package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dsa;
import com.tencent.mm.protocal.protobuf.dsb;
import com.tencent.mm.sdk.platformtools.ac;

public final class e
  extends n<dsa, dsb>
{
  public e(int paramInt, long paramLong, String paramString)
  {
    AppMethodBeat.i(115230);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dsa();
    ((b.a)localObject).hvu = new dsb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipgetroominfo";
    ((b.a)localObject).funcId = 303;
    ((b.a)localObject).reqCmdId = 119;
    ((b.a)localObject).respCmdId = 1000000119;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dsa)this.rr.hvr.hvw;
    ((dsa)localObject).Exf = paramInt;
    ((dsa)localObject).Exg = paramLong;
    ((dsa)localObject).FZq = paramString;
    ((dsa)localObject).ndI = 1;
    ((dsa)localObject).FYl = System.currentTimeMillis();
    AppMethodBeat.o(115230);
  }
  
  public final g eks()
  {
    AppMethodBeat.i(115232);
    g local1 = new g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(115229);
        d.Loge("MicroMsg.Voip.GetRoomInfo", "Voip onSceneEnd type:" + paramAnonymousn.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousn != null))
        {
          paramAnonymousString = (dsb)e.this.ekw();
          if ((paramAnonymousString.BaseResponse.Ret == 0) && (!c.ehb().AEF.ekd()))
          {
            ac.i("MicroMsg.Voip.GetRoomInfo", "doTaskCallin in NetSceneVoipGetRoomInfo, roomid:%d, roomkey:%s, time:%d", new Object[] { Integer.valueOf(paramAnonymousString.Exf), Long.valueOf(paramAnonymousString.Exg), Integer.valueOf(paramAnonymousString.CreateTime) });
            c.ehb().c(paramAnonymousString);
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
  
  public final void ig(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115231);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      dsb localdsb = (dsb)ekw();
      if (localdsb != null) {
        ac.i("MicroMsg.Voip.GetRoomInfo", "roomId:%d, roomKey:%s, memberCount:%d, inviteType:%d", new Object[] { Integer.valueOf(localdsb.Exf), Long.valueOf(localdsb.Exg), Integer.valueOf(localdsb.fsB), Integer.valueOf(localdsb.FZh) });
      }
      AppMethodBeat.o(115231);
      return;
    }
    ac.i("MicroMsg.Voip.GetRoomInfo", "Get RoomInfo error");
    AppMethodBeat.o(115231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.e
 * JD-Core Version:    0.7.0.1
 */