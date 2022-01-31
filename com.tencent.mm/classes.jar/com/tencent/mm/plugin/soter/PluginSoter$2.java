package com.tencent.mm.plugin.soter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.auth.a.a;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;

final class PluginSoter$2
  implements a
{
  PluginSoter$2(PluginSoter paramPluginSoter) {}
  
  public final void a(j.h paramh, j.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(59289);
    ab.i("MicroMsg.PluginSoter", "autoAuth: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    d.ysm.execute(new PluginSoter.2.1(this));
    AppMethodBeat.o(59289);
  }
  
  public final void a(v.b paramb, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.PluginSoter.2
 * JD-Core Version:    0.7.0.1
 */