package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wenote.model.nativenote.b.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;

final class c$11
  implements View.OnClickListener
{
  c$11(c paramc, a parama) {}
  
  public final void onClick(View paramView)
  {
    boolean bool2 = true;
    h.nFQ.f(14547, new Object[] { Integer.valueOf(7) });
    Object localObject = u.rKY;
    if (!this.rMB.rMw)
    {
      bool1 = true;
      c.c((t)localObject, Boolean.valueOf(bool1));
      localObject = this.rMB;
      if (this.rMB.rMw) {
        break label101;
      }
    }
    label101:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((c)localObject).rMw = bool1;
      c.a(this.rMB, paramView, this.rMB.rMw);
      c.b(this.rMA);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c.11
 * JD-Core Version:    0.7.0.1
 */