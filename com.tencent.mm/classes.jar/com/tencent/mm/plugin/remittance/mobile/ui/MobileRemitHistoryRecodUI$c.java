package com.tencent.mm.plugin.remittance.mobile.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public final class MobileRemitHistoryRecodUI$c
  extends RecyclerView.h
{
  private int dividerHeight;
  private Paint gwh;
  private Paint gxp;
  private int gxq;
  
  public MobileRemitHistoryRecodUI$c(Context paramContext)
  {
    AppMethodBeat.i(67702);
    this.dividerHeight = a.fromDPToPix(paramContext, 0.5F);
    this.gxq = a.fromDPToPix(paramContext, 16);
    this.gwh = new Paint();
    this.gwh.setColor(paramContext.getResources().getColor(2131099657));
    this.gxp = new Paint();
    this.gxp.setColor(paramContext.getResources().getColor(2131099689));
    AppMethodBeat.o(67702);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(67703);
    super.a(paramCanvas, paramRecyclerView, params);
    int j = paramRecyclerView.getChildCount();
    int k = paramRecyclerView.getPaddingLeft();
    int m = this.gxq;
    int n = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
    int i = 0;
    if (i < j)
    {
      params = paramRecyclerView.getChildAt(i);
      float f1 = params.getBottom();
      float f2 = params.getBottom() + this.dividerHeight;
      if (i == j - 1) {
        paramCanvas.drawRect(k, f1, n, f2, this.gxp);
      }
      for (;;)
      {
        i += 1;
        break;
        paramCanvas.drawRect(k + m, f1, n, f2, this.gwh);
      }
    }
    AppMethodBeat.o(67703);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(67704);
    super.a(paramRect, paramView, paramRecyclerView, params);
    paramRect.bottom = this.dividerHeight;
    AppMethodBeat.o(67704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI.c
 * JD-Core Version:    0.7.0.1
 */