package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(27125);
    h.qsU.e(14547, new Object[] { Integer.valueOf(7) });
    Object localObject = u.vBC;
    if (!this.vDf.vDa)
    {
      bool1 = true;
      c.c((t)localObject, Boolean.valueOf(bool1));
      localObject = this.vDf;
      if (this.vDf.vDa) {
        break label113;
      }
    }
    label113:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((c)localObject).vDa = bool1;
      c.a(this.vDf, paramView, this.vDf.vDa);
      c.b(this.vDe);
      AppMethodBeat.o(27125);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c.11
 * JD-Core Version:    0.7.0.1
 */