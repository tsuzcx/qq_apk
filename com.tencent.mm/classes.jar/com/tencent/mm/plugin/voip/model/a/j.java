package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cwu;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.protocal.protobuf.dmq;
import com.tencent.mm.protocal.protobuf.dmr;
import com.tencent.mm.protocal.protobuf.dnf;
import com.tencent.mm.protocal.protobuf.dng;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.util.LinkedList;

public final class j
  extends n<dnf, dng>
{
  public j(long paramLong1, long paramLong2, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115247);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new dnf();
    ((b.a)localObject).gUV = new dng();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipspeedresult";
    ((b.a)localObject).funcId = 901;
    ((b.a)localObject).reqCmdId = 901;
    ((b.a)localObject).respCmdId = 1000000901;
    this.rr = ((b.a)localObject).atI();
    localObject = (dnf)this.rr.gUS.gUX;
    ((dnf)localObject).EDR = paramLong1;
    ((dnf)localObject).Dea = paramLong2;
    ((dnf)localObject).CYi = paramInt1;
    ((dnf)localObject).EDS = new cmf().aEE(paramString1);
    ((dnf)localObject).EDT = new cmf().aEE(paramString2);
    ((dnf)localObject).CJD = 0.0D;
    ((dnf)localObject).CJE = 0.0D;
    ((dnf)localObject).DdZ = paramInt2;
    ((dnf)localObject).EDU = paramInt3;
    for (;;)
    {
      try
      {
        paramString1 = (dmr)new dmr().parseFrom(paramArrayOfByte);
        paramInt1 = 0;
        if (paramInt1 >= paramString1.ECF.size()) {
          break;
        }
        paramString2 = new cwu();
        paramString2.Eov = ((dmq)paramString1.ECF.get(paramInt1)).ECp;
        paramString2.Eow = ((dmq)paramString1.ECF.get(paramInt1)).ECq;
        paramString2.Eox = ((dmq)paramString1.ECF.get(paramInt1)).ECr;
        paramString2.Eoy = new dlh();
        paramString2.Eoy.EsP = ((dmq)paramString1.ECF.get(paramInt1)).ECs;
        paramString2.Eoy.DYT = ((dmq)paramString1.ECF.get(paramInt1)).ECt;
        paramString2.Eoy.EsQ = ((dmq)paramString1.ECF.get(paramInt1)).ECD;
        paramString2.Eoz = ((dmq)paramString1.ECF.get(paramInt1)).ECu;
        paramString2.EoA = ((dmq)paramString1.ECF.get(paramInt1)).ECv;
        paramString2.EoB = ((dmq)paramString1.ECF.get(paramInt1)).ECw;
        paramString2.EoC = ((dmq)paramString1.ECF.get(paramInt1)).ECy.size();
        paramInt2 = 0;
        if (paramInt2 < paramString2.EoC)
        {
          paramString2.EoD.add(((dmq)paramString1.ECF.get(paramInt1)).ECy.get(paramInt2));
          paramInt2 += 1;
          continue;
        }
        paramString2.EoE = ((dmq)paramString1.ECF.get(paramInt1)).ECz;
      }
      catch (IOException paramString1)
      {
        ad.printErrStackTrace("MicroMsg.NetSceneVoipSpeedResult", paramString1, "", new Object[0]);
        AppMethodBeat.o(115247);
        return;
      }
      paramInt2 = 0;
      while (paramInt2 < paramString2.EoE)
      {
        paramString2.EoF.add(((dmq)paramString1.ECF.get(paramInt1)).ECA.get(paramInt2));
        paramInt2 += 1;
      }
      paramString2.EoG = ((dmq)paramString1.ECF.get(paramInt1)).ECB;
      paramInt2 = 0;
      while (paramInt2 < paramString2.EoG)
      {
        paramString2.EoH.add(((dmq)paramString1.ECF.get(paramInt1)).ECC.get(paramInt2));
        paramInt2 += 1;
      }
      paramString2.EoI = ((dmq)paramString1.ECF.get(paramInt1)).ECE;
      ((dnf)localObject).Duw.add(paramString2);
      c.Logi("MicroMsg.NetSceneVoipSpeedResult", "VoipContext NetSceneVoipSpeedResult testid:" + paramLong1 + " roomkey=" + paramLong2 + " ipstr=" + paramString2.Eoy.EsQ + " client ipstr=" + paramString2.EoI);
      paramInt1 += 1;
    }
    AppMethodBeat.o(115247);
  }
  
  public final g dVg()
  {
    AppMethodBeat.i(115248);
    g local1 = new g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(115246);
        c.Logi("MicroMsg.NetSceneVoipSpeedResult", "VoipContext onVoipSpeedResultResp errType=" + paramAnonymousInt1 + " errCode=" + paramAnonymousInt2 + " errMsg=" + paramAnonymousString);
        j.this.zjH.dSU();
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