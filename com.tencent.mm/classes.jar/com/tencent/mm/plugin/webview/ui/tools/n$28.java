package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.68;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import java.util.Map;

final class n$28
  implements Runnable
{
  n$28(n paramn, WebViewUI paramWebViewUI, d paramd, String paramString, float paramFloat) {}
  
  public final void run()
  {
    AppMethodBeat.i(7740);
    if ((this.vdo == null) || (this.vdo.isFinishing()))
    {
      AppMethodBeat.o(7740);
      return;
    }
    if (this.vdp != null)
    {
      d locald = this.vdp;
      String str = this.vdK;
      float f = this.vdM;
      HashMap localHashMap = new HashMap();
      localHashMap.put("postId", str);
      localHashMap.put("percent", Float.valueOf(f));
      al.d(new d.68(locald, i.a.b("onPublishHaowanProgress", localHashMap, locald.voB, locald.voC)));
    }
    AppMethodBeat.o(7740);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.28
 * JD-Core Version:    0.7.0.1
 */