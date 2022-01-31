package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;

public final class t
  extends m
  implements k
{
  public final boolean cce;
  private b dmK;
  private f dmL;
  private String nel = "";
  
  public t(boolean paramBoolean, String paramString)
  {
    this.cce = paramBoolean;
    this.nel = bk.pm(paramString);
  }
  
  public final boolean Kx()
  {
    return true;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ad();
    ((b.a)localObject).ecI = new ae();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/switchpushmail";
    ((b.a)localObject).ecG = 129;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ad)this.dmK.ecE.ecN;
    if (this.cce) {}
    for (int i = 1;; i = 2)
    {
      ((ad)localObject).nfn = i;
      ((ad)localObject).nfo = this.nel;
      this.dmL = paramf;
      return a(parame, this.dmK, this);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (ae)this.dmK.ecF.ecN;
      g.DP().Dz().o(17, Integer.valueOf(paramq.nfn));
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 24;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.t
 * JD-Core Version:    0.7.0.1
 */