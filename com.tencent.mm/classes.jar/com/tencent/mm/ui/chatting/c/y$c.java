package com.tencent.mm.ui.chatting.c;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class y$c
  extends RecyclerView.h
{
  private final int column;
  private final int rie;
  
  public y$c(int paramInt)
  {
    this.rie = paramInt;
    this.column = 4;
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    AppMethodBeat.i(196494);
    paramRect.left = (RecyclerView.bw(paramView) % this.column * this.rie);
    AppMethodBeat.o(196494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.y.c
 * JD-Core Version:    0.7.0.1
 */