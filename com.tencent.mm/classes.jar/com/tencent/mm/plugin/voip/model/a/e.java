package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dmj;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends n<dmj, dmk>
{
  public e(int paramInt, long paramLong, String paramString)
  {
    AppMethodBeat.i(115230);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new dmj();
    ((b.a)localObject).gUV = new dmk();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipgetroominfo";
    ((b.a)localObject).funcId = 303;
    ((b.a)localObject).reqCmdId = 119;
    ((b.a)localObject).respCmdId = 1000000119;
    this.rr = ((b.a)localObject).atI();
    localObject = (dmj)this.rr.gUS.gUX;
    ((dmj)localObject).DdZ = paramInt;
    ((dmj)localObject).Dea = paramLong;
    ((dmj)localObject).ECd = paramString;
    ((dmj)localObject).mBH = 1;
    ((dmj)localObject).EAY = System.currentTimeMillis();
    AppMethodBeat.o(115230);
  }
  
  public final g dVg()
  {
    AppMethodBeat.i(115232);
    g local1 = new g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(115229);
        com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.GetRoomInfo", "Voip onSceneEnd type:" + paramAnonymousn.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousn != null))
        {
          paramAnonymousString = (dmk)e.this.dVk();
          if ((paramAnonymousString.BaseResponse.Ret == 0) && (!com.tencent.mm.plugin.voip.c.dRQ().zlR.dUR()))
          {
            ad.i("MicroMsg.Voip.GetRoomInfo", "doTaskCallin in NetSceneVoipGetRoomInfo, roomid:%d, roomkey:%s, time:%d", new Object[] { Integer.valueOf(paramAnonymousString.DdZ), Long.valueOf(paramAnonymousString.Dea), Integer.valueOf(paramAnonymousString.CreateTime) });
            com.tencent.mm.plugin.voip.c.dRQ().c(paramAnonymousString);
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
  
  public final void hR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115231);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      dmk localdmk = (dmk)dVk();
      if (localdmk != null) {
        ad.i("MicroMsg.Voip.GetRoomInfo", "roomId:%d, roomKey:%s, memberCount:%d, inviteType:%d", new Object[] { Integer.valueOf(localdmk.DdZ), Long.valueOf(localdmk.Dea), Integer.valueOf(localdmk.fpb), Integer.valueOf(localdmk.EBU) });
      }
      AppMethodBeat.o(115231);
      return;
    }
    ad.i("MicroMsg.Voip.GetRoomInfo", "Get RoomInfo error");
    AppMethodBeat.o(115231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.e
 * JD-Core Version:    0.7.0.1
 */