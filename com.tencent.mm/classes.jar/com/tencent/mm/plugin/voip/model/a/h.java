package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.plugin.voip.model.j;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.c.cfn;
import com.tencent.mm.protocal.c.cfo;
import com.tencent.mm.protocal.c.cfq;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class h
  extends n<cfn, cfo>
{
  public h(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new cfn();
    ((b.a)localObject).ecI = new cfo();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipRedirect";
    ((b.a)localObject).ecG = 678;
    ((b.a)localObject).ecJ = 240;
    ((b.a)localObject).ecK = 1000000240;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (cfn)this.dmK.ecE.ecN;
    ((cfn)localObject).sST = paramInt1;
    ((cfn)localObject).sSU = paramLong;
    ((cfn)localObject).tAN = paramInt2;
    ((cfn)localObject).tUI = paramInt3;
    ((cfn)localObject).tUJ = paramInt4;
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < paramInt4)
    {
      cfq localcfq = new cfq();
      paramInt3 = paramInt2 + 1;
      localcfq.tUT = paramArrayOfInt[paramInt2];
      paramInt2 = paramInt3 + 1;
      localcfq.tUU = paramArrayOfInt[paramInt3];
      paramInt3 = paramInt2 + 1;
      localcfq.tUV = paramArrayOfInt[paramInt2];
      int j = paramInt3 + 1;
      localcfq.tUW = paramArrayOfInt[paramInt3];
      paramInt2 = j + 1;
      localcfq.tUX = paramArrayOfInt[j];
      ((cfn)localObject).tUK.add(localcfq);
      paramInt1 += 1;
    }
    paramInt1 = i;
    if (this.pQA.pQe.pWi.pRv != 0L) {
      paramInt1 = (int)((System.currentTimeMillis() - this.pQA.pQe.pWi.pRv) / 1000L);
    }
    ((cfn)localObject).tUL = paramInt1;
  }
  
  public final f bRy()
  {
    return new h.1(this);
  }
  
  public final void em(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      cfo localcfo = (cfo)this.dmK.ecF.ecN;
      if (localcfo != null) {
        y.i("MicroMsg.Voip.Redirect", "roomId:%d, roomKey:%s, member:%d", new Object[] { Integer.valueOf(localcfo.sST), Long.valueOf(localcfo.sSU), Integer.valueOf(localcfo.tAN) });
      }
      return;
    }
    y.i("MicroMsg.Voip.Redirect", "Redirect error");
  }
  
  public final int getType()
  {
    return 678;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.h
 * JD-Core Version:    0.7.0.1
 */