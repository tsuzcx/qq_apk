onAudioPlayStop = function (fileName, md5) {
    var elmts = document.getElementsByName(fileName);
    if(isUnvalid(elmts)) {
       elmts = document.getElementsByClassName("audio-wrapper");
    }
    for (i = 0; i < elmts.length; ++i) {
        var item = elmts[i];
        var itemMd5 = item.getAttribute('md5');
        var category = item.getAttribute('category');

        if (item == undefined || itemMd5 == undefined || itemMd5 == "" || itemMd5 != md5) {
            continue;
        }
        var playbtns = item.getElementsByClassName('play-btn');
        if (playbtns == undefined || playbtns == null || playbtns.length == 0) {
            continue;
        }
        ignoreChange(true);
        var playbtn = playbtns[0];
        if (playbtn.className != undefined && playbtn.className.indexOf('playing') > 0) {
            playbtn.className = 'play-btn vertical-center';
            if (category == 2) { // 语音
                playbtn.style.backgroundImage = "url(https://static-res.qq.com/static-res/favorite/qfav_audio_play.png)";
                updateWare(item, true);

            } else {  // 录音
                playbtn.style.backgroundImage = "url(https://static-res.qq.com/static-res/favorite/qfav_ptt_play.png)";
            }
        }
        var progress = getAudioProgress(item);
        if (progress > 0.9) {
            updateAudioProgress(item, 0, 1);
        }
        ignoreChange(false);
        break;
    }
}

updateAudioProgress = function (audioElem, curTime, duration) {
    if (audioElem == undefined || audioElem == null) {
        return;
    }
    var dots = audioElem.getElementsByClassName('progressDot');
    if (isUnvalid(dots)) {
        return;
    }
    var dot = dots[0];

    var bars = audioElem.getElementsByClassName('progress-bar');
    if (isUnvalid(bars)) {
        return;
    }
    var bar = bars[0];

    var times = audioElem.getElementsByClassName('audio-length-current');
    if (isUnvalid(times)) {
        return;
    }
    ignoreChange(true);
    var curTimeItem = times[0];
    var position = curTime * 100.0 / duration;
    bar.style.width = position + '%';
    dot.style.left = position + '%';
    curTimeItem.innerText = transTime(curTime / 1000);
    ignoreChange(false);
}

stopAllAudio = function () {
    var playbtns = document.getElementsByClassName('play-btn');
    if (playbtns == undefined || playbtns == null) {
        return;
    }
    for (var i = 0; i < playbtns.length; i++) {
        var playbtn = playbtns[i];
        var audioTag = playbtn.parentElement;
        if (audioTag == undefined || audioTag == null) {
            return;
        }
        var category = audioTag.getAttribute("category");
        if (category == undefined) {
            category = audioTag.parentElement.getAttribute("category");
        }
        ignoreChange(true);
        if (isPlaying(playbtn)) {
            playbtn.className = 'play-btn vertical-center';
            if (category == 2) { // 语音
                playbtn.style.backgroundImage = "url(https://static-res.qq.com/static-res/favorite/qfav_audio_play.png)";
                updateWare(item, true);

            } else {  // 录音
                playbtn.style.backgroundImage = "url(https://static-res.qq.com/static-res/favorite/qfav_ptt_play.png)";
            }
        }
        ignoreChange(false);
    }
    resetAllAudioProcess();
}

resetAllAudioProcess = function () {
    ignoreChange(true);
    var dots = document.getElementsByClassName('progressDot');
    if (dots == undefined || dots == null) {
        return;
    }
    var i = 0;
    for (; i < dots.length; i++) {
        var dot = dots[i];
        dot.style.left = '0';
    }

    var bars = document.getElementsByClassName('progress-bar');
    if (bars == undefined || bars == null) {
        return;
    }
    for (i = 0; i < bars.length; i++) {
        var bar = bars[i];
        bar.style.width = '0';
    }

    var times = document.getElementsByClassName('audio-length-current');
    if (times == undefined || times == null) {
        return;
    }
    for (i = 0; i < times.length; i++) {
        var curTimeItem = times[i];
        curTimeItem.innerText = '00:00';
    }
    ignoreChange(false);
}

/**
 * 音频播放时间换算
 * @param {number} value - 音频当前播放时间，单位秒
 */
function transTime(value) {
    var time = "";
    var h = Math.floor(value / 3600);
    value %= 3600;
    var m = Math.floor(value / 60);
    var s = Math.round(value % 60);
    if (h > 0) {
        time = formatTime(h + ":" + m + ":" + s);
    } else {
        time = formatTime(m + ":" + s);
    }

    return time;
}

/**
 * 格式化时间显示，补零对齐
 * eg：2:4  -->  02:04
 * @param {string} value - 形如 h:m:s 的字符串
 */
function formatTime(value) {
    var time = "";
    var s = value.split(':');
    var i = 0;
    for (; i < s.length - 1; i++) {
        time += s[i].length == 1 ? ("0" + s[i]) : s[i];
        time += ":";
    }
    time += s[i].length == 1 ? ("0" + s[i]) : s[i];

    return time;
}

