package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.f.b.c.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.pb.talkroom.sdk.c;

final class d$2
  implements c.a
{
  d$2(d paramd) {}
  
  public final void aU(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.MT.MultiTalkEngine", "OnPcmRecListener onRecError %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public final void r(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt <= 0) {
      y.e("MicroMsg.MT.MultiTalkEngine", "pcm data len <= 0");
    }
    while (this.mtu.mtr == null) {
      return;
    }
    this.mtu.mtr.W(paramArrayOfByte, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.d.2
 * JD-Core Version:    0.7.0.1
 */