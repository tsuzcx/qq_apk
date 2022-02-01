package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends View
{
  private a ESX;
  private int mPadding;
  private Paint mPaint;
  private int mType;
  private RectF pCC;
  private RectF pCD;
  private RectF pCE;
  private RectF pCF;
  private int pCG;
  private int pCH;
  private int pCI;
  private int pCJ;
  
  public a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(30544);
    this.mType = 2;
    this.mType = paramInt1;
    this.pCH = paramInt2;
    this.pCI = paramInt3;
    this.pCG = (this.pCH * 2 / 5);
    this.mPadding = this.pCG;
    this.pCJ = (this.pCG * 3 / 4);
    this.mPaint = new Paint(1);
    this.mPaint.setColor(paramInt4);
    this.ESX = parama;
    this.pCC = new RectF(this.mPadding, this.pCH, this.mPadding + this.pCG * 2, this.pCH + this.pCG * 2);
    this.pCD = new RectF(this.pCJ - this.pCG, this.pCH, this.pCJ + this.pCG, this.pCH + this.pCG * 2);
    this.pCE = new RectF(this.mPadding, this.pCH, this.mPadding + this.pCG * 2, this.pCH + this.pCG * 2);
    this.pCF = new RectF(this.mPadding + this.pCI, this.pCH, this.mPadding + this.pCI + this.pCG * 2, this.pCH + this.pCG * 2);
    AppMethodBeat.o(30544);
  }
  
  public final int getOffsetForCursorMid()
  {
    return this.mPadding + this.pCG + 1;
  }
  
  public final int getType()
  {
    return this.mType;
  }
  
  public final int getViewHeight()
  {
    return this.pCH + this.pCG * 2 + this.mPadding;
  }
  
  public final int getViewPadding()
  {
    return this.mPadding;
  }
  
  public final int getViewWidth()
  {
    if ((this.mType == 3) || (this.mType == 4)) {
      return this.mPadding + this.pCG + this.pCJ;
    }
    return this.pCI + (this.mPadding + this.pCG) * 2;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(30545);
    switch (this.mType)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30545);
      return;
      paramCanvas.drawRect(this.mPadding + this.pCG, 0.0F, this.mPadding + this.pCG + this.pCI, this.pCH + this.pCG * 2, this.mPaint);
      paramCanvas.drawArc(this.pCE, 90.0F, 180.0F, true, this.mPaint);
      paramCanvas.drawArc(this.pCF, 270.0F, 180.0F, true, this.mPaint);
      AppMethodBeat.o(30545);
      return;
      paramCanvas.drawRect(this.mPadding + this.pCG + this.pCJ - this.pCI, 0.0F, this.mPadding + this.pCG + this.pCJ, this.pCH, this.mPaint);
      paramCanvas.drawArc(this.pCC, 90.0F, 180.0F, true, this.mPaint);
      paramCanvas.drawRect(this.mPadding + this.pCG, this.pCH, this.mPadding + this.pCG + this.pCJ, this.pCH + this.pCG * 2, this.mPaint);
      AppMethodBeat.o(30545);
      return;
      paramCanvas.drawRect(0.0F, 0.0F, this.pCI, this.pCH, this.mPaint);
      paramCanvas.drawRect(0.0F, this.pCH, this.pCJ, this.pCH + this.pCG * 2, this.mPaint);
      paramCanvas.drawArc(this.pCD, 270.0F, 180.0F, true, this.mPaint);
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(30546);
    if (this.ESX != null) {
      this.ESX.a(this.mType, paramMotionEvent);
    }
    AppMethodBeat.o(30546);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.a
 * JD-Core Version:    0.7.0.1
 */