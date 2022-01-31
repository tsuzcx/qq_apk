package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class g$25
  implements w.a
{
  g$25(g paramg, d paramd) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    y.d("MicroMsg.MsgHandler", "onGYNetEnd oreh errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.i("MicroMsg.MsgHandler", "report oreh logbuffer(13927)");
      h.nFQ.f(13927, new Object[] { this.rzF });
      h.nFQ.a(457L, 0L, 1L, false);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.25
 * JD-Core Version:    0.7.0.1
 */