package com.tencent.mm.plugin.webview.l;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"TAG", "", "kvCommand", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvCommand", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "canDebug", "", "showToast", "", "content", "tag", "webview-sdk_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class g
{
  private static final void bnk(String paramString)
  {
    AppMethodBeat.i(295404);
    s.u(paramString, "$content");
    Toast.makeText(MMApplicationContext.getContext(), (CharSequence)paramString, 0).show();
    AppMethodBeat.o(295404);
  }
  
  static final MultiProcessMMKV cTb()
  {
    AppMethodBeat.i(82933);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("__webcompt_command");
    s.s(localMultiProcessMMKV, "getMMKV(\"__webcompt_command\")");
    AppMethodBeat.o(82933);
    return localMultiProcessMMKV;
  }
  
  static final boolean gTR()
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
  
  private static final void showToast(String paramString)
  {
    AppMethodBeat.i(82934);
    if (gTR()) {
      MMHandlerThread.postToMainThread(new g..ExternalSyntheticLambda0(paramString));
    }
    Log.i("WebComptCommand", paramString);
    AppMethodBeat.o(82934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.g
 * JD-Core Version:    0.7.0.1
 */