function refreshAudioWare() {
    var wares = document.getElementsByClassName('palette');
    if (wares == undefined || wares == null) {
        return;
    }
    var i = 0;
    for (; i < wares.length; i++) {

        var ware = wares[i];
        var parent = ware.parentElement;
        var playbtns = parent.getElementsByClassName('play-btn');
        if (isUnvalid(playbtns)) {
            continue;
        }
        var times = parent.getElementsByClassName('audio-length-total');
        if (isUnvalid(times)) {
            continue;
        }
        ware.style.width = times[0].offsetLeft - playbtns[0].offsetLeft - playbtns[0].offsetWidth - 6;
        ware.innerHTML = "";
        var itemCount = (ware.clientWidth + 2) / 6;
        var itemHtml = '';
        for (var j = 0; j < itemCount; j++) {
            itemHtml += '<div></div>';
        }
        ware.innerHTML = itemHtml;
    }
}

function init(night) {
    refreshAudioWare();
    initAudioEvents();
    updateTheme(night);
}

function initAudioEvents() {
    var bars = document.getElementsByClassName('progress-bar-bg');
    if (isUnvalid(bars)) {
        return;
    }
    var position = {
        oriOffestLeft: 0, // 移动开始时进度条的点距离进度条的偏移值
        oriX: 0, // 移动开始时的x坐标
        maxLeft: 0, // 向左最大可拖动距离
        maxRight: 0, // 向右最大可拖动距离
        target: null
    };
    for (var i = 0; i < bars.length; i++) {
        var bar = bars[i];
        initBarEvent(bar);
    }

    var dots = document.getElementsByClassName('progressDot');
    if (isUnvalid(dots)) {
        return;
    }
    for (var i = 0; i < dots.length; i++) {
        var dot = dots[i];
        dot.removeEventListener('mousedown', onDotDown);
        dot.removeEventListener('touchstart', onDotDown);
        dot.addEventListener('mousedown', onDotDown, false);
        dot.addEventListener('touchstart', onDotDown, false);
    }

    // 开始拖动
    document.removeEventListener('mousemove', move);
    document.removeEventListener('touchmove', move);
    document.addEventListener('mousemove', move, false);
    document.addEventListener('touchmove', move, false);
    // 拖动结束
    document.removeEventListener('mouseup', end);
    document.removeEventListener('touchend', end);
    document.addEventListener('mouseup', end, false);
    document.addEventListener('touchend', end, false);

    function onDotDown(event) {
        var dot = event.target;
        if (dot == undefined || dot == null || dot.className == undefined || dot.className.indexOf('progressDot') < 0) {
            return;
        }
        var audioTag = dot.parentElement.parentElement;
        if (audioTag == undefined || audioTag == null) {
            return;
        }
        var playbtns = audioTag.getElementsByClassName('play-btn');
        if (isUnvalid(playbtns)) {
            return;
        }
        updateDragFlag(true);
        position.oriOffestLeft = dot.offsetLeft;
        position.oriX = event.touches ? event.touches[0].clientX : event.clientX; // 要同时适配mousedown和touchstart事件
        position.maxLeft = position.oriOffestLeft; // 向左最大可拖动距离
        position.target = dot;
        var barParent = dot.parentElement;
        if (barParent == undefined || barParent == null) {
            return;
        }
        position.maxRight = barParent.offsetWidth - position.oriOffestLeft; // 向右最大可拖动距离
        // 禁止事件冒泡
        if (event && event.stopPropagation) {
            event.stopPropagation();
        } else {
            window.event.cancelBubble = true;
        }

        var audioTag = dot.parentElement.parentElement;
        if (audioTag == undefined || audioTag == null) {
            return;
        }
        var fid = audioTag.getAttribute("fid");
        var md5 = audioTag.getAttribute('md5');
        var fileName = audioTag.getAttribute('name');
        var duration = audioTag.getAttribute('duration');
        var progress = getAudioProgress(audioTag);
        progress = progress * duration;
        if(isPlaying(playbtns[0])) {
             playAudio(fid, fileName);
        }
    }

    function move(event) {
        if (document.dragflag == true) {
            var dot = position.target;
            if (dot == undefined || dot == null || dot.className == undefined || dot.className.indexOf('progressDot') < 0) {
                return;
            }
            var audioTag = dot.parentElement.parentElement;
            if (audioTag == undefined || audioTag == null) {
                return;
            }
            var clientX = event.touches ? event.touches[0].clientX : event.clientX; // 要同时适配mousemove和touchmove事件
            var length = clientX - position.oriX;
            if (length > position.maxRight) {
                length = position.maxRight;
            } else if (length < -position.maxLeft) {
                length = -position.maxLeft;
            }
            var barParent = dot.parentElement;
            if (barParent == undefined || barParent == null) {
                return;
            }
            var pgsWidth = parseFloat(window.getComputedStyle(barParent, null).width.replace('px', ''));
            var rate = (position.oriOffestLeft + length) / pgsWidth;
            var duration = audioTag.getAttribute("duration");
            if (duration == undefined || duration == 0) {
                return;
            }
            var currentTime = duration * rate;
            updateAudioProgress(audioTag, currentTime, duration);
        }
    }

    function end() {
        if (document.dragflag == true) {
            updateDragFlag(false);
            var dot = position.target;
            if (dot == undefined || dot == null || dot.className == undefined || dot.className.indexOf('progressDot') < 0) {
                return;
            }
            var audioTag = dot.parentElement.parentElement;
            if (audioTag == undefined || audioTag == null) {
                return;
            }
            var fid = audioTag.getAttribute("fid");
            var md5 = audioTag.getAttribute('md5');
            var fileName = audioTag.getAttribute('name');
            var duration = audioTag.getAttribute('duration');
            var progress = getAudioProgress(audioTag);
            progress = progress * duration;
            // notifyPlayAudio(fid, fileName, md5, true, progress);
            var playbtns = audioTag.getElementsByClassName('play-btn');
            if(isUnvalid(playbtns)) {
              return;
            }
            if(!isPlaying(playbtns[0])) {
                playAudio(fid, fileName);
            }
        }

    }
}

