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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;

public class HighlightRectSideView
  extends View
{
  private au bYO;
  private Paint vZ;
  private boolean[] xcJ;
  private Rect xcK;
  private int xcL;
  private int xcM;
  private int xcN;
  private int xcO;
  
  public HighlightRectSideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51795);
    this.xcO = 0;
    this.bYO = new au(new au.a()
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
    this.xcL = paramContext.getWidth();
    this.xcM = paramContext.getHeight();
    if (this.xcM != this.xcL) {
      ac.e("MicroMsg.HighlightRectSideView", "width is not same as height");
    }
    this.xcN = (this.xcL * 6 / 24);
    this.xcJ = new boolean[4];
    this.vZ = new Paint();
    this.vZ.setColor(6676738);
    this.vZ.setAlpha(255);
    this.vZ.setStrokeWidth(this.xcN);
    this.vZ.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(51795);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(51797);
    super.onAttachedToWindow();
    this.bYO.au(300L, 300L);
    AppMethodBeat.o(51797);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(51798);
    super.onDetachedFromWindow();
    if (this.bYO != null)
    {
      this.bYO.stopTimer();
      this.bYO = null;
    }
    AppMethodBeat.o(51798);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(51799);
    super.onDraw(paramCanvas);
    int i = 0;
    if (i < 4) {
      if (this.xcJ[i] != 0) {}
    }
    for (i = 0;; i = 1)
    {
      int j = this.xcN / 2;
      if ((this.xcJ[0] != 0) && ((1 == i) || (this.xcO % 2 == 0))) {
        paramCanvas.drawLine(this.xcK.left + j, this.xcK.top + this.xcM, this.xcK.left + j, this.xcK.bottom - this.xcM, this.vZ);
      }
      if ((this.xcJ[1] != 0) && ((1 == i) || (this.xcO % 2 == 0))) {
        paramCanvas.drawLine(this.xcK.right - j, this.xcK.top + this.xcM, this.xcK.right - j, this.xcK.bottom - this.xcM, this.vZ);
      }
      if ((this.xcJ[2] != 0) && ((1 == i) || (this.xcO % 3 == 0))) {
        paramCanvas.drawLine(this.xcK.left + this.xcL, this.xcK.top + j, this.xcK.right - this.xcL, this.xcK.top + j, this.vZ);
      }
      if ((this.xcJ[3] != 0) && ((1 == i) || (this.xcO % 3 == 0))) {
        paramCanvas.drawLine(this.xcK.left + this.xcL, this.xcK.bottom - j, this.xcK.right - this.xcL, this.xcK.bottom - j, this.vZ);
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
    this.xcK = paramRect;
    ac.d("MicroMsg.HighlightRectSideView", "rect:%s", new Object[] { paramRect });
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
    ac.d("MicroMsg.HighlightRectSideView", "%s, %s, %s, %s", new Object[] { Boolean.valueOf(paramArrayOfBoolean[0]), Boolean.valueOf(paramArrayOfBoolean[1]), Boolean.valueOf(paramArrayOfBoolean[2]), Boolean.valueOf(paramArrayOfBoolean[3]) });
    while (i < 4)
    {
      this.xcJ[i] = paramArrayOfBoolean[i];
      i += 1;
    }
    invalidate();
    AppMethodBeat.o(51800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.HighlightRectSideView
 * JD-Core Version:    0.7.0.1
 */