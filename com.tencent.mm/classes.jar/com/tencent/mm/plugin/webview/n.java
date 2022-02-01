package com.tencent.mm.plugin.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/WebTransStatus;", "", "(Ljava/lang/String;I)V", "None", "DoTrans", "DoRevert", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum n
{
  static
  {
    AppMethodBeat.i(295413);
    Wvq = new n("None", 0);
    Wvr = new n("DoTrans", 1);
    Wvs = new n("DoRevert", 2);
    Wvt = new n[] { Wvq, Wvr, Wvs };
    AppMethodBeat.o(295413);
  }
  
  private n() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.n
 * JD-Core Version:    0.7.0.1
 */