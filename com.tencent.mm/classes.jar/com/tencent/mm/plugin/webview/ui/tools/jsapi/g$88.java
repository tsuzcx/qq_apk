package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.g.a.fo.b;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

final class g$88
  implements Runnable
{
  g$88(g paramg, WebViewJSSDKFileItem paramWebViewJSSDKFileItem, i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(155009);
    final fo localfo = new fo();
    localfo.ctE.op = 1;
    localfo.ctE.filePath = this.vrl.hgj;
    localfo.ctE.duration = bo.getInt((String)this.uZa.pJb.get("duration"), 60);
    localfo.ctE.caX = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(155008);
        ab.i("MicroMsg.MsgHandler", "onVoiceRecordEnd, localId(%s).", new Object[] { g.88.this.vrl.ctV });
        for (;;)
        {
          try
          {
            g.H(g.88.this.vqm);
            localBundle = new Bundle();
            localBundle.putString("localId", g.88.this.vrl.ctV);
            localStringBuilder = new StringBuilder("onVoiceRecordEnd:");
            if (localfo.ctF.ctG != 2) {
              break label185;
            }
            if (localfo.ctF.ctG != 3) {
              break label191;
            }
          }
          catch (Exception localException)
          {
            Bundle localBundle;
            StringBuilder localStringBuilder;
            String str1;
            ab.e("MicroMsg.MsgHandler", "callback stop record failed");
            AppMethodBeat.o(155008);
            return;
          }
          localBundle.putString("recordResult", str1);
          if (g.l(g.88.this.vqm) != null)
          {
            g.l(g.88.this.vqm).e(2008, localBundle);
            AppMethodBeat.o(155008);
            return;
          }
          ab.e("MicroMsg.MsgHandler", "callbacker is null");
          AppMethodBeat.o(155008);
          return;
          label185:
          String str2 = "ok";
          continue;
          label191:
          str2 = "fail";
        }
      }
    };
    a.ymk.l(localfo);
    AppMethodBeat.o(155009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.88
 * JD-Core Version:    0.7.0.1
 */