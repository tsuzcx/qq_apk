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
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.d.a.a;
import java.util.LinkedList;

public final class c
  extends RecyclerView.h
{
  private static final int[] FV = { 16843284 };
  private int adN;
  private final Rect pD = new Rect();
  public a.a xar;
  
  public c(Context paramContext)
  {
    paramContext.obtainStyledAttributes(FV).recycle();
    this.adN = 1;
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    int k = 0;
    if ((paramRecyclerView.getLayoutManager() == null) || (this.xar.xbq == null)) {}
    int j;
    int i;
    View localView;
    int m;
    int n;
    int i1;
    do
    {
      do
      {
        return;
        if (this.adN != 1) {
          break;
        }
      } while (!this.xar.xbp);
      paramCanvas.save();
      j = paramRecyclerView.getChildCount();
      i = 0;
      while (i < j)
      {
        localView = paramRecyclerView.getChildAt(i);
        k = paramRecyclerView.be(localView).id();
        if (k >= 0)
        {
          g localg = ((b)paramRecyclerView.getAdapter()).Kq(k);
          if (localg.xbe)
          {
            k = localg.es(localView)[0];
            m = paramRecyclerView.getWidth();
            n = localg.es(localView)[1];
            RecyclerView.d(localView, this.pD);
            i1 = this.pD.bottom;
            i1 = Math.round(localView.getTranslationY()) + i1;
            int i2 = this.xar.xbq.getIntrinsicHeight();
            this.xar.xbq.setBounds(k, i1 - i2, m - n, i1);
            this.xar.xbq.draw(paramCanvas);
          }
        }
        i += 1;
      }
      paramCanvas.restore();
      return;
    } while (!this.xar.xbp);
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
        if (((g)this.xar.xbo.get(paramRecyclerView.be(localView).id())).xbe)
        {
          paramRecyclerView.getLayoutManager();
          RecyclerView.i.d(localView, this.pD);
          n = this.pD.right + Math.round(localView.getTranslationX());
          i1 = this.xar.xbq.getIntrinsicWidth();
          this.xar.xbq.setBounds(n - i1, j, n, i);
          this.xar.xbq.draw(paramCanvas);
        }
        k += 1;
      }
      i = paramRecyclerView.getHeight();
      j = 0;
    }
    paramCanvas.restore();
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    if (this.xar.xbq == null)
    {
      paramRect.set(0, 0, 0, 0);
      return;
    }
    if (this.adN == 1)
    {
      paramRect.set(0, 0, 0, this.xar.xbq.getIntrinsicHeight());
      return;
    }
    paramRect.set(0, 0, this.xar.xbq.getIntrinsicWidth(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.toybrick.b.c
 * JD-Core Version:    0.7.0.1
 */