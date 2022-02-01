package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
final class y$f
  implements aa.a
{
  public static final f NQd;
  
  static
  {
    AppMethodBeat.i(212585);
    NQd = new f();
    AppMethodBeat.o(212585);
  }
  
  public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
  {
    AppMethodBeat.i(212584);
    Log.i("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult callback errType = " + paramInt1 + ", errCode=" + paramInt2);
    AppMethodBeat.o(212584);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.y.f
 * JD-Core Version:    0.7.0.1
 */