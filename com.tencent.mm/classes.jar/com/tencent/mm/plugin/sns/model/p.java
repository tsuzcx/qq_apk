package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bth;
import com.tencent.mm.protocal.c.bti;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.io.OutputStream;

public final class p
  extends m
  implements k
{
  String bUi = "";
  private com.tencent.mm.ah.b dmK;
  public f dmL;
  private OutputStream eca = null;
  private String filename;
  private String opV;
  private int opW = -1;
  int opX = -1;
  private boolean opY = true;
  private String opZ = null;
  private awd oqa;
  
  public p(awd paramawd, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, String paramString3)
  {
    this.bUi = paramString1;
    this.oqa = paramawd;
    this.opY = paramBoolean;
    this.opW = paramInt1;
    this.opX = paramInt2;
    this.opZ = paramString3;
    this.opV = an.eJ(af.getAccSnsPath(), paramString1);
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bth();
    ((b.a)localObject).ecI = new bti();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsdownload";
    ((b.a)localObject).ecG = 208;
    ((b.a)localObject).ecJ = 96;
    ((b.a)localObject).ecK = 1000000096;
    this.dmK = ((b.a)localObject).Kt();
    bth localbth = (bth)this.dmK.ecE.ecN;
    r localr = af.bDu().OQ(paramString1);
    localObject = localr;
    if (localr == null) {
      localObject = new r();
    }
    ((r)localObject).oLU = paramString1;
    ((r)localObject).offset = 0;
    af.bDu().a(paramString1, (r)localObject);
    if (paramBoolean) {}
    for (this.filename = i.n(paramawd);; this.filename = i.m(paramawd))
    {
      com.tencent.mm.vfs.e.nb(this.opV);
      com.tencent.mm.vfs.e.deleteFile(an.eJ(af.getAccSnsPath(), paramString1) + this.filename);
      localbth.tJQ = paramString2;
      localbth.tJR = 0;
      localbth.ndg = 0;
      localbth.ndf = 0;
      localbth.hQR = this.opW;
      y.d("MicroMsg.NetSceneSnsDownload", "requestKey " + paramString3);
      return;
    }
  }
  
  private int B(byte[] paramArrayOfByte)
  {
    if (!i.Nd(af.FU())) {
      return 0;
    }
    try
    {
      if (this.eca == null)
      {
        com.tencent.mm.vfs.e.nb(this.opV);
        this.eca = com.tencent.mm.vfs.e.I(this.opV + this.filename, false);
      }
      y.d("MicroMsg.NetSceneSnsDownload", "appendBuf " + paramArrayOfByte.length);
      this.eca.write(paramArrayOfByte);
      return paramArrayOfByte.length;
    }
    catch (IOException paramArrayOfByte)
    {
      y.printErrStackTrace("MicroMsg.NetSceneSnsDownload", paramArrayOfByte, "appendBuf failed: " + this.filename, new Object[0]);
      return -1;
    }
    finally
    {
      Kb();
    }
  }
  
  private void Kb()
  {
    try
    {
      if (this.eca != null)
      {
        this.eca.flush();
        this.eca.close();
        this.eca = null;
      }
      return;
    }
    catch (IOException localIOException)
    {
      y.printErrStackTrace("MicroMsg.NetSceneSnsDownload", localIOException, "", new Object[0]);
    }
  }
  
  private void onError()
  {
    af.bDA().Np(this.opZ);
  }
  
  protected final int Ka()
  {
    return 100;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneSnsDownload", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramArrayOfByte = (b.c)paramq.HF();
    paramq = (bti)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    if (paramArrayOfByte.spN != 0)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      af.bDA().Np(this.opZ);
      return;
    }
    paramArrayOfByte = af.bDu().OQ(this.bUi);
    if (paramq.ndf <= 0)
    {
      y.e("MicroMsg.NetSceneSnsDownload", "error 1");
      onError();
      return;
    }
    if (paramq.szp == null)
    {
      y.e("MicroMsg.NetSceneSnsDownload", "error 2");
      onError();
      return;
    }
    if ((paramq.ndg < 0) || (paramq.ndg + paramq.szp.tFM.oY.length > paramq.ndf))
    {
      y.e("MicroMsg.NetSceneSnsDownload", "error 3");
      onError();
      return;
    }
    if (paramq.ndg != paramArrayOfByte.offset)
    {
      y.e("MicroMsg.NetSceneSnsDownload", "error 4");
      onError();
      return;
    }
    paramInt1 = B(paramq.szp.tFM.toByteArray());
    if (paramInt1 < 0)
    {
      y.e("MicroMsg.NetSceneSnsDownload", "error 5");
      onError();
      return;
    }
    paramArrayOfByte.offset += paramInt1;
    paramArrayOfByte.oLQ = paramq.ndf;
    y.d("MicroMsg.NetSceneSnsDownload", "byteLen " + paramInt1 + "  totalLen " + paramq.ndf);
    af.bDu().a(this.bUi, paramArrayOfByte);
    if ((paramArrayOfByte.offset == paramArrayOfByte.oLQ) && (paramArrayOfByte.oLQ != 0))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label614;
      }
      y.d("MicroMsg.NetSceneSnsDownload", "downLoad ok");
      if (this.opX != 1) {
        break label501;
      }
      paramq = i.e(this.oqa);
      label397:
      paramArrayOfByte = an.eJ(af.getAccSnsPath(), this.bUi);
      com.tencent.mm.vfs.e.deleteFile(paramArrayOfByte + paramq);
      com.tencent.mm.vfs.e.f(paramArrayOfByte, this.filename, paramq);
      if (!this.opY) {
        break label513;
      }
      s.b(paramArrayOfByte, paramq, i.f(this.oqa), af.bDN());
    }
    for (;;)
    {
      af.bDA().Np(this.opZ);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      paramInt1 = 0;
      break;
      label501:
      paramq = i.l(this.oqa);
      break label397;
      label513:
      String str = i.e(this.oqa);
      if (!com.tencent.mm.vfs.e.bK(paramArrayOfByte + str)) {
        s.a(paramArrayOfByte, paramq, str, af.bDO());
      }
      str = i.f(this.oqa);
      if (!com.tencent.mm.vfs.e.bK(paramArrayOfByte + str)) {
        s.b(paramArrayOfByte, paramq, str, af.bDN());
      }
    }
    label614:
    a(this.edc, this.dmL);
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 208;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.p
 * JD-Core Version:    0.7.0.1
 */