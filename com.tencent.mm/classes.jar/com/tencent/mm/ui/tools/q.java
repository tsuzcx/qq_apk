package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class q
  implements Runnable
{
  public long afKm;
  public int afKn;
  public int afKo;
  public int afKp;
  private final int afKq;
  public int afKr;
  public ListView bEw;
  public int mMode;
  
  public q(ListView paramListView)
  {
    AppMethodBeat.i(143221);
    this.afKm = System.currentTimeMillis();
    this.bEw = paramListView;
    this.afKq = ViewConfiguration.get(this.bEw.getContext()).getScaledFadingEdgeLength();
    Log.d("ScrollerRunnable", "mExtraScroll: %d", new Object[] { Integer.valueOf(this.afKq) });
    AppMethodBeat.o(143221);
  }
  
  public final void run()
  {
    AppMethodBeat.i(143222);
    if (System.currentTimeMillis() - this.afKm > 10000L)
    {
      AppMethodBeat.o(143222);
      return;
    }
    int j = this.bEw.getHeight();
    int k = this.bEw.getFirstVisiblePosition();
    View localView;
    switch (this.mMode)
    {
    default: 
      AppMethodBeat.o(143222);
      return;
    case 1: 
      i = this.bEw.getChildCount() - 1;
      k += i;
      if (i < 0)
      {
        AppMethodBeat.o(143222);
        return;
      }
      int m;
      int n;
      if (k == this.afKo)
      {
        if (this.afKr > 20)
        {
          this.bEw.setSelection(this.afKn);
          Log.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
        }
      }
      else
      {
        this.afKr = 0;
        localView = this.bEw.getChildAt(i);
        m = localView.getHeight();
        n = localView.getTop();
        if (k >= this.bEw.getCount() - 1) {
          break label271;
        }
      }
      label271:
      for (i = this.afKq;; i = this.bEw.getPaddingBottom())
      {
        this.bEw.smoothScrollBy(i + (m - (j - n)), this.afKp);
        this.afKo = k;
        if (k >= this.afKn) {
          break;
        }
        this.bEw.post(this);
        AppMethodBeat.o(143222);
        return;
        this.bEw.post(this);
        this.afKr += 1;
        Log.d("ScrollerRunnable", "dz:try scroll lastpos = %d", new Object[] { Integer.valueOf(k) });
        AppMethodBeat.o(143222);
        return;
      }
    }
    if (k == this.afKo)
    {
      if (this.afKr > 20)
      {
        this.bEw.setSelection(this.afKn);
        Log.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
      }
    }
    else
    {
      this.afKr = 0;
      localView = this.bEw.getChildAt(0);
      if (localView != null) {
        break label386;
      }
      AppMethodBeat.o(143222);
      return;
    }
    this.bEw.post(this);
    this.afKr += 1;
    Log.d("ScrollerRunnable", "dz:try scroll firstPos = %d", new Object[] { Integer.valueOf(k) });
    AppMethodBeat.o(143222);
    return;
    label386:
    j = localView.getTop();
    if (k > 0) {}
    for (int i = this.afKq;; i = this.bEw.getPaddingTop())
    {
      this.bEw.smoothScrollBy(j - i, this.afKp);
      this.afKo = k;
      if (k <= this.afKn) {
        break;
      }
      this.bEw.post(this);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.q
 * JD-Core Version:    0.7.0.1
 */