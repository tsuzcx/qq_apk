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
  private float FUa;
  private float FUb;
  private Paint FUc;
  private Paint FUd;
  private float lZX;
  private boolean mae;
  
  public NewPullDownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33826);
    this.lZX = 0.0F;
    this.mae = false;
    this.FUa = (20.0F * getResources().getDisplayMetrics().density);
    this.FUb = (14.0F * getResources().getDisplayMetrics().density - getResources().getDisplayMetrics().density * 4.0F);
    this.FUc = new Paint(1);
    this.FUc.setStyle(Paint.Style.FILL);
    this.FUc.setColor(-4408132);
    this.FUd = new Paint(1);
    this.FUd.setStyle(Paint.Style.STROKE);
    this.FUd.setColor(0);
    this.FUd.setStrokeWidth(getResources().getDisplayMetrics().density * 4.0F);
    this.FUd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    AppMethodBeat.o(33826);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(33827);
    super.onDraw(paramCanvas);
    float f1 = getMeasuredWidth() / 2;
    float f2 = getMeasuredHeight() / 2;
    paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null, 31);
    paramCanvas.drawCircle(f1, f2, this.lZX * this.FUa / 2.0F, this.FUc);
    if (this.lZX >= 0.4F) {
      paramCanvas.drawCircle(f1, f2, (this.lZX - 0.4F) / 0.6F * this.FUb / 2.0F, this.FUd);
    }
    paramCanvas.restore();
    AppMethodBeat.o(33827);
  }
  
  public void setVerticalScrollPercent(float paramFloat)
  {
    AppMethodBeat.i(33828);
    ad.i("MicroMsg.PullDownView", "[setVerticalScrollPercent] percent:%s", new Object[] { Float.valueOf(paramFloat) });
    float f = paramFloat;
    if (this.mae) {
      f = 1.0F - paramFloat;
    }
    this.lZX = Math.max(0.0F, Math.min(f, 1.0F));
    postInvalidate();
    AppMethodBeat.o(33828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.NewPullDownView
 * JD-Core Version:    0.7.0.1
 */