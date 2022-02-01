package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.fgs;
import com.tencent.mm.protocal.protobuf.fzn;
import com.tencent.mm.protocal.protobuf.gaw;
import com.tencent.mm.protocal.protobuf.gax;
import com.tencent.mm.protocal.protobuf.gbl;
import com.tencent.mm.protocal.protobuf.gbm;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.LinkedList;

public final class j
  extends n<gbl, gbm>
{
  public j(long paramLong1, long paramLong2, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115247);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new gbl();
    ((c.a)localObject).otF = new gbm();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/voipspeedresult";
    ((c.a)localObject).funcId = 901;
    ((c.a)localObject).otG = 901;
    ((c.a)localObject).respCmdId = 1000000901;
    this.rr = ((c.a)localObject).bEF();
    localObject = (gbl)c.b.b(this.rr.otB);
    ((gbl)localObject).abZN = paramLong1;
    ((gbl)localObject).ZvA = paramLong2;
    ((gbl)localObject).ZkT = paramInt1;
    ((gbl)localObject).abZO = new etl().btH(paramString1);
    ((gbl)localObject).abZP = new etl().btH(paramString2);
    ((gbl)localObject).YTc = 0.0D;
    ((gbl)localObject).YTd = 0.0D;
    ((gbl)localObject).Zvz = paramInt2;
    ((gbl)localObject).abZQ = paramInt3;
    for (;;)
    {
      try
      {
        paramString1 = (gax)new gax().parseFrom(paramArrayOfByte);
        paramInt1 = 0;
        if (paramInt1 >= paramString1.abYB.size()) {
          break;
        }
        paramString2 = new fgs();
        paramString2.abGB = ((gaw)paramString1.abYB.get(paramInt1)).abYl;
        paramString2.abGC = ((gaw)paramString1.abYB.get(paramInt1)).abYm;
        paramString2.abGD = ((gaw)paramString1.abYB.get(paramInt1)).abYn;
        paramString2.abGE = new fzn();
        paramString2.abGE.abMm = ((gaw)paramString1.abYB.get(paramInt1)).abYo;
        paramString2.abGE.abmN = ((gaw)paramString1.abYB.get(paramInt1)).abYp;
        paramString2.abGE.abMn = ((gaw)paramString1.abYB.get(paramInt1)).abYz;
        paramString2.abGF = ((gaw)paramString1.abYB.get(paramInt1)).abYq;
        paramString2.abGG = ((gaw)paramString1.abYB.get(paramInt1)).abYr;
        paramString2.abGH = ((gaw)paramString1.abYB.get(paramInt1)).abYs;
        paramString2.abGI = ((gaw)paramString1.abYB.get(paramInt1)).abYu.size();
        paramInt2 = 0;
        if (paramInt2 < paramString2.abGI)
        {
          paramString2.abGJ.add((Integer)((gaw)paramString1.abYB.get(paramInt1)).abYu.get(paramInt2));
          paramInt2 += 1;
          continue;
        }
        paramString2.abGK = ((gaw)paramString1.abYB.get(paramInt1)).abYv;
      }
      catch (IOException paramString1)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneVoipSpeedResult", paramString1, "", new Object[0]);
        AppMethodBeat.o(115247);
        return;
      }
      paramInt2 = 0;
      while (paramInt2 < paramString2.abGK)
      {
        paramString2.abGL.add((Integer)((gaw)paramString1.abYB.get(paramInt1)).abYw.get(paramInt2));
        paramInt2 += 1;
      }
      paramString2.abGM = ((gaw)paramString1.abYB.get(paramInt1)).abYx;
      paramInt2 = 0;
      while (paramInt2 < paramString2.abGM)
      {
        paramString2.abGN.add((Integer)((gaw)paramString1.abYB.get(paramInt1)).abYy.get(paramInt2));
        paramInt2 += 1;
      }
      paramString2.abGO = ((gaw)paramString1.abYB.get(paramInt1)).abYA;
      ((gbl)localObject).aasW.add(paramString2);
      g.Logi("MicroMsg.NetSceneVoipSpeedResult", "VoipContext NetSceneVoipSpeedResult testid:" + paramLong1 + " roomkey=" + paramLong2 + " ipstr=" + paramString2.abGE.abMn + " client ipstr=" + paramString2.abGO);
      paramInt1 += 1;
    }
    AppMethodBeat.o(115247);
  }
  
  public final int getType()
  {
    return 901;
  }
  
  public final h hYT()
  {
    AppMethodBeat.i(115248);
    h local1 = new h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(115246);
        g.Logi("MicroMsg.NetSceneVoipSpeedResult", "VoipContext onVoipSpeedResultResp errType=" + paramAnonymousInt1 + " errCode=" + paramAnonymousInt2 + " errMsg=" + paramAnonymousString);
        j.this.UzB.hWw();
        AppMethodBeat.o(115246);
      }
    };
    AppMethodBeat.o(115248);
    return local1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.j
 * JD-Core Version:    0.7.0.1
 */