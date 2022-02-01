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
import androidx.recyclerview.widget.o;
import androidx.recyclerview.widget.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.a;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.widget.f;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends f
{
  b TLn;
  private s bYd;
  private s bYe;
  
  public c(b paramb)
  {
    this.TLn = paramb;
  }
  
  private static View a(RecyclerView.LayoutManager paramLayoutManager, s params)
  {
    Object localObject = null;
    AppMethodBeat.i(271829);
    int n = paramLayoutManager.getChildCount();
    if (n == 0)
    {
      AppMethodBeat.o(271829);
      return null;
    }
    int j;
    int k;
    if (paramLayoutManager.getClipToPadding())
    {
      j = params.JE() + (params.JG() - a.TJc) / 2;
      int i = 2147483647;
      k = 0;
      label55:
      if (k >= n) {
        break label124;
      }
      View localView = paramLayoutManager.getChildAt(k);
      int m = Math.abs(params.bs(localView) + params.bw(localView) / 2 - j);
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
      j = params.getEnd() / 2;
      break;
      label124:
      AppMethodBeat.o(271829);
      return localObject;
    }
  }
  
  private s b(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(271830);
    if ((this.bYd == null) || (this.bYd.getLayoutManager() != paramLayoutManager)) {
      this.bYd = s.e(paramLayoutManager);
    }
    paramLayoutManager = this.bYd;
    AppMethodBeat.o(271830);
    return paramLayoutManager;
  }
  
  private int c(View paramView, s params)
  {
    AppMethodBeat.i(271826);
    int i = params.bs(paramView);
    int j = this.TLn.hNJ();
    AppMethodBeat.o(271826);
    return i - j;
  }
  
  private s c(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(271832);
    if ((this.bYe == null) || (this.bYe.getLayoutManager() != paramLayoutManager)) {
      this.bYe = s.d(paramLayoutManager);
    }
    paramLayoutManager = this.bYe;
    AppMethodBeat.o(271832);
    return paramLayoutManager;
  }
  
  public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(271835);
    if ((Math.abs(paramInt2) <= 500) || (Math.abs(paramInt1) >= Math.abs(paramInt2)))
    {
      AppMethodBeat.o(271835);
      return -1;
    }
    int j = paramLayoutManager.getItemCount();
    if (j == 0)
    {
      AppMethodBeat.o(271835);
      return -1;
    }
    int i = this.TLn.hND() + 1;
    if (i == -1)
    {
      AppMethodBeat.o(271835);
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
        paramLayoutManager = ((RecyclerView.r.b)paramLayoutManager).fM(j - 1);
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
        Log.i("MicroMsg.TopStory.TopStoryVideoPagerSnapHelper", "findTargetSnapPosition velocityY: %d centerPosition: %d forwardDirection: %b result: %d currentPlayPos: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(this.TLn.hND() + 1) });
        AppMethodBeat.o(271835);
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
    AppMethodBeat.i(271834);
    if (paramLayoutManager.canScrollVertically())
    {
      paramLayoutManager = a(paramLayoutManager, b(paramLayoutManager));
      AppMethodBeat.o(271834);
      return paramLayoutManager;
    }
    if (paramLayoutManager.canScrollHorizontally())
    {
      paramLayoutManager = a(paramLayoutManager, c(paramLayoutManager));
      AppMethodBeat.o(271834);
      return paramLayoutManager;
    }
    AppMethodBeat.o(271834);
    return null;
  }
  
  public final int[] a(RecyclerView.LayoutManager paramLayoutManager, View paramView)
  {
    AppMethodBeat.i(271833);
    int[] arrayOfInt = new int[2];
    if (paramLayoutManager.canScrollHorizontally())
    {
      arrayOfInt[0] = c(paramView, c(paramLayoutManager));
      if (!paramLayoutManager.canScrollVertically()) {
        break label63;
      }
      arrayOfInt[1] = c(paramView, b(paramLayoutManager));
    }
    for (;;)
    {
      AppMethodBeat.o(271833);
      return arrayOfInt;
      arrayOfInt[0] = 0;
      break;
      label63:
      arrayOfInt[1] = 0;
    }
  }
  
  public final o f(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(271837);
    if (!(paramLayoutManager instanceof RecyclerView.r.b))
    {
      AppMethodBeat.o(271837);
      return null;
    }
    paramLayoutManager = new o(this.mRecyclerView.getContext())
    {
      public final void a(View paramAnonymousView, RecyclerView.s paramAnonymouss, RecyclerView.r.a paramAnonymousa)
      {
        AppMethodBeat.i(271824);
        paramAnonymousView = c.this.a(c.a(c.this).getLayoutManager(), paramAnonymousView);
        int i = paramAnonymousView[0];
        int j = paramAnonymousView[1];
        int k = fO(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0) {
          paramAnonymousa.a(i, j, k, this.bXY);
        }
        AppMethodBeat.o(271824);
      }
      
      public final float c(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 100.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      public final int fP(int paramAnonymousInt)
      {
        AppMethodBeat.i(126408);
        paramAnonymousInt = Math.min(100, super.fP(paramAnonymousInt));
        AppMethodBeat.o(126408);
        return paramAnonymousInt;
      }
    };
    AppMethodBeat.o(271837);
    return paramLayoutManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.c
 * JD-Core Version:    0.7.0.1
 */