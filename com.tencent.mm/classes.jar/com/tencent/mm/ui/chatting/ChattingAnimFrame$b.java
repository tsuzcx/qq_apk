package com.tencent.mm.ui.chatting;

import android.graphics.Matrix;
import android.view.View.OnLayoutChangeListener;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.c.a.a;
import com.tencent.mm.ui.c.a.b;

final class ChattingAnimFrame$b
  extends Animation
{
  private float hYB;
  private float hYC;
  private float hYD;
  private float hYE;
  private float hYF;
  private float hYG;
  private int mSize = 0;
  private View.OnLayoutChangeListener uKj = new ChattingAnimFrame.b.1(this);
  private float viL;
  private float viM;
  private float viN;
  private float viO;
  private int viP = 0;
  private boolean viQ = false;
  
  public ChattingAnimFrame$b(ChattingAnimFrame paramChattingAnimFrame, int paramInt1, int paramInt2)
  {
    this.viP = paramInt1;
    this.mSize = paramInt2;
    this.viQ = false;
  }
  
  public ChattingAnimFrame$b(ChattingAnimFrame paramChattingAnimFrame, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.viP = paramInt1;
    this.mSize = paramInt2;
    this.viQ = paramBoolean;
  }
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f2 = this.hYD;
    float f1 = this.hYF;
    if (this.hYD != this.hYE) {
      f2 = this.hYD + (this.hYE - this.hYD) * paramFloat;
    }
    if (this.hYF != this.hYG)
    {
      float f3 = this.hYF + (this.hYG - this.hYF) * paramFloat;
      f1 = f3;
      if (this.viP == 2) {
        f1 = f3 - this.mSize;
      }
    }
    paramTransformation.getMatrix().setTranslate(f2, f1);
    if ((this.hYB != this.hYC) && (3 == this.viP))
    {
      paramFloat = this.hYB + (this.hYC - this.hYB) * paramFloat;
      paramTransformation.getMatrix().postScale(paramFloat, paramFloat);
    }
  }
  
  public final void awP()
  {
    this.hYD = (this.viL * ChattingAnimFrame.a(this.viK));
    this.hYE = (this.viM * ChattingAnimFrame.a(this.viK));
    if (this.viP == 2)
    {
      this.hYF = (this.viN * ChattingAnimFrame.b(this.viK));
      this.hYG = (this.viO * ChattingAnimFrame.b(this.viK));
    }
    do
    {
      return;
      if (this.viP != 3) {
        break;
      }
      this.hYF = (this.viN * ChattingAnimFrame.c(this.viK));
      this.hYG = (this.viO * ChattingAnimFrame.c(this.viK));
      if (ChattingAnimFrame.d(this.viK))
      {
        this.hYF = (this.viN * ChattingAnimFrame.c(this.viK) - ChattingAnimFrame.e(this.viK));
        this.hYG = (this.viO * ChattingAnimFrame.c(this.viK) - ChattingAnimFrame.e(this.viK));
      }
    } while (this.hYG >= 0.0F);
    this.hYG = 0.0F;
    return;
    this.hYF = (this.viN * ChattingAnimFrame.c(this.viK));
    this.hYG = (this.viO * ChattingAnimFrame.c(this.viK));
  }
  
  protected final void finalize()
  {
    super.finalize();
    y.i("MicroMsg.ChattingAnimFrame", "finalize!");
    this.viK.removeOnLayoutChangeListener(this.uKj);
  }
  
  public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    switch (this.viP)
    {
    default: 
      this.viL = ChattingAnimFrame.L(0.1F, 0.9F);
      this.viM = ChattingAnimFrame.L(this.viL - 0.5F, this.viL + 0.5F);
      this.viN = -0.2F;
      this.viO = 1.2F;
      setInterpolator(new LinearInterpolator());
    }
    for (;;)
    {
      if ((this.viP != 0) && (this.viP != 1)) {
        this.viK.addOnLayoutChangeListener(this.uKj);
      }
      awP();
      return;
      this.viL = ChattingAnimFrame.L(0.1F, 0.9F);
      this.viM = ChattingAnimFrame.L(this.viL - 0.25F, this.viL + 0.25F);
      this.viN = 1.5F;
      this.viO = -0.2F;
      setInterpolator(new LinearInterpolator());
      continue;
      this.viL = 0.0F;
      this.viM = 0.0F;
      this.viN = 1.5F;
      if (this.viQ) {}
      for (this.viO = ChattingAnimFrame.L(0.4F, 0.55F);; this.viO = ChattingAnimFrame.L(0.55F, 0.85F))
      {
        setInterpolator(new b());
        break;
      }
      this.viL = 0.0F;
      this.viM = 0.0F;
      this.viN = 0.0F;
      this.viO = 1.0F;
      setInterpolator(new a());
      continue;
      this.viL = ChattingAnimFrame.L(0.1F, 0.9F);
      this.viM = ChattingAnimFrame.L(this.viL - 0.5F, this.viL + 0.5F);
      this.viN = 0.0F;
      this.viO = 0.0F;
      this.hYB = 0.8F;
      this.hYC = 1.1F;
      setInterpolator(new LinearInterpolator());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingAnimFrame.b
 * JD-Core Version:    0.7.0.1
 */