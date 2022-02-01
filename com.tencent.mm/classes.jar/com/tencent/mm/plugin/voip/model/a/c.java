package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.voip.c.e;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.fdv;
import com.tencent.mm.protocal.protobuf.fdw;
import com.tencent.mm.protocal.protobuf.ffd;

public final class c
  extends n<fdv, fdw>
{
  public c(int paramInt1, long paramLong, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(115222);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new fdv();
    ((d.a)localObject).lBV = new fdw();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voipcancelinvite";
    ((d.a)localObject).funcId = 171;
    ((d.a)localObject).lBW = 64;
    ((d.a)localObject).respCmdId = 1000000064;
    this.rr = ((d.a)localObject).bgN();
    localObject = (fdv)d.b.b(this.rr.lBR);
    ((fdv)localObject).Svu = paramInt1;
    ((fdv)localObject).Svv = paramLong;
    ((fdv)localObject).CRQ = paramString1;
    ((fdv)localObject).TWa = paramInt2;
    paramString1 = new ffd();
    eaf localeaf = new eaf();
    localeaf.btQ(paramString2);
    paramString1.Uti = localeaf;
    ((fdv)localObject).UDE = paramString1;
    ((fdv)localObject).UCJ = System.currentTimeMillis();
    ((fdv)localObject).UDG = paramInt3;
    AppMethodBeat.o(115222);
  }
  
  public final i gAU()
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
  
  public final int gAV()
  {
    AppMethodBeat.i(115223);
    fdv localfdv = (fdv)gAZ();
    if ((localfdv.Svu == 0) && (localfdv.TWa == 0))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.c
 * JD-Core Version:    0.7.0.1
 */