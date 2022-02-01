package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dht;
import com.tencent.mm.protocal.protobuf.dws;
import com.tencent.mm.protocal.protobuf.dyb;
import com.tencent.mm.protocal.protobuf.dyc;
import com.tencent.mm.protocal.protobuf.dyq;
import com.tencent.mm.protocal.protobuf.dyr;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.util.LinkedList;

public final class j
  extends n<dyq, dyr>
{
  public j(long paramLong1, long paramLong2, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115247);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dyq();
    ((b.a)localObject).hNN = new dyr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipspeedresult";
    ((b.a)localObject).funcId = 901;
    ((b.a)localObject).hNO = 901;
    ((b.a)localObject).respCmdId = 1000000901;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dyq)this.rr.hNK.hNQ;
    ((dyq)localObject).HMb = paramLong1;
    ((dyq)localObject).GeJ = paramLong2;
    ((dyq)localObject).FYc = paramInt1;
    ((dyq)localObject).HMc = new cwt().aPy(paramString1);
    ((dyq)localObject).HMd = new cwt().aPy(paramString2);
    ((dyq)localObject).FIb = 0.0D;
    ((dyq)localObject).FIc = 0.0D;
    ((dyq)localObject).GeI = paramInt2;
    ((dyq)localObject).HMe = paramInt3;
    for (;;)
    {
      try
      {
        paramString1 = (dyc)new dyc().parseFrom(paramArrayOfByte);
        paramInt1 = 0;
        if (paramInt1 >= paramString1.HKO.size()) {
          break;
        }
        paramString2 = new dht();
        paramString2.Hwc = ((dyb)paramString1.HKO.get(paramInt1)).HKy;
        paramString2.Hwd = ((dyb)paramString1.HKO.get(paramInt1)).HKz;
        paramString2.Hwe = ((dyb)paramString1.HKO.get(paramInt1)).HKA;
        paramString2.Hwf = new dws();
        paramString2.Hwf.HAw = ((dyb)paramString1.HKO.get(paramInt1)).HKB;
        paramString2.Hwf.HfV = ((dyb)paramString1.HKO.get(paramInt1)).HKC;
        paramString2.Hwf.HAx = ((dyb)paramString1.HKO.get(paramInt1)).HKM;
        paramString2.Hwg = ((dyb)paramString1.HKO.get(paramInt1)).HKD;
        paramString2.Hwh = ((dyb)paramString1.HKO.get(paramInt1)).HKE;
        paramString2.Hwi = ((dyb)paramString1.HKO.get(paramInt1)).HKF;
        paramString2.Hwj = ((dyb)paramString1.HKO.get(paramInt1)).HKH.size();
        paramInt2 = 0;
        if (paramInt2 < paramString2.Hwj)
        {
          paramString2.Hwk.add(((dyb)paramString1.HKO.get(paramInt1)).HKH.get(paramInt2));
          paramInt2 += 1;
          continue;
        }
        paramString2.Hwl = ((dyb)paramString1.HKO.get(paramInt1)).HKI;
      }
      catch (IOException paramString1)
      {
        ad.printErrStackTrace("MicroMsg.NetSceneVoipSpeedResult", paramString1, "", new Object[0]);
        AppMethodBeat.o(115247);
        return;
      }
      paramInt2 = 0;
      while (paramInt2 < paramString2.Hwl)
      {
        paramString2.Hwm.add(((dyb)paramString1.HKO.get(paramInt1)).HKJ.get(paramInt2));
        paramInt2 += 1;
      }
      paramString2.Hwn = ((dyb)paramString1.HKO.get(paramInt1)).HKK;
      paramInt2 = 0;
      while (paramInt2 < paramString2.Hwn)
      {
        paramString2.Hwo.add(((dyb)paramString1.HKO.get(paramInt1)).HKL.get(paramInt2));
        paramInt2 += 1;
      }
      paramString2.Hwp = ((dyb)paramString1.HKO.get(paramInt1)).HKN;
      ((dyq)localObject).GyQ.add(paramString2);
      com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.NetSceneVoipSpeedResult", "VoipContext NetSceneVoipSpeedResult testid:" + paramLong1 + " roomkey=" + paramLong2 + " ipstr=" + paramString2.Hwf.HAx + " client ipstr=" + paramString2.Hwp);
      paramInt1 += 1;
    }
    AppMethodBeat.o(115247);
  }
  
  public final com.tencent.mm.al.f eyd()
  {
    AppMethodBeat.i(115248);
    com.tencent.mm.al.f local1 = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(115246);
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.NetSceneVoipSpeedResult", "VoipContext onVoipSpeedResultResp errType=" + paramAnonymousInt1 + " errCode=" + paramAnonymousInt2 + " errMsg=" + paramAnonymousString);
        j.this.Cbq.evR();
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