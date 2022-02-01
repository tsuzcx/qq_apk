package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.cus;
import com.tencent.mm.protocal.protobuf.cut;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.io.OutputStream;

public final class o
  extends n
  implements k
{
  public g callback;
  private String filename;
  String mediaId;
  private OutputStream output;
  private com.tencent.mm.al.b rr;
  private String wEY;
  private int wEZ;
  int wFa;
  private boolean wFb;
  private String wFc;
  private bpi wFd;
  
  public o(bpi parambpi, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(95589);
    this.mediaId = "";
    this.output = null;
    this.wEZ = -1;
    this.wFa = -1;
    this.wFb = true;
    this.wFc = null;
    this.mediaId = paramString1;
    this.wFd = parambpi;
    this.wFb = paramBoolean;
    this.wEZ = paramInt1;
    this.wFa = paramInt2;
    this.wFc = paramString3;
    this.wEY = an.iF(af.getAccSnsPath(), paramString1);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cus();
    ((b.a)localObject).gUV = new cut();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsdownload";
    ((b.a)localObject).funcId = 208;
    ((b.a)localObject).reqCmdId = 96;
    ((b.a)localObject).respCmdId = 1000000096;
    this.rr = ((b.a)localObject).atI();
    cus localcus = (cus)this.rr.gUS.gUX;
    t localt = af.dtj().aqc(paramString1);
    localObject = localt;
    if (localt == null) {
      localObject = new t();
    }
    ((t)localObject).xjm = paramString1;
    ((t)localObject).offset = 0;
    af.dtj().a(paramString1, (t)localObject);
    if (paramBoolean) {}
    for (this.filename = com.tencent.mm.plugin.sns.data.q.m(parambpi);; this.filename = com.tencent.mm.plugin.sns.data.q.l(parambpi))
    {
      i.aMF(this.wEY);
      i.deleteFile(an.iF(af.getAccSnsPath(), paramString1) + this.filename);
      localcus.Emw = paramString2;
      localcus.Emx = 0;
      localcus.uKR = 0;
      localcus.uKQ = 0;
      localcus.mBH = this.wEZ;
      ad.d("MicroMsg.NetSceneSnsDownload", "requestKey ".concat(String.valueOf(paramString3)));
      AppMethodBeat.o(95589);
      return;
    }
  }
  
  private int Y(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95593);
    if (!com.tencent.mm.plugin.sns.data.q.anO(af.getAccPath()))
    {
      AppMethodBeat.o(95593);
      return 0;
    }
    try
    {
      if (this.output == null)
      {
        i.aMF(this.wEY);
        this.output = i.cM(this.wEY + this.filename, false);
      }
      ad.d("MicroMsg.NetSceneSnsDownload", "appendBuf " + paramArrayOfByte.length);
      this.output.write(paramArrayOfByte);
      auA();
      int i = paramArrayOfByte.length;
      AppMethodBeat.o(95593);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      ad.printErrStackTrace("MicroMsg.NetSceneSnsDownload", paramArrayOfByte, "appendBuf failed: " + this.filename, new Object[0]);
      return -1;
    }
    finally
    {
      auA();
      AppMethodBeat.o(95593);
    }
  }
  
  private void auA()
  {
    AppMethodBeat.i(95594);
    try
    {
      if (this.output != null)
      {
        this.output.flush();
        this.output.close();
        this.output = null;
      }
      AppMethodBeat.o(95594);
      return;
    }
    catch (IOException localIOException)
    {
      ad.printErrStackTrace("MicroMsg.NetSceneSnsDownload", localIOException, "", new Object[0]);
      AppMethodBeat.o(95594);
    }
  }
  
  private void onError()
  {
    AppMethodBeat.i(95592);
    af.dtp().aon(this.wFc);
    AppMethodBeat.o(95592);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(95590);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(95590);
    return i;
  }
  
  public final int getType()
  {
    return 208;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95591);
    ad.d("MicroMsg.NetSceneSnsDownload", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramArrayOfByte = (b.c)paramq.getRespObj();
    paramq = (cut)((com.tencent.mm.al.b)paramq).gUT.gUX;
    if (paramArrayOfByte.getRetCode() != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      af.dtp().aon(this.wFc);
      AppMethodBeat.o(95591);
      return;
    }
    paramArrayOfByte = af.dtj().aqc(this.mediaId);
    if (paramq.uKQ <= 0)
    {
      ad.e("MicroMsg.NetSceneSnsDownload", "error 1");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    if (paramq.CCV == null)
    {
      ad.e("MicroMsg.NetSceneSnsDownload", "error 2");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    if ((paramq.uKR < 0) || (paramq.uKR + paramq.CCV.getBuffer().wA.length > paramq.uKQ))
    {
      ad.e("MicroMsg.NetSceneSnsDownload", "error 3");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    if (paramq.uKR != paramArrayOfByte.offset)
    {
      ad.e("MicroMsg.NetSceneSnsDownload", "error 4");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    paramInt1 = Y(paramq.CCV.getBuffer().toByteArray());
    if (paramInt1 < 0)
    {
      ad.e("MicroMsg.NetSceneSnsDownload", "error 5");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    paramArrayOfByte.offset += paramInt1;
    paramArrayOfByte.xji = paramq.uKQ;
    ad.d("MicroMsg.NetSceneSnsDownload", "byteLen " + paramInt1 + "  totalLen " + paramq.uKQ);
    af.dtj().a(this.mediaId, paramArrayOfByte);
    if ((paramArrayOfByte.offset == paramArrayOfByte.xji) && (paramArrayOfByte.xji != 0))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label665;
      }
      ad.d("MicroMsg.NetSceneSnsDownload", "downLoad ok");
      if (this.wFa != 1) {
        break label552;
      }
      paramq = com.tencent.mm.plugin.sns.data.q.d(this.wFd);
      label442:
      paramArrayOfByte = an.iF(af.getAccSnsPath(), this.mediaId);
      i.deleteFile(paramArrayOfByte + paramq);
      i.aQ(paramArrayOfByte, this.filename, paramq);
      if (!this.wFb) {
        break label564;
      }
      u.b(paramArrayOfByte, paramq, com.tencent.mm.plugin.sns.data.q.e(this.wFd), af.dtE());
    }
    for (;;)
    {
      af.dtp().aon(this.wFc);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95591);
      return;
      paramInt1 = 0;
      break;
      label552:
      paramq = com.tencent.mm.plugin.sns.data.q.k(this.wFd);
      break label442;
      label564:
      String str = com.tencent.mm.plugin.sns.data.q.d(this.wFd);
      if (!i.eK(paramArrayOfByte + str)) {
        u.a(paramArrayOfByte, paramq, str, af.dtF());
      }
      str = com.tencent.mm.plugin.sns.data.q.e(this.wFd);
      if (!i.eK(paramArrayOfByte + str)) {
        u.b(paramArrayOfByte, paramq, str, af.dtE());
      }
    }
    label665:
    doScene(dispatcher(), this.callback);
    AppMethodBeat.o(95591);
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.o
 * JD-Core Version:    0.7.0.1
 */