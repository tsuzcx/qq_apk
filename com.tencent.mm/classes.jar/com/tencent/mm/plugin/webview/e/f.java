package com.tencent.mm.plugin.webview.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "T", "Lcom/tencent/mm/plugin/webview/permission/AuthCallback;", "authCallback", "(Lcom/tencent/mm/plugin/webview/permission/AuthCallback;)V", "onAuthEnd", "", "reason", "", "reqUrl", "", "onAuthStart", "onContentRedirect", "content", "onError", "errType", "errCode", "errMsg", "onPermissionUpdate", "fullUrl", "response", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "onProcessResult", "", "(ILjava/lang/String;Ljava/lang/Object;)Z", "onUrlRedirect", "webview-sdk_release"})
public final class f<T>
  implements a<T>
{
  final a<T> Ctx;
  
  public f(a<T> parama)
  {
    AppMethodBeat.i(205557);
    this.Ctx = parama;
    AppMethodBeat.o(205557);
  }
  
  public final void A(final int paramInt, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(205555);
    c.g((d.g.a.a)new c(this, paramInt, paramString1, paramString2));
    AppMethodBeat.o(205555);
  }
  
  public final void a(final int paramInt1, final String paramString1, final int paramInt2, final int paramInt3, final String paramString2)
  {
    AppMethodBeat.i(205556);
    k.h(paramString1, "reqUrl");
    k.h(paramString2, "errMsg");
    c.g((d.g.a.a)new d(this, paramInt1, paramString1, paramInt2, paramInt3, paramString2));
    AppMethodBeat.o(205556);
  }
  
  public final void a(final int paramInt, final String paramString1, final String paramString2, final T paramT)
  {
    AppMethodBeat.i(205553);
    k.h(paramString1, "reqUrl");
    k.h(paramString2, "fullUrl");
    c.g((d.g.a.a)new e(this, paramInt, paramString1, paramString2, paramT));
    AppMethodBeat.o(205553);
  }
  
  public final void b(final int paramInt, final String paramString1, final String paramString2, final T paramT)
  {
    AppMethodBeat.i(205554);
    k.h(paramString1, "reqUrl");
    k.h(paramString2, "fullUrl");
    c.g((d.g.a.a)new f(this, paramInt, paramString1, paramString2, paramT));
    AppMethodBeat.o(205554);
  }
  
  public final boolean b(int paramInt, String paramString, T paramT)
  {
    AppMethodBeat.i(205552);
    k.h(paramString, "reqUrl");
    boolean bool = this.Ctx.b(paramInt, paramString, paramT);
    AppMethodBeat.o(205552);
    return bool;
  }
  
  public final void bj(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(205551);
    k.h(paramString, "reqUrl");
    c.g((d.g.a.a)new a(this, paramInt, paramString));
    AppMethodBeat.o(205551);
  }
  
  public final void bk(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(205550);
    k.h(paramString, "reqUrl");
    c.g((d.g.a.a)new b(this, paramInt, paramString));
    AppMethodBeat.o(205550);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    a(f paramf, int paramInt, String paramString)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(f paramf, int paramInt, String paramString)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(f paramf, int paramInt, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(f paramf, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(f paramf, int paramInt, String paramString1, String paramString2, Object paramObject)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(f paramf, int paramInt, String paramString1, String paramString2, Object paramObject)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.f
 * JD-Core Version:    0.7.0.1
 */