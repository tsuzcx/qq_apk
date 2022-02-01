package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.dcg;
import com.tencent.mm.protocal.protobuf.dqy;
import com.tencent.mm.protocal.protobuf.dsh;
import com.tencent.mm.protocal.protobuf.dsi;
import com.tencent.mm.protocal.protobuf.dsw;
import com.tencent.mm.protocal.protobuf.dsx;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;
import java.util.LinkedList;

public final class j
  extends n<dsw, dsx>
{
  public j(long paramLong1, long paramLong2, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115247);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dsw();
    ((b.a)localObject).hvu = new dsx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipspeedresult";
    ((b.a)localObject).funcId = 901;
    ((b.a)localObject).reqCmdId = 901;
    ((b.a)localObject).respCmdId = 1000000901;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dsw)this.rr.hvr.hvw;
    ((dsw)localObject).Gbe = paramLong1;
    ((dsw)localObject).Exg = paramLong2;
    ((dsw)localObject).EqS = paramInt1;
    ((dsw)localObject).Gbf = new crm().aJV(paramString1);
    ((dsw)localObject).Gbg = new crm().aJV(paramString2);
    ((dsw)localObject).Ecf = 0.0D;
    ((dsw)localObject).Ecg = 0.0D;
    ((dsw)localObject).Exf = paramInt2;
    ((dsw)localObject).Gbh = paramInt3;
    for (;;)
    {
      try
      {
        paramString1 = (dsi)new dsi().parseFrom(paramArrayOfByte);
        paramInt1 = 0;
        if (paramInt1 >= paramString1.FZS.size()) {
          break;
        }
        paramString2 = new dcg();
        paramString2.FLu = ((dsh)paramString1.FZS.get(paramInt1)).FZC;
        paramString2.FLv = ((dsh)paramString1.FZS.get(paramInt1)).FZD;
        paramString2.FLw = ((dsh)paramString1.FZS.get(paramInt1)).FZE;
        paramString2.FLx = new dqy();
        paramString2.FLx.FPR = ((dsh)paramString1.FZS.get(paramInt1)).FZF;
        paramString2.FLx.FvP = ((dsh)paramString1.FZS.get(paramInt1)).FZG;
        paramString2.FLx.FPS = ((dsh)paramString1.FZS.get(paramInt1)).FZQ;
        paramString2.FLy = ((dsh)paramString1.FZS.get(paramInt1)).FZH;
        paramString2.FLz = ((dsh)paramString1.FZS.get(paramInt1)).FZI;
        paramString2.FLA = ((dsh)paramString1.FZS.get(paramInt1)).FZJ;
        paramString2.FLB = ((dsh)paramString1.FZS.get(paramInt1)).FZL.size();
        paramInt2 = 0;
        if (paramInt2 < paramString2.FLB)
        {
          paramString2.FLC.add(((dsh)paramString1.FZS.get(paramInt1)).FZL.get(paramInt2));
          paramInt2 += 1;
          continue;
        }
        paramString2.FLD = ((dsh)paramString1.FZS.get(paramInt1)).FZM;
      }
      catch (IOException paramString1)
      {
        ac.printErrStackTrace("MicroMsg.NetSceneVoipSpeedResult", paramString1, "", new Object[0]);
        AppMethodBeat.o(115247);
        return;
      }
      paramInt2 = 0;
      while (paramInt2 < paramString2.FLD)
      {
        paramString2.FLE.add(((dsh)paramString1.FZS.get(paramInt1)).FZN.get(paramInt2));
        paramInt2 += 1;
      }
      paramString2.FLF = ((dsh)paramString1.FZS.get(paramInt1)).FZO;
      paramInt2 = 0;
      while (paramInt2 < paramString2.FLF)
      {
        paramString2.FLG.add(((dsh)paramString1.FZS.get(paramInt1)).FZP.get(paramInt2));
        paramInt2 += 1;
      }
      paramString2.FLH = ((dsh)paramString1.FZS.get(paramInt1)).FZR;
      ((dsw)localObject).EPF.add(paramString2);
      d.Logi("MicroMsg.NetSceneVoipSpeedResult", "VoipContext NetSceneVoipSpeedResult testid:" + paramLong1 + " roomkey=" + paramLong2 + " ipstr=" + paramString2.FLx.FPS + " client ipstr=" + paramString2.FLH);
      paramInt1 += 1;
    }
    AppMethodBeat.o(115247);
  }
  
  public final g eks()
  {
    AppMethodBeat.i(115248);
    g local1 = new g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(115246);
        d.Logi("MicroMsg.NetSceneVoipSpeedResult", "VoipContext onVoipSpeedResultResp errType=" + paramAnonymousInt1 + " errCode=" + paramAnonymousInt2 + " errMsg=" + paramAnonymousString);
        j.this.ACr.eig();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.j
 * JD-Core Version:    0.7.0.1
 */