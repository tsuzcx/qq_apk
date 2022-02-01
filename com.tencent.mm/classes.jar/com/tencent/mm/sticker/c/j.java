package com.tencent.mm.sticker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/sticker/task/GetLensListTaskImpl;", "Lcom/tencent/mm/sticker/task/GetLensListTask;", "type", "", "pageBuff", "", "lensCtx", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "callback", "Lcom/tencent/mm/sticker/task/GetLensListCallback;", "(I[B[BLcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Lcom/tencent/mm/sticker/task/GetLensListCallback;)V", "plugin-sticker_release"})
public final class j
  extends i
{
  public j(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb, h paramh)
  {
    AppMethodBeat.i(105991);
    paramArrayOfByte1 = new b(paramInt, paramArrayOfByte1, paramArrayOfByte2).aED().j((com.tencent.mm.vending.c.a)new a(paramh));
    if (paramb != null) {
      paramArrayOfByte1.a(paramb);
    }
    AppMethodBeat.o(105991);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetLensListResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(h paramh) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.c.j
 * JD-Core Version:    0.7.0.1
 */