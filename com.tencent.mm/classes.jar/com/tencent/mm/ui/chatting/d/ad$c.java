package com.tencent.mm.ui.chatting.d;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ad$c
  extends RecyclerView.h
{
  private final int column;
  private final int space;
  
  public ad$c(int paramInt)
  {
    this.space = paramInt;
    this.column = 4;
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(291849);
    paramRect.left = (RecyclerView.bh(paramView) % this.column * this.space);
    AppMethodBeat.o(291849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ad.c
 * JD-Core Version:    0.7.0.1
 */