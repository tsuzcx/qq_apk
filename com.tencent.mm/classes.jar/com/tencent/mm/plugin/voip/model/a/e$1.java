package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.protocal.protobuf.gaq;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;

final class e$1
  implements h
{
  e$1(e parame) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(115229);
    g.Loge("MicroMsg.Voip.GetRoomInfo", "Voip onSceneEnd type:" + paramp.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramp != null))
    {
      paramString = (gaq)this.UDb.hYX();
      if ((paramString.BaseResponse.Idd == 0) && (!SubCoreVoip.hVp().UBE.hYK()))
      {
        Log.i("MicroMsg.Voip.GetRoomInfo", "doTaskCallin in NetSceneVoipGetRoomInfo, roomid:%d, roomkey:%s, time:%d", new Object[] { Integer.valueOf(paramString.Zvz), Long.valueOf(paramString.ZvA), Integer.valueOf(paramString.CreateTime) });
        SubCoreVoip.hVp().c(paramString);
      }
    }
    AppMethodBeat.o(115229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.e.1
 * JD-Core Version:    0.7.0.1
 */