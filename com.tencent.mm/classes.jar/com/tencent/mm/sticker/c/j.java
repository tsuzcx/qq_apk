package com.tencent.mm.sticker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.e.a;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/task/GetLensListTaskImpl;", "Lcom/tencent/mm/sticker/task/GetLensListTask;", "type", "", "pageBuff", "", "lensCtx", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "callback", "Lcom/tencent/mm/sticker/task/GetLensListCallback;", "(I[B[BLcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Lcom/tencent/mm/sticker/task/GetLensListCallback;)V", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends i
{
  public j(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, com.tencent.mm.vending.e.b<a> paramb, h paramh)
  {
    AppMethodBeat.i(105991);
    paramArrayOfByte1 = new b(paramInt, paramArrayOfByte1, paramArrayOfByte2).bFJ().j(new j..ExternalSyntheticLambda0(paramh));
    if (paramb != null) {
      paramArrayOfByte1.a(paramb);
    }
    AppMethodBeat.o(105991);
  }
  
  private static final ah a(h paramh, b.a parama)
  {
    AppMethodBeat.i(233900);
    Log.i(k.aUw(), "cgi callback : " + parama.errType + ' ' + parama.errCode);
    if (paramh == null)
    {
      AppMethodBeat.o(233900);
      return null;
    }
    paramh.a(parama.errType, parama.errCode, (cmf)parama.ott);
    paramh = ah.aiuX;
    AppMethodBeat.o(233900);
    return paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sticker.c.j
 * JD-Core Version:    0.7.0.1
 */