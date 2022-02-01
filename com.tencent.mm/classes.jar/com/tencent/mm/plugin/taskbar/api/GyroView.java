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
  private float FSi;
  private float FSj;
  private float FSk;
  private float FSl;
  private float FSm;
  private float FSn;
  private boolean FSo;
  private float auO;
  private Paint mPaint;
  
  public GyroView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(197270);
    this.FSi = 0.0F;
    this.FSj = 0.0F;
    this.FSo = false;
    this.FSl = (40.0F * getResources().getDisplayMetrics().density);
    this.FSk = (100.0F * getResources().getDisplayMetrics().density);
    this.auO = (20.0F * getResources().getDisplayMetrics().density);
    this.FSm = (10.0F * getResources().getDisplayMetrics().density);
    this.FSn = (6.0F * getResources().getDisplayMetrics().density);
    this.mPaint = new Paint(1);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(-9934744);
    AppMethodBeat.o(197270);
  }
  
  public final void c(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(197273);
    float f2 = (paramFloat - this.FSl) / (paramInt - this.FSl);
    float f1 = f2;
    if (this.FSo) {
      f1 = 1.0F - f2;
    }
    this.FSj = Math.max(0.0F, Math.min(f1, 1.0F));
    f2 = paramFloat / this.FSl;
    f1 = f2;
    if (this.FSo) {
      f1 = 1.0F - f2;
    }
    this.FSi = Math.max(0.0F, Math.min(f1, 1.0F));
    Log.d("MicroMsg.GyroView", "alvinluo GyroView setVerticalScroll y: %f, limit: %d, percent: %f, paddingPercent: %f", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(paramInt), Float.valueOf(this.FSi), Float.valueOf(this.FSj) });
    postInvalidate();
    AppMethodBeat.o(197273);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(197271);
    super.onDraw(paramCanvas);
    float f1 = getMeasuredWidth() / 2.0F;
    float f2 = getMeasuredHeight() / 2.0F;
    if (this.FSj > 0.0F)
    {
      paramCanvas.drawCircle(f1, f2, this.FSm / 2.0F - this.FSj * (this.FSm - this.FSn) / 2.0F, this.mPaint);
      paramCanvas.drawCircle(f1 - this.FSj * this.auO, f2, this.FSn / 2.0F, this.mPaint);
      paramCanvas.drawCircle(f1 + this.FSj * this.auO, f2, this.FSn / 2.0F, this.mPaint);
      AppMethodBeat.o(197271);
      return;
    }
    paramCanvas.drawCircle(f1, f2, this.FSi * this.FSm / 2.0F, this.mPaint);
    AppMethodBeat.o(197271);
  }
  
  public void setVerticalScroll(float paramFloat)
  {
    AppMethodBeat.i(197272);
    float f2 = (paramFloat - this.FSl) / (this.FSk - this.FSl);
    float f1 = f2;
    if (this.FSo) {
      f1 = 1.0F - f2;
    }
    this.FSj = Math.max(0.0F, Math.min(f1, 1.0F));
    f1 = paramFloat / this.FSl;
    paramFloat = f1;
    if (this.FSo) {
      paramFloat = 1.0F - f1;
    }
    this.FSi = Math.max(0.0F, Math.min(paramFloat, 1.0F));
    postInvalidate();
    AppMethodBeat.o(197272);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.api.GyroView
 * JD-Core Version:    0.7.0.1
 */