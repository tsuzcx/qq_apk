package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.y;

public final class m
  implements Runnable
{
  public int mMode;
  public ListView mQH;
  public long wee = System.currentTimeMillis();
  public int wef;
  public int weg;
  public int weh;
  private final int wei;
  public int wej;
  
  public m(ListView paramListView)
  {
    this.mQH = paramListView;
    this.wei = ViewConfiguration.get(this.mQH.getContext()).getScaledFadingEdgeLength();
    y.d("ScrollerRunnable", "mExtraScroll: %d", new Object[] { Integer.valueOf(this.wei) });
  }
  
  public final void run()
  {
    if (System.currentTimeMillis() - this.wee > 10000L) {}
    int k;
    View localView;
    label242:
    do
    {
      do
      {
        return;
        j = this.mQH.getHeight();
        k = this.mQH.getFirstVisiblePosition();
        switch (this.mMode)
        {
        default: 
          return;
        case 1: 
          i = this.mQH.getChildCount() - 1;
          k += i;
        }
      } while (i < 0);
      int m;
      int n;
      if (k == this.weg)
      {
        if (this.wej > 20)
        {
          this.mQH.setSelection(this.wef);
          y.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
        }
      }
      else
      {
        this.wej = 0;
        localView = this.mQH.getChildAt(i);
        m = localView.getHeight();
        n = localView.getTop();
        if (k >= this.mQH.getCount() - 1) {
          break label242;
        }
      }
      for (i = this.wei;; i = this.mQH.getPaddingBottom())
      {
        this.mQH.smoothScrollBy(i + (m - (j - n)), this.weh);
        this.weg = k;
        if (k >= this.wef) {
          break;
        }
        this.mQH.post(this);
        return;
        this.mQH.post(this);
        this.wej += 1;
        y.d("ScrollerRunnable", "dz:try scroll lastpos = %d", new Object[] { Integer.valueOf(k) });
        return;
      }
      if (k == this.weg)
      {
        if (this.wej <= 20) {
          break;
        }
        this.mQH.setSelection(this.wef);
        y.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
      }
      this.wej = 0;
      localView = this.mQH.getChildAt(0);
    } while (localView == null);
    int j = localView.getTop();
    if (k > 0) {}
    for (int i = this.wei;; i = this.mQH.getPaddingTop())
    {
      this.mQH.smoothScrollBy(j - i, this.weh);
      this.weg = k;
      if (k <= this.wef) {
        break;
      }
      this.mQH.post(this);
      return;
      this.mQH.post(this);
      this.wej += 1;
      y.d("ScrollerRunnable", "dz:try scroll firstPos = %d", new Object[] { Integer.valueOf(k) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.m
 * JD-Core Version:    0.7.0.1
 */