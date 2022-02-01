package com.tencent.mm.plugin.topstory.ui.video.list;

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
import com.tencent.mm.plugin.topstory.ui.a;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.widget.f;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends f
{
  b BtO;
  private aj aqL;
  private aj aqM;
  
  public c(b paramb)
  {
    this.BtO = paramb;
  }
  
  private int a(View paramView, aj paramaj)
  {
    AppMethodBeat.i(126413);
    int i = paramaj.bn(paramView);
    int j = this.BtO.epK();
    AppMethodBeat.o(126413);
    return i - j;
  }
  
  private static View a(RecyclerView.i parami, aj paramaj)
  {
    Object localObject = null;
    AppMethodBeat.i(126414);
    int n = parami.getChildCount();
    if (n == 0)
    {
      AppMethodBeat.o(126414);
      return null;
    }
    int j;
    int k;
    if (parami.getClipToPadding())
    {
      j = paramaj.kB() + (paramaj.kD() - a.BrF) / 2;
      int i = 2147483647;
      k = 0;
      label55:
      if (k >= n) {
        break label124;
      }
      View localView = parami.getChildAt(k);
      int m = Math.abs(paramaj.bn(localView) + paramaj.br(localView) / 2 - j);
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
  
  private aj b(RecyclerView.i parami)
  {
    AppMethodBeat.i(126415);
    if ((this.aqL == null) || (this.aqL.getLayoutManager() != parami)) {
      this.aqL = aj.e(parami);
    }
    parami = this.aqL;
    AppMethodBeat.o(126415);
    return parami;
  }
  
  private aj c(RecyclerView.i parami)
  {
    AppMethodBeat.i(126416);
    if ((this.aqM == null) || (this.aqM.getLayoutManager() != parami)) {
      this.aqM = aj.d(parami);
    }
    parami = this.aqM;
    AppMethodBeat.o(126416);
    return parami;
  }
  
  public final int a(RecyclerView.i parami, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126411);
    if ((Math.abs(paramInt2) <= 500) || (Math.abs(paramInt1) >= Math.abs(paramInt2)))
    {
      AppMethodBeat.o(126411);
      return -1;
    }
    int j = parami.getItemCount();
    if (j == 0)
    {
      AppMethodBeat.o(126411);
      return -1;
    }
    int i = this.BtO.epE() + 1;
    if (i == -1)
    {
      AppMethodBeat.o(126411);
      return -1;
    }
    boolean bool;
    if (parami.kc()) {
      if (paramInt1 > 0)
      {
        bool = true;
        if (!(parami instanceof RecyclerView.s.b)) {
          break label263;
        }
        parami = ((RecyclerView.s.b)parami).bZ(j - 1);
        if (parami == null) {
          break label263;
        }
        if ((parami.x >= 0.0F) && (parami.y >= 0.0F)) {
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
        ad.i("MicroMsg.TopStory.TopStoryVideoPagerSnapHelper", "findTargetSnapPosition velocityY: %d centerPosition: %d forwardDirection: %b result: %d currentPlayPos: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(this.BtO.epE() + 1) });
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
  
  public final View a(RecyclerView.i parami)
  {
    AppMethodBeat.i(126410);
    if (parami.kd())
    {
      parami = a(parami, b(parami));
      AppMethodBeat.o(126410);
      return parami;
    }
    if (parami.kc())
    {
      parami = a(parami, c(parami));
      AppMethodBeat.o(126410);
      return parami;
    }
    AppMethodBeat.o(126410);
    return null;
  }
  
  public final int[] a(RecyclerView.i parami, View paramView)
  {
    AppMethodBeat.i(126409);
    int[] arrayOfInt = new int[2];
    if (parami.kc())
    {
      arrayOfInt[0] = a(paramView, c(parami));
      if (!parami.kd()) {
        break label63;
      }
      arrayOfInt[1] = a(paramView, b(parami));
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
  
  public final ae f(RecyclerView.i parami)
  {
    AppMethodBeat.i(126412);
    if (!(parami instanceof RecyclerView.s.b))
    {
      AppMethodBeat.o(126412);
      return null;
    }
    parami = new ae(this.anl.getContext())
    {
      public final float a(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 100.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      public final void a(View paramAnonymousView, RecyclerView.t paramAnonymoust, RecyclerView.s.a paramAnonymousa)
      {
        AppMethodBeat.i(126407);
        paramAnonymousView = c.this.a(c.this.anl.getLayoutManager(), paramAnonymousView);
        int i = paramAnonymousView[0];
        int j = paramAnonymousView[1];
        int k = cd(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0) {
          paramAnonymousa.a(i, j, k, this.VD);
        }
        AppMethodBeat.o(126407);
      }
      
      public final int ce(int paramAnonymousInt)
      {
        AppMethodBeat.i(126408);
        paramAnonymousInt = Math.min(100, super.ce(paramAnonymousInt));
        AppMethodBeat.o(126408);
        return paramAnonymousInt;
      }
    };
    AppMethodBeat.o(126412);
    return parami;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.c
 * JD-Core Version:    0.7.0.1
 */