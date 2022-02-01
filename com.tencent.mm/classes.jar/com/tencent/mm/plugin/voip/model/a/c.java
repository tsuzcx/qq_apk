package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dzd;
import com.tencent.mm.protocal.protobuf.dze;
import com.tencent.mm.protocal.protobuf.eal;

public final class c
  extends n<dzd, dze>
{
  public c(int paramInt1, long paramLong, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(115222);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dzd();
    ((b.a)localObject).hQG = new dze();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipcancelinvite";
    ((b.a)localObject).funcId = 171;
    ((b.a)localObject).hQH = 64;
    ((b.a)localObject).respCmdId = 1000000064;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dzd)this.rr.hQD.hQJ;
    ((dzd)localObject).Gxq = paramInt1;
    ((dzd)localObject).Gxr = paramLong;
    ((dzd)localObject).uvF = paramString1;
    ((dzd)localObject).Hzx = paramInt2;
    paramString1 = new eal();
    cxn localcxn = new cxn();
    localcxn.aQV(paramString2);
    paramString1.HUm = localcxn;
    ((dzd)localObject).Iek = paramString1;
    ((dzd)localObject).Idp = System.currentTimeMillis();
    ((dzd)localObject).Iem = paramInt3;
    AppMethodBeat.o(115222);
  }
  
  public final com.tencent.mm.ak.f eBL()
  {
    AppMethodBeat.i(115224);
    com.tencent.mm.ak.f local1 = new com.tencent.mm.ak.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(115221);
        com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.NetSceneVoipCancelInvite", "onSceneEnd type:" + paramAnonymousn.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
        AppMethodBeat.o(115221);
      }
    };
    AppMethodBeat.o(115224);
    return local1;
  }
  
  public final int eBM()
  {
    AppMethodBeat.i(115223);
    dzd localdzd = (dzd)eBQ();
    if ((localdzd.Gxq == 0) && (localdzd.Hzx == 0))
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