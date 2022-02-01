package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.ero;
import com.tencent.mm.sdk.platformtools.Log;

public final class p$5
  implements IPCRunCgi.a
{
  public p$5(p paramp, b paramb) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, d paramd)
  {
    AppMethodBeat.i(239123);
    Log.i("MicroMsg.Multitalk.ILinkService", "on invite result: %d, %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramd.iLL.iLR == null))
    {
      Log.e("MicroMsg.Multitalk.ILinkService", "hy: getsdkmode fail, errType:" + paramInt1 + ",errCode:" + paramInt2);
      AppMethodBeat.o(239123);
      return;
    }
    int i = ((ero)paramd.iLL.iLR).Npg;
    this.zJn.a(paramInt1, paramInt2, paramString, Integer.valueOf(i));
    Log.i("MicroMsg.Multitalk.ILinkService", "checkMultiTalkSDKMode svr sdkmode: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(239123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.p.5
 * JD-Core Version:    0.7.0.1
 */