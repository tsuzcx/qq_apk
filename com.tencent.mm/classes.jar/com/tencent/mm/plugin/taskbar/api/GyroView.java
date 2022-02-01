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
  private float Rl;
  private float SQF;
  private float SQG;
  private float SQH;
  private float SQI;
  private float SQJ;
  private float SQK;
  private boolean SQL;
  private Paint mPaint;
  
  public GyroView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(264005);
    this.SQF = 0.0F;
    this.SQG = 0.0F;
    this.SQL = false;
    this.SQI = (40.0F * getResources().getDisplayMetrics().density);
    this.SQH = (100.0F * getResources().getDisplayMetrics().density);
    this.Rl = (20.0F * getResources().getDisplayMetrics().density);
    this.SQJ = (10.0F * getResources().getDisplayMetrics().density);
    this.SQK = (6.0F * getResources().getDisplayMetrics().density);
    this.mPaint = new Paint(1);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(-9934744);
    AppMethodBeat.o(264005);
  }
  
  public final void f(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(264027);
    float f2 = (paramFloat - this.SQI) / (paramInt - this.SQI);
    float f1 = f2;
    if (this.SQL) {
      f1 = 1.0F - f2;
    }
    this.SQG = Math.max(0.0F, Math.min(f1, 1.0F));
    f2 = paramFloat / this.SQI;
    f1 = f2;
    if (this.SQL) {
      f1 = 1.0F - f2;
    }
    this.SQF = Math.max(0.0F, Math.min(f1, 1.0F));
    Log.d("MicroMsg.GyroView", "alvinluo GyroView setVerticalScroll y: %f, limit: %d, percent: %f, paddingPercent: %f", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(paramInt), Float.valueOf(this.SQF), Float.valueOf(this.SQG) });
    postInvalidate();
    AppMethodBeat.o(264027);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(264012);
    super.onDraw(paramCanvas);
    float f1 = getMeasuredWidth() / 2.0F;
    float f2 = getMeasuredHeight() / 2.0F;
    if (this.SQG > 0.0F)
    {
      paramCanvas.drawCircle(f1, f2, this.SQJ / 2.0F - this.SQG * (this.SQJ - this.SQK) / 2.0F, this.mPaint);
      paramCanvas.drawCircle(f1 - this.SQG * this.Rl, f2, this.SQK / 2.0F, this.mPaint);
      paramCanvas.drawCircle(f1 + this.SQG * this.Rl, f2, this.SQK / 2.0F, this.mPaint);
      AppMethodBeat.o(264012);
      return;
    }
    paramCanvas.drawCircle(f1, f2, this.SQF * this.SQJ / 2.0F, this.mPaint);
    AppMethodBeat.o(264012);
  }
  
  public void setVerticalScroll(float paramFloat)
  {
    AppMethodBeat.i(264021);
    float f2 = (paramFloat - this.SQI) / (this.SQH - this.SQI);
    float f1 = f2;
    if (this.SQL) {
      f1 = 1.0F - f2;
    }
    this.SQG = Math.max(0.0F, Math.min(f1, 1.0F));
    f1 = paramFloat / this.SQI;
    paramFloat = f1;
    if (this.SQL) {
      paramFloat = 1.0F - f1;
    }
    this.SQF = Math.max(0.0F, Math.min(paramFloat, 1.0F));
    postInvalidate();
    AppMethodBeat.o(264021);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.api.GyroView
 * JD-Core Version:    0.7.0.1
 */