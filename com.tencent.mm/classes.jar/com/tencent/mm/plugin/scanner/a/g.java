package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.jf;
import com.tencent.mm.protocal.c.jg;
import com.tencent.mm.sdk.platformtools.y;

public final class g
  extends m
  implements k
{
  public int bIj;
  public int bIk;
  private b dmK;
  private f dmL;
  public boolean nGX = false;
  
  public g(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new jf();
    ((b.a)localObject).ecI = new jg();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanbarcode";
    ((b.a)localObject).ecG = 1061;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (jf)this.dmK.ecE.ecN;
    ((jf)localObject).hQR = paramInt1;
    ((jf)localObject).sDP = paramString;
    ((jf)localObject).pyo = 1;
    this.bIj = paramInt2;
    this.bIk = paramInt3;
    y.d("MicroMsg.scanner.NetSceneScanBarcode", "NetSceneScanBarcode, type: %s, barcode: %s, scene: %s, codetype: %s, codeVersion: %s", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.scanner.NetSceneScanBarcode", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  protected final m.b b(q paramq)
  {
    paramq = (jf)((b)paramq).ecE.ecN;
    if ((paramq.hQR < 0) || (paramq.sDP == null) || (paramq.sDP.length() <= 0))
    {
      y.e("MicroMsg.scanner.NetSceneScanBarcode", "securityVerificationChecked failed, Type = " + paramq.hQR + ", Barcode = %s" + paramq.sDP);
      return m.b.eds;
    }
    return m.b.edr;
  }
  
  public final jg bxh()
  {
    if ((this.dmK != null) && (this.dmK.ecF.ecN != null)) {
      return (jg)this.dmK.ecF.ecN;
    }
    return null;
  }
  
  public final int getType()
  {
    return 1061;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.a.g
 * JD-Core Version:    0.7.0.1
 */