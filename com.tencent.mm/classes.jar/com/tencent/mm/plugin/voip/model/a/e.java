package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ets;
import com.tencent.mm.protocal.protobuf.ett;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends n<ets, ett>
{
  public e(int paramInt, long paramLong, String paramString)
  {
    AppMethodBeat.i(115230);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ets();
    ((d.a)localObject).iLO = new ett();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voipgetroominfo";
    ((d.a)localObject).funcId = 303;
    ((d.a)localObject).iLP = 119;
    ((d.a)localObject).respCmdId = 1000000119;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ets)this.rr.iLK.iLR;
    ((ets)localObject).LsZ = paramInt;
    ((ets)localObject).Lta = paramLong;
    ((ets)localObject).NqS = paramString;
    ((ets)localObject).oUv = 1;
    ((ets)localObject).NpN = System.currentTimeMillis();
    AppMethodBeat.o(115230);
  }
  
  public final i fIF()
  {
    AppMethodBeat.i(115232);
    i local1 = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(115229);
        com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.GetRoomInfo", "Voip onSceneEnd type:" + paramAnonymousq.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousq != null))
        {
          paramAnonymousString = (ett)e.this.fIJ();
          if ((paramAnonymousString.BaseResponse.Ret == 0) && (!c.fFg().GYS.fIq()))
          {
            Log.i("MicroMsg.Voip.GetRoomInfo", "doTaskCallin in NetSceneVoipGetRoomInfo, roomid:%d, roomkey:%s, time:%d", new Object[] { Integer.valueOf(paramAnonymousString.LsZ), Long.valueOf(paramAnonymousString.Lta), Integer.valueOf(paramAnonymousString.CreateTime) });
            c.fFg().c(paramAnonymousString);
          }
        }
        AppMethodBeat.o(115229);
      }
    };
    AppMethodBeat.o(115232);
    return local1;
  }
  
  public final int getType()
  {
    return 303;
  }
  
  public final void jC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115231);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ett localett = (ett)fIJ();
      if (localett != null) {
        Log.i("MicroMsg.Voip.GetRoomInfo", "roomId:%d, roomKey:%s, memberCount:%d, inviteType:%d", new Object[] { Integer.valueOf(localett.LsZ), Long.valueOf(localett.Lta), Integer.valueOf(localett.gsq), Integer.valueOf(localett.NqJ) });
      }
      AppMethodBeat.o(115231);
      return;
    }
    Log.i("MicroMsg.Voip.GetRoomInfo", "Get RoomInfo error");
    AppMethodBeat.o(115231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.e
 * JD-Core Version:    0.7.0.1
 */