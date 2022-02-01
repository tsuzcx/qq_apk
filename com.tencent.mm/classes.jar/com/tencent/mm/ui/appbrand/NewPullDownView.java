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
  private float FSi;
  private boolean FSo;
  private float ONi;
  private float ONj;
  private Paint ONk;
  private Paint ONl;
  
  public NewPullDownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33826);
    this.FSi = 0.0F;
    this.FSo = false;
    this.ONi = (20.0F * getResources().getDisplayMetrics().density);
    this.ONj = (14.0F * getResources().getDisplayMetrics().density - getResources().getDisplayMetrics().density * 4.0F);
    this.ONk = new Paint(1);
    this.ONk.setStyle(Paint.Style.FILL);
    this.ONk.setColor(-4408132);
    this.ONl = new Paint(1);
    this.ONl.setStyle(Paint.Style.STROKE);
    this.ONl.setColor(0);
    this.ONl.setStrokeWidth(getResources().getDisplayMetrics().density * 4.0F);
    this.ONl.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    AppMethodBeat.o(33826);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(33827);
    super.onDraw(paramCanvas);
    float f1 = getMeasuredWidth() / 2;
    float f2 = getMeasuredHeight() / 2;
    paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null, 31);
    paramCanvas.drawCircle(f1, f2, this.FSi * this.ONi / 2.0F, this.ONk);
    if (this.FSi >= 0.4F) {
      paramCanvas.drawCircle(f1, f2, (this.FSi - 0.4F) / 0.6F * this.ONj / 2.0F, this.ONl);
    }
    paramCanvas.restore();
    AppMethodBeat.o(33827);
  }
  
  public void setVerticalScrollPercent(float paramFloat)
  {
    AppMethodBeat.i(33828);
    Log.i("MicroMsg.PullDownView", "[setVerticalScrollPercent] percent:%s", new Object[] { Float.valueOf(paramFloat) });
    float f = paramFloat;
    if (this.FSo) {
      f = 1.0F - paramFloat;
    }
    this.FSi = Math.max(0.0F, Math.min(f, 1.0F));
    postInvalidate();
    AppMethodBeat.o(33828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.NewPullDownView
 * JD-Core Version:    0.7.0.1
 */