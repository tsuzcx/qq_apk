package com.tencent.mm.plugin.webview.l;

import android.os.Bundle;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.fad;
import com.tencent.mm.protocal.protobuf.fae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.xweb.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.bn;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;", "", "webComponent", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "webComptName", "", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;Ljava/lang/String;)V", "callbackHandler", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "jsPerm", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "getJsPerm", "()Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "setJsPerm", "(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;)V", "cgi", "", "callbackId", "request", "errReport", "errMsg", "errStack", "errLine", "", "errCol", "evaluate", "script", "idkey", "id", "", "key", "value", "idkeyList", "list", "invoke", "message", "kv", "data", "log", "level", "tag", "msg", "performance", "frontEndPerformance", "refreshA8Key", "sendMessage", "Companion", "webview-sdk_release"})
public final class i
{
  public static final i.a JEK;
  private static final String TAG = "WebComptContextJsApiHandler";
  private final com.tencent.mm.plugin.webview.d.b IBt;
  public JsapiPermissionWrapper IBv;
  private final String JDJ;
  private final c JEJ;
  
  static
  {
    AppMethodBeat.i(82957);
    JEK = new i.a((byte)0);
    TAG = "WebComptContextJsApiHandler";
    AppMethodBeat.o(82957);
  }
  
  public i(c paramc, String paramString)
  {
    AppMethodBeat.i(225217);
    this.JEJ = paramc;
    this.JDJ = paramString;
    this.IBt = ((com.tencent.mm.plugin.webview.d.b)new i.b(this));
    AppMethodBeat.o(225217);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void cgi(final String paramString1, String paramString2)
  {
    AppMethodBeat.i(82955);
    p.h(paramString1, "callbackId");
    p.h(paramString2, "request");
    Object localObject = this.JEJ.JCS;
    if (localObject != null) {
      ((j)localObject).a(b.JCJ);
    }
    localObject = new d.a();
    fad localfad = new fad();
    localfad.NvW = paramString2;
    ((d.a)localObject).c((com.tencent.mm.bw.a)localfad);
    ((d.a)localObject).d((com.tencent.mm.bw.a)new fae());
    ((d.a)localObject).MB("/cgi-bin/mmbiz-bin/webcompt/webcomptcommcgi");
    ((d.a)localObject).sG(2936);
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    IPCRunCgi.a(((d.a)localObject).aXF(), (IPCRunCgi.a)new c(this, paramString1));
    AppMethodBeat.o(82955);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void errReport(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82949);
    p.h(paramString1, "errMsg");
    p.h(paramString2, "errStack");
    this.JEJ.h(this.JDJ, paramString1, paramString2, paramInt1, paramInt2);
    AppMethodBeat.o(82949);
  }
  
  public final JsapiPermissionWrapper gdH()
  {
    AppMethodBeat.i(82945);
    JsapiPermissionWrapper localJsapiPermissionWrapper = this.IBv;
    if (localJsapiPermissionWrapper == null) {
      p.btv("jsPerm");
    }
    AppMethodBeat.o(82945);
    return localJsapiPermissionWrapper;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void idkey(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(82953);
    com.tencent.mm.plugin.report.service.h.CyF.n(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(82953);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void idkeyList(String paramString)
  {
    AppMethodBeat.i(82954);
    p.h(paramString, "list");
    paramString = new com.tencent.mm.ab.f(paramString);
    LinkedList localLinkedList = new LinkedList();
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      com.tencent.mm.ab.f localf = paramString.pW(i);
      localLinkedList.add(new IDKey(localf.getLong(0), localf.getLong(1), localf.getLong(2)));
      i += 1;
    }
    paramString = (List)localLinkedList;
    com.tencent.mm.plugin.report.service.h.CyF.b(new ArrayList((Collection)paramString), false);
    AppMethodBeat.o(82954);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void invoke(final String paramString)
  {
    AppMethodBeat.i(82946);
    p.h(paramString, "message");
    d locald = new d(this, paramString);
    int i;
    if (((CharSequence)paramString).length() == 0) {
      i = 1;
    }
    while (i == 0)
    {
      Log.d(TAG, "invoke: ".concat(String.valueOf(paramString)));
      if (MMHandlerThread.isMainThread())
      {
        locald.invoke();
        AppMethodBeat.o(82946);
        return;
        i = 0;
      }
      else
      {
        MMHandlerThread.postToMainThread((Runnable)new e(locald));
      }
    }
    AppMethodBeat.o(82946);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void kv(int paramInt, String paramString)
  {
    AppMethodBeat.i(82952);
    p.h(paramString, "data");
    com.tencent.mm.plugin.report.service.h.CyF.kvStat(paramInt, paramString);
    AppMethodBeat.o(82952);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void log(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(82951);
    p.h(paramString1, "tag");
    p.h(paramString2, "msg");
    paramString1 = "webCompt[" + paramString1 + ']';
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(82951);
      return;
      Log.v(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      Log.d(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      Log.i(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      Log.w(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      Log.e(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      Log.f(paramString1, paramString2);
    }
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final String performance(String paramString)
  {
    AppMethodBeat.i(82950);
    p.h(paramString, "frontEndPerformance");
    Object localObject2 = this.JEJ;
    String str1 = this.JDJ;
    p.h(str1, "webCompt");
    p.h(paramString, "frontEndPerformance");
    c.l.a locala = (c.l.a)((c)localObject2).giJ().get(str1);
    Object localObject1;
    if (locala != null)
    {
      localObject1 = locala.JDX;
      if (localObject1 != null)
      {
        localObject1 = c.a((r)localObject1, kotlin.a.j.listOf(new c.k[] { c.k.JDL, c.k.JDN, c.k.JDO, c.k.JDM })) + paramString;
        Log.i(c.TAG, "performance: ".concat(String.valueOf(localObject1)));
        paramString = (com.tencent.mm.plugin.webview.d.h)((c)localObject2).JCU.get();
        if (paramString != null)
        {
          paramString = paramString.getSettings();
          if (paramString != null)
          {
            localObject2 = paramString.getUserAgentString();
            paramString = (String)localObject2;
            if (localObject2 != null) {
              break label176;
            }
          }
        }
        paramString = "";
        label176:
        paramString = a.htmlEncode(paramString);
        localObject2 = a.htmlEncode(locala.pDH);
        String str2 = locala.appId;
        c.b localb = c.JDf;
        paramString = kotlin.a.j.a((Iterable)kotlin.a.j.listOf(new Object[] { paramString, localObject2, str2, str1, Integer.valueOf(c.b.giU().getVersion()), locala.JDW }), (CharSequence)",", null, (CharSequence)",", 0, null, null, 58);
        com.tencent.mm.plugin.report.service.h.CyF.kvStat(18151, paramString + (String)localObject1);
      }
    }
    for (paramString = (String)localObject1;; paramString = "")
    {
      localObject1 = paramString;
      if (paramString == null) {
        localObject1 = "";
      }
      AppMethodBeat.o(82950);
      return localObject1;
    }
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void refreshA8Key(String paramString)
  {
    AppMethodBeat.i(82948);
    p.h(paramString, "callbackId");
    c localc = this.JEJ;
    Object localObject = this.JDJ;
    kotlin.g.a.b localb = (kotlin.g.a.b)new i.f(this);
    paramString = (kotlin.g.a.b)new i.g(this, paramString);
    p.h(localObject, "webCompt");
    p.h(localb, "onerror");
    p.h(paramString, "onsuccess");
    localObject = (c.l.a)localc.giJ().get(localObject);
    if (localObject != null)
    {
      if (!n.aL((CharSequence)((c.l.a)localObject).JDU)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          kotlinx.coroutines.f.b((ai)bn.TUK, null, (m)new c.y((c.l.a)localObject, null, localc, paramString, localb), 3);
        }
        AppMethodBeat.o(82948);
        return;
      }
    }
    AppMethodBeat.o(82948);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void sendMessage(String paramString)
  {
    AppMethodBeat.i(82947);
    p.h(paramString, "data");
    c localc = this.JEJ;
    p.h(paramString, "message");
    Log.v(c.TAG, "postToFront ".concat(String.valueOf(paramString)));
    c.a(localc, "window.WeixinOpenTags && window.WeixinOpenTags.onMessage(" + paramString + ')');
    localc.JCS.a(b.JCI);
    AppMethodBeat.o(82947);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class c
    implements IPCRunCgi.a
  {
    c(i parami, String paramString) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, d paramd)
    {
      AppMethodBeat.i(82937);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        localObject = this.JEL;
        StringBuilder localStringBuilder = new StringBuilder("WeixinWebCompt._callback(").append(a.bbs(paramString1)).append(", {errType:").append(paramInt1).append(", errCode:").append(paramInt2).append(", errMsg:");
        if (paramString != null)
        {
          paramd = a.bbs(paramString);
          paramString = paramd;
          if (paramd != null) {}
        }
        else
        {
          paramString = "";
        }
        i.a((i)localObject, paramString + "})");
        paramString = i.a(this.JEL).JCS;
        if (paramString != null)
        {
          paramString.a(b.JCK);
          AppMethodBeat.o(82937);
          return;
        }
        AppMethodBeat.o(82937);
        return;
      }
      paramString = this.JEL;
      Object localObject = new StringBuilder("WeixinWebCompt._callback(").append(a.bbs(paramString1)).append(", ");
      p.g(paramd, "rr");
      paramd = paramd.aYK();
      if (paramd == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.WebComptCommCgiResp");
        AppMethodBeat.o(82937);
        throw paramString;
      }
      i.a(paramString, ((fae)paramd).NvX + ')');
      AppMethodBeat.o(82937);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"dealMsg", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(i parami, String paramString)
    {
      super();
    }
    
    public final void invoke()
    {
      AppMethodBeat.i(82941);
      Object localObject = i.a(this.JEL).JCU;
      if (localObject != null)
      {
        localObject = (com.tencent.mm.plugin.webview.d.h)((WeakReference)localObject).get();
        if (localObject != null)
        {
          String str = paramString;
          JsapiPermissionWrapper localJsapiPermissionWrapper = this.JEL.gdH();
          Bundle localBundle = new Bundle();
          localBundle.putString("name", i.b(this.JEL));
          ((com.tencent.mm.plugin.webview.d.h)localObject).a(str, localJsapiPermissionWrapper, localBundle, i.c(this.JEL));
          AppMethodBeat.o(82941);
          return;
        }
      }
      AppMethodBeat.o(82941);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(i.d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(82942);
      this.JEN.invoke();
      AppMethodBeat.o(82942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.i
 * JD-Core Version:    0.7.0.1
 */