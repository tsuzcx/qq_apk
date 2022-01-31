package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.plugin.u.a.c;
import com.tencent.mm.sdk.platformtools.y;

public class MMSightCircularProgressBar
  extends View
{
  private float Hs = 0.0F;
  boolean bSr = false;
  int duration = 0;
  private Paint gaZ;
  float mon = 0.0F;
  int moo = 0;
  int mop = 0;
  private RectF moq;
  b mor;
  MMSightCircularProgressBar.a mos;
  private int mot = Color.parseColor("#1AAD19");
  private float strokeWidth = 0.0F;
  
  public MMSightCircularProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MMSightCircularProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    float f = getResources().getDimensionPixelSize(a.c.mmsight_recorder_button_outer_size_max);
    this.strokeWidth = getResources().getDimensionPixelSize(a.c.mmsight_recorder_progress_circular_thickness);
    this.Hs = (this.strokeWidth / 2.0F);
    this.moq = new RectF(this.Hs, this.Hs, f - this.Hs, f - this.Hs);
    this.gaZ = new Paint();
    this.gaZ.setStyle(Paint.Style.STROKE);
    this.gaZ.setStrokeWidth(this.strokeWidth);
    this.gaZ.setColor(this.mot);
    this.gaZ.setAlpha(153);
    this.gaZ.setAntiAlias(true);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(this.Hs, this.Hs);
    paramCanvas.rotate(180.0F, this.moq.right / 2.0F, this.moq.bottom / 2.0F);
    paramCanvas.drawArc(this.moq, 90.0F, 360.0F * (this.mon / this.mop), false, this.gaZ);
    paramCanvas.restore();
  }
  
  public void setDuration(int paramInt)
  {
    y.i("MicroMsg.MMSightCircularProgressBar", "setDuration: %s", new Object[] { Integer.valueOf(paramInt) });
    this.duration = paramInt;
  }
  
  public void setInitProgress(int paramInt)
  {
    y.i("MicroMsg.MMSightCircularProgressBar", "setInitProgress: %s, isStart: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.bSr) });
    if (!this.bSr) {
      this.moo = paramInt;
    }
  }
  
  public void setMaxProgress(int paramInt)
  {
    y.i("MicroMsg.MMSightCircularProgressBar", "setMaxProgress: %s", new Object[] { Integer.valueOf(paramInt) });
    this.mop = paramInt;
  }
  
  public void setProgressCallback(MMSightCircularProgressBar.a parama)
  {
    this.mos = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar
 * JD-Core Version:    0.7.0.1
 */