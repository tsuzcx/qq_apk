package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.cfh;
import com.tencent.mm.protocal.c.cfi;
import com.tencent.mm.protocal.c.cfp;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends n<cfh, cfi>
{
  public g(List<String> paramList, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = new b.a();
    ((b.a)localObject1).ecH = new cfh();
    ((b.a)localObject1).ecI = new cfi();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/voipinvite";
    ((b.a)localObject1).ecG = 170;
    ((b.a)localObject1).ecJ = 63;
    ((b.a)localObject1).ecK = 1000000063;
    this.dmK = ((b.a)localObject1).Kt();
    localObject1 = (cfh)this.dmK.ecE.ecN;
    Object localObject2 = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      ((LinkedList)localObject2).add(new bml().YI((String)paramList.get(i)));
      i += 1;
    }
    ((cfh)localObject1).tAY = q.Gj();
    ((cfh)localObject1).tTS = ((LinkedList)localObject2);
    ((cfh)localObject1).tTR = ((LinkedList)localObject2).size();
    ((cfh)localObject1).sNU = paramInt1;
    ((cfh)localObject1).tLL = 0;
    ((cfh)localObject1).tTG = paramInt2;
    ((cfh)localObject1).tAC = paramInt3;
    paramList = new cfp();
    paramList.hQR = 2;
    localObject2 = new bmk();
    ((bmk)localObject2).bs(paramArrayOfByte1);
    paramList.szp = ((bmk)localObject2);
    ((cfh)localObject1).tSF = paramList;
    paramList = new cfp();
    paramList.hQR = 3;
    paramArrayOfByte1 = new bmk();
    paramArrayOfByte1.bs(paramArrayOfByte2);
    paramList.szp = paramArrayOfByte1;
    ((cfh)localObject1).tSG = paramList;
    ((cfh)localObject1).tSJ = System.currentTimeMillis();
    paramInt1 = ((a)com.tencent.mm.kernel.g.r(a.class)).bih();
    y.i("MicroMsg.NetSceneVoipInvite", "simType: %s", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == 0) {
      paramInt1 = j;
    }
    for (;;)
    {
      ((cfh)localObject1).tSK = paramInt1;
      return;
      if (paramInt1 == 1) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
    }
  }
  
  public final f bRy()
  {
    return new g.1(this);
  }
  
  public final int getType()
  {
    return 170;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.g
 * JD-Core Version:    0.7.0.1
 */