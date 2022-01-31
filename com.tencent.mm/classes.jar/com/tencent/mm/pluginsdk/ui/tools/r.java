package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class r
{
  int iiW;
  int iiX;
  int iiY;
  int iiZ;
  h.d ryj = h.d.vQI;
  int videoHeight;
  int videoWidth;
  boolean wfC;
  
  private void al(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(118047);
    if (!this.wfC)
    {
      if (this.iiW < this.iiX)
      {
        this.iiZ = ((int)(this.iiW / paramFloat1));
        this.iiY = this.iiW;
        AppMethodBeat.o(118047);
        return;
      }
      this.iiY = ((int)(this.iiX * paramFloat1));
      this.iiZ = this.iiX;
      AppMethodBeat.o(118047);
      return;
    }
    if (Math.abs(paramFloat1 - paramFloat2) > 0.05D)
    {
      if (this.iiW < this.iiX)
      {
        this.iiZ = ((int)(this.iiW / paramFloat1));
        this.iiY = this.iiW;
        AppMethodBeat.o(118047);
        return;
      }
      this.iiY = ((int)(this.iiX * paramFloat1));
      this.iiZ = this.iiX;
      AppMethodBeat.o(118047);
      return;
    }
    if (this.iiW > this.iiX)
    {
      this.iiZ = ((int)(this.iiW / paramFloat1));
      this.iiY = this.iiW;
      AppMethodBeat.o(118047);
      return;
    }
    this.iiY = ((int)(this.iiX * paramFloat1));
    this.iiZ = this.iiX;
    AppMethodBeat.o(118047);
  }
  
  private void bq(float paramFloat)
  {
    if (this.iiW < this.iiX)
    {
      this.iiZ = ((int)(this.iiW / paramFloat));
      this.iiY = this.iiW;
      if (this.iiZ > this.iiX)
      {
        this.iiY = ((int)(this.iiX * paramFloat));
        this.iiZ = this.iiX;
      }
    }
    do
    {
      return;
      this.iiY = ((int)(this.iiX * paramFloat));
      this.iiZ = this.iiX;
    } while (this.iiY <= this.iiW);
    this.iiZ = ((int)(this.iiW / paramFloat));
    this.iiY = this.iiW;
  }
  
  private void br(float paramFloat)
  {
    if (this.iiW > this.iiX)
    {
      this.iiZ = ((int)(this.iiW / paramFloat));
      this.iiY = this.iiW;
      if (this.iiZ < this.iiX)
      {
        this.iiY = ((int)(this.iiX * paramFloat));
        this.iiZ = this.iiX;
      }
    }
    do
    {
      return;
      this.iiY = ((int)(this.iiX * paramFloat));
      this.iiZ = this.iiX;
    } while (this.iiY >= this.iiW);
    this.iiZ = ((int)(this.iiW / paramFloat));
    this.iiY = this.iiW;
  }
  
  private void dpJ()
  {
    this.iiZ = this.iiX;
    this.iiY = this.iiW;
  }
  
  final boolean H(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(118046);
    if ((this.iiW == paramInt1) && (this.iiX == paramInt2) && (this.videoWidth == paramInt3) && (this.videoHeight == paramInt4))
    {
      AppMethodBeat.o(118046);
      return true;
    }
    this.iiW = paramInt1;
    this.iiX = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    float f1 = this.videoWidth * 1.0F / this.videoHeight;
    float f2 = this.iiW * 1.0F / this.iiX;
    if (this.ryj != h.d.vQI) {
      if (this.ryj == h.d.vQK) {
        bq(f1);
      }
    }
    for (;;)
    {
      ab.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", new Object[] { Integer.valueOf(this.iiW), Integer.valueOf(this.iiX), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.iiY), Integer.valueOf(this.iiZ), Float.valueOf(f2), Float.valueOf(f1) });
      AppMethodBeat.o(118046);
      return false;
      if (this.ryj == h.d.vQJ) {
        dpJ();
      } else if (this.ryj == h.d.vQL) {
        br(f1);
      } else {
        al(f1, f2);
      }
    }
  }
  
  final void reset()
  {
    this.iiX = 0;
    this.iiW = 0;
    this.videoHeight = 0;
    this.videoWidth = 0;
    this.iiZ = 0;
    this.iiY = 0;
  }
  
  public final void setScaleType(h.d paramd)
  {
    AppMethodBeat.i(118045);
    ab.i("MicroMsg.ViewSizeCache", "set scale type old[%s] new[%s]", new Object[] { this.ryj, paramd });
    this.ryj = paramd;
    reset();
    AppMethodBeat.o(118045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.r
 * JD-Core Version:    0.7.0.1
 */