package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/model/WebViewVisitReporter;", "Lcom/tencent/mm/plugin/webview/model/IWebviewReporter;", "()V", "appId", "", "chattype", "", "desc", "enterTime", "", "expidstr", "hasShowKeyboard", "lastResumeTime", "mPreUsername", "mPreviousUrl", "messageId", "messageIndex", "newMsgId", "publishId", "publisher", "rawUrl", "scene", "statExtStr", "stayTime", "title", "username", "viewID", "onPause", "", "onResume", "report", "setAppId", "setChattype", "setDesc", "setExpidstr", "setHasShowKeyboard", "showKeyboard", "", "setMessageId", "setMessageIndex", "setPreUsername", "setPreviousUrl", "url", "setPublishId", "setPublisher", "setRawUrl", "setScene", "setStatExtStr", "setTitle", "setUserName", "setViewID", "plugin-webview_release"})
public final class av
{
  public String CkC;
  public String CqV;
  public long CqW;
  public int CqX;
  public String CqY;
  public String CqZ;
  public String Cra;
  public int Crb;
  public int Crc;
  public String appId;
  public String desc;
  public long dpQ;
  public String dxX;
  public String eSk;
  final long enterTime;
  public String hkW;
  public long lastResumeTime;
  public int scene;
  public String title;
  public String username;
  public String yAj;
  
  public av()
  {
    AppMethodBeat.i(189461);
    this.title = "";
    this.desc = "";
    this.lastResumeTime = -1L;
    this.enterTime = (System.currentTimeMillis() / 1000L);
    AppMethodBeat.o(189461);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "invoke"})
  static final class a<InputType, ResultType>
    implements b<IPCVoid, IPCString>
  {
    public static final a Crd;
    
    static
    {
      AppMethodBeat.i(189459);
      Crd = new a();
      AppMethodBeat.o(189459);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "curUsername", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "onCallback"})
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