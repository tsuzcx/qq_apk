package com.tencent.mm.plugin.topstory.ui.video.list;

import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.r.b;
import android.support.v7.widget.ae;
import android.support.v7.widget.aj;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.a;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.widget.e;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
  extends e
{
  private aj agR;
  private aj agS;
  b thM;
  
  public c(b paramb)
  {
    this.thM = paramb;
  }
  
  private int a(View paramView, aj paramaj)
  {
    AppMethodBeat.i(2019);
    int i = paramaj.bh(paramView);
    int j = this.thM.cJp();
    AppMethodBeat.o(2019);
    return i - j;
  }
  
  private static View a(RecyclerView.i parami, aj paramaj)
  {
    Object localObject = null;
    AppMethodBeat.i(2020);
    int n = parami.getChildCount();
    if (n == 0)
    {
      AppMethodBeat.o(2020);
      return null;
    }
    int j;
    int k;
    if (parami.getClipToPadding())
    {
      j = paramaj.iI() + (paramaj.iK() - a.tfs) / 2;
      int i = 2147483647;
      k = 0;
      label57:
      if (k >= n) {
        break label126;
      }
      View localView = parami.getChildAt(k);
      int m = Math.abs(paramaj.bh(localView) + paramaj.bl(localView) / 2 - j);
      if (m >= i) {
        break label135;
      }
      localObject = localView;
      i = m;
    }
    label135:
    for (;;)
    {
      k += 1;
      break label57;
      j = paramaj.getEnd() / 2;
      break;
      label126:
      AppMethodBeat.o(2020);
      return localObject;
    }
  }
  
  private aj b(RecyclerView.i parami)
  {
    AppMethodBeat.i(2021);
    if ((this.agR == null) || (this.agR.getLayoutManager() != parami)) {
      this.agR = aj.e(parami);
    }
    parami = this.agR;
    AppMethodBeat.o(2021);
    return parami;
  }
  
  private aj c(RecyclerView.i parami)
  {
    AppMethodBeat.i(2022);
    if ((this.agS == null) || (this.agS.getLayoutManager() != parami)) {
      this.agS = aj.d(parami);
    }
    parami = this.agS;
    AppMethodBeat.o(2022);
    return parami;
  }
  
  public final int a(RecyclerView.i parami, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2017);
    if ((Math.abs(paramInt2) <= 500) || (Math.abs(paramInt1) >= Math.abs(paramInt2)))
    {
      AppMethodBeat.o(2017);
      return -1;
    }
    int j = parami.getItemCount();
    if (j == 0)
    {
      AppMethodBeat.o(2017);
      return -1;
    }
    int i = this.thM.cJk() + 1;
    if (i == -1)
    {
      AppMethodBeat.o(2017);
      return -1;
    }
    boolean bool;
    if (parami.ij()) {
      if (paramInt1 > 0)
      {
        bool = true;
        if (!(parami instanceof RecyclerView.r.b)) {
          break label268;
        }
        parami = ((RecyclerView.r.b)parami).bI(j - 1);
        if (parami == null) {
          break label268;
        }
        if ((parami.x >= 0.0F) && (parami.y >= 0.0F)) {
          break label242;
        }
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      label140:
      if (paramInt1 != 0)
      {
        if (bool) {
          break label260;
        }
        paramInt1 = i + 1;
      }
      for (;;)
      {
        ab.i("MicroMsg.TopStory.TopStoryVideoPagerSnapHelper", "findTargetSnapPosition velocityY: %d centerPosition: %d forwardDirection: %b result: %d currentPlayPos: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(this.thM.cJk() + 1) });
        AppMethodBeat.o(2017);
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
        label242:
        paramInt1 = 0;
        break label140;
        if (bool) {
          paramInt1 = i + 1;
        } else {
          label260:
          paramInt1 = i - 1;
        }
      }
      label268:
      paramInt1 = 0;
    }
  }
  
  public final View a(RecyclerView.i parami)
  {
    AppMethodBeat.i(2016);
    if (parami.ik())
    {
      parami = a(parami, b(parami));
      AppMethodBeat.o(2016);
      return parami;
    }
    if (parami.ij())
    {
      parami = a(parami, c(parami));
      AppMethodBeat.o(2016);
      return parami;
    }
    AppMethodBeat.o(2016);
    return null;
  }
  
  public final int[] a(RecyclerView.i parami, View paramView)
  {
    AppMethodBeat.i(2015);
    int[] arrayOfInt = new int[2];
    if (parami.ij())
    {
      arrayOfInt[0] = a(paramView, c(parami));
      if (!parami.ik()) {
        break label65;
      }
      arrayOfInt[1] = a(paramView, b(parami));
    }
    for (;;)
    {
      AppMethodBeat.o(2015);
      return arrayOfInt;
      arrayOfInt[0] = 0;
      break;
      label65:
      arrayOfInt[1] = 0;
    }
  }
  
  public final ae f(RecyclerView.i parami)
  {
    AppMethodBeat.i(2018);
    if (!(parami instanceof RecyclerView.r.b))
    {
      AppMethodBeat.o(2018);
      return null;
    }
    parami = new c.1(this, this.adt.getContext());
    AppMethodBeat.o(2018);
    return parami;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.c
 * JD-Core Version:    0.7.0.1
 */