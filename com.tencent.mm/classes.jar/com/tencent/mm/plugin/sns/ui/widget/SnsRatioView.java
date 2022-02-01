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
  private Path zlA;
  public Paint zlB;
  public Paint zlC;
  public float[] zlD;
  public int zlt;
  public int zlu;
  public int zlv;
  public int zlw;
  public int zlx;
  public int zly;
  private Path zlz;
  
  public SnsRatioView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100559);
    this.zlw = 70;
    this.zlx = 10;
    this.zly = 0;
    this.zlz = new Path();
    this.zlA = new Path();
    this.zlB = new Paint();
    this.zlC = new Paint();
    this.zlD = new float[8];
    AppMethodBeat.o(100559);
  }
  
  public final void hK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100560);
    this.zlB.setColor(paramInt1);
    this.zlC.setColor(paramInt2);
    invalidate();
    AppMethodBeat.o(100560);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(100561);
    int i = getWidth();
    int j = getHeight();
    int k = (int)(j / Math.tan(Math.toRadians(this.zlw)));
    int m = Math.max((int)((i - k - this.zlx - this.zlv * 2) * this.zlt * 1.0F / 100.0F), this.zly);
    this.zlz.reset();
    this.zlz.moveTo(0.0F, 0.0F);
    this.zlz.lineTo(m + k, 0.0F);
    this.zlz.lineTo(m, j);
    this.zlz.lineTo(0.0F, j);
    this.zlz.close();
    this.zlA.reset();
    this.zlA.moveTo(k + m + this.zlx, 0.0F);
    this.zlA.lineTo(i, 0.0F);
    this.zlA.lineTo(i, j);
    this.zlA.lineTo(this.zlx + m, j);
    this.zlA.close();
    Path localPath = new Path();
    localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.zlD, Path.Direction.CW);
    paramCanvas.clipPath(localPath);
    paramCanvas.drawPath(this.zlz, this.zlB);
    paramCanvas.drawPath(this.zlA, this.zlC);
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