package com.tencent.mm.plugin.websearch.widget;

import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.plugin.websearch.widget.c.b;
import com.tencent.mm.sdk.platformtools.y;

final class a$5
  implements Runnable
{
  a$5(a parama, int paramInt1, int paramInt2, String paramString1, n paramn, String paramString2) {}
  
  public final void run()
  {
    b localb = new b(this.gUz, this.gUA, this.qWQ);
    n localn = this.qWR;
    if (localn == null) {
      y.e("BaseJsapiEvent", "null JSBridgeAccessible ");
    }
    for (boolean bool = false; !bool; bool = localn.ad(localb.getName(), localb.caj()))
    {
      y.i("FTSSearchWidgetMgr", "onTap fail: execute js event %s ", new Object[] { this.fVe });
      a.j(this.qWF).a(this.qWQ, false, "onTap fail: execute js event  " + this.fVe, this.fVe);
      return;
    }
    a.b(this.qWF, this.qWQ);
    com.tencent.mm.cg.a.postDelayed(new a.5.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.5
 * JD-Core Version:    0.7.0.1
 */