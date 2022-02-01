package com.tencent.mm.plugin.webview.l;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"TAG", "", "kvCommand", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvCommand", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "canDebug", "", "showToast", "", "content", "tag", "webview-sdk_release"})
public final class h
{
  static final MultiProcessMMKV cqu()
  {
    AppMethodBeat.i(82933);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("__webcompt_command");
    p.j(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV(\"__webcompt_command\")");
    AppMethodBeat.o(82933);
    return localMultiProcessMMKV;
  }
  
  static final boolean gSI()
  {
    AppMethodBeat.i(82935);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || ((Log.getLogLevel() == 0) && (WeChatEnvironment.hasDebugger())))
    {
      AppMethodBeat.o(82935);
      return true;
    }
    AppMethodBeat.o(82935);
    return false;
  }
  
  static final void showToast(String paramString)
  {
    AppMethodBeat.i(82934);
    if (gSI()) {
      MMHandlerThread.postToMainThread((Runnable)new a(paramString));
    }
    Log.i("WebComptCommand", paramString);
    AppMethodBeat.o(82934);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(82932);
      Toast.makeText(MMApplicationContext.getContext(), (CharSequence)this.iVV, 0).show();
      AppMethodBeat.o(82932);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.h
 * JD-Core Version:    0.7.0.1
 */