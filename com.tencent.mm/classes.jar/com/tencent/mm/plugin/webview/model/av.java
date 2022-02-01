package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/model/WebViewVisitReporter;", "Lcom/tencent/mm/plugin/webview/model/IWebviewReporter;", "()V", "appId", "", "chattype", "", "desc", "enterTime", "", "expidstr", "hasShowKeyboard", "lastResumeTime", "mPreUsername", "mPreviousUrl", "messageId", "messageIndex", "newMsgId", "publishId", "publisher", "rawUrl", "scene", "statExtStr", "stayTime", "title", "username", "viewID", "onPause", "", "onResume", "report", "setAppId", "setChattype", "setDesc", "setExpidstr", "setHasShowKeyboard", "showKeyboard", "", "setMessageId", "setMessageIndex", "setPreUsername", "setPreviousUrl", "url", "setPublishId", "setPublisher", "setRawUrl", "setScene", "setStatExtStr", "setTitle", "setUserName", "setViewID", "plugin-webview_release"})
public final class av
{
  public String ASp;
  public String AYI;
  public long AYJ;
  public int AYK;
  public String AYL;
  public String AYM;
  public String AYN;
  public int AYO;
  public int AYP;
  public String appId;
  public String dAl;
  public String desc;
  public long dsf;
  public String ePc;
  final long enterTime;
  public String gKw;
  public long lastResumeTime;
  public int scene;
  public String title;
  public String username;
  public String xns;
  
  public av()
  {
    AppMethodBeat.i(188892);
    this.title = "";
    this.desc = "";
    this.lastResumeTime = -1L;
    this.enterTime = (System.currentTimeMillis() / 1000L);
    AppMethodBeat.o(188892);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "invoke"})
  static final class a<InputType, ResultType>
    implements b<IPCVoid, IPCString>
  {
    public static final a AYQ;
    
    static
    {
      AppMethodBeat.i(188890);
      AYQ = new a();
      AppMethodBeat.o(188890);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "curUsername", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class b<T>
    implements d<ResultType>
  {
    b(av paramav) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.av
 * JD-Core Version:    0.7.0.1
 */