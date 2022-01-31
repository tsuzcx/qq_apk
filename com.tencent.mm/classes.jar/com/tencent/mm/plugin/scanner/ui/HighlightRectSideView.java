package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.R.g;
import com.tencent.mm.compatible.g.a;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

public class HighlightRectSideView
  extends View
{
  private am fjC = new am(new HighlightRectSideView.1(this), true);
  private Paint nB;
  private boolean[] nJC;
  private Rect nJD;
  private int nJE;
  private int nJF;
  private int nJG;
  private int nJH = 0;
  
  public HighlightRectSideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = a.decodeResource(getResources(), R.g.scanqr1);
    this.nJE = paramContext.getWidth();
    this.nJF = paramContext.getHeight();
    if (this.nJF != this.nJE) {
      y.e("MicroMsg.HighlightRectSideView", "width is not same as height");
    }
    this.nJG = (this.nJE * 6 / 24);
    this.nJC = new boolean[4];
    this.nB = new Paint();
    this.nB.setColor(6676738);
    this.nB.setAlpha(255);
    this.nB.setStrokeWidth(this.nJG);
    this.nB.setStyle(Paint.Style.STROKE);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.fjC.S(300L, 300L);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.fjC != null)
    {
      this.fjC.stopTimer();
      this.fjC = null;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = 0;
    if (i < 4) {
      if (this.nJC[i] != 0) {}
    }
    for (i = 0;; i = 1)
    {
      int j = this.nJG / 2;
      if ((this.nJC[0] != 0) && ((1 == i) || (this.nJH % 2 == 0))) {
        paramCanvas.drawLine(this.nJD.left + j, this.nJD.top + this.nJF, this.nJD.left + j, this.nJD.bottom - this.nJF, this.nB);
      }
      if ((this.nJC[1] != 0) && ((1 == i) || (this.nJH % 2 == 0))) {
        paramCanvas.drawLine(this.nJD.right - j, this.nJD.top + this.nJF, this.nJD.right - j, this.nJD.bottom - this.nJF, this.nB);
      }
      if ((this.nJC[2] != 0) && ((1 == i) || (this.nJH % 3 == 0))) {
        paramCanvas.drawLine(this.nJD.left + this.nJE, this.nJD.top + j, this.nJD.right - this.nJE, this.nJD.top + j, this.nB);
      }
      if ((this.nJC[3] != 0) && ((1 == i) || (this.nJH % 3 == 0))) {
        paramCanvas.drawLine(this.nJD.left + this.nJE, this.nJD.bottom - j, this.nJD.right - this.nJE, this.nJD.bottom - j, this.nB);
      }
      return;
      i += 1;
      break;
    }
  }
  
  public void setMaskRect(Rect paramRect)
  {
    this.nJD = paramRect;
    y.d("MicroMsg.HighlightRectSideView", "rect:%s", new Object[] { paramRect });
  }
  
  public void setShowRectEdges(boolean[] paramArrayOfBoolean)
  {
    int i = 0;
    if ((paramArrayOfBoolean == null) || (4 != paramArrayOfBoolean.length)) {
      return;
    }
    y.d("MicroMsg.HighlightRectSideView", "%s, %s, %s, %s", new Object[] { Boolean.valueOf(paramArrayOfBoolean[0]), Boolean.valueOf(paramArrayOfBoolean[1]), Boolean.valueOf(paramArrayOfBoolean[2]), Boolean.valueOf(paramArrayOfBoolean[3]) });
    while (i < 4)
    {
      this.nJC[i] = paramArrayOfBoolean[i];
      i += 1;
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.HighlightRectSideView
 * JD-Core Version:    0.7.0.1
 */