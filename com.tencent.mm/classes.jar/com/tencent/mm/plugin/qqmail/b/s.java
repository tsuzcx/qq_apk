package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.a;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Random;

public final class s
  extends m
  implements k
{
  private String bRO;
  private String clientId = null;
  private b dmK;
  private com.tencent.mm.ah.f dmL;
  private int ebK = 0;
  private int ebL = 0;
  private com.tencent.mm.ah.g eoM;
  private String nei = null;
  private String nej;
  private int nek = 0;
  
  public s(String paramString1, String paramString2, String[] paramArrayOfString, int paramInt, com.tencent.mm.ah.g paramg)
  {
    this.nei = paramString1;
    this.nek = paramInt;
    this.eoM = paramg;
    if (!bk.bl(paramString1))
    {
      this.clientId = (com.tencent.mm.a.g.o(paramString1.getBytes()) + "_" + System.nanoTime() + "_" + new Random().nextInt());
      this.ebK = paramString1.getBytes().length;
      this.ebL = 0;
    }
    if (!bk.bl(paramString2)) {
      this.bRO = paramString2;
    }
    if (paramArrayOfString != null)
    {
      this.nej = "";
      int i = paramArrayOfString.length;
      paramInt = 0;
      while (paramInt < i)
      {
        paramString1 = paramArrayOfString[paramInt];
        this.nej = (this.nej + paramString1 + ",");
        paramInt += 1;
      }
      this.nej = this.nej.substring(0, this.nej.length() - 1);
    }
    y.i("MicroMsg.NetSceneComposeSend", "NetSceneComposeSend, clientId: %s, totalLen: %d", new Object[] { this.clientId, Integer.valueOf(this.ebK) });
  }
  
  protected final int Ka()
  {
    return 100;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    if (bk.bl(this.nei))
    {
      y.e("MicroMsg.NetSceneComposeSend", "doScene, sendContent is null");
      return -1;
    }
    int k = Math.min(this.ebK - this.ebL, 32768);
    y.i("MicroMsg.NetSceneComposeSend", "doScene, dataLen: %d", new Object[] { Integer.valueOf(k) });
    paramf = new byte[k];
    Object localObject = this.nei.getBytes();
    int i = this.ebL;
    int j = 0;
    while (i < this.ebL + k)
    {
      paramf[j] = localObject[i];
      j += 1;
      i += 1;
    }
    if (bk.bE(paramf))
    {
      y.e("MicroMsg.NetSceneComposeSend", "doScene, sendData is null");
      return -1;
    }
    localObject = new b.a();
    ((b.a)localObject).ecH = new e();
    ((b.a)localObject).ecI = new f();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/composesend";
    ((b.a)localObject).ecG = 485;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (e)this.dmK.ecE.ecN;
    ((e)localObject).nde = this.clientId;
    ((e)localObject).ndf = this.ebK;
    ((e)localObject).ndg = this.ebL;
    ((e)localObject).ndh = k;
    ((e)localObject).ndj = this.bRO;
    ((e)localObject).ndk = this.nej;
    ((e)localObject).ndl = ((int)(this.ebK + this.nek * 1.333333F));
    y.i("MicroMsg.NetSceneComposeSend", "doScene, realSize: %d", new Object[] { Integer.valueOf(((e)localObject).ndl) });
    ((e)localObject).ndi = aa.I(paramf);
    i = a(parame, this.dmK, this);
    y.i("MicroMsg.NetSceneComposeSend", "doScene, ret: %d", new Object[] { Integer.valueOf(i) });
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneComposeSend", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      if (this.dmL != null) {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
    }
    do
    {
      return;
      this.ebL = ((f)((b)paramq).ecF.ecN).ndg;
      if (this.dmL != null) {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      if (this.eoM != null) {
        this.eoM.a(this.ebL, this.ebK, this);
      }
      if (this.ebL >= this.ebK) {
        break;
      }
      y.i("MicroMsg.NetSceneComposeSend", "onGYNetEnd, startPos: %d, totalLen: %d, continue to upload", new Object[] { Integer.valueOf(this.ebL), Integer.valueOf(this.ebK) });
    } while (a(this.edc, this.dmL) >= 0);
    y.e("MicroMsg.NetSceneComposeSend", "continue to upload fail");
    return;
    y.i("MicroMsg.NetSceneComposeSend", "finished upload");
  }
  
  protected final void a(m.a parama) {}
  
  protected final m.b b(q paramq)
  {
    if (bk.bl(this.nei))
    {
      y.e("MicroMsg.NetSceneComposeSend", "securityVerificationChecked failed, content is null");
      return m.b.eds;
    }
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 485;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.s
 * JD-Core Version:    0.7.0.1
 */