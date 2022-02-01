package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.sdk.platformtools.ad;

public final class u
{
  public boolean kuu;
  int kvn;
  int kvo;
  public int kvp;
  public int kvq;
  h.e vhJ = h.e.BVq;
  int videoHeight;
  int videoWidth;
  
  private void ac(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(134104);
    if (!this.kuu)
    {
      if (this.kvn < this.kvo)
      {
        this.kvq = ((int)(this.kvn / paramFloat1));
        this.kvp = this.kvn;
        AppMethodBeat.o(134104);
        return;
      }
      this.kvp = ((int)(this.kvo * paramFloat1));
      this.kvq = this.kvo;
      AppMethodBeat.o(134104);
      return;
    }
    if (Math.abs(paramFloat1 - paramFloat2) > 0.05D)
    {
      if (this.kvn < this.kvo)
      {
        this.kvq = ((int)(this.kvn / paramFloat1));
        this.kvp = this.kvn;
        AppMethodBeat.o(134104);
        return;
      }
      this.kvp = ((int)(this.kvo * paramFloat1));
      this.kvq = this.kvo;
      AppMethodBeat.o(134104);
      return;
    }
    if (this.kvn > this.kvo)
    {
      this.kvq = ((int)(this.kvn / paramFloat1));
      this.kvp = this.kvn;
      AppMethodBeat.o(134104);
      return;
    }
    this.kvp = ((int)(this.kvo * paramFloat1));
    this.kvq = this.kvo;
    AppMethodBeat.o(134104);
  }
  
  private void bB(float paramFloat)
  {
    if (this.kvn < this.kvo)
    {
      this.kvq = ((int)(this.kvn / paramFloat));
      this.kvp = this.kvn;
      if (this.kvq > this.kvo)
      {
        this.kvp = ((int)(this.kvo * paramFloat));
        this.kvq = this.kvo;
      }
    }
    do
    {
      return;
      this.kvp = ((int)(this.kvo * paramFloat));
      this.kvq = this.kvo;
    } while (this.kvp <= this.kvn);
    this.kvq = ((int)(this.kvn / paramFloat));
    this.kvp = this.kvn;
  }
  
  private void bC(float paramFloat)
  {
    if (this.kvn > this.kvo)
    {
      this.kvq = ((int)(this.kvn / paramFloat));
      this.kvp = this.kvn;
      if (this.kvq < this.kvo)
      {
        this.kvp = ((int)(this.kvo * paramFloat));
        this.kvq = this.kvo;
      }
    }
    do
    {
      return;
      this.kvp = ((int)(this.kvo * paramFloat));
      this.kvq = this.kvo;
    } while (this.kvp >= this.kvn);
    this.kvq = ((int)(this.kvn / paramFloat));
    this.kvp = this.kvn;
  }
  
  private void eAW()
  {
    this.kvq = this.kvo;
    this.kvp = this.kvn;
  }
  
  public final boolean a(h.e parame)
  {
    AppMethodBeat.i(169170);
    if (this.vhJ == parame) {}
    for (int i = 1;; i = 0)
    {
      ad.i("MicroMsg.ViewSizeCache", "set scale type old[%s] new[%s]", new Object[] { this.vhJ, parame });
      this.vhJ = parame;
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
    this.kvo = 0;
    this.kvn = 0;
    this.videoHeight = 0;
    this.videoWidth = 0;
    this.kvq = 0;
    this.kvp = 0;
  }
  
  public final boolean x(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(134103);
    if ((this.kvn == paramInt1) && (this.kvo == paramInt2) && (this.videoWidth == paramInt3) && (this.videoHeight == paramInt4))
    {
      AppMethodBeat.o(134103);
      return true;
    }
    this.kvn = paramInt1;
    this.kvo = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    float f1 = this.videoWidth * 1.0F / this.videoHeight;
    float f2 = this.kvn * 1.0F / this.kvo;
    if (this.vhJ != h.e.BVq) {
      if (this.vhJ == h.e.BVs) {
        bB(f1);
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", new Object[] { Integer.valueOf(this.kvn), Integer.valueOf(this.kvo), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.kvp), Integer.valueOf(this.kvq), Float.valueOf(f2), Float.valueOf(f1) });
      AppMethodBeat.o(134103);
      return false;
      if (this.vhJ == h.e.BVr) {
        eAW();
      } else if (this.vhJ == h.e.BVt) {
        bC(f1);
      } else {
        ac(f1, f2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.u
 * JD-Core Version:    0.7.0.1
 */