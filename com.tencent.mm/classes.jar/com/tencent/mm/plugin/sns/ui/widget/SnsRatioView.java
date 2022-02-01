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
  public int Luo;
  public int Lup;
  public int Luq;
  public int Lur;
  public int Lus;
  public int Lut;
  private Path Luu;
  private Path Luv;
  public Paint Luw;
  public Paint Lux;
  public float[] Luy;
  
  public SnsRatioView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100559);
    this.Lur = 70;
    this.Lus = 10;
    this.Lut = 0;
    this.Luu = new Path();
    this.Luv = new Path();
    this.Luw = new Paint();
    this.Lux = new Paint();
    this.Luy = new float[8];
    AppMethodBeat.o(100559);
  }
  
  public final void kj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100560);
    this.Luw.setColor(paramInt1);
    this.Lux.setColor(paramInt2);
    invalidate();
    AppMethodBeat.o(100560);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(100561);
    int i = getWidth();
    int j = getHeight();
    int k = (int)(j / Math.tan(Math.toRadians(this.Lur)));
    int m = Math.max((int)((i - k - this.Lus - this.Luq * 2) * this.Luo * 1.0F / 100.0F), this.Lut);
    this.Luu.reset();
    this.Luu.moveTo(0.0F, 0.0F);
    this.Luu.lineTo(m + k, 0.0F);
    this.Luu.lineTo(m, j);
    this.Luu.lineTo(0.0F, j);
    this.Luu.close();
    this.Luv.reset();
    this.Luv.moveTo(k + m + this.Lus, 0.0F);
    this.Luv.lineTo(i, 0.0F);
    this.Luv.lineTo(i, j);
    this.Luv.lineTo(this.Lus + m, j);
    this.Luv.close();
    Path localPath = new Path();
    localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.Luy, Path.Direction.CW);
    paramCanvas.clipPath(localPath);
    paramCanvas.drawPath(this.Luu, this.Luw);
    paramCanvas.drawPath(this.Luv, this.Lux);
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