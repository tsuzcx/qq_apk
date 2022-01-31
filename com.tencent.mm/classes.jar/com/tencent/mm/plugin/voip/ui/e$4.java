package com.tencent.mm.plugin.voip.ui;

import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMTextureView;
import java.lang.ref.WeakReference;

final class e$4
  implements View.OnClickListener
{
  e$4(e parame) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.pYP;
    boolean bool;
    label40:
    int i;
    if (!e.k(this.pYP))
    {
      bool = true;
      e.c(paramView, bool);
      paramView = this.pYP;
      if (e.k(this.pYP)) {
        break label288;
      }
      bool = true;
      paramView = e.d(paramView, bool);
      e.l(this.pYP).eq(paramView.x, paramView.y);
      y.i("MicroMsg.Voip.VoipVideoFragment", "steve: mGlSmallVideoView clicked!");
      if ((this.pYP.pYt & 0x1) == 0) {
        break label293;
      }
      i = 1;
      label85:
      if (i == 0) {
        break label298;
      }
      if (!e.h(this.pYP))
      {
        this.pYP.pYq.setVisibility(4);
        this.pYP.pWQ.removeView(this.pYP.pYq);
        this.pYP.pWQ.addView(this.pYP.pYr);
        ((c)this.pYP.pWz.get()).b(this.pYP.pYr);
        e.a(this.pYP, true);
        y.i("MicroMsg.Voip.VoipVideoFragment", "steve: change hw texture view!");
      }
      e.l(this.pYP).setVisibility(4);
      this.pYP.pYr.setVisibility(0);
      this.pYP.pYr.bringToFront();
      e.m(this.pYP).setVisibility(0);
    }
    for (;;)
    {
      e.n(this.pYP).setVoipBeauty(this.pYP.pYu);
      e.o(this.pYP).setVoipBeauty(this.pYP.pYu);
      h.nFQ.f(11079, new Object[] { Integer.valueOf(3) });
      return;
      bool = false;
      break;
      label288:
      bool = false;
      break label40;
      label293:
      i = 0;
      break label85;
      label298:
      e.l(this.pYP).setVisibility(0);
      this.pYP.pYr.setVisibility(4);
      e.l(this.pYP).bringToFront();
      e.m(this.pYP).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.e.4
 * JD-Core Version:    0.7.0.1
 */