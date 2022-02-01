

playAudio = function (fid, fileName) {
    // 目前设定名字不会重
    var elmts = document.getElementsByName(fileName);
    for (i = 0; i < elmts.length; ++i) {
        var item = elmts[i];
        var fid = item.getAttribute("fid");
        var md5 = item.getAttribute('md5');
        var category = item.getAttribute('category');
        if (item == undefined || (fid == undefined || fid == "") && (md5 == undefined || md5 == "")) {
            continue;
        }
        var playbtns = item.getElementsByClassName('play-btn');
        if (playbtns == undefined || playbtns == null || playbtns.length == 0) {
            continue;
        }
        var playbtn = playbtns[0];
        var progress = getAudioProgress(item);
        var duration = item.getAttribute('duration');
        if (duration != undefined) {
            progress = Math.floor(progress * duration);
        }
        if (playbtn.className != undefined && (playbtn.className.indexOf('playing') > 0)) {
            playbtn.className = 'play-btn vertical-center pause';
            // 暂停
            if (category == 2) { // 语音
                playbtn.style.backgroundImage = "url(https://static-res.qq.com/static-res/favorite/qfav_audio_play.png)";
                updateWare(item, true);;

            } else {  // 录音
                playbtn.style.backgroundImage = "url(https://static-res.qq.com/static-res/favorite/qfav_ptt_play.png)";
            }
            window.imagelistner.playAudio(fid, fileName, md5, false, progress);


        } else {
            stopAllAudio();
            playbtn.className = 'play-btn vertical-center playing';
            // 播放
            if (category == 2) { // 语音
                playbtn.style.backgroundImage = "url(https://static-res.qq.com/static-res/favorite/qfav_audio_pause.png)";
                updateWare(item, false);

            } else {  // 录音
                playbtn.style.backgroundImage = "url(https://static-res.qq.com/static-res/favorite/qfav_ptt_pause.png)";
            }
            window.imagelistner.playAudio(fid, fileName, md5, true, progress);
        }
        break;
    }
}

function getRootPath() {
    return "file:///android_asset/qfav_editor/";
}

function notifyPlayAudio(fid, fileName, md5, play, progress) {
    window.imagelistner.playAudio(fid, fileName, md5, true, progress);
}

function notifyPreventFinish(prevent) {
    window.imagelistner.updatePreventFinishFlag(prevent);
}

function openFile(file) {
    if (file == undefined || file == null) {
        return;
    }

    var fid = file.getAttribute('fid');
    var path = file.getAttribute('path');
    if (fid == undefined && path == null) {
        return;
    }
    if (path == undefined) {
        path = "";
    }
    window.imagelistner.openFile(fid, path);
}


function openLocation(locationDiv) {
    if (locationDiv == undefined || locationDiv == null) {
        return;
    }
    var lat = locationDiv.getAttribute("lat");
    var lon = locationDiv.getAttribute("lon");
    var title = locationDiv.getAttribute("title");
    var address = locationDiv.getAttribute("summary");
    window.imagelistner.openLocation(lat, lon, title, address);
}
