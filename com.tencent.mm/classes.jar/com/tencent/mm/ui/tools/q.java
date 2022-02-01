package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class q
  implements Runnable
{
  public ListView GF;
  public long LgY;
  public int LgZ;
  public int Lha;
  public int Lhb;
  private final int Lhc;
  public int Lhd;
  public int mMode;
  
  public q(ListView paramListView)
  {
    AppMethodBeat.i(143221);
    this.LgY = System.currentTimeMillis();
    this.GF = paramListView;
    this.Lhc = ViewConfiguration.get(this.GF.getContext()).getScaledFadingEdgeLength();
    ae.d("ScrollerRunnable", "mExtraScroll: %d", new Object[] { Integer.valueOf(this.Lhc) });
    AppMethodBeat.o(143221);
  }
  
  public final void run()
  {
    AppMethodBeat.i(143222);
    if (System.currentTimeMillis() - this.LgY > 10000L)
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
      if (k == this.Lha)
      {
        if (this.Lhd > 20)
        {
          this.GF.setSelection(this.LgZ);
          ae.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
        }
      }
      else
      {
        this.Lhd = 0;
        localView = this.GF.getChildAt(i);
        m = localView.getHeight();
        n = localView.getTop();
        if (k >= this.GF.getCount() - 1) {
          break label271;
        }
      }
      label271:
      for (i = this.Lhc;; i = this.GF.getPaddingBottom())
      {
        this.GF.smoothScrollBy(i + (m - (j - n)), this.Lhb);
        this.Lha = k;
        if (k >= this.LgZ) {
          break;
        }
        this.GF.post(this);
        AppMethodBeat.o(143222);
        return;
        this.GF.post(this);
        this.Lhd += 1;
        ae.d("ScrollerRunnable", "dz:try scroll lastpos = %d", new Object[] { Integer.valueOf(k) });
        AppMethodBeat.o(143222);
        return;
      }
    }
    if (k == this.Lha)
    {
      if (this.Lhd > 20)
      {
        this.GF.setSelection(this.LgZ);
        ae.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
      }
    }
    else
    {
      this.Lhd = 0;
      localView = this.GF.getChildAt(0);
      if (localView != null) {
        break label386;
      }
      AppMethodBeat.o(143222);
      return;
    }
    this.GF.post(this);
    this.Lhd += 1;
    ae.d("ScrollerRunnable", "dz:try scroll firstPos = %d", new Object[] { Integer.valueOf(k) });
    AppMethodBeat.o(143222);
    return;
    label386:
    j = localView.getTop();
    if (k > 0) {}
    for (int i = this.Lhc;; i = this.GF.getPaddingTop())
    {
      this.GF.smoothScrollBy(j - i, this.Lhb);
      this.Lha = k;
      if (k <= this.LgZ) {
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