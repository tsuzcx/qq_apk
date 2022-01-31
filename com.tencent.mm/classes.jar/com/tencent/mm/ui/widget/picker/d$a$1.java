package com.tencent.mm.ui.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.d;
import java.util.HashMap;

final class d$a$1
  implements View.OnClickListener
{
  d$a$1(d.a parama, int paramInt, m paramm) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(112842);
    if (this.AJk.AJg.sap != null) {
      this.AJk.AJg.sap.onMMMenuItemSelected(this.AJk.AJg.saq.getItem(this.lU), this.lU);
    }
    if (this.AJj.xTc)
    {
      AppMethodBeat.o(112842);
      return;
    }
    if (((Boolean)d.a.a(this.AJk).get(Integer.valueOf(this.lU))).booleanValue()) {
      d.a.a(this.AJk).put(Integer.valueOf(this.lU), Boolean.FALSE);
    }
    for (;;)
    {
      this.AJk.AJh = d.a.a(this.AJk);
      this.AJk.notifyDataSetChanged();
      AppMethodBeat.o(112842);
      return;
      d.a.a(this.AJk).put(Integer.valueOf(this.lU), Boolean.TRUE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.d.a.1
 * JD-Core Version:    0.7.0.1
 */