package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/model/WebViewVisitReporter;", "Lcom/tencent/mm/plugin/webview/model/IWebviewReporter;", "()V", "appId", "", "chattype", "", "desc", "enterTime", "", "expidstr", "hasShowKeyboard", "lastResumeTime", "mPreUsername", "mPreviousUrl", "messageId", "messageIndex", "newMsgId", "publishId", "publisher", "rawUrl", "scene", "statExtStr", "stayTime", "title", "username", "viewID", "onPause", "", "onResume", "report", "setAppId", "setChattype", "setDesc", "setExpidstr", "setHasShowKeyboard", "showKeyboard", "", "setMessageId", "setMessageIndex", "setPreUsername", "setPreviousUrl", "url", "setPublishId", "setPublisher", "setRawUrl", "setScene", "setStatExtStr", "setTitle", "setUserName", "setViewID", "plugin-webview_release"})
public final class aw
{
  public String DNH;
  public long DUA;
  public int DUB;
  public String DUC;
  public String DUD;
  public String DUE;
  public int DUF;
  public int DUG;
  public String DUz;
  public String appId;
  public long dBD;
  public String dKk;
  public String desc;
  final long enterTime;
  public String fkz;
  public String hDf;
  public long lastResumeTime;
  public int scene;
  public String title;
  public String username;
  public String zRz;
  
  public aw()
  {
    AppMethodBeat.i(207596);
    this.title = "";
    this.desc = "";
    this.lastResumeTime = -1L;
    this.enterTime = (System.currentTimeMillis() / 1000L);
    AppMethodBeat.o(207596);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "invoke"})
  static final class a<InputType, ResultType>
    implements b<IPCVoid, IPCString>
  {
    public static final a DUH;
    
    static
    {
      AppMethodBeat.i(207594);
      DUH = new a();
      AppMethodBeat.o(207594);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "curUsername", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class b<T>
    implements d<ResultType>
  {
    b(aw paramaw) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.aw
 * JD-Core Version:    0.7.0.1
 */