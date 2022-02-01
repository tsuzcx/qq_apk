package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.r.b;
import android.support.v7.widget.ae;
import android.support.v7.widget.aj;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.widget.f;

public final class b
  extends f
{
  private aj anY;
  private aj anZ;
  
  private static int a(RecyclerView.i parami, View paramView, aj paramaj)
  {
    AppMethodBeat.i(126240);
    int j = paramaj.bn(paramView);
    int k = paramaj.br(paramView) / 2;
    if (parami.getClipToPadding()) {}
    for (int i = paramaj.kd() + paramaj.kf() / 2;; i = paramaj.getEnd() / 2)
    {
      AppMethodBeat.o(126240);
      return k + j - i;
    }
  }
  
  private static View a(RecyclerView.i parami, aj paramaj)
  {
    Object localObject = null;
    AppMethodBeat.i(126241);
    int n = parami.getChildCount();
    if (n == 0)
    {
      AppMethodBeat.o(126241);
      return null;
    }
    int j;
    int k;
    if (parami.getClipToPadding())
    {
      j = paramaj.kd() + paramaj.kf() / 2;
      int i = 2147483647;
      k = 0;
      label51:
      if (k >= n) {
        break label120;
      }
      View localView = parami.getChildAt(k);
      int m = Math.abs(paramaj.bn(localView) + paramaj.br(localView) / 2 - j);
      if (m >= i) {
        break label128;
      }
      localObject = localView;
      i = m;
    }
    label128:
    for (;;)
    {
      k += 1;
      break label51;
      j = paramaj.getEnd() / 2;
      break;
      label120:
      AppMethodBeat.o(126241);
      return localObject;
    }
  }
  
  private aj b(RecyclerView.i parami)
  {
    AppMethodBeat.i(126243);
    if ((this.anY == null) || (this.anY.getLayoutManager() != parami)) {
      this.anY = aj.e(parami);
    }
    parami = this.anY;
    AppMethodBeat.o(126243);
    return parami;
  }
  
  private aj c(RecyclerView.i parami)
  {
    AppMethodBeat.i(126244);
    if ((this.anZ == null) || (this.anZ.getLayoutManager() != parami)) {
      this.anZ = aj.d(parami);
    }
    parami = this.anZ;
    AppMethodBeat.o(126244);
    return parami;
  }
  
  private static View c(RecyclerView.i parami, aj paramaj)
  {
    Object localObject = null;
    AppMethodBeat.i(126242);
    int m = parami.getChildCount();
    if (m == 0)
    {
      AppMethodBeat.o(126242);
      return null;
    }
    int i = 2147483647;
    int j = 0;
    if (j < m)
    {
      View localView = parami.getChildAt(j);
      int k = paramaj.bn(localView);
      if (k >= i) {
        break label80;
      }
      localObject = localView;
      i = k;
    }
    label80:
    for (;;)
    {
      j += 1;
      break;
      AppMethodBeat.o(126242);
      return localObject;
    }
  }
  
  public final int a(RecyclerView.i parami, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(126238);
    if ((Math.abs(paramInt2) <= 500) || (Math.abs(paramInt1) >= Math.abs(paramInt2)))
    {
      AppMethodBeat.o(126238);
      return -1;
    }
    int k = parami.getItemCount();
    if (k == 0)
    {
      AppMethodBeat.o(126238);
      return -1;
    }
    View localView = null;
    if (parami.jF()) {
      localView = c(parami, b(parami));
    }
    while (localView == null)
    {
      AppMethodBeat.o(126238);
      return -1;
      if (parami.jE()) {
        localView = c(parami, c(parami));
      }
    }
    int j = RecyclerView.i.bB(localView);
    if (j == -1)
    {
      AppMethodBeat.o(126238);
      return -1;
    }
    if (parami.jE()) {
      if (paramInt1 > 0) {
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      paramInt2 = i;
      if ((parami instanceof RecyclerView.r.b))
      {
        parami = ((RecyclerView.r.b)parami).bZ(k - 1);
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
        break label240;
      }
      if (paramInt1 == 0) {
        break;
      }
      AppMethodBeat.o(126238);
      return j - 1;
      paramInt1 = 0;
      continue;
      if (paramInt2 > 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
    }
    AppMethodBeat.o(126238);
    return j;
    label240:
    if (paramInt1 != 0)
    {
      AppMethodBeat.o(126238);
      return j + 1;
    }
    AppMethodBeat.o(126238);
    return j;
  }
  
  public final View a(RecyclerView.i parami)
  {
    AppMethodBeat.i(126237);
    if (parami.jF())
    {
      parami = a(parami, b(parami));
      AppMethodBeat.o(126237);
      return parami;
    }
    if (parami.jE())
    {
      parami = a(parami, c(parami));
      AppMethodBeat.o(126237);
      return parami;
    }
    AppMethodBeat.o(126237);
    return null;
  }
  
  public final int[] a(RecyclerView.i parami, View paramView)
  {
    AppMethodBeat.i(126236);
    int[] arrayOfInt = new int[2];
    if (parami.jE())
    {
      arrayOfInt[0] = a(parami, paramView, c(parami));
      if (!parami.jF()) {
        break label63;
      }
      arrayOfInt[1] = a(parami, paramView, b(parami));
    }
    for (;;)
    {
      AppMethodBeat.o(126236);
      return arrayOfInt;
      arrayOfInt[0] = 0;
      break;
      label63:
      arrayOfInt[1] = 0;
    }
  }
  
  public final ae f(RecyclerView.i parami)
  {
    AppMethodBeat.i(126239);
    if (!(parami instanceof RecyclerView.r.b))
    {
      AppMethodBeat.o(126239);
      return null;
    }
    parami = new b.1(this, this.akA.getContext());
    AppMethodBeat.o(126239);
    return parami;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.b
 * JD-Core Version:    0.7.0.1
 */