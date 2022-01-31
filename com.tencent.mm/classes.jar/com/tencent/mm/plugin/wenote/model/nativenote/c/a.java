package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

public final class a
  extends View
{
  private int dsI;
  private Paint mPaint;
  private int mType = 2;
  private int qQq;
  private RectF rJl;
  private RectF rJm;
  private RectF rJn;
  private RectF rJo;
  private int rJp;
  private int rJq;
  private int rJr;
  private a.a rJs;
  
  public a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, a.a parama)
  {
    super(paramContext);
    this.mType = paramInt1;
    this.rJq = paramInt2;
    this.qQq = paramInt3;
    this.rJp = (this.rJq * 2 / 5);
    this.dsI = this.rJp;
    this.rJr = (this.rJp * 3 / 4);
    this.mPaint = new Paint(1);
    this.mPaint.setColor(paramInt4);
    this.rJs = parama;
    this.rJl = new RectF(this.dsI, this.rJq, this.dsI + this.rJp * 2, this.rJq + this.rJp * 2);
    this.rJm = new RectF(this.rJr - this.rJp, this.rJq, this.rJr + this.rJp, this.rJq + this.rJp * 2);
    this.rJn = new RectF(this.dsI, this.rJq, this.dsI + this.rJp * 2, this.rJq + this.rJp * 2);
    this.rJo = new RectF(this.dsI + this.qQq, this.rJq, this.dsI + this.qQq + this.rJp * 2, this.rJq + this.rJp * 2);
  }
  
  public final int getOffsetForCursorMid()
  {
    return this.dsI + this.rJp + 1;
  }
  
  public final int getType()
  {
    return this.mType;
  }
  
  public final int getViewHeight()
  {
    return this.rJq + this.rJp * 2 + this.dsI;
  }
  
  public final int getViewPadding()
  {
    return this.dsI;
  }
  
  public final int getViewWidth()
  {
    if ((this.mType == 3) || (this.mType == 4)) {
      return this.dsI + this.rJp + this.rJr;
    }
    return this.qQq + (this.dsI + this.rJp) * 2;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    switch (this.mType)
    {
    default: 
      return;
    case 2: 
      paramCanvas.drawRect(this.dsI + this.rJp, 0.0F, this.dsI + this.rJp + this.qQq, this.rJq + this.rJp * 2, this.mPaint);
      paramCanvas.drawArc(this.rJn, 90.0F, 180.0F, true, this.mPaint);
      paramCanvas.drawArc(this.rJo, 270.0F, 180.0F, true, this.mPaint);
      return;
    case 3: 
      paramCanvas.drawRect(this.dsI + this.rJp + this.rJr - this.qQq, 0.0F, this.dsI + this.rJp + this.rJr, this.rJq, this.mPaint);
      paramCanvas.drawArc(this.rJl, 90.0F, 180.0F, true, this.mPaint);
      paramCanvas.drawRect(this.dsI + this.rJp, this.rJq, this.dsI + this.rJp + this.rJr, this.rJq + this.rJp * 2, this.mPaint);
      return;
    }
    paramCanvas.drawRect(0.0F, 0.0F, this.qQq, this.rJq, this.mPaint);
    paramCanvas.drawRect(0.0F, this.rJq, this.rJr, this.rJq + this.rJp * 2, this.mPaint);
    paramCanvas.drawArc(this.rJm, 270.0F, 180.0F, true, this.mPaint);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.rJs != null) {
      this.rJs.a(this.mType, paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.a
 * JD-Core Version:    0.7.0.1
 */