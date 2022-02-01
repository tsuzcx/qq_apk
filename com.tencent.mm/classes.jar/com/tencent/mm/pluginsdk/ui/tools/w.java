package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.sdk.platformtools.Log;

public final class w
{
  i.e BOo = i.e.KbZ;
  int mEX;
  int mEY;
  public int mEZ;
  public boolean mEe;
  public int mFa;
  int videoHeight;
  int videoWidth;
  
  private void ar(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(134104);
    if (!this.mEe)
    {
      if (this.mEX < this.mEY)
      {
        this.mFa = ((int)(this.mEX / paramFloat1));
        this.mEZ = this.mEX;
        AppMethodBeat.o(134104);
        return;
      }
      this.mEZ = ((int)(this.mEY * paramFloat1));
      this.mFa = this.mEY;
      AppMethodBeat.o(134104);
      return;
    }
    if (Math.abs(paramFloat1 - paramFloat2) > 0.05D)
    {
      if (this.mEX < this.mEY)
      {
        this.mFa = ((int)(this.mEX / paramFloat1));
        this.mEZ = this.mEX;
        AppMethodBeat.o(134104);
        return;
      }
      this.mEZ = ((int)(this.mEY * paramFloat1));
      this.mFa = this.mEY;
      AppMethodBeat.o(134104);
      return;
    }
    if (this.mEX > this.mEY)
    {
      this.mFa = ((int)(this.mEX / paramFloat1));
      this.mEZ = this.mEX;
      AppMethodBeat.o(134104);
      return;
    }
    this.mEZ = ((int)(this.mEY * paramFloat1));
    this.mFa = this.mEY;
    AppMethodBeat.o(134104);
  }
  
  private void ck(float paramFloat)
  {
    if (this.mEX < this.mEY)
    {
      this.mFa = ((int)(this.mEX / paramFloat));
      this.mEZ = this.mEX;
      if (this.mFa > this.mEY)
      {
        this.mEZ = ((int)(this.mEY * paramFloat));
        this.mFa = this.mEY;
      }
    }
    do
    {
      return;
      this.mEZ = ((int)(this.mEY * paramFloat));
      this.mFa = this.mEY;
    } while (this.mEZ <= this.mEX);
    this.mFa = ((int)(this.mEX / paramFloat));
    this.mEZ = this.mEX;
  }
  
  private void cl(float paramFloat)
  {
    if (this.mEX > this.mEY)
    {
      this.mFa = ((int)(this.mEX / paramFloat));
      this.mEZ = this.mEX;
      if (this.mFa < this.mEY)
      {
        this.mEZ = ((int)(this.mEY * paramFloat));
        this.mFa = this.mEY;
      }
    }
    do
    {
      return;
      this.mEZ = ((int)(this.mEY * paramFloat));
      this.mFa = this.mEY;
    } while (this.mEZ >= this.mEX);
    this.mFa = ((int)(this.mEX / paramFloat));
    this.mEZ = this.mEX;
  }
  
  private void gsI()
  {
    this.mFa = this.mEY;
    this.mEZ = this.mEX;
  }
  
  public final boolean a(i.e parame)
  {
    AppMethodBeat.i(169170);
    if (this.BOo == parame) {}
    for (int i = 1;; i = 0)
    {
      Log.i("MicroMsg.ViewSizeCache", "set scale type old[%s] new[%s]", new Object[] { this.BOo, parame });
      this.BOo = parame;
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
    this.mEY = 0;
    this.mEX = 0;
    this.videoHeight = 0;
    this.videoWidth = 0;
    this.mFa = 0;
    this.mEZ = 0;
  }
  
  public final boolean y(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(134103);
    if ((this.mEX == paramInt1) && (this.mEY == paramInt2) && (this.videoWidth == paramInt3) && (this.videoHeight == paramInt4))
    {
      AppMethodBeat.o(134103);
      return true;
    }
    this.mEX = paramInt1;
    this.mEY = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    float f1 = this.videoWidth * 1.0F / this.videoHeight;
    float f2 = this.mEX * 1.0F / this.mEY;
    if (this.BOo != i.e.KbZ) {
      if (this.BOo == i.e.Kcb) {
        ck(f1);
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", new Object[] { Integer.valueOf(this.mEX), Integer.valueOf(this.mEY), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.mEZ), Integer.valueOf(this.mFa), Float.valueOf(f2), Float.valueOf(f1) });
      AppMethodBeat.o(134103);
      return false;
      if (this.BOo == i.e.Kca) {
        gsI();
      } else if (this.BOo == i.e.Kcc) {
        cl(f1);
      } else {
        ar(f1, f2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.w
 * JD-Core Version:    0.7.0.1
 */