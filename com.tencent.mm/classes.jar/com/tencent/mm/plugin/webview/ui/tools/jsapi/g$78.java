package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.mm.h.a.fl;
import com.tencent.mm.h.a.fl.b;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class g$78
  implements Runnable
{
  g$78(g paramg, WebViewJSSDKFileItem paramWebViewJSSDKFileItem, i parami) {}
  
  public final void run()
  {
    final fl localfl = new fl();
    localfl.bMj.op = 1;
    localfl.bMj.filePath = this.rAi.fMZ;
    localfl.bMj.duration = bk.getInt((String)this.rzk.ndL.get("duration"), 60);
    localfl.bMj.byV = new Runnable()
    {
      public final void run()
      {
        y.i("MicroMsg.MsgHandler", "onVoiceRecordEnd, localId(%s).", new Object[] { g.78.this.rAi.bMB });
        for (;;)
        {
          try
          {
            g.C(g.78.this.rzi);
            localBundle = new Bundle();
            localBundle.putString("localId", g.78.this.rAi.bMB);
            localStringBuilder = new StringBuilder("onVoiceRecordEnd:");
            if (localfl.bMk.bMl != 2) {
              break label165;
            }
            if (localfl.bMk.bMl != 3) {
              break label171;
            }
          }
          catch (Exception localException)
          {
            Bundle localBundle;
            StringBuilder localStringBuilder;
            String str1;
            y.e("MicroMsg.MsgHandler", "callback stop record failed");
            return;
          }
          localBundle.putString("recordResult", str1);
          if (g.D(g.78.this.rzi) != null)
          {
            g.D(g.78.this.rzi).b(2008, localBundle);
            return;
          }
          y.e("MicroMsg.MsgHandler", "callbacker is null");
          return;
          label165:
          String str2 = "ok";
          continue;
          label171:
          str2 = "fail";
        }
      }
    };
    a.udP.m(localfl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.78
 * JD-Core Version:    0.7.0.1
 */