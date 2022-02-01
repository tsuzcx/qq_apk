package com.tencent.mm.plugin.webview.k;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.protocal.protobuf.bqx;
import com.tencent.mm.sdk.platformtools.ad;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptTagJsApiHandler;", "", "jsapi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;)V", "debugInfo", "", "getDebugInfo", "()Ljava/lang/String;", "debugListener", "Landroid/view/View$OnLongClickListener;", "getDebugListener", "()Landroid/view/View$OnLongClickListener;", "debugListener$delegate", "Lkotlin/Lazy;", "firstTimeConfig", "", "lastAppId", "webComponent", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "webComptSettings", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "clear", "", "config", "appId", "url", "webCompts", "Ljava/util/LinkedList;", "dispatchEvent", "webCompt", "event", "message", "getInterceptResponse", "Lcom/tencent/xweb/WebResourceResponse;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "sendMessage", "webview-sdk_release"})
public final class k
{
  private final com.tencent.mm.plugin.webview.c.f DzP;
  private boolean EwF;
  String EwG;
  final HashMap<String, bqx> EwH;
  private final d.f EwI;
  final c Ewx;
  
  public k(com.tencent.mm.plugin.webview.c.f paramf)
  {
    AppMethodBeat.i(214420);
    this.DzP = paramf;
    this.Ewx = new c(this.DzP);
    this.EwF = true;
    this.EwG = "";
    this.EwH = new HashMap();
    this.EwI = d.g.O((d.g.a.a)new c(this));
    AppMethodBeat.o(214420);
  }
  
  public final void aX(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(214418);
    p.h(paramString1, "webCompt");
    p.h(paramString2, "event");
    this.Ewx.aX(paramString1, paramString2, paramString3);
    AppMethodBeat.o(214418);
  }
  
  public final void c(final String paramString1, final String paramString2, final LinkedList<bqx> paramLinkedList)
  {
    AppMethodBeat.i(214419);
    p.h(paramString1, "appId");
    p.h(paramString2, "url");
    p.h(paramLinkedList, "webCompts");
    if (paramLinkedList.isEmpty())
    {
      paramString1 = c.EuR;
      ad.w(c.access$getTAG$cp(), "webCompt is null");
      AppMethodBeat.o(214419);
      return;
    }
    final r localr = new r();
    if (this.EwH.isEmpty())
    {
      if (((Collection)paramLinkedList).isEmpty()) {
        break label193;
      }
      i = 1;
      if (i != 0) {
        this.Ewx.EuF.a(b.Eua);
      }
    }
    final y.a locala = new y.a();
    locala.MLQ = false;
    if (this.EwF)
    {
      locala.MLQ = true;
      label128:
      this.EwG = paramString1;
      this.EwF = false;
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
        c.b localb = c.EuR;
        com.tencent.mm.ad.c.b(c.access$getTAG$cp(), (d.g.a.a)new a(this, paramLinkedList, localr, paramString1, paramString2, locala));
      }
      AppMethodBeat.o(214419);
      return;
      i = 0;
      break;
      if ((p.i(this.EwG, paramString1) ^ true))
      {
        clear();
        this.Ewx.eVT();
        this.Ewx.EuF.EwD.clear();
        break label128;
      }
      this.Ewx.EuF.a(b.Eub);
      break label128;
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(82969);
    this.EwG = "";
    this.EwF = true;
    this.EwH.clear();
    this.Ewx.clear();
    AppMethodBeat.o(82969);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void sendMessage(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82968);
    p.h(paramString1, "webCompt");
    p.h(paramString2, "message");
    c localc = this.Ewx;
    p.h(paramString1, "webCompt");
    p.h(paramString2, "message");
    ad.v(c.TAG, "postToBack " + paramString1 + ' ' + paramString2);
    paramString1 = localc.aJH(paramString1);
    if (paramString1 != null) {
      c.c(paramString1, "WeixinWebCompt.onMessage(" + paramString2 + ')');
    }
    localc.EuF.a(b.Euu);
    AppMethodBeat.o(82968);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    a(k paramk, LinkedList paramLinkedList, r paramr, String paramString1, String paramString2, y.a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<bqx, String>
  {
    public static final b EwM;
    
    static
    {
      AppMethodBeat.i(82964);
      EwM = new b();
      AppMethodBeat.o(82964);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/View$OnLongClickListener;", "invoke"})
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