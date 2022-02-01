package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.etk;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.eus;

public final class c
  extends n<etk, etl>
{
  public c(int paramInt1, long paramLong, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(115222);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new etk();
    ((d.a)localObject).iLO = new etl();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voipcancelinvite";
    ((d.a)localObject).funcId = 171;
    ((d.a)localObject).iLP = 64;
    ((d.a)localObject).respCmdId = 1000000064;
    this.rr = ((d.a)localObject).aXF();
    localObject = (etk)this.rr.iLK.iLR;
    ((etk)localObject).LsZ = paramInt1;
    ((etk)localObject).Lta = paramLong;
    ((etk)localObject).xNG = paramString1;
    ((etk)localObject).MKg = paramInt2;
    paramString1 = new eus();
    dqi localdqi = new dqi();
    localdqi.bhy(paramString2);
    paramString1.NgE = localdqi;
    ((etk)localObject).NqI = paramString1;
    ((etk)localObject).NpN = System.currentTimeMillis();
    ((etk)localObject).NqK = paramInt3;
    AppMethodBeat.o(115222);
  }
  
  public final i fIF()
  {
    AppMethodBeat.i(115224);
    i local1 = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(115221);
        e.Logd("MicroMsg.NetSceneVoipCancelInvite", "onSceneEnd type:" + paramAnonymousq.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
        AppMethodBeat.o(115221);
      }
    };
    AppMethodBeat.o(115224);
    return local1;
  }
  
  public final int fIG()
  {
    AppMethodBeat.i(115223);
    etk localetk = (etk)fIK();
    if ((localetk.LsZ == 0) && (localetk.MKg == 0))
    {
      AppMethodBeat.o(115223);
      return -1;
    }
    AppMethodBeat.o(115223);
    return 0;
  }
  
  public final int getType()
  {
    return 171;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.c
 * JD-Core Version:    0.7.0.1
 */