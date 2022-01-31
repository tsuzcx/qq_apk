package com.tencent.mm.plugin.voip.ui;

import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.video.MovableTextureView;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMTextureView;
import java.lang.ref.WeakReference;

final class e$5
  implements View.OnClickListener
{
  e$5(e parame) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.Voip.VoipVideoFragment", "steve: hwTxtureViewSmall clicked!");
    if (e.h(this.pYP))
    {
      paramView = this.pYP;
      if (e.k(this.pYP)) {
        break label322;
      }
      bool = true;
      e.c(paramView, bool);
      paramView = this.pYP;
      if (e.k(this.pYP)) {
        break label328;
      }
    }
    label322:
    label328:
    for (boolean bool = true;; bool = false)
    {
      Object localObject = e.d(paramView, bool);
      paramView = (MovableTextureView)this.pYP.pYr;
      int i = ((Point)localObject).x;
      int j = ((Point)localObject).y;
      localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, j);
      localLayoutParams.leftMargin = ((RelativeLayout.LayoutParams)localObject).leftMargin;
      localLayoutParams.topMargin = ((RelativeLayout.LayoutParams)localObject).topMargin;
      paramView.mWidth = i;
      paramView.qav = j;
      paramView.setLayoutParams(localLayoutParams);
      this.pYP.pYr.setVisibility(4);
      e.p(this.pYP);
      this.pYP.pYq.setVisibility(0);
      e.l(this.pYP).setVisibility(0);
      y.i("MicroMsg.Voip.VoipVideoFragment", "steve: change to big hw texture view!");
      paramView = new RelativeLayout.LayoutParams(-1, -2);
      paramView.addRule(13);
      i = this.pYP.pWQ.indexOfChild(e.m(this.pYP));
      this.pYP.pWQ.removeView(this.pYP.pYr);
      this.pYP.pWQ.addView(this.pYP.pYq, i + 1, paramView);
      ((c)this.pYP.pWz.get()).b(this.pYP.pYq);
      e.a(this.pYP, false);
      h.nFQ.f(11079, new Object[] { Integer.valueOf(3) });
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.e.5
 * JD-Core Version:    0.7.0.1
 */