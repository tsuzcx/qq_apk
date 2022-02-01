package com.tencent.mm.plugin.webview.k;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.protocal.protobuf.brr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.h;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.a;
import d.l;
import d.n.n;
import d.z;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptTagJsApiHandler;", "", "jsapi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;)V", "debugInfo", "", "getDebugInfo", "()Ljava/lang/String;", "debugListener", "Landroid/view/View$OnLongClickListener;", "getDebugListener", "()Landroid/view/View$OnLongClickListener;", "debugListener$delegate", "Lkotlin/Lazy;", "firstTimeConfig", "", "lastAppId", "webComponent", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "webComptSettings", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "clear", "", "config", "appId", "url", "webCompts", "Ljava/util/LinkedList;", "dispatchEvent", "webCompt", "event", "message", "getInterceptResponse", "Lcom/tencent/xweb/WebResourceResponse;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "sendMessage", "webview-sdk_release"})
public final class k
{
  private final com.tencent.mm.plugin.webview.c.f DRx;
  final c EOT;
  private boolean EPb;
  String EPc;
  final HashMap<String, brr> EPd;
  private final d.f EPe;
  
  public k(com.tencent.mm.plugin.webview.c.f paramf)
  {
    AppMethodBeat.i(214261);
    this.DRx = paramf;
    this.EOT = new c(this.DRx);
    this.EPb = true;
    this.EPc = "";
    this.EPd = new HashMap();
    this.EPe = d.g.O((d.g.a.a)new c(this));
    AppMethodBeat.o(214261);
  }
  
  public final void aY(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(214259);
    p.h(paramString1, "webCompt");
    p.h(paramString2, "event");
    this.EOT.aY(paramString1, paramString2, paramString3);
    AppMethodBeat.o(214259);
  }
  
  public final void c(final String paramString1, final String paramString2, final LinkedList<brr> paramLinkedList)
  {
    AppMethodBeat.i(214260);
    p.h(paramString1, "appId");
    p.h(paramString2, "url");
    p.h(paramLinkedList, "webCompts");
    if (paramLinkedList.isEmpty())
    {
      paramString1 = c.ENl;
      ae.w(c.access$getTAG$cp(), "webCompt is null");
      AppMethodBeat.o(214260);
      return;
    }
    final r localr = new r();
    if (this.EPd.isEmpty())
    {
      if (((Collection)paramLinkedList).isEmpty()) {
        break label193;
      }
      i = 1;
      if (i != 0) {
        this.EOT.EMZ.a(b.EMu);
      }
    }
    final y.a locala = new y.a();
    locala.NiT = false;
    if (this.EPb)
    {
      locala.NiT = true;
      label128:
      this.EPc = paramString1;
      this.EPb = false;
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
        c.b localb = c.ENl;
        com.tencent.mm.ac.c.b(c.access$getTAG$cp(), (d.g.a.a)new a(this, paramLinkedList, localr, paramString1, paramString2, locala));
      }
      AppMethodBeat.o(214260);
      return;
      i = 0;
      break;
      if ((p.i(this.EPc, paramString1) ^ true))
      {
        clear();
        this.EOT.eZF();
        this.EOT.EMZ.EOZ.clear();
        break label128;
      }
      this.EOT.EMZ.a(b.EMv);
      break label128;
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(82969);
    this.EPc = "";
    this.EPb = true;
    this.EPd.clear();
    this.EOT.clear();
    AppMethodBeat.o(82969);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void sendMessage(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82968);
    p.h(paramString1, "webCompt");
    p.h(paramString2, "message");
    c localc = this.EOT;
    p.h(paramString1, "webCompt");
    p.h(paramString2, "message");
    ae.v(c.TAG, "postToBack " + paramString1 + ' ' + paramString2);
    paramString1 = localc.aLd(paramString1);
    if (paramString1 != null) {
      c.c(paramString1, "WeixinWebCompt.onMessage(" + paramString2 + ')');
    }
    localc.EMZ.a(b.EMO);
    AppMethodBeat.o(82968);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    a(k paramk, LinkedList paramLinkedList, r paramr, String paramString1, String paramString2, y.a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<brr, String>
  {
    public static final b EPi;
    
    static
    {
      AppMethodBeat.i(82964);
      EPi = new b();
      AppMethodBeat.o(82964);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View$OnLongClickListener;", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<View.OnLongClickListener>
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