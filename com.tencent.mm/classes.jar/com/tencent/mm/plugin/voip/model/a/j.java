package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.model.k;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.cfu;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.cte;
import com.tencent.mm.protocal.protobuf.ctf;
import java.util.LinkedList;

public final class j
  extends n<cte, ctf>
{
  public j(long paramLong1, long paramLong2, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(4727);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cte();
    ((b.a)localObject).fsY = new ctf();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipspeedresult";
    ((b.a)localObject).funcId = 901;
    ((b.a)localObject).reqCmdId = 901;
    ((b.a)localObject).respCmdId = 1000000901;
    this.rr = ((b.a)localObject).ado();
    localObject = (cte)this.rr.fsV.fta;
    ((cte)localObject).ycp = paramLong1;
    ((cte)localObject).wQQ = paramLong2;
    ((cte)localObject).wLO = paramInt1;
    ((cte)localObject).ycq = new bwc().aoF(paramString1);
    ((cte)localObject).ycr = new bwc().aoF(paramString2);
    ((cte)localObject).wyO = 0.0D;
    ((cte)localObject).wyP = 0.0D;
    ((cte)localObject).wQP = paramInt2;
    ((cte)localObject).ycs = paramInt3;
    paramInt1 = 0;
    int i = 0;
    while (i < paramInt3)
    {
      paramString1 = new cfu();
      paramInt2 = paramInt1 + 1;
      paramString1.xQb = paramArrayOfInt[paramInt1];
      paramInt1 = paramInt2 + 1;
      paramString1.xQc = paramArrayOfInt[paramInt2];
      paramInt2 = paramInt1 + 1;
      paramString1.xQd = paramArrayOfInt[paramInt1];
      paramString1.xQe = new crm();
      paramString2 = paramString1.xQe;
      paramInt1 = paramInt2 + 1;
      paramString2.xTC = paramArrayOfInt[paramInt2];
      paramString2 = paramString1.xQe;
      paramInt2 = paramInt1 + 1;
      paramString2.xCi = paramArrayOfInt[paramInt1];
      paramInt1 = paramInt2 + 1;
      paramString1.xQf = paramArrayOfInt[paramInt2];
      paramInt2 = paramInt1 + 1;
      paramString1.xQg = paramArrayOfInt[paramInt1];
      int j = paramInt2 + 1;
      paramString1.xQh = paramArrayOfInt[paramInt2];
      paramInt1 = j + 1;
      paramString1.xQi = paramArrayOfInt[j];
      paramInt2 = 0;
      while (paramInt2 < paramString1.xQi)
      {
        j = paramInt1;
        if (paramInt1 < paramArrayOfInt.length)
        {
          paramString1.xQj.add(Integer.valueOf(paramArrayOfInt[paramInt1]));
          j = paramInt1 + 1;
        }
        paramInt2 += 1;
        paramInt1 = j;
      }
      paramInt2 = paramInt1;
      if (paramInt1 < paramArrayOfInt.length)
      {
        paramString1.xQk = paramArrayOfInt[paramInt1];
        paramInt2 = paramInt1 + 1;
      }
      j = 0;
      paramInt1 = paramInt2;
      paramInt2 = j;
      while (paramInt2 < paramString1.xQk)
      {
        j = paramInt1;
        if (paramInt1 < paramArrayOfInt.length)
        {
          paramString1.xQl.add(Integer.valueOf(paramArrayOfInt[paramInt1]));
          j = paramInt1 + 1;
        }
        paramInt2 += 1;
        paramInt1 = j;
      }
      paramInt2 = paramInt1;
      if (paramInt1 < paramArrayOfInt.length)
      {
        paramString1.xQm = paramArrayOfInt[paramInt1];
        paramInt2 = paramInt1 + 1;
      }
      j = 0;
      paramInt1 = paramInt2;
      paramInt2 = j;
      while (paramInt2 < paramString1.xQm)
      {
        j = paramInt1;
        if (paramInt1 < paramArrayOfInt.length)
        {
          paramString1.xQn.add(Integer.valueOf(paramArrayOfInt[paramInt1]));
          j = paramInt1 + 1;
        }
        paramInt2 += 1;
        paramInt1 = j;
      }
      a.Logi("MicroMsg.NetSceneVoipSpeedResult", "SpeedResult: pkt_size[" + paramString1.xQc + "], pkt_count[" + paramString1.xQd + "], svr_ip[" + paramString1.xQe.xTC + "], avg_rtt[" + paramString1.xQf + "], min_rtt[" + paramString1.xQg + "], max_rtt[" + paramString1.xQh + "], rtt_count[" + paramString1.xQi + "], down_seq_count[" + paramString1.xQk + "], up_seq_count[" + paramString1.xQm + "]");
      ((cte)localObject).xcd.add(paramString1);
      i += 1;
    }
    AppMethodBeat.o(4727);
  }
  
  public final f cOp()
  {
    AppMethodBeat.i(4728);
    f local1 = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(4726);
        a.Logi("MicroMsg.NetSceneVoipSpeedResult", "VoipContext onVoipSpeedResultResp errType=" + paramAnonymousInt1 + " errCode=" + paramAnonymousInt2 + " errMsg=" + paramAnonymousString);
        j.this.tvE.cLW();
        AppMethodBeat.o(4726);
      }
    };
    AppMethodBeat.o(4728);
    return local1;
  }
  
  public final int getType()
  {
    return 901;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.j
 * JD-Core Version:    0.7.0.1
 */