package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.sdk.platformtools.Log;

public final class y
{
  i.e HKU = i.e.RcE;
  public boolean pDp;
  int pEj;
  int pEk;
  public int pEl;
  public int pEm;
  int videoHeight;
  int videoWidth;
  
  private void aw(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(134104);
    if (!this.pDp)
    {
      if (this.pEj < this.pEk)
      {
        this.pEm = ((int)(this.pEj / paramFloat1));
        this.pEl = this.pEj;
        AppMethodBeat.o(134104);
        return;
      }
      this.pEl = ((int)(this.pEk * paramFloat1));
      this.pEm = this.pEk;
      AppMethodBeat.o(134104);
      return;
    }
    if (Math.abs(paramFloat1 - paramFloat2) > 0.05D)
    {
      if (this.pEj < this.pEk)
      {
        this.pEm = ((int)(this.pEj / paramFloat1));
        this.pEl = this.pEj;
        AppMethodBeat.o(134104);
        return;
      }
      this.pEl = ((int)(this.pEk * paramFloat1));
      this.pEm = this.pEk;
      AppMethodBeat.o(134104);
      return;
    }
    if (this.pEj > this.pEk)
    {
      this.pEm = ((int)(this.pEj / paramFloat1));
      this.pEl = this.pEj;
      AppMethodBeat.o(134104);
      return;
    }
    this.pEl = ((int)(this.pEk * paramFloat1));
    this.pEm = this.pEk;
    AppMethodBeat.o(134104);
  }
  
  private void ct(float paramFloat)
  {
    if (this.pEj < this.pEk)
    {
      this.pEm = ((int)(this.pEj / paramFloat));
      this.pEl = this.pEj;
      if (this.pEm > this.pEk)
      {
        this.pEl = ((int)(this.pEk * paramFloat));
        this.pEm = this.pEk;
      }
    }
    do
    {
      return;
      this.pEl = ((int)(this.pEk * paramFloat));
      this.pEm = this.pEk;
    } while (this.pEl <= this.pEj);
    this.pEm = ((int)(this.pEj / paramFloat));
    this.pEl = this.pEj;
  }
  
  private void cu(float paramFloat)
  {
    if (this.pEj > this.pEk)
    {
      this.pEm = ((int)(this.pEj / paramFloat));
      this.pEl = this.pEj;
      if (this.pEm < this.pEk)
      {
        this.pEl = ((int)(this.pEk * paramFloat));
        this.pEm = this.pEk;
      }
    }
    do
    {
      return;
      this.pEl = ((int)(this.pEk * paramFloat));
      this.pEm = this.pEk;
    } while (this.pEl >= this.pEj);
    this.pEm = ((int)(this.pEj / paramFloat));
    this.pEl = this.pEj;
  }
  
  private void hnQ()
  {
    this.pEm = this.pEk;
    this.pEl = this.pEj;
  }
  
  public final boolean A(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(134103);
    if ((this.pEj == paramInt1) && (this.pEk == paramInt2) && (this.videoWidth == paramInt3) && (this.videoHeight == paramInt4))
    {
      AppMethodBeat.o(134103);
      return true;
    }
    this.pEj = paramInt1;
    this.pEk = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    float f1 = this.videoWidth * 1.0F / this.videoHeight;
    float f2 = this.pEj * 1.0F / this.pEk;
    if (this.HKU != i.e.RcE) {
      if (this.HKU == i.e.RcG) {
        ct(f1);
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", new Object[] { Integer.valueOf(this.pEj), Integer.valueOf(this.pEk), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.pEl), Integer.valueOf(this.pEm), Float.valueOf(f2), Float.valueOf(f1) });
      AppMethodBeat.o(134103);
      return false;
      if (this.HKU == i.e.RcF) {
        hnQ();
      } else if (this.HKU == i.e.RcH) {
        cu(f1);
      } else {
        aw(f1, f2);
      }
    }
  }
  
  public final boolean a(i.e parame)
  {
    AppMethodBeat.i(169170);
    if (this.HKU == parame) {}
    for (int i = 1;; i = 0)
    {
      Log.i("MicroMsg.ViewSizeCache", "set scale type old[%s] new[%s]", new Object[] { this.HKU, parame });
      this.HKU = parame;
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
    this.pEk = 0;
    this.pEj = 0;
    this.videoHeight = 0;
    this.videoWidth = 0;
    this.pEm = 0;
    this.pEl = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.y
 * JD-Core Version:    0.7.0.1
 */