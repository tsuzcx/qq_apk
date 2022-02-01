package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.sdk.platformtools.ae;

public final class u
{
  int lxZ;
  public boolean lxh;
  int lya;
  public int lyb;
  public int lyc;
  int videoHeight;
  int videoWidth;
  i.e xOi = i.e.Flh;
  
  private void ak(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(134104);
    if (!this.lxh)
    {
      if (this.lxZ < this.lya)
      {
        this.lyc = ((int)(this.lxZ / paramFloat1));
        this.lyb = this.lxZ;
        AppMethodBeat.o(134104);
        return;
      }
      this.lyb = ((int)(this.lya * paramFloat1));
      this.lyc = this.lya;
      AppMethodBeat.o(134104);
      return;
    }
    if (Math.abs(paramFloat1 - paramFloat2) > 0.05D)
    {
      if (this.lxZ < this.lya)
      {
        this.lyc = ((int)(this.lxZ / paramFloat1));
        this.lyb = this.lxZ;
        AppMethodBeat.o(134104);
        return;
      }
      this.lyb = ((int)(this.lya * paramFloat1));
      this.lyc = this.lya;
      AppMethodBeat.o(134104);
      return;
    }
    if (this.lxZ > this.lya)
    {
      this.lyc = ((int)(this.lxZ / paramFloat1));
      this.lyb = this.lxZ;
      AppMethodBeat.o(134104);
      return;
    }
    this.lyb = ((int)(this.lya * paramFloat1));
    this.lyc = this.lya;
    AppMethodBeat.o(134104);
  }
  
  private void bM(float paramFloat)
  {
    if (this.lxZ < this.lya)
    {
      this.lyc = ((int)(this.lxZ / paramFloat));
      this.lyb = this.lxZ;
      if (this.lyc > this.lya)
      {
        this.lyb = ((int)(this.lya * paramFloat));
        this.lyc = this.lya;
      }
    }
    do
    {
      return;
      this.lyb = ((int)(this.lya * paramFloat));
      this.lyc = this.lya;
    } while (this.lyb <= this.lxZ);
    this.lyc = ((int)(this.lxZ / paramFloat));
    this.lyb = this.lxZ;
  }
  
  private void bN(float paramFloat)
  {
    if (this.lxZ > this.lya)
    {
      this.lyc = ((int)(this.lxZ / paramFloat));
      this.lyb = this.lxZ;
      if (this.lyc < this.lya)
      {
        this.lyb = ((int)(this.lya * paramFloat));
        this.lyc = this.lya;
      }
    }
    do
    {
      return;
      this.lyb = ((int)(this.lya * paramFloat));
      this.lyc = this.lya;
    } while (this.lyb >= this.lxZ);
    this.lyc = ((int)(this.lxZ / paramFloat));
    this.lyb = this.lxZ;
  }
  
  private void fji()
  {
    this.lyc = this.lya;
    this.lyb = this.lxZ;
  }
  
  public final boolean a(i.e parame)
  {
    AppMethodBeat.i(169170);
    if (this.xOi == parame) {}
    for (int i = 1;; i = 0)
    {
      ae.i("MicroMsg.ViewSizeCache", "set scale type old[%s] new[%s]", new Object[] { this.xOi, parame });
      this.xOi = parame;
      reset();
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(169170);
      return true;
    }
    AppMethodBeat.o(169170);
    return false;
  }
  
  public final void reset()
  {
    this.lya = 0;
    this.lxZ = 0;
    this.videoHeight = 0;
    this.videoWidth = 0;
    this.lyc = 0;
    this.lyb = 0;
  }
  
  public final boolean y(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(134103);
    if ((this.lxZ == paramInt1) && (this.lya == paramInt2) && (this.videoWidth == paramInt3) && (this.videoHeight == paramInt4))
    {
      AppMethodBeat.o(134103);
      return true;
    }
    this.lxZ = paramInt1;
    this.lya = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    float f1 = this.videoWidth * 1.0F / this.videoHeight;
    float f2 = this.lxZ * 1.0F / this.lya;
    if (this.xOi != i.e.Flh) {
      if (this.xOi == i.e.Flj) {
        bM(f1);
      }
    }
    for (;;)
    {
      ae.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", new Object[] { Integer.valueOf(this.lxZ), Integer.valueOf(this.lya), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.lyb), Integer.valueOf(this.lyc), Float.valueOf(f2), Float.valueOf(f1) });
      AppMethodBeat.o(134103);
      return false;
      if (this.xOi == i.e.Fli) {
        fji();
      } else if (this.xOi == i.e.Flk) {
        bN(f1);
      } else {
        ak(f1, f2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.u
 * JD-Core Version:    0.7.0.1
 */