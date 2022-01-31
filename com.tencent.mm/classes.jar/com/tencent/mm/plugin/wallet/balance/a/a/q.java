package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.bbz;
import com.tencent.mm.protocal.c.bca;
import com.tencent.mm.sdk.platformtools.y;

public final class q
  extends m
  implements k
{
  private f dmL;
  private b eWr;
  private bbz qgl;
  public bca qgm;
  
  public q(String paramString1, String paramString2)
  {
    b.a locala = new b.a();
    locala.ecH = new bbz();
    locala.ecI = new bca();
    locala.ecG = 2996;
    locala.uri = "/cgi-bin/mmpay-bin/openlqbaccount";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.eWr = locala.Kt();
    this.qgl = ((bbz)this.eWr.ecE.ecN);
    this.qgl.sAT = paramString1;
    this.qgl.txt = paramString2;
    y.i("MicroMsg.NetSceneOpenLqbAccount", "NetSceneOpenLqbAccount, eCardType: %s, extraData: %s", new Object[] { paramString1, paramString2 });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneOpenLqbAccount", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.qgm = ((bca)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneOpenLqbAccount", "onGYNetEnd, retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.qgm.ino), this.qgm.inp });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 2996;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.q
 * JD-Core Version:    0.7.0.1
 */