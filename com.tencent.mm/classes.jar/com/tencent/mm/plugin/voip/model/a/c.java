package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.drs;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.protocal.protobuf.dta;

public final class c
  extends n<drs, drt>
{
  public c(int paramInt1, long paramLong, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(115222);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new drs();
    ((b.a)localObject).hvu = new drt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipcancelinvite";
    ((b.a)localObject).funcId = 171;
    ((b.a)localObject).reqCmdId = 64;
    ((b.a)localObject).respCmdId = 1000000064;
    this.rr = ((b.a)localObject).aAz();
    localObject = (drs)this.rr.hvr.hvw;
    ((drs)localObject).Exf = paramInt1;
    ((drs)localObject).Exg = paramLong;
    ((drs)localObject).tlJ = paramString1;
    ((drs)localObject).FvR = paramInt2;
    paramString1 = new dta();
    crm localcrm = new crm();
    localcrm.aJV(paramString2);
    paramString1.FPU = localcrm;
    ((drs)localObject).FZg = paramString1;
    ((drs)localObject).FYl = System.currentTimeMillis();
    ((drs)localObject).FZi = paramInt3;
    AppMethodBeat.o(115222);
  }
  
  public final g eks()
  {
    AppMethodBeat.i(115224);
    g local1 = new g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(115221);
        d.Logd("MicroMsg.NetSceneVoipCancelInvite", "onSceneEnd type:" + paramAnonymousn.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
        AppMethodBeat.o(115221);
      }
    };
    AppMethodBeat.o(115224);
    return local1;
  }
  
  public final int ekt()
  {
    AppMethodBeat.i(115223);
    drs localdrs = (drs)ekx();
    if ((localdrs.Exf == 0) && (localdrs.FvR == 0))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.c
 * JD-Core Version:    0.7.0.1
 */