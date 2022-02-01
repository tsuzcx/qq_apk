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
  public int xYA;
  public int xYB;
  private Path xYC;
  private Path xYD;
  public Paint xYE;
  public Paint xYF;
  public float[] xYG;
  public int xYw;
  public int xYx;
  public int xYy;
  public int xYz;
  
  public SnsRatioView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100559);
    this.xYz = 70;
    this.xYA = 10;
    this.xYB = 0;
    this.xYC = new Path();
    this.xYD = new Path();
    this.xYE = new Paint();
    this.xYF = new Paint();
    this.xYG = new float[8];
    AppMethodBeat.o(100559);
  }
  
  public final void hB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100560);
    this.xYE.setColor(paramInt1);
    this.xYF.setColor(paramInt2);
    invalidate();
    AppMethodBeat.o(100560);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(100561);
    int i = getWidth();
    int j = getHeight();
    int k = (int)(j / Math.tan(Math.toRadians(this.xYz)));
    int m = Math.max((int)((i - k - this.xYA - this.xYy * 2) * this.xYw * 1.0F / 100.0F), this.xYB);
    this.xYC.reset();
    this.xYC.moveTo(0.0F, 0.0F);
    this.xYC.lineTo(m + k, 0.0F);
    this.xYC.lineTo(m, j);
    this.xYC.lineTo(0.0F, j);
    this.xYC.close();
    this.xYD.reset();
    this.xYD.moveTo(k + m + this.xYA, 0.0F);
    this.xYD.lineTo(i, 0.0F);
    this.xYD.lineTo(i, j);
    this.xYD.lineTo(this.xYA + m, j);
    this.xYD.close();
    Path localPath = new Path();
    localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.xYG, Path.Direction.CW);
    paramCanvas.clipPath(localPath);
    paramCanvas.drawPath(this.xYC, this.xYE);
    paramCanvas.drawPath(this.xYD, this.xYF);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsRatioView
 * JD-Core Version:    0.7.0.1
 */