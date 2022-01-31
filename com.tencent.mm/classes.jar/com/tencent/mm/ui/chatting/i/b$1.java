package com.tencent.mm.ui.chatting.i;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.a.c.b;

final class b$1
  extends RecyclerView.h
{
  int kFE;
  ColorDrawable kFF;
  int mSize;
  
  b$1(b paramb)
  {
    AppMethodBeat.i(32525);
    this.kFE = this.zPf.mContext.getResources().getColor(2131690052);
    this.kFF = new ColorDrawable(this.kFE);
    this.mSize = ((int)this.zPf.mContext.getResources().getDimension(2131427496));
    AppMethodBeat.o(32525);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(32526);
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
        Object localObject = this.zPf.PD(((Integer)params.getTag()).intValue() + 1);
        if ((localObject == null) || (((c.b)localObject).getType() != 2147483647))
        {
          localObject = (RecyclerView.LayoutParams)params.getLayoutParams();
          int i1 = params.getBottom();
          i1 = ((RecyclerView.LayoutParams)localObject).bottomMargin + i1;
          int i2 = this.mSize;
          this.kFF.setBounds(j, i1, k - m, i2 + i1);
          this.kFF.draw(paramCanvas);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(32526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.b.1
 * JD-Core Version:    0.7.0.1
 */