package com.tencent.mm.plugin.shake.ui;

import android.graphics.Matrix;
import android.view.View;
import android.view.animation.Transformation;
import junit.framework.Assert;

final class ShakeEggAnimFrame$b
  extends ShakeEggAnimFrame.a
{
  private int fSw;
  private int fSx;
  private float obA;
  private float obr;
  private float obs;
  private float obt;
  private float obu;
  private float obv = 0.01F;
  private float obw = 0.02F;
  private float obx;
  private float oby;
  private float obz;
  
  public ShakeEggAnimFrame$b(ShakeEggAnimFrame paramShakeEggAnimFrame, int paramInt1, int paramInt2)
  {
    super(paramShakeEggAnimFrame);
    this.fSw = paramInt1;
    this.fSx = paramInt2;
    this.obr = ShakeEggAnimFrame.L(0.1F, 0.9F);
    this.obs = this.obr;
    this.obu = ShakeEggAnimFrame.L(-0.3F, -0.1F);
    restart();
  }
  
  private void restart()
  {
    if (this.obu > 0.0F) {
      this.obw += this.obv;
    }
    this.obt = this.obu;
    this.obu += this.obw;
    if (this.obt > 1.1F) {
      if (this.targetView == null) {
        break label139;
      }
    }
    label139:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.targetView.post(new ShakeEggAnimFrame.a.1(this));
      this.obx = (this.obr * this.fSw);
      this.oby = (this.obs * this.fSw);
      this.obz = (this.obt * this.fSx);
      this.obA = (this.obu * this.fSx);
      return;
    }
  }
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = this.obx;
    float f2 = this.obz;
    if (this.obx != this.oby) {
      f1 = this.obx + (this.oby - this.obx) * paramFloat;
    }
    if (this.obz != this.obA) {
      f2 = this.obz + (this.obA - this.obz) * paramFloat;
    }
    paramTransformation.getMatrix().setTranslate(f1, f2);
    if (paramFloat == 1.0F) {
      restart();
    }
  }
  
  public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    setRepeatCount(-1);
    setDuration(this.duration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeEggAnimFrame.b
 * JD-Core Version:    0.7.0.1
 */