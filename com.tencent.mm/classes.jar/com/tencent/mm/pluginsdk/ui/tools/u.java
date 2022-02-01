package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.sdk.platformtools.ac;

public final class u
{
  public boolean kVJ;
  int kWB;
  int kWC;
  public int kWD;
  public int kWE;
  int videoHeight;
  int videoWidth;
  h.e wqv = h.e.DnH;
  
  private void ag(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(134104);
    if (!this.kVJ)
    {
      if (this.kWB < this.kWC)
      {
        this.kWE = ((int)(this.kWB / paramFloat1));
        this.kWD = this.kWB;
        AppMethodBeat.o(134104);
        return;
      }
      this.kWD = ((int)(this.kWC * paramFloat1));
      this.kWE = this.kWC;
      AppMethodBeat.o(134104);
      return;
    }
    if (Math.abs(paramFloat1 - paramFloat2) > 0.05D)
    {
      if (this.kWB < this.kWC)
      {
        this.kWE = ((int)(this.kWB / paramFloat1));
        this.kWD = this.kWB;
        AppMethodBeat.o(134104);
        return;
      }
      this.kWD = ((int)(this.kWC * paramFloat1));
      this.kWE = this.kWC;
      AppMethodBeat.o(134104);
      return;
    }
    if (this.kWB > this.kWC)
    {
      this.kWE = ((int)(this.kWB / paramFloat1));
      this.kWD = this.kWB;
      AppMethodBeat.o(134104);
      return;
    }
    this.kWD = ((int)(this.kWC * paramFloat1));
    this.kWE = this.kWC;
    AppMethodBeat.o(134104);
  }
  
  private void bJ(float paramFloat)
  {
    if (this.kWB < this.kWC)
    {
      this.kWE = ((int)(this.kWB / paramFloat));
      this.kWD = this.kWB;
      if (this.kWE > this.kWC)
      {
        this.kWD = ((int)(this.kWC * paramFloat));
        this.kWE = this.kWC;
      }
    }
    do
    {
      return;
      this.kWD = ((int)(this.kWC * paramFloat));
      this.kWE = this.kWC;
    } while (this.kWD <= this.kWB);
    this.kWE = ((int)(this.kWB / paramFloat));
    this.kWD = this.kWB;
  }
  
  private void bK(float paramFloat)
  {
    if (this.kWB > this.kWC)
    {
      this.kWE = ((int)(this.kWB / paramFloat));
      this.kWD = this.kWB;
      if (this.kWE < this.kWC)
      {
        this.kWD = ((int)(this.kWC * paramFloat));
        this.kWE = this.kWC;
      }
    }
    do
    {
      return;
      this.kWD = ((int)(this.kWC * paramFloat));
      this.kWE = this.kWC;
    } while (this.kWD >= this.kWB);
    this.kWE = ((int)(this.kWB / paramFloat));
    this.kWD = this.kWB;
  }
  
  private void eQq()
  {
    this.kWE = this.kWC;
    this.kWD = this.kWB;
  }
  
  public final boolean a(h.e parame)
  {
    AppMethodBeat.i(169170);
    if (this.wqv == parame) {}
    for (int i = 1;; i = 0)
    {
      ac.i("MicroMsg.ViewSizeCache", "set scale type old[%s] new[%s]", new Object[] { this.wqv, parame });
      this.wqv = parame;
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
    this.kWC = 0;
    this.kWB = 0;
    this.videoHeight = 0;
    this.videoWidth = 0;
    this.kWE = 0;
    this.kWD = 0;
  }
  
  public final boolean x(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(134103);
    if ((this.kWB == paramInt1) && (this.kWC == paramInt2) && (this.videoWidth == paramInt3) && (this.videoHeight == paramInt4))
    {
      AppMethodBeat.o(134103);
      return true;
    }
    this.kWB = paramInt1;
    this.kWC = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    float f1 = this.videoWidth * 1.0F / this.videoHeight;
    float f2 = this.kWB * 1.0F / this.kWC;
    if (this.wqv != h.e.DnH) {
      if (this.wqv == h.e.DnJ) {
        bJ(f1);
      }
    }
    for (;;)
    {
      ac.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", new Object[] { Integer.valueOf(this.kWB), Integer.valueOf(this.kWC), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.kWD), Integer.valueOf(this.kWE), Float.valueOf(f2), Float.valueOf(f1) });
      AppMethodBeat.o(134103);
      return false;
      if (this.wqv == h.e.DnI) {
        eQq();
      } else if (this.wqv == h.e.DnK) {
        bK(f1);
      } else {
        ag(f1, f2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.u
 * JD-Core Version:    0.7.0.1
 */