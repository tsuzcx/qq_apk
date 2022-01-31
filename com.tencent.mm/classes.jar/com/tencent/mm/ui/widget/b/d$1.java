package com.tencent.mm.ui.widget.b;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.d;
import java.util.List;

final class d$1
  implements AdapterView.OnItemClickListener
{
  d$1(d paramd) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(112647);
    if (paramInt >= d.b(this.AHn).size())
    {
      AppMethodBeat.o(112647);
      return;
    }
    paramAdapterView = (m)d.b(this.AHn).zkW.get(paramInt);
    if ((paramAdapterView != null) && (paramAdapterView.xTc))
    {
      AppMethodBeat.o(112647);
      return;
    }
    if (paramInt < d.b(this.AHn).size()) {
      if (d.c(this.AHn) != null) {
        d.c(this.AHn).onMMMenuItemSelected(d.b(this.AHn).getItem(paramInt), paramInt);
      }
    }
    for (;;)
    {
      if (!d.f(this.AHn)) {
        this.AHn.cre();
      }
      d.g(this.AHn);
      d.a(this.AHn, paramInt);
      d.h(this.AHn).ajb.notifyChanged();
      AppMethodBeat.o(112647);
      return;
      if ((d.d(this.AHn).size() > 0) && (paramInt < d.b(this.AHn).size() + d.d(this.AHn).size()))
      {
        if (d.e(this.AHn) != null) {
          d.e(this.AHn).onMMMenuItemSelected(d.d(this.AHn).getItem(paramInt - d.b(this.AHn).size()), paramInt);
        }
      }
      else {
        d.dPc();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b.d.1
 * JD-Core Version:    0.7.0.1
 */