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
  public int FfJ;
  public int FfK;
  public int FfL;
  public int FfM;
  public int FfN;
  public int FfO;
  private Path FfP;
  private Path FfQ;
  public Paint FfR;
  public Paint FfS;
  public float[] FfT;
  
  public SnsRatioView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100559);
    this.FfM = 70;
    this.FfN = 10;
    this.FfO = 0;
    this.FfP = new Path();
    this.FfQ = new Path();
    this.FfR = new Paint();
    this.FfS = new Paint();
    this.FfT = new float[8];
    AppMethodBeat.o(100559);
  }
  
  public final void iZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100560);
    this.FfR.setColor(paramInt1);
    this.FfS.setColor(paramInt2);
    invalidate();
    AppMethodBeat.o(100560);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(100561);
    int i = getWidth();
    int j = getHeight();
    int k = (int)(j / Math.tan(Math.toRadians(this.FfM)));
    int m = Math.max((int)((i - k - this.FfN - this.FfL * 2) * this.FfJ * 1.0F / 100.0F), this.FfO);
    this.FfP.reset();
    this.FfP.moveTo(0.0F, 0.0F);
    this.FfP.lineTo(m + k, 0.0F);
    this.FfP.lineTo(m, j);
    this.FfP.lineTo(0.0F, j);
    this.FfP.close();
    this.FfQ.reset();
    this.FfQ.moveTo(k + m + this.FfN, 0.0F);
    this.FfQ.lineTo(i, 0.0F);
    this.FfQ.lineTo(i, j);
    this.FfQ.lineTo(this.FfN + m, j);
    this.FfQ.close();
    Path localPath = new Path();
    localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.FfT, Path.Direction.CW);
    paramCanvas.clipPath(localPath);
    paramCanvas.drawPath(this.FfP, this.FfR);
    paramCanvas.drawPath(this.FfQ, this.FfS);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsRatioView
 * JD-Core Version:    0.7.0.1
 */