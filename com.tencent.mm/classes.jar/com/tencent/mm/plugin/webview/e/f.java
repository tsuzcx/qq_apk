package com.tencent.mm.plugin.webview.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "T", "Lcom/tencent/mm/plugin/webview/permission/AuthCallback;", "weakAuthCallback", "Ljava/lang/ref/WeakReference;", "(Ljava/lang/ref/WeakReference;)V", "onAuthEnd", "", "reason", "", "reqUrl", "", "onAuthStart", "onContentRedirect", "content", "onError", "errType", "errCode", "errMsg", "onPermissionUpdate", "fullUrl", "response", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "onProcessResult", "", "(ILjava/lang/String;Ljava/lang/Object;)Z", "onUrlRedirect", "forceRedirect", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f<T>
  implements a<T>
{
  final WeakReference<a<T>> WPx;
  
  public f(WeakReference<a<T>> paramWeakReference)
  {
    AppMethodBeat.i(294834);
    this.WPx = paramWeakReference;
    AppMethodBeat.o(294834);
  }
  
  public final void J(final int paramInt, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(294867);
    d.uiThread((kotlin.g.a.a)new c(this, paramInt, paramString1, paramString2));
    AppMethodBeat.o(294867);
  }
  
  public final void a(final int paramInt1, final String paramString1, final int paramInt2, final int paramInt3, final String paramString2)
  {
    AppMethodBeat.i(294872);
    s.u(paramString1, "reqUrl");
    s.u(paramString2, "errMsg");
    d.uiThread((kotlin.g.a.a)new d(this, paramInt1, paramString1, paramInt2, paramInt3, paramString2));
    AppMethodBeat.o(294872);
  }
  
  public final void a(final int paramInt, final String paramString1, final String paramString2, final T paramT)
  {
    AppMethodBeat.i(294857);
    s.u(paramString1, "reqUrl");
    s.u(paramString2, "fullUrl");
    d.uiThread((kotlin.g.a.a)new e(this, paramInt, paramString1, paramString2, paramT));
    AppMethodBeat.o(294857);
  }
  
  public final void a(final int paramInt, final boolean paramBoolean, final String paramString1, final String paramString2, final T paramT)
  {
    AppMethodBeat.i(294864);
    s.u(paramString1, "reqUrl");
    s.u(paramString2, "fullUrl");
    d.uiThread((kotlin.g.a.a)new f(this, paramInt, paramBoolean, paramString1, paramString2, paramT));
    AppMethodBeat.o(294864);
  }
  
  public final boolean b(int paramInt, String paramString, T paramT)
  {
    AppMethodBeat.i(294850);
    s.u(paramString, "reqUrl");
    a locala = (a)this.WPx.get();
    if ((locala != null) && (locala.b(paramInt, paramString, paramT) == true))
    {
      AppMethodBeat.o(294850);
      return true;
    }
    AppMethodBeat.o(294850);
    return false;
  }
  
  public final void ca(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(294844);
    s.u(paramString, "reqUrl");
    d.uiThread((kotlin.g.a.a)new a(this, paramInt, paramString));
    AppMethodBeat.o(294844);
  }
  
  public final void cb(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(294839);
    s.u(paramString, "reqUrl");
    d.uiThread((kotlin.g.a.a)new b(this, paramInt, paramString));
    AppMethodBeat.o(294839);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(f<T> paramf, int paramInt, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(f<T> paramf, int paramInt, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(f<T> paramf, int paramInt, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(f<T> paramf, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(f<T> paramf, int paramInt, String paramString1, String paramString2, T paramT)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(f<T> paramf, int paramInt, boolean paramBoolean, String paramString1, String paramString2, T paramT)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.f
 * JD-Core Version:    0.7.0.1
 */