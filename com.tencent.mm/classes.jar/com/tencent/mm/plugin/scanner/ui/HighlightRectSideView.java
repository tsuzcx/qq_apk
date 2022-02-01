package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.f.a;
import com.tencent.mm.plugin.scanner.l.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public class HighlightRectSideView
  extends View
{
  private boolean[] IQa;
  private Rect IQb;
  private int IQc;
  private int IQd;
  private int IQe;
  private int IQf;
  private Paint auH;
  private MTimerHandler cts;
  
  public HighlightRectSideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51795);
    this.IQf = 0;
    this.cts = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(51794);
        HighlightRectSideView.a(HighlightRectSideView.this);
        HighlightRectSideView.this.invalidate();
        AppMethodBeat.o(51794);
        return true;
      }
    }, true);
    paramContext = a.decodeResource(getResources(), l.e.scanqr1);
    this.IQc = paramContext.getWidth();
    this.IQd = paramContext.getHeight();
    if (this.IQd != this.IQc) {
      Log.e("MicroMsg.HighlightRectSideView", "width is not same as height");
    }
    this.IQe = (this.IQc * 6 / 24);
    this.IQa = new boolean[4];
    this.auH = new Paint();
    this.auH.setColor(6676738);
    this.auH.setAlpha(255);
    this.auH.setStrokeWidth(this.IQe);
    this.auH.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(51795);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(51797);
    super.onAttachedToWindow();
    this.cts.startTimer(300L);
    AppMethodBeat.o(51797);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(51798);
    super.onDetachedFromWindow();
    if (this.cts != null)
    {
      this.cts.stopTimer();
      this.cts = null;
    }
    AppMethodBeat.o(51798);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(51799);
    super.onDraw(paramCanvas);
    int i = 0;
    if (i < 4) {
      if (this.IQa[i] != 0) {}
    }
    for (i = 0;; i = 1)
    {
      int j = this.IQe / 2;
      if ((this.IQa[0] != 0) && ((1 == i) || (this.IQf % 2 == 0))) {
        paramCanvas.drawLine(this.IQb.left + j, this.IQb.top + this.IQd, this.IQb.left + j, this.IQb.bottom - this.IQd, this.auH);
      }
      if ((this.IQa[1] != 0) && ((1 == i) || (this.IQf % 2 == 0))) {
        paramCanvas.drawLine(this.IQb.right - j, this.IQb.top + this.IQd, this.IQb.right - j, this.IQb.bottom - this.IQd, this.auH);
      }
      if ((this.IQa[2] != 0) && ((1 == i) || (this.IQf % 3 == 0))) {
        paramCanvas.drawLine(this.IQb.left + this.IQc, this.IQb.top + j, this.IQb.right - this.IQc, this.IQb.top + j, this.auH);
      }
      if ((this.IQa[3] != 0) && ((1 == i) || (this.IQf % 3 == 0))) {
        paramCanvas.drawLine(this.IQb.left + this.IQc, this.IQb.bottom - j, this.IQb.right - this.IQc, this.IQb.bottom - j, this.auH);
      }
      AppMethodBeat.o(51799);
      return;
      i += 1;
      break;
    }
  }
  
  public void setMaskRect(Rect paramRect)
  {
    AppMethodBeat.i(51796);
    this.IQb = paramRect;
    Log.d("MicroMsg.HighlightRectSideView", "rect:%s", new Object[] { paramRect });
    AppMethodBeat.o(51796);
  }
  
  public void setShowRectEdges(boolean[] paramArrayOfBoolean)
  {
    int i = 0;
    AppMethodBeat.i(51800);
    if ((paramArrayOfBoolean == null) || (4 != paramArrayOfBoolean.length))
    {
      AppMethodBeat.o(51800);
      return;
    }
    Log.d("MicroMsg.HighlightRectSideView", "%s, %s, %s, %s", new Object[] { Boolean.valueOf(paramArrayOfBoolean[0]), Boolean.valueOf(paramArrayOfBoolean[1]), Boolean.valueOf(paramArrayOfBoolean[2]), Boolean.valueOf(paramArrayOfBoolean[3]) });
    while (i < 4)
    {
      this.IQa[i] = paramArrayOfBoolean[i];
      i += 1;
    }
    invalidate();
    AppMethodBeat.o(51800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.HighlightRectSideView
 * JD-Core Version:    0.7.0.1
 */