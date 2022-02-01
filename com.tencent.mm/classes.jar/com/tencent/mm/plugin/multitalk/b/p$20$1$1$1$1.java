package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.sdk.platformtools.ae;

final class p$20$1$1$1$1
  implements IPCRunCgi.a
{
  p$20$1$1$1$1(p.20.1.1.1 param1) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(190593);
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramb.hQE.hQJ == null)) {
      ae.e("MicroMsg.Multitalk.ILinkService", "hy: invite fail, errType:" + paramInt1 + ",errCode:" + paramInt2);
    }
    AppMethodBeat.o(190593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.p.20.1.1.1.1
 * JD-Core Version:    0.7.0.1
 */