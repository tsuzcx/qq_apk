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
import com.tencent.mm.compatible.e.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;

public class HighlightRectSideView
  extends View
{
  private av cbR;
  private boolean[] vRY;
  private Rect vRZ;
  private int vSa;
  private int vSb;
  private int vSc;
  private int vSd;
  private Paint vb;
  
  public HighlightRectSideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51795);
    this.vSd = 0;
    this.cbR = new av(new av.a()
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
    paramContext = a.decodeResource(getResources(), 2131233910);
    this.vSa = paramContext.getWidth();
    this.vSb = paramContext.getHeight();
    if (this.vSb != this.vSa) {
      ad.e("MicroMsg.HighlightRectSideView", "width is not same as height");
    }
    this.vSc = (this.vSa * 6 / 24);
    this.vRY = new boolean[4];
    this.vb = new Paint();
    this.vb.setColor(6676738);
    this.vb.setAlpha(255);
    this.vb.setStrokeWidth(this.vSc);
    this.vb.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(51795);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(51797);
    super.onAttachedToWindow();
    this.cbR.av(300L, 300L);
    AppMethodBeat.o(51797);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(51798);
    super.onDetachedFromWindow();
    if (this.cbR != null)
    {
      this.cbR.stopTimer();
      this.cbR = null;
    }
    AppMethodBeat.o(51798);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(51799);
    super.onDraw(paramCanvas);
    int i = 0;
    if (i < 4) {
      if (this.vRY[i] != 0) {}
    }
    for (i = 0;; i = 1)
    {
      int j = this.vSc / 2;
      if ((this.vRY[0] != 0) && ((1 == i) || (this.vSd % 2 == 0))) {
        paramCanvas.drawLine(this.vRZ.left + j, this.vRZ.top + this.vSb, this.vRZ.left + j, this.vRZ.bottom - this.vSb, this.vb);
      }
      if ((this.vRY[1] != 0) && ((1 == i) || (this.vSd % 2 == 0))) {
        paramCanvas.drawLine(this.vRZ.right - j, this.vRZ.top + this.vSb, this.vRZ.right - j, this.vRZ.bottom - this.vSb, this.vb);
      }
      if ((this.vRY[2] != 0) && ((1 == i) || (this.vSd % 3 == 0))) {
        paramCanvas.drawLine(this.vRZ.left + this.vSa, this.vRZ.top + j, this.vRZ.right - this.vSa, this.vRZ.top + j, this.vb);
      }
      if ((this.vRY[3] != 0) && ((1 == i) || (this.vSd % 3 == 0))) {
        paramCanvas.drawLine(this.vRZ.left + this.vSa, this.vRZ.bottom - j, this.vRZ.right - this.vSa, this.vRZ.bottom - j, this.vb);
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
    this.vRZ = paramRect;
    ad.d("MicroMsg.HighlightRectSideView", "rect:%s", new Object[] { paramRect });
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
    ad.d("MicroMsg.HighlightRectSideView", "%s, %s, %s, %s", new Object[] { Boolean.valueOf(paramArrayOfBoolean[0]), Boolean.valueOf(paramArrayOfBoolean[1]), Boolean.valueOf(paramArrayOfBoolean[2]), Boolean.valueOf(paramArrayOfBoolean[3]) });
    while (i < 4)
    {
      this.vRY[i] = paramArrayOfBoolean[i];
      i += 1;
    }
    invalidate();
    AppMethodBeat.o(51800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.HighlightRectSideView
 * JD-Core Version:    0.7.0.1
 */