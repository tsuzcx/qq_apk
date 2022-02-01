package com.tencent.mm.plugin.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/WebTransTipsStatus;", "", "(Ljava/lang/String;I)V", "Hide", "DoingTrans", "DoneTrans", "NoNeedTrans", "plugin-webview_release"})
public enum o
{
  static
  {
    AppMethodBeat.i(220583);
    o localo1 = new o("Hide", 0);
    PEU = localo1;
    o localo2 = new o("DoingTrans", 1);
    PEV = localo2;
    o localo3 = new o("DoneTrans", 2);
    PEW = localo3;
    o localo4 = new o("NoNeedTrans", 3);
    PEX = localo4;
    PEY = new o[] { localo1, localo2, localo3, localo4 };
    AppMethodBeat.o(220583);
  }
  
  private o() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.o
 * JD-Core Version:    0.7.0.1
 */