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
  private boolean[] OYW;
  private Rect OYX;
  private int OYY;
  private int OYZ;
  private int OZa;
  private int OZb;
  private Paint cje;
  private MTimerHandler eln;
  
  public HighlightRectSideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51795);
    this.OZb = 0;
    this.eln = new MTimerHandler(new MTimerHandler.CallBack()
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
    this.OYY = paramContext.getWidth();
    this.OYZ = paramContext.getHeight();
    if (this.OYZ != this.OYY) {
      Log.e("MicroMsg.HighlightRectSideView", "width is not same as height");
    }
    this.OZa = (this.OYY * 6 / 24);
    this.OYW = new boolean[4];
    this.cje = new Paint();
    this.cje.setColor(6676738);
    this.cje.setAlpha(255);
    this.cje.setStrokeWidth(this.OZa);
    this.cje.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(51795);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(51797);
    super.onAttachedToWindow();
    this.eln.startTimer(300L);
    AppMethodBeat.o(51797);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(51798);
    super.onDetachedFromWindow();
    if (this.eln != null)
    {
      this.eln.stopTimer();
      this.eln = null;
    }
    AppMethodBeat.o(51798);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(51799);
    super.onDraw(paramCanvas);
    int i = 0;
    if (i < 4) {
      if (this.OYW[i] != 0) {}
    }
    for (i = 0;; i = 1)
    {
      int j = this.OZa / 2;
      if ((this.OYW[0] != 0) && ((1 == i) || (this.OZb % 2 == 0))) {
        paramCanvas.drawLine(this.OYX.left + j, this.OYX.top + this.OYZ, this.OYX.left + j, this.OYX.bottom - this.OYZ, this.cje);
      }
      if ((this.OYW[1] != 0) && ((1 == i) || (this.OZb % 2 == 0))) {
        paramCanvas.drawLine(this.OYX.right - j, this.OYX.top + this.OYZ, this.OYX.right - j, this.OYX.bottom - this.OYZ, this.cje);
      }
      if ((this.OYW[2] != 0) && ((1 == i) || (this.OZb % 3 == 0))) {
        paramCanvas.drawLine(this.OYX.left + this.OYY, this.OYX.top + j, this.OYX.right - this.OYY, this.OYX.top + j, this.cje);
      }
      if ((this.OYW[3] != 0) && ((1 == i) || (this.OZb % 3 == 0))) {
        paramCanvas.drawLine(this.OYX.left + this.OYY, this.OYX.bottom - j, this.OYX.right - this.OYY, this.OYX.bottom - j, this.cje);
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
    this.OYX = paramRect;
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
      this.OYW[i] = paramArrayOfBoolean[i];
      i += 1;
    }
    invalidate();
    AppMethodBeat.o(51800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.HighlightRectSideView
 * JD-Core Version:    0.7.0.1
 */