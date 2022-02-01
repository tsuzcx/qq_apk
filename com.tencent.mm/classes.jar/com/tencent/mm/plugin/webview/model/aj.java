package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.ai;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/model/TopStoryWebViewVisitReporter;", "Lcom/tencent/mm/plugin/webview/model/IWebviewReporter;", "()V", "enterTime", "", "getEnterTime", "()J", "lastResumeTime", "maxScrollY", "", "publishId", "", "scene", "stayTime", "totalScrollY", "onPause", "", "onResume", "report", "setMaxScrollY", "setPublishId", "setScene", "setTotalScrollY", "plugin-webview_release"})
public final class aj
{
  public int CqA;
  public long dpQ;
  public final long enterTime;
  public String hkW;
  public long lastResumeTime;
  public int scene;
  public int yWt;
  
  public aj()
  {
    AppMethodBeat.i(189452);
    this.lastResumeTime = -1L;
    this.enterTime = System.currentTimeMillis();
    this.CqA = a.ih(ai.getContext());
    this.yWt = a.ih(ai.getContext());
    AppMethodBeat.o(189452);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "data", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class a<InputType, ResultType>
    implements b<Bundle, IPCVoid>
  {
    public static final a CqB;
    
    static
    {
      AppMethodBeat.i(189451);
      CqB = new a();
      AppMethodBeat.o(189451);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.aj
 * JD-Core Version:    0.7.0.1
 */