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
  ValueAnimator animator;
  float progress;
  float zEA;
  float zEB;
  float zEC;
  Path zED;
  private Paint zEE;
  a zEp;
  a zEq;
  boolean zEr;
  public a zEs;
  PointF zEt;
  PointF zEu;
  PointF zEv;
  PointF zEw;
  PointF zEx;
  PointF zEy;
  float zEz;
  
  public b(a parama1, a parama2, a parama)
  {
    AppMethodBeat.i(94797);
    this.progress = 0.0F;
    this.zEr = false;
    this.zEz = 0.0F;
    this.zEA = 0.0F;
    this.zEB = 0.0F;
    this.zEC = 0.0F;
    this.zEE = null;
    this.zEp = parama1;
    this.zEq = parama2;
    this.zEs = parama;
    this.zEA = (MMSightProgressBar.rLp * 2.0F);
    this.zEB = (-MMSightProgressBar.rLp * 0.5F);
    this.zED = new Path();
    this.zEE = new Paint();
    this.zEE.setAntiAlias(true);
    this.zEE.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(94797);
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public abstract void elf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.progressbar.b
 * JD-Core Version:    0.7.0.1
 */