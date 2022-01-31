package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.alg;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  extends m
  implements k
{
  private f dmL;
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    paramf = new b.a();
    paramf.ecH = new alg();
    paramf.ecI = new alh();
    paramf.uri = "/cgi-bin/micromsg-bin/gettrustedfriends";
    paramf.ecG = 869;
    paramf.ecJ = 0;
    paramf.ecK = 0;
    return a(parame, paramf.Kt(), this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    this.ede = paramInt1;
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      y.e("MicroMsg.NetSceneGetTrustedFriends", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 869;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.e
 * JD-Core Version:    0.7.0.1
 */