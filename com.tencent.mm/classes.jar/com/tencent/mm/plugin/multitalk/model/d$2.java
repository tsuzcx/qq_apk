package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.pb.talkroom.sdk.c;

final class d$2
  implements c.a
{
  d$2(d paramd) {}
  
  public final void bS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(53906);
    ab.i("MicroMsg.MT.MultiTalkEngine", "OnPcmRecListener onRecError %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(53906);
  }
  
  public final void s(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(53905);
    if (paramInt <= 0)
    {
      ab.e("MicroMsg.MT.MultiTalkEngine", "pcm data len <= 0");
      AppMethodBeat.o(53905);
      return;
    }
    if (this.oTf.oTc != null) {
      this.oTf.oTc.X(paramArrayOfByte, paramInt);
    }
    AppMethodBeat.o(53905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.d.2
 * JD-Core Version:    0.7.0.1
 */