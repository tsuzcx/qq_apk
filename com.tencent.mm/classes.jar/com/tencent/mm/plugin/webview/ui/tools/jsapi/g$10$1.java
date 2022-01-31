package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.plugin.webview.ui.tools.widget.n;
import com.tencent.mm.protocal.c.aro;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class g$10$1
  implements Runnable
{
  g$10$1(g.10 param10, aro paramaro) {}
  
  public final void run()
  {
    LinkedList localLinkedList = this.rzs.tab;
    String str1 = this.rzs.kVn;
    String str2 = this.rzs.suv;
    n localn = new n(g.i(this.rzt.rzi));
    g.10.1.1 local1 = new g.10.1.1(this);
    if ((localLinkedList != null) && (localLinkedList.size() > 0))
    {
      if (!localn.a(localLinkedList, str1, str2, local1)) {
        this.rzt.rzo.aib();
      }
      return;
    }
    y.e("MicroMsg.MsgHandler", "scopeInfoList is empty!");
    g.a(this.rzt.rzi, this.rzt.rzk, "authorize:fail", null);
    this.rzt.rzo.aib();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.10.1
 * JD-Core Version:    0.7.0.1
 */