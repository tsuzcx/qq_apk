package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bcb;
import com.tencent.mm.protocal.c.bcc;
import com.tencent.mm.sdk.platformtools.y;

public final class f
  extends m
  implements k
{
  private b dmK;
  private com.tencent.mm.ah.f dmL;
  
  public f(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bcb();
    ((b.a)localObject).ecI = new bcc();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/opensotertouchlock";
    ((b.a)localObject).ecG = 1967;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bcb)this.dmK.ecE.ecN;
    y.d("MicroMsg.NetSceneOpenSoterFingerprintLock", "alvinluo json: %s, signature: %s, token: %s", new Object[] { paramString1, paramString2, paramString3 });
    ((bcb)localObject).txu = paramString1;
    ((bcb)localObject).signature = paramString2;
    ((bcb)localObject).qrc = paramString3;
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneOpenSoterFingerprintLock", "alvinluo open soter fingerprint lock errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1967;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.f
 * JD-Core Version:    0.7.0.1
 */