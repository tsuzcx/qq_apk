package com.tencent.mm.plugin.talkroom.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.sdk.platformtools.ab;

final class f$1
  implements c.a
{
  f$1(f paramf) {}
  
  public final void bS(int paramInt1, int paramInt2) {}
  
  public final void s(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(25713);
    ab.d("MicroMsg.MicRecoder", "pcm len: ".concat(String.valueOf(paramInt)));
    if (paramInt <= 0)
    {
      ab.e("MicroMsg.MicRecoder", "pcm data too low");
      AppMethodBeat.o(25713);
      return;
    }
    f.a(this.tby, paramArrayOfByte, paramInt);
    paramInt = f.a(this.tby).Send(paramArrayOfByte, (short)paramInt);
    if (paramInt < 0)
    {
      ab.e("MicroMsg.MicRecoder", "send failed, ret: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(25713);
      return;
    }
    AppMethodBeat.o(25713);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.f.1
 * JD-Core Version:    0.7.0.1
 */