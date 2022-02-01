package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.eby;
import com.tencent.mm.protocal.protobuf.esq;
import com.tencent.mm.protocal.protobuf.etz;
import com.tencent.mm.protocal.protobuf.eua;
import com.tencent.mm.protocal.protobuf.euo;
import com.tencent.mm.protocal.protobuf.eup;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.LinkedList;

public final class j
  extends n<euo, eup>
{
  public j(long paramLong1, long paramLong2, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115247);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new euo();
    ((d.a)localObject).iLO = new eup();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voipspeedresult";
    ((d.a)localObject).funcId = 901;
    ((d.a)localObject).iLP = 901;
    ((d.a)localObject).respCmdId = 1000000901;
    this.rr = ((d.a)localObject).aXF();
    localObject = (euo)this.rr.iLK.iLR;
    ((euo)localObject).NsG = paramLong1;
    ((euo)localObject).Lta = paramLong2;
    ((euo)localObject).Llx = paramInt1;
    ((euo)localObject).NsH = new dqi().bhy(paramString1);
    ((euo)localObject).NsI = new dqi().bhy(paramString2);
    ((euo)localObject).KUt = 0.0D;
    ((euo)localObject).KUu = 0.0D;
    ((euo)localObject).LsZ = paramInt2;
    ((euo)localObject).NsJ = paramInt3;
    for (;;)
    {
      try
      {
        paramString1 = (eua)new eua().parseFrom(paramArrayOfByte);
        paramInt1 = 0;
        if (paramInt1 >= paramString1.Nru.size()) {
          break;
        }
        paramString2 = new eby();
        paramString2.NbD = ((etz)paramString1.Nru.get(paramInt1)).Nre;
        paramString2.NbE = ((etz)paramString1.Nru.get(paramInt1)).Nrf;
        paramString2.NbF = ((etz)paramString1.Nru.get(paramInt1)).Nrg;
        paramString2.NbG = new esq();
        paramString2.NbG.NgB = ((etz)paramString1.Nru.get(paramInt1)).Nrh;
        paramString2.NbG.MKe = ((etz)paramString1.Nru.get(paramInt1)).Nri;
        paramString2.NbG.NgC = ((etz)paramString1.Nru.get(paramInt1)).Nrs;
        paramString2.NbH = ((etz)paramString1.Nru.get(paramInt1)).Nrj;
        paramString2.NbI = ((etz)paramString1.Nru.get(paramInt1)).Nrk;
        paramString2.NbJ = ((etz)paramString1.Nru.get(paramInt1)).Nrl;
        paramString2.NbK = ((etz)paramString1.Nru.get(paramInt1)).Nrn.size();
        paramInt2 = 0;
        if (paramInt2 < paramString2.NbK)
        {
          paramString2.NbL.add(((etz)paramString1.Nru.get(paramInt1)).Nrn.get(paramInt2));
          paramInt2 += 1;
          continue;
        }
        paramString2.NbM = ((etz)paramString1.Nru.get(paramInt1)).Nro;
      }
      catch (IOException paramString1)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneVoipSpeedResult", paramString1, "", new Object[0]);
        AppMethodBeat.o(115247);
        return;
      }
      paramInt2 = 0;
      while (paramInt2 < paramString2.NbM)
      {
        paramString2.NbN.add(((etz)paramString1.Nru.get(paramInt1)).Nrp.get(paramInt2));
        paramInt2 += 1;
      }
      paramString2.NbO = ((etz)paramString1.Nru.get(paramInt1)).Nrq;
      paramInt2 = 0;
      while (paramInt2 < paramString2.NbO)
      {
        paramString2.NbP.add(((etz)paramString1.Nru.get(paramInt1)).Nrr.get(paramInt2));
        paramInt2 += 1;
      }
      paramString2.NbQ = ((etz)paramString1.Nru.get(paramInt1)).Nrt;
      ((euo)localObject).LWv.add(paramString2);
      e.Logi("MicroMsg.NetSceneVoipSpeedResult", "VoipContext NetSceneVoipSpeedResult testid:" + paramLong1 + " roomkey=" + paramLong2 + " ipstr=" + paramString2.NbG.NgC + " client ipstr=" + paramString2.NbQ);
      paramInt1 += 1;
    }
    AppMethodBeat.o(115247);
  }
  
  public final i fIF()
  {
    AppMethodBeat.i(115248);
    i local1 = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(115246);
        e.Logi("MicroMsg.NetSceneVoipSpeedResult", "VoipContext onVoipSpeedResultResp errType=" + paramAnonymousInt1 + " errCode=" + paramAnonymousInt2 + " errMsg=" + paramAnonymousString);
        j.this.GWA.fGo();
        AppMethodBeat.o(115246);
      }
    };
    AppMethodBeat.o(115248);
    return local1;
  }
  
  public final int getType()
  {
    return 901;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.j
 * JD-Core Version:    0.7.0.1
 */