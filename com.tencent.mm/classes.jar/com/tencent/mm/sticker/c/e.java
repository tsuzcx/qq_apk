package com.tencent.mm.sticker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bty;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.e.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/sticker/task/GetLensInfoTaskImpl;", "Lcom/tencent/mm/sticker/task/GetLensInfoTask;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "lensId", "", "callback", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Ljava/lang/String;Lcom/tencent/mm/sticker/task/GetLensInfoCallback;)V", "plugin-sticker_release"})
public final class e
  extends d
{
  public e(b<com.tencent.mm.vending.e.a> paramb, final String paramString, c paramc)
  {
    super(paramString);
    AppMethodBeat.i(105985);
    ad.i(f.aeD(), "GetLensInfoTaskImpl: ".concat(String.valueOf(paramString)));
    bty localbty = com.tencent.mm.sticker.a.a.ImW.aSg(paramString);
    if (com.tencent.mm.sticker.a.a.ImW.aSh(paramString))
    {
      if (paramc != null)
      {
        paramc.a(2, null);
        AppMethodBeat.o(105985);
        return;
      }
      AppMethodBeat.o(105985);
      return;
    }
    if (localbty != null)
    {
      if (paramc != null)
      {
        paramc.a(0, localbty);
        AppMethodBeat.o(105985);
        return;
      }
      AppMethodBeat.o(105985);
      return;
    }
    paramString = new a(paramString).aEC().aED().j((com.tencent.mm.vending.c.a)new a(paramc, paramString));
    if (paramb != null) {
      paramString.a(paramb);
    }
    AppMethodBeat.o(105985);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetLensInfoResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(c paramc, String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.c.e
 * JD-Core Version:    0.7.0.1
 */