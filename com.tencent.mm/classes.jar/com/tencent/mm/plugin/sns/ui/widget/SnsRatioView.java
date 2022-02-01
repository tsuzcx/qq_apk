package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SnsRatioView
  extends View
{
  public int RXP;
  public int RXQ;
  public int RXR;
  public int RXS;
  public int RXT;
  private Path RXU;
  private Path RXV;
  public Paint RXW;
  public Paint RXX;
  public float[] RXY;
  public int mRadius;
  
  public SnsRatioView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100559);
    this.RXR = 70;
    this.RXS = 10;
    this.RXT = 0;
    this.RXU = new Path();
    this.RXV = new Path();
    this.RXW = new Paint();
    this.RXX = new Paint();
    this.RXY = new float[8];
    AppMethodBeat.o(100559);
  }
  
  public final void lV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100560);
    this.RXW.setColor(paramInt1);
    this.RXX.setColor(paramInt2);
    invalidate();
    AppMethodBeat.o(100560);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(100561);
    int i = getWidth();
    int j = getHeight();
    int k = (int)(j / Math.tan(Math.toRadians(this.RXR)));
    int m = Math.max((int)((i - k - this.RXS - this.mRadius * 2) * this.RXP * 1.0F / 100.0F), this.RXT);
    this.RXU.reset();
    this.RXU.moveTo(0.0F, 0.0F);
    this.RXU.lineTo(m + k, 0.0F);
    this.RXU.lineTo(m, j);
    this.RXU.lineTo(0.0F, j);
    this.RXU.close();
    this.RXV.reset();
    this.RXV.moveTo(k + m + this.RXS, 0.0F);
    this.RXV.lineTo(i, 0.0F);
    this.RXV.lineTo(i, j);
    this.RXV.lineTo(this.RXS + m, j);
    this.RXV.close();
    Path localPath = new Path();
    localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.RXY, Path.Direction.CW);
    paramCanvas.clipPath(localPath);
    paramCanvas.drawPath(this.RXU, this.RXW);
    paramCanvas.drawPath(this.RXV, this.RXX);
    AppMethodBeat.o(100561);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(100562);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      invalidate();
    }
    AppMethodBeat.o(100562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsRatioView
 * JD-Core Version:    0.7.0.1
 */