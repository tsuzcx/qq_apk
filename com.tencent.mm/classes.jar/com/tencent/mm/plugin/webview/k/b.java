package com.tencent.mm.plugin.webview.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/webcompt/Key;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "PKG_SCRIPT_FROM_ASSESTS", "PKG_SCRIPT_FROM_PACKAGE", "APP_SCRIPT_FROM_CACHE", "APP_SCRIPT_FROM_NETWORK", "EX_PKG_SCRIPT_FROM_ASSESTS", "EX_PKG_SCRIPT_FROM_PACKAGE", "APP_SCRIPT_DOWNLOAD", "APP_SCRIPT_DOWNLOAD_ERR", "APP_SCRIPT_MD5_INVALID", "EX_APP_SCRIPT", "AUTH_FROM_CONFIG", "AUTH_FROM_SVR", "AUTH_SUCC", "AUTH_INVALID", "AUTH_ERR", "AUTH_WITH_APP_CHANGE", "AUTH_WITH_FIRST_TIME", "REAUTH", "EVAL_MAIN_FRAME", "EVAL_MAIN_FRAME_ERR", "CREATE_JS_CONTEXT", "CREATE_JS_CONTEXT_ERR", "GET_TAGS_SUCC", "GET_TAGS_ERR", "PRELOAD_JS_CONTEXT", "PRELOAD_JS_CONTEXT_USE", "GET_A8KEY", "GET_A8KEY_SUCC", "GET_A8KEY_ERR", "LOAD_APP_SCRIPT", "LOAD_APP_SCRIPT_SUCC", "LOAD_APP_SCRIPT_ERR", "EX_JS_CONTEXT", "IFRAME_INTERCEPT", "IFRAME_INTERCEPT_SUCC", "IFRAME_INTERCEPT_ERR", "SEND_TO_JS_CONTEXT", "SEND_TO_MAIN_FRAME", "REQUEST_CGI", "REQUEST_CGI_ERR", "REQUEST_JS_ERR_REPORT", "REQUEST_JS_ERR_REPORT_ERR", "SEND_EVENT_TO_JS_CONTEXT", "PARSE_RES_VERSION_ERR", "RECYCLE_JS_CXT", "RECYCLE_JS_CXT_USE", "webview-sdk_release"})
public enum b
{
  final int value;
  
  static
  {
    AppMethodBeat.i(82771);
    b localb1 = new b("PKG_SCRIPT_FROM_ASSESTS", 0, 40);
    CPG = localb1;
    b localb2 = new b("PKG_SCRIPT_FROM_PACKAGE", 1, 41);
    CPH = localb2;
    b localb3 = new b("APP_SCRIPT_FROM_CACHE", 2, 42);
    CPI = localb3;
    b localb4 = new b("APP_SCRIPT_FROM_NETWORK", 3, 43);
    CPJ = localb4;
    b localb5 = new b("EX_PKG_SCRIPT_FROM_ASSESTS", 4, 44);
    CPK = localb5;
    b localb6 = new b("EX_PKG_SCRIPT_FROM_PACKAGE", 5, 45);
    CPL = localb6;
    b localb7 = new b("APP_SCRIPT_DOWNLOAD", 6, 46);
    CPM = localb7;
    b localb8 = new b("APP_SCRIPT_DOWNLOAD_ERR", 7, 47);
    CPN = localb8;
    b localb9 = new b("APP_SCRIPT_MD5_INVALID", 8, 48);
    CPO = localb9;
    b localb10 = new b("EX_APP_SCRIPT", 9, 49);
    CPP = localb10;
    b localb11 = new b("AUTH_FROM_CONFIG", 10, 50);
    CPQ = localb11;
    b localb12 = new b("AUTH_FROM_SVR", 11, 51);
    CPR = localb12;
    b localb13 = new b("AUTH_SUCC", 12, 52);
    CPS = localb13;
    b localb14 = new b("AUTH_INVALID", 13, 53);
    CPT = localb14;
    b localb15 = new b("AUTH_ERR", 14, 54);
    CPU = localb15;
    b localb16 = new b("AUTH_WITH_APP_CHANGE", 15, 55);
    CPV = localb16;
    b localb17 = new b("AUTH_WITH_FIRST_TIME", 16, 56);
    CPW = localb17;
    b localb18 = new b("REAUTH", 17, 57);
    CPX = localb18;
    b localb19 = new b("EVAL_MAIN_FRAME", 18, 60);
    CPY = localb19;
    b localb20 = new b("EVAL_MAIN_FRAME_ERR", 19, 61);
    CPZ = localb20;
    b localb21 = new b("CREATE_JS_CONTEXT", 20, 62);
    CQa = localb21;
    b localb22 = new b("CREATE_JS_CONTEXT_ERR", 21, 63);
    CQb = localb22;
    b localb23 = new b("GET_TAGS_SUCC", 22, 64);
    CQc = localb23;
    b localb24 = new b("GET_TAGS_ERR", 23, 65);
    CQd = localb24;
    b localb25 = new b("PRELOAD_JS_CONTEXT", 24, 66);
    CQe = localb25;
    b localb26 = new b("PRELOAD_JS_CONTEXT_USE", 25, 67);
    CQf = localb26;
    b localb27 = new b("GET_A8KEY", 26, 70);
    CQg = localb27;
    b localb28 = new b("GET_A8KEY_SUCC", 27, 71);
    CQh = localb28;
    b localb29 = new b("GET_A8KEY_ERR", 28, 72);
    CQi = localb29;
    b localb30 = new b("LOAD_APP_SCRIPT", 29, 73);
    CQj = localb30;
    b localb31 = new b("LOAD_APP_SCRIPT_SUCC", 30, 74);
    CQk = localb31;
    b localb32 = new b("LOAD_APP_SCRIPT_ERR", 31, 75);
    CQl = localb32;
    b localb33 = new b("EX_JS_CONTEXT", 32, 80);
    CQm = localb33;
    b localb34 = new b("IFRAME_INTERCEPT", 33, 81);
    CQn = localb34;
    b localb35 = new b("IFRAME_INTERCEPT_SUCC", 34, 83);
    CQo = localb35;
    b localb36 = new b("IFRAME_INTERCEPT_ERR", 35, 84);
    CQp = localb36;
    b localb37 = new b("SEND_TO_JS_CONTEXT", 36, 85);
    CQq = localb37;
    b localb38 = new b("SEND_TO_MAIN_FRAME", 37, 86);
    CQr = localb38;
    b localb39 = new b("REQUEST_CGI", 38, 87);
    CQs = localb39;
    b localb40 = new b("REQUEST_CGI_ERR", 39, 88);
    CQt = localb40;
    b localb41 = new b("REQUEST_JS_ERR_REPORT", 40, 90);
    CQu = localb41;
    b localb42 = new b("REQUEST_JS_ERR_REPORT_ERR", 41, 91);
    CQv = localb42;
    b localb43 = new b("SEND_EVENT_TO_JS_CONTEXT", 42, 92);
    CQw = localb43;
    b localb44 = new b("PARSE_RES_VERSION_ERR", 43, 93);
    Hah = localb44;
    b localb45 = new b("RECYCLE_JS_CXT", 44, 100);
    CQx = localb45;
    b localb46 = new b("RECYCLE_JS_CXT_USE", 45, 101);
    CQy = localb46;
    CQz = new b[] { localb1, localb2, localb3, localb4, localb5, localb6, localb7, localb8, localb9, localb10, localb11, localb12, localb13, localb14, localb15, localb16, localb17, localb18, localb19, localb20, localb21, localb22, localb23, localb24, localb25, localb26, localb27, localb28, localb29, localb30, localb31, localb32, localb33, localb34, localb35, localb36, localb37, localb38, localb39, localb40, localb41, localb42, localb43, localb44, localb45, localb46 };
    AppMethodBeat.o(82771);
  }
  
  private b(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.b
 * JD-Core Version:    0.7.0.1
 */