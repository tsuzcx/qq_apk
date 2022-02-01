package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/model/WebViewSnsAdReporter;", "Lcom/tencent/mm/plugin/webview/model/IWebviewReporter;", "()V", "errCode", "", "loadReportInfo", "Ljava/util/ArrayList;", "", "snsAdClick", "Lcom/tencent/mm/modelsns/SnsAdClick;", "report", "", "setErrorCode", "setLoadReportInfo", "loadReports", "", "([Ljava/lang/String;)V", "setSnsAdClick", "adClick", "plugin-webview_release"})
public final class au
{
  private final ArrayList<String> Emv;
  public int errCode;
  public SnsAdClick xht;
  
  public au()
  {
    AppMethodBeat.i(199348);
    this.Emv = new ArrayList();
    AppMethodBeat.o(199348);
  }
  
  public final void R(String... paramVarArgs)
  {
    AppMethodBeat.i(199346);
    p.h(paramVarArgs, "loadReports");
    int i = 0;
    while (i < 4)
    {
      String str = paramVarArgs[i];
      this.Emv.add(str);
      i += 1;
    }
    AppMethodBeat.o(199346);
  }
  
  public final void report()
  {
    AppMethodBeat.i(199347);
    for (;;)
    {
      try
      {
        if (((Collection)this.Emv).isEmpty()) {
          continue;
        }
        i = 1;
        if (i != 0)
        {
          Bundle localBundle = new Bundle();
          localBundle.putStringArrayList("reportAdH5Load", new ArrayList((Collection)this.Emv));
          localBundle.putInt("errCode", this.errCode);
          localBundle.putParcelable("snsAdClick", (Parcelable)this.xht);
          h.a("com.tencent.mm", (Parcelable)localBundle, a.Emw.getClass(), null);
        }
      }
      catch (Exception localException)
      {
        int i;
        ae.printErrStackTrace("MicroMsg.WebviewReporter", (Throwable)localException, "", new Object[0]);
        continue;
      }
      this.xht = null;
      this.Emv.clear();
      AppMethodBeat.o(199347);
      return;
      i = 0;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "data", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class a<InputType, ResultType>
    implements b<Bundle, IPCVoid>
  {
    public static final a Emw;
    
    static
    {
      AppMethodBeat.i(199345);
      Emw = new a();
      AppMethodBeat.o(199345);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.au
 * JD-Core Version:    0.7.0.1
 */