package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dzl;
import com.tencent.mm.protocal.protobuf.dzm;
import com.tencent.mm.sdk.platformtools.ae;

public final class e
  extends n<dzl, dzm>
{
  public e(int paramInt, long paramLong, String paramString)
  {
    AppMethodBeat.i(115230);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dzl();
    ((b.a)localObject).hQG = new dzm();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipgetroominfo";
    ((b.a)localObject).funcId = 303;
    ((b.a)localObject).hQH = 119;
    ((b.a)localObject).respCmdId = 1000000119;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dzl)this.rr.hQD.hQJ;
    ((dzl)localObject).Gxq = paramInt;
    ((dzl)localObject).Gxr = paramLong;
    ((dzl)localObject).Ieu = paramString;
    ((dzl)localObject).nJA = 1;
    ((dzl)localObject).Idp = System.currentTimeMillis();
    AppMethodBeat.o(115230);
  }
  
  public final com.tencent.mm.ak.f eBL()
  {
    AppMethodBeat.i(115232);
    com.tencent.mm.ak.f local1 = new com.tencent.mm.ak.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(115229);
        com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.GetRoomInfo", "Voip onSceneEnd type:" + paramAnonymousn.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousn != null))
        {
          paramAnonymousString = (dzm)e.this.eBP();
          if ((paramAnonymousString.BaseResponse.Ret == 0) && (!c.eys().Cvg.eBw()))
          {
            ae.i("MicroMsg.Voip.GetRoomInfo", "doTaskCallin in NetSceneVoipGetRoomInfo, roomid:%d, roomkey:%s, time:%d", new Object[] { Integer.valueOf(paramAnonymousString.Gxq), Long.valueOf(paramAnonymousString.Gxr), Integer.valueOf(paramAnonymousString.CreateTime) });
            c.eys().c(paramAnonymousString);
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
  
  public final void ix(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115231);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      dzm localdzm = (dzm)eBP();
      if (localdzm != null) {
        ae.i("MicroMsg.Voip.GetRoomInfo", "roomId:%d, roomKey:%s, memberCount:%d, inviteType:%d", new Object[] { Integer.valueOf(localdzm.Gxq), Long.valueOf(localdzm.Gxr), Integer.valueOf(localdzm.fNf), Integer.valueOf(localdzm.Iel) });
      }
      AppMethodBeat.o(115231);
      return;
    }
    ae.i("MicroMsg.Voip.GetRoomInfo", "Get RoomInfo error");
    AppMethodBeat.o(115231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.e
 * JD-Core Version:    0.7.0.1
 */