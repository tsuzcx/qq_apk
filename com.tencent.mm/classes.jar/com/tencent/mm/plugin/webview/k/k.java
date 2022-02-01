package com.tencent.mm.plugin.webview.k;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import d.g;
import d.g.a.a;
import d.g.b.u;
import d.g.b.v.a;
import d.g.b.w;
import d.n.n;
import d.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptTagJsApiHandler;", "", "jsapi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;)V", "debugInfo", "", "getDebugInfo", "()Ljava/lang/String;", "debugListener", "Landroid/view/View$OnLongClickListener;", "getDebugListener", "()Landroid/view/View$OnLongClickListener;", "debugListener$delegate", "Lkotlin/Lazy;", "firstTimeConfig", "", "lastAppId", "webComponent", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "webComptSettings", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "clear", "", "config", "appId", "url", "webCompts", "Ljava/util/LinkedList;", "dispatchEvent", "webCompt", "event", "message", "getInterceptResponse", "Lcom/tencent/xweb/WebResourceResponse;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "sendMessage", "webview-sdk_release"})
public final class k
{
  private final com.tencent.mm.plugin.webview.c.f AQP;
  private final d.f BAA;
  final c BAp;
  private boolean BAx;
  private String BAy;
  private final HashMap<String, biv> BAz;
  
  static
  {
    AppMethodBeat.i(82967);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(k.class), "debugListener", "getDebugListener()Landroid/view/View$OnLongClickListener;")) };
    AppMethodBeat.o(82967);
  }
  
  public k(com.tencent.mm.plugin.webview.c.f paramf)
  {
    AppMethodBeat.i(189493);
    this.AQP = paramf;
    this.BAp = new c(this.AQP);
    this.BAx = true;
    this.BAy = "";
    this.BAz = new HashMap();
    this.BAA = g.E((a)new c(this));
    AppMethodBeat.o(189493);
  }
  
  public final void aM(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(189491);
    d.g.b.k.h(paramString1, "webCompt");
    d.g.b.k.h(paramString2, "event");
    this.BAp.aM(paramString1, paramString2, paramString3);
    AppMethodBeat.o(189491);
  }
  
  public final void c(final String paramString1, final String paramString2, final LinkedList<biv> paramLinkedList)
  {
    AppMethodBeat.i(189492);
    d.g.b.k.h(paramString1, "appId");
    d.g.b.k.h(paramString2, "url");
    d.g.b.k.h(paramLinkedList, "webCompts");
    final q localq = new q();
    if (this.BAz.isEmpty())
    {
      if (((Collection)paramLinkedList).isEmpty()) {
        break label168;
      }
      i = 1;
      if (i != 0) {
        this.BAp.Bys.a(b.BxO);
      }
    }
    final v.a locala = new v.a();
    locala.Jhs = false;
    if (this.BAx)
    {
      locala.Jhs = true;
      label103:
      this.BAy = paramString1;
      this.BAx = false;
      if (((Collection)paramLinkedList).isEmpty()) {
        break label230;
      }
    }
    label168:
    label230:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        c.b localb = c.ByF;
        com.tencent.mm.ad.c.b(c.b.erK(), (a)new a(this, paramLinkedList, localq, paramString1, paramString2, locala));
      }
      AppMethodBeat.o(189492);
      return;
      i = 0;
      break;
      if ((d.g.b.k.g(this.BAy, paramString1) ^ true))
      {
        clear();
        this.BAp.erx();
        this.BAp.Bys.BAv.clear();
        break label103;
      }
      this.BAp.Bys.a(b.BxP);
      break label103;
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(82969);
    this.BAy = "";
    this.BAx = true;
    this.BAz.clear();
    this.BAp.clear();
    AppMethodBeat.o(82969);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void sendMessage(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82968);
    d.g.b.k.h(paramString1, "webCompt");
    d.g.b.k.h(paramString2, "message");
    c localc = this.BAp;
    d.g.b.k.h(paramString1, "webCompt");
    d.g.b.k.h(paramString2, "message");
    ad.v(c.TAG, "postToBack " + paramString1 + ' ' + paramString2);
    paramString1 = localc.ayO(paramString1);
    if (paramString1 != null) {
      c.c(paramString1, "WeixinWebCompt.onMessage(" + paramString2 + ')');
    }
    localc.Bys.a(b.Byi);
    AppMethodBeat.o(82968);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<y>
  {
    a(k paramk, LinkedList paramLinkedList, q paramq, String paramString1, String paramString2, v.a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<biv, String>
  {
    public static final b BAE;
    
    static
    {
      AppMethodBeat.i(82964);
      BAE = new b();
      AppMethodBeat.o(82964);
    }
    
    b()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/View$OnLongClickListener;", "invoke"})
  static final class c
    extends d.g.b.l
    implements a<View.OnLongClickListener>
  {
    c(k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.k
 * JD-Core Version:    0.7.0.1
 */