package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.voip.a.a;

final class m$1
  implements c.a
{
  m$1(m paramm) {}
  
  public final void bS(int paramInt1, int paramInt2) {}
  
  public final void s(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(4436);
    for (;;)
    {
      synchronized (m.m(this.tvV))
      {
        if ((this.tvV.kJF != 2) || (m.a(this.tvV) == null))
        {
          AppMethodBeat.o(4436);
          return;
        }
        if (m.b(this.tvV) == 1)
        {
          m.a(this.tvV, System.currentTimeMillis());
          m.b(this.tvV, m.c(this.tvV));
          m.d(this.tvV);
          if (m.f(this.tvV) <= 10) {
            m.b(this.tvV, 92);
          }
          int i = m.a(this.tvV).cLI();
          m.b(this.tvV, (i + 24 + m.f(this.tvV) * 3) / 4);
          if (m.g(this.tvV) != 1) {
            break label371;
          }
          m.c(this.tvV, m.a(this.tvV).cLF());
          if (m.h(this.tvV) >= m.f(this.tvV)) {
            m.c(this.tvV, m.h(this.tvV) - m.f(this.tvV));
          }
          m.b(this.tvV, m.h(this.tvV));
          m.i(this.tvV);
          if (1 != m.j(this.tvV)) {
            break label383;
          }
          m.k(this.tvV);
          m.c(this.tvV, System.currentTimeMillis());
          a.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,first record");
          this.tvV.ttm.tvj.recordCallback(paramArrayOfByte, paramInt, m.f(this.tvV));
          m.tvT += 1;
        }
      }
      long l1 = System.currentTimeMillis();
      m.a(this.tvV, (int)(l1 - m.e(this.tvV) - m.tvT * 20));
      m.a(this.tvV, l1);
      continue;
      label371:
      m.b(this.tvV, 0);
      continue;
      label383:
      l1 = System.currentTimeMillis();
      long l2 = l1 - m.l(this.tvV);
      if (l2 > 1000L) {
        a.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,error,deltaTime:".concat(String.valueOf(l2)));
      }
      m.c(this.tvV, l1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.m.1
 * JD-Core Version:    0.7.0.1
 */