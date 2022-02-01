package com.tencent.mm.plugin.topstory.ui.video.list;

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
import com.tencent.mm.plugin.topstory.ui.a;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.widget.f;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends f
{
  b GlS;
  private aj aqX;
  private aj aqY;
  
  public c(b paramb)
  {
    this.GlS = paramb;
  }
  
  private static View a(RecyclerView.LayoutManager paramLayoutManager, aj paramaj)
  {
    Object localObject = null;
    AppMethodBeat.i(126414);
    int n = paramLayoutManager.getChildCount();
    if (n == 0)
    {
      AppMethodBeat.o(126414);
      return null;
    }
    int j;
    int k;
    if (paramLayoutManager.getClipToPadding())
    {
      j = paramaj.kH() + (paramaj.kJ() - a.GjN) / 2;
      int i = 2147483647;
      k = 0;
      label55:
      if (k >= n) {
        break label124;
      }
      View localView = paramLayoutManager.getChildAt(k);
      int m = Math.abs(paramaj.bo(localView) + paramaj.bs(localView) / 2 - j);
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
      j = paramaj.getEnd() / 2;
      break;
      label124:
      AppMethodBeat.o(126414);
      return localObject;
    }
  }
  
  private int b(View paramView, aj paramaj)
  {
    AppMethodBeat.i(126413);
    int i = paramaj.bo(paramView);
    int j = this.GlS.fyN();
    AppMethodBeat.o(126413);
    return i - j;
  }
  
  private aj b(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(126415);
    if ((this.aqX == null) || (this.aqX.getLayoutManager() != paramLayoutManager)) {
      this.aqX = aj.e(paramLayoutManager);
    }
    paramLayoutManager = this.aqX;
    AppMethodBeat.o(126415);
    return paramLayoutManager;
  }
  
  private aj c(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(126416);
    if ((this.aqY == null) || (this.aqY.getLayoutManager() != paramLayoutManager)) {
      this.aqY = aj.d(paramLayoutManager);
    }
    paramLayoutManager = this.aqY;
    AppMethodBeat.o(126416);
    return paramLayoutManager;
  }
  
  public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126411);
    if ((Math.abs(paramInt2) <= 500) || (Math.abs(paramInt1) >= Math.abs(paramInt2)))
    {
      AppMethodBeat.o(126411);
      return -1;
    }
    int j = paramLayoutManager.getItemCount();
    if (j == 0)
    {
      AppMethodBeat.o(126411);
      return -1;
    }
    int i = this.GlS.fyH() + 1;
    if (i == -1)
    {
      AppMethodBeat.o(126411);
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
        paramLayoutManager = ((RecyclerView.r.b)paramLayoutManager).bZ(j - 1);
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
        Log.i("MicroMsg.TopStory.TopStoryVideoPagerSnapHelper", "findTargetSnapPosition velocityY: %d centerPosition: %d forwardDirection: %b result: %d currentPlayPos: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(this.GlS.fyH() + 1) });
        AppMethodBeat.o(126411);
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
    AppMethodBeat.i(126410);
    if (paramLayoutManager.canScrollVertically())
    {
      paramLayoutManager = a(paramLayoutManager, b(paramLayoutManager));
      AppMethodBeat.o(126410);
      return paramLayoutManager;
    }
    if (paramLayoutManager.canScrollHorizontally())
    {
      paramLayoutManager = a(paramLayoutManager, c(paramLayoutManager));
      AppMethodBeat.o(126410);
      return paramLayoutManager;
    }
    AppMethodBeat.o(126410);
    return null;
  }
  
  public final int[] a(RecyclerView.LayoutManager paramLayoutManager, View paramView)
  {
    AppMethodBeat.i(126409);
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
      AppMethodBeat.o(126409);
      return arrayOfInt;
      arrayOfInt[0] = 0;
      break;
      label63:
      arrayOfInt[1] = 0;
    }
  }
  
  public final ae f(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(126412);
    if (!(paramLayoutManager instanceof RecyclerView.r.b))
    {
      AppMethodBeat.o(126412);
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
        AppMethodBeat.i(126407);
        paramAnonymousView = c.this.a(c.this.mRecyclerView.getLayoutManager(), paramAnonymousView);
        int i = paramAnonymousView[0];
        int j = paramAnonymousView[1];
        int k = cc(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0) {
          paramAnonymousa.a(i, j, k, this.VQ);
        }
        AppMethodBeat.o(126407);
      }
      
      public final int cd(int paramAnonymousInt)
      {
        AppMethodBeat.i(126408);
        paramAnonymousInt = Math.min(100, super.cd(paramAnonymousInt));
        AppMethodBeat.o(126408);
        return paramAnonymousInt;
      }
    };
    AppMethodBeat.o(126412);
    return paramLayoutManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.c
 * JD-Core Version:    0.7.0.1
 */