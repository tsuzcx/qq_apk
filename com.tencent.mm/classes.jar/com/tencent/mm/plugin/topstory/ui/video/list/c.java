package com.tencent.mm.plugin.topstory.ui.video.list;

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
import com.tencent.mm.plugin.topstory.ui.a;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.widget.f;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends f
{
  b MYE;
  private u ajA;
  private u ajz;
  
  public c(b paramb)
  {
    this.MYE = paramb;
  }
  
  private static View a(RecyclerView.LayoutManager paramLayoutManager, u paramu)
  {
    Object localObject = null;
    AppMethodBeat.i(203280);
    int n = paramLayoutManager.getChildCount();
    if (n == 0)
    {
      AppMethodBeat.o(203280);
      return null;
    }
    int j;
    int k;
    if (paramLayoutManager.getClipToPadding())
    {
      j = paramu.kT() + (paramu.kV() - a.MWy) / 2;
      int i = 2147483647;
      k = 0;
      label55:
      if (k >= n) {
        break label124;
      }
      View localView = paramLayoutManager.getChildAt(k);
      int m = Math.abs(paramu.aZ(localView) + paramu.bd(localView) / 2 - j);
      if (m >= i) {
        break label132;
      }
      localObject = localView;
      i = m;
    }
    label132:
    for (;;)
    {
      k += 1;
      break label55;
      j = paramu.getEnd() / 2;
      break;
      label124:
      AppMethodBeat.o(203280);
      return localObject;
    }
  }
  
  private int b(View paramView, u paramu)
  {
    AppMethodBeat.i(203275);
    int i = paramu.aZ(paramView);
    int j = this.MYE.gqK();
    AppMethodBeat.o(203275);
    return i - j;
  }
  
  private u b(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(203283);
    if ((this.ajz == null) || (this.ajz.getLayoutManager() != paramLayoutManager)) {
      this.ajz = u.e(paramLayoutManager);
    }
    paramLayoutManager = this.ajz;
    AppMethodBeat.o(203283);
    return paramLayoutManager;
  }
  
  private u c(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(203285);
    if ((this.ajA == null) || (this.ajA.getLayoutManager() != paramLayoutManager)) {
      this.ajA = u.d(paramLayoutManager);
    }
    paramLayoutManager = this.ajA;
    AppMethodBeat.o(203285);
    return paramLayoutManager;
  }
  
  public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203272);
    if ((Math.abs(paramInt2) <= 500) || (Math.abs(paramInt1) >= Math.abs(paramInt2)))
    {
      AppMethodBeat.o(203272);
      return -1;
    }
    int j = paramLayoutManager.getItemCount();
    if (j == 0)
    {
      AppMethodBeat.o(203272);
      return -1;
    }
    int i = this.MYE.gqE() + 1;
    if (i == -1)
    {
      AppMethodBeat.o(203272);
      return -1;
    }
    boolean bool;
    if (paramLayoutManager.canScrollHorizontally()) {
      if (paramInt1 > 0)
      {
        bool = true;
        if (!(paramLayoutManager instanceof RecyclerView.r.b)) {
          break label263;
        }
        paramLayoutManager = ((RecyclerView.r.b)paramLayoutManager).cB(j - 1);
        if (paramLayoutManager == null) {
          break label263;
        }
        if ((paramLayoutManager.x >= 0.0F) && (paramLayoutManager.y >= 0.0F)) {
          break label237;
        }
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      label136:
      if (paramInt1 != 0)
      {
        if (bool) {
          break label255;
        }
        paramInt1 = i + 1;
      }
      for (;;)
      {
        Log.i("MicroMsg.TopStory.TopStoryVideoPagerSnapHelper", "findTargetSnapPosition velocityY: %d centerPosition: %d forwardDirection: %b result: %d currentPlayPos: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(this.MYE.gqE() + 1) });
        AppMethodBeat.o(203272);
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
        label237:
        paramInt1 = 0;
        break label136;
        if (bool) {
          paramInt1 = i + 1;
        } else {
          label255:
          paramInt1 = i - 1;
        }
      }
      label263:
      paramInt1 = 0;
    }
  }
  
  public final View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(203258);
    if (paramLayoutManager.canScrollVertically())
    {
      paramLayoutManager = a(paramLayoutManager, b(paramLayoutManager));
      AppMethodBeat.o(203258);
      return paramLayoutManager;
    }
    if (paramLayoutManager.canScrollHorizontally())
    {
      paramLayoutManager = a(paramLayoutManager, c(paramLayoutManager));
      AppMethodBeat.o(203258);
      return paramLayoutManager;
    }
    AppMethodBeat.o(203258);
    return null;
  }
  
  public final int[] a(RecyclerView.LayoutManager paramLayoutManager, View paramView)
  {
    AppMethodBeat.i(203256);
    int[] arrayOfInt = new int[2];
    if (paramLayoutManager.canScrollHorizontally())
    {
      arrayOfInt[0] = b(paramView, c(paramLayoutManager));
      if (!paramLayoutManager.canScrollVertically()) {
        break label63;
      }
      arrayOfInt[1] = b(paramView, b(paramLayoutManager));
    }
    for (;;)
    {
      AppMethodBeat.o(203256);
      return arrayOfInt;
      arrayOfInt[0] = 0;
      break;
      label63:
      arrayOfInt[1] = 0;
    }
  }
  
  public final p f(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(203274);
    if (!(paramLayoutManager instanceof RecyclerView.r.b))
    {
      AppMethodBeat.o(203274);
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
        AppMethodBeat.i(203023);
        paramAnonymousView = c.this.a(c.a(c.this).getLayoutManager(), paramAnonymousView);
        int i = paramAnonymousView[0];
        int j = paramAnonymousView[1];
        int k = cE(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0) {
          paramAnonymousa.a(i, j, k, this.aju);
        }
        AppMethodBeat.o(203023);
      }
      
      public final int cF(int paramAnonymousInt)
      {
        AppMethodBeat.i(126408);
        paramAnonymousInt = Math.min(100, super.cF(paramAnonymousInt));
        AppMethodBeat.o(126408);
        return paramAnonymousInt;
      }
    };
    AppMethodBeat.o(203274);
    return paramLayoutManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.c
 * JD-Core Version:    0.7.0.1
 */