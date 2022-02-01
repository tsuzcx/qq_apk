package com.tencent.mm.ui.chatting.d;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ac$c
  extends RecyclerView.h
{
  private final int column;
  private final int tCv;
  
  public ac$c(int paramInt)
  {
    this.tCv = paramInt;
    this.column = 4;
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(233117);
    paramRect.left = (RecyclerView.bw(paramView) % this.column * this.tCv);
    AppMethodBeat.o(233117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ac.c
 * JD-Core Version:    0.7.0.1
 */