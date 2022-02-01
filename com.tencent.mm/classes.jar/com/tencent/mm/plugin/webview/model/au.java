package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/model/WebViewSnsAdReporter;", "Lcom/tencent/mm/plugin/webview/model/IWebviewReporter;", "()V", "errCode", "", "loadReportInfo", "Ljava/util/ArrayList;", "", "snsAdClick", "Lcom/tencent/mm/modelsns/SnsAdClick;", "report", "", "setErrorCode", "setLoadReportInfo", "loadReports", "", "([Ljava/lang/String;)V", "setSnsAdClick", "adClick", "plugin-webview_release"})
public final class au
{
  private final ArrayList<String> DUw;
  public int errCode;
  public SnsAdClick wRC;
  
  public au()
  {
    AppMethodBeat.i(207592);
    this.DUw = new ArrayList();
    AppMethodBeat.o(207592);
  }
  
  public final void R(String... paramVarArgs)
  {
    AppMethodBeat.i(207590);
    p.h(paramVarArgs, "loadReports");
    int i = 0;
    while (i < 4)
    {
      String str = paramVarArgs[i];
      this.DUw.add(str);
      i += 1;
    }
    AppMethodBeat.o(207590);
  }
  
  public final void report()
  {
    AppMethodBeat.i(207591);
    for (;;)
    {
      try
      {
        if (((Collection)this.DUw).isEmpty()) {
          continue;
        }
        i = 1;
        if (i != 0)
        {
          Bundle localBundle = new Bundle();
          localBundle.putStringArrayList("reportAdH5Load", new ArrayList((Collection)this.DUw));
          localBundle.putInt("errCode", this.errCode);
          localBundle.putParcelable("snsAdClick", (Parcelable)this.wRC);
          h.a("com.tencent.mm", (Parcelable)localBundle, a.DUx.getClass(), null);
        }
      }
      catch (Exception localException)
      {
        int i;
        ad.printErrStackTrace("MicroMsg.WebviewReporter", (Throwable)localException, "", new Object[0]);
        continue;
      }
      this.wRC = null;
      this.DUw.clear();
      AppMethodBeat.o(207591);
      return;
      i = 0;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "data", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class a<InputType, ResultType>
    implements b<Bundle, IPCVoid>
  {
    public static final a DUx;
    
    static
    {
      AppMethodBeat.i(207589);
      DUx = new a();
      AppMethodBeat.o(207589);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.au
 * JD-Core Version:    0.7.0.1
 */