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
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  float FjA;
  float FjB;
  Path FjC;
  private Paint FjD;
  a Fjo;
  a Fjp;
  boolean Fjq;
  public a Fjr;
  PointF Fjs;
  PointF Fjt;
  PointF Fju;
  PointF Fjv;
  PointF Fjw;
  PointF Fjx;
  float Fjy;
  float Fjz;
  ValueAnimator animator;
  float progress;
  
  public b(a parama1, a parama2, a parama)
  {
    AppMethodBeat.i(94797);
    this.progress = 0.0F;
    this.Fjq = false;
    this.Fjy = 0.0F;
    this.Fjz = 0.0F;
    this.FjA = 0.0F;
    this.FjB = 0.0F;
    this.FjD = null;
    this.Fjo = parama1;
    this.Fjp = parama2;
    this.Fjr = parama;
    this.Fjz = (MMSightProgressBar.vqY * 2.0F);
    this.FjA = (-MMSightProgressBar.vqY * 0.5F);
    this.FjC = new Path();
    this.FjD = new Paint();
    this.FjD.setAntiAlias(true);
    this.FjD.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(94797);
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public abstract void eUO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.progressbar.b
 * JD-Core Version:    0.7.0.1
 */