package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/model/WebViewSnsAdReporter;", "Lcom/tencent/mm/plugin/webview/model/IWebviewReporter;", "()V", "errCode", "", "loadReportInfo", "Ljava/util/ArrayList;", "", "snsAdClick", "Lcom/tencent/mm/modelsns/SnsAdClick;", "report", "", "setErrorCode", "setLoadReportInfo", "loadReports", "", "([Ljava/lang/String;)V", "setSnsAdClick", "adClick", "plugin-webview_release"})
public final class au
{
  public SnsAdClick Bfh;
  private final ArrayList<String> IZv;
  public int errCode;
  
  public au()
  {
    AppMethodBeat.i(210358);
    this.IZv = new ArrayList();
    AppMethodBeat.o(210358);
  }
  
  public final void U(String... paramVarArgs)
  {
    AppMethodBeat.i(210356);
    p.h(paramVarArgs, "loadReports");
    int i = 0;
    while (i < 4)
    {
      String str = paramVarArgs[i];
      this.IZv.add(str);
      i += 1;
    }
    AppMethodBeat.o(210356);
  }
  
  public final void report()
  {
    AppMethodBeat.i(210357);
    for (;;)
    {
      try
      {
        if (((Collection)this.IZv).isEmpty()) {
          continue;
        }
        i = 1;
        if (i != 0)
        {
          Bundle localBundle = new Bundle();
          localBundle.putStringArrayList("reportAdH5Load", new ArrayList((Collection)this.IZv));
          localBundle.putInt("errCode", this.errCode);
          localBundle.putParcelable("snsAdClick", (Parcelable)this.Bfh);
          h.a(MainProcessIPCService.dkO, (Parcelable)localBundle, a.IZw.getClass(), null);
        }
      }
      catch (Exception localException)
      {
        int i;
        Log.printErrStackTrace("MicroMsg.WebviewReporter", (Throwable)localException, "", new Object[0]);
        continue;
      }
      this.Bfh = null;
      this.IZv.clear();
      AppMethodBeat.o(210357);
      return;
      i = 0;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class a<InputType, ResultType>
    implements b<Bundle, IPCVoid>
  {
    public static final a IZw;
    
    static
    {
      AppMethodBeat.i(210355);
      IZw = new a();
      AppMethodBeat.o(210355);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.au
 * JD-Core Version:    0.7.0.1
 */