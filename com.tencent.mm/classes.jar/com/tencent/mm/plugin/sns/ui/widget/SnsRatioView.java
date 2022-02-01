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
  public int ADE;
  public int ADF;
  public int ADG;
  public int ADH;
  public int ADI;
  public int ADJ;
  private Path ADK;
  private Path ADL;
  public Paint ADM;
  public Paint ADN;
  public float[] ADO;
  
  public SnsRatioView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100559);
    this.ADH = 70;
    this.ADI = 10;
    this.ADJ = 0;
    this.ADK = new Path();
    this.ADL = new Path();
    this.ADM = new Paint();
    this.ADN = new Paint();
    this.ADO = new float[8];
    AppMethodBeat.o(100559);
  }
  
  public final void ib(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100560);
    this.ADM.setColor(paramInt1);
    this.ADN.setColor(paramInt2);
    invalidate();
    AppMethodBeat.o(100560);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(100561);
    int i = getWidth();
    int j = getHeight();
    int k = (int)(j / Math.tan(Math.toRadians(this.ADH)));
    int m = Math.max((int)((i - k - this.ADI - this.ADG * 2) * this.ADE * 1.0F / 100.0F), this.ADJ);
    this.ADK.reset();
    this.ADK.moveTo(0.0F, 0.0F);
    this.ADK.lineTo(m + k, 0.0F);
    this.ADK.lineTo(m, j);
    this.ADK.lineTo(0.0F, j);
    this.ADK.close();
    this.ADL.reset();
    this.ADL.moveTo(k + m + this.ADI, 0.0F);
    this.ADL.lineTo(i, 0.0F);
    this.ADL.lineTo(i, j);
    this.ADL.lineTo(this.ADI + m, j);
    this.ADL.close();
    Path localPath = new Path();
    localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.ADO, Path.Direction.CW);
    paramCanvas.clipPath(localPath);
    paramCanvas.drawPath(this.ADK, this.ADM);
    paramCanvas.drawPath(this.ADL, this.ADN);
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