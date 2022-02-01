package com.tencent.mm.plugin.webview.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.jsapi.s;
import com.tencent.mm.protocal.c;
import com.tencent.mm.protocal.c.g;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/WebViewUtilKt;", "", "()V", "finishWhenCurrentUrlNull", "", "getFinishWhenCurrentUrlNull", "()Z", "finishWhenCurrentUrlNull$delegate", "Lkotlin/Lazy;", "jumpWeiXinProtocolWithPermission", "getJumpWeiXinProtocolWithPermission", "jumpWeiXinProtocolWithPermission$delegate", "pendingCount", "", "getPendingCount", "()I", "pendingCount$delegate", "pendingOpen", "getPendingOpen", "pendingOpen$delegate", "pendingStartTime", "getPendingStartTime", "pendingStartTime$delegate", "getJsApiFunc", "Lcom/tencent/mm/protocal/ConstantsJSAPIFunc$JSAPI_FUNC;", "func", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
{
  public static final p WzF;
  private static final j WzG;
  private static final j WzH;
  private static final j WzI;
  private static final j WzJ;
  private static final j WzK;
  
  static
  {
    AppMethodBeat.i(295111);
    WzF = new p();
    WzG = k.cm((kotlin.g.a.a)f.WzP);
    WzH = k.cm((kotlin.g.a.a)d.WzN);
    WzI = k.cm((kotlin.g.a.a)e.WzO);
    WzJ = k.cm((kotlin.g.a.a)a.WzL);
    WzK = k.cm((kotlin.g.a.a)c.WzM);
    AppMethodBeat.o(295111);
  }
  
  public static c.g bjx(String paramString)
  {
    AppMethodBeat.i(295106);
    if (paramString == null)
    {
      AppMethodBeat.o(295106);
      return null;
    }
    c.g localg = c.bsk(paramString);
    Object localObject = localg;
    if (localg == null)
    {
      localObject = s.WEN;
      paramString = s.bjT(paramString);
      localObject = localg;
      if (paramString != null) {
        localObject = (c.g)new b(paramString.gPX(), paramString.gPX(), paramString.gPZ());
      }
    }
    AppMethodBeat.o(295106);
    return localObject;
  }
  
  public static int isP()
  {
    AppMethodBeat.i(295080);
    int i = ((Number)WzG.getValue()).intValue();
    AppMethodBeat.o(295080);
    return i;
  }
  
  public static int isQ()
  {
    AppMethodBeat.i(295084);
    int i = ((Number)WzH.getValue()).intValue();
    AppMethodBeat.o(295084);
    return i;
  }
  
  public static boolean isR()
  {
    AppMethodBeat.i(295089);
    boolean bool = ((Boolean)WzI.getValue()).booleanValue();
    AppMethodBeat.o(295089);
    return bool;
  }
  
  public static boolean isS()
  {
    AppMethodBeat.i(295093);
    boolean bool = ((Boolean)WzJ.getValue()).booleanValue();
    AppMethodBeat.o(295093);
    return bool;
  }
  
  public static boolean isT()
  {
    AppMethodBeat.i(295097);
    boolean bool = ((Boolean)WzK.getValue()).booleanValue();
    AppMethodBeat.o(295097);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    public static final a WzL;
    
    static
    {
      AppMethodBeat.i(295055);
      WzL = new a();
      AppMethodBeat.o(295055);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/core/WebViewUtilKt$getJsApiFunc$1", "Lcom/tencent/mm/protocal/ConstantsJSAPIFunc$JSAPI_FUNC;", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends c.g
  {
    b(String paramString1, String paramString2, int paramInt)
    {
      super(paramString2, paramInt, false);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    public static final c WzM;
    
    static
    {
      AppMethodBeat.i(295057);
      WzM = new c();
      AppMethodBeat.o(295057);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final d WzN;
    
    static
    {
      AppMethodBeat.i(295068);
      WzN = new d();
      AppMethodBeat.o(295068);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    public static final e WzO;
    
    static
    {
      AppMethodBeat.i(295062);
      WzO = new e();
      AppMethodBeat.o(295062);
    }
    
    e()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final f WzP;
    
    static
    {
      AppMethodBeat.i(295060);
      WzP = new f();
      AppMethodBeat.o(295060);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.p
 * JD-Core Version:    0.7.0.1
 */