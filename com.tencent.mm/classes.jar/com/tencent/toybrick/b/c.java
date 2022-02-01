package com.tencent.toybrick.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.d.a.a;
import java.util.LinkedList;

public final class c
  extends RecyclerView.h
{
  private static final int[] NC = { 16843284 };
  public a.a IGb;
  private int mOrientation;
  private final Rect xc;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(159929);
    this.xc = new Rect();
    paramContext.obtainStyledAttributes(NC).recycle();
    this.mOrientation = 1;
    AppMethodBeat.o(159929);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(159931);
    if (this.IGb.IGZ == null)
    {
      paramRect.set(0, 0, 0, 0);
      AppMethodBeat.o(159931);
      return;
    }
    if (this.mOrientation == 1)
    {
      paramRect.set(0, 0, 0, this.IGb.IGZ.getIntrinsicHeight());
      AppMethodBeat.o(159931);
      return;
    }
    paramRect.set(0, 0, this.IGb.IGZ.getIntrinsicWidth(), 0);
    AppMethodBeat.o(159931);
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int k = 0;
    AppMethodBeat.i(168816);
    if ((paramRecyclerView.getLayoutManager() == null) || (this.IGb.IGZ == null))
    {
      AppMethodBeat.o(168816);
      return;
    }
    int j;
    int i;
    int m;
    int n;
    int i1;
    if (this.mOrientation == 1)
    {
      if (this.IGb.IGY)
      {
        paramCanvas.save();
        j = paramRecyclerView.getChildCount();
        i = 0;
        while (i < j)
        {
          params = paramRecyclerView.getChildAt(i);
          k = paramRecyclerView.bu(params).ln();
          if (k >= 0)
          {
            g localg = ((b)paramRecyclerView.getAdapter()).acR(k);
            if (localg.IGN)
            {
              k = localg.gH(params)[0];
              m = paramRecyclerView.getWidth();
              n = localg.gH(params)[1];
              RecyclerView.c(params, this.xc);
              i1 = this.xc.bottom;
              i1 = Math.round(params.getTranslationY()) + i1;
              int i2 = this.IGb.IGZ.getIntrinsicHeight();
              this.IGb.IGZ.setBounds(k, i1 - i2, m - n, i1);
              this.IGb.IGZ.draw(paramCanvas);
            }
          }
          i += 1;
        }
        paramCanvas.restore();
      }
      AppMethodBeat.o(168816);
      return;
    }
    if (this.IGb.IGY)
    {
      paramCanvas.save();
      if (paramRecyclerView.getClipToPadding())
      {
        j = paramRecyclerView.getPaddingTop();
        i = paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom();
        paramCanvas.clipRect(paramRecyclerView.getPaddingLeft(), j, paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight(), i);
      }
      for (;;)
      {
        m = paramRecyclerView.getChildCount();
        while (k < m)
        {
          params = paramRecyclerView.getChildAt(k);
          if (((g)this.IGb.IGX.get(paramRecyclerView.bu(params).ln())).IGN)
          {
            paramRecyclerView.getLayoutManager();
            RecyclerView.i.c(params, this.xc);
            n = this.xc.right + Math.round(params.getTranslationX());
            i1 = this.IGb.IGZ.getIntrinsicWidth();
            this.IGb.IGZ.setBounds(n - i1, j, n, i);
            this.IGb.IGZ.draw(paramCanvas);
          }
          k += 1;
        }
        i = paramRecyclerView.getHeight();
        j = 0;
      }
      paramCanvas.restore();
    }
    AppMethodBeat.o(168816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.toybrick.b.c
 * JD-Core Version:    0.7.0.1
 */