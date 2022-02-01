package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends RecyclerView.h
{
  private static void a(Rect paramRect, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramRect.left = paramInt;
      return;
    }
    paramRect.right = paramInt;
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    AppMethodBeat.i(200269);
    super.a(paramRect, paramView, paramRecyclerView, paramt);
    int i = paramRecyclerView.getWidth() / 2 - paramView.getLayoutParams().width / 2;
    if (RecyclerView.bw(paramView) == 0)
    {
      ((ViewGroup.MarginLayoutParams)paramView.getLayoutParams()).leftMargin = 0;
      a(paramRect, i, true);
      AppMethodBeat.o(200269);
      return;
    }
    if (RecyclerView.bw(paramView) == paramt.getItemCount() - 1)
    {
      ((ViewGroup.MarginLayoutParams)paramView.getLayoutParams()).rightMargin = 0;
      a(paramRect, i, false);
    }
    AppMethodBeat.o(200269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.h
 * JD-Core Version:    0.7.0.1
 */