package com.tencent.mm.plugin.webview.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "T", "Lcom/tencent/mm/plugin/webview/permission/AuthCallback;", "authCallback", "(Lcom/tencent/mm/plugin/webview/permission/AuthCallback;)V", "onAuthEnd", "", "reason", "", "reqUrl", "", "onAuthStart", "onContentRedirect", "content", "onError", "errType", "errCode", "errMsg", "onPermissionUpdate", "fullUrl", "response", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "onProcessResult", "", "(ILjava/lang/String;Ljava/lang/Object;)Z", "onUrlRedirect", "forceRedirect", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "webview-sdk_release"})
public final class f<T>
  implements a<T>
{
  final a<T> Jcl;
  
  public f(a<T> parama)
  {
    AppMethodBeat.i(225141);
    this.Jcl = parama;
    AppMethodBeat.o(225141);
  }
  
  public final void C(final int paramInt, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(225139);
    d.h((kotlin.g.a.a)new c(this, paramInt, paramString1, paramString2));
    AppMethodBeat.o(225139);
  }
  
  public final void a(final int paramInt1, final String paramString1, final int paramInt2, final int paramInt3, final String paramString2)
  {
    AppMethodBeat.i(225140);
    p.h(paramString1, "reqUrl");
    p.h(paramString2, "errMsg");
    d.h((kotlin.g.a.a)new d(this, paramInt1, paramString1, paramInt2, paramInt3, paramString2));
    AppMethodBeat.o(225140);
  }
  
  public final void a(final int paramInt, final String paramString1, final String paramString2, final T paramT)
  {
    AppMethodBeat.i(225137);
    p.h(paramString1, "reqUrl");
    p.h(paramString2, "fullUrl");
    d.h((kotlin.g.a.a)new e(this, paramInt, paramString1, paramString2, paramT));
    AppMethodBeat.o(225137);
  }
  
  public final void a(final int paramInt, final boolean paramBoolean, final String paramString1, final String paramString2, final T paramT)
  {
    AppMethodBeat.i(225138);
    p.h(paramString1, "reqUrl");
    p.h(paramString2, "fullUrl");
    d.h((kotlin.g.a.a)new f(this, paramInt, paramBoolean, paramString1, paramString2, paramT));
    AppMethodBeat.o(225138);
  }
  
  public final boolean b(int paramInt, String paramString, T paramT)
  {
    AppMethodBeat.i(225136);
    p.h(paramString, "reqUrl");
    boolean bool = this.Jcl.b(paramInt, paramString, paramT);
    AppMethodBeat.o(225136);
    return bool;
  }
  
  public final void bx(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(225135);
    p.h(paramString, "reqUrl");
    d.h((kotlin.g.a.a)new a(this, paramInt, paramString));
    AppMethodBeat.o(225135);
  }
  
  public final void by(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(225134);
    p.h(paramString, "reqUrl");
    d.h((kotlin.g.a.a)new b(this, paramInt, paramString));
    AppMethodBeat.o(225134);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(f paramf, int paramInt, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(f paramf, int paramInt, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(f paramf, int paramInt, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(f paramf, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(f paramf, int paramInt, String paramString1, String paramString2, Object paramObject)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f.f
 * JD-Core Version:    0.7.0.1
 */