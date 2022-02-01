var WeixinJSBridge = (function(global) {
  if (typeof global.WeixinJSBridge !== 'undefined') {
    return global.WeixinJSBridge
  }

  var isWebView = global.hasOwnProperty('document');
  var isIosWebView = false;

  var invokeCallbacks = {};
  var invokeCallbackId = 0;

  var onCallbacks = {};

  if (isWebView) {
    var userAgent = global.navigator.userAgent;
    var isAndroidWebView = userAgent.indexOf('Android') != -1;
    isIosWebView = !isAndroidWebView;
  }

  var _WeixinJSCore = global.WeixinJSCore
  delete global.WeixinJSCore

  var _invokeHandler = function(event, paramsString, callbackId) {
    var result = _WeixinJSCore.invokeHandler(event, paramsString, callbackId);
    if (typeof result !== 'undefined' && typeof invokeCallbacks[callbackId] === 'function' && result !== '') {
      try {
        result = JSON.parse(result)
      } catch (e) {
        console.error('invokeHandler result parse failed ' + result)
        result = {}
      }
      invokeCallbacks[callbackId](result)
      delete invokeCallbacks[callbackId]
    }
  }

  var invoke = function(event, params, callback) {
    var paramsString = JSON.stringify(params || {});
    var callbackId = ++invokeCallbackId
    invokeCallbacks[callbackId] = callback;
    _invokeHandler(event, paramsString, callbackId);
  }

  var _invokeCallbackHandler = function(callbackId, result) {
    var callback = invokeCallbacks[callbackId];
    if (typeof callback == 'function') {
      callback(result);
    }
    delete invokeCallbacks[callbackId];
  }

  var on = function(event, callback) {
    onCallbacks[event] = callback;
  }

  var _subscribeHandler = function(event, result) {
    var callback = onCallbacks[event];
    if (typeof callback == 'function') {
      callback(result);
    }
  }

  var vsprintf = function (fmt, argv) {
    argv.unshift(fmt);
    return sprintf.apply(null, argv);
  };

  var _session_data = {}

  function log(fmt) {
    var curFuncIdentifier = global.WeixinJSBridge.log;
    if (curFuncIdentifier !== _logIdentifier) {
      return;
    }
    var argv = [];
    for (var i = 0; i < arguments.length; i++) {
      argv.push(arguments[i]);
    };
    var fm = argv.shift();
    var msg;
    try {
      msg = vsprintf(fm, argv);
    } catch (e) {
      msg = fmt;
    }
    invoke('log', {
      'msg': msg
    });
  }
  var _logIdentifier = log;

  function env(key) {
    var curFuncIdentifier = global.WeixinJSBridge.env;
    if (curFuncIdentifier !== _envIdentifier) {
      return '';
    }
    return _session_data[key];
  }
  var _envIdentifier = env;

  // the first event
  on('sys:init', function (ses) {
    // 避免由于Java层多次发起init请求，造成网页端多次收到WeixinJSBridgeReady事件
    if (global.WeixinJSBridge._hasInit) {
      log('hasInit, no need to init again');
      return;
    }

    global.WeixinJSBridge._hasInit = true;

    // bridge ready
    var readyEvent;
    try {
      readyEvent = new Event('WeixinJSBridgeReady');
    } catch (e) {
      readyEvent = document.createEvent('Event');
      readyEvent.initEvent('WeixinJSBridgeReady');
    }
    document.dispatchEvent(readyEvent);
  });

  return {
    invoke: invoke,
    call: invoke,
    on: on,
    log: log,
    env: env,
    _hasInit: false,
    // java 2 js
    subscribeHandler: _subscribeHandler,
    invokeCallbackHandler: _invokeCallbackHandler
  }
}) (this);