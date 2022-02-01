package com.tencent.mm.plugin.webview.l;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.protocal.protobuf.cnf;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.aa.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptTagJsApiHandler;", "", "jsapi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;)V", "debugInfo", "", "getDebugInfo", "()Ljava/lang/String;", "debugListener", "Landroid/view/View$OnLongClickListener;", "getDebugListener", "()Landroid/view/View$OnLongClickListener;", "debugListener$delegate", "Lkotlin/Lazy;", "firstTimeConfig", "", "lastAppId", "webComponent", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "webComptSettings", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "clear", "", "config", "appId", "url", "webCompts", "Ljava/util/LinkedList;", "dispatchEvent", "webCompt", "event", "message", "getInterceptResponse", "Lcom/tencent/xweb/WebResourceResponse;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "sendMessage", "webview-sdk_release"})
public final class k
{
  private final com.tencent.mm.plugin.webview.d.h PvJ;
  private boolean QDE;
  String QDF;
  final HashMap<String, cnf> QDG;
  private final f QDH;
  final c QDy;
  
  public k(com.tencent.mm.plugin.webview.d.h paramh)
  {
    AppMethodBeat.i(206675);
    this.PvJ = paramh;
    this.QDy = new c(new WeakReference(this.PvJ));
    this.QDE = true;
    this.QDF = "";
    this.QDG = new HashMap();
    this.QDH = g.ar((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(206675);
  }
  
  public final void bd(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(206670);
    p.k(paramString1, "webCompt");
    p.k(paramString2, "event");
    this.QDy.bd(paramString1, paramString2, paramString3);
    AppMethodBeat.o(206670);
  }
  
  public final void c(final String paramString1, final String paramString2, final LinkedList<cnf> paramLinkedList)
  {
    AppMethodBeat.i(206674);
    p.k(paramString1, "appId");
    p.k(paramString2, "url");
    p.k(paramLinkedList, "webCompts");
    if (paramLinkedList.isEmpty())
    {
      paramString1 = c.QBP;
      Log.w(c.access$getTAG$cp(), "webCompt is null");
      AppMethodBeat.o(206674);
      return;
    }
    final r localr = new r();
    if (this.QDG.isEmpty())
    {
      if (((Collection)paramLinkedList).isEmpty()) {
        break label193;
      }
      i = 1;
      if (i != 0) {
        this.QDy.QBB.a(b.QAW);
      }
    }
    final aa.a locala = new aa.a();
    locala.aaBx = false;
    if (this.QDE)
    {
      locala.aaBx = true;
      label128:
      this.QDF = paramString1;
      this.QDE = false;
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
        c.b localb = c.QBP;
        d.b(c.access$getTAG$cp(), (kotlin.g.a.a)new a(this, paramLinkedList, localr, paramString1, paramString2, locala));
      }
      AppMethodBeat.o(206674);
      return;
      i = 0;
      break;
      if ((p.h(this.QDF, paramString1) ^ true))
      {
        clear();
        this.QDy.hcu();
        this.QDy.QBB.QDC.clear();
        break label128;
      }
      this.QDy.QBB.a(b.QAX);
      break label128;
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(82969);
    this.QDF = "";
    this.QDE = true;
    this.QDG.clear();
    this.QDy.clear();
    AppMethodBeat.o(82969);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void sendMessage(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82968);
    p.k(paramString1, "webCompt");
    p.k(paramString2, "message");
    c localc = this.QDy;
    p.k(paramString1, "webCompt");
    p.k(paramString2, "message");
    Log.v(c.TAG, "postToBack " + paramString1 + ' ' + paramString2);
    paramString1 = localc.bnt(paramString1);
    if (paramString1 != null) {
      c.c(paramString1, "WeixinWebCompt.onMessage(" + paramString2 + ')');
    }
    localc.QBB.a(b.QBq);
    AppMethodBeat.o(82968);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(k paramk, LinkedList paramLinkedList, r paramr, String paramString1, String paramString2, aa.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<cnf, String>
  {
    public static final b QDL;
    
    static
    {
      AppMethodBeat.i(82964);
      QDL = new b();
      AppMethodBeat.o(82964);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View$OnLongClickListener;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<View.OnLongClickListener>
  {
    c(k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.k
 * JD-Core Version:    0.7.0.1
 */