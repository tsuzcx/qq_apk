package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.cel;
import com.tencent.mm.protocal.c.cem;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends m
  implements k
{
  public com.tencent.mm.ah.b dmK;
  private f dmL;
  
  public c(int paramInt1, String paramString1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new cel();
    ((b.a)localObject).ecI = new cem();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/csvoipinvite";
    ((b.a)localObject).ecG = 823;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (cel)this.dmK.ecE.ecN;
    ((cel)localObject).tAC = paramInt1;
    ((cel)localObject).tTp = paramString1;
    ((cel)localObject).sNU = paramInt2;
    ((cel)localObject).tTq = com.tencent.mm.bv.b.bk(paramArrayOfByte1);
    ((cel)localObject).tTr = com.tencent.mm.bv.b.bk(paramArrayOfByte2);
    ((cel)localObject).tAB = System.currentTimeMillis();
    if ((paramString2 != null) && (!paramString2.equals(""))) {
      ((cel)localObject).tTs = paramString2;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneVoipCSInvite", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 823;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.c.c
 * JD-Core Version:    0.7.0.1
 */