package com.tencent.mm.plugin.websearch.widget;

import android.widget.AbsoluteLayout;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class a$3$1
  implements Runnable
{
  a$3$1(a.3 param3) {}
  
  public final void run()
  {
    if (this.qWP.qWG != a.b(this.qWP.qWF)) {}
    while ((a.n(this.qWP.qWF) == 4) || (a.n(this.qWP.qWF) == 2) || (a.n(this.qWP.qWF) == 3)) {
      return;
    }
    y.e("FTSSearchWidgetMgr", "widget load timeout, unbind now");
    h.nFQ.a(867L, 5L, 1L, false);
    u.i("FTSSearchWidgetMgr", "widget load timeout, unbind now", new Object[0]);
    a.cae();
    u.y(this.qWP.qWG.qVo.bOL, false);
    this.qWP.qWJ.cKc();
    this.qWP.qWJ.setVisibility(4);
    a.j(this.qWP.qWF).cJ(this.qWP.qWH, 3);
    a.f(this.qWP.qWF).bM(this.qWP.val$view);
    a.f(this.qWP.qWF).b(this.qWP.fVG, this.qWP.val$view);
    this.qWP.qWO.removeView(this.qWP.val$view);
    h.nFQ.a(646L, 0L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.3.1
 * JD-Core Version:    0.7.0.1
 */