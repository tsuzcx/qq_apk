//var self = __TT__GLOBAL__;
//var global = __TT__GLOBAL__;
//var window = __TT__GLOBAL__;
(function(global, tt){
  global.setTimeout = function(fn, delay) {
    delay = delay || 0;
    // JSBMessageQueue.cpp
    return tt.Triton.MessageQueue.setTimeout(fn, delay);
  };

  global.clearTimeout = function(id) {
    tt.Triton.MessageQueue.removeTimeout(id);
  };

  global.setInterval = function(fn, delay) {
    delay = delay || 0;
    let idHolder = {};
    let routine = function () {
      idHolder.id = tt.Triton.MessageQueue.setTimeout(routine, delay);
      fn();
    };

    idHolder.id = tt.Triton.MessageQueue.setTimeout(routine, delay);
    return idHolder;
  };

  global.clearInterval = function(idHolder) {
    if (idHolder && typeof idHolder.id === 'number') {
      tt.Triton.MessageQueue.removeTimeout(idHolder.id);
    }
  };

}(this, this.__ttObjdec__));