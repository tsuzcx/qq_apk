package com.tencent.mm.view.b;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.b;

final class a$a
  extends b
{
  private float ASK;
  private float ASL;
  boolean ASM;
  a.b ASN;
  float bVL;
  float bVM;
  float gV;
  private ValueAnimator kO;
  float mScale;
  
  public a$a(a parama, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
  {
    this.mScale = paramFloat1;
    this.ASK = paramFloat2;
    this.ASL = paramFloat3;
    this.bVL = paramFloat4;
    this.bVM = paramFloat5;
    this.gV = paramFloat6;
    this.ASM = paramBoolean;
  }
  
  public final void play()
  {
    AppMethodBeat.i(116400);
    this.kO = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { 0.0F, 166.0F }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, this.ASK }), PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, this.ASL }), PropertyValuesHolder.ofFloat("rotation", new float[] { 0.0F, this.gV }) });
    this.kO.addUpdateListener(new a.a.1(this));
    this.kO.addListener(new a.a.2(this));
    this.kO.setInterpolator(new LinearInterpolator());
    this.kO.setDuration(166L);
    this.kO.start();
    AppMethodBeat.o(116400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.b.a.a
 * JD-Core Version:    0.7.0.1
 */