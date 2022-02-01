package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.h.a;
import com.tencent.mm.al.h.b;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;

final class f$115
  implements Runnable
{
  f$115(f paramf, WebViewJSSDKFileItem paramWebViewJSSDKFileItem, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(208330);
    fv localfv = new fv();
    localfv.drj.op = 1;
    localfv.drj.fileName = this.Enn.fileName;
    localfv.drj.dbL = true;
    localfv.drj.drm = new h.a()
    {
      public final void onCompletion()
      {
        AppMethodBeat.i(208328);
        try
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("playResult", "onVoicePlayEnd:ok");
          localBundle.putString("localId", f.115.this.tYG);
          f.k(f.115.this.Ema).g(2002, localBundle);
          AppMethodBeat.o(208328);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.MsgHandler", "notify voice play end failed : %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(208328);
        }
      }
    };
    localfv.drj.drn = new h.b()
    {
      public final void onError()
      {
        AppMethodBeat.i(208329);
        try
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("playResult", "onVoicePlayEnd:fail");
          localBundle.putString("localId", f.115.this.tYG);
          f.k(f.115.this.Ema).g(2002, localBundle);
          AppMethodBeat.o(208329);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.MsgHandler", "notify voice play end failed : %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(208329);
        }
      }
    };
    a.IbL.l(localfv);
    AppMethodBeat.o(208330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.f.115
 * JD-Core Version:    0.7.0.1
 */