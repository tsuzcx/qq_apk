package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class p
  implements Runnable
{
  public long AwU;
  public int AwV;
  public int AwW;
  public int AwX;
  private final int AwY;
  public int AwZ;
  public int mMode;
  public ListView xx;
  
  public p(ListView paramListView)
  {
    AppMethodBeat.i(107753);
    this.AwU = System.currentTimeMillis();
    this.xx = paramListView;
    this.AwY = ViewConfiguration.get(this.xx.getContext()).getScaledFadingEdgeLength();
    ab.d("ScrollerRunnable", "mExtraScroll: %d", new Object[] { Integer.valueOf(this.AwY) });
    AppMethodBeat.o(107753);
  }
  
  public final void run()
  {
    AppMethodBeat.i(107754);
    if (System.currentTimeMillis() - this.AwU > 10000L)
    {
      AppMethodBeat.o(107754);
      return;
    }
    int j = this.xx.getHeight();
    int k = this.xx.getFirstVisiblePosition();
    View localView;
    switch (this.mMode)
    {
    default: 
      AppMethodBeat.o(107754);
      return;
    case 1: 
      i = this.xx.getChildCount() - 1;
      k += i;
      if (i < 0)
      {
        AppMethodBeat.o(107754);
        return;
      }
      int m;
      int n;
      if (k == this.AwW)
      {
        if (this.AwZ > 20)
        {
          this.xx.setSelection(this.AwV);
          ab.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
        }
      }
      else
      {
        this.AwZ = 0;
        localView = this.xx.getChildAt(i);
        m = localView.getHeight();
        n = localView.getTop();
        if (k >= this.xx.getCount() - 1) {
          break label271;
        }
      }
      label271:
      for (i = this.AwY;; i = this.xx.getPaddingBottom())
      {
        this.xx.smoothScrollBy(i + (m - (j - n)), this.AwX);
        this.AwW = k;
        if (k >= this.AwV) {
          break;
        }
        this.xx.post(this);
        AppMethodBeat.o(107754);
        return;
        this.xx.post(this);
        this.AwZ += 1;
        ab.d("ScrollerRunnable", "dz:try scroll lastpos = %d", new Object[] { Integer.valueOf(k) });
        AppMethodBeat.o(107754);
        return;
      }
    }
    if (k == this.AwW)
    {
      if (this.AwZ > 20)
      {
        this.xx.setSelection(this.AwV);
        ab.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
      }
    }
    else
    {
      this.AwZ = 0;
      localView = this.xx.getChildAt(0);
      if (localView != null) {
        break label386;
      }
      AppMethodBeat.o(107754);
      return;
    }
    this.xx.post(this);
    this.AwZ += 1;
    ab.d("ScrollerRunnable", "dz:try scroll firstPos = %d", new Object[] { Integer.valueOf(k) });
    AppMethodBeat.o(107754);
    return;
    label386:
    j = localView.getTop();
    if (k > 0) {}
    for (int i = this.AwY;; i = this.xx.getPaddingTop())
    {
      this.xx.smoothScrollBy(j - i, this.AwX);
      this.AwW = k;
      if (k <= this.AwV) {
        break;
      }
      this.xx.post(this);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.p
 * JD-Core Version:    0.7.0.1
 */