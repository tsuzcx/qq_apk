package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.sdk.platformtools.y;

public final class p
{
  int gHR;
  int gHS;
  int gHT;
  int gHU;
  h.d oIo = h.d.rZQ;
  boolean snh;
  int videoHeight;
  int videoWidth;
  
  final boolean B(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.gHR == paramInt1) && (this.gHS == paramInt2) && (this.videoWidth == paramInt3) && (this.videoHeight == paramInt4)) {
      return true;
    }
    this.gHR = paramInt1;
    this.gHS = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    float f1 = this.videoWidth * 1.0F / this.videoHeight;
    float f2 = this.gHR * 1.0F / this.gHS;
    if (this.oIo != h.d.rZQ) {
      if (this.oIo == h.d.rZS) {
        if (this.gHR < this.gHS)
        {
          this.gHU = ((int)(this.gHR / f1));
          this.gHT = this.gHR;
          if (this.gHU <= this.gHS) {}
        }
      }
    }
    label642:
    for (;;)
    {
      p localp = this;
      localp.gHT = ((int)(localp.gHS * f1));
      localp.gHU = localp.gHS;
      for (;;)
      {
        y.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", new Object[] { Integer.valueOf(this.gHR), Integer.valueOf(this.gHS), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.gHT), Integer.valueOf(this.gHU), Float.valueOf(f2), Float.valueOf(f1) });
        return false;
        this.gHT = ((int)(this.gHS * f1));
        this.gHU = this.gHS;
        if (this.gHT > this.gHR)
        {
          this.gHU = ((int)(this.gHR / f1));
          this.gHT = this.gHR;
          continue;
          if (this.oIo == h.d.rZR)
          {
            this.gHU = this.gHS;
            this.gHT = this.gHR;
          }
          else
          {
            if (this.oIo == h.d.rZT)
            {
              if (this.gHR > this.gHS)
              {
                this.gHU = ((int)(this.gHR / f1));
                this.gHT = this.gHR;
                if (this.gHU >= this.gHS) {
                  continue;
                }
                break;
              }
              this.gHT = ((int)(this.gHS * f1));
              this.gHU = this.gHS;
              if (this.gHT >= this.gHR) {
                continue;
              }
              this.gHU = ((int)(this.gHR / f1));
              this.gHT = this.gHR;
              continue;
            }
            if (!this.snh)
            {
              if (this.gHR < this.gHS)
              {
                this.gHU = ((int)(this.gHR / f1));
                this.gHT = this.gHR;
              }
              else
              {
                this.gHT = ((int)(this.gHS * f1));
                this.gHU = this.gHS;
              }
            }
            else if (Math.abs(f1 - f2) > 0.05D)
            {
              if (this.gHR < this.gHS)
              {
                this.gHU = ((int)(this.gHR / f1));
                this.gHT = this.gHR;
              }
              else
              {
                this.gHT = ((int)(this.gHS * f1));
                this.gHU = this.gHS;
              }
            }
            else
            {
              if (this.gHR <= this.gHS) {
                break label642;
              }
              this.gHU = ((int)(this.gHR / f1));
              this.gHT = this.gHR;
            }
          }
        }
      }
    }
  }
  
  final void reset()
  {
    this.gHS = 0;
    this.gHR = 0;
    this.videoHeight = 0;
    this.videoWidth = 0;
    this.gHU = 0;
    this.gHT = 0;
  }
  
  final void setScaleType(h.d paramd)
  {
    y.i("MicroMsg.ViewSizeCache", "set scale type old[%s] new[%s]", new Object[] { this.oIo, paramd });
    this.oIo = paramd;
    reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.p
 * JD-Core Version:    0.7.0.1
 */