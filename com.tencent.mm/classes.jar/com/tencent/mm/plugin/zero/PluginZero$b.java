package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.cm.a;
import com.tencent.mm.plugin.zero.a.c;

public final class PluginZero$b
  extends a<c>
  implements c
{
  public final void a(NotifyReceiver.NotifyService paramNotifyService, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong)
  {
    AppMethodBeat.i(58761);
    a(new PluginZero.b.1(this, paramNotifyService, paramInt, paramArrayOfByte1, paramArrayOfByte2, paramLong));
    AppMethodBeat.o(58761);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.PluginZero.b
 * JD-Core Version:    0.7.0.1
 */