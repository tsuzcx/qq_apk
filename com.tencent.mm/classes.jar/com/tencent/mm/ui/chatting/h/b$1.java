package com.tencent.mm.ui.chatting.h;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.ui.chatting.a.c.b;

final class b$1
  extends RecyclerView.h
{
  int mSize = (int)this.vyI.mContext.getResources().getDimension(R.f.BasicPaddingSize);
  int vyG = this.vyI.mContext.getResources().getColor(R.e.fav_listitem_divider_bg);
  ColorDrawable vyH = new ColorDrawable(this.vyG);
  
  b$1(b paramb) {}
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int j = paramRecyclerView.getPaddingLeft();
    int k = paramRecyclerView.getWidth();
    int m = paramRecyclerView.getPaddingRight();
    int n = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < n)
    {
      params = paramRecyclerView.getChildAt(i);
      if (params.getTag() != null)
      {
        Object localObject = this.vyI.Ha(((Integer)params.getTag()).intValue() + 1);
        if ((localObject == null) || (((c.b)localObject).getType() != 2147483647))
        {
          localObject = (RecyclerView.LayoutParams)params.getLayoutParams();
          int i1 = params.getBottom();
          i1 = ((RecyclerView.LayoutParams)localObject).bottomMargin + i1;
          int i2 = this.mSize;
          this.vyH.setBounds(j, i1, k - m, i2 + i1);
          this.vyH.draw(paramCanvas);
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.b.1
 * JD-Core Version:    0.7.0.1
 */