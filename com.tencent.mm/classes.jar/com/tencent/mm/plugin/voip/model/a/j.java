package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bve;
import com.tencent.mm.protocal.c.ceb;
import com.tencent.mm.protocal.c.cft;
import com.tencent.mm.protocal.c.cfu;
import java.util.LinkedList;

public final class j
  extends n<cft, cfu>
{
  public j(long paramLong1, long paramLong2, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new cft();
    ((b.a)localObject).ecI = new cfu();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipspeedresult";
    ((b.a)localObject).ecG = 901;
    ((b.a)localObject).ecJ = 901;
    ((b.a)localObject).ecK = 1000000901;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (cft)this.dmK.ecE.ecN;
    ((cft)localObject).tUY = paramLong1;
    ((cft)localObject).sSU = paramLong2;
    ((cft)localObject).sNU = paramInt1;
    ((cft)localObject).tUZ = new bml().YI(paramString1);
    ((cft)localObject).tVa = new bml().YI(paramString2);
    ((cft)localObject).sDm = 0.0D;
    ((cft)localObject).sDn = 0.0D;
    ((cft)localObject).sST = paramInt2;
    ((cft)localObject).tVb = paramInt3;
    paramInt1 = 0;
    int i = 0;
    while (i < paramInt3)
    {
      paramString1 = new bve();
      paramInt2 = paramInt1 + 1;
      paramString1.tLy = paramArrayOfInt[paramInt1];
      paramInt1 = paramInt2 + 1;
      paramString1.tLz = paramArrayOfInt[paramInt2];
      paramInt2 = paramInt1 + 1;
      paramString1.tLA = paramArrayOfInt[paramInt1];
      paramString1.tLB = new ceb();
      paramString2 = paramString1.tLB;
      paramInt1 = paramInt2 + 1;
      paramString2.tNg = paramArrayOfInt[paramInt2];
      paramString2 = paramString1.tLB;
      paramInt2 = paramInt1 + 1;
      paramString2.tAA = paramArrayOfInt[paramInt1];
      paramInt1 = paramInt2 + 1;
      paramString1.tLC = paramArrayOfInt[paramInt2];
      paramInt2 = paramInt1 + 1;
      paramString1.tLD = paramArrayOfInt[paramInt1];
      int j = paramInt2 + 1;
      paramString1.tLE = paramArrayOfInt[paramInt2];
      paramInt1 = j + 1;
      paramString1.tLF = paramArrayOfInt[j];
      paramInt2 = 0;
      while (paramInt2 < paramString1.tLF)
      {
        j = paramInt1;
        if (paramInt1 < paramArrayOfInt.length)
        {
          paramString1.tLG.add(Integer.valueOf(paramArrayOfInt[paramInt1]));
          j = paramInt1 + 1;
        }
        paramInt2 += 1;
        paramInt1 = j;
      }
      paramInt2 = paramInt1;
      if (paramInt1 < paramArrayOfInt.length)
      {
        paramString1.tLH = paramArrayOfInt[paramInt1];
        paramInt2 = paramInt1 + 1;
      }
      j = 0;
      paramInt1 = paramInt2;
      paramInt2 = j;
      while (paramInt2 < paramString1.tLH)
      {
        j = paramInt1;
        if (paramInt1 < paramArrayOfInt.length)
        {
          paramString1.tLI.add(Integer.valueOf(paramArrayOfInt[paramInt1]));
          j = paramInt1 + 1;
        }
        paramInt2 += 1;
        paramInt1 = j;
      }
      paramInt2 = paramInt1;
      if (paramInt1 < paramArrayOfInt.length)
      {
        paramString1.tLJ = paramArrayOfInt[paramInt1];
        paramInt2 = paramInt1 + 1;
      }
      j = 0;
      paramInt1 = paramInt2;
      paramInt2 = j;
      while (paramInt2 < paramString1.tLJ)
      {
        j = paramInt1;
        if (paramInt1 < paramArrayOfInt.length)
        {
          paramString1.tLK.add(Integer.valueOf(paramArrayOfInt[paramInt1]));
          j = paramInt1 + 1;
        }
        paramInt2 += 1;
        paramInt1 = j;
      }
      a.Logi("MicroMsg.NetSceneVoipSpeedResult", "SpeedResult: pkt_size[" + paramString1.tLz + "], pkt_count[" + paramString1.tLA + "], svr_ip[" + paramString1.tLB.tNg + "], avg_rtt[" + paramString1.tLC + "], min_rtt[" + paramString1.tLD + "], max_rtt[" + paramString1.tLE + "], rtt_count[" + paramString1.tLF + "], down_seq_count[" + paramString1.tLH + "], up_seq_count[" + paramString1.tLJ + "]");
      ((cft)localObject).tee.add(paramString1);
      i += 1;
    }
  }
  
  public final f bRy()
  {
    return new j.1(this);
  }
  
  public final int getType()
  {
    return 901;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.j
 * JD-Core Version:    0.7.0.1
 */