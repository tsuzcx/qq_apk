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
import com.tencent.mm.sdk.platformtools.ab;

public class NewPullDownView
  extends View
{
  private float jkl;
  private boolean jkr;
  private float zgv;
  private float zgw;
  private Paint zgx;
  private Paint zgy;
  
  public NewPullDownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29969);
    this.jkl = 0.0F;
    this.jkr = false;
    this.zgv = (20.0F * getResources().getDisplayMetrics().density);
    this.zgw = (14.0F * getResources().getDisplayMetrics().density - getResources().getDisplayMetrics().density * 4.0F);
    this.zgx = new Paint(1);
    this.zgx.setStyle(Paint.Style.FILL);
    this.zgx.setColor(-4408132);
    this.zgy = new Paint(1);
    this.zgy.setStyle(Paint.Style.STROKE);
    this.zgy.setColor(0);
    this.zgy.setStrokeWidth(getResources().getDisplayMetrics().density * 4.0F);
    this.zgy.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    AppMethodBeat.o(29969);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(29970);
    super.onDraw(paramCanvas);
    float f1 = getMeasuredWidth() / 2;
    float f2 = getMeasuredHeight() / 2;
    paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null, 31);
    paramCanvas.drawCircle(f1, f2, this.jkl * this.zgv / 2.0F, this.zgx);
    if (this.jkl >= 0.4F) {
      paramCanvas.drawCircle(f1, f2, (this.jkl - 0.4F) / 0.6F * this.zgw / 2.0F, this.zgy);
    }
    paramCanvas.restore();
    AppMethodBeat.o(29970);
  }
  
  public void setVerticalScrollPercent(float paramFloat)
  {
    AppMethodBeat.i(29971);
    ab.i("MicroMsg.PullDownView", "[setVerticalScrollPercent] percent:%s", new Object[] { Float.valueOf(paramFloat) });
    float f = paramFloat;
    if (this.jkr) {
      f = 1.0F - paramFloat;
    }
    this.jkl = Math.max(0.0F, Math.min(f, 1.0F));
    postInvalidate();
    AppMethodBeat.o(29971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.NewPullDownView
 * JD-Core Version:    0.7.0.1
 */