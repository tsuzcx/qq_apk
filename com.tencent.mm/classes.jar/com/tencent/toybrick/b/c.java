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
  private static final int[] GC = { 16843284 };
  public a.a BwX;
  private int mOrientation;
  private final Rect qA;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(113192);
    this.qA = new Rect();
    paramContext.obtainStyledAttributes(GC).recycle();
    this.mOrientation = 1;
    AppMethodBeat.o(113192);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    int k = 0;
    AppMethodBeat.i(113193);
    if ((paramRecyclerView.getLayoutManager() == null) || (this.BwX.BxW == null))
    {
      AppMethodBeat.o(113193);
      return;
    }
    int j;
    int i;
    View localView;
    int m;
    int n;
    int i1;
    if (this.mOrientation == 1)
    {
      if (this.BwX.BxV)
      {
        paramCanvas.save();
        j = paramRecyclerView.getChildCount();
        i = 0;
        while (i < j)
        {
          localView = paramRecyclerView.getChildAt(i);
          k = paramRecyclerView.bo(localView).jN();
          if (k >= 0)
          {
            g localg = ((b)paramRecyclerView.getAdapter()).Tk(k);
            if (localg.BxK)
            {
              k = localg.fG(localView)[0];
              m = paramRecyclerView.getWidth();
              n = localg.fG(localView)[1];
              RecyclerView.d(localView, this.qA);
              i1 = this.qA.bottom;
              i1 = Math.round(localView.getTranslationY()) + i1;
              int i2 = this.BwX.BxW.getIntrinsicHeight();
              this.BwX.BxW.setBounds(k, i1 - i2, m - n, i1);
              this.BwX.BxW.draw(paramCanvas);
            }
          }
          i += 1;
        }
        paramCanvas.restore();
      }
      AppMethodBeat.o(113193);
      return;
    }
    if (this.BwX.BxV)
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
          localView = paramRecyclerView.getChildAt(k);
          if (((g)this.BwX.BxU.get(paramRecyclerView.bo(localView).jN())).BxK)
          {
            paramRecyclerView.getLayoutManager();
            RecyclerView.i.d(localView, this.qA);
            n = this.qA.right + Math.round(localView.getTranslationX());
            i1 = this.BwX.BxW.getIntrinsicWidth();
            this.BwX.BxW.setBounds(n - i1, j, n, i);
            this.BwX.BxW.draw(paramCanvas);
          }
          k += 1;
        }
        i = paramRecyclerView.getHeight();
        j = 0;
      }
      paramCanvas.restore();
    }
    AppMethodBeat.o(113193);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(113194);
    if (this.BwX.BxW == null)
    {
      paramRect.set(0, 0, 0, 0);
      AppMethodBeat.o(113194);
      return;
    }
    if (this.mOrientation == 1)
    {
      paramRect.set(0, 0, 0, this.BwX.BxW.getIntrinsicHeight());
      AppMethodBeat.o(113194);
      return;
    }
    paramRect.set(0, 0, this.BwX.BxW.getIntrinsicWidth(), 0);
    AppMethodBeat.o(113194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.toybrick.b.c
 * JD-Core Version:    0.7.0.1
 */