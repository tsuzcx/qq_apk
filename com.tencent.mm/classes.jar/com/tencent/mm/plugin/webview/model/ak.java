package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.aj;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/model/TopStoryWebViewVisitReporter;", "Lcom/tencent/mm/plugin/webview/model/IWebviewReporter;", "()V", "enterTime", "", "getEnterTime", "()J", "lastResumeTime", "maxScrollY", "", "publishId", "", "scene", "stayTime", "totalScrollY", "onPause", "", "onResume", "report", "setMaxScrollY", "setPublishId", "setScene", "setTotalScrollY", "plugin-webview_release"})
public final class ak
{
  public int Aod;
  public int DUd;
  public long dBD;
  public final long enterTime;
  public String hDf;
  public long lastResumeTime;
  public int scene;
  
  public ak()
  {
    AppMethodBeat.i(207587);
    this.lastResumeTime = -1L;
    this.enterTime = System.currentTimeMillis();
    this.DUd = a.iq(aj.getContext());
    this.Aod = a.iq(aj.getContext());
    AppMethodBeat.o(207587);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "data", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class a<InputType, ResultType>
    implements b<Bundle, IPCVoid>
  {
    public static final a DUe;
    
    static
    {
      AppMethodBeat.i(207586);
      DUe = new a();
      AppMethodBeat.o(207586);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ak
 * JD-Core Version:    0.7.0.1
 */