package com.tencent.mm.sandbox.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.c.i;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sandbox.SubCoreSandBox;
import com.tencent.mm.protocal.c.alk;
import com.tencent.mm.protocal.c.all;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class a
  extends m
  implements k, com.tencent.mm.plugin.w.b
{
  public final com.tencent.mm.ah.b dmK;
  private f dmL;
  
  public a(int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new alk();
    ((b.a)localObject).ecI = new all();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getupdateinfo";
    ((b.a)localObject).ecG = 113;
    ((b.a)localObject).ecJ = 35;
    ((b.a)localObject).ecK = 1000000035;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (alk)this.dmK.ecE.ecN;
    ((alk)localObject).thp = paramInt;
    ((alk)localObject).sss = com.tencent.mm.sdk.platformtools.e.bvj;
    if ((10012 == com.tencent.mm.platformtools.ae.eSP) && (com.tencent.mm.platformtools.ae.eSQ > 0)) {
      ((alk)localObject).sss = com.tencent.mm.platformtools.ae.eSQ;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      y.i("MicroMsg.NetSceneGetUpdateInfo", "summerupdate dkchan NetSceneGetUpdateInfo updateType:%d channel:%d release:%d, stack[%s]", new Object[] { Integer.valueOf(((alk)localObject).thp), Integer.valueOf(((alk)localObject).sss), Integer.valueOf(com.tencent.mm.sdk.platformtools.e.bvj), bk.csb() });
      return;
      h.nFQ.a(405L, 3L, 1L, true);
      continue;
      h.nFQ.a(405L, 4L, 1L, true);
      continue;
      h.nFQ.a(405L, 5L, 1L, true);
      continue;
      h.nFQ.a(405L, 6L, 1L, true);
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken GetUpdateInfo onGYNetEnd errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      h.nFQ.a(405L, 7L, 1L, true);
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramString = cpD();
      if (paramString == null) {
        break label266;
      }
      paramq = i.cf(paramString);
      if (paramq == null) {
        break;
      }
      paramInt1 = paramq.versionCode;
      y.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchVersionCode[%d]", new Object[] { Integer.valueOf(paramInt1) });
      au.Dk().a(new ad(com.tencent.mm.sdk.platformtools.ae.getPackageName(), paramInt1), 0);
      h.nFQ.a(405L, 13L, 1L, true);
      return;
      h.nFQ.a(405L, 8L, 1L, true);
      if (paramInt2 == 4)
      {
        h.nFQ.a(405L, 9L, 1L, true);
        if (paramInt3 == -16) {
          h.nFQ.a(405L, 10L, 1L, true);
        } else if (paramInt3 == -17) {
          h.nFQ.a(405L, 11L, 1L, true);
        } else if (paramInt3 == -18) {
          h.nFQ.a(405L, 12L, 1L, true);
        }
      }
    }
    y.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchInfo is null patchXml[%s]", new Object[] { paramString });
    return;
    label266:
    y.w("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchXml is null!");
    h.nFQ.a(405L, 14L, 1L, true);
  }
  
  public final int bko()
  {
    return ((all)this.dmK.ecF.ecN).thq;
  }
  
  public final String[] bkp()
  {
    all localall = (all)this.dmK.ecF.ecN;
    String[] arrayOfString = new String[localall.thv.size()];
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      arrayOfString[i] = ((bml)localall.thv.get(i)).tFO;
      i += 1;
    }
    return arrayOfString;
  }
  
  public final all bkq()
  {
    int i = 1;
    all localall;
    if (SubCoreSandBox.nGl)
    {
      localall = (all)this.dmK.ecF.ecN;
      localall.thx = 1;
      localall.thy = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
      if (!SubCoreSandBox.nGm) {
        break label58;
      }
    }
    for (;;)
    {
      localall.thz = i;
      return (all)this.dmK.ecF.ecN;
      label58:
      i = 0;
    }
  }
  
  public final int cpB()
  {
    return ((all)this.dmK.ecF.ecN).ths;
  }
  
  public final String cpC()
  {
    return ((all)this.dmK.ecF.ecN).thr;
  }
  
  public final String cpD()
  {
    all localall = (all)this.dmK.ecF.ecN;
    y.d("MicroMsg.NetSceneGetUpdateInfo", "summertoken getPatchInfo[%s], stack[%s]", new Object[] { localall.thw, bk.csb() });
    return localall.thw;
  }
  
  public final int getType()
  {
    return 11;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sandbox.a.a
 * JD-Core Version:    0.7.0.1
 */