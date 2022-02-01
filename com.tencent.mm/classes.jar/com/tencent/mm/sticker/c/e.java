package com.tencent.mm.sticker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.e.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/sticker/task/GetLensInfoTaskImpl;", "Lcom/tencent/mm/sticker/task/GetLensInfoTask;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "lensId", "", "callback", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Ljava/lang/String;Lcom/tencent/mm/sticker/task/GetLensInfoCallback;)V", "plugin-sticker_release"})
public final class e
  extends d
{
  public e(b<com.tencent.mm.vending.e.a> paramb, final String paramString, c paramc)
  {
    super(paramString);
    AppMethodBeat.i(105985);
    Log.i(f.auD(), "GetLensInfoTaskImpl: ".concat(String.valueOf(paramString)));
    chz localchz = com.tencent.mm.sticker.a.a.NOa.biy(paramString);
    if (com.tencent.mm.sticker.a.a.NOa.biz(paramString))
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
    if (localchz != null)
    {
      if (paramc != null)
      {
        paramc.a(0, localchz);
        AppMethodBeat.o(105985);
        return;
      }
      AppMethodBeat.o(105985);
      return;
    }
    paramString = new a(paramString).aYH().aYI().j((com.tencent.mm.vending.c.a)new a(paramc, paramString));
    if (paramb != null) {
      paramString.a(paramb);
    }
    AppMethodBeat.o(105985);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetLensInfoResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(c paramc, String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sticker.c.e
 * JD-Core Version:    0.7.0.1
 */