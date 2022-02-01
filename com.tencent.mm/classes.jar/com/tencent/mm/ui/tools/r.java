package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class r
  implements Runnable
{
  public long XTY;
  public int XTZ;
  public int XUa;
  public int XUb;
  private final int XUc;
  public int XUd;
  public ListView Xc;
  public int mMode;
  
  public r(ListView paramListView)
  {
    AppMethodBeat.i(143221);
    this.XTY = System.currentTimeMillis();
    this.Xc = paramListView;
    this.XUc = ViewConfiguration.get(this.Xc.getContext()).getScaledFadingEdgeLength();
    Log.d("ScrollerRunnable", "mExtraScroll: %d", new Object[] { Integer.valueOf(this.XUc) });
    AppMethodBeat.o(143221);
  }
  
  public final void run()
  {
    AppMethodBeat.i(143222);
    if (System.currentTimeMillis() - this.XTY > 10000L)
    {
      AppMethodBeat.o(143222);
      return;
    }
    int j = this.Xc.getHeight();
    int k = this.Xc.getFirstVisiblePosition();
    View localView;
    switch (this.mMode)
    {
    default: 
      AppMethodBeat.o(143222);
      return;
    case 1: 
      i = this.Xc.getChildCount() - 1;
      k += i;
      if (i < 0)
      {
        AppMethodBeat.o(143222);
        return;
      }
      int m;
      int n;
      if (k == this.XUa)
      {
        if (this.XUd > 20)
        {
          this.Xc.setSelection(this.XTZ);
          Log.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
        }
      }
      else
      {
        this.XUd = 0;
        localView = this.Xc.getChildAt(i);
        m = localView.getHeight();
        n = localView.getTop();
        if (k >= this.Xc.getCount() - 1) {
          break label271;
        }
      }
      label271:
      for (i = this.XUc;; i = this.Xc.getPaddingBottom())
      {
        this.Xc.smoothScrollBy(i + (m - (j - n)), this.XUb);
        this.XUa = k;
        if (k >= this.XTZ) {
          break;
        }
        this.Xc.post(this);
        AppMethodBeat.o(143222);
        return;
        this.Xc.post(this);
        this.XUd += 1;
        Log.d("ScrollerRunnable", "dz:try scroll lastpos = %d", new Object[] { Integer.valueOf(k) });
        AppMethodBeat.o(143222);
        return;
      }
    }
    if (k == this.XUa)
    {
      if (this.XUd > 20)
      {
        this.Xc.setSelection(this.XTZ);
        Log.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
      }
    }
    else
    {
      this.XUd = 0;
      localView = this.Xc.getChildAt(0);
      if (localView != null) {
        break label386;
      }
      AppMethodBeat.o(143222);
      return;
    }
    this.Xc.post(this);
    this.XUd += 1;
    Log.d("ScrollerRunnable", "dz:try scroll firstPos = %d", new Object[] { Integer.valueOf(k) });
    AppMethodBeat.o(143222);
    return;
    label386:
    j = localView.getTop();
    if (k > 0) {}
    for (int i = this.XUc;; i = this.Xc.getPaddingTop())
    {
      this.Xc.smoothScrollBy(j - i, this.XUb);
      this.XUa = k;
      if (k <= this.XTZ) {
        break;
      }
      this.Xc.post(this);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.r
 * JD-Core Version:    0.7.0.1
 */