package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.dfr;
import com.tencent.mm.protocal.protobuf.dfs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.io.OutputStream;

public final class o
  extends n
  implements k
{
  public f callback;
  private String filename;
  String mediaId;
  private OutputStream output;
  private com.tencent.mm.al.b rr;
  private String zhn;
  private int zho;
  int zhp;
  private boolean zhq;
  private String zhr;
  private byn zhs;
  
  public o(byn parambyn, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(95589);
    this.mediaId = "";
    this.output = null;
    this.zho = -1;
    this.zhp = -1;
    this.zhq = true;
    this.zhr = null;
    this.mediaId = paramString1;
    this.zhs = parambyn;
    this.zhq = paramBoolean;
    this.zho = paramInt1;
    this.zhp = paramInt2;
    this.zhr = paramString3;
    this.zhn = ao.jo(ag.getAccSnsPath(), paramString1);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dfr();
    ((b.a)localObject).hNN = new dfs();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsdownload";
    ((b.a)localObject).funcId = 208;
    ((b.a)localObject).hNO = 96;
    ((b.a)localObject).respCmdId = 1000000096;
    this.rr = ((b.a)localObject).aDC();
    dfr localdfr = (dfr)this.rr.hNK.hNQ;
    t localt = ag.dTT().aAs(paramString1);
    localObject = localt;
    if (localt == null) {
      localObject = new t();
    }
    ((t)localObject).zNq = paramString1;
    ((t)localObject).offset = 0;
    ag.dTT().a(paramString1, (t)localObject);
    if (paramBoolean) {}
    for (this.filename = com.tencent.mm.plugin.sns.data.q.m(parambyn);; this.filename = com.tencent.mm.plugin.sns.data.q.l(parambyn))
    {
      i.aYg(this.zhn);
      i.deleteFile(ao.jo(ag.getAccSnsPath(), paramString1) + this.filename);
      localdfr.Hud = paramString2;
      localdfr.Hue = 0;
      localdfr.xcL = 0;
      localdfr.xcK = 0;
      localdfr.nEf = this.zho;
      ad.d("MicroMsg.NetSceneSnsDownload", "requestKey ".concat(String.valueOf(paramString3)));
      AppMethodBeat.o(95589);
      return;
    }
  }
  
  private int W(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95593);
    if (!com.tencent.mm.plugin.sns.data.q.ayf(ag.getAccPath()))
    {
      AppMethodBeat.o(95593);
      return 0;
    }
    try
    {
      if (this.output == null)
      {
        i.aYg(this.zhn);
        this.output = i.cX(this.zhn + this.filename, false);
      }
      ad.d("MicroMsg.NetSceneSnsDownload", "appendBuf " + paramArrayOfByte.length);
      this.output.write(paramArrayOfByte);
      aEt();
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
      aEt();
      AppMethodBeat.o(95593);
    }
  }
  
  private void aEt()
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
    ag.dTZ().ayE(this.zhr);
    AppMethodBeat.o(95592);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(95590);
    this.callback = paramf;
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
    paramq = (dfs)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    if (paramArrayOfByte.getRetCode() != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      ag.dTZ().ayE(this.zhr);
      AppMethodBeat.o(95591);
      return;
    }
    paramArrayOfByte = ag.dTT().aAs(this.mediaId);
    if (paramq.xcK <= 0)
    {
      ad.e("MicroMsg.NetSceneSnsDownload", "error 1");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    if (paramq.FAN == null)
    {
      ad.e("MicroMsg.NetSceneSnsDownload", "error 2");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    if ((paramq.xcL < 0) || (paramq.xcL + paramq.FAN.getBuffer().zr.length > paramq.xcK))
    {
      ad.e("MicroMsg.NetSceneSnsDownload", "error 3");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    if (paramq.xcL != paramArrayOfByte.offset)
    {
      ad.e("MicroMsg.NetSceneSnsDownload", "error 4");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    paramInt1 = W(paramq.FAN.getBuffer().toByteArray());
    if (paramInt1 < 0)
    {
      ad.e("MicroMsg.NetSceneSnsDownload", "error 5");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    paramArrayOfByte.offset += paramInt1;
    paramArrayOfByte.zNm = paramq.xcK;
    ad.d("MicroMsg.NetSceneSnsDownload", "byteLen " + paramInt1 + "  totalLen " + paramq.xcK);
    ag.dTT().a(this.mediaId, paramArrayOfByte);
    if ((paramArrayOfByte.offset == paramArrayOfByte.zNm) && (paramArrayOfByte.zNm != 0))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label665;
      }
      ad.d("MicroMsg.NetSceneSnsDownload", "downLoad ok");
      if (this.zhp != 1) {
        break label552;
      }
      paramq = com.tencent.mm.plugin.sns.data.q.d(this.zhs);
      label442:
      paramArrayOfByte = ao.jo(ag.getAccSnsPath(), this.mediaId);
      i.deleteFile(paramArrayOfByte + paramq);
      i.bb(paramArrayOfByte, this.filename, paramq);
      if (!this.zhq) {
        break label564;
      }
      u.b(paramArrayOfByte, paramq, com.tencent.mm.plugin.sns.data.q.e(this.zhs), ag.dUp());
    }
    for (;;)
    {
      ag.dTZ().ayE(this.zhr);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95591);
      return;
      paramInt1 = 0;
      break;
      label552:
      paramq = com.tencent.mm.plugin.sns.data.q.k(this.zhs);
      break label442;
      label564:
      String str = com.tencent.mm.plugin.sns.data.q.d(this.zhs);
      if (!i.fv(paramArrayOfByte + str)) {
        u.a(paramArrayOfByte, paramq, str, ag.dUq());
      }
      str = com.tencent.mm.plugin.sns.data.q.e(this.zhs);
      if (!i.fv(paramArrayOfByte + str)) {
        u.b(paramArrayOfByte, paramq, str, ag.dUp());
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
    return n.b.hOp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.o
 * JD-Core Version:    0.7.0.1
 */