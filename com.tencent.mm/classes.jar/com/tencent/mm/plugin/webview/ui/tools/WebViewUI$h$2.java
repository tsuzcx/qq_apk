package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

final class WebViewUI$h$2
  implements Runnable
{
  WebViewUI$h$2(WebViewUI.h paramh, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(153262);
    h localh = h.qsU;
    String str = this.vgR;
    int i = this.gKf;
    Object localObject = ah.getContext();
    if (at.isWifi((Context)localObject)) {
      localObject = "wifi";
    }
    for (;;)
    {
      localh.e(17082, new Object[] { str, Integer.valueOf(i), localObject, WebViewUI.h.aiA("mp.weixin.qq.com") });
      AppMethodBeat.o(153262);
      return;
      if (at.is4G((Context)localObject)) {
        localObject = "4g";
      } else if (at.is3G((Context)localObject)) {
        localObject = "3g";
      } else if (at.is2G((Context)localObject)) {
        localObject = "2g";
      } else {
        localObject = "none";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.h.2
 * JD-Core Version:    0.7.0.1
 */