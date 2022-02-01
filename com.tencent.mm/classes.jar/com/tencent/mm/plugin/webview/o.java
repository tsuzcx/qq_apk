package com.tencent.mm.plugin.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/WebTransTipsStatus;", "", "(Ljava/lang/String;I)V", "Hide", "DoingTrans", "DoneTrans", "NoNeedTrans", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum o
{
  static
  {
    AppMethodBeat.i(295397);
    Wvu = new o("Hide", 0);
    Wvv = new o("DoingTrans", 1);
    Wvw = new o("DoneTrans", 2);
    Wvx = new o("NoNeedTrans", 3);
    Wvy = new o[] { Wvu, Wvv, Wvw, Wvx };
    AppMethodBeat.o(295397);
  }
  
  private o() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.o
 * JD-Core Version:    0.7.0.1
 */