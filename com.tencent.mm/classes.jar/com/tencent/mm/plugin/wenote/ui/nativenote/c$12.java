package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(27126);
    h.qsU.e(14547, new Object[] { Integer.valueOf(8) });
    this.vDf.vCX.setPressed(false);
    this.vDf.vCV.setPressed(false);
    if ((this.vDf.vDc) || (this.vDf.vDd)) {
      this.vDf.vDb = false;
    }
    Object localObject = u.vBE;
    if (!this.vDf.vDb)
    {
      bool1 = true;
      c.c((t)localObject, Boolean.valueOf(bool1));
      localObject = this.vDf;
      if (this.vDf.vDb) {
        break label179;
      }
    }
    label179:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((c)localObject).vDb = bool1;
      c.a(this.vDf, paramView, this.vDf.vDb);
      c.b(this.vDe);
      this.vDf.vDc = false;
      this.vDf.vDd = false;
      AppMethodBeat.o(27126);
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