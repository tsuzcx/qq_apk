package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class q
  implements Runnable
{
  public ListView GP;
  public long QvV;
  public int QvW;
  public int QvX;
  public int QvY;
  private final int QvZ;
  public int Qwa;
  public int mMode;
  
  public q(ListView paramListView)
  {
    AppMethodBeat.i(143221);
    this.QvV = System.currentTimeMillis();
    this.GP = paramListView;
    this.QvZ = ViewConfiguration.get(this.GP.getContext()).getScaledFadingEdgeLength();
    Log.d("ScrollerRunnable", "mExtraScroll: %d", new Object[] { Integer.valueOf(this.QvZ) });
    AppMethodBeat.o(143221);
  }
  
  public final void run()
  {
    AppMethodBeat.i(143222);
    if (System.currentTimeMillis() - this.QvV > 10000L)
    {
      AppMethodBeat.o(143222);
      return;
    }
    int j = this.GP.getHeight();
    int k = this.GP.getFirstVisiblePosition();
    View localView;
    switch (this.mMode)
    {
    default: 
      AppMethodBeat.o(143222);
      return;
    case 1: 
      i = this.GP.getChildCount() - 1;
      k += i;
      if (i < 0)
      {
        AppMethodBeat.o(143222);
        return;
      }
      int m;
      int n;
      if (k == this.QvX)
      {
        if (this.Qwa > 20)
        {
          this.GP.setSelection(this.QvW);
          Log.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
        }
      }
      else
      {
        this.Qwa = 0;
        localView = this.GP.getChildAt(i);
        m = localView.getHeight();
        n = localView.getTop();
        if (k >= this.GP.getCount() - 1) {
          break label271;
        }
      }
      label271:
      for (i = this.QvZ;; i = this.GP.getPaddingBottom())
      {
        this.GP.smoothScrollBy(i + (m - (j - n)), this.QvY);
        this.QvX = k;
        if (k >= this.QvW) {
          break;
        }
        this.GP.post(this);
        AppMethodBeat.o(143222);
        return;
        this.GP.post(this);
        this.Qwa += 1;
        Log.d("ScrollerRunnable", "dz:try scroll lastpos = %d", new Object[] { Integer.valueOf(k) });
        AppMethodBeat.o(143222);
        return;
      }
    }
    if (k == this.QvX)
    {
      if (this.Qwa > 20)
      {
        this.GP.setSelection(this.QvW);
        Log.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
      }
    }
    else
    {
      this.Qwa = 0;
      localView = this.GP.getChildAt(0);
      if (localView != null) {
        break label386;
      }
      AppMethodBeat.o(143222);
      return;
    }
    this.GP.post(this);
    this.Qwa += 1;
    Log.d("ScrollerRunnable", "dz:try scroll firstPos = %d", new Object[] { Integer.valueOf(k) });
    AppMethodBeat.o(143222);
    return;
    label386:
    j = localView.getTop();
    if (k > 0) {}
    for (int i = this.QvZ;; i = this.GP.getPaddingTop())
    {
      this.GP.smoothScrollBy(j - i, this.QvY);
      this.QvX = k;
      if (k <= this.QvW) {
        break;
      }
      this.GP.post(this);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.q
 * JD-Core Version:    0.7.0.1
 */