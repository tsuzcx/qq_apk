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
  private int mPadding;
  private Paint mPaint;
  private int mType;
  private int sKW;
  private int uFy;
  private RectF vzQ;
  private RectF vzR;
  private RectF vzS;
  private RectF vzT;
  private int vzU;
  private int vzV;
  private a.a vzW;
  
  public a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, a.a parama)
  {
    super(paramContext);
    AppMethodBeat.i(26851);
    this.mType = 2;
    this.mType = paramInt1;
    this.vzV = paramInt2;
    this.uFy = paramInt3;
    this.vzU = (this.vzV * 2 / 5);
    this.mPadding = this.vzU;
    this.sKW = (this.vzU * 3 / 4);
    this.mPaint = new Paint(1);
    this.mPaint.setColor(paramInt4);
    this.vzW = parama;
    this.vzQ = new RectF(this.mPadding, this.vzV, this.mPadding + this.vzU * 2, this.vzV + this.vzU * 2);
    this.vzR = new RectF(this.sKW - this.vzU, this.vzV, this.sKW + this.vzU, this.vzV + this.vzU * 2);
    this.vzS = new RectF(this.mPadding, this.vzV, this.mPadding + this.vzU * 2, this.vzV + this.vzU * 2);
    this.vzT = new RectF(this.mPadding + this.uFy, this.vzV, this.mPadding + this.uFy + this.vzU * 2, this.vzV + this.vzU * 2);
    AppMethodBeat.o(26851);
  }
  
  public final int getOffsetForCursorMid()
  {
    return this.mPadding + this.vzU + 1;
  }
  
  public final int getType()
  {
    return this.mType;
  }
  
  public final int getViewHeight()
  {
    return this.vzV + this.vzU * 2 + this.mPadding;
  }
  
  public final int getViewPadding()
  {
    return this.mPadding;
  }
  
  public final int getViewWidth()
  {
    if ((this.mType == 3) || (this.mType == 4)) {
      return this.mPadding + this.vzU + this.sKW;
    }
    return this.uFy + (this.mPadding + this.vzU) * 2;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(26852);
    switch (this.mType)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26852);
      return;
      paramCanvas.drawRect(this.mPadding + this.vzU, 0.0F, this.mPadding + this.vzU + this.uFy, this.vzV + this.vzU * 2, this.mPaint);
      paramCanvas.drawArc(this.vzS, 90.0F, 180.0F, true, this.mPaint);
      paramCanvas.drawArc(this.vzT, 270.0F, 180.0F, true, this.mPaint);
      AppMethodBeat.o(26852);
      return;
      paramCanvas.drawRect(this.mPadding + this.vzU + this.sKW - this.uFy, 0.0F, this.mPadding + this.vzU + this.sKW, this.vzV, this.mPaint);
      paramCanvas.drawArc(this.vzQ, 90.0F, 180.0F, true, this.mPaint);
      paramCanvas.drawRect(this.mPadding + this.vzU, this.vzV, this.mPadding + this.vzU + this.sKW, this.vzV + this.vzU * 2, this.mPaint);
      AppMethodBeat.o(26852);
      return;
      paramCanvas.drawRect(0.0F, 0.0F, this.uFy, this.vzV, this.mPaint);
      paramCanvas.drawRect(0.0F, this.vzV, this.sKW, this.vzV + this.vzU * 2, this.mPaint);
      paramCanvas.drawArc(this.vzR, 270.0F, 180.0F, true, this.mPaint);
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(26853);
    if (this.vzW != null) {
      this.vzW.a(this.mType, paramMotionEvent);
    }
    AppMethodBeat.o(26853);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.a
 * JD-Core Version:    0.7.0.1
 */