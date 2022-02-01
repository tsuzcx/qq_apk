package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class q
  implements Runnable
{
  public ListView GF;
  public long KKE;
  public int KKF;
  public int KKG;
  public int KKH;
  private final int KKI;
  public int KKJ;
  public int mMode;
  
  public q(ListView paramListView)
  {
    AppMethodBeat.i(143221);
    this.KKE = System.currentTimeMillis();
    this.GF = paramListView;
    this.KKI = ViewConfiguration.get(this.GF.getContext()).getScaledFadingEdgeLength();
    ad.d("ScrollerRunnable", "mExtraScroll: %d", new Object[] { Integer.valueOf(this.KKI) });
    AppMethodBeat.o(143221);
  }
  
  public final void run()
  {
    AppMethodBeat.i(143222);
    if (System.currentTimeMillis() - this.KKE > 10000L)
    {
      AppMethodBeat.o(143222);
      return;
    }
    int j = this.GF.getHeight();
    int k = this.GF.getFirstVisiblePosition();
    View localView;
    switch (this.mMode)
    {
    default: 
      AppMethodBeat.o(143222);
      return;
    case 1: 
      i = this.GF.getChildCount() - 1;
      k += i;
      if (i < 0)
      {
        AppMethodBeat.o(143222);
        return;
      }
      int m;
      int n;
      if (k == this.KKG)
      {
        if (this.KKJ > 20)
        {
          this.GF.setSelection(this.KKF);
          ad.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
        }
      }
      else
      {
        this.KKJ = 0;
        localView = this.GF.getChildAt(i);
        m = localView.getHeight();
        n = localView.getTop();
        if (k >= this.GF.getCount() - 1) {
          break label271;
        }
      }
      label271:
      for (i = this.KKI;; i = this.GF.getPaddingBottom())
      {
        this.GF.smoothScrollBy(i + (m - (j - n)), this.KKH);
        this.KKG = k;
        if (k >= this.KKF) {
          break;
        }
        this.GF.post(this);
        AppMethodBeat.o(143222);
        return;
        this.GF.post(this);
        this.KKJ += 1;
        ad.d("ScrollerRunnable", "dz:try scroll lastpos = %d", new Object[] { Integer.valueOf(k) });
        AppMethodBeat.o(143222);
        return;
      }
    }
    if (k == this.KKG)
    {
      if (this.KKJ > 20)
      {
        this.GF.setSelection(this.KKF);
        ad.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
      }
    }
    else
    {
      this.KKJ = 0;
      localView = this.GF.getChildAt(0);
      if (localView != null) {
        break label386;
      }
      AppMethodBeat.o(143222);
      return;
    }
    this.GF.post(this);
    this.KKJ += 1;
    ad.d("ScrollerRunnable", "dz:try scroll firstPos = %d", new Object[] { Integer.valueOf(k) });
    AppMethodBeat.o(143222);
    return;
    label386:
    j = localView.getTop();
    if (k > 0) {}
    for (int i = this.KKI;; i = this.GF.getPaddingTop())
    {
      this.GF.smoothScrollBy(j - i, this.KKH);
      this.KKG = k;
      if (k <= this.KKF) {
        break;
      }
      this.GF.post(this);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.q
 * JD-Core Version:    0.7.0.1
 */