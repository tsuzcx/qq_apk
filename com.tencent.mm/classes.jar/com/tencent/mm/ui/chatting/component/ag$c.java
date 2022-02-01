package com.tencent.mm.ui.chatting.component;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ag$c
  extends RecyclerView.h
{
  private final int column;
  private final int space;
  
  public ag$c(int paramInt)
  {
    this.space = paramInt;
    this.column = 4;
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(256278);
    paramRect.left = (RecyclerView.bA(paramView) % this.column * this.space);
    AppMethodBeat.o(256278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.ag.c
 * JD-Core Version:    0.7.0.1
 */