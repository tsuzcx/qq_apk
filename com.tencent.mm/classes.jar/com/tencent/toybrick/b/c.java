package com.tencent.toybrick.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.h;
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
  private static final int[] QA = { 16843284 };
  public a.a Snl;
  private final Rect mBounds;
  private int mOrientation;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(159929);
    this.mBounds = new Rect();
    paramContext.obtainStyledAttributes(QA).recycle();
    this.mOrientation = 1;
    AppMethodBeat.o(159929);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(159931);
    if (this.Snl.Soj == null)
    {
      paramRect.set(0, 0, 0, 0);
      AppMethodBeat.o(159931);
      return;
    }
    if (this.mOrientation == 1)
    {
      paramRect.set(0, 0, 0, this.Snl.Soj.getIntrinsicHeight());
      AppMethodBeat.o(159931);
      return;
    }
    paramRect.set(0, 0, this.Snl.Soj.getIntrinsicWidth(), 0);
    AppMethodBeat.o(159931);
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int k = 0;
    AppMethodBeat.i(168816);
    if ((paramRecyclerView.getLayoutManager() == null) || (this.Snl.Soj == null))
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
      if (this.Snl.Soi)
      {
        paramCanvas.save();
        j = paramRecyclerView.getChildCount();
        i = 0;
        while (i < j)
        {
          params = paramRecyclerView.getChildAt(i);
          k = paramRecyclerView.bu(params).lR();
          if (k >= 0)
          {
            g localg = ((b)paramRecyclerView.getAdapter()).asz(k);
            if (localg.SnX)
            {
              k = localg.hN(params)[0];
              m = paramRecyclerView.getWidth();
              n = localg.hN(params)[1];
              RecyclerView.getDecoratedBoundsWithMargins(params, this.mBounds);
              i1 = this.mBounds.bottom;
              i1 = Math.round(params.getTranslationY()) + i1;
              int i2 = this.Snl.Soj.getIntrinsicHeight();
              this.Snl.Soj.setBounds(k, i1 - i2, m - n, i1);
              this.Snl.Soj.draw(paramCanvas);
            }
          }
          i += 1;
        }
        paramCanvas.restore();
      }
      AppMethodBeat.o(168816);
      return;
    }
    if (this.Snl.Soi)
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
          if (((g)this.Snl.Soh.get(paramRecyclerView.bu(params).lR())).SnX)
          {
            paramRecyclerView.getLayoutManager().getDecoratedBoundsWithMargins(params, this.mBounds);
            n = this.mBounds.right + Math.round(params.getTranslationX());
            i1 = this.Snl.Soj.getIntrinsicWidth();
            this.Snl.Soj.setBounds(n - i1, j, n, i);
            this.Snl.Soj.draw(paramCanvas);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.toybrick.b.c
 * JD-Core Version:    0.7.0.1
 */