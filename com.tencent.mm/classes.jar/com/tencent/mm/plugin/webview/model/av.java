package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.uh;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/model/WebViewSnsAdReporter;", "Lcom/tencent/mm/plugin/webview/model/IWebviewReporter;", "()V", "errCode", "", "loadReportInfo", "Ljava/util/ArrayList;", "", "snsAdClick", "Lcom/tencent/mm/modelsns/SnsAdClick;", "report", "", "setErrorCode", "setLoadReportInfo", "loadReports", "", "([Ljava/lang/String;)V", "setSnsAdClick", "adClick", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class av
{
  public SnsAdClick MXi;
  private final ArrayList<String> WMt;
  public int errCode;
  
  public av()
  {
    AppMethodBeat.i(298193);
    this.WMt = new ArrayList();
    AppMethodBeat.o(298193);
  }
  
  private static final void h(Bundle paramBundle, f paramf)
  {
    AppMethodBeat.i(298199);
    paramf = paramBundle.getStringArrayList("reportAdH5Load");
    if (paramf != null) {
      if (((Collection)paramf).isEmpty()) {
        break label152;
      }
    }
    label152:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        uh localuh = new uh();
        localuh.hYa.hXZ = ((SnsAdClick)paramBundle.getParcelable("snsAdClick"));
        localuh.hYa.url = aa.aUC((String)paramf.get(0));
        localuh.hYa.hYb = Util.safeParseInt((String)paramf.get(1));
        localuh.hYa.timestamp = Util.safeParseLong((String)paramf.get(2));
        localuh.hYa.uxInfo = ((String)paramf.get(3));
        localuh.hYa.errorCode = paramBundle.getInt("errCode", 0);
        localuh.publish();
      }
      AppMethodBeat.o(298199);
      return;
    }
  }
  
  public final void W(String... paramVarArgs)
  {
    AppMethodBeat.i(298207);
    s.u(paramVarArgs, "loadReports");
    int i = 0;
    while (i < 4)
    {
      String str = paramVarArgs[i];
      i += 1;
      this.WMt.add(str);
    }
    AppMethodBeat.o(298207);
  }
  
  public final void report()
  {
    AppMethodBeat.i(298213);
    for (;;)
    {
      try
      {
        if (((Collection)this.WMt).isEmpty()) {
          continue;
        }
        i = 1;
        if (i != 0)
        {
          Bundle localBundle = new Bundle();
          localBundle.putStringArrayList("reportAdH5Load", new ArrayList((Collection)this.WMt));
          localBundle.putInt("errCode", this.errCode);
          localBundle.putParcelable("snsAdClick", (Parcelable)this.MXi);
          j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localBundle, av..ExternalSyntheticLambda0.INSTANCE.getClass(), null);
        }
      }
      catch (Exception localException)
      {
        int i;
        Log.printErrStackTrace("MicroMsg.WebviewReporter", (Throwable)localException, "", new Object[0]);
        continue;
      }
      this.MXi = null;
      this.WMt.clear();
      AppMethodBeat.o(298213);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.av
 * JD-Core Version:    0.7.0.1
 */