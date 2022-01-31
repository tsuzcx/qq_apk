package com.tencent.mm.plugin.voip.ui;

import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMTextureView;
import java.lang.ref.WeakReference;

final class e$11
  implements Runnable
{
  e$11(e parame) {}
  
  public final void run()
  {
    if (e.k(this.pYP))
    {
      if (e.h(this.pYP))
      {
        this.pYP.pYr.setVisibility(4);
        this.pYP.pYq.setVisibility(0);
        y.i("MicroMsg.Voip.VoipVideoFragment", "steve: change to big hw texture view!");
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.addRule(13);
        int i = this.pYP.pWQ.indexOfChild(e.m(this.pYP));
        this.pYP.pWQ.removeView(this.pYP.pYr);
        this.pYP.pWQ.addView(this.pYP.pYq, i + 1, localLayoutParams);
        ((c)this.pYP.pWz.get()).b(this.pYP.pYq);
      }
      e.m(this.pYP).setVisibility(4);
      e.l(this.pYP).setVisibility(0);
      e.p(this.pYP);
      this.pYP.pYq.setVisibility(0);
      y.i("MicroMsg.Voip.VoipVideoFragment", "set big hw view visible");
      e.a(this.pYP, false);
      return;
    }
    if (!e.h(this.pYP))
    {
      this.pYP.pYq.setVisibility(4);
      this.pYP.pWQ.removeView(this.pYP.pYq);
      this.pYP.pWQ.addView(this.pYP.pYr);
      ((c)this.pYP.pWz.get()).b(this.pYP.pYr);
    }
    e.l(this.pYP).setVisibility(4);
    this.pYP.pYr.setVisibility(0);
    y.i("MicroMsg.Voip.VoipVideoFragment", "set big hw view visible");
    this.pYP.pYr.bringToFront();
    e.m(this.pYP).setVisibility(0);
    e.a(this.pYP, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.e.11
 * JD-Core Version:    0.7.0.1
 */