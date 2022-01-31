package com.tencent.mm.plugin.websearch.widget;

import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.Map;

final class a$5$1
  implements Runnable
{
  a$5$1(a.5 param5) {}
  
  public final void run()
  {
    AppMethodBeat.i(91395);
    if (this.uMd.uLS != a.b(this.uMd.uLR))
    {
      AppMethodBeat.o(91395);
      return;
    }
    if ((a.o(this.uMd.uLR) != 4) && (a.o(this.uMd.uLR) != 2) && (a.o(this.uMd.uLR) != 3))
    {
      ab.e("FTSSearchWidgetMgr", "widget load timeout, unbind now");
      h.qsU.idkeyStat(867L, 5L, 1L, false);
      u.i("FTSSearchWidgetMgr", "widget load timeout, unbind now", new Object[0]);
      a.daa();
      u.C(this.uMd.uLS.uKA.cwc, false);
      ((a.d)a.e(this.uMd.uLR).get(this.uMd.uLT)).isLoading = false;
      this.uMd.uLW.dOW();
      this.uMd.uLW.setVisibility(4);
      a.c(this.uMd.uLR).dI(this.uMd.uLT, 3);
      a.h(this.uMd.uLR).cl(this.uMd.val$view);
      a.h(this.uMd.uLR).a(this.uMd.hpi, this.uMd.val$view);
      this.uMd.uMc.removeView(this.uMd.val$view);
      h.qsU.idkeyStat(646L, 0L, 1L, false);
    }
    AppMethodBeat.o(91395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.5.1
 * JD-Core Version:    0.7.0.1
 */