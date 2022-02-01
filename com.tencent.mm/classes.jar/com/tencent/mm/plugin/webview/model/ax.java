package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/model/WebViewVisitReporter;", "Lcom/tencent/mm/plugin/webview/model/IWebviewReporter;", "()V", "appId", "", "chattype", "", "desc", "enterTime", "", "expidstr", "hasShowKeyboard", "lastResumeTime", "mPreUsername", "mPreviousUrl", "messageId", "messageIndex", "newMsgId", "publishId", "publisher", "rawUrl", "scene", "statExtStr", "stayTime", "title", "username", "viewID", "onPause", "", "onResume", "report", "setAppId", "setChattype", "setDesc", "setExpidstr", "setHasShowKeyboard", "showKeyboard", "", "setMessageId", "setMessageIndex", "setPreUsername", "setPreviousUrl", "url", "setPublishId", "setPublisher", "setRawUrl", "setScene", "setStatExtStr", "setTitle", "setUserName", "setViewID", "plugin-webview_release"})
public final class ax
{
  public String ISp;
  public String IZB;
  public long IZC;
  public int IZD;
  public String IZE;
  public String IZF;
  public String IZG;
  public int IZH;
  public int IZI;
  public String appId;
  public long dUy;
  public String desc;
  public String edo;
  final long enterTime;
  public String fRa;
  public String iAh;
  public long lastResumeTime;
  public int scene;
  public String statExtStr;
  public String title;
  public String username;
  
  public ax()
  {
    AppMethodBeat.i(210368);
    this.title = "";
    this.desc = "";
    this.lastResumeTime = -1L;
    this.enterTime = (System.currentTimeMillis() / 1000L);
    AppMethodBeat.o(210368);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "invoke"})
  public static final class a<InputType, ResultType>
    implements b<IPCVoid, IPCString>
  {
    public static final a IZJ;
    
    static
    {
      AppMethodBeat.i(210366);
      IZJ = new a();
      AppMethodBeat.o(210366);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "curUsername", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "onCallback"})
  public static final class b<T>
    implements d<ResultType>
  {
    public b(ax paramax) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ax
 * JD-Core Version:    0.7.0.1
 */