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
  public int AVe;
  public int AVf;
  public int AVg;
  public int AVh;
  public int AVi;
  public int AVj;
  private Path AVk;
  private Path AVl;
  public Paint AVm;
  public Paint AVn;
  public float[] AVo;
  
  public SnsRatioView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100559);
    this.AVh = 70;
    this.AVi = 10;
    this.AVj = 0;
    this.AVk = new Path();
    this.AVl = new Path();
    this.AVm = new Paint();
    this.AVn = new Paint();
    this.AVo = new float[8];
    AppMethodBeat.o(100559);
  }
  
  public final void ie(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100560);
    this.AVm.setColor(paramInt1);
    this.AVn.setColor(paramInt2);
    invalidate();
    AppMethodBeat.o(100560);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(100561);
    int i = getWidth();
    int j = getHeight();
    int k = (int)(j / Math.tan(Math.toRadians(this.AVh)));
    int m = Math.max((int)((i - k - this.AVi - this.AVg * 2) * this.AVe * 1.0F / 100.0F), this.AVj);
    this.AVk.reset();
    this.AVk.moveTo(0.0F, 0.0F);
    this.AVk.lineTo(m + k, 0.0F);
    this.AVk.lineTo(m, j);
    this.AVk.lineTo(0.0F, j);
    this.AVk.close();
    this.AVl.reset();
    this.AVl.moveTo(k + m + this.AVi, 0.0F);
    this.AVl.lineTo(i, 0.0F);
    this.AVl.lineTo(i, j);
    this.AVl.lineTo(this.AVi + m, j);
    this.AVl.close();
    Path localPath = new Path();
    localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.AVo, Path.Direction.CW);
    paramCanvas.clipPath(localPath);
    paramCanvas.drawPath(this.AVk, this.AVm);
    paramCanvas.drawPath(this.AVl, this.AVn);
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