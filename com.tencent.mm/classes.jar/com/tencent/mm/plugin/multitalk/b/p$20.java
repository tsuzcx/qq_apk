package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class p$20
  implements IPCRunCgi.a
{
  public p$20(p paramp) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(190599);
    ae.i("MicroMsg.Multitalk.ILinkService", "on invite result: %d, %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wnP.ad(new p.20.1(this, paramInt1, paramInt2, paramb));
    AppMethodBeat.o(190599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.p.20
 * JD-Core Version:    0.7.0.1
 */