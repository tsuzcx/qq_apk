package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.g;
import java.util.Map;

final class j$1
  implements g
{
  j$1(String paramString) {}
  
  public final void bD(int paramInt, String paramString)
  {
    AppMethodBeat.i(153158);
    ab.i("MicroMsg.WebViewPreviewImgHelper", "onFinishImageBitmapToFile result %d", new Object[] { Integer.valueOf(paramInt) });
    h localh;
    if (j.access$000())
    {
      localh = h.qsU;
      if (paramInt != 0) {
        break label61;
      }
    }
    label61:
    for (long l = 0L;; l = 1L)
    {
      localh.idkeyStat(1059L, l, 1L, false);
      if (paramInt == 0) {
        break;
      }
      AppMethodBeat.o(153158);
      return;
    }
    j.ajx().put(this.uNP, paramString);
    AppMethodBeat.o(153158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.j.1
 * JD-Core Version:    0.7.0.1
 */