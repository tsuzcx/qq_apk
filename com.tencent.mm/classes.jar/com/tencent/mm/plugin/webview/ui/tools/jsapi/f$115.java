package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.k.a;
import com.tencent.mm.ak.k.b;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

final class f$115
  implements Runnable
{
  f$115(f paramf, WebViewJSSDKFileItem paramWebViewJSSDKFileItem, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(211423);
    fz localfz = new fz();
    localfz.dJA.op = 1;
    localfz.dJA.fileName = this.JuX.fileName;
    localfz.dJA.dtE = true;
    localfz.dJA.dJD = new k.a()
    {
      public final void onCompletion()
      {
        AppMethodBeat.i(211421);
        try
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("playResult", "onVoicePlayEnd:ok");
          localBundle.putString("localId", f.115.this.xCb);
          f.k(f.115.this.JtL).f(2002, localBundle);
          AppMethodBeat.o(211421);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.MsgHandler", "notify voice play end failed : %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(211421);
        }
      }
    };
    localfz.dJA.dJE = new k.b()
    {
      public final void onError()
      {
        AppMethodBeat.i(211422);
        try
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("playResult", "onVoicePlayEnd:fail");
          localBundle.putString("localId", f.115.this.xCb);
          f.k(f.115.this.JtL).f(2002, localBundle);
          AppMethodBeat.o(211422);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.MsgHandler", "notify voice play end failed : %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(211422);
        }
      }
    };
    EventCenter.instance.publish(localfz);
    AppMethodBeat.o(211423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.f.115
 * JD-Core Version:    0.7.0.1
 */