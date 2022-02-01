package com.tencent.mm.plugin.remittance.mobile.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public final class MobileRemitHistoryRecodUI$c
  extends RecyclerView.h
{
  private int dividerHeight;
  private Paint fQY;
  private Paint fSg;
  private int fSh;
  
  public MobileRemitHistoryRecodUI$c(Context paramContext)
  {
    AppMethodBeat.i(67702);
    this.dividerHeight = a.h(paramContext, 0.5F);
    this.fSh = a.fromDPToPix(paramContext, 16);
    this.fQY = new Paint();
    this.fQY.setColor(paramContext.getResources().getColor(2131099656));
    this.fSg = new Paint();
    this.fSg.setColor(paramContext.getResources().getColor(2131099679));
    AppMethodBeat.o(67702);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    AppMethodBeat.i(67703);
    super.a(paramCanvas, paramRecyclerView, paramt);
    int j = paramRecyclerView.getChildCount();
    int k = paramRecyclerView.getPaddingLeft();
    int m = this.fSh;
    int n = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
    int i = 0;
    if (i < j)
    {
      paramt = paramRecyclerView.getChildAt(i);
      float f1 = paramt.getBottom();
      float f2 = paramt.getBottom() + this.dividerHeight;
      if (i == j - 1) {
        paramCanvas.drawRect(k, f1, n, f2, this.fSg);
      }
      for (;;)
      {
        i += 1;
        break;
        paramCanvas.drawRect(k + m, f1, n, f2, this.fQY);
      }
    }
    AppMethodBeat.o(67703);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    AppMethodBeat.i(67704);
    super.a(paramRect, paramView, paramRecyclerView, paramt);
    paramRect.bottom = this.dividerHeight;
    AppMethodBeat.o(67704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI.c
 * JD-Core Version:    0.7.0.1
 */