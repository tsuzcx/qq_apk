package com.tencent.mm.plugin.topstory.ui.video.list;

import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.r.b;
import android.support.v7.widget.af;
import android.support.v7.widget.aj;
import android.view.View;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends com.tencent.mm.plugin.topstory.ui.a.b
{
  com.tencent.mm.plugin.topstory.ui.video.b pEp;
  private aj pGJ;
  private aj pGK;
  
  public c(com.tencent.mm.plugin.topstory.ui.video.b paramb)
  {
    this.pEp = paramb;
  }
  
  private int a(View paramView, aj paramaj)
  {
    return paramaj.aX(paramView) - this.pEp.bNG();
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
    if ((Math.abs(paramInt2) <= 500) || (Math.abs(paramInt1) >= Math.abs(paramInt2))) {}
    int j;
    int i;
    do
    {
      do
      {
        return -1;
        j = parami.getItemCount();
      } while (j == 0);
      i = this.pEp.bNB() + 1;
    } while (i == -1);
    boolean bool;
    if (parami.gO()) {
      if (paramInt1 > 0)
      {
        bool = true;
        if (!(parami instanceof RecyclerView.r.b)) {
          break label234;
        }
        parami = ((RecyclerView.r.b)parami).bD(j - 1);
        if (parami == null) {
          break label234;
        }
        if ((parami.x >= 0.0F) && (parami.y >= 0.0F)) {
          break label208;
        }
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      label112:
      if (paramInt1 != 0)
      {
        if (bool) {
          break label226;
        }
        paramInt1 = i + 1;
      }
      for (;;)
      {
        y.i("MicroMsg.TopStory.TopStoryVideoPagerSnapHelper", "findTargetSnapPosition velocityY: %d centerPosition: %d forwardDirection: %b result: %d currentPlayPos: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(this.pEp.bNB() + 1) });
        return paramInt1;
        bool = false;
        break;
        if (paramInt2 > 0)
        {
          bool = true;
          break;
        }
        bool = false;
        break;
        label208:
        paramInt1 = 0;
        break label112;
        if (bool) {
          paramInt1 = i + 1;
        } else {
          label226:
          paramInt1 = i - 1;
        }
      }
      label234:
      paramInt1 = 0;
    }
  }
  
  public final int[] a(RecyclerView.i parami, View paramView)
  {
    int[] arrayOfInt = new int[2];
    if (parami.gO()) {
      arrayOfInt[0] = a(paramView, f(parami));
    }
    while (parami.gP())
    {
      arrayOfInt[1] = a(paramView, e(parami));
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
    return new c.1(this, this.acI.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.c
 * JD-Core Version:    0.7.0.1
 */