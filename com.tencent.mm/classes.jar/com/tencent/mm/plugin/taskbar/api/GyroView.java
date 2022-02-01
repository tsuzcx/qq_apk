package com.tencent.mm.plugin.taskbar.api;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class GyroView
  extends View
{
  private float Mnm;
  private float Mnn;
  private float Mno;
  private float Mnp;
  private float Mnq;
  private float Mnr;
  private boolean Mns;
  private Paint mPaint;
  private float yW;
  
  public GyroView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(256267);
    this.Mnm = 0.0F;
    this.Mnn = 0.0F;
    this.Mns = false;
    this.Mnp = (40.0F * getResources().getDisplayMetrics().density);
    this.Mno = (100.0F * getResources().getDisplayMetrics().density);
    this.yW = (20.0F * getResources().getDisplayMetrics().density);
    this.Mnq = (10.0F * getResources().getDisplayMetrics().density);
    this.Mnr = (6.0F * getResources().getDisplayMetrics().density);
    this.mPaint = new Paint(1);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(-9934744);
    AppMethodBeat.o(256267);
  }
  
  public final void f(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(256270);
    float f2 = (paramFloat - this.Mnp) / (paramInt - this.Mnp);
    float f1 = f2;
    if (this.Mns) {
      f1 = 1.0F - f2;
    }
    this.Mnn = Math.max(0.0F, Math.min(f1, 1.0F));
    f2 = paramFloat / this.Mnp;
    f1 = f2;
    if (this.Mns) {
      f1 = 1.0F - f2;
    }
    this.Mnm = Math.max(0.0F, Math.min(f1, 1.0F));
    Log.d("MicroMsg.GyroView", "alvinluo GyroView setVerticalScroll y: %f, limit: %d, percent: %f, paddingPercent: %f", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(paramInt), Float.valueOf(this.Mnm), Float.valueOf(this.Mnn) });
    postInvalidate();
    AppMethodBeat.o(256270);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(256268);
    super.onDraw(paramCanvas);
    float f1 = getMeasuredWidth() / 2.0F;
    float f2 = getMeasuredHeight() / 2.0F;
    if (this.Mnn > 0.0F)
    {
      paramCanvas.drawCircle(f1, f2, this.Mnq / 2.0F - this.Mnn * (this.Mnq - this.Mnr) / 2.0F, this.mPaint);
      paramCanvas.drawCircle(f1 - this.Mnn * this.yW, f2, this.Mnr / 2.0F, this.mPaint);
      paramCanvas.drawCircle(f1 + this.Mnn * this.yW, f2, this.Mnr / 2.0F, this.mPaint);
      AppMethodBeat.o(256268);
      return;
    }
    paramCanvas.drawCircle(f1, f2, this.Mnm * this.Mnq / 2.0F, this.mPaint);
    AppMethodBeat.o(256268);
  }
  
  public void setVerticalScroll(float paramFloat)
  {
    AppMethodBeat.i(256269);
    float f2 = (paramFloat - this.Mnp) / (this.Mno - this.Mnp);
    float f1 = f2;
    if (this.Mns) {
      f1 = 1.0F - f2;
    }
    this.Mnn = Math.max(0.0F, Math.min(f1, 1.0F));
    f1 = paramFloat / this.Mnp;
    paramFloat = f1;
    if (this.Mns) {
      paramFloat = 1.0F - f1;
    }
    this.Mnm = Math.max(0.0F, Math.min(paramFloat, 1.0F));
    postInvalidate();
    AppMethodBeat.o(256269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.api.GyroView
 * JD-Core Version:    0.7.0.1
 */