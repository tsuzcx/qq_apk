package com.tencent.mm.plugin.soter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nu;
import com.tencent.mm.plugin.soter.d.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;

final class PluginSoter$1$1
  implements g
{
  PluginSoter$1$1(PluginSoter.1 param1) {}
  
  public final void bc(int paramInt, String paramString)
  {
    AppMethodBeat.i(130781);
    ad.i("MicroMsg.PluginSoter", "init finish: %s, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    nu localnu = new nu();
    localnu.dBH.errCode = paramInt;
    localnu.dBH.errMsg = paramString;
    a.IbL.l(localnu);
    AppMethodBeat.o(130781);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.PluginSoter.1.1
 * JD-Core Version:    0.7.0.1
 */