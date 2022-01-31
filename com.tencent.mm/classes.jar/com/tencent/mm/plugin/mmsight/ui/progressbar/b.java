package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  ValueAnimator ggX;
  a oRf;
  a oRg;
  boolean oRh;
  public b.a oRi;
  PointF oRj;
  PointF oRk;
  PointF oRl;
  PointF oRm;
  PointF oRn;
  PointF oRo;
  float oRp;
  float oRq;
  float oRr;
  float oRs;
  Path oRt;
  private Paint oRu;
  float progress;
  
  public b(a parama1, a parama2, b.a parama)
  {
    AppMethodBeat.i(55343);
    this.progress = 0.0F;
    this.oRh = false;
    this.oRp = 0.0F;
    this.oRq = 0.0F;
    this.oRr = 0.0F;
    this.oRs = 0.0F;
    this.oRu = null;
    this.oRf = parama1;
    this.oRg = parama2;
    this.oRi = parama;
    this.oRq = (MMSightProgressBar.lQb * 2.0F);
    this.oRr = (-MMSightProgressBar.lQb * 0.5F);
    this.oRt = new Path();
    this.oRu = new Paint();
    this.oRu.setAntiAlias(true);
    this.oRu.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(55343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.progressbar.b
 * JD-Core Version:    0.7.0.1
 */