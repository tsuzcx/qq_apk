package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wenote.model.nativenote.b.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;

final class c$10
  implements View.OnClickListener
{
  c$10(c paramc, a parama) {}
  
  public final void onClick(View paramView)
  {
    boolean bool2 = true;
    AppMethodBeat.i(27124);
    h.qsU.e(14547, new Object[] { Integer.valueOf(11) });
    this.vDf.vCU.setPressed(false);
    this.vDf.vCV.setPressed(false);
    if ((this.vDf.vDc) || (this.vDf.vDb)) {
      this.vDf.vDd = false;
    }
    Object localObject = u.vBD;
    if (!this.vDf.vDd)
    {
      bool1 = true;
      c.c((t)localObject, Boolean.valueOf(bool1));
      localObject = this.vDf;
      if (this.vDf.vDd) {
        break label179;
      }
    }
    label179:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((c)localObject).vDd = bool1;
      c.a(this.vDf, paramView, this.vDf.vDd);
      c.b(this.vDe);
      this.vDf.vDc = false;
      this.vDf.vDb = false;
      AppMethodBeat.o(27124);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c.10
 * JD-Core Version:    0.7.0.1
 */