function notifyPlayAudio(fid, fileName, md5, play, progress) {
}


function isPlaying(playbtn) {
    if (isUnvalid(playbtn)) {
        return false;
    }
    return playbtn.className.indexOf('playing') > 0;
}

function initBarEvent(barBg) {
    if (isUnvalid(barBg)) {
        return;
    }
    barBg.removeEventListener('mousedown', onBarDown);
    barBg.addEventListener('mousedown', onBarDown, false);

    function onBarDown(event) {
        var audioTag = barBg.parentElement;
        if (audioTag == undefined || audioTag == null) {
            return;
        }
        var playbtns = audioTag.getElementsByClassName('play-btn');
        if (isUnvalid(playbtns)) {
            return;
        }
        if (isPlaying(playbtns[0])) {
            var pgsWidth = parseFloat(window.getComputedStyle(barBg, null).width.replace('px', ''));
            var rate = event.offsetX / pgsWidth;

            var duration = audioTag.getAttribute("duration");
            if (duration == undefined || duration == 0) {
                return;
            }
            var currentTime = duration * rate;

            updateAudioProgress(audioTag, currentTime, duration);
            var fid = audioTag.getAttribute("fid");
            var md5 = audioTag.getAttribute('md5');
            var fileName = audioTag.getAttribute('name');
            var progress = getAudioProgress(audioTag);
            progress = progress * duration;
            notifyPlayAudio(fid, fileName, md5, true, progress);
        }
    }
}

function isUnvalid(elem) {
    return elem == undefined || elem == null || elem.length == 0;
}

function getAudioProgress(audioTag) {
    if (isUnvalid(audioTag)) {
        return 0;
    }
    var barBgs = audioTag.getElementsByClassName('progress-bar-bg');
    if (isUnvalid(barBgs)) {
        return 0;
    }
    var bars = audioTag.getElementsByClassName('progress-bar');
    if (isUnvalid(bars)) {
        return 0;
    }
    var bgWidth = parseFloat(window.getComputedStyle(barBgs[0], null).width.replace('px', ''));
    var barWidth = parseFloat(window.getComputedStyle(bars[0], null).width.replace('px', ''));
    if (bgWidth == 0) {
        return 0;
    }
    return barWidth * 1.0 / bgWidth;
}

function getRootPath() {
    return "";
}

onProgressChanged = function (fileName, md5, curTime, duration) {
    var elmts = document.getElementsByName(fileName);
    if(isUnvalid(elmts)) {
      elmts = document.getElementsByClassName("audio-wrapper");
    }
    for (i = 0; i < elmts.length; ++i) {
        var item = elmts[i];
        var itemMd5 = item.getAttribute('md5');
        if (item == undefined || itemMd5 == undefined || itemMd5 == "" || itemMd5 != md5) {
            continue;
        }
        updateAudioProgress(item, curTime, duration);
        break;
    }
}


updateWare = function (parent, stop) {
    if (parent == undefined || parent == null) {
        parent = document;
    }
    var wares = parent.getElementsByClassName('palette');
    if (wares == undefined || wares == null || wares.length == 0) {
        return;
    }
    for (var i = 0; i < wares.length; i++) {
        var ware = wares[i];
        ware.className = 'palette';
        if (stop) {
            ware.className = 'palette';
        } else {
            ware.className = 'palette play';
        }
    }
}

updateDragFlag = function (dragflag) {
    document.dragflag = dragflag;
    notifyPreventFinish(dragflag);
}

notifyPreventFinish = function (prevent) {

}

openFile = function (file) {

}

ignoreChange = function (ignore) {
}

function updateTheme(night) {
  var editor = document.getElementById("QMEditor");
  if(editor != undefined && editor != null) {
    if(night) {
      editor.className = "night";
      document.body.style.setProperty("background","#282828");
    }
  }

}