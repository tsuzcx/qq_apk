package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.protocal.protobuf.dmc;
import com.tencent.mm.protocal.protobuf.dnj;

public final class c
  extends n<dmb, dmc>
{
  public c(int paramInt1, long paramLong, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(115222);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new dmb();
    ((b.a)localObject).gUV = new dmc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipcancelinvite";
    ((b.a)localObject).funcId = 171;
    ((b.a)localObject).reqCmdId = 64;
    ((b.a)localObject).respCmdId = 1000000064;
    this.rr = ((b.a)localObject).atI();
    localObject = (dmb)this.rr.gUS.gUX;
    ((dmb)localObject).DdZ = paramInt1;
    ((dmb)localObject).Dea = paramLong;
    ((dmb)localObject).sdP = paramString1;
    ((dmb)localObject).DYV = paramInt2;
    paramString1 = new dnj();
    cmf localcmf = new cmf();
    localcmf.aEE(paramString2);
    paramString1.EsS = localcmf;
    ((dmb)localObject).EBT = paramString1;
    ((dmb)localObject).EAY = System.currentTimeMillis();
    ((dmb)localObject).EBV = paramInt3;
    AppMethodBeat.o(115222);
  }
  
  public final g dVg()
  {
    AppMethodBeat.i(115224);
    g local1 = new g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(115221);
        com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.NetSceneVoipCancelInvite", "onSceneEnd type:" + paramAnonymousn.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
        AppMethodBeat.o(115221);
      }
    };
    AppMethodBeat.o(115224);
    return local1;
  }
  
  public final int dVh()
  {
    AppMethodBeat.i(115223);
    dmb localdmb = (dmb)dVl();
    if ((localdmb.DdZ == 0) && (localdmb.DYV == 0))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.c
 * JD-Core Version:    0.7.0.1
 */