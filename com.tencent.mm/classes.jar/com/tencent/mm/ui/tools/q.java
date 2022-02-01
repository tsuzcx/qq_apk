package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class q
  implements Runnable
{
  public ListView EO;
  public long ITA;
  public int ITB;
  public int ITC;
  public int ITD;
  private final int ITE;
  public int ITF;
  public int mMode;
  
  public q(ListView paramListView)
  {
    AppMethodBeat.i(143221);
    this.ITA = System.currentTimeMillis();
    this.EO = paramListView;
    this.ITE = ViewConfiguration.get(this.EO.getContext()).getScaledFadingEdgeLength();
    ac.d("ScrollerRunnable", "mExtraScroll: %d", new Object[] { Integer.valueOf(this.ITE) });
    AppMethodBeat.o(143221);
  }
  
  public final void run()
  {
    AppMethodBeat.i(143222);
    if (System.currentTimeMillis() - this.ITA > 10000L)
    {
      AppMethodBeat.o(143222);
      return;
    }
    int j = this.EO.getHeight();
    int k = this.EO.getFirstVisiblePosition();
    View localView;
    switch (this.mMode)
    {
    default: 
      AppMethodBeat.o(143222);
      return;
    case 1: 
      i = this.EO.getChildCount() - 1;
      k += i;
      if (i < 0)
      {
        AppMethodBeat.o(143222);
        return;
      }
      int m;
      int n;
      if (k == this.ITC)
      {
        if (this.ITF > 20)
        {
          this.EO.setSelection(this.ITB);
          ac.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
        }
      }
      else
      {
        this.ITF = 0;
        localView = this.EO.getChildAt(i);
        m = localView.getHeight();
        n = localView.getTop();
        if (k >= this.EO.getCount() - 1) {
          break label271;
        }
      }
      label271:
      for (i = this.ITE;; i = this.EO.getPaddingBottom())
      {
        this.EO.smoothScrollBy(i + (m - (j - n)), this.ITD);
        this.ITC = k;
        if (k >= this.ITB) {
          break;
        }
        this.EO.post(this);
        AppMethodBeat.o(143222);
        return;
        this.EO.post(this);
        this.ITF += 1;
        ac.d("ScrollerRunnable", "dz:try scroll lastpos = %d", new Object[] { Integer.valueOf(k) });
        AppMethodBeat.o(143222);
        return;
      }
    }
    if (k == this.ITC)
    {
      if (this.ITF > 20)
      {
        this.EO.setSelection(this.ITB);
        ac.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
      }
    }
    else
    {
      this.ITF = 0;
      localView = this.EO.getChildAt(0);
      if (localView != null) {
        break label386;
      }
      AppMethodBeat.o(143222);
      return;
    }
    this.EO.post(this);
    this.ITF += 1;
    ac.d("ScrollerRunnable", "dz:try scroll firstPos = %d", new Object[] { Integer.valueOf(k) });
    AppMethodBeat.o(143222);
    return;
    label386:
    j = localView.getTop();
    if (k > 0) {}
    for (int i = this.ITE;; i = this.EO.getPaddingTop())
    {
      this.EO.smoothScrollBy(j - i, this.ITD);
      this.ITC = k;
      if (k <= this.ITB) {
        break;
      }
      this.EO.post(this);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.q
 * JD-Core Version:    0.7.0.1
 */