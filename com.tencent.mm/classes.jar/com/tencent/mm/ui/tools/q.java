package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class q
  implements Runnable
{
  public ListView DQ;
  public long Htd;
  public int Hte;
  public int Htf;
  public int Htg;
  private final int Hth;
  public int Hti;
  public int mMode;
  
  public q(ListView paramListView)
  {
    AppMethodBeat.i(143221);
    this.Htd = System.currentTimeMillis();
    this.DQ = paramListView;
    this.Hth = ViewConfiguration.get(this.DQ.getContext()).getScaledFadingEdgeLength();
    ad.d("ScrollerRunnable", "mExtraScroll: %d", new Object[] { Integer.valueOf(this.Hth) });
    AppMethodBeat.o(143221);
  }
  
  public final void run()
  {
    AppMethodBeat.i(143222);
    if (System.currentTimeMillis() - this.Htd > 10000L)
    {
      AppMethodBeat.o(143222);
      return;
    }
    int j = this.DQ.getHeight();
    int k = this.DQ.getFirstVisiblePosition();
    View localView;
    switch (this.mMode)
    {
    default: 
      AppMethodBeat.o(143222);
      return;
    case 1: 
      i = this.DQ.getChildCount() - 1;
      k += i;
      if (i < 0)
      {
        AppMethodBeat.o(143222);
        return;
      }
      int m;
      int n;
      if (k == this.Htf)
      {
        if (this.Hti > 20)
        {
          this.DQ.setSelection(this.Hte);
          ad.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
        }
      }
      else
      {
        this.Hti = 0;
        localView = this.DQ.getChildAt(i);
        m = localView.getHeight();
        n = localView.getTop();
        if (k >= this.DQ.getCount() - 1) {
          break label271;
        }
      }
      label271:
      for (i = this.Hth;; i = this.DQ.getPaddingBottom())
      {
        this.DQ.smoothScrollBy(i + (m - (j - n)), this.Htg);
        this.Htf = k;
        if (k >= this.Hte) {
          break;
        }
        this.DQ.post(this);
        AppMethodBeat.o(143222);
        return;
        this.DQ.post(this);
        this.Hti += 1;
        ad.d("ScrollerRunnable", "dz:try scroll lastpos = %d", new Object[] { Integer.valueOf(k) });
        AppMethodBeat.o(143222);
        return;
      }
    }
    if (k == this.Htf)
    {
      if (this.Hti > 20)
      {
        this.DQ.setSelection(this.Hte);
        ad.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
      }
    }
    else
    {
      this.Hti = 0;
      localView = this.DQ.getChildAt(0);
      if (localView != null) {
        break label386;
      }
      AppMethodBeat.o(143222);
      return;
    }
    this.DQ.post(this);
    this.Hti += 1;
    ad.d("ScrollerRunnable", "dz:try scroll firstPos = %d", new Object[] { Integer.valueOf(k) });
    AppMethodBeat.o(143222);
    return;
    label386:
    j = localView.getTop();
    if (k > 0) {}
    for (int i = this.Hth;; i = this.DQ.getPaddingTop())
    {
      this.DQ.smoothScrollBy(j - i, this.Htg);
      this.Htf = k;
      if (k <= this.Hte) {
        break;
      }
      this.DQ.post(this);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.q
 * JD-Core Version:    0.7.0.1
 */