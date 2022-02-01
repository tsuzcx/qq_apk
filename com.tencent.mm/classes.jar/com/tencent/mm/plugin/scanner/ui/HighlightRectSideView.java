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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public class HighlightRectSideView
  extends View
{
  private Rect CKA;
  private int CKB;
  private int CKC;
  private int CKD;
  private int CKE;
  private boolean[] CKz;
  private MTimerHandler cve;
  private Paint xY;
  
  public HighlightRectSideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51795);
    this.CKE = 0;
    this.cve = new MTimerHandler(new MTimerHandler.CallBack()
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
    paramContext = a.decodeResource(getResources(), 2131234738);
    this.CKB = paramContext.getWidth();
    this.CKC = paramContext.getHeight();
    if (this.CKC != this.CKB) {
      Log.e("MicroMsg.HighlightRectSideView", "width is not same as height");
    }
    this.CKD = (this.CKB * 6 / 24);
    this.CKz = new boolean[4];
    this.xY = new Paint();
    this.xY.setColor(6676738);
    this.xY.setAlpha(255);
    this.xY.setStrokeWidth(this.CKD);
    this.xY.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(51795);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(51797);
    super.onAttachedToWindow();
    this.cve.startTimer(300L);
    AppMethodBeat.o(51797);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(51798);
    super.onDetachedFromWindow();
    if (this.cve != null)
    {
      this.cve.stopTimer();
      this.cve = null;
    }
    AppMethodBeat.o(51798);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(51799);
    super.onDraw(paramCanvas);
    int i = 0;
    if (i < 4) {
      if (this.CKz[i] != 0) {}
    }
    for (i = 0;; i = 1)
    {
      int j = this.CKD / 2;
      if ((this.CKz[0] != 0) && ((1 == i) || (this.CKE % 2 == 0))) {
        paramCanvas.drawLine(this.CKA.left + j, this.CKA.top + this.CKC, this.CKA.left + j, this.CKA.bottom - this.CKC, this.xY);
      }
      if ((this.CKz[1] != 0) && ((1 == i) || (this.CKE % 2 == 0))) {
        paramCanvas.drawLine(this.CKA.right - j, this.CKA.top + this.CKC, this.CKA.right - j, this.CKA.bottom - this.CKC, this.xY);
      }
      if ((this.CKz[2] != 0) && ((1 == i) || (this.CKE % 3 == 0))) {
        paramCanvas.drawLine(this.CKA.left + this.CKB, this.CKA.top + j, this.CKA.right - this.CKB, this.CKA.top + j, this.xY);
      }
      if ((this.CKz[3] != 0) && ((1 == i) || (this.CKE % 3 == 0))) {
        paramCanvas.drawLine(this.CKA.left + this.CKB, this.CKA.bottom - j, this.CKA.right - this.CKB, this.CKA.bottom - j, this.xY);
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
    this.CKA = paramRect;
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
      this.CKz[i] = paramArrayOfBoolean[i];
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