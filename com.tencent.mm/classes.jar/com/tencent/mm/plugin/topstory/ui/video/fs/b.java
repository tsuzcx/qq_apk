package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.s.a;
import android.support.v7.widget.RecyclerView.s.b;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.ae;
import android.support.v7.widget.aj;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.widget.f;

public final class b
  extends f
{
  private aj aoT;
  private aj aoU;
  
  private static int a(RecyclerView.i parami, View paramView, aj paramaj)
  {
    AppMethodBeat.i(126240);
    int j = paramaj.bn(paramView);
    int k = paramaj.br(paramView) / 2;
    if (parami.getClipToPadding()) {}
    for (int i = paramaj.kl() + paramaj.kn() / 2;; i = paramaj.getEnd() / 2)
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
      j = paramaj.kl() + paramaj.kn() / 2;
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
    if ((this.aoT == null) || (this.aoT.getLayoutManager() != parami)) {
      this.aoT = aj.e(parami);
    }
    parami = this.aoT;
    AppMethodBeat.o(126243);
    return parami;
  }
  
  private aj c(RecyclerView.i parami)
  {
    AppMethodBeat.i(126244);
    if ((this.aoU == null) || (this.aoU.getLayoutManager() != parami)) {
      this.aoU = aj.d(parami);
    }
    parami = this.aoU;
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
    if (parami.jN()) {
      localView = c(parami, b(parami));
    }
    while (localView == null)
    {
      AppMethodBeat.o(126238);
      return -1;
      if (parami.jM()) {
        localView = c(parami, c(parami));
      }
    }
    int j = RecyclerView.i.bB(localView);
    if (j == -1)
    {
      AppMethodBeat.o(126238);
      return -1;
    }
    if (parami.jM()) {
      if (paramInt1 > 0) {
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      paramInt2 = i;
      if ((parami instanceof RecyclerView.s.b))
      {
        parami = ((RecyclerView.s.b)parami).bZ(k - 1);
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
    if (parami.jN())
    {
      parami = a(parami, b(parami));
      AppMethodBeat.o(126237);
      return parami;
    }
    if (parami.jM())
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
    if (parami.jM())
    {
      arrayOfInt[0] = a(parami, paramView, c(parami));
      if (!parami.jN()) {
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
    if (!(parami instanceof RecyclerView.s.b))
    {
      AppMethodBeat.o(126239);
      return null;
    }
    parami = new ae(this.alu.getContext())
    {
      public final float a(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 100.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      public final void a(View paramAnonymousView, RecyclerView.t paramAnonymoust, RecyclerView.s.a paramAnonymousa)
      {
        AppMethodBeat.i(126234);
        paramAnonymousView = b.this.a(b.this.alu.getLayoutManager(), paramAnonymousView);
        int i = paramAnonymousView[0];
        int j = paramAnonymousView[1];
        int k = cd(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0) {
          paramAnonymousa.a(i, j, k, this.TN);
        }
        AppMethodBeat.o(126234);
      }
      
      public final int ce(int paramAnonymousInt)
      {
        AppMethodBeat.i(126235);
        paramAnonymousInt = Math.min(100, super.ce(paramAnonymousInt));
        AppMethodBeat.o(126235);
        return paramAnonymousInt;
      }
    };
    AppMethodBeat.o(126239);
    return parami;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.b
 * JD-Core Version:    0.7.0.1
 */