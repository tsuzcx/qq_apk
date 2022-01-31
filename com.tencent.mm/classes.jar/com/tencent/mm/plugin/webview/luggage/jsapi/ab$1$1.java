package com.tencent.mm.plugin.webview.luggage.jsapi;

import com.tencent.luggage.e.a.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.n;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class ab$1$1
  implements Runnable
{
  ab$1$1(ab.1 param1, String paramString1, LinkedList paramLinkedList, String paramString2, String paramString3) {}
  
  public final void run()
  {
    n localn = new n(((com.tencent.mm.plugin.webview.luggage.e)this.rdI.kNj.big).mContext);
    ab.1.1.1 local1 = new ab.1.1.1(this);
    if ((this.fXW != null) && (this.fXW.size() > 0))
    {
      if (!localn.a(this.fXW, this.rds, this.rdt, local1)) {
        this.rdI.kNj.a("fail", null);
      }
      return;
    }
    y.e("MicroMsg.JsApiLogin", "scopeInfoList is empty!");
    this.rdI.kNj.a("fail", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ab.1.1
 * JD-Core Version:    0.7.0.1
 */