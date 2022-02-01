package com.tencent.mm.plugin.webview.k;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.sdk.platformtools.ac;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptTagJsApiHandler;", "", "jsapi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;)V", "debugInfo", "", "getDebugInfo", "()Ljava/lang/String;", "debugListener", "Landroid/view/View$OnLongClickListener;", "getDebugListener", "()Landroid/view/View$OnLongClickListener;", "debugListener$delegate", "Lkotlin/Lazy;", "firstTimeConfig", "", "lastAppId", "webComponent", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "webComptSettings", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "clear", "", "config", "appId", "url", "webCompts", "Ljava/util/LinkedList;", "dispatchEvent", "webCompt", "event", "message", "getInterceptResponse", "Lcom/tencent/xweb/WebResourceResponse;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "sendMessage", "webview-sdk_release"})
public final class k
{
  private boolean CSE;
  private String CSF;
  private final HashMap<String, bmn> CSG;
  private final d.f CSH;
  final c CSw;
  private final com.tencent.mm.plugin.webview.c.f Cjc;
  
  static
  {
    AppMethodBeat.i(82967);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(k.class), "debugListener", "getDebugListener()Landroid/view/View$OnLongClickListener;")) };
    AppMethodBeat.o(82967);
  }
  
  public k(com.tencent.mm.plugin.webview.c.f paramf)
  {
    AppMethodBeat.i(205626);
    this.Cjc = paramf;
    this.CSw = new c(this.Cjc);
    this.CSE = true;
    this.CSF = "";
    this.CSG = new HashMap();
    this.CSH = g.K((a)new c(this));
    AppMethodBeat.o(205626);
  }
  
  public final void aP(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(205624);
    d.g.b.k.h(paramString1, "webCompt");
    d.g.b.k.h(paramString2, "event");
    this.CSw.aP(paramString1, paramString2, paramString3);
    AppMethodBeat.o(205624);
  }
  
  public final void c(final String paramString1, final String paramString2, final LinkedList<bmn> paramLinkedList)
  {
    AppMethodBeat.i(205625);
    d.g.b.k.h(paramString1, "appId");
    d.g.b.k.h(paramString2, "url");
    d.g.b.k.h(paramLinkedList, "webCompts");
    final q localq = new q();
    if (this.CSG.isEmpty())
    {
      if (((Collection)paramLinkedList).isEmpty()) {
        break label168;
      }
      i = 1;
      if (i != 0) {
        this.CSw.CQA.a(b.CPW);
      }
    }
    final v.a locala = new v.a();
    locala.KUL = false;
    if (this.CSE)
    {
      locala.KUL = true;
      label103:
      this.CSF = paramString1;
      this.CSE = false;
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
        c.b localb = c.CQN;
        com.tencent.mm.ac.c.b(c.b.eHe(), (a)new a(this, paramLinkedList, localq, paramString1, paramString2, locala));
      }
      AppMethodBeat.o(205625);
      return;
      i = 0;
      break;
      if ((d.g.b.k.g(this.CSF, paramString1) ^ true))
      {
        clear();
        this.CSw.eGR();
        this.CSw.CQA.CSC.clear();
        break label103;
      }
      this.CSw.CQA.a(b.CPX);
      break label103;
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(82969);
    this.CSF = "";
    this.CSE = true;
    this.CSG.clear();
    this.CSw.clear();
    AppMethodBeat.o(82969);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void sendMessage(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82968);
    d.g.b.k.h(paramString1, "webCompt");
    d.g.b.k.h(paramString2, "message");
    c localc = this.CSw;
    d.g.b.k.h(paramString1, "webCompt");
    d.g.b.k.h(paramString2, "message");
    ac.v(c.TAG, "postToBack " + paramString1 + ' ' + paramString2);
    paramString1 = localc.aEf(paramString1);
    if (paramString1 != null) {
      c.c(paramString1, "WeixinWebCompt.onMessage(" + paramString2 + ')');
    }
    localc.CQA.a(b.CQq);
    AppMethodBeat.o(82968);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<y>
  {
    a(k paramk, LinkedList paramLinkedList, q paramq, String paramString1, String paramString2, v.a parama)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<bmn, String>
  {
    public static final b CSL;
    
    static
    {
      AppMethodBeat.i(82964);
      CSL = new b();
      AppMethodBeat.o(82964);
    }
    
    b()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/View$OnLongClickListener;", "invoke"})
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