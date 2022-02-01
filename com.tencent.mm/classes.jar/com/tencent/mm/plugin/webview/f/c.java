package com.tencent.mm.plugin.webview.f;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.g;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.plugin.webview.jsapi.p.a;
import com.tencent.mm.plugin.webview.jsapi.t;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/prefecher/WebPrefetcherJsApiHandler;", "Lcom/tencent/mm/plugin/webview/jsapi/IJsApiHandlerWrapper;", "jsApiPool", "Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;", "jsPerm", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "wv", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;Lcom/tencent/mm/protocal/JsapiPermissionWrapper;Lcom/tencent/mm/ui/widget/MMWebView;)V", "canGetRandomStrNow", "", "getCanGetRandomStrNow", "()Z", "setCanGetRandomStrNow", "(Z)V", "canUpdateRandomStr", "destroyed", "enableDigestVerify", "isDgtVerify", "msgList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "msgQueueHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "randomStr", "", "resultValueList", "", "_getAllHosts", "", "allHostsStr", "_getDgtVerifyRandomStr", "_getHtmlContent", "contentStr", "_isDgtVerifyEnabled", "_ready", "ready", "_sendMessage", "msgContent", "dealAllMsg", "dealMsg", "msg", "dealMsgQueue", "dealNextMsg", "destroy", "doCallback", "callbackId", "ret", "retValue", "", "", "getBinderID", "", "getDgtVerifyRandomStr", "getJsApiPool", "getJsPerm", "hasPermission", "controlByte", "init", "initMsgQueueHandler", "isDgtVerifyEnabled", "setDigestVerify", "digestVerify", "updateRandomStr", "Companion", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements e
{
  public static final a WPT;
  String KQY;
  private final LinkedList<p> PmC;
  private final List<String> WDD;
  private MMHandler WDE;
  boolean WDI;
  boolean WDJ;
  final MMWebView WDz;
  boolean WPU;
  boolean WPV;
  JsapiPermissionWrapper WlV;
  private final g Wwh;
  private boolean vXm;
  
  static
  {
    AppMethodBeat.i(294641);
    WPT = new a((byte)0);
    AppMethodBeat.o(294641);
  }
  
  public c(g paramg, JsapiPermissionWrapper paramJsapiPermissionWrapper, MMWebView paramMMWebView)
  {
    AppMethodBeat.i(294594);
    this.Wwh = paramg;
    this.WlV = paramJsapiPermissionWrapper;
    this.WDz = paramMMWebView;
    this.WDD = ((List)new ArrayList());
    this.PmC = new LinkedList();
    this.KQY = "";
    this.WDE = ((MMHandler)new c(this, Looper.getMainLooper()));
    this.WPU = b.iwv();
    this.WPV = b.iww();
    paramg = a.iwy();
    if (paramg != null)
    {
      Log.i("MicroMsg.WebPrefetcherJsApiHandler", "init hardcodeJsPermission valid and use");
      this.WlV = paramg;
    }
    AppMethodBeat.o(294594);
  }
  
  private static final void a(c paramc)
  {
    AppMethodBeat.i(294611);
    s.u(paramc, "this$0");
    paramc.iwx();
    AppMethodBeat.o(294611);
  }
  
  private static final void a(c paramc, String paramString)
  {
    AppMethodBeat.i(294620);
    s.u(paramc, "this$0");
    try
    {
      paramc.WDz.evaluateJavascript("javascript:WeixinPrefecherJSBridge._handleMessageFromWeixin(" + paramString + ')', (ValueCallback)new b());
      AppMethodBeat.o(294620);
      return;
    }
    catch (Exception paramc)
    {
      Log.printErrStackTrace("MicroMsg.WebPrefetcherJsApiHandler", (Throwable)paramc, "doCallback exception", new Object[0]);
      AppMethodBeat.o(294620);
    }
  }
  
  private final void iwx()
  {
    AppMethodBeat.i(294606);
    if (this.WDD.isEmpty())
    {
      Log.i("MicroMsg.WebPrefetcherJsApiHandler", "dealMsgQueue fail, resultValueList is empty");
      AppMethodBeat.o(294606);
      return;
    }
    Log.i("MicroMsg.WebPrefetcherJsApiHandler", s.X("dealMsgQueue, pre msgList = ", Integer.valueOf(this.PmC.size())));
    boolean bool;
    p localp;
    try
    {
      Object localObject1 = p.a.n((String)this.WDD.remove(0), this.WDI, this.KQY);
      if (!Util.isNullOrNil((List)localObject1))
      {
        this.PmC.addAll((Collection)localObject1);
        Log.i("MicroMsg.WebPrefetcherJsApiHandler", "dealMsgQueue now msg list size : %d", new Object[] { Integer.valueOf(this.PmC.size()) });
      }
      Log.i("MicroMsg.WebPrefetcherJsApiHandler", s.X("dealMsgQueue, post msgList = ", Integer.valueOf(this.PmC.size())));
      while (this.PmC.isEmpty())
      {
        Log.i("MicroMsg.WebPrefetcherJsApiHandler", "dealNextMsg stop, msgList is empty");
        bool = false;
        if (!bool)
        {
          if (this.WDE != null)
          {
            localObject1 = this.WDE;
            s.checkNotNull(localObject1);
            ((MMHandler)localObject1).post(new c..ExternalSyntheticLambda0(this));
          }
          AppMethodBeat.o(294606);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WebPrefetcherJsApiHandler", (Throwable)localException, "dealMsgQueue exception", new Object[0]);
        continue;
        Log.i("MicroMsg.WebPrefetcherJsApiHandler", "dealNextMsg size: %s", new Object[] { Integer.valueOf(this.PmC.size()) });
        localp = (p)this.PmC.remove(0);
        if (localp != null) {
          break;
        }
        bool = false;
      }
      localObject2 = this.WDz;
      if (localObject2 != null) {}
    }
    for (Object localObject2 = null;; localObject2 = ((MMWebView)localObject2).getContext())
    {
      Object localObject3 = localObject2;
      if (localObject2 == null) {
        localObject3 = MMApplicationContext.getContext();
      }
      s.s(localObject3, "wv?.context ?: MMApplicationContext.getContext()");
      JsapiPermissionWrapper localJsapiPermissionWrapper = this.WlV;
      localObject2 = localJsapiPermissionWrapper;
      if (localJsapiPermissionWrapper == null) {
        localObject2 = localp.WlV;
      }
      localObject2 = new com.tencent.mm.plugin.webview.jsapi.h((Context)localObject3, (JsapiPermissionWrapper)localObject2, null, (e)this, this.WDz);
      localObject3 = t.WEP;
      bool = t.a((com.tencent.mm.plugin.webview.jsapi.h)localObject2, localp, this.Wwh);
      break;
    }
  }
  
  public final void _getAllHosts(String paramString) {}
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final String _getDgtVerifyRandomStr()
  {
    AppMethodBeat.i(294673);
    Log.i("MicroMsg.WebPrefetcherJsApiHandler", "_getDgtVerifyRandomStr canUpdateRandomStr: %s, canGet: %s, randomStr: %s", new Object[] { Boolean.valueOf(this.WPV), Boolean.valueOf(this.WDJ), this.KQY });
    if ((this.WPV) && (!this.WDJ))
    {
      AppMethodBeat.o(294673);
      return "";
    }
    this.WDJ = false;
    String str = this.KQY;
    AppMethodBeat.o(294673);
    return str;
  }
  
  public final void _getHtmlContent(String paramString) {}
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final boolean _isDgtVerifyEnabled()
  {
    return this.WDI;
  }
  
  public final void _ready(boolean paramBoolean) {}
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _sendMessage(String paramString)
  {
    AppMethodBeat.i(294665);
    Log.d("MicroMsg.WebPrefetcherJsApiHandler", "_sendMessage msgContent: %s", new Object[] { paramString });
    if (this.WDE != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramString;
      paramString = this.WDE;
      if (paramString != null)
      {
        paramString.sendMessage(localMessage);
        AppMethodBeat.o(294665);
      }
    }
    else
    {
      Log.e("MicroMsg.WebPrefetcherJsApiHandler", "_sendMessage msgQueueHandler err");
    }
    AppMethodBeat.o(294665);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(294656);
    Object localObject = this.WDE;
    if (localObject != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 3;
      localMessage.obj = null;
      ah localah = ah.aiuX;
      ((MMHandler)localObject).sendMessage(localMessage);
    }
    localObject = this.WDz;
    if (localObject != null) {
      ((MMWebView)localObject).removeJavascriptInterface("__wxPrefetcher");
    }
    AppMethodBeat.o(294656);
  }
  
  public final void doCallback(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(294701);
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localObject = (CharSequence)paramString1;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label89;
        }
      }
    }
    label89:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label95;
      }
      Log.e("MicroMsg.WebPrefetcherJsApiHandler", s.X("doCallback, invalid args, ret = ", paramString2));
      AppMethodBeat.o(294701);
      return;
      i = 0;
      break;
    }
    label95:
    Map localMap = (Map)new HashMap();
    if (paramString2 == null)
    {
      localObject = "";
      localMap.put("errMsg", localObject);
      if ((paramMap != null) && (!paramMap.isEmpty())) {
        break label282;
      }
    }
    label282:
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        Log.i("MicroMsg.WebPrefetcherJsApiHandler", "doCallback, retValue size: " + paramMap.size() + ' ');
        localMap.putAll(paramMap);
      }
      paramString1 = p.a.a(paramString1, localMap, this.WDI, this.KQY);
      Log.i("MicroMsg.WebPrefetcherJsApiHandler", "doCallback, ret = " + paramString2 + ", cb = " + paramString1);
      if ((paramString1 == null) || (this.WDz == null)) {
        break label298;
      }
      paramString1 = new c..ExternalSyntheticLambda1(this, paramString1);
      if (!MMHandlerThread.isMainThread()) {
        break label288;
      }
      paramString1.run();
      AppMethodBeat.o(294701);
      return;
      localObject = paramString2;
      break;
    }
    label288:
    com.tencent.threadpool.h.ahAA.bk(paramString1);
    label298:
    AppMethodBeat.o(294701);
  }
  
  public final int getBinderID()
  {
    return 0;
  }
  
  public final g itt()
  {
    return this.Wwh;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/prefecher/WebPrefetcherJsApiHandler$Companion;", "", "()V", "EVENT_ID", "", "TAG", "WHAT_DESTROY", "", "WHAT_FETCH_DONE", "WHAT_HANDLE_DONE", "WX_PREFETCHER_NAME", "getHardCodeJsPermission", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static JsapiPermissionWrapper iwy()
    {
      AppMethodBeat.i(294600);
      Object localObject = (CharSequence)z.pCh;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.w("MicroMsg.WebPrefetcherJsApiHandler", "getHardCodeJsPermission, Test.jsapiPermission is null");
        AppMethodBeat.o(294600);
        return null;
      }
      try
      {
        i = Util.getInt(z.pCh, 0);
        if (i < 0)
        {
          Log.w("MicroMsg.WebPrefetcherJsApiHandler", "getHardCodeJsPermission, Test.jsapiPermission wrong");
          AppMethodBeat.o(294600);
          return null;
        }
        Log.i("MicroMsg.WebPrefetcherJsApiHandler", "getHardCodeJsPermission %d", new Object[] { Integer.valueOf(i) });
        localObject = new JsapiPermissionWrapper(i);
        AppMethodBeat.o(294600);
        return localObject;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.WebPrefetcherJsApiHandler", (Throwable)localException, "getHardCodeJsPermission exception", new Object[0]);
        AppMethodBeat.o(294600);
      }
      return null;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/prefecher/WebPrefetcherJsApiHandler$doCallback$r$1$1", "Landroid/webkit/ValueCallback;", "", "onReceiveValue", "", "value", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements ValueCallback<String>
  {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/prefecher/WebPrefetcherJsApiHandler$initMsgQueueHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends MMHandler
  {
    c(c paramc, Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(294596);
      s.u(paramMessage, "msg");
      if (c.b(this.WPW))
      {
        Log.w("MicroMsg.WebPrefetcherJsApiHandler", "handleMsg destroyed and ignore");
        AppMethodBeat.o(294596);
        return;
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(294596);
        return;
        paramMessage = paramMessage.obj;
        if ((paramMessage instanceof String))
        {
          paramMessage = (String)paramMessage;
          CharSequence localCharSequence = (CharSequence)paramMessage;
          if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
            break label143;
          }
        }
        label143:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            c.c(this.WPW).add(paramMessage);
          }
          c.d(this.WPW);
          AppMethodBeat.o(294596);
          return;
          paramMessage = null;
          break;
        }
        Log.v("MicroMsg.WebPrefetcherJsApiHandler", "handle msg from wx done, msg: " + paramMessage.obj + ' ');
        AppMethodBeat.o(294596);
        return;
        c.e(this.WPW);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/prefecher/WebPrefetcherJsApiHandler$updateRandomStr$1", "Landroid/webkit/ValueCallback;", "", "onReceiveValue", "", "value", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements ValueCallback<String>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f.c
 * JD-Core Version:    0.7.0.1
 */