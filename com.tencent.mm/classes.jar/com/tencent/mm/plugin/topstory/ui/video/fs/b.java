package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.r.b;
import android.support.v7.widget.af;
import android.support.v7.widget.aj;
import android.view.View;

public final class b
  extends com.tencent.mm.plugin.topstory.ui.a.b
{
  private aj pGJ;
  private aj pGK;
  
  private static int a(RecyclerView.i parami, View paramView, aj paramaj)
  {
    int j = paramaj.aX(paramView);
    int k = paramaj.bb(paramView) / 2;
    if (parami.getClipToPadding()) {}
    for (int i = paramaj.hh() + paramaj.hj() / 2;; i = paramaj.getEnd() / 2) {
      return k + j - i;
    }
  }
  
  private static View a(RecyclerView.i parami, aj paramaj)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int n = parami.getChildCount();
    if (n == 0) {}
    int j;
    int i;
    int k;
    label45:
    do
    {
      return localObject2;
      if (!parami.getClipToPadding()) {
        break;
      }
      j = paramaj.hh() + paramaj.hj() / 2;
      i = 2147483647;
      k = 0;
      localObject2 = localObject1;
    } while (k >= n);
    localObject2 = parami.getChildAt(k);
    int m = Math.abs(paramaj.aX((View)localObject2) + paramaj.bb((View)localObject2) / 2 - j);
    if (m < i)
    {
      localObject1 = localObject2;
      i = m;
    }
    for (;;)
    {
      k += 1;
      break label45;
      j = paramaj.getEnd() / 2;
      break;
    }
  }
  
  private static View b(RecyclerView.i parami, aj paramaj)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int m = parami.getChildCount();
    if (m == 0) {}
    int i;
    int j;
    do
    {
      return localObject2;
      i = 2147483647;
      j = 0;
      localObject2 = localObject1;
    } while (j >= m);
    localObject2 = parami.getChildAt(j);
    int k = paramaj.aX((View)localObject2);
    if (k < i)
    {
      localObject1 = localObject2;
      i = k;
    }
    for (;;)
    {
      j += 1;
      break;
    }
  }
  
  private aj e(RecyclerView.i parami)
  {
    if ((this.pGJ == null) || (this.pGJ.getLayoutManager() != parami)) {
      this.pGJ = aj.b(parami);
    }
    return this.pGJ;
  }
  
  private aj f(RecyclerView.i parami)
  {
    if ((this.pGK == null) || (this.pGK.getLayoutManager() != parami)) {
      this.pGK = aj.a(parami);
    }
    return this.pGK;
  }
  
  public final int a(RecyclerView.i parami, int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((Math.abs(paramInt2) <= 500) || (Math.abs(paramInt1) >= Math.abs(paramInt2))) {}
    int k;
    View localView;
    label58:
    int j;
    do
    {
      do
      {
        return -1;
        k = parami.getItemCount();
      } while (k == 0);
      localView = null;
      if (!parami.gP()) {
        break;
      }
      localView = b(parami, e(parami));
      if (localView == null) {
        break label175;
      }
      j = RecyclerView.i.bl(localView);
    } while (j == -1);
    if (parami.gO()) {
      if (paramInt1 > 0) {
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      paramInt2 = i;
      if ((parami instanceof RecyclerView.r.b))
      {
        parami = ((RecyclerView.r.b)parami).bD(k - 1);
        paramInt2 = i;
        if (parami != null) {
          if (parami.x >= 0.0F)
          {
            paramInt2 = i;
            if (parami.y >= 0.0F) {}
          }
          else
          {
            paramInt2 = 1;
          }
        }
      }
      if (paramInt2 == 0) {
        break label199;
      }
      if (paramInt1 == 0) {
        break label196;
      }
      return j - 1;
      if (!parami.gO()) {
        break label58;
      }
      localView = b(parami, f(parami));
      break label58;
      label175:
      break;
      paramInt1 = 0;
      continue;
      if (paramInt2 > 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
    }
    label196:
    return j;
    label199:
    if (paramInt1 != 0) {
      return j + 1;
    }
    return j;
  }
  
  public final int[] a(RecyclerView.i parami, View paramView)
  {
    int[] arrayOfInt = new int[2];
    if (parami.gO()) {
      arrayOfInt[0] = a(parami, paramView, f(parami));
    }
    while (parami.gP())
    {
      arrayOfInt[1] = a(parami, paramView, e(parami));
      return arrayOfInt;
      arrayOfInt[0] = 0;
    }
    arrayOfInt[1] = 0;
    return arrayOfInt;
  }
  
  public final View c(RecyclerView.i parami)
  {
    if (parami.gP()) {
      return a(parami, e(parami));
    }
    if (parami.gO()) {
      return a(parami, f(parami));
    }
    return null;
  }
  
  protected final af d(RecyclerView.i parami)
  {
    if (!(parami instanceof RecyclerView.r.b)) {
      return null;
    }
    return new b.1(this, this.acI.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.b
 * JD-Core Version:    0.7.0.1
 */