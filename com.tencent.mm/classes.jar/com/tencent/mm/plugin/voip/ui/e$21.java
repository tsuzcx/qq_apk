package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.report.service.h;
import java.lang.ref.WeakReference;

final class e$21
  implements View.OnClickListener
{
  e$21(e parame) {}
  
  public final void onClick(View paramView)
  {
    h.nFQ.f(11618, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
    if ((this.pYP.pWz != null) && (this.pYP.pWz.get() != null))
    {
      ((c)this.pYP.pWz.get()).jX(true);
      if (!e.h(this.pYP)) {
        break label138;
      }
      this.pYP.pWQ.removeView(this.pYP.pYr);
    }
    for (;;)
    {
      e.a(this.pYP, false);
      if (this.pYP.pWV != null)
      {
        this.pYP.bQK();
        this.pYP.pWV.J(false, true);
      }
      return;
      label138:
      this.pYP.pWQ.removeView(this.pYP.pYq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.e.21
 * JD-Core Version:    0.7.0.1
 */