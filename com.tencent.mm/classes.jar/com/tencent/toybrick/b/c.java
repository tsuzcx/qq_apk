package com.tencent.toybrick.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.d.a.a;
import java.util.LinkedList;

public final class c
  extends RecyclerView.h
{
  private static final int[] oG = { 16843284 };
  public a.a ZPW;
  private final Rect mBounds;
  private int mOrientation;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(159929);
    this.mBounds = new Rect();
    paramContext.obtainStyledAttributes(oG).recycle();
    this.mOrientation = 1;
    AppMethodBeat.o(159929);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(249998);
    if (this.ZPW.ZQc == null)
    {
      paramRect.set(0, 0, 0, 0);
      AppMethodBeat.o(249998);
      return;
    }
    if (this.mOrientation == 1)
    {
      paramRect.set(0, 0, 0, this.ZPW.ZQc.getIntrinsicHeight());
      AppMethodBeat.o(249998);
      return;
    }
    paramRect.set(0, 0, this.ZPW.ZQc.getIntrinsicWidth(), 0);
    AppMethodBeat.o(249998);
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int i = 0;
    AppMethodBeat.i(249996);
    if ((paramRecyclerView.getLayoutManager() == null) || (this.ZPW.ZQc == null))
    {
      AppMethodBeat.o(249996);
      return;
    }
    int j;
    int k;
    if (this.mOrientation == 1)
    {
      if (this.ZPW.ZQb)
      {
        paramCanvas.save();
        j = paramRecyclerView.getChildCount();
        while (i < j)
        {
          k = paramRecyclerView.bf(paramRecyclerView.getChildAt(i)).md();
          if (k >= 0)
          {
            ((b)paramRecyclerView.getAdapter()).aCn(k);
            AppMethodBeat.o(249996);
            throw null;
          }
          i += 1;
        }
        paramCanvas.restore();
      }
      AppMethodBeat.o(249996);
      return;
    }
    if (this.ZPW.ZQb)
    {
      paramCanvas.save();
      if (paramRecyclerView.getClipToPadding())
      {
        i = paramRecyclerView.getPaddingTop();
        j = paramRecyclerView.getHeight();
        k = paramRecyclerView.getPaddingBottom();
        paramCanvas.clipRect(paramRecyclerView.getPaddingLeft(), i, paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight(), j - k);
      }
      while (paramRecyclerView.getChildCount() > 0)
      {
        paramCanvas = paramRecyclerView.getChildAt(0);
        this.ZPW.ZQa.get(paramRecyclerView.bf(paramCanvas).md());
        AppMethodBeat.o(249996);
        throw null;
        paramRecyclerView.getHeight();
      }
      paramCanvas.restore();
    }
    AppMethodBeat.o(249996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.toybrick.b.c
 * JD-Core Version:    0.7.0.1
 */