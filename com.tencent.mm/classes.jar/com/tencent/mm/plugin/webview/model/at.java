package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/model/WebViewSnsAdReporter;", "Lcom/tencent/mm/plugin/webview/model/IWebviewReporter;", "()V", "errCode", "", "loadReportInfo", "Ljava/util/ArrayList;", "", "snsAdClick", "Lcom/tencent/mm/modelsns/SnsAdClick;", "report", "", "setErrorCode", "setLoadReportInfo", "loadReports", "", "([Ljava/lang/String;)V", "setSnsAdClick", "adClick", "plugin-webview_release"})
public final class at
{
  private final ArrayList<String> AYF;
  public int errCode;
  public SnsAdClick uBA;
  
  public at()
  {
    AppMethodBeat.i(188888);
    this.AYF = new ArrayList();
    AppMethodBeat.o(188888);
  }
  
  public final void P(String... paramVarArgs)
  {
    AppMethodBeat.i(188886);
    k.h(paramVarArgs, "loadReports");
    int i = 0;
    while (i < 4)
    {
      String str = paramVarArgs[i];
      this.AYF.add(str);
      i += 1;
    }
    AppMethodBeat.o(188886);
  }
  
  public final void report()
  {
    AppMethodBeat.i(188887);
    for (;;)
    {
      try
      {
        if (((Collection)this.AYF).isEmpty()) {
          continue;
        }
        i = 1;
        if (i != 0)
        {
          Bundle localBundle = new Bundle();
          localBundle.putStringArrayList("reportAdH5Load", new ArrayList((Collection)this.AYF));
          localBundle.putInt("errCode", this.errCode);
          localBundle.putParcelable("snsAdClick", (Parcelable)this.uBA);
          h.a("com.tencent.mm", (Parcelable)localBundle, a.AYG.getClass(), null);
        }
      }
      catch (Exception localException)
      {
        int i;
        ad.printErrStackTrace("MicroMsg.WebviewReporter", (Throwable)localException, "", new Object[0]);
        continue;
      }
      this.uBA = null;
      this.AYF.clear();
      AppMethodBeat.o(188887);
      return;
      i = 0;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "data", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class a<InputType, ResultType>
    implements b<Bundle, IPCVoid>
  {
    public static final a AYG;
    
    static
    {
      AppMethodBeat.i(188885);
      AYG = new a();
      AppMethodBeat.o(188885);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.at
 * JD-Core Version:    0.7.0.1
 */