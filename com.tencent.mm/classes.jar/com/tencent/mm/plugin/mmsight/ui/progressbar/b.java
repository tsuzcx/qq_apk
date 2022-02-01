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
  a LeL;
  a LeM;
  boolean LeN;
  public a LeO;
  PointF LeP;
  PointF LeQ;
  PointF LeR;
  PointF LeS;
  PointF LeT;
  PointF LeU;
  float LeV;
  float LeW;
  float LeX;
  float LeY;
  Path LeZ;
  private Paint Lfa;
  ValueAnimator animator;
  float progress;
  
  public b(a parama1, a parama2, a parama)
  {
    AppMethodBeat.i(94797);
    this.progress = 0.0F;
    this.LeN = false;
    this.LeV = 0.0F;
    this.LeW = 0.0F;
    this.LeX = 0.0F;
    this.LeY = 0.0F;
    this.Lfa = null;
    this.LeL = parama1;
    this.LeM = parama2;
    this.LeO = parama;
    this.LeW = (MMSightProgressBar.yDp * 2.0F);
    this.LeX = (-MMSightProgressBar.yDp * 0.5F);
    this.LeZ = new Path();
    this.Lfa = new Paint();
    this.Lfa.setAntiAlias(true);
    this.Lfa.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(94797);
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public abstract void gdA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.progressbar.b
 * JD-Core Version:    0.7.0.1
 */