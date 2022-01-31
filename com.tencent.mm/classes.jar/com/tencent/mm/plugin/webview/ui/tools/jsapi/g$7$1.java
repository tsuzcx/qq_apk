package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.widget.n;
import com.tencent.mm.protocal.protobuf.axx;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class g$7$1
  implements Runnable
{
  g$7$1(g.7 param7, axx paramaxx, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(154928);
    LinkedList localLinkedList = this.vqr.wYt;
    String str1 = this.vqr.ntp;
    String str2 = this.vqr.wnz;
    ab.d("MicroMsg.MsgHandler", "appName %s, appIconUrl %s", new Object[] { str1, str2 });
    n localn = new n(g.j(this.vqs.vqm));
    g.7.1.1 local1 = new g.7.1.1(this);
    if ((localLinkedList != null) && (localLinkedList.size() > 0))
    {
      if (!localn.a(localLinkedList, str1, str2, local1)) {
        this.vqs.vqq.aBV();
      }
      AppMethodBeat.o(154928);
      return;
    }
    ab.e("MicroMsg.MsgHandler", "scopeInfoList is empty!");
    this.vqs.vqm.a(this.vqs.uZa, "login:fail", null);
    this.vqs.vqq.aBV();
    AppMethodBeat.o(154928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.7.1
 * JD-Core Version:    0.7.0.1
 */