package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.g.a.fw;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;

final class f$115
  implements Runnable
{
  f$115(f paramf, WebViewJSSDKFileItem paramWebViewJSSDKFileItem, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(198512);
    fw localfw = new fw();
    localfw.dso.op = 1;
    localfw.dso.fileName = this.EFr.fileName;
    localfw.dso.dcN = true;
    localfw.dso.dsr = new h.a()
    {
      public final void onCompletion()
      {
        AppMethodBeat.i(198510);
        try
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("playResult", "onVoicePlayEnd:ok");
          localBundle.putString("localId", f.115.this.ujI);
          f.k(f.115.this.EEe).g(2002, localBundle);
          AppMethodBeat.o(198510);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.MsgHandler", "notify voice play end failed : %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(198510);
        }
      }
    };
    localfw.dso.dss = new h.b()
    {
      public final void onError()
      {
        AppMethodBeat.i(198511);
        try
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("playResult", "onVoicePlayEnd:fail");
          localBundle.putString("localId", f.115.this.ujI);
          f.k(f.115.this.EEe).g(2002, localBundle);
          AppMethodBeat.o(198511);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.MsgHandler", "notify voice play end failed : %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(198511);
        }
      }
    };
    a.IvT.l(localfw);
    AppMethodBeat.o(198512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.f.115
 * JD-Core Version:    0.7.0.1
 */