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
  private av cjg;
  private Paint xS;
  private boolean[] yqL;
  private Rect yqM;
  private int yqN;
  private int yqO;
  private int yqP;
  private int yqQ;
  
  public HighlightRectSideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51795);
    this.yqQ = 0;
    this.cjg = new av(new av.a()
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
    this.yqN = paramContext.getWidth();
    this.yqO = paramContext.getHeight();
    if (this.yqO != this.yqN) {
      ad.e("MicroMsg.HighlightRectSideView", "width is not same as height");
    }
    this.yqP = (this.yqN * 6 / 24);
    this.yqL = new boolean[4];
    this.xS = new Paint();
    this.xS.setColor(6676738);
    this.xS.setAlpha(255);
    this.xS.setStrokeWidth(this.yqP);
    this.xS.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(51795);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(51797);
    super.onAttachedToWindow();
    this.cjg.az(300L, 300L);
    AppMethodBeat.o(51797);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(51798);
    super.onDetachedFromWindow();
    if (this.cjg != null)
    {
      this.cjg.stopTimer();
      this.cjg = null;
    }
    AppMethodBeat.o(51798);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(51799);
    super.onDraw(paramCanvas);
    int i = 0;
    if (i < 4) {
      if (this.yqL[i] != 0) {}
    }
    for (i = 0;; i = 1)
    {
      int j = this.yqP / 2;
      if ((this.yqL[0] != 0) && ((1 == i) || (this.yqQ % 2 == 0))) {
        paramCanvas.drawLine(this.yqM.left + j, this.yqM.top + this.yqO, this.yqM.left + j, this.yqM.bottom - this.yqO, this.xS);
      }
      if ((this.yqL[1] != 0) && ((1 == i) || (this.yqQ % 2 == 0))) {
        paramCanvas.drawLine(this.yqM.right - j, this.yqM.top + this.yqO, this.yqM.right - j, this.yqM.bottom - this.yqO, this.xS);
      }
      if ((this.yqL[2] != 0) && ((1 == i) || (this.yqQ % 3 == 0))) {
        paramCanvas.drawLine(this.yqM.left + this.yqN, this.yqM.top + j, this.yqM.right - this.yqN, this.yqM.top + j, this.xS);
      }
      if ((this.yqL[3] != 0) && ((1 == i) || (this.yqQ % 3 == 0))) {
        paramCanvas.drawLine(this.yqM.left + this.yqN, this.yqM.bottom - j, this.yqM.right - this.yqN, this.yqM.bottom - j, this.xS);
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
    this.yqM = paramRect;
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
      this.yqL[i] = paramArrayOfBoolean[i];
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