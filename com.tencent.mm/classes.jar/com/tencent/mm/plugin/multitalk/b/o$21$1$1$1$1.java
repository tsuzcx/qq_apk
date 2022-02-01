package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.sdk.platformtools.Log;

final class o$21$1$1$1$1
  implements IPCRunCgi.a
{
  o$21$1$1$1$1(o.21.1.1.1 param1) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, d paramd)
  {
    AppMethodBeat.i(200254);
    if ((paramInt1 != 0) || (paramInt2 != 0) || (d.c.b(paramd.lBS) == null)) {
      Log.e("MicroMsg.Multitalk.ILinkService", "hy: invite fail, errType:" + paramInt1 + ",errCode:" + paramInt2);
    }
    AppMethodBeat.o(200254);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.o.21.1.1.1.1
 * JD-Core Version:    0.7.0.1
 */