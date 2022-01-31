package com.tencent.mm.ui.chatting;

import android.graphics.Matrix;
import android.view.View.OnLayoutChangeListener;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.c.a.a;
import com.tencent.mm.ui.c.a.b;

final class ChattingAnimFrame$b
  extends Animation
{
  private int mSize;
  private View.OnLayoutChangeListener yYb;
  private float zxF;
  private float zxG;
  private float zxH;
  private float zxI;
  private float zxJ;
  private float zxK;
  private float zxL;
  private float zxM;
  private float zxN;
  private float zxO;
  private int zxP;
  private boolean zxQ;
  
  public ChattingAnimFrame$b(ChattingAnimFrame paramChattingAnimFrame, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30507);
    this.zxP = 0;
    this.mSize = 0;
    this.zxQ = false;
    this.yYb = new ChattingAnimFrame.b.1(this);
    this.zxP = paramInt1;
    this.mSize = paramInt2;
    this.zxQ = false;
    AppMethodBeat.o(30507);
  }
  
  public ChattingAnimFrame$b(ChattingAnimFrame paramChattingAnimFrame, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(30508);
    this.zxP = 0;
    this.mSize = 0;
    this.zxQ = false;
    this.yYb = new ChattingAnimFrame.b.1(this);
    this.zxP = paramInt1;
    this.mSize = paramInt2;
    this.zxQ = paramBoolean;
    AppMethodBeat.o(30508);
  }
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    AppMethodBeat.i(30510);
    float f2 = this.zxJ;
    float f1 = this.zxL;
    if (this.zxJ != this.zxK) {
      f2 = this.zxJ + (this.zxK - this.zxJ) * paramFloat;
    }
    if (this.zxL != this.zxM)
    {
      float f3 = this.zxL + (this.zxM - this.zxL) * paramFloat;
      f1 = f3;
      if (this.zxP == 2) {
        f1 = f3 - this.mSize;
      }
    }
    paramTransformation.getMatrix().setTranslate(f2, f1);
    if ((this.zxN != this.zxO) && (3 == this.zxP))
    {
      paramFloat = this.zxN + (this.zxO - this.zxN) * paramFloat;
      paramTransformation.getMatrix().postScale(paramFloat, paramFloat);
    }
    AppMethodBeat.o(30510);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(30511);
    super.finalize();
    ab.i("MicroMsg.ChattingAnimFrame", "finalize!");
    this.zxE.removeOnLayoutChangeListener(this.yYb);
    AppMethodBeat.o(30511);
  }
  
  public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(30509);
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    switch (this.zxP)
    {
    default: 
      this.zxF = ChattingAnimFrame.ab(0.1F, 0.9F);
      this.zxG = ChattingAnimFrame.ab(this.zxF - 0.5F, this.zxF + 0.5F);
      this.zxH = -0.2F;
      this.zxI = 1.2F;
      setInterpolator(new LinearInterpolator());
    }
    for (;;)
    {
      if ((this.zxP != 0) && (this.zxP != 1)) {
        this.zxE.addOnLayoutChangeListener(this.yYb);
      }
      resolve();
      AppMethodBeat.o(30509);
      return;
      this.zxF = ChattingAnimFrame.ab(0.1F, 0.9F);
      this.zxG = ChattingAnimFrame.ab(this.zxF - 0.25F, this.zxF + 0.25F);
      this.zxH = 1.5F;
      this.zxI = -0.2F;
      setInterpolator(new LinearInterpolator());
      continue;
      this.zxF = 0.0F;
      this.zxG = 0.0F;
      this.zxH = 1.5F;
      if (this.zxQ) {}
      for (this.zxI = ChattingAnimFrame.ab(0.4F, 0.55F);; this.zxI = ChattingAnimFrame.ab(0.55F, 0.85F))
      {
        setInterpolator(new b());
        break;
      }
      this.zxF = 0.0F;
      this.zxG = 0.0F;
      this.zxH = 0.0F;
      this.zxI = 1.0F;
      setInterpolator(new a());
      continue;
      this.zxF = ChattingAnimFrame.ab(0.1F, 0.9F);
      this.zxG = ChattingAnimFrame.ab(this.zxF - 0.5F, this.zxF + 0.5F);
      this.zxH = 0.0F;
      this.zxI = 0.0F;
      this.zxN = 0.8F;
      this.zxO = 1.1F;
      setInterpolator(new LinearInterpolator());
      continue;
      float f = ChattingAnimFrame.ab(0.0F, 1.0F - this.mSize * 1.0F / ChattingAnimFrame.a(this.zxE));
      this.zxF = 1.0F;
      this.zxG = (0.0F - this.mSize * 1.0F / ChattingAnimFrame.b(this.zxE));
      this.zxH = f;
      this.zxI = f;
      setInterpolator(new LinearInterpolator());
    }
  }
  
  public final void resolve()
  {
    AppMethodBeat.i(30512);
    this.zxJ = (this.zxF * ChattingAnimFrame.b(this.zxE));
    this.zxK = (this.zxG * ChattingAnimFrame.b(this.zxE));
    if (this.zxP == 2)
    {
      this.zxL = (this.zxH * ChattingAnimFrame.a(this.zxE));
      this.zxM = (this.zxI * ChattingAnimFrame.a(this.zxE));
      AppMethodBeat.o(30512);
      return;
    }
    if (this.zxP == 3)
    {
      this.zxL = (this.zxH * ChattingAnimFrame.c(this.zxE));
      this.zxM = (this.zxI * ChattingAnimFrame.c(this.zxE));
      if (ChattingAnimFrame.d(this.zxE))
      {
        this.zxL = (this.zxH * ChattingAnimFrame.c(this.zxE) - ChattingAnimFrame.e(this.zxE));
        this.zxM = (this.zxI * ChattingAnimFrame.c(this.zxE) - ChattingAnimFrame.e(this.zxE));
      }
      if (this.zxM < 0.0F)
      {
        this.zxM = 0.0F;
        AppMethodBeat.o(30512);
      }
    }
    else
    {
      if (this.zxP == 4)
      {
        this.zxL = (this.zxH * ChattingAnimFrame.a(this.zxE));
        this.zxM = (this.zxI * ChattingAnimFrame.a(this.zxE));
        AppMethodBeat.o(30512);
        return;
      }
      this.zxL = (this.zxH * ChattingAnimFrame.c(this.zxE));
      this.zxM = (this.zxI * ChattingAnimFrame.c(this.zxE));
    }
    AppMethodBeat.o(30512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingAnimFrame.b
 * JD-Core Version:    0.7.0.1
 */