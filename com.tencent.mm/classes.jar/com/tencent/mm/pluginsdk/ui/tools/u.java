package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.sdk.platformtools.ad;

public final class u
{
  public boolean lsI;
  int ltA;
  int ltB;
  public int ltC;
  public int ltD;
  int videoHeight;
  int videoWidth;
  i.e xyl = i.e.ESM;
  
  private void ak(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(134104);
    if (!this.lsI)
    {
      if (this.ltA < this.ltB)
      {
        this.ltD = ((int)(this.ltA / paramFloat1));
        this.ltC = this.ltA;
        AppMethodBeat.o(134104);
        return;
      }
      this.ltC = ((int)(this.ltB * paramFloat1));
      this.ltD = this.ltB;
      AppMethodBeat.o(134104);
      return;
    }
    if (Math.abs(paramFloat1 - paramFloat2) > 0.05D)
    {
      if (this.ltA < this.ltB)
      {
        this.ltD = ((int)(this.ltA / paramFloat1));
        this.ltC = this.ltA;
        AppMethodBeat.o(134104);
        return;
      }
      this.ltC = ((int)(this.ltB * paramFloat1));
      this.ltD = this.ltB;
      AppMethodBeat.o(134104);
      return;
    }
    if (this.ltA > this.ltB)
    {
      this.ltD = ((int)(this.ltA / paramFloat1));
      this.ltC = this.ltA;
      AppMethodBeat.o(134104);
      return;
    }
    this.ltC = ((int)(this.ltB * paramFloat1));
    this.ltD = this.ltB;
    AppMethodBeat.o(134104);
  }
  
  private void bO(float paramFloat)
  {
    if (this.ltA < this.ltB)
    {
      this.ltD = ((int)(this.ltA / paramFloat));
      this.ltC = this.ltA;
      if (this.ltD > this.ltB)
      {
        this.ltC = ((int)(this.ltB * paramFloat));
        this.ltD = this.ltB;
      }
    }
    do
    {
      return;
      this.ltC = ((int)(this.ltB * paramFloat));
      this.ltD = this.ltB;
    } while (this.ltC <= this.ltA);
    this.ltD = ((int)(this.ltA / paramFloat));
    this.ltC = this.ltA;
  }
  
  private void bP(float paramFloat)
  {
    if (this.ltA > this.ltB)
    {
      this.ltD = ((int)(this.ltA / paramFloat));
      this.ltC = this.ltA;
      if (this.ltD < this.ltB)
      {
        this.ltC = ((int)(this.ltB * paramFloat));
        this.ltD = this.ltB;
      }
    }
    do
    {
      return;
      this.ltC = ((int)(this.ltB * paramFloat));
      this.ltD = this.ltB;
    } while (this.ltC >= this.ltA);
    this.ltD = ((int)(this.ltA / paramFloat));
    this.ltC = this.ltA;
  }
  
  private void ffs()
  {
    this.ltD = this.ltB;
    this.ltC = this.ltA;
  }
  
  public final boolean a(i.e parame)
  {
    AppMethodBeat.i(169170);
    if (this.xyl == parame) {}
    for (int i = 1;; i = 0)
    {
      ad.i("MicroMsg.ViewSizeCache", "set scale type old[%s] new[%s]", new Object[] { this.xyl, parame });
      this.xyl = parame;
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
    this.ltB = 0;
    this.ltA = 0;
    this.videoHeight = 0;
    this.videoWidth = 0;
    this.ltD = 0;
    this.ltC = 0;
  }
  
  public final boolean y(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(134103);
    if ((this.ltA == paramInt1) && (this.ltB == paramInt2) && (this.videoWidth == paramInt3) && (this.videoHeight == paramInt4))
    {
      AppMethodBeat.o(134103);
      return true;
    }
    this.ltA = paramInt1;
    this.ltB = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    float f1 = this.videoWidth * 1.0F / this.videoHeight;
    float f2 = this.ltA * 1.0F / this.ltB;
    if (this.xyl != i.e.ESM) {
      if (this.xyl == i.e.ESO) {
        bO(f1);
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", new Object[] { Integer.valueOf(this.ltA), Integer.valueOf(this.ltB), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.ltC), Integer.valueOf(this.ltD), Float.valueOf(f2), Float.valueOf(f1) });
      AppMethodBeat.o(134103);
      return false;
      if (this.xyl == i.e.ESN) {
        ffs();
      } else if (this.xyl == i.e.ESP) {
        bP(f1);
      } else {
        ak(f1, f2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.u
 * JD-Core Version:    0.7.0.1
 */