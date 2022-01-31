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
import com.tencent.mm.compatible.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

public class HighlightRectSideView
  extends View
{
  private ap bAz;
  private Paint oz;
  private boolean[] qxe;
  private Rect qxf;
  private int qxg;
  private int qxh;
  private int qxi;
  private int qxj;
  
  public HighlightRectSideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(81024);
    this.qxj = 0;
    this.bAz = new ap(new HighlightRectSideView.1(this), true);
    paramContext = a.decodeResource(getResources(), 2130840208);
    this.qxg = paramContext.getWidth();
    this.qxh = paramContext.getHeight();
    if (this.qxh != this.qxg) {
      ab.e("MicroMsg.HighlightRectSideView", "width is not same as height");
    }
    this.qxi = (this.qxg * 6 / 24);
    this.qxe = new boolean[4];
    this.oz = new Paint();
    this.oz.setColor(6676738);
    this.oz.setAlpha(255);
    this.oz.setStrokeWidth(this.qxi);
    this.oz.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(81024);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(81026);
    super.onAttachedToWindow();
    this.bAz.ag(300L, 300L);
    AppMethodBeat.o(81026);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(81027);
    super.onDetachedFromWindow();
    if (this.bAz != null)
    {
      this.bAz.stopTimer();
      this.bAz = null;
    }
    AppMethodBeat.o(81027);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(81028);
    super.onDraw(paramCanvas);
    int i = 0;
    if (i < 4) {
      if (this.qxe[i] != 0) {}
    }
    for (i = 0;; i = 1)
    {
      int j = this.qxi / 2;
      if ((this.qxe[0] != 0) && ((1 == i) || (this.qxj % 2 == 0))) {
        paramCanvas.drawLine(this.qxf.left + j, this.qxf.top + this.qxh, this.qxf.left + j, this.qxf.bottom - this.qxh, this.oz);
      }
      if ((this.qxe[1] != 0) && ((1 == i) || (this.qxj % 2 == 0))) {
        paramCanvas.drawLine(this.qxf.right - j, this.qxf.top + this.qxh, this.qxf.right - j, this.qxf.bottom - this.qxh, this.oz);
      }
      if ((this.qxe[2] != 0) && ((1 == i) || (this.qxj % 3 == 0))) {
        paramCanvas.drawLine(this.qxf.left + this.qxg, this.qxf.top + j, this.qxf.right - this.qxg, this.qxf.top + j, this.oz);
      }
      if ((this.qxe[3] != 0) && ((1 == i) || (this.qxj % 3 == 0))) {
        paramCanvas.drawLine(this.qxf.left + this.qxg, this.qxf.bottom - j, this.qxf.right - this.qxg, this.qxf.bottom - j, this.oz);
      }
      AppMethodBeat.o(81028);
      return;
      i += 1;
      break;
    }
  }
  
  public void setMaskRect(Rect paramRect)
  {
    AppMethodBeat.i(81025);
    this.qxf = paramRect;
    ab.d("MicroMsg.HighlightRectSideView", "rect:%s", new Object[] { paramRect });
    AppMethodBeat.o(81025);
  }
  
  public void setShowRectEdges(boolean[] paramArrayOfBoolean)
  {
    int i = 0;
    AppMethodBeat.i(81029);
    if ((paramArrayOfBoolean == null) || (4 != paramArrayOfBoolean.length))
    {
      AppMethodBeat.o(81029);
      return;
    }
    ab.d("MicroMsg.HighlightRectSideView", "%s, %s, %s, %s", new Object[] { Boolean.valueOf(paramArrayOfBoolean[0]), Boolean.valueOf(paramArrayOfBoolean[1]), Boolean.valueOf(paramArrayOfBoolean[2]), Boolean.valueOf(paramArrayOfBoolean[3]) });
    while (i < 4)
    {
      this.qxe[i] = paramArrayOfBoolean[i];
      i += 1;
    }
    invalidate();
    AppMethodBeat.o(81029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.HighlightRectSideView
 * JD-Core Version:    0.7.0.1
 */