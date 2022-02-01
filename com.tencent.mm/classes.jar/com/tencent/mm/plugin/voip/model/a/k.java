package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.eca;
import com.tencent.mm.protocal.protobuf.euq;
import com.tencent.mm.protocal.protobuf.eur;

public final class k
  extends n<euq, eur>
{
  public k(eca parameca)
  {
    AppMethodBeat.i(115250);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new euq();
    ((d.a)localObject).iLO = new eur();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voipspeedtest";
    ((d.a)localObject).funcId = 765;
    ((d.a)localObject).iLP = 765;
    ((d.a)localObject).respCmdId = 1000000765;
    this.rr = ((d.a)localObject).aXF();
    localObject = (euq)this.rr.iLK.iLR;
    ((euq)localObject).LsZ = parameca.LsZ;
    ((euq)localObject).NbR = parameca.NbR;
    ((euq)localObject).Llx = parameca.Llx;
    ((euq)localObject).NbS = parameca.NbS;
    ((euq)localObject).NbT = parameca.NbT;
    ((euq)localObject).NbU = parameca.NbU;
    ((euq)localObject).NbV = parameca.NbV;
    ((euq)localObject).NbW = parameca.NbW;
    ((euq)localObject).NbX = parameca.NbX;
    ((euq)localObject).NbY = parameca.NbY;
    ((euq)localObject).NbZ = parameca.NbZ;
    ((euq)localObject).Nca = parameca.Nca;
    ((euq)localObject).Ncb = parameca.Ncb;
    AppMethodBeat.o(115250);
  }
  
  public final i fIF()
  {
    AppMethodBeat.i(115251);
    i local1 = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(115249);
        e.Logd("MicroMsg.NetSceneVoipSpeedTest", "onSceneEnd type:" + paramAnonymousq.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
        try
        {
          paramAnonymousString = (eur)k.this.fIJ();
          if ((paramAnonymousString.NsK == 0) || (paramAnonymousString.NsL == 0))
          {
            e.Loge("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, svrCount = " + paramAnonymousString.NsL);
            AppMethodBeat.o(115249);
            return;
          }
          if (k.this.GWA.GVA != 1)
          {
            e.Loge("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, for mSpeedTestStatus = " + k.this.GWA.GVA);
            AppMethodBeat.o(115249);
            return;
          }
          k.this.GWA.GVA = 2;
          k.this.GWA.GVC = paramAnonymousString.NsG;
          k.this.GWA.GVV.a(paramAnonymousString);
          AppMethodBeat.o(115249);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          k.this.GWA.GVA = 0;
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