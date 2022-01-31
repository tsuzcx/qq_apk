package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.r.b;
import android.support.v7.widget.ae;
import android.support.v7.widget.aj;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.widget.e;

public final class b
  extends e
{
  private aj agR;
  private aj agS;
  
  private static int a(RecyclerView.i parami, View paramView, aj paramaj)
  {
    AppMethodBeat.i(1866);
    int j = paramaj.bh(paramView);
    int k = paramaj.bl(paramView) / 2;
    if (parami.getClipToPadding()) {}
    for (int i = paramaj.iI() + paramaj.iK() / 2;; i = paramaj.getEnd() / 2)
    {
      AppMethodBeat.o(1866);
      return k + j - i;
    }
  }
  
  private static View a(RecyclerView.i parami, aj paramaj)
  {
    Object localObject = null;
    AppMethodBeat.i(1867);
    int n = parami.getChildCount();
    if (n == 0)
    {
      AppMethodBeat.o(1867);
      return null;
    }
    int j;
    int k;
    if (parami.getClipToPadding())
    {
      j = paramaj.iI() + paramaj.iK() / 2;
      int i = 2147483647;
      k = 0;
      label53:
      if (k >= n) {
        break label122;
      }
      View localView = parami.getChildAt(k);
      int m = Math.abs(paramaj.bh(localView) + paramaj.bl(localView) / 2 - j);
      if (m >= i) {
        break label131;
      }
      localObject = localView;
      i = m;
    }
    label131:
    for (;;)
    {
      k += 1;
      break label53;
      j = paramaj.getEnd() / 2;
      break;
      label122:
      AppMethodBeat.o(1867);
      return localObject;
    }
  }
  
  private aj b(RecyclerView.i parami)
  {
    AppMethodBeat.i(1869);
    if ((this.agR == null) || (this.agR.getLayoutManager() != parami)) {
      this.agR = aj.e(parami);
    }
    parami = this.agR;
    AppMethodBeat.o(1869);
    return parami;
  }
  
  private aj c(RecyclerView.i parami)
  {
    AppMethodBeat.i(1870);
    if ((this.agS == null) || (this.agS.getLayoutManager() != parami)) {
      this.agS = aj.d(parami);
    }
    parami = this.agS;
    AppMethodBeat.o(1870);
    return parami;
  }
  
  private static View c(RecyclerView.i parami, aj paramaj)
  {
    Object localObject = null;
    AppMethodBeat.i(1868);
    int m = parami.getChildCount();
    if (m == 0)
    {
      AppMethodBeat.o(1868);
      return null;
    }
    int i = 2147483647;
    int j = 0;
    if (j < m)
    {
      View localView = parami.getChildAt(j);
      int k = paramaj.bh(localView);
      if (k >= i) {
        break label83;
      }
      localObject = localView;
      i = k;
    }
    label83:
    for (;;)
    {
      j += 1;
      break;
      AppMethodBeat.o(1868);
      return localObject;
    }
  }
  
  public final int a(RecyclerView.i parami, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(1864);
    if ((Math.abs(paramInt2) <= 500) || (Math.abs(paramInt1) >= Math.abs(paramInt2)))
    {
      AppMethodBeat.o(1864);
      return -1;
    }
    int k = parami.getItemCount();
    if (k == 0)
    {
      AppMethodBeat.o(1864);
      return -1;
    }
    View localView = null;
    if (parami.ik()) {
      localView = c(parami, b(parami));
    }
    while (localView == null)
    {
      AppMethodBeat.o(1864);
      return -1;
      if (parami.ij()) {
        localView = c(parami, c(parami));
      }
    }
    int j = RecyclerView.i.bv(localView);
    if (j == -1)
    {
      AppMethodBeat.o(1864);
      return -1;
    }
    if (parami.ij()) {
      if (paramInt1 > 0) {
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      paramInt2 = i;
      if ((parami instanceof RecyclerView.r.b))
      {
        parami = ((RecyclerView.r.b)parami).bI(k - 1);
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
        break label247;
      }
      if (paramInt1 == 0) {
        break;
      }
      AppMethodBeat.o(1864);
      return j - 1;
      paramInt1 = 0;
      continue;
      if (paramInt2 > 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
    }
    AppMethodBeat.o(1864);
    return j;
    label247:
    if (paramInt1 != 0)
    {
      AppMethodBeat.o(1864);
      return j + 1;
    }
    AppMethodBeat.o(1864);
    return j;
  }
  
  public final View a(RecyclerView.i parami)
  {
    AppMethodBeat.i(1863);
    if (parami.ik())
    {
      parami = a(parami, b(parami));
      AppMethodBeat.o(1863);
      return parami;
    }
    if (parami.ij())
    {
      parami = a(parami, c(parami));
      AppMethodBeat.o(1863);
      return parami;
    }
    AppMethodBeat.o(1863);
    return null;
  }
  
  public final int[] a(RecyclerView.i parami, View paramView)
  {
    AppMethodBeat.i(1862);
    int[] arrayOfInt = new int[2];
    if (parami.ij())
    {
      arrayOfInt[0] = a(parami, paramView, c(parami));
      if (!parami.ik()) {
        break label65;
      }
      arrayOfInt[1] = a(parami, paramView, b(parami));
    }
    for (;;)
    {
      AppMethodBeat.o(1862);
      return arrayOfInt;
      arrayOfInt[0] = 0;
      break;
      label65:
      arrayOfInt[1] = 0;
    }
  }
  
  public final ae f(RecyclerView.i parami)
  {
    AppMethodBeat.i(1865);
    if (!(parami instanceof RecyclerView.r.b))
    {
      AppMethodBeat.o(1865);
      return null;
    }
    parami = new b.1(this, this.adt.getContext());
    AppMethodBeat.o(1865);
    return parami;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.b
 * JD-Core Version:    0.7.0.1
 */