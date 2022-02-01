package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.sdk.platformtools.Log;

public final class x
{
  i.e NHS = i.e.XYK;
  int pvg;
  public boolean sIB;
  int sJv;
  public int sJw;
  public int sJx;
  int videoHeight;
  int videoWidth;
  
  private void at(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(134104);
    if (!this.sIB)
    {
      if (this.sJv < this.pvg)
      {
        this.sJx = ((int)(this.sJv / paramFloat1));
        this.sJw = this.sJv;
        AppMethodBeat.o(134104);
        return;
      }
      this.sJw = ((int)(this.pvg * paramFloat1));
      this.sJx = this.pvg;
      AppMethodBeat.o(134104);
      return;
    }
    if (Math.abs(paramFloat1 - paramFloat2) > 0.05D)
    {
      if (this.sJv < this.pvg)
      {
        this.sJx = ((int)(this.sJv / paramFloat1));
        this.sJw = this.sJv;
        AppMethodBeat.o(134104);
        return;
      }
      this.sJw = ((int)(this.pvg * paramFloat1));
      this.sJx = this.pvg;
      AppMethodBeat.o(134104);
      return;
    }
    if (this.sJv > this.pvg)
    {
      this.sJx = ((int)(this.sJv / paramFloat1));
      this.sJw = this.sJv;
      AppMethodBeat.o(134104);
      return;
    }
    this.sJw = ((int)(this.pvg * paramFloat1));
    this.sJx = this.pvg;
    AppMethodBeat.o(134104);
  }
  
  private void bO(float paramFloat)
  {
    if (this.sJv < this.pvg)
    {
      this.sJx = ((int)(this.sJv / paramFloat));
      this.sJw = this.sJv;
      if (this.sJx > this.pvg)
      {
        this.sJw = ((int)(this.pvg * paramFloat));
        this.sJx = this.pvg;
      }
    }
    do
    {
      return;
      this.sJw = ((int)(this.pvg * paramFloat));
      this.sJx = this.pvg;
    } while (this.sJw <= this.sJv);
    this.sJx = ((int)(this.sJv / paramFloat));
    this.sJw = this.sJv;
  }
  
  private void bP(float paramFloat)
  {
    if (this.sJv > this.pvg)
    {
      this.sJx = ((int)(this.sJv / paramFloat));
      this.sJw = this.sJv;
      if (this.sJx < this.pvg)
      {
        this.sJw = ((int)(this.pvg * paramFloat));
        this.sJx = this.pvg;
      }
    }
    do
    {
      return;
      this.sJw = ((int)(this.pvg * paramFloat));
      this.sJx = this.pvg;
    } while (this.sJw >= this.sJv);
    this.sJx = ((int)(this.sJv / paramFloat));
    this.sJw = this.sJv;
  }
  
  private void cyT()
  {
    this.sJx = this.pvg;
    this.sJw = this.sJv;
  }
  
  public final boolean G(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(134103);
    if ((this.sJv == paramInt1) && (this.pvg == paramInt2) && (this.videoWidth == paramInt3) && (this.videoHeight == paramInt4))
    {
      AppMethodBeat.o(134103);
      return true;
    }
    this.sJv = paramInt1;
    this.pvg = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    float f1 = this.videoWidth * 1.0F / this.videoHeight;
    float f2 = this.sJv * 1.0F / this.pvg;
    if (this.NHS != i.e.XYK) {
      if (this.NHS == i.e.XYM) {
        bO(f1);
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", new Object[] { Integer.valueOf(this.sJv), Integer.valueOf(this.pvg), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.sJw), Integer.valueOf(this.sJx), Float.valueOf(f2), Float.valueOf(f1) });
      AppMethodBeat.o(134103);
      return false;
      if (this.NHS == i.e.XYL) {
        cyT();
      } else if (this.NHS == i.e.XYN) {
        bP(f1);
      } else {
        at(f1, f2);
      }
    }
  }
  
  public final boolean a(i.e parame)
  {
    AppMethodBeat.i(169170);
    if (this.NHS == parame) {}
    for (int i = 1;; i = 0)
    {
      Log.i("MicroMsg.ViewSizeCache", "set scale type old[%s] new[%s]", new Object[] { this.NHS, parame });
      this.NHS = parame;
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
    this.pvg = 0;
    this.sJv = 0;
    this.videoHeight = 0;
    this.videoWidth = 0;
    this.sJx = 0;
    this.sJw = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.x
 * JD-Core Version:    0.7.0.1
 */