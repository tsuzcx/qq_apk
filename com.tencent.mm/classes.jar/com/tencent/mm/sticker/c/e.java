package com.tencent.mm.sticker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bus;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vending.e.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/sticker/task/GetLensInfoTaskImpl;", "Lcom/tencent/mm/sticker/task/GetLensInfoTask;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "lensId", "", "callback", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Ljava/lang/String;Lcom/tencent/mm/sticker/task/GetLensInfoCallback;)V", "plugin-sticker_release"})
public final class e
  extends d
{
  public e(b<com.tencent.mm.vending.e.a> paramb, final String paramString, c paramc)
  {
    super(paramString);
    AppMethodBeat.i(105985);
    ae.i(f.aeP(), "GetLensInfoTaskImpl: ".concat(String.valueOf(paramString)));
    bus localbus = com.tencent.mm.sticker.a.a.IHh.aTD(paramString);
    if (com.tencent.mm.sticker.a.a.IHh.aTE(paramString))
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
    if (localbus != null)
    {
      if (paramc != null)
      {
        paramc.a(0, localbus);
        AppMethodBeat.o(105985);
        return;
      }
      AppMethodBeat.o(105985);
      return;
    }
    paramString = new a(paramString).aES().aET().j((com.tencent.mm.vending.c.a)new a(paramc, paramString));
    if (paramb != null) {
      paramString.a(paramb);
    }
    AppMethodBeat.o(105985);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetLensInfoResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(c paramc, String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sticker.c.e
 * JD-Core Version:    0.7.0.1
 */