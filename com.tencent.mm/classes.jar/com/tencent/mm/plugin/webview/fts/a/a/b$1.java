package com.tencent.mm.plugin.webview.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.protocal.protobuf.asp;
import com.tencent.mm.sdk.platformtools.ab;

public final class b$1
  implements w.a
{
  public b$1(b paramb) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb, m paramm)
  {
    AppMethodBeat.i(5765);
    ab.i("WidgetPkgPreDownloadMgr", "cgi back errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      b.a(this.uPN, ((asp)paramb.fsW.fta).fjy);
    }
    AppMethodBeat.o(5765);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a.a.b.1
 * JD-Core Version:    0.7.0.1
 */