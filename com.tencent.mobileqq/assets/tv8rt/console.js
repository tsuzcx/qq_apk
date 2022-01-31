/*globals TT, window*/
//var self = __TT__GLOBAL__;
//var global = __TT__GLOBAL__;
//var window = __TT__GLOBAL__;
//var GameGlobal = __TT__GLOBAL__;
//var tt = global.__ttObjdec__;

//var _notifcationCenter;

//console.log支持可变参数
//1. 单参数调用
//console.log( "directly call log");
//2. 多参数调用
//console.log.apply(console, ["arg1", "arg2"]);
//300,301,302,303 是native定义的
(function (global, tt) {
tt.logInterface = function(type, args){
                try {
                    //arguments参数是个伪数组，通过 Array.prototype.slice.call 转化为标准数组
//                    var args = Array.prototype.slice.call(arguments);
                    if (args.length > 0) {
                        var msg = args.map(
                            function(e) {
                                try {
                                    return typeof e == 'string' ? e : JSON.stringify(e);
                                } catch(error) {
                                    return e;
                                }
                            }).join(' ');
                        tt.Triton.Script.log(type, 0, msg);
                    } else {
                        tt.Triton.Script.log(type, 0, "no args log");
                    }
                } catch (err) {
                    tt.Triton.Script.log(103, 0, "tt.Triton.Script.logInterface error! err =" + err);
                }
};

global.console = {}
console.log = function(){
    var args = Array.prototype.slice.call(arguments);
    tt.logInterface(101, args);
};
console.info = console.log;
console.error = function(){
    var args = Array.prototype.slice.call(arguments);
    tt.logInterface(103, args);
};
console.warn = function(){
    var args = Array.prototype.slice.call(arguments);
    tt.logInterface(102, args);
};
console.debug = function(){
    var args = Array.prototype.slice.call(arguments);
    tt.logInterface(100, args);
};

console.group = console.log
console.groupEnd = function() { };
})(this, this.__ttObjdec__);
//window.console = console;

