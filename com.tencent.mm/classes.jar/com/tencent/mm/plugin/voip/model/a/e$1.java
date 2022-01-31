package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.b;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.csp;

final class e$1
  implements f
{
  e$1(e parame) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(4709);
    a.Loge("MicroMsg.Voip.GetRoomInfo", "Voip onSceneEnd type:" + paramm.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramm != null))
    {
      paramString = (csp)this.tzN.cOt();
      if ((paramString.BaseResponse.Ret == 0) && (!b.cLC().tyR.cOc())) {
        b.cLC().b(paramString);
      }
    }
    AppMethodBeat.o(4709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.e.1
 * JD-Core Version:    0.7.0.1
 */