package com.tencent.mm.plugin.webview.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.c;
import com.tencent.mm.protocal.c.g;
import kotlin.f;
import kotlin.g;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/WebViewUtilKt;", "", "()V", "finishWhenCurrentUrlNull", "", "getFinishWhenCurrentUrlNull", "()Z", "finishWhenCurrentUrlNull$delegate", "Lkotlin/Lazy;", "jumpWeiXinProtocolWithPermission", "getJumpWeiXinProtocolWithPermission", "jumpWeiXinProtocolWithPermission$delegate", "pendingCount", "", "getPendingCount", "()I", "pendingCount$delegate", "pendingOpen", "getPendingOpen", "pendingOpen$delegate", "pendingStartTime", "getPendingStartTime", "pendingStartTime$delegate", "getJsApiFunc", "Lcom/tencent/mm/protocal/ConstantsJSAPIFunc$JSAPI_FUNC;", "func", "", "webview-sdk_release"})
public final class n
{
  public static final f PJm;
  private static final f PJn;
  public static final f PJo;
  public static final f PJp;
  static final f PJq;
  public static final n PJr;
  
  static
  {
    AppMethodBeat.i(205142);
    PJr = new n();
    PJm = g.ar((kotlin.g.a.a)f.PJx);
    PJn = g.ar((kotlin.g.a.a)d.PJv);
    PJo = g.ar((kotlin.g.a.a)e.PJw);
    PJp = g.ar((kotlin.g.a.a)a.PJs);
    PJq = g.ar((kotlin.g.a.a)c.PJu);
    AppMethodBeat.o(205142);
  }
  
  public static c.g bjL(String paramString)
  {
    AppMethodBeat.i(205141);
    if (paramString == null)
    {
      AppMethodBeat.o(205141);
      return null;
    }
    c.g localg = c.bst(paramString);
    Object localObject = localg;
    if (localg == null)
    {
      localObject = com.tencent.mm.plugin.webview.d.q.POB;
      paramString = com.tencent.mm.plugin.webview.d.q.bkj(paramString);
      localObject = localg;
      if (paramString != null) {
        localObject = (c.g)new b(paramString, paramString.fCm(), paramString.fCm(), paramString.fCn());
      }
    }
    AppMethodBeat.o(205141);
    return localObject;
  }
  
  public static int gTe()
  {
    AppMethodBeat.i(205139);
    int i = ((Number)PJn.getValue()).intValue();
    AppMethodBeat.o(205139);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final a PJs;
    
    static
    {
      AppMethodBeat.i(206815);
      PJs = new a();
      AppMethodBeat.o(206815);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/core/WebViewUtilKt$getJsApiFunc$1", "Lcom/tencent/mm/protocal/ConstantsJSAPIFunc$JSAPI_FUNC;", "webview-sdk_release"})
  public static final class b
    extends c.g
  {
    b(com.tencent.mm.plugin.webview.d.c.a parama, String paramString1, String paramString2, int paramInt)
    {
      super(paramString2, paramInt, false);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final c PJu;
    
    static
    {
      AppMethodBeat.i(206992);
      PJu = new c();
      AppMethodBeat.o(206992);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    public static final d PJv;
    
    static
    {
      AppMethodBeat.i(205845);
      PJv = new d();
      AppMethodBeat.o(205845);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final e PJw;
    
    static
    {
      AppMethodBeat.i(214986);
      PJw = new e();
      AppMethodBeat.o(214986);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    public static final f PJx;
    
    static
    {
      AppMethodBeat.i(206267);
      PJx = new f();
      AppMethodBeat.o(206267);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.n
 * JD-Core Version:    0.7.0.1
 */