package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.r.a;
import android.support.v7.widget.RecyclerView.r.b;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.ae;
import android.support.v7.widget.aj;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.widget.f;

public final class b
  extends f
{
  private aj aqX;
  private aj aqY;
  
  private static int a(RecyclerView.LayoutManager paramLayoutManager, View paramView, aj paramaj)
  {
    AppMethodBeat.i(126240);
    int j = paramaj.bo(paramView);
    int k = paramaj.bs(paramView) / 2;
    if (paramLayoutManager.getClipToPadding()) {}
    for (int i = paramaj.kH() + paramaj.kJ() / 2;; i = paramaj.getEnd() / 2)
    {
      AppMethodBeat.o(126240);
      return k + j - i;
    }
  }
  
  private static View a(RecyclerView.LayoutManager paramLayoutManager, aj paramaj)
  {
    Object localObject = null;
    AppMethodBeat.i(126241);
    int n = paramLayoutManager.getChildCount();
    if (n == 0)
    {
      AppMethodBeat.o(126241);
      return null;
    }
    int j;
    int k;
    if (paramLayoutManager.getClipToPadding())
    {
      j = paramaj.kH() + paramaj.kJ() / 2;
      int i = 2147483647;
      k = 0;
      label51:
      if (k >= n) {
        break label120;
      }
      View localView = paramLayoutManager.getChildAt(k);
      int m = Math.abs(paramaj.bo(localView) + paramaj.bs(localView) / 2 - j);
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
  
  private aj b(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(126243);
    if ((this.aqX == null) || (this.aqX.getLayoutManager() != paramLayoutManager)) {
      this.aqX = aj.e(paramLayoutManager);
    }
    paramLayoutManager = this.aqX;
    AppMethodBeat.o(126243);
    return paramLayoutManager;
  }
  
  private aj c(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(126244);
    if ((this.aqY == null) || (this.aqY.getLayoutManager() != paramLayoutManager)) {
      this.aqY = aj.d(paramLayoutManager);
    }
    paramLayoutManager = this.aqY;
    AppMethodBeat.o(126244);
    return paramLayoutManager;
  }
  
  private static View c(RecyclerView.LayoutManager paramLayoutManager, aj paramaj)
  {
    Object localObject = null;
    AppMethodBeat.i(126242);
    int m = paramLayoutManager.getChildCount();
    if (m == 0)
    {
      AppMethodBeat.o(126242);
      return null;
    }
    int i = 2147483647;
    int j = 0;
    if (j < m)
    {
      View localView = paramLayoutManager.getChildAt(j);
      int k = paramaj.bo(localView);
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
  
  public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(126238);
    if ((Math.abs(paramInt2) <= 500) || (Math.abs(paramInt1) >= Math.abs(paramInt2)))
    {
      AppMethodBeat.o(126238);
      return -1;
    }
    int k = paramLayoutManager.getItemCount();
    if (k == 0)
    {
      AppMethodBeat.o(126238);
      return -1;
    }
    View localView = null;
    if (paramLayoutManager.canScrollVertically()) {
      localView = c(paramLayoutManager, b(paramLayoutManager));
    }
    while (localView == null)
    {
      AppMethodBeat.o(126238);
      return -1;
      if (paramLayoutManager.canScrollHorizontally()) {
        localView = c(paramLayoutManager, c(paramLayoutManager));
      }
    }
    int j = paramLayoutManager.getPosition(localView);
    if (j == -1)
    {
      AppMethodBeat.o(126238);
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
        paramLayoutManager = ((RecyclerView.r.b)paramLayoutManager).bZ(k - 1);
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
    label241:
    if (paramInt1 != 0)
    {
      AppMethodBeat.o(126238);
      return j + 1;
    }
    AppMethodBeat.o(126238);
    return j;
  }
  
  public final View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(126237);
    if (paramLayoutManager.canScrollVertically())
    {
      paramLayoutManager = a(paramLayoutManager, b(paramLayoutManager));
      AppMethodBeat.o(126237);
      return paramLayoutManager;
    }
    if (paramLayoutManager.canScrollHorizontally())
    {
      paramLayoutManager = a(paramLayoutManager, c(paramLayoutManager));
      AppMethodBeat.o(126237);
      return paramLayoutManager;
    }
    AppMethodBeat.o(126237);
    return null;
  }
  
  public final int[] a(RecyclerView.LayoutManager paramLayoutManager, View paramView)
  {
    AppMethodBeat.i(126236);
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
      AppMethodBeat.o(126236);
      return arrayOfInt;
      arrayOfInt[0] = 0;
      break;
      label63:
      arrayOfInt[1] = 0;
    }
  }
  
  public final ae f(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(126239);
    if (!(paramLayoutManager instanceof RecyclerView.r.b))
    {
      AppMethodBeat.o(126239);
      return null;
    }
    paramLayoutManager = new ae(this.mRecyclerView.getContext())
    {
      public final float a(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 100.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      public final void a(View paramAnonymousView, RecyclerView.s paramAnonymouss, RecyclerView.r.a paramAnonymousa)
      {
        AppMethodBeat.i(126234);
        paramAnonymousView = b.this.a(b.this.mRecyclerView.getLayoutManager(), paramAnonymousView);
        int i = paramAnonymousView[0];
        int j = paramAnonymousView[1];
        int k = cc(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0) {
          paramAnonymousa.a(i, j, k, this.VQ);
        }
        AppMethodBeat.o(126234);
      }
      
      public final int cd(int paramAnonymousInt)
      {
        AppMethodBeat.i(126235);
        paramAnonymousInt = Math.min(100, super.cd(paramAnonymousInt));
        AppMethodBeat.o(126235);
        return paramAnonymousInt;
      }
    };
    AppMethodBeat.o(126239);
    return paramLayoutManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.b
 * JD-Core Version:    0.7.0.1
 */