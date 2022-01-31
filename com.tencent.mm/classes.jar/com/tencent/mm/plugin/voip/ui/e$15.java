package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.report.service.h;
import java.lang.ref.WeakReference;

final class e$15
  implements View.OnClickListener
{
  e$15(e parame) {}
  
  public final void onClick(View paramView)
  {
    boolean bool = false;
    h.nFQ.f(11079, new Object[] { Integer.valueOf(4) });
    if ((!e.k(this.pYP)) && (this.pYP.pWz.get() != null)) {
      e.s(this.pYP).getVisibility();
    }
    int i;
    if (e.s(this.pYP).getVisibility() == 0)
    {
      i = 4;
      if (i != 0) {
        break label240;
      }
    }
    label240:
    for (int j = 0;; j = 8)
    {
      e.s(this.pYP).setVisibility(j);
      e.w(this.pYP).setVisibility(j);
      e.x(this.pYP).setVisibility(j);
      e.b(this.pYP).setVisibility(j);
      e.a(this.pYP).setVisibility(j);
      paramView = this.pYP;
      if (j == 0) {
        bool = true;
      }
      e.e(paramView, bool);
      if (ae.eTA)
      {
        e.B(this.pYP).setVisibility(j);
        e.C(this.pYP).setVisibility(j);
        e.D(this.pYP).setVisibility(j);
        e.E(this.pYP).setVisibility(j);
        e.F(this.pYP).setVisibility(j);
        e.G(this.pYP).setVisibility(j);
      }
      if (i == 0) {
        e.t(this.pYP);
      }
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.e.15
 * JD-Core Version:    0.7.0.1
 */