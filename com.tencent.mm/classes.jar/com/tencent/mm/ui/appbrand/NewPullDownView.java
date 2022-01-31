package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mm.sdk.platformtools.y;

public class NewPullDownView
  extends View
{
  private float hsH = 0.0F;
  private boolean hsN = false;
  private float uRU = 20.0F * getResources().getDisplayMetrics().density;
  private float uRV = 14.0F * getResources().getDisplayMetrics().density - getResources().getDisplayMetrics().density * 4.0F;
  private Paint uRW = new Paint(1);
  private Paint uRX;
  
  public NewPullDownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.uRW.setStyle(Paint.Style.FILL);
    this.uRW.setColor(-4408132);
    this.uRX = new Paint(1);
    this.uRX.setStyle(Paint.Style.STROKE);
    this.uRX.setColor(0);
    this.uRX.setStrokeWidth(getResources().getDisplayMetrics().density * 4.0F);
    this.uRX.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = getMeasuredWidth() / 2;
    float f2 = getMeasuredHeight() / 2;
    paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null, 31);
    paramCanvas.drawCircle(f1, f2, this.hsH * this.uRU / 2.0F, this.uRW);
    if (this.hsH >= 0.4F) {
      paramCanvas.drawCircle(f1, f2, (this.hsH - 0.4F) / 0.6F * this.uRV / 2.0F, this.uRX);
    }
    paramCanvas.restore();
  }
  
  public void setVerticalScrollPercent(float paramFloat)
  {
    y.i("MicroMsg.PullDownView", "[setVerticalScrollPercent] percent:%s", new Object[] { Float.valueOf(paramFloat) });
    float f = paramFloat;
    if (this.hsN) {
      f = 1.0F - paramFloat;
    }
    this.hsH = Math.max(0.0F, Math.min(f, 1.0F));
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.NewPullDownView
 * JD-Core Version:    0.7.0.1
 */