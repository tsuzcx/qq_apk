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
import androidx.recyclerview.widget.o;
import androidx.recyclerview.widget.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.widget.f;

public final class b
  extends f
{
  private s bYd;
  private s bYe;
  
  private static int a(RecyclerView.LayoutManager paramLayoutManager, View paramView, s params)
  {
    AppMethodBeat.i(271805);
    int j = params.bs(paramView);
    int k = params.bw(paramView) / 2;
    if (paramLayoutManager.getClipToPadding()) {}
    for (int i = params.JE() + params.JG() / 2;; i = params.getEnd() / 2)
    {
      AppMethodBeat.o(271805);
      return k + j - i;
    }
  }
  
  private static View a(RecyclerView.LayoutManager paramLayoutManager, s params)
  {
    Object localObject = null;
    AppMethodBeat.i(271807);
    int n = paramLayoutManager.getChildCount();
    if (n == 0)
    {
      AppMethodBeat.o(271807);
      return null;
    }
    int j;
    int k;
    if (paramLayoutManager.getClipToPadding())
    {
      j = params.JE() + params.JG() / 2;
      int i = 2147483647;
      k = 0;
      label51:
      if (k >= n) {
        break label120;
      }
      View localView = paramLayoutManager.getChildAt(k);
      int m = Math.abs(params.bs(localView) + params.bw(localView) / 2 - j);
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
      j = params.getEnd() / 2;
      break;
      label120:
      AppMethodBeat.o(271807);
      return localObject;
    }
  }
  
  private s b(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(271811);
    if ((this.bYd == null) || (this.bYd.getLayoutManager() != paramLayoutManager)) {
      this.bYd = s.e(paramLayoutManager);
    }
    paramLayoutManager = this.bYd;
    AppMethodBeat.o(271811);
    return paramLayoutManager;
  }
  
  private static View c(RecyclerView.LayoutManager paramLayoutManager, s params)
  {
    Object localObject = null;
    AppMethodBeat.i(271809);
    int m = paramLayoutManager.getChildCount();
    if (m == 0)
    {
      AppMethodBeat.o(271809);
      return null;
    }
    int i = 2147483647;
    int j = 0;
    if (j < m)
    {
      View localView = paramLayoutManager.getChildAt(j);
      int k = params.bs(localView);
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
      AppMethodBeat.o(271809);
      return localObject;
    }
  }
  
  private s c(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(271813);
    if ((this.bYe == null) || (this.bYe.getLayoutManager() != paramLayoutManager)) {
      this.bYe = s.d(paramLayoutManager);
    }
    paramLayoutManager = this.bYe;
    AppMethodBeat.o(271813);
    return paramLayoutManager;
  }
  
  public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(271818);
    if ((Math.abs(paramInt2) <= 500) || (Math.abs(paramInt1) >= Math.abs(paramInt2)))
    {
      AppMethodBeat.o(271818);
      return -1;
    }
    int k = paramLayoutManager.getItemCount();
    if (k == 0)
    {
      AppMethodBeat.o(271818);
      return -1;
    }
    View localView = null;
    if (paramLayoutManager.canScrollVertically()) {
      localView = c(paramLayoutManager, b(paramLayoutManager));
    }
    while (localView == null)
    {
      AppMethodBeat.o(271818);
      return -1;
      if (paramLayoutManager.canScrollHorizontally()) {
        localView = c(paramLayoutManager, c(paramLayoutManager));
      }
    }
    int j = paramLayoutManager.getPosition(localView);
    if (j == -1)
    {
      AppMethodBeat.o(271818);
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
        paramLayoutManager = ((RecyclerView.r.b)paramLayoutManager).fM(k - 1);
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
      AppMethodBeat.o(271818);
      return j - 1;
      paramInt1 = 0;
      continue;
      if (paramInt2 > 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
    }
    AppMethodBeat.o(271818);
    return j;
    label241:
    if (paramInt1 != 0)
    {
      AppMethodBeat.o(271818);
      return j + 1;
    }
    AppMethodBeat.o(271818);
    return j;
  }
  
  public final View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(271816);
    if (paramLayoutManager.canScrollVertically())
    {
      paramLayoutManager = a(paramLayoutManager, b(paramLayoutManager));
      AppMethodBeat.o(271816);
      return paramLayoutManager;
    }
    if (paramLayoutManager.canScrollHorizontally())
    {
      paramLayoutManager = a(paramLayoutManager, c(paramLayoutManager));
      AppMethodBeat.o(271816);
      return paramLayoutManager;
    }
    AppMethodBeat.o(271816);
    return null;
  }
  
  public final int[] a(RecyclerView.LayoutManager paramLayoutManager, View paramView)
  {
    AppMethodBeat.i(271815);
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
      AppMethodBeat.o(271815);
      return arrayOfInt;
      arrayOfInt[0] = 0;
      break;
      label63:
      arrayOfInt[1] = 0;
    }
  }
  
  public final o f(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(271819);
    if (!(paramLayoutManager instanceof RecyclerView.r.b))
    {
      AppMethodBeat.o(271819);
      return null;
    }
    paramLayoutManager = new o(this.mRecyclerView.getContext())
    {
      public final void a(View paramAnonymousView, RecyclerView.s paramAnonymouss, RecyclerView.r.a paramAnonymousa)
      {
        AppMethodBeat.i(271817);
        paramAnonymousView = b.this.a(b.a(b.this).getLayoutManager(), paramAnonymousView);
        int i = paramAnonymousView[0];
        int j = paramAnonymousView[1];
        int k = fO(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0) {
          paramAnonymousa.a(i, j, k, this.bXY);
        }
        AppMethodBeat.o(271817);
      }
      
      public final float c(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 100.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      public final int fP(int paramAnonymousInt)
      {
        AppMethodBeat.i(126235);
        paramAnonymousInt = Math.min(100, super.fP(paramAnonymousInt));
        AppMethodBeat.o(126235);
        return paramAnonymousInt;
      }
    };
    AppMethodBeat.o(271819);
    return paramLayoutManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.b
 * JD-Core Version:    0.7.0.1
 */