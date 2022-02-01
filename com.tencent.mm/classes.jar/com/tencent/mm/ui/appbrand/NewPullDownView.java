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
import com.tencent.mm.sdk.platformtools.Log;

public class NewPullDownView
  extends View
{
  private float SQF;
  private boolean SQL;
  private float adNC;
  private float adND;
  private Paint adNE;
  private Paint adNF;
  
  public NewPullDownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33826);
    this.SQF = 0.0F;
    this.SQL = false;
    this.adNC = (20.0F * getResources().getDisplayMetrics().density);
    this.adND = (14.0F * getResources().getDisplayMetrics().density - getResources().getDisplayMetrics().density * 4.0F);
    this.adNE = new Paint(1);
    this.adNE.setStyle(Paint.Style.FILL);
    this.adNE.setColor(-4408132);
    this.adNF = new Paint(1);
    this.adNF.setStyle(Paint.Style.STROKE);
    this.adNF.setColor(0);
    this.adNF.setStrokeWidth(getResources().getDisplayMetrics().density * 4.0F);
    this.adNF.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    AppMethodBeat.o(33826);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(33827);
    super.onDraw(paramCanvas);
    float f1 = getMeasuredWidth() / 2;
    float f2 = getMeasuredHeight() / 2;
    paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null, 31);
    paramCanvas.drawCircle(f1, f2, this.SQF * this.adNC / 2.0F, this.adNE);
    if (this.SQF >= 0.4F) {
      paramCanvas.drawCircle(f1, f2, (this.SQF - 0.4F) / 0.6F * this.adND / 2.0F, this.adNF);
    }
    paramCanvas.restore();
    AppMethodBeat.o(33827);
  }
  
  public void setVerticalScrollPercent(float paramFloat)
  {
    AppMethodBeat.i(33828);
    Log.i("MicroMsg.PullDownView", "[setVerticalScrollPercent] percent:%s", new Object[] { Float.valueOf(paramFloat) });
    float f = paramFloat;
    if (this.SQL) {
      f = 1.0F - paramFloat;
    }
    this.SQF = Math.max(0.0F, Math.min(f, 1.0F));
    postInvalidate();
    AppMethodBeat.o(33828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.NewPullDownView
 * JD-Core Version:    0.7.0.1
 */