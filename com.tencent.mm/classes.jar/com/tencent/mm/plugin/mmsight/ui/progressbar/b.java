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
import com.tencent.mm.sdk.platformtools.ae;

public final class b
{
  ValueAnimator animator;
  float progress;
  a wjQ;
  a wjR;
  boolean wjS;
  public a wjT;
  PointF wjU;
  PointF wjV;
  PointF wjW;
  PointF wjX;
  PointF wjY;
  PointF wjZ;
  float wka;
  float wkb;
  float wkc;
  float wkd;
  Path wke;
  private Paint wkf;
  
  public b(a parama1, a parama2, a parama)
  {
    AppMethodBeat.i(94797);
    this.progress = 0.0F;
    this.wjS = false;
    this.wka = 0.0F;
    this.wkb = 0.0F;
    this.wkc = 0.0F;
    this.wkd = 0.0F;
    this.wkf = null;
    this.wjQ = parama1;
    this.wjR = parama2;
    this.wjT = parama;
    this.wkb = (MMSightProgressBar.qui * 2.0F);
    this.wkc = (-MMSightProgressBar.qui * 0.5F);
    this.wke = new Path();
    this.wkf = new Paint();
    this.wkf.setAntiAlias(true);
    this.wkf.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(94797);
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public abstract void drl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.progressbar.b
 * JD-Core Version:    0.7.0.1
 */