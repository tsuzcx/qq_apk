package com.tencent.mm.plugin.webview.l;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.protocal.protobuf.ddx;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptTagJsApiHandler;", "", "jsapi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;)V", "debugInfo", "", "getDebugInfo", "()Ljava/lang/String;", "debugListener", "Landroid/view/View$OnLongClickListener;", "getDebugListener", "()Landroid/view/View$OnLongClickListener;", "debugListener$delegate", "Lkotlin/Lazy;", "firstTimeConfig", "", "lastAppId", "webComponent", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "webComptSettings", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "clear", "", "config", "appId", "url", "webCompts", "Ljava/util/LinkedList;", "dispatchEvent", "webCompt", "event", "message", "getInterceptResponse", "Lcom/tencent/xweb/WebResourceResponse;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "sendMessage", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  private final com.tencent.mm.plugin.webview.jsapi.j WlX;
  private final kotlin.j XwA;
  final c Xws;
  private boolean Xwx;
  String Xwy;
  final HashMap<String, ddx> Xwz;
  
  public j(com.tencent.mm.plugin.webview.jsapi.j paramj)
  {
    AppMethodBeat.i(295407);
    this.WlX = paramj;
    this.Xws = new c(new WeakReference(this.WlX));
    this.Xwx = true;
    this.Xwy = "";
    this.Xwz = new HashMap();
    this.XwA = kotlin.k.cm((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(295407);
  }
  
  public final void bw(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(295429);
    kotlin.g.b.s.u(paramString1, "webCompt");
    kotlin.g.b.s.u(paramString2, "event");
    this.Xws.bw(paramString1, paramString2, paramString3);
    AppMethodBeat.o(295429);
  }
  
  public final void c(final String paramString1, final String paramString2, LinkedList<ddx> paramLinkedList)
  {
    AppMethodBeat.i(295448);
    kotlin.g.b.s.u(paramString1, "appId");
    kotlin.g.b.s.u(paramString2, "url");
    kotlin.g.b.s.u(paramLinkedList, "webCompts");
    if (paramLinkedList.isEmpty())
    {
      paramString1 = c.XuL;
      Log.w(c.access$getTAG$cp(), "webCompt is null");
      AppMethodBeat.o(295448);
      return;
    }
    final com.tencent.mm.pluginsdk.s locals = new com.tencent.mm.pluginsdk.s();
    if (this.Xwz.isEmpty())
    {
      if (((Collection)paramLinkedList).isEmpty()) {
        break label187;
      }
      i = 1;
      if (i != 0) {
        this.Xws.XuN.a(b.Xug);
      }
    }
    final ah.a locala = new ah.a();
    if (this.Xwx)
    {
      locala.aiwY = true;
      label122:
      this.Xwy = paramString1;
      this.Xwx = false;
      if (((Collection)paramLinkedList).isEmpty()) {
        break label247;
      }
    }
    label187:
    label247:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        c.b localb = c.XuL;
        d.d(c.access$getTAG$cp(), (kotlin.g.a.a)new a(paramLinkedList, this, locals, paramString1, paramString2, locala));
      }
      AppMethodBeat.o(295448);
      return;
      i = 0;
      break;
      if (!kotlin.g.b.s.p(this.Xwy, paramString1))
      {
        clear();
        this.Xws.iDb();
        this.Xws.XuN.Xww.clear();
        break label122;
      }
      this.Xws.XuN.a(b.Xuh);
      break label122;
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(82969);
    this.Xwy = "";
    this.Xwx = true;
    this.Xwz.clear();
    this.Xws.clear();
    AppMethodBeat.o(82969);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void sendMessage(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82968);
    kotlin.g.b.s.u(paramString1, "webCompt");
    kotlin.g.b.s.u(paramString2, "message");
    c localc = this.Xws;
    kotlin.g.b.s.u(paramString1, "webCompt");
    kotlin.g.b.s.u(paramString2, "message");
    Log.v(c.TAG, "postToBack " + paramString1 + ' ' + paramString2);
    paramString1 = localc.bng(paramString1);
    if (paramString1 != null) {
      c.c(paramString1, "WeixinWebCompt.onMessage(" + paramString2 + ')');
    }
    localc.XuN.a(b.XuA);
    AppMethodBeat.o(82968);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(LinkedList<ddx> paramLinkedList, j paramj, com.tencent.mm.pluginsdk.s params, String paramString1, String paramString2, ah.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<ddx, CharSequence>
  {
    public static final b XwE;
    
    static
    {
      AppMethodBeat.i(82964);
      XwE = new b();
      AppMethodBeat.o(82964);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View$OnLongClickListener;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<View.OnLongClickListener>
  {
    c(j paramj)
    {
      super();
    }
    
    private static final boolean a(j paramj, View paramView)
    {
      AppMethodBeat.i(295443);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramj);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/webcompt/WebComptTagJsApiHandler$debugListener$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
      kotlin.g.b.s.u(paramj, "this$0");
      if (!n.bp((CharSequence)paramj.Xwy)) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool)
        {
          paramView = paramView.getContext();
          localObject = new StringBuilder("[webCompts]\n            ");
          paramj = paramj.Xwz.values();
          kotlin.g.b.s.s(paramj, "webComptSettings.values");
          paramj = ((StringBuilder)localObject).append(p.a((Iterable)paramj, (CharSequence)"\n\n", null, null, 0, null, (kotlin.g.a.b)j.b.XwE, 30)).append("\n\n            ");
          localObject = c.XuL;
          com.tencent.mm.ui.base.k.c(paramView, n.bJB(c.b.gca() + "\n            "), "", true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(bool, new Object(), "com/tencent/mm/plugin/webview/webcompt/WebComptTagJsApiHandler$debugListener$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(295443);
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.j
 * JD-Core Version:    0.7.0.1
 */