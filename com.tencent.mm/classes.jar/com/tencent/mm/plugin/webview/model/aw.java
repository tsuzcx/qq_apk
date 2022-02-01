package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/model/WebViewVisitReporter;", "Lcom/tencent/mm/plugin/webview/model/IWebviewReporter;", "()V", "appId", "", "chattype", "", "desc", "enterTime", "", "expidstr", "hasShowKeyboard", "lastResumeTime", "mPreUsername", "mPreviousUrl", "messageId", "messageIndex", "newMsgId", "publishId", "publisher", "rawUrl", "scene", "statExtStr", "stayTime", "title", "username", "viewID", "onPause", "", "onResume", "report", "setAppId", "setChattype", "setDesc", "setExpidstr", "setHasShowKeyboard", "showKeyboard", "", "setMessageId", "setMessageIndex", "setPreUsername", "setPreviousUrl", "url", "setPublishId", "setPublisher", "setRawUrl", "setScene", "setStatExtStr", "setTitle", "setUserName", "setViewID", "plugin-webview_release"})
public final class aw
{
  public String AiG;
  public String EfG;
  public int EmA;
  public String EmB;
  public String EmC;
  public String EmD;
  public int EmE;
  public int EmF;
  public String Emy;
  public long Emz;
  public String appId;
  public long dCI;
  public String dLz;
  public String desc;
  final long enterTime;
  public String fmw;
  public String hFX;
  public long lastResumeTime;
  public int scene;
  public String title;
  public String username;
  
  public aw()
  {
    AppMethodBeat.i(199352);
    this.title = "";
    this.desc = "";
    this.lastResumeTime = -1L;
    this.enterTime = (System.currentTimeMillis() / 1000L);
    AppMethodBeat.o(199352);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "invoke"})
  static final class a<InputType, ResultType>
    implements b<IPCVoid, IPCString>
  {
    public static final a EmG;
    
    static
    {
      AppMethodBeat.i(199350);
      EmG = new a();
      AppMethodBeat.o(199350);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "curUsername", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "onCallback"})
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