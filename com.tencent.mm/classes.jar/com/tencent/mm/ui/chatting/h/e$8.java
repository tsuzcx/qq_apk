package com.tencent.mm.ui.chatting.h;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.mm.R.f;

final class e$8
  extends RecyclerView.h
{
  e$8(e parame, Context paramContext) {}
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int i = (int)this.val$context.getResources().getDimension(R.f.OneDPPadding);
    paramRect.bottom = i;
    paramRect.top = i;
    paramRect.left = i;
    paramRect.right = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.e.8
 * JD-Core Version:    0.7.0.1
 */