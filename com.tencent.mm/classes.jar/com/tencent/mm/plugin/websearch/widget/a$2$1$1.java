package com.tencent.mm.plugin.websearch.widget;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.h.b.a.au;
import com.tencent.mm.h.b.a.av;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class a$2$1$1
  implements f
{
  a$2$1$1(a.2.1 param1, String paramString, ThreeDotsLoadingView paramThreeDotsLoadingView, ImageView paramImageView, long paramLong, boolean paramBoolean) {}
  
  public final void y(View paramView, int paramInt)
  {
    u.i("FTSSearchWidgetMgr", "onWidgetStateChanged sessionId %s, state %d", new Object[] { this.fVG, Integer.valueOf(paramInt) });
    a.a(this.qWN.qWI.qWF, paramInt);
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      h.nFQ.a(867L, 4L, 1L, false);
      a.cae();
      u.y(this.qWN.qWI.qWG.qVo.bOL, false);
      this.qWJ.cKc();
      this.qWJ.setVisibility(4);
      if (paramInt == 2)
      {
        a.j(this.qWN.qWI.qWF).cJ(this.qWN.qWI.qWH, 4);
        return;
      }
      break;
    case 0: 
      h.nFQ.a(867L, 1L, 1L, false);
      this.qWJ.setVisibility(0);
      this.qWK.setVisibility(4);
      a.j(this.qWN.qWI.qWF).cJ(this.qWN.qWI.qWH, 1);
      return;
    case 1: 
      h.nFQ.a(867L, 3L, 1L, false);
      this.qWJ.cKc();
      this.qWJ.setVisibility(4);
      a.j(this.qWN.qWI.qWF).cJ(this.qWN.qWI.qWH, 3);
      a.cae();
      u.y(this.qWN.qWI.qWG.qVo.bOL, false);
      return;
    case 4: 
      h.nFQ.a(867L, 2L, 1L, false);
      this.qWJ.setVisibility(4);
      this.qWK.setVisibility(4);
      this.qWJ.cKc();
      a.cae();
      u.y(this.qWN.qWI.qWG.qVo.bOL, true);
      a.j(this.qWN.qWI.qWF).cJ(this.qWN.qWI.qWH, 2);
      u.i("FTSSearchWidgetMgr", "widget display timecost %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.qWL) });
      paramView = new au();
      paramView.cjv = this.qWN.qWI.qWG.qVo.dZY;
      paramView.cpX = (System.currentTimeMillis() - this.qWL);
      if (this.qWM)
      {
        l = 1L;
        paramView.cjx = l;
        paramView.QX();
        paramView = new av();
        paramView.cfv = 4L;
        paramView.cjv = this.qWN.qWI.qWG.qVo.dZY;
        paramView.cpX = (System.currentTimeMillis() - this.qWL);
        if (!this.qWM) {
          break label585;
        }
      }
      label585:
      for (long l = 1L;; l = 2L)
      {
        paramView.cjx = l;
        paramView.cpY = this.qWN.qWI.fVY;
        paramView.QX();
        d.caf();
        d.d(this.qWN.qWI.qWG);
        return;
        l = 2L;
        break;
      }
    }
    a.j(this.qWN.qWI.qWF).cJ(this.qWN.qWI.qWH, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.2.1.1
 * JD-Core Version:    0.7.0.1
 */