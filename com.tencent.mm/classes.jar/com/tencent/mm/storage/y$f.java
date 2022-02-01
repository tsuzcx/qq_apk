package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.q;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
final class y$f
  implements aa.a
{
  public static final f VdV;
  
  static
  {
    AppMethodBeat.i(206500);
    VdV = new f();
    AppMethodBeat.o(206500);
  }
  
  public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
  {
    AppMethodBeat.i(206497);
    Log.i("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult callback errType = " + paramInt1 + ", errCode=" + paramInt2);
    AppMethodBeat.o(206497);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.y.f
 * JD-Core Version:    0.7.0.1
 */