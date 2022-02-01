package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dxu;
import com.tencent.mm.protocal.protobuf.dxv;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends n<dxu, dxv>
{
  public e(int paramInt, long paramLong, String paramString)
  {
    AppMethodBeat.i(115230);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dxu();
    ((b.a)localObject).hNN = new dxv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipgetroominfo";
    ((b.a)localObject).funcId = 303;
    ((b.a)localObject).hNO = 119;
    ((b.a)localObject).respCmdId = 1000000119;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dxu)this.rr.hNK.hNQ;
    ((dxu)localObject).GeI = paramInt;
    ((dxu)localObject).GeJ = paramLong;
    ((dxu)localObject).HKm = paramString;
    ((dxu)localObject).nEf = 1;
    ((dxu)localObject).HJh = System.currentTimeMillis();
    AppMethodBeat.o(115230);
  }
  
  public final com.tencent.mm.al.f eyd()
  {
    AppMethodBeat.i(115232);
    com.tencent.mm.al.f local1 = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(115229);
        com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.GetRoomInfo", "Voip onSceneEnd type:" + paramAnonymousn.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousn != null))
        {
          paramAnonymousString = (dxv)e.this.eyh();
          if ((paramAnonymousString.BaseResponse.Ret == 0) && (!c.euM().CdF.exO()))
          {
            ad.i("MicroMsg.Voip.GetRoomInfo", "doTaskCallin in NetSceneVoipGetRoomInfo, roomid:%d, roomkey:%s, time:%d", new Object[] { Integer.valueOf(paramAnonymousString.GeI), Long.valueOf(paramAnonymousString.GeJ), Integer.valueOf(paramAnonymousString.CreateTime) });
            c.euM().c(paramAnonymousString);
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
  
  public final void it(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115231);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      dxv localdxv = (dxv)eyh();
      if (localdxv != null) {
        ad.i("MicroMsg.Voip.GetRoomInfo", "roomId:%d, roomKey:%s, memberCount:%d, inviteType:%d", new Object[] { Integer.valueOf(localdxv.GeI), Long.valueOf(localdxv.GeJ), Integer.valueOf(localdxv.fLb), Integer.valueOf(localdxv.HKd) });
      }
      AppMethodBeat.o(115231);
      return;
    }
    ad.i("MicroMsg.Voip.GetRoomInfo", "Get RoomInfo error");
    AppMethodBeat.o(115231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.e
 * JD-Core Version:    0.7.0.1
 */