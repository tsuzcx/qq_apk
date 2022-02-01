package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/model/WebViewSnsAdReporter;", "Lcom/tencent/mm/plugin/webview/model/IWebviewReporter;", "()V", "errCode", "", "loadReportInfo", "Ljava/util/ArrayList;", "", "snsAdClick", "Lcom/tencent/mm/modelsns/SnsAdClick;", "report", "", "setErrorCode", "setLoadReportInfo", "loadReports", "", "([Ljava/lang/String;)V", "setSnsAdClick", "adClick", "plugin-webview_release"})
public final class at
{
  private final ArrayList<String> CqS;
  public int errCode;
  public SnsAdClick vKt;
  
  public at()
  {
    AppMethodBeat.i(189457);
    this.CqS = new ArrayList();
    AppMethodBeat.o(189457);
  }
  
  public final void P(String... paramVarArgs)
  {
    AppMethodBeat.i(189455);
    k.h(paramVarArgs, "loadReports");
    int i = 0;
    while (i < 4)
    {
      String str = paramVarArgs[i];
      this.CqS.add(str);
      i += 1;
    }
    AppMethodBeat.o(189455);
  }
  
  public final void report()
  {
    AppMethodBeat.i(189456);
    for (;;)
    {
      try
      {
        if (((Collection)this.CqS).isEmpty()) {
          continue;
        }
        i = 1;
        if (i != 0)
        {
          Bundle localBundle = new Bundle();
          localBundle.putStringArrayList("reportAdH5Load", new ArrayList((Collection)this.CqS));
          localBundle.putInt("errCode", this.errCode);
          localBundle.putParcelable("snsAdClick", (Parcelable)this.vKt);
          h.a("com.tencent.mm", (Parcelable)localBundle, a.CqT.getClass(), null);
        }
      }
      catch (Exception localException)
      {
        int i;
        ac.printErrStackTrace("MicroMsg.WebviewReporter", (Throwable)localException, "", new Object[0]);
        continue;
      }
      this.vKt = null;
      this.CqS.clear();
      AppMethodBeat.o(189456);
      return;
      i = 0;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "data", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class a<InputType, ResultType>
    implements b<Bundle, IPCVoid>
  {
    public static final a CqT;
    
    static
    {
      AppMethodBeat.i(189454);
      CqT = new a();
      AppMethodBeat.o(189454);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.at
 * JD-Core Version:    0.7.0.1
 */