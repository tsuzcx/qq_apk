package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.voip.a.a;

final class m$2
  implements b
{
  m$2(m paramm) {}
  
  public final int M(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(4437);
    if (this.tvV.kJF != 2)
    {
      AppMethodBeat.o(4437);
      return -1;
    }
    if (1 == m.n(this.tvV))
    {
      m.o(this.tvV);
      m.d(this.tvV, System.currentTimeMillis());
      a.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,first play");
    }
    for (;;)
    {
      paramInt = this.tvV.ttm.tvj.playCallback(paramArrayOfByte, paramInt);
      if (paramInt >= 0) {
        break;
      }
      a.Loge("MicroMsg.Voip.VoipDeviceHandler", g.Ml() + "protocal.playcallback ret:" + paramInt);
      AppMethodBeat.o(4437);
      return -1;
      long l1 = System.currentTimeMillis();
      long l2 = l1 - m.p(this.tvV);
      if (l2 > 1000L) {
        a.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,error,deltaTime:".concat(String.valueOf(l2)));
      }
      m.d(this.tvV, l1);
    }
    m.tvS += 1;
    AppMethodBeat.o(4437);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.m.2
 * JD-Core Version:    0.7.0.1
 */