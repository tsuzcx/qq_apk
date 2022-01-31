package com.tencent.mm.plugin.websearch.widget;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.da;
import com.tencent.mm.g.b.a.dc;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.Map;

final class a$2$2$9
  implements f
{
  a$2$2$9(a.2.2 param2, String paramString, ThreeDotsLoadingView paramThreeDotsLoadingView, ImageView paramImageView, long paramLong, boolean paramBoolean) {}
  
  public final void I(View paramView, int paramInt)
  {
    AppMethodBeat.i(91385);
    u.i("FTSSearchWidgetMgr", "onWidgetStateChanged sessionId %s, state %d", new Object[] { this.hpi, Integer.valueOf(paramInt) });
    a.a(this.uLV.uLU.uLR, paramInt);
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      h.qsU.idkeyStat(867L, 4L, 1L, false);
      a.daa();
      u.C(this.uLV.uLU.uLS.uKA.cwc, false);
      this.uLW.dOW();
      this.uLW.setVisibility(4);
      ((a.d)a.e(this.uLV.uLU.uLR).get(this.uLV.uLU.uLT)).isLoading = false;
      if (paramInt == 2)
      {
        a.c(this.uLV.uLU.uLR).dI(this.uLV.uLU.uLT, 4);
        AppMethodBeat.o(91385);
        return;
      }
      break;
    case 0: 
      h.qsU.idkeyStat(867L, 1L, 1L, false);
      if (a.e(this.uLV.uLU.uLR).get(this.uLV.uLU.uLT) != null)
      {
        if (!((a.d)a.e(this.uLV.uLU.uLR).get(this.uLV.uLU.uLT)).uMq) {
          break label340;
        }
        this.uLW.setVisibility(8);
      }
      for (;;)
      {
        this.uLX.setVisibility(4);
        a.c(this.uLV.uLU.uLR).dI(this.uLV.uLU.uLT, 1);
        AppMethodBeat.o(91385);
        return;
        this.uLW.setVisibility(0);
      }
    case 1: 
      h.qsU.idkeyStat(867L, 3L, 1L, false);
      this.uLW.dOW();
      this.uLW.setVisibility(4);
      a.c(this.uLV.uLU.uLR).dI(this.uLV.uLU.uLT, 3);
      a.daa();
      u.C(this.uLV.uLU.uLS.uKA.cwc, false);
      ((a.d)a.e(this.uLV.uLU.uLR).get(this.uLV.uLU.uLT)).isLoading = false;
      AppMethodBeat.o(91385);
      return;
    case 4: 
      label340:
      h.qsU.idkeyStat(867L, 2L, 1L, false);
      this.uLW.setVisibility(4);
      this.uLX.setVisibility(4);
      this.uLW.dOW();
      a.daa();
      u.C(this.uLV.uLU.uLS.uKA.cwc, true);
      ((a.d)a.e(this.uLV.uLU.uLR).get(this.uLV.uLU.uLT)).isLoading = false;
      a.c(this.uLV.uLU.uLR).dI(this.uLV.uLU.uLT, 2);
      u.i("FTSSearchWidgetMgr", "widget display timecost %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.uLY) });
      paramView = new da().im(this.uLV.uLU.uLS.uKA.fqf);
      paramView.dea = (System.currentTimeMillis() - this.uLY);
      if (this.uLZ)
      {
        l = 1L;
        paramView.cUm = l;
        paramView.ake();
        paramView = new dc();
        paramView.cOc = 4L;
        paramView = paramView.it(this.uLV.uLU.uLS.uKA.fqf);
        paramView.dea = (System.currentTimeMillis() - this.uLY);
        if (!this.uLZ) {
          break label794;
        }
      }
      label794:
      for (long l = 1L;; l = 2L)
      {
        paramView.cUm = l;
        paramView.del = this.uLV.uLU.hpB;
        paramView.ake();
        d.dab();
        d.d(this.uLV.uLU.uLS);
        AppMethodBeat.o(91385);
        return;
        l = 2L;
        break;
      }
    }
    a.c(this.uLV.uLU.uLR).dI(this.uLV.uLU.uLT, 3);
    AppMethodBeat.o(91385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.2.2.9
 * JD-Core Version:    0.7.0.1
 */