package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/model/TopStoryWebViewVisitReporter;", "Lcom/tencent/mm/plugin/webview/model/IWebviewReporter;", "()V", "enterTime", "", "getEnterTime", "()J", "lastResumeTime", "maxScrollY", "", "publishId", "", "scene", "stayTime", "totalScrollY", "onPause", "", "onResume", "report", "setMaxScrollY", "setPublishId", "setScene", "setTotalScrollY", "plugin-webview_release"})
public final class ak
{
  public int AFq;
  public int Emc;
  public long dCI;
  public final long enterTime;
  public String hFX;
  public long lastResumeTime;
  public int scene;
  
  public ak()
  {
    AppMethodBeat.i(199343);
    this.lastResumeTime = -1L;
    this.enterTime = System.currentTimeMillis();
    this.Emc = a.iv(com.tencent.mm.sdk.platformtools.ak.getContext());
    this.AFq = a.iv(com.tencent.mm.sdk.platformtools.ak.getContext());
    AppMethodBeat.o(199343);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "data", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class a<InputType, ResultType>
    implements b<Bundle, IPCVoid>
  {
    public static final a Emd;
    
    static
    {
      AppMethodBeat.i(199342);
      Emd = new a();
      AppMethodBeat.o(199342);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ak
 * JD-Core Version:    0.7.0.1
 */