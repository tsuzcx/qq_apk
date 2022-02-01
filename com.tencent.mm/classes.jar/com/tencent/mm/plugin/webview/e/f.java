package com.tencent.mm.plugin.webview.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "T", "Lcom/tencent/mm/plugin/webview/permission/AuthCallback;", "authCallback", "(Lcom/tencent/mm/plugin/webview/permission/AuthCallback;)V", "onAuthEnd", "", "reason", "", "reqUrl", "", "onAuthStart", "onContentRedirect", "content", "onError", "errType", "errCode", "errMsg", "onPermissionUpdate", "fullUrl", "response", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "onProcessResult", "", "(ILjava/lang/String;Ljava/lang/Object;)Z", "onUrlRedirect", "forceRedirect", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "webview-sdk_release"})
public final class f<T>
  implements a<T>
{
  final a<T> DXd;
  
  public f(a<T> parama)
  {
    AppMethodBeat.i(214346);
    this.DXd = parama;
    AppMethodBeat.o(214346);
  }
  
  public final void a(final int paramInt1, final String paramString1, final int paramInt2, final int paramInt3, final String paramString2)
  {
    AppMethodBeat.i(214345);
    p.h(paramString1, "reqUrl");
    p.h(paramString2, "errMsg");
    c.g((d.g.a.a)new d(this, paramInt1, paramString1, paramInt2, paramInt3, paramString2));
    AppMethodBeat.o(214345);
  }
  
  public final void a(final int paramInt, final String paramString1, final String paramString2, final T paramT)
  {
    AppMethodBeat.i(214342);
    p.h(paramString1, "reqUrl");
    p.h(paramString2, "fullUrl");
    c.g((d.g.a.a)new e(this, paramInt, paramString1, paramString2, paramT));
    AppMethodBeat.o(214342);
  }
  
  public final void a(final int paramInt, final boolean paramBoolean, final String paramString1, final String paramString2, final T paramT)
  {
    AppMethodBeat.i(214343);
    p.h(paramString1, "reqUrl");
    p.h(paramString2, "fullUrl");
    c.g((d.g.a.a)new f(this, paramInt, paramBoolean, paramString1, paramString2, paramT));
    AppMethodBeat.o(214343);
  }
  
  public final boolean b(int paramInt, String paramString, T paramT)
  {
    AppMethodBeat.i(214341);
    p.h(paramString, "reqUrl");
    boolean bool = this.DXd.b(paramInt, paramString, paramT);
    AppMethodBeat.o(214341);
    return bool;
  }
  
  public final void bm(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(214340);
    p.h(paramString, "reqUrl");
    c.g((d.g.a.a)new a(this, paramInt, paramString));
    AppMethodBeat.o(214340);
  }
  
  public final void bn(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(214339);
    p.h(paramString, "reqUrl");
    c.g((d.g.a.a)new b(this, paramInt, paramString));
    AppMethodBeat.o(214339);
  }
  
  public final void z(final int paramInt, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(214344);
    c.g((d.g.a.a)new c(this, paramInt, paramString1, paramString2));
    AppMethodBeat.o(214344);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    a(f paramf, int paramInt, String paramString)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(f paramf, int paramInt, String paramString)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(f paramf, int paramInt, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    d(f paramf, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<z>
  {
    e(f paramf, int paramInt, String paramString1, String paramString2, Object paramObject)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    f(f paramf, int paramInt, boolean paramBoolean, String paramString1, String paramString2, Object paramObject)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.f
 * JD-Core Version:    0.7.0.1
 */