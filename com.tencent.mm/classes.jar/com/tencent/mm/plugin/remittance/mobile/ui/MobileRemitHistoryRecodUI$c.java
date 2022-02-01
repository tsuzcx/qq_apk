package com.tencent.mm.plugin.remittance.mobile.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.wxpay.a.c;

public final class MobileRemitHistoryRecodUI$c
  extends RecyclerView.h
{
  private Paint lCo;
  private int lCp;
  private Paint lDC;
  private int lDD;
  
  public MobileRemitHistoryRecodUI$c(Context paramContext)
  {
    AppMethodBeat.i(67702);
    this.lCp = a.fromDPToPix(paramContext, 0.5F);
    this.lDD = a.fromDPToPix(paramContext, 16);
    this.lCo = new Paint();
    this.lCo.setColor(paramContext.getResources().getColor(a.c.BW_0_Alpha_0_1));
    this.lDC = new Paint();
    this.lDC.setColor(paramContext.getResources().getColor(a.c.BW_93));
    AppMethodBeat.o(67702);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(288881);
    super.a(paramCanvas, paramRecyclerView, params);
    int j = paramRecyclerView.getChildCount();
    int k = paramRecyclerView.getPaddingLeft();
    int m = this.lDD;
    int n = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
    int i = 0;
    if (i < j)
    {
      params = paramRecyclerView.getChildAt(i);
      float f1 = params.getBottom();
      float f2 = params.getBottom() + this.lCp;
      if (i == j - 1) {
        paramCanvas.drawRect(k, f1, n, f2, this.lDC);
      }
      for (;;)
      {
        i += 1;
        break;
        paramCanvas.drawRect(k + m, f1, n, f2, this.lCo);
      }
    }
    AppMethodBeat.o(288881);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(288883);
    super.a(paramRect, paramView, paramRecyclerView, params);
    paramRect.bottom = this.lCp;
    AppMethodBeat.o(288883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI.c
 * JD-Core Version:    0.7.0.1
 */