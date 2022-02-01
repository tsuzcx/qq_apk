package com.tencent.mm.plugin.webview.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/webcompt/Key;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "PKG_SCRIPT_FROM_ASSESTS", "PKG_SCRIPT_FROM_PACKAGE", "APP_SCRIPT_FROM_CACHE", "APP_SCRIPT_FROM_NETWORK", "EX_PKG_SCRIPT_FROM_ASSESTS", "EX_PKG_SCRIPT_FROM_PACKAGE", "APP_SCRIPT_DOWNLOAD", "APP_SCRIPT_DOWNLOAD_ERR", "APP_SCRIPT_MD5_INVALID", "EX_APP_SCRIPT", "AUTH_FROM_CONFIG", "AUTH_FROM_SVR", "AUTH_SUCC", "AUTH_INVALID", "AUTH_ERR", "AUTH_WITH_APP_CHANGE", "AUTH_WITH_FIRST_TIME", "REAUTH", "EVAL_MAIN_FRAME", "EVAL_MAIN_FRAME_ERR", "CREATE_JS_CONTEXT", "CREATE_JS_CONTEXT_ERR", "GET_TAGS_SUCC", "GET_TAGS_ERR", "PRELOAD_JS_CONTEXT", "PRELOAD_JS_CONTEXT_USE", "GET_A8KEY", "GET_A8KEY_SUCC", "GET_A8KEY_ERR", "LOAD_APP_SCRIPT", "LOAD_APP_SCRIPT_SUCC", "LOAD_APP_SCRIPT_ERR", "EX_JS_CONTEXT", "IFRAME_INTERCEPT", "IFRAME_INTERCEPT_SUCC", "IFRAME_INTERCEPT_ERR", "SEND_TO_JS_CONTEXT", "SEND_TO_MAIN_FRAME", "REQUEST_CGI", "REQUEST_CGI_ERR", "REQUEST_JS_ERR_REPORT", "REQUEST_JS_ERR_REPORT_ERR", "SEND_EVENT_TO_JS_CONTEXT", "PARSE_RES_VERSION_ERR", "RECYCLE_JS_CXT", "RECYCLE_JS_CXT_USE", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum b
{
  final int value;
  
  static
  {
    AppMethodBeat.i(82771);
    XtQ = new b("PKG_SCRIPT_FROM_ASSESTS", 0, 40);
    XtR = new b("PKG_SCRIPT_FROM_PACKAGE", 1, 41);
    XtS = new b("APP_SCRIPT_FROM_CACHE", 2, 42);
    XtT = new b("APP_SCRIPT_FROM_NETWORK", 3, 43);
    XtU = new b("EX_PKG_SCRIPT_FROM_ASSESTS", 4, 44);
    XtV = new b("EX_PKG_SCRIPT_FROM_PACKAGE", 5, 45);
    XtW = new b("APP_SCRIPT_DOWNLOAD", 6, 46);
    XtX = new b("APP_SCRIPT_DOWNLOAD_ERR", 7, 47);
    XtY = new b("APP_SCRIPT_MD5_INVALID", 8, 48);
    XtZ = new b("EX_APP_SCRIPT", 9, 49);
    Xua = new b("AUTH_FROM_CONFIG", 10, 50);
    Xub = new b("AUTH_FROM_SVR", 11, 51);
    Xuc = new b("AUTH_SUCC", 12, 52);
    Xud = new b("AUTH_INVALID", 13, 53);
    Xue = new b("AUTH_ERR", 14, 54);
    Xuf = new b("AUTH_WITH_APP_CHANGE", 15, 55);
    Xug = new b("AUTH_WITH_FIRST_TIME", 16, 56);
    Xuh = new b("REAUTH", 17, 57);
    Xui = new b("EVAL_MAIN_FRAME", 18, 60);
    Xuj = new b("EVAL_MAIN_FRAME_ERR", 19, 61);
    Xuk = new b("CREATE_JS_CONTEXT", 20, 62);
    Xul = new b("CREATE_JS_CONTEXT_ERR", 21, 63);
    Xum = new b("GET_TAGS_SUCC", 22, 64);
    Xun = new b("GET_TAGS_ERR", 23, 65);
    Xuo = new b("PRELOAD_JS_CONTEXT", 24, 66);
    Xup = new b("PRELOAD_JS_CONTEXT_USE", 25, 67);
    Xuq = new b("GET_A8KEY", 26, 70);
    Xur = new b("GET_A8KEY_SUCC", 27, 71);
    Xus = new b("GET_A8KEY_ERR", 28, 72);
    Xut = new b("LOAD_APP_SCRIPT", 29, 73);
    Xuu = new b("LOAD_APP_SCRIPT_SUCC", 30, 74);
    Xuv = new b("LOAD_APP_SCRIPT_ERR", 31, 75);
    Xuw = new b("EX_JS_CONTEXT", 32, 80);
    Xux = new b("IFRAME_INTERCEPT", 33, 81);
    Xuy = new b("IFRAME_INTERCEPT_SUCC", 34, 83);
    Xuz = new b("IFRAME_INTERCEPT_ERR", 35, 84);
    XuA = new b("SEND_TO_JS_CONTEXT", 36, 85);
    XuB = new b("SEND_TO_MAIN_FRAME", 37, 86);
    XuC = new b("REQUEST_CGI", 38, 87);
    XuD = new b("REQUEST_CGI_ERR", 39, 88);
    XuE = new b("REQUEST_JS_ERR_REPORT", 40, 90);
    XuF = new b("REQUEST_JS_ERR_REPORT_ERR", 41, 91);
    XuG = new b("SEND_EVENT_TO_JS_CONTEXT", 42, 92);
    XuH = new b("PARSE_RES_VERSION_ERR", 43, 93);
    XuI = new b("RECYCLE_JS_CXT", 44, 100);
    XuJ = new b("RECYCLE_JS_CXT_USE", 45, 101);
    XuK = new b[] { XtQ, XtR, XtS, XtT, XtU, XtV, XtW, XtX, XtY, XtZ, Xua, Xub, Xuc, Xud, Xue, Xuf, Xug, Xuh, Xui, Xuj, Xuk, Xul, Xum, Xun, Xuo, Xup, Xuq, Xur, Xus, Xut, Xuu, Xuv, Xuw, Xux, Xuy, Xuz, XuA, XuB, XuC, XuD, XuE, XuF, XuG, XuH, XuI, XuJ };
    AppMethodBeat.o(82771);
  }
  
  private b(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.b
 * JD-Core Version:    0.7.0.1
 */