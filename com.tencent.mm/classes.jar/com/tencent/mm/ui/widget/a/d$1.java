package com.tencent.mm.ui.widget.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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
    paramAdapterView = (m)d.b(this.wnq).uWD.get(paramInt);
    if ((paramAdapterView != null) && (paramAdapterView.tMS)) {
      return;
    }
    if (paramInt < d.b(this.wnq).size()) {
      if (d.c(this.wnq) != null) {
        d.c(this.wnq).onMMMenuItemSelected(d.b(this.wnq).getItem(paramInt), paramInt);
      }
    }
    for (;;)
    {
      if (!d.f(this.wnq)) {
        this.wnq.bFp();
      }
      d.g(this.wnq);
      d.a(this.wnq, paramInt);
      d.h(this.wnq).agL.notifyChanged();
      return;
      if ((d.d(this.wnq).size() > 0) && (paramInt < d.b(this.wnq).size() + d.d(this.wnq).size()) && (d.e(this.wnq) != null)) {
        d.e(this.wnq).onMMMenuItemSelected(d.d(this.wnq).getItem(paramInt - d.b(this.wnq).size()), paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.d.1
 * JD-Core Version:    0.7.0.1
 */