package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.g;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.a;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Random;

public final class u
  extends m
  implements k
{
  private String bVP;
  private b dmK;
  private f dmL;
  private int ebK = 0;
  private int ebL = 0;
  private g eoM;
  public String filePath = null;
  
  public u(String paramString1, String paramString2, g paramg)
  {
    this.filePath = paramString1;
    this.bVP = (paramString2 + "_" + System.nanoTime() + "_" + Math.abs(new Random().nextInt() / 2));
    this.eoM = paramg;
    y.i("MicroMsg.NetSceneUploadFie", "msgId: %s, filePath: %s", new Object[] { this.bVP, this.filePath });
  }
  
  protected final int Ka()
  {
    return 640;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    if (bk.bl(this.filePath))
    {
      y.e("MicroMsg.NetSceneUploadFie", "doScene, filePath is null");
      return -1;
    }
    if (!com.tencent.mm.vfs.e.bK(this.filePath))
    {
      y.e("MicroMsg.NetSceneUploadFie", "doScene, file: %s not exist", new Object[] { this.filePath });
      return -1;
    }
    if (this.ebK == 0)
    {
      this.ebK = ((int)com.tencent.mm.vfs.e.aeQ(this.filePath));
      y.i("MicroMsg.NetSceneUploadFie", "doScene, totalLen: %d", new Object[] { Integer.valueOf(this.ebK) });
    }
    int i = Math.min(this.ebK - this.ebL, 32768);
    y.i("MicroMsg.NetSceneUploadFie", "doScene, startPos: %d, dataLen: %d", new Object[] { Integer.valueOf(this.ebL), Integer.valueOf(i) });
    paramf = com.tencent.mm.vfs.e.c(this.filePath, this.ebL, i);
    if (paramf == null)
    {
      y.e("MicroMsg.NetSceneUploadFie", "doScene, read file buf is null");
      return -1;
    }
    y.i("MicroMsg.NetSceneUploadFie", "doScene, buf.length: %d", new Object[] { Integer.valueOf(paramf.length) });
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ag();
    ((b.a)localObject).ecI = new ah();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadfile";
    ((b.a)localObject).ecG = 484;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ag)this.dmK.ecE.ecN;
    ((ag)localObject).nde = this.bVP;
    ((ag)localObject).ndf = this.ebK;
    ((ag)localObject).ndg = this.ebL;
    ((ag)localObject).ndh = i;
    ((ag)localObject).ndi = aa.I(paramf);
    i = a(parame, this.dmK, this);
    y.i("MicroMsg.NetSceneUploadFie", "doScene, ret: %d", new Object[] { Integer.valueOf(i) });
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      if (this.dmL != null) {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          paramq = (ah)((b)paramq).ecF.ecN;
          paramArrayOfByte = paramq.nde;
          y.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, clientId: %s, totalLen: %d, attachId: %s", new Object[] { paramq.nde, Integer.valueOf(paramq.ndf), paramq.ndn });
        } while (!paramArrayOfByte.equals(this.bVP));
        this.ebL = paramq.ndg;
        if (this.ebL >= this.ebK) {
          break;
        }
        y.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, startPos: %d, totalLen: %d, continue to upload", new Object[] { Integer.valueOf(this.ebL), Integer.valueOf(this.ebK) });
        if (a(this.edc, this.dmL) >= 0) {
          break;
        }
        y.e("MicroMsg.NetSceneUploadFie", "continue to upload fail");
        if (this.dmL != null) {
          this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        }
      } while (this.eoM == null);
      this.eoM.a(this.ebL, this.ebK, this);
      return;
      paramq = paramq.ndn;
      y.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, finish upload, startPos: %d, totalLen: %d, attachId: %s", new Object[] { Integer.valueOf(this.ebL), Integer.valueOf(this.ebK), paramq });
      if (this.dmL != null) {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
    } while (this.eoM == null);
    this.eoM.a(this.ebL, this.ebK, this);
  }
  
  protected final void a(m.a parama) {}
  
  protected final m.b b(q paramq)
  {
    if ((bk.bl(this.filePath)) || (!com.tencent.mm.vfs.e.bK(this.filePath)))
    {
      y.e("MicroMsg.NetSceneUploadFie", "securityVerificationChecked failed, file not exist");
      return m.b.eds;
    }
    return m.b.edr;
  }
  
  public final ah bty()
  {
    if (this.dmK != null) {
      return (ah)this.dmK.ecF.ecN;
    }
    return null;
  }
  
  public final int getType()
  {
    return 484;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.u
 * JD-Core Version:    0.7.0.1
 */