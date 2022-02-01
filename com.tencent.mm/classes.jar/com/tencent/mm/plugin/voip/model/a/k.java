package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.diq;
import com.tencent.mm.protocal.protobuf.eaj;
import com.tencent.mm.protocal.protobuf.eak;

public final class k
  extends n<eaj, eak>
{
  public k(diq paramdiq)
  {
    AppMethodBeat.i(115250);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new eaj();
    ((b.a)localObject).hQG = new eak();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipspeedtest";
    ((b.a)localObject).funcId = 765;
    ((b.a)localObject).hQH = 765;
    ((b.a)localObject).respCmdId = 1000000765;
    this.rr = ((b.a)localObject).aDS();
    localObject = (eaj)this.rr.hQD.hQJ;
    ((eaj)localObject).Gxq = paramdiq.Gxq;
    ((eaj)localObject).HPZ = paramdiq.HPZ;
    ((eaj)localObject).GqB = paramdiq.GqB;
    ((eaj)localObject).HQa = paramdiq.HQa;
    ((eaj)localObject).HQb = paramdiq.HQb;
    ((eaj)localObject).HQc = paramdiq.HQc;
    ((eaj)localObject).HQd = paramdiq.HQd;
    ((eaj)localObject).HQe = paramdiq.HQe;
    ((eaj)localObject).HQf = paramdiq.HQf;
    ((eaj)localObject).HQg = paramdiq.HQg;
    ((eaj)localObject).HQh = paramdiq.HQh;
    ((eaj)localObject).HQi = paramdiq.HQi;
    ((eaj)localObject).HQj = paramdiq.HQj;
    AppMethodBeat.o(115250);
  }
  
  public final com.tencent.mm.ak.f eBL()
  {
    AppMethodBeat.i(115251);
    com.tencent.mm.ak.f local1 = new com.tencent.mm.ak.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(115249);
        com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.NetSceneVoipSpeedTest", "onSceneEnd type:" + paramAnonymousn.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
        try
        {
          paramAnonymousString = (eak)k.this.eBP();
          if ((paramAnonymousString.Igm == 0) || (paramAnonymousString.Ign == 0))
          {
            com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, svrCount = " + paramAnonymousString.Ign);
            AppMethodBeat.o(115249);
            return;
          }
          if (k.this.CsR.CrO != 1)
          {
            com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, for mSpeedTestStatus = " + k.this.CsR.CrO);
            AppMethodBeat.o(115249);
            return;
          }
          k.this.CsR.CrO = 2;
          k.this.CsR.CrQ = paramAnonymousString.Igi;
          k.this.CsR.Csj.a(paramAnonymousString);
          AppMethodBeat.o(115249);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          k.this.CsR.CrO = 0;
          AppMethodBeat.o(115249);
        }
      }
    };
    AppMethodBeat.o(115251);
    return local1;
  }
  
  public final int getType()
  {
    return 765;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.k
 * JD-Core Version:    0.7.0.1
 */