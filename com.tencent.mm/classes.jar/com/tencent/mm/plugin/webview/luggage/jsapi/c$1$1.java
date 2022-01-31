package com.tencent.mm.plugin.webview.luggage.jsapi;

import com.tencent.luggage.e.a.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.n;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class c$1$1
  implements Runnable
{
  c$1$1(c.1 param1, LinkedList paramLinkedList, String paramString1, String paramString2) {}
  
  public final void run()
  {
    n localn = new n(((com.tencent.mm.plugin.webview.luggage.e)this.rdu.kNj.big).mContext);
    c.1.1.1 local1 = new c.1.1.1(this);
    if ((this.fXW != null) && (this.fXW.size() > 0))
    {
      if (!localn.a(this.fXW, this.rds, this.rdt, local1)) {
        this.rdu.kNj.a("fail", null);
      }
      return;
    }
    y.e("MicroMsg.JsApiAuthorize", "scopeInfoList is empty!");
    this.rdu.kNj.a("fail", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.c.1.1
 * JD-Core Version:    0.7.0.1
 */