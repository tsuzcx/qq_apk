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
  float progress;
  ValueAnimator qT;
  a tMa;
  a tMb;
  boolean tMc;
  public a tMd;
  PointF tMe;
  PointF tMf;
  PointF tMg;
  PointF tMh;
  PointF tMi;
  PointF tMj;
  float tMk;
  float tMl;
  float tMm;
  float tMn;
  Path tMo;
  private Paint tMp;
  
  public b(a parama1, a parama2, a parama)
  {
    AppMethodBeat.i(94797);
    this.progress = 0.0F;
    this.tMc = false;
    this.tMk = 0.0F;
    this.tMl = 0.0F;
    this.tMm = 0.0F;
    this.tMn = 0.0F;
    this.tMp = null;
    this.tMa = parama1;
    this.tMb = parama2;
    this.tMd = parama;
    this.tMl = (MMSightProgressBar.pgN * 2.0F);
    this.tMm = (-MMSightProgressBar.pgN * 0.5F);
    this.tMo = new Path();
    this.tMp = new Paint();
    this.tMp.setAntiAlias(true);
    this.tMp.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(94797);
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public abstract void cRf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.progressbar.b
 * JD-Core Version:    0.7.0.1
 */