package com.tencent.mm.plugin.soter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lr;
import com.tencent.mm.plugin.soter.d.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class PluginSoter$1$1
  implements g
{
  PluginSoter$1$1(PluginSoter.1 param1) {}
  
  public final void aC(int paramInt, String paramString)
  {
    AppMethodBeat.i(59286);
    ab.i("MicroMsg.PluginSoter", "init finish: %s, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    lr locallr = new lr();
    locallr.cBK.errCode = paramInt;
    locallr.cBK.errMsg = paramString;
    a.ymk.l(locallr);
    AppMethodBeat.o(59286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.PluginSoter.1.1
 * JD-Core Version:    0.7.0.1
 */