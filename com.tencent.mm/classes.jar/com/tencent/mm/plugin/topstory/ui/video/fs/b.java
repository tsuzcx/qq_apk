package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.r.a;
import androidx.recyclerview.widget.RecyclerView.r.b;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.p;
import androidx.recyclerview.widget.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.widget.f;

public final class b
  extends f
{
  private u ajA;
  private u ajz;
  
  private static int a(RecyclerView.LayoutManager paramLayoutManager, View paramView, u paramu)
  {
    AppMethodBeat.i(205941);
    int j = paramu.aZ(paramView);
    int k = paramu.bd(paramView) / 2;
    if (paramLayoutManager.getClipToPadding()) {}
    for (int i = paramu.kT() + paramu.kV() / 2;; i = paramu.getEnd() / 2)
    {
      AppMethodBeat.o(205941);
      return k + j - i;
    }
  }
  
  private static View a(RecyclerView.LayoutManager paramLayoutManager, u paramu)
  {
    Object localObject = null;
    AppMethodBeat.i(205942);
    int n = paramLayoutManager.getChildCount();
    if (n == 0)
    {
      AppMethodBeat.o(205942);
      return null;
    }
    int j;
    int k;
    if (paramLayoutManager.getClipToPadding())
    {
      j = paramu.kT() + paramu.kV() / 2;
      int i = 2147483647;
      k = 0;
      label51:
      if (k >= n) {
        break label120;
      }
      View localView = paramLayoutManager.getChildAt(k);
      int m = Math.abs(paramu.aZ(localView) + paramu.bd(localView) / 2 - j);
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
      j = paramu.getEnd() / 2;
      break;
      label120:
      AppMethodBeat.o(205942);
      return localObject;
    }
  }
  
  private u b(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(205944);
    if ((this.ajz == null) || (this.ajz.getLayoutManager() != paramLayoutManager)) {
      this.ajz = u.e(paramLayoutManager);
    }
    paramLayoutManager = this.ajz;
    AppMethodBeat.o(205944);
    return paramLayoutManager;
  }
  
  private static View c(RecyclerView.LayoutManager paramLayoutManager, u paramu)
  {
    Object localObject = null;
    AppMethodBeat.i(205943);
    int m = paramLayoutManager.getChildCount();
    if (m == 0)
    {
      AppMethodBeat.o(205943);
      return null;
    }
    int i = 2147483647;
    int j = 0;
    if (j < m)
    {
      View localView = paramLayoutManager.getChildAt(j);
      int k = paramu.aZ(localView);
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
      AppMethodBeat.o(205943);
      return localObject;
    }
  }
  
  private u c(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(205945);
    if ((this.ajA == null) || (this.ajA.getLayoutManager() != paramLayoutManager)) {
      this.ajA = u.d(paramLayoutManager);
    }
    paramLayoutManager = this.ajA;
    AppMethodBeat.o(205945);
    return paramLayoutManager;
  }
  
  public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(205939);
    if ((Math.abs(paramInt2) <= 500) || (Math.abs(paramInt1) >= Math.abs(paramInt2)))
    {
      AppMethodBeat.o(205939);
      return -1;
    }
    int k = paramLayoutManager.getItemCount();
    if (k == 0)
    {
      AppMethodBeat.o(205939);
      return -1;
    }
    View localView = null;
    if (paramLayoutManager.canScrollVertically()) {
      localView = c(paramLayoutManager, b(paramLayoutManager));
    }
    while (localView == null)
    {
      AppMethodBeat.o(205939);
      return -1;
      if (paramLayoutManager.canScrollHorizontally()) {
        localView = c(paramLayoutManager, c(paramLayoutManager));
      }
    }
    int j = paramLayoutManager.getPosition(localView);
    if (j == -1)
    {
      AppMethodBeat.o(205939);
      return -1;
    }
    if (paramLayoutManager.canScrollHorizontally()) {
      if (paramInt1 > 0) {
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      paramInt2 = i;
      if ((paramLayoutManager instanceof RecyclerView.r.b))
      {
        paramLayoutManager = ((RecyclerView.r.b)paramLayoutManager).cB(k - 1);
        paramInt2 = i;
        if (paramLayoutManager != null) {
          if (paramLayoutManager.x >= 0.0F)
          {
            paramInt2 = i;
            if (paramLayoutManager.y >= 0.0F) {}
          }
          else
          {
            paramInt2 = 1;
          }
        }
      }
      if (paramInt2 == 0) {
        break label241;
      }
      if (paramInt1 == 0) {
        break;
      }
      AppMethodBeat.o(205939);
      return j - 1;
      paramInt1 = 0;
      continue;
      if (paramInt2 > 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
    }
    AppMethodBeat.o(205939);
    return j;
    label241:
    if (paramInt1 != 0)
    {
      AppMethodBeat.o(205939);
      return j + 1;
    }
    AppMethodBeat.o(205939);
    return j;
  }
  
  public final View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(205938);
    if (paramLayoutManager.canScrollVertically())
    {
      paramLayoutManager = a(paramLayoutManager, b(paramLayoutManager));
      AppMethodBeat.o(205938);
      return paramLayoutManager;
    }
    if (paramLayoutManager.canScrollHorizontally())
    {
      paramLayoutManager = a(paramLayoutManager, c(paramLayoutManager));
      AppMethodBeat.o(205938);
      return paramLayoutManager;
    }
    AppMethodBeat.o(205938);
    return null;
  }
  
  public final int[] a(RecyclerView.LayoutManager paramLayoutManager, View paramView)
  {
    AppMethodBeat.i(205937);
    int[] arrayOfInt = new int[2];
    if (paramLayoutManager.canScrollHorizontally())
    {
      arrayOfInt[0] = a(paramLayoutManager, paramView, c(paramLayoutManager));
      if (!paramLayoutManager.canScrollVertically()) {
        break label63;
      }
      arrayOfInt[1] = a(paramLayoutManager, paramView, b(paramLayoutManager));
    }
    for (;;)
    {
      AppMethodBeat.o(205937);
      return arrayOfInt;
      arrayOfInt[0] = 0;
      break;
      label63:
      arrayOfInt[1] = 0;
    }
  }
  
  public final p f(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(205940);
    if (!(paramLayoutManager instanceof RecyclerView.r.b))
    {
      AppMethodBeat.o(205940);
      return null;
    }
    paramLayoutManager = new p(this.mRecyclerView.getContext())
    {
      public final float a(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 100.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      public final void a(View paramAnonymousView, RecyclerView.s paramAnonymouss, RecyclerView.r.a paramAnonymousa)
      {
        AppMethodBeat.i(204808);
        paramAnonymousView = b.this.a(b.a(b.this).getLayoutManager(), paramAnonymousView);
        int i = paramAnonymousView[0];
        int j = paramAnonymousView[1];
        int k = cE(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0) {
          paramAnonymousa.a(i, j, k, this.aju);
        }
        AppMethodBeat.o(204808);
      }
      
      public final int cF(int paramAnonymousInt)
      {
        AppMethodBeat.i(126235);
        paramAnonymousInt = Math.min(100, super.cF(paramAnonymousInt));
        AppMethodBeat.o(126235);
        return paramAnonymousInt;
      }
    };
    AppMethodBeat.o(205940);
    return paramLayoutManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.b
 * JD-Core Version:    0.7.0.1
 */