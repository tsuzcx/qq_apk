package com.tencent.toybrick.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.d.a.a;
import java.util.LinkedList;

public final class c
  extends RecyclerView.h
{
  private static final int[] Ox = { 16843284 };
  public a.a Ksm;
  private int mOrientation;
  private final Rect ya;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(159929);
    this.ya = new Rect();
    paramContext.obtainStyledAttributes(Ox).recycle();
    this.mOrientation = 1;
    AppMethodBeat.o(159929);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    AppMethodBeat.i(159931);
    if (this.Ksm.Ktk == null)
    {
      paramRect.set(0, 0, 0, 0);
      AppMethodBeat.o(159931);
      return;
    }
    if (this.mOrientation == 1)
    {
      paramRect.set(0, 0, 0, this.Ksm.Ktk.getIntrinsicHeight());
      AppMethodBeat.o(159931);
      return;
    }
    paramRect.set(0, 0, this.Ksm.Ktk.getIntrinsicWidth(), 0);
    AppMethodBeat.o(159931);
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    int k = 0;
    AppMethodBeat.i(168816);
    if ((paramRecyclerView.getLayoutManager() == null) || (this.Ksm.Ktk == null))
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
      if (this.Ksm.Ktj)
      {
        paramCanvas.save();
        j = paramRecyclerView.getChildCount();
        i = 0;
        while (i < j)
        {
          paramt = paramRecyclerView.getChildAt(i);
          k = paramRecyclerView.bu(paramt).lv();
          if (k >= 0)
          {
            g localg = ((b)paramRecyclerView.getAdapter()).afN(k);
            if (localg.KsY)
            {
              k = localg.gZ(paramt)[0];
              m = paramRecyclerView.getWidth();
              n = localg.gZ(paramt)[1];
              RecyclerView.c(paramt, this.ya);
              i1 = this.ya.bottom;
              i1 = Math.round(paramt.getTranslationY()) + i1;
              int i2 = this.Ksm.Ktk.getIntrinsicHeight();
              this.Ksm.Ktk.setBounds(k, i1 - i2, m - n, i1);
              this.Ksm.Ktk.draw(paramCanvas);
            }
          }
          i += 1;
        }
        paramCanvas.restore();
      }
      AppMethodBeat.o(168816);
      return;
    }
    if (this.Ksm.Ktj)
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
          paramt = paramRecyclerView.getChildAt(k);
          if (((g)this.Ksm.Kti.get(paramRecyclerView.bu(paramt).lv())).KsY)
          {
            paramRecyclerView.getLayoutManager();
            RecyclerView.i.c(paramt, this.ya);
            n = this.ya.right + Math.round(paramt.getTranslationX());
            i1 = this.Ksm.Ktk.getIntrinsicWidth();
            this.Ksm.Ktk.setBounds(n - i1, j, n, i);
            this.Ksm.Ktk.draw(paramCanvas);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.toybrick.b.c
 * JD-Core Version:    0.7.0.1
 */