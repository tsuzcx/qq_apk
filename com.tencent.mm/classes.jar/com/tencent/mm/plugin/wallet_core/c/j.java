package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.wf;
import com.tencent.mm.protocal.c.wg;
import com.tencent.mm.sdk.platformtools.y;

public final class j
  extends m
  implements k
{
  private f dmL;
  private b eWr;
  private boolean qqD;
  private wf qqJ;
  public wg qqK;
  
  public j(String paramString, boolean paramBoolean)
  {
    this.qqD = paramBoolean;
    b.a locala = new b.a();
    locala.ecH = new wf();
    locala.ecI = new wg();
    if (paramBoolean) {
      locala.ecG = 2529;
    }
    for (locala.uri = "/cgi-bin/mmpay-bin/mktf2fmodifyexposure";; locala.uri = "/cgi-bin/mmpay-bin/mktmodifyexposure")
    {
      locala.ecJ = 0;
      locala.ecK = 0;
      this.eWr = locala.Kt();
      this.qqJ = ((wf)this.eWr.ecE.ecN);
      this.qqJ.sTe = paramString;
      return;
      locala.ecG = 2888;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneMktModifyExposure", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.qqK = ((wg)((b)paramq).ecF.ecN);
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    if (this.qqD) {
      return 2529;
    }
    return 2888;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.j
 * JD-Core Version:    0.7.0.1
 */