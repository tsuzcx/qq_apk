package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class k$2
  implements b.a
{
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(7029);
    ab.i("MicroMsg.WebViewReportOnLeaveHelper", "doReport callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(7029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.k.2
 * JD-Core Version:    0.7.0.1
 */