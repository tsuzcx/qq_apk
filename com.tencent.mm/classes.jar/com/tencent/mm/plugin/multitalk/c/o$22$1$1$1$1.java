package com.tencent.mm.plugin.multitalk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.sdk.platformtools.Log;

final class o$22$1$1$1$1
  implements IPCRunCgi.a
{
  o$22$1$1$1$1(o.22.1.1.1 param1) {}
  
  public final void callback(int paramInt1, int paramInt2, String paramString, c paramc)
  {
    AppMethodBeat.i(284992);
    if ((paramInt1 != 0) || (paramInt2 != 0) || (c.c.b(paramc.otC) == null)) {
      Log.e("MicroMsg.Multitalk.ILinkService", "hy: invite fail, errType:" + paramInt1 + ",errCode:" + paramInt2);
    }
    AppMethodBeat.o(284992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.c.o.22.1.1.1.1
 * JD-Core Version:    0.7.0.1
 */