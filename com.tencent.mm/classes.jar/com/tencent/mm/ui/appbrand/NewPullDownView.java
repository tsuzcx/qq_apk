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
import com.tencent.mm.sdk.platformtools.ae;

public class NewPullDownView
  extends View
{
  private float JCq;
  private float JCr;
  private Paint JCs;
  private Paint JCt;
  private float nhH;
  private boolean nhN;
  
  public NewPullDownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33826);
    this.nhH = 0.0F;
    this.nhN = false;
    this.JCq = (20.0F * getResources().getDisplayMetrics().density);
    this.JCr = (14.0F * getResources().getDisplayMetrics().density - getResources().getDisplayMetrics().density * 4.0F);
    this.JCs = new Paint(1);
    this.JCs.setStyle(Paint.Style.FILL);
    this.JCs.setColor(-4408132);
    this.JCt = new Paint(1);
    this.JCt.setStyle(Paint.Style.STROKE);
    this.JCt.setColor(0);
    this.JCt.setStrokeWidth(getResources().getDisplayMetrics().density * 4.0F);
    this.JCt.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    AppMethodBeat.o(33826);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(33827);
    super.onDraw(paramCanvas);
    float f1 = getMeasuredWidth() / 2;
    float f2 = getMeasuredHeight() / 2;
    paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null, 31);
    paramCanvas.drawCircle(f1, f2, this.nhH * this.JCq / 2.0F, this.JCs);
    if (this.nhH >= 0.4F) {
      paramCanvas.drawCircle(f1, f2, (this.nhH - 0.4F) / 0.6F * this.JCr / 2.0F, this.JCt);
    }
    paramCanvas.restore();
    AppMethodBeat.o(33827);
  }
  
  public void setVerticalScrollPercent(float paramFloat)
  {
    AppMethodBeat.i(33828);
    ae.i("MicroMsg.PullDownView", "[setVerticalScrollPercent] percent:%s", new Object[] { Float.valueOf(paramFloat) });
    float f = paramFloat;
    if (this.nhN) {
      f = 1.0F - paramFloat;
    }
    this.nhH = Math.max(0.0F, Math.min(f, 1.0F));
    postInvalidate();
    AppMethodBeat.o(33828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.NewPullDownView
 * JD-Core Version:    0.7.0.1
 */