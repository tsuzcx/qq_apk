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
import com.tencent.mm.sdk.platformtools.ac;

public final class b
{
  float progress;
  ValueAnimator rT;
  a uUE;
  a uUF;
  boolean uUG;
  public a uUH;
  PointF uUI;
  PointF uUJ;
  PointF uUK;
  PointF uUL;
  PointF uUM;
  PointF uUN;
  float uUO;
  float uUP;
  float uUQ;
  float uUR;
  Path uUS;
  private Paint uUT;
  
  public b(a parama1, a parama2, a parama)
  {
    AppMethodBeat.i(94797);
    this.progress = 0.0F;
    this.uUG = false;
    this.uUO = 0.0F;
    this.uUP = 0.0F;
    this.uUQ = 0.0F;
    this.uUR = 0.0F;
    this.uUT = null;
    this.uUE = parama1;
    this.uUF = parama2;
    this.uUH = parama;
    this.uUP = (MMSightProgressBar.pJX * 2.0F);
    this.uUQ = (-MMSightProgressBar.pJX * 0.5F);
    this.uUS = new Path();
    this.uUT = new Paint();
    this.uUT.setAntiAlias(true);
    this.uUT.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(94797);
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public abstract void deP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.progressbar.b
 * JD-Core Version:    0.7.0.1
 */