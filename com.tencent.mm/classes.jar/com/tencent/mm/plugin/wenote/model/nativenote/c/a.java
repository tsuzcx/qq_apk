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
  private a CWF;
  private int mPadding;
  private Paint mPaint;
  private int mType;
  private RectF oSo;
  private RectF oSp;
  private RectF oSq;
  private RectF oSr;
  private int oSs;
  private int oSt;
  private int oSu;
  private int oSv;
  
  public a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(30544);
    this.mType = 2;
    this.mType = paramInt1;
    this.oSt = paramInt2;
    this.oSu = paramInt3;
    this.oSs = (this.oSt * 2 / 5);
    this.mPadding = this.oSs;
    this.oSv = (this.oSs * 3 / 4);
    this.mPaint = new Paint(1);
    this.mPaint.setColor(paramInt4);
    this.CWF = parama;
    this.oSo = new RectF(this.mPadding, this.oSt, this.mPadding + this.oSs * 2, this.oSt + this.oSs * 2);
    this.oSp = new RectF(this.oSv - this.oSs, this.oSt, this.oSv + this.oSs, this.oSt + this.oSs * 2);
    this.oSq = new RectF(this.mPadding, this.oSt, this.mPadding + this.oSs * 2, this.oSt + this.oSs * 2);
    this.oSr = new RectF(this.mPadding + this.oSu, this.oSt, this.mPadding + this.oSu + this.oSs * 2, this.oSt + this.oSs * 2);
    AppMethodBeat.o(30544);
  }
  
  public final int getOffsetForCursorMid()
  {
    return this.mPadding + this.oSs + 1;
  }
  
  public final int getType()
  {
    return this.mType;
  }
  
  public final int getViewHeight()
  {
    return this.oSt + this.oSs * 2 + this.mPadding;
  }
  
  public final int getViewPadding()
  {
    return this.mPadding;
  }
  
  public final int getViewWidth()
  {
    if ((this.mType == 3) || (this.mType == 4)) {
      return this.mPadding + this.oSs + this.oSv;
    }
    return this.oSu + (this.mPadding + this.oSs) * 2;
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
      paramCanvas.drawRect(this.mPadding + this.oSs, 0.0F, this.mPadding + this.oSs + this.oSu, this.oSt + this.oSs * 2, this.mPaint);
      paramCanvas.drawArc(this.oSq, 90.0F, 180.0F, true, this.mPaint);
      paramCanvas.drawArc(this.oSr, 270.0F, 180.0F, true, this.mPaint);
      AppMethodBeat.o(30545);
      return;
      paramCanvas.drawRect(this.mPadding + this.oSs + this.oSv - this.oSu, 0.0F, this.mPadding + this.oSs + this.oSv, this.oSt, this.mPaint);
      paramCanvas.drawArc(this.oSo, 90.0F, 180.0F, true, this.mPaint);
      paramCanvas.drawRect(this.mPadding + this.oSs, this.oSt, this.mPadding + this.oSs + this.oSv, this.oSt + this.oSs * 2, this.mPaint);
      AppMethodBeat.o(30545);
      return;
      paramCanvas.drawRect(0.0F, 0.0F, this.oSu, this.oSt, this.mPaint);
      paramCanvas.drawRect(0.0F, this.oSt, this.oSv, this.oSt + this.oSs * 2, this.mPaint);
      paramCanvas.drawArc(this.oSp, 270.0F, 180.0F, true, this.mPaint);
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(30546);
    if (this.CWF != null) {
      this.CWF.a(this.mType, paramMotionEvent);
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