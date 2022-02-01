package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  ValueAnimator animator;
  float progress;
  a vXM;
  a vXN;
  boolean vXO;
  public a vXP;
  PointF vXQ;
  PointF vXR;
  PointF vXS;
  PointF vXT;
  PointF vXU;
  PointF vXV;
  float vXW;
  float vXX;
  float vXY;
  float vXZ;
  Path vYa;
  private Paint vYb;
  
  public b(a parama1, a parama2, a parama)
  {
    AppMethodBeat.i(94797);
    this.progress = 0.0F;
    this.vXO = false;
    this.vXW = 0.0F;
    this.vXX = 0.0F;
    this.vXY = 0.0F;
    this.vXZ = 0.0F;
    this.vYb = null;
    this.vXM = parama1;
    this.vXN = parama2;
    this.vXP = parama;
    this.vXX = (MMSightProgressBar.qnC * 2.0F);
    this.vXY = (-MMSightProgressBar.qnC * 0.5F);
    this.vYa = new Path();
    this.vYb = new Paint();
    this.vYb.setAntiAlias(true);
    this.vYb.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(94797);
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public abstract void don();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.progressbar.b
 * JD-Core Version:    0.7.0.1
 */