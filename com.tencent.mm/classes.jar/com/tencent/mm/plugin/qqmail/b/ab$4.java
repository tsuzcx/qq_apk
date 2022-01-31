package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

final class ab$4
  implements ab.d
{
  ab$4(ab paramab) {}
  
  public final void e(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(68040);
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ShareModeMailAppService", "finishedSendOneFile, currentFileCount: %d, totalFileNum: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.pKx.pKj.put(paramString1, paramString2);
    this.pKx.BX((int)(10.0F + 80.0F * (paramInt1 / paramInt2)));
    AppMethodBeat.o(68040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.ab.4
 * JD-Core Version:    0.7.0.1
 */