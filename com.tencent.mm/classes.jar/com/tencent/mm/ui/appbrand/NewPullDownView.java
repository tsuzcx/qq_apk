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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class NewPullDownView
  extends View
{
  private float JhF;
  private float JhG;
  private Paint JhH;
  private Paint JhI;
  private boolean ncE;
  private float ncy;
  
  public NewPullDownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33826);
    this.ncy = 0.0F;
    this.ncE = false;
    this.JhF = (20.0F * getResources().getDisplayMetrics().density);
    this.JhG = (14.0F * getResources().getDisplayMetrics().density - getResources().getDisplayMetrics().density * 4.0F);
    this.JhH = new Paint(1);
    this.JhH.setStyle(Paint.Style.FILL);
    this.JhH.setColor(-4408132);
    this.JhI = new Paint(1);
    this.JhI.setStyle(Paint.Style.STROKE);
    this.JhI.setColor(0);
    this.JhI.setStrokeWidth(getResources().getDisplayMetrics().density * 4.0F);
    this.JhI.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    AppMethodBeat.o(33826);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(33827);
    super.onDraw(paramCanvas);
    float f1 = getMeasuredWidth() / 2;
    float f2 = getMeasuredHeight() / 2;
    paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null, 31);
    paramCanvas.drawCircle(f1, f2, this.ncy * this.JhF / 2.0F, this.JhH);
    if (this.ncy >= 0.4F) {
      paramCanvas.drawCircle(f1, f2, (this.ncy - 0.4F) / 0.6F * this.JhG / 2.0F, this.JhI);
    }
    paramCanvas.restore();
    AppMethodBeat.o(33827);
  }
  
  public void setVerticalScrollPercent(float paramFloat)
  {
    AppMethodBeat.i(33828);
    ad.i("MicroMsg.PullDownView", "[setVerticalScrollPercent] percent:%s", new Object[] { Float.valueOf(paramFloat) });
    float f = paramFloat;
    if (this.ncE) {
      f = 1.0F - paramFloat;
    }
    this.ncy = Math.max(0.0F, Math.min(f, 1.0F));
    postInvalidate();
    AppMethodBeat.o(33828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.NewPullDownView
 * JD-Core Version:    0.7.0.1
 */