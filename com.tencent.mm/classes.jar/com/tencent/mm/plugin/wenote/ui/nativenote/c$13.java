package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wenote.model.nativenote.b.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;

final class c$13
  implements View.OnClickListener
{
  c$13(c paramc, a parama) {}
  
  public final void onClick(View paramView)
  {
    boolean bool2 = true;
    AppMethodBeat.i(27127);
    h.qsU.e(14547, new Object[] { Integer.valueOf(9) });
    this.vDf.vCU.setPressed(false);
    this.vDf.vCX.setPressed(false);
    if ((this.vDf.vDb) || (this.vDf.vDd)) {
      this.vDf.vDc = false;
    }
    Object localObject = u.vBF;
    if (!this.vDf.vDc)
    {
      bool1 = true;
      c.c((t)localObject, Boolean.valueOf(bool1));
      localObject = this.vDf;
      if (this.vDf.vDc) {
        break label179;
      }
    }
    label179:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((c)localObject).vDc = bool1;
      c.a(this.vDf, paramView, this.vDf.vDc);
      c.b(this.vDe);
      this.vDf.vDb = false;
      this.vDf.vDd = false;
      AppMethodBeat.o(27127);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c.13
 * JD-Core Version:    0.7.0.1
 */