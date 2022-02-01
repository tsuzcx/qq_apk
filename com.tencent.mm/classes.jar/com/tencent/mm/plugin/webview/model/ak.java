package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/model/TopStoryWebViewVisitReporter;", "Lcom/tencent/mm/plugin/webview/model/IWebviewReporter;", "()V", "enterTime", "", "getEnterTime", "()J", "lastResumeTime", "maxScrollY", "", "publishId", "", "scene", "stayTime", "totalScrollY", "onPause", "", "onResume", "report", "setMaxScrollY", "setPublishId", "setScene", "setTotalScrollY", "plugin-webview_release"})
public final class ak
{
  public int EOU;
  public int IZc;
  public long dUy;
  public final long enterTime;
  public String iAh;
  public long lastResumeTime;
  public int scene;
  
  public ak()
  {
    AppMethodBeat.i(210353);
    this.lastResumeTime = -1L;
    this.enterTime = System.currentTimeMillis();
    this.IZc = a.jo(MMApplicationContext.getContext());
    this.EOU = a.jo(MMApplicationContext.getContext());
    AppMethodBeat.o(210353);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  public static final class a<InputType, ResultType>
    implements b<Bundle, IPCVoid>
  {
    public static final a IZd;
    
    static
    {
      AppMethodBeat.i(210352);
      IZd = new a();
      AppMethodBeat.o(210352);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ak
 * JD-Core Version:    0.7.0.1
 */