package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.voip.c.e;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.fex;
import com.tencent.mm.protocal.protobuf.fey;
import com.tencent.mm.protocal.protobuf.ffd;

public final class i
  extends n<fex, fey>
{
  private String TAG;
  
  public i(int paramInt, long paramLong, String paramString)
  {
    AppMethodBeat.i(115244);
    this.TAG = "MicroMsg.NetSceneVoipShutDown";
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new fex();
    ((d.a)localObject).lBV = new fey();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voipshutdown";
    ((d.a)localObject).funcId = 173;
    ((d.a)localObject).lBW = 66;
    ((d.a)localObject).respCmdId = 1000000066;
    this.rr = ((d.a)localObject).bgN();
    localObject = (fex)d.b.b(this.rr.lBR);
    ((fex)localObject).Svu = paramInt;
    ((fex)localObject).Svv = paramLong;
    ffd localffd = new ffd();
    eaf localeaf = new eaf();
    localeaf.btQ(paramString);
    localffd.Uti = localeaf;
    ((fex)localObject).UDE = localffd;
    ((fex)localObject).UCJ = System.currentTimeMillis();
    AppMethodBeat.o(115244);
  }
  
  public final com.tencent.mm.an.i gAU()
  {
    AppMethodBeat.i(115245);
    com.tencent.mm.an.i local1 = new com.tencent.mm.an.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(115243);
        e.Logd(i.a(i.this), "onSceneEnd type:" + paramAnonymousq.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
        AppMethodBeat.o(115243);
      }
    };
    AppMethodBeat.o(115245);
    return local1;
  }
  
  public final int getType()
  {
    return 173;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.i
 * JD-Core Version:    0.7.0.1
 */