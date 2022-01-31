package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.bui;
import com.tencent.mm.protocal.c.bun;
import com.tencent.mm.protocal.c.buo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class x
  extends m
  implements k
{
  private int bMC;
  private b dmK;
  public f dmL;
  private long oqH = 0L;
  
  public x(long paramLong, String paramString)
  {
    y.d("MicroMsg.NetSceneSnsTagOption", "opcode 3 snsTagId " + paramLong + " tagName " + paramString);
    this.oqH = paramLong;
    this.bMC = 3;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bun();
    ((b.a)localObject).ecI = new buo();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstagoption";
    ((b.a)localObject).ecG = 290;
    ((b.a)localObject).ecJ = 114;
    ((b.a)localObject).ecK = 1000000114;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bun)this.dmK.ecE.ecN;
    ((bun)localObject).ssq = 3;
    ((bun)localObject).tLb = paramLong;
    ((bun)localObject).kVl = paramString;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneSnsTagOption", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramq = ((buo)((b)paramq).ecF.ecN).tLd;
    y.d("MicroMsg.NetSceneSnsTagOption", paramq.toString());
    switch (this.bMC)
    {
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      paramArrayOfByte = af.bDL().gv(paramq.tLb);
      paramArrayOfByte.field_tagId = paramq.tLb;
      paramArrayOfByte.field_tagName = bk.aM(paramq.kVl, "");
      paramArrayOfByte.field_count = paramq.hPS;
      paramArrayOfByte.cD(paramq.hPT);
      af.bDL().a(paramArrayOfByte);
      continue;
      paramInt1 = af.bDL().gw(this.oqH);
      y.d("MicroMsg.NetSceneSnsTagOption", "MM_SNS_TAG_DEL " + paramInt1);
    }
  }
  
  public final int getType()
  {
    return 290;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.x
 * JD-Core Version:    0.7.0.1
 */