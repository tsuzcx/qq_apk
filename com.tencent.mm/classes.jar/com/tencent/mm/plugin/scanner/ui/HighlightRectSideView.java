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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;

public class HighlightRectSideView
  extends View
{
  private aw cji;
  private Paint xS;
  private boolean[] yGL;
  private Rect yGM;
  private int yGN;
  private int yGO;
  private int yGP;
  private int yGQ;
  
  public HighlightRectSideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51795);
    this.yGQ = 0;
    this.cji = new aw(new aw.a()
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
    this.yGN = paramContext.getWidth();
    this.yGO = paramContext.getHeight();
    if (this.yGO != this.yGN) {
      ae.e("MicroMsg.HighlightRectSideView", "width is not same as height");
    }
    this.yGP = (this.yGN * 6 / 24);
    this.yGL = new boolean[4];
    this.xS = new Paint();
    this.xS.setColor(6676738);
    this.xS.setAlpha(255);
    this.xS.setStrokeWidth(this.yGP);
    this.xS.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(51795);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(51797);
    super.onAttachedToWindow();
    this.cji.ay(300L, 300L);
    AppMethodBeat.o(51797);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(51798);
    super.onDetachedFromWindow();
    if (this.cji != null)
    {
      this.cji.stopTimer();
      this.cji = null;
    }
    AppMethodBeat.o(51798);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(51799);
    super.onDraw(paramCanvas);
    int i = 0;
    if (i < 4) {
      if (this.yGL[i] != 0) {}
    }
    for (i = 0;; i = 1)
    {
      int j = this.yGP / 2;
      if ((this.yGL[0] != 0) && ((1 == i) || (this.yGQ % 2 == 0))) {
        paramCanvas.drawLine(this.yGM.left + j, this.yGM.top + this.yGO, this.yGM.left + j, this.yGM.bottom - this.yGO, this.xS);
      }
      if ((this.yGL[1] != 0) && ((1 == i) || (this.yGQ % 2 == 0))) {
        paramCanvas.drawLine(this.yGM.right - j, this.yGM.top + this.yGO, this.yGM.right - j, this.yGM.bottom - this.yGO, this.xS);
      }
      if ((this.yGL[2] != 0) && ((1 == i) || (this.yGQ % 3 == 0))) {
        paramCanvas.drawLine(this.yGM.left + this.yGN, this.yGM.top + j, this.yGM.right - this.yGN, this.yGM.top + j, this.xS);
      }
      if ((this.yGL[3] != 0) && ((1 == i) || (this.yGQ % 3 == 0))) {
        paramCanvas.drawLine(this.yGM.left + this.yGN, this.yGM.bottom - j, this.yGM.right - this.yGN, this.yGM.bottom - j, this.xS);
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
    this.yGM = paramRect;
    ae.d("MicroMsg.HighlightRectSideView", "rect:%s", new Object[] { paramRect });
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
    ae.d("MicroMsg.HighlightRectSideView", "%s, %s, %s, %s", new Object[] { Boolean.valueOf(paramArrayOfBoolean[0]), Boolean.valueOf(paramArrayOfBoolean[1]), Boolean.valueOf(paramArrayOfBoolean[2]), Boolean.valueOf(paramArrayOfBoolean[3]) });
    while (i < 4)
    {
      this.yGL[i] = paramArrayOfBoolean[i];
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