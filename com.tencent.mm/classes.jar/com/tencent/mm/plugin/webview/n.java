package com.tencent.mm.plugin.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/WebTransStatus;", "", "(Ljava/lang/String;I)V", "None", "DoTrans", "DoRevert", "plugin-webview_release"})
public enum n
{
  static
  {
    AppMethodBeat.i(268464);
    n localn1 = new n("None", 0);
    PEQ = localn1;
    n localn2 = new n("DoTrans", 1);
    PER = localn2;
    n localn3 = new n("DoRevert", 2);
    PES = localn3;
    PET = new n[] { localn1, localn2, localn3 };
    AppMethodBeat.o(268464);
  }
  
  private n() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.n
 * JD-Core Version:    0.7.0.1
 */