package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.protocal.protobuf.dyj;
import com.tencent.mm.protocal.protobuf.dzs;
import com.tencent.mm.protocal.protobuf.dzt;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.protocal.protobuf.eai;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;
import java.util.LinkedList;

public final class j
  extends n<eah, eai>
{
  public j(long paramLong1, long paramLong2, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115247);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new eah();
    ((b.a)localObject).hQG = new eai();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipspeedresult";
    ((b.a)localObject).funcId = 901;
    ((b.a)localObject).hQH = 901;
    ((b.a)localObject).respCmdId = 1000000901;
    this.rr = ((b.a)localObject).aDS();
    localObject = (eah)this.rr.hQD.hQJ;
    ((eah)localObject).Igi = paramLong1;
    ((eah)localObject).Gxr = paramLong2;
    ((eah)localObject).GqB = paramInt1;
    ((eah)localObject).Igj = new cxn().aQV(paramString1);
    ((eah)localObject).Igk = new cxn().aQV(paramString2);
    ((eah)localObject).Gax = 0.0D;
    ((eah)localObject).Gay = 0.0D;
    ((eah)localObject).Gxq = paramInt2;
    ((eah)localObject).Igl = paramInt3;
    for (;;)
    {
      try
      {
        paramString1 = (dzt)new dzt().parseFrom(paramArrayOfByte);
        paramInt1 = 0;
        if (paramInt1 >= paramString1.IeW.size()) {
          break;
        }
        paramString2 = new dio();
        paramString2.HPL = ((dzs)paramString1.IeW.get(paramInt1)).IeG;
        paramString2.HPM = ((dzs)paramString1.IeW.get(paramInt1)).IeH;
        paramString2.HPN = ((dzs)paramString1.IeW.get(paramInt1)).IeI;
        paramString2.HPO = new dyj();
        paramString2.HPO.HUj = ((dzs)paramString1.IeW.get(paramInt1)).IeJ;
        paramString2.HPO.Hzv = ((dzs)paramString1.IeW.get(paramInt1)).IeK;
        paramString2.HPO.HUk = ((dzs)paramString1.IeW.get(paramInt1)).IeU;
        paramString2.HPP = ((dzs)paramString1.IeW.get(paramInt1)).IeL;
        paramString2.HPQ = ((dzs)paramString1.IeW.get(paramInt1)).IeM;
        paramString2.HPR = ((dzs)paramString1.IeW.get(paramInt1)).IeN;
        paramString2.HPS = ((dzs)paramString1.IeW.get(paramInt1)).IeP.size();
        paramInt2 = 0;
        if (paramInt2 < paramString2.HPS)
        {
          paramString2.HPT.add(((dzs)paramString1.IeW.get(paramInt1)).IeP.get(paramInt2));
          paramInt2 += 1;
          continue;
        }
        paramString2.HPU = ((dzs)paramString1.IeW.get(paramInt1)).IeQ;
      }
      catch (IOException paramString1)
      {
        ae.printErrStackTrace("MicroMsg.NetSceneVoipSpeedResult", paramString1, "", new Object[0]);
        AppMethodBeat.o(115247);
        return;
      }
      paramInt2 = 0;
      while (paramInt2 < paramString2.HPU)
      {
        paramString2.HPV.add(((dzs)paramString1.IeW.get(paramInt1)).IeR.get(paramInt2));
        paramInt2 += 1;
      }
      paramString2.HPW = ((dzs)paramString1.IeW.get(paramInt1)).IeS;
      paramInt2 = 0;
      while (paramInt2 < paramString2.HPW)
      {
        paramString2.HPX.add(((dzs)paramString1.IeW.get(paramInt1)).IeT.get(paramInt2));
        paramInt2 += 1;
      }
      paramString2.HPY = ((dzs)paramString1.IeW.get(paramInt1)).IeV;
      ((eah)localObject).GSq.add(paramString2);
      com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.NetSceneVoipSpeedResult", "VoipContext NetSceneVoipSpeedResult testid:" + paramLong1 + " roomkey=" + paramLong2 + " ipstr=" + paramString2.HPO.HUk + " client ipstr=" + paramString2.HPY);
      paramInt1 += 1;
    }
    AppMethodBeat.o(115247);
  }
  
  public final com.tencent.mm.ak.f eBL()
  {
    AppMethodBeat.i(115248);
    com.tencent.mm.ak.f local1 = new com.tencent.mm.ak.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(115246);
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.NetSceneVoipSpeedResult", "VoipContext onVoipSpeedResultResp errType=" + paramAnonymousInt1 + " errCode=" + paramAnonymousInt2 + " errMsg=" + paramAnonymousString);
        j.this.CsR.ezy();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.j
 * JD-Core Version:    0.7.0.1
 */