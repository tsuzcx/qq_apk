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
import com.tencent.mm.sdk.platformtools.ac;

public class NewPullDownView
  extends View
{
  private float HtP;
  private float HtQ;
  private Paint HtR;
  private Paint HtS;
  private float mBY;
  private boolean mCe;
  
  public NewPullDownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33826);
    this.mBY = 0.0F;
    this.mCe = false;
    this.HtP = (20.0F * getResources().getDisplayMetrics().density);
    this.HtQ = (14.0F * getResources().getDisplayMetrics().density - getResources().getDisplayMetrics().density * 4.0F);
    this.HtR = new Paint(1);
    this.HtR.setStyle(Paint.Style.FILL);
    this.HtR.setColor(-4408132);
    this.HtS = new Paint(1);
    this.HtS.setStyle(Paint.Style.STROKE);
    this.HtS.setColor(0);
    this.HtS.setStrokeWidth(getResources().getDisplayMetrics().density * 4.0F);
    this.HtS.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    AppMethodBeat.o(33826);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(33827);
    super.onDraw(paramCanvas);
    float f1 = getMeasuredWidth() / 2;
    float f2 = getMeasuredHeight() / 2;
    paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null, 31);
    paramCanvas.drawCircle(f1, f2, this.mBY * this.HtP / 2.0F, this.HtR);
    if (this.mBY >= 0.4F) {
      paramCanvas.drawCircle(f1, f2, (this.mBY - 0.4F) / 0.6F * this.HtQ / 2.0F, this.HtS);
    }
    paramCanvas.restore();
    AppMethodBeat.o(33827);
  }
  
  public void setVerticalScrollPercent(float paramFloat)
  {
    AppMethodBeat.i(33828);
    ac.i("MicroMsg.PullDownView", "[setVerticalScrollPercent] percent:%s", new Object[] { Float.valueOf(paramFloat) });
    float f = paramFloat;
    if (this.mCe) {
      f = 1.0F - paramFloat;
    }
    this.mBY = Math.max(0.0F, Math.min(f, 1.0F));
    postInvalidate();
    AppMethodBeat.o(33828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.NewPullDownView
 * JD-Core Version:    0.7.0.1
 */