package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.mm.f.b.c.a;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  implements c.a
{
  c$1(c paramc) {}
  
  public final void aU(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.cs.VoipCsAudioManager", "OnPcmRecListener onRecError %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public final void r(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt <= 0)
    {
      y.e("MicroMsg.cs.VoipCsAudioManager", "pcm data len <= 0");
      return;
    }
    y.d("MicroMsg.cs.VoipCsAudioManager", "onRecPcmDataReady,pcm data len:" + paramArrayOfByte.length);
    paramInt = com.tencent.mm.plugin.voip_cs.b.c.bSO().qeL.recordCallback(paramArrayOfByte, paramInt, 200);
    y.d("MicroMsg.cs.VoipCsAudioManager", "recordCallback,ret:" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a.c.1
 * JD-Core Version:    0.7.0.1
 */