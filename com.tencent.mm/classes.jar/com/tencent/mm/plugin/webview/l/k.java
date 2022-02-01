package com.tencent.mm.plugin.webview.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.a;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptTagJsApiHandler;", "", "jsapi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;)V", "debugInfo", "", "getDebugInfo", "()Ljava/lang/String;", "debugListener", "Landroid/view/View$OnLongClickListener;", "getDebugListener", "()Landroid/view/View$OnLongClickListener;", "debugListener$delegate", "Lkotlin/Lazy;", "firstTimeConfig", "", "lastAppId", "webComponent", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "webComptSettings", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "clear", "", "config", "appId", "url", "webCompts", "Ljava/util/LinkedList;", "dispatchEvent", "webCompt", "event", "message", "getInterceptResponse", "Lcom/tencent/xweb/WebResourceResponse;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "sendMessage", "webview-sdk_release"})
public final class k
{
  private final h IBw;
  final c JEJ;
  private boolean JEQ;
  String JER;
  final HashMap<String, cel> JES;
  private final f JET;
  
  public k(h paramh)
  {
    AppMethodBeat.i(225220);
    this.IBw = paramh;
    this.JEJ = new c(new WeakReference(this.IBw));
    this.JEQ = true;
    this.JER = "";
    this.JES = new HashMap();
    this.JET = g.ah((a)new k.c(this));
    AppMethodBeat.o(225220);
  }
  
  public final void bi(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(225218);
    p.h(paramString1, "webCompt");
    p.h(paramString2, "event");
    this.JEJ.bi(paramString1, paramString2, paramString3);
    AppMethodBeat.o(225218);
  }
  
  public final void c(final String paramString1, final String paramString2, final LinkedList<cel> paramLinkedList)
  {
    AppMethodBeat.i(225219);
    p.h(paramString1, "appId");
    p.h(paramString2, "url");
    p.h(paramLinkedList, "webCompts");
    if (paramLinkedList.isEmpty())
    {
      paramString1 = c.JDf;
      Log.w(c.access$getTAG$cp(), "webCompt is null");
      AppMethodBeat.o(225219);
      return;
    }
    final r localr = new r();
    if (this.JES.isEmpty())
    {
      if (((Collection)paramLinkedList).isEmpty()) {
        break label193;
      }
      i = 1;
      if (i != 0) {
        this.JEJ.JCS.a(b.JCn);
      }
    }
    final z.a locala = new z.a();
    locala.SYB = false;
    if (this.JEQ)
    {
      locala.SYB = true;
      label128:
      this.JER = paramString1;
      this.JEQ = false;
      if (((Collection)paramLinkedList).isEmpty()) {
        break label255;
      }
    }
    label193:
    label255:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        c.b localb = c.JDf;
        d.b(c.access$getTAG$cp(), (a)new a(this, paramLinkedList, localr, paramString1, paramString2, locala));
      }
      AppMethodBeat.o(225219);
      return;
      i = 0;
      break;
      if ((p.j(this.JER, paramString1) ^ true))
      {
        clear();
        this.JEJ.giK();
        this.JEJ.JCS.JEO.clear();
        break label128;
      }
      this.JEJ.JCS.a(b.JCo);
      break label128;
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(82969);
    this.JER = "";
    this.JEQ = true;
    this.JES.clear();
    this.JEJ.clear();
    AppMethodBeat.o(82969);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void sendMessage(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82968);
    p.h(paramString1, "webCompt");
    p.h(paramString2, "message");
    c localc = this.JEJ;
    p.h(paramString1, "webCompt");
    p.h(paramString2, "message");
    Log.v(c.TAG, "postToBack " + paramString1 + ' ' + paramString2);
    paramString1 = localc.bbt(paramString1);
    if (paramString1 != null) {
      c.c(paramString1, "WeixinWebCompt.onMessage(" + paramString2 + ')');
    }
    localc.JCS.a(b.JCH);
    AppMethodBeat.o(82968);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    a(k paramk, LinkedList paramLinkedList, r paramr, String paramString1, String paramString2, z.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.k
 * JD-Core Version:    0.7.0.1
 */