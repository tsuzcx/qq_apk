package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/model/TopStoryWebViewVisitReporter;", "Lcom/tencent/mm/plugin/webview/model/IWebviewReporter;", "()V", "enterTime", "", "getEnterTime", "()J", "lastResumeTime", "maxScrollY", "", "publishId", "", "scene", "stayTime", "totalScrollY", "onPause", "", "onResume", "report", "setMaxScrollY", "setPublishId", "setScene", "setTotalScrollY", "plugin-webview_release"})
public final class ak
{
  public int LcP;
  public int PVv;
  public final long enterTime;
  public long fOa;
  public long lastResumeTime;
  public String lpD;
  public int scene;
  
  public ak()
  {
    AppMethodBeat.i(268300);
    this.lastResumeTime = -1L;
    this.enterTime = System.currentTimeMillis();
    this.PVv = a.ks(MMApplicationContext.getContext());
    this.LcP = a.ks(MMApplicationContext.getContext());
    AppMethodBeat.o(268300);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "data", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  public static final class a<InputType, ResultType>
    implements d<Bundle, IPCVoid>
  {
    public static final a PVw;
    
    static
    {
      AppMethodBeat.i(263758);
      PVw = new a();
      AppMethodBeat.o(263758);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ak
 * JD-Core Version:    0.7.0.1
 */