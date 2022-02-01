package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.sdk.platformtools.Log;

final class p$19
  implements IPCRunCgi.a
{
  p$19(p paramp) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, d paramd)
  {
    AppMethodBeat.i(239176);
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramd.iLL.iLR == null)) {
      Log.e("MicroMsg.Multitalk.ILinkService", "hy: cgiReportLog fail, errType:" + paramInt1 + ",errCode:" + paramInt2);
    }
    AppMethodBeat.o(239176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.p.19
 * JD-Core Version:    0.7.0.1
 */