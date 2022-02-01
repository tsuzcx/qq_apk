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
  private a EAB;
  private int mPadding;
  private Paint mPaint;
  private int mType;
  private RectF pvY;
  private RectF pvZ;
  private RectF pwa;
  private RectF pwb;
  private int pwc;
  private int pwd;
  private int pwe;
  private int pwf;
  
  public a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(30544);
    this.mType = 2;
    this.mType = paramInt1;
    this.pwd = paramInt2;
    this.pwe = paramInt3;
    this.pwc = (this.pwd * 2 / 5);
    this.mPadding = this.pwc;
    this.pwf = (this.pwc * 3 / 4);
    this.mPaint = new Paint(1);
    this.mPaint.setColor(paramInt4);
    this.EAB = parama;
    this.pvY = new RectF(this.mPadding, this.pwd, this.mPadding + this.pwc * 2, this.pwd + this.pwc * 2);
    this.pvZ = new RectF(this.pwf - this.pwc, this.pwd, this.pwf + this.pwc, this.pwd + this.pwc * 2);
    this.pwa = new RectF(this.mPadding, this.pwd, this.mPadding + this.pwc * 2, this.pwd + this.pwc * 2);
    this.pwb = new RectF(this.mPadding + this.pwe, this.pwd, this.mPadding + this.pwe + this.pwc * 2, this.pwd + this.pwc * 2);
    AppMethodBeat.o(30544);
  }
  
  public final int getOffsetForCursorMid()
  {
    return this.mPadding + this.pwc + 1;
  }
  
  public final int getType()
  {
    return this.mType;
  }
  
  public final int getViewHeight()
  {
    return this.pwd + this.pwc * 2 + this.mPadding;
  }
  
  public final int getViewPadding()
  {
    return this.mPadding;
  }
  
  public final int getViewWidth()
  {
    if ((this.mType == 3) || (this.mType == 4)) {
      return this.mPadding + this.pwc + this.pwf;
    }
    return this.pwe + (this.mPadding + this.pwc) * 2;
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
      paramCanvas.drawRect(this.mPadding + this.pwc, 0.0F, this.mPadding + this.pwc + this.pwe, this.pwd + this.pwc * 2, this.mPaint);
      paramCanvas.drawArc(this.pwa, 90.0F, 180.0F, true, this.mPaint);
      paramCanvas.drawArc(this.pwb, 270.0F, 180.0F, true, this.mPaint);
      AppMethodBeat.o(30545);
      return;
      paramCanvas.drawRect(this.mPadding + this.pwc + this.pwf - this.pwe, 0.0F, this.mPadding + this.pwc + this.pwf, this.pwd, this.mPaint);
      paramCanvas.drawArc(this.pvY, 90.0F, 180.0F, true, this.mPaint);
      paramCanvas.drawRect(this.mPadding + this.pwc, this.pwd, this.mPadding + this.pwc + this.pwf, this.pwd + this.pwc * 2, this.mPaint);
      AppMethodBeat.o(30545);
      return;
      paramCanvas.drawRect(0.0F, 0.0F, this.pwe, this.pwd, this.mPaint);
      paramCanvas.drawRect(0.0F, this.pwd, this.pwf, this.pwd + this.pwc * 2, this.mPaint);
      paramCanvas.drawArc(this.pvZ, 270.0F, 180.0F, true, this.mPaint);
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(30546);
    if (this.EAB != null) {
      this.EAB.a(this.mType, paramMotionEvent);
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