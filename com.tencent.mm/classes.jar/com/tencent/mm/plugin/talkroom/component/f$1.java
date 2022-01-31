package com.tencent.mm.plugin.talkroom.component;

import com.tencent.mm.f.b.c.a;
import com.tencent.mm.sdk.platformtools.y;

final class f$1
  implements c.a
{
  f$1(f paramf) {}
  
  public final void aU(int paramInt1, int paramInt2) {}
  
  public final void r(byte[] paramArrayOfByte, int paramInt)
  {
    y.d("MicroMsg.MicRecoder", "pcm len: " + paramInt);
    if (paramInt <= 0) {
      y.e("MicroMsg.MicRecoder", "pcm data too low");
    }
    do
    {
      return;
      f.a(this.pzM, paramArrayOfByte, paramInt);
      paramInt = f.a(this.pzM).Send(paramArrayOfByte, (short)paramInt);
    } while (paramInt >= 0);
    y.e("MicroMsg.MicRecoder", "send failed, ret: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.f.1
 * JD-Core Version:    0.7.0.1
 */