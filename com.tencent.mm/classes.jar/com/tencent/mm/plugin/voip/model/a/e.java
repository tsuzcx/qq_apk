package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.protocal.protobuf.fed;
import com.tencent.mm.protocal.protobuf.fee;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends n<fed, fee>
{
  public e(int paramInt, long paramLong, String paramString)
  {
    AppMethodBeat.i(115230);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new fed();
    ((d.a)localObject).lBV = new fee();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voipgetroominfo";
    ((d.a)localObject).funcId = 303;
    ((d.a)localObject).lBW = 119;
    ((d.a)localObject).respCmdId = 1000000119;
    this.rr = ((d.a)localObject).bgN();
    localObject = (fed)d.b.b(this.rr.lBR);
    ((fed)localObject).Svu = paramInt;
    ((fed)localObject).Svv = paramLong;
    ((fed)localObject).UDO = paramString;
    ((fed)localObject).rWu = 1;
    ((fed)localObject).UCJ = System.currentTimeMillis();
    AppMethodBeat.o(115230);
  }
  
  public final i gAU()
  {
    AppMethodBeat.i(115232);
    i local1 = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(115229);
        com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.GetRoomInfo", "Voip onSceneEnd type:" + paramAnonymousq.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousq != null))
        {
          paramAnonymousString = (fee)e.this.gAY();
          if ((paramAnonymousString.BaseResponse.CqV == 0) && (!c.gxs().NPf.gAK()))
          {
            Log.i("MicroMsg.Voip.GetRoomInfo", "doTaskCallin in NetSceneVoipGetRoomInfo, roomid:%d, roomkey:%s, time:%d", new Object[] { Integer.valueOf(paramAnonymousString.Svu), Long.valueOf(paramAnonymousString.Svv), Integer.valueOf(paramAnonymousString.CreateTime) });
            c.gxs().c(paramAnonymousString);
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
  
  public final void kQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115231);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      fee localfee = (fee)gAY();
      if (localfee != null) {
        Log.i("MicroMsg.Voip.GetRoomInfo", "roomId:%d, roomKey:%s, memberCount:%d, inviteType:%d", new Object[] { Integer.valueOf(localfee.Svu), Long.valueOf(localfee.Svv), Integer.valueOf(localfee.iWB), Integer.valueOf(localfee.UDF) });
      }
      AppMethodBeat.o(115231);
      return;
    }
    Log.i("MicroMsg.Voip.GetRoomInfo", "Get RoomInfo error");
    AppMethodBeat.o(115231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.e
 * JD-Core Version:    0.7.0.1
 */