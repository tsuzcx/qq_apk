package com.tencent.mm.ui.chatting.k;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$9
  extends RecyclerView.h
{
  e$9(e parame, Context paramContext) {}
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(36508);
    int i = (int)this.val$context.getResources().getDimension(2131165537);
    paramRect.bottom = i;
    paramRect.top = i;
    paramRect.left = i;
    paramRect.right = i;
    AppMethodBeat.o(36508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.e.9
 * JD-Core Version:    0.7.0.1
 */