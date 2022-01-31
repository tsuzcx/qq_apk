package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.byj;
import com.tencent.mm.protocal.c.byk;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  String klM;
  boolean qPj = false;
  
  public e(String paramString1, String paramString2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new byj();
    ((b.a)localObject).ecI = new byk();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/touchlockgetchallenge";
    ((b.a)localObject).ecG = 1548;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (byj)this.dmK.ecE.ecN;
    ((byj)localObject).scene = 1548;
    ((byj)localObject).psl = paramString1;
    ((byj)localObject).psm = paramString2;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetTouchWalletLockChallenge", "alvinluo get touch wallet lock challenge errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (byk)((b)paramq).ecF.ecN;
    this.klM = paramq.klM;
    y.d("MicroMsg.NetSceneGetTouchWalletLockChallenge", "alvinluo get touch lock challenge: %s", new Object[] { this.klM });
    if (paramq.tLu == 1) {}
    for (this.qPj = true;; this.qPj = false)
    {
      if (this.dmL != null) {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      return;
    }
  }
  
  public final int getType()
  {
    return 1548;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.e
 * JD-Core Version:    0.7.0.1
 */