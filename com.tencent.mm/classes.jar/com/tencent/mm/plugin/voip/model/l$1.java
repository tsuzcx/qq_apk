package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.f.b.c.a;
import com.tencent.mm.plugin.voip.a.a;

final class l$1
  implements c.a
{
  l$1(l paraml) {}
  
  public final void aU(int paramInt1, int paramInt2) {}
  
  public final void r(byte[] paramArrayOfByte, int paramInt)
  {
    for (;;)
    {
      synchronized (l.m(this.pQR))
      {
        if ((this.pQR.iEu != 2) || (l.a(this.pQR) == null)) {
          return;
        }
        if (l.b(this.pQR) == 1)
        {
          l.a(this.pQR, System.currentTimeMillis());
          l.b(this.pQR, l.c(this.pQR));
          l.d(this.pQR);
          if (l.f(this.pQR) <= 10) {
            l.b(this.pQR, 92);
          }
          int i = l.a(this.pQR).bPE();
          l.b(this.pQR, (i + 24 + l.f(this.pQR) * 3) / 4);
          if (l.g(this.pQR) != 1) {
            break label353;
          }
          l.c(this.pQR, l.a(this.pQR).bPB());
          if (l.h(this.pQR) >= l.f(this.pQR)) {
            l.c(this.pQR, l.h(this.pQR) - l.f(this.pQR));
          }
          l.b(this.pQR, l.h(this.pQR));
          l.i(this.pQR);
          if (1 != l.j(this.pQR)) {
            break label365;
          }
          l.k(this.pQR);
          l.c(this.pQR, System.currentTimeMillis());
          a.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,first record");
          this.pQR.pNq.pQe.recordCallback(paramArrayOfByte, paramInt, l.f(this.pQR));
          l.pQP += 1;
        }
      }
      long l1 = System.currentTimeMillis();
      l.a(this.pQR, (int)(l1 - l.e(this.pQR) - l.pQP * 20));
      l.a(this.pQR, l1);
      continue;
      label353:
      l.b(this.pQR, 0);
      continue;
      label365:
      l1 = System.currentTimeMillis();
      long l2 = l1 - l.l(this.pQR);
      if (l2 > 1000L) {
        a.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,error,deltaTime:" + l2);
      }
      l.c(this.pQR, l1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.l.1
 * JD-Core Version:    0.7.0.1
 */