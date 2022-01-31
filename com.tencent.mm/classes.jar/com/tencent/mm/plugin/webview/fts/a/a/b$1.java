package com.tencent.mm.plugin.webview.fts.a.a;

import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.protocal.c.ana;
import com.tencent.mm.sdk.platformtools.y;

public final class b$1
  implements w.a
{
  public b$1(b paramb) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.b paramb, m paramm)
  {
    y.i("WidgetPkgPreDownloadMgr", "cgi back errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      b.a(this.raf, ((ana)paramb.ecF.ecN).dTx);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a.a.b.1
 * JD-Core Version:    0.7.0.1
 */