package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;

public final class b
{
  ValueAnimator hsF;
  PointF mrA;
  float mrB = 0.0F;
  float mrC = 0.0F;
  float mrD = 0.0F;
  float mrE = 0.0F;
  Path mrF;
  private Paint mrG = null;
  a mrr;
  a mrs;
  boolean mrt = false;
  public b.a mru;
  PointF mrv;
  PointF mrw;
  PointF mrx;
  PointF mry;
  PointF mrz;
  float progress = 0.0F;
  
  public b(a parama1, a parama2, b.a parama)
  {
    this.mrr = parama1;
    this.mrs = parama2;
    this.mru = parama;
    this.mrC = (MMSightProgressBar.jGD * 2.0F);
    this.mrD = (-MMSightProgressBar.jGD * 0.5F);
    this.mrF = new Path();
    this.mrG = new Paint();
    this.mrG.setAntiAlias(true);
    this.mrG.setStyle(Paint.Style.FILL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.progressbar.b
 * JD-Core Version:    0.7.0.1
 */