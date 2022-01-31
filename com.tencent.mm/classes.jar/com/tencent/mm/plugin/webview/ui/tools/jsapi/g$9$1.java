package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.widget.n;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class g$9$1
  implements Runnable
{
  g$9$1(g.9 param9, axt paramaxt) {}
  
  public final void run()
  {
    AppMethodBeat.i(9051);
    LinkedList localLinkedList = this.vqu.wYt;
    String str1 = this.vqu.ntp;
    String str2 = this.vqu.wnz;
    n localn = new n(g.j(this.vqv.vqm));
    g.9.1.1 local1 = new g.9.1.1(this);
    if ((localLinkedList != null) && (localLinkedList.size() > 0))
    {
      if (!localn.a(localLinkedList, str1, str2, local1)) {
        this.vqv.vqq.aBV();
      }
      AppMethodBeat.o(9051);
      return;
    }
    ab.e("MicroMsg.MsgHandler", "scopeInfoList is empty!");
    this.vqv.vqm.a(this.vqv.uZa, "authorize:fail", null);
    this.vqv.vqq.aBV();
    AppMethodBeat.o(9051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.9.1
 * JD-Core Version:    0.7.0.1
 */