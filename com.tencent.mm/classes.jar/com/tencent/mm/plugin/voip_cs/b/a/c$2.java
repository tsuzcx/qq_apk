package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.mm.sdk.platformtools.y;

final class c$2
  implements com.tencent.mm.plugin.voip.model.a
{
  c$2(c paramc) {}
  
  public final int L(byte[] paramArrayOfByte, int paramInt)
  {
    y.d("MicroMsg.cs.VoipCsAudioManager", "PlayDevDataCallBack,pcm data len:" + paramArrayOfByte.length);
    paramInt = com.tencent.mm.plugin.voip_cs.b.c.bSO().qeL.playCallback(paramArrayOfByte, paramInt);
    if (paramInt != 0) {
      y.d("MicroMsg.cs.VoipCsAudioManager", "PlayDevDataCallBack is failure! pc data:" + paramArrayOfByte.length + ",ret:" + paramInt);
    }
    if (paramInt != 0) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a.c.2
 * JD-Core Version:    0.7.0.1
 */