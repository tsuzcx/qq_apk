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
  private a XBC;
  private int ebX;
  private Paint mPaint;
  private int mType;
  private RectF xAA;
  private int xAB;
  private int xAC;
  private int xAD;
  private int xAE;
  private RectF xAx;
  private RectF xAy;
  private RectF xAz;
  
  public a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(30544);
    this.mType = 2;
    this.mType = paramInt1;
    this.xAC = paramInt2;
    this.xAD = paramInt3;
    this.xAB = (this.xAC * 2 / 5);
    this.ebX = this.xAB;
    this.xAE = (this.xAB * 3 / 4);
    this.mPaint = new Paint(1);
    this.mPaint.setColor(paramInt4);
    this.XBC = parama;
    this.xAx = new RectF(this.ebX, this.xAC, this.ebX + this.xAB * 2, this.xAC + this.xAB * 2);
    this.xAy = new RectF(this.xAE - this.xAB, this.xAC, this.xAE + this.xAB, this.xAC + this.xAB * 2);
    this.xAz = new RectF(this.ebX, this.xAC, this.ebX + this.xAB * 2, this.xAC + this.xAB * 2);
    this.xAA = new RectF(this.ebX + this.xAD, this.xAC, this.ebX + this.xAD + this.xAB * 2, this.xAC + this.xAB * 2);
    AppMethodBeat.o(30544);
  }
  
  public final int getOffsetForCursorMid()
  {
    return this.ebX + this.xAB + 1;
  }
  
  public final int getType()
  {
    return this.mType;
  }
  
  public final int getViewHeight()
  {
    return this.xAC + this.xAB * 2 + this.ebX;
  }
  
  public final int getViewPadding()
  {
    return this.ebX;
  }
  
  public final int getViewWidth()
  {
    if ((this.mType == 3) || (this.mType == 4)) {
      return this.ebX + this.xAB + this.xAE;
    }
    return this.xAD + (this.ebX + this.xAB) * 2;
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
      paramCanvas.drawRect(this.ebX + this.xAB, 0.0F, this.ebX + this.xAB + this.xAD, this.xAC + this.xAB * 2, this.mPaint);
      paramCanvas.drawArc(this.xAz, 90.0F, 180.0F, true, this.mPaint);
      paramCanvas.drawArc(this.xAA, 270.0F, 180.0F, true, this.mPaint);
      AppMethodBeat.o(30545);
      return;
      paramCanvas.drawRect(this.ebX + this.xAB + this.xAE - this.xAD, 0.0F, this.ebX + this.xAB + this.xAE, this.xAC, this.mPaint);
      paramCanvas.drawArc(this.xAx, 90.0F, 180.0F, true, this.mPaint);
      paramCanvas.drawRect(this.ebX + this.xAB, this.xAC, this.ebX + this.xAB + this.xAE, this.xAC + this.xAB * 2, this.mPaint);
      AppMethodBeat.o(30545);
      return;
      paramCanvas.drawRect(0.0F, 0.0F, this.xAD, this.xAC, this.mPaint);
      paramCanvas.drawRect(0.0F, this.xAC, this.xAE, this.xAC + this.xAB * 2, this.mPaint);
      paramCanvas.drawArc(this.xAy, 270.0F, 180.0F, true, this.mPaint);
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(30546);
    if (this.XBC != null) {
      this.XBC.a(this.mType, paramMotionEvent);
    }
    AppMethodBeat.o(30546);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.a
 * JD-Core Version:    0.7.0.1
 */