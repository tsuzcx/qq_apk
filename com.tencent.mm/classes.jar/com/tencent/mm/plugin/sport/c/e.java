package com.tencent.mm.plugin.sport.c;

import android.os.Build;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.civ;
import com.tencent.mm.protocal.c.ciw;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bs;

public final class e
  extends m
  implements k
{
  private f dmL;
  private b esv;
  ciw ptq;
  
  public e()
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecG = 1947;
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/getwxsportconfig";
    ((b.a)localObject).ecH = new civ();
    ((b.a)localObject).ecI = new ciw();
    this.esv = ((b.a)localObject).Kt();
    localObject = (civ)this.esv.ecE.ecN;
    ((civ)localObject).hQc = com.tencent.mm.protocal.d.DEVICE_NAME;
    ((civ)localObject).syI = bs.cwc();
    ((civ)localObject).sEd = Build.BRAND;
    ((civ)localObject).sEc = Build.MODEL;
    ((civ)localObject).tXc = com.tencent.mm.protocal.d.soW;
    ((civ)localObject).sEe = com.tencent.mm.protocal.d.soX;
    ((civ)localObject).sEf = com.tencent.mm.protocal.d.soY;
    ((civ)localObject).tXd = com.tencent.mm.sdk.platformtools.d.CLIENT_VERSION;
    ((civ)localObject).tXe = Build.MANUFACTURER;
    y.i("MicroMsg.Sport.NetSceneGetWeSportConfig", "request params=[%s, %s, %s, %s, %s, %s, %s, %s, %s]", new Object[] { ((civ)localObject).syI, ((civ)localObject).sEd, ((civ)localObject).sEc, ((civ)localObject).hQc, ((civ)localObject).sEf, ((civ)localObject).sEe, ((civ)localObject).sEf, ((civ)localObject).tXd, ((civ)localObject).tXe });
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.esv, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Sport.NetSceneGetWeSportConfig", "onGYNetEnd %d %d %d %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    this.ptq = ((ciw)this.esv.ecF.ecN);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1947;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.c.e
 * JD-Core Version:    0.7.0.1
 */