package com.tencent.mm.plugin.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/WebTransCheckResult;", "", "(Ljava/lang/String;I)V", "Unknown", "NeedTrans", "NoNeedTrans", "NotSure", "BadNet", "plugin-webview_release"})
public enum e
{
  static
  {
    AppMethodBeat.i(215123);
    e locale1 = new e("Unknown", 0);
    PDQ = locale1;
    e locale2 = new e("NeedTrans", 1);
    PDR = locale2;
    e locale3 = new e("NoNeedTrans", 2);
    PDS = locale3;
    e locale4 = new e("NotSure", 3);
    PDT = locale4;
    e locale5 = new e("BadNet", 4);
    PDU = locale5;
    PDV = new e[] { locale1, locale2, locale3, locale4, locale5 };
    AppMethodBeat.o(215123);
  }
  
  private e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e
 * JD-Core Version:    0.7.0.1
 */