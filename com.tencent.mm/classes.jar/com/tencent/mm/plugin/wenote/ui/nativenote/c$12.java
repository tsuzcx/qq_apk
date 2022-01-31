package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wenote.model.nativenote.b.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;

final class c$12
  implements View.OnClickListener
{
  c$12(c paramc, a parama) {}
  
  public final void onClick(View paramView)
  {
    boolean bool2 = true;
    h.nFQ.f(14547, new Object[] { Integer.valueOf(8) });
    this.rMB.rMt.setPressed(false);
    this.rMB.rMr.setPressed(false);
    if ((this.rMB.rMy) || (this.rMB.rMz)) {
      this.rMB.rMx = false;
    }
    Object localObject = u.rLa;
    if (!this.rMB.rMx)
    {
      bool1 = true;
      c.c((t)localObject, Boolean.valueOf(bool1));
      localObject = this.rMB;
      if (this.rMB.rMx) {
        break label167;
      }
    }
    label167:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((c)localObject).rMx = bool1;
      c.a(this.rMB, paramView, this.rMB.rMx);
      c.b(this.rMA);
      this.rMB.rMy = false;
      this.rMB.rMz = false;
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c.12
 * JD-Core Version:    0.7.0.1
 */