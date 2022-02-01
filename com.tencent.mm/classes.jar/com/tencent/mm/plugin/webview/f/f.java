package com.tencent.mm.plugin.webview.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "T", "Lcom/tencent/mm/plugin/webview/permission/AuthCallback;", "weakAuthCallback", "Ljava/lang/ref/WeakReference;", "(Ljava/lang/ref/WeakReference;)V", "onAuthEnd", "", "reason", "", "reqUrl", "", "onAuthStart", "onContentRedirect", "content", "onError", "errType", "errCode", "errMsg", "onPermissionUpdate", "fullUrl", "response", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "onProcessResult", "", "(ILjava/lang/String;Ljava/lang/Object;)Z", "onUrlRedirect", "forceRedirect", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "webview-sdk_release"})
public final class f<T>
  implements a<T>
{
  final WeakReference<a<T>> PYT;
  
  public f(WeakReference<a<T>> paramWeakReference)
  {
    AppMethodBeat.i(207223);
    this.PYT = paramWeakReference;
    AppMethodBeat.o(207223);
  }
  
  public final void F(final int paramInt, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(207221);
    d.uiThread((kotlin.g.a.a)new c(this, paramInt, paramString1, paramString2));
    AppMethodBeat.o(207221);
  }
  
  public final void a(final int paramInt1, final String paramString1, final int paramInt2, final int paramInt3, final String paramString2)
  {
    AppMethodBeat.i(207222);
    p.k(paramString1, "reqUrl");
    p.k(paramString2, "errMsg");
    d.uiThread((kotlin.g.a.a)new d(this, paramInt1, paramString1, paramInt2, paramInt3, paramString2));
    AppMethodBeat.o(207222);
  }
  
  public final void a(final int paramInt, final String paramString1, final String paramString2, final T paramT)
  {
    AppMethodBeat.i(207219);
    p.k(paramString1, "reqUrl");
    p.k(paramString2, "fullUrl");
    d.uiThread((kotlin.g.a.a)new e(this, paramInt, paramString1, paramString2, paramT));
    AppMethodBeat.o(207219);
  }
  
  public final void a(final int paramInt, final boolean paramBoolean, final String paramString1, final String paramString2, final T paramT)
  {
    AppMethodBeat.i(207220);
    p.k(paramString1, "reqUrl");
    p.k(paramString2, "fullUrl");
    d.uiThread((kotlin.g.a.a)new f(this, paramInt, paramBoolean, paramString1, paramString2, paramT));
    AppMethodBeat.o(207220);
  }
  
  public final boolean b(int paramInt, String paramString, T paramT)
  {
    AppMethodBeat.i(207218);
    p.k(paramString, "reqUrl");
    a locala = (a)this.PYT.get();
    if ((locala != null) && (locala.b(paramInt, paramString, paramT) == true))
    {
      AppMethodBeat.o(207218);
      return true;
    }
    AppMethodBeat.o(207218);
    return false;
  }
  
  public final void bu(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(207217);
    p.k(paramString, "reqUrl");
    d.uiThread((kotlin.g.a.a)new a(this, paramInt, paramString));
    AppMethodBeat.o(207217);
  }
  
  public final void bv(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(207215);
    p.k(paramString, "reqUrl");
    d.uiThread((kotlin.g.a.a)new b(this, paramInt, paramString));
    AppMethodBeat.o(207215);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(f paramf, int paramInt, String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(f paramf, int paramInt, String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(f paramf, int paramInt, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(f paramf, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(f paramf, int paramInt, String paramString1, String paramString2, Object paramObject)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(f paramf, int paramInt, boolean paramBoolean, String paramString1, String paramString2, Object paramObject)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f.f
 * JD-Core Version:    0.7.0.1
 */