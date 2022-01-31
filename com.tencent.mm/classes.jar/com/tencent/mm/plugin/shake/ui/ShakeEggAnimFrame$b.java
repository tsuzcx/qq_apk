package com.tencent.mm.plugin.shake.ui;

import android.graphics.Matrix;
import android.view.animation.Transformation;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShakeEggAnimFrame$b
  extends ShakeEggAnimFrame.a
{
  private float ay;
  private int hlX;
  private int hlY;
  private float qPA;
  private float qPB;
  private float qPC;
  private float qPD;
  private float qPE;
  private float qPF;
  private float qPG;
  private float qPH;
  private float qPz;
  
  public ShakeEggAnimFrame$b(ShakeEggAnimFrame paramShakeEggAnimFrame, int paramInt1, int paramInt2)
  {
    super(paramShakeEggAnimFrame);
    AppMethodBeat.i(24711);
    this.ay = 0.01F;
    this.qPD = 0.02F;
    this.hlX = paramInt1;
    this.hlY = paramInt2;
    this.qPz = ShakeEggAnimFrame.ab(0.1F, 0.9F);
    this.qPA = this.qPz;
    this.qPC = ShakeEggAnimFrame.ab(-0.3F, -0.1F);
    restart();
    AppMethodBeat.o(24711);
  }
  
  private void resolve()
  {
    this.qPE = (this.qPz * this.hlX);
    this.qPF = (this.qPA * this.hlX);
    this.qPG = (this.qPB * this.hlY);
    this.qPH = (this.qPC * this.hlY);
  }
  
  private void restart()
  {
    AppMethodBeat.i(24713);
    if (this.qPC > 0.0F) {
      this.qPD += this.ay;
    }
    this.qPB = this.qPC;
    this.qPC += this.qPD;
    if (this.qPB > 1.1F) {
      clV();
    }
    resolve();
    AppMethodBeat.o(24713);
  }
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    AppMethodBeat.i(24712);
    float f1 = this.qPE;
    float f2 = this.qPG;
    if (this.qPE != this.qPF) {
      f1 = this.qPE + (this.qPF - this.qPE) * paramFloat;
    }
    if (this.qPG != this.qPH) {
      f2 = this.qPG + (this.qPH - this.qPG) * paramFloat;
    }
    paramTransformation.getMatrix().setTranslate(f1, f2);
    if (paramFloat == 1.0F) {
      restart();
    }
    AppMethodBeat.o(24712);
  }
  
  public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(24714);
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    setRepeatCount(-1);
    setDuration(this.duration);
    AppMethodBeat.o(24714);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeEggAnimFrame.b
 * JD-Core Version:    0.7.0.1
 */