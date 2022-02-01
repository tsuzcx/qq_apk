package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.dzs;
import com.tencent.mm.protocal.protobuf.dzt;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.io.OutputStream;

public final class q
  extends com.tencent.mm.ak.q
  implements m
{
  private String DIl;
  private int DIm;
  int DIn;
  private boolean DIo;
  private String DIp;
  private cnb DIq;
  public i callback;
  private String filename;
  String mediaId;
  private OutputStream output;
  private d rr;
  
  public q(cnb paramcnb, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(95589);
    this.mediaId = "";
    this.output = null;
    this.DIm = -1;
    this.DIn = -1;
    this.DIo = true;
    this.DIp = null;
    this.mediaId = paramString1;
    this.DIq = paramcnb;
    this.DIo = paramBoolean;
    this.DIm = paramInt1;
    this.DIn = paramInt2;
    this.DIp = paramString3;
    this.DIl = ar.ki(aj.getAccSnsPath(), paramString1);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dzs();
    ((d.a)localObject).iLO = new dzt();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsdownload";
    ((d.a)localObject).funcId = 208;
    ((d.a)localObject).iLP = 96;
    ((d.a)localObject).respCmdId = 1000000096;
    this.rr = ((d.a)localObject).aXF();
    dzs localdzs = (dzs)this.rr.iLK.iLR;
    com.tencent.mm.plugin.sns.storage.q localq = aj.faD().aQE(paramString1);
    localObject = localq;
    if (localq == null) {
      localObject = new com.tencent.mm.plugin.sns.storage.q();
    }
    ((com.tencent.mm.plugin.sns.storage.q)localObject).EmQ = paramString1;
    ((com.tencent.mm.plugin.sns.storage.q)localObject).offset = 0;
    aj.faD().a(paramString1, (com.tencent.mm.plugin.sns.storage.q)localObject);
    if (paramBoolean) {}
    for (this.filename = com.tencent.mm.plugin.sns.data.r.n(paramcnb);; this.filename = com.tencent.mm.plugin.sns.data.r.m(paramcnb))
    {
      com.tencent.mm.vfs.s.boN(this.DIl);
      com.tencent.mm.vfs.s.deleteFile(ar.ki(aj.getAccSnsPath(), paramString1) + this.filename);
      localdzs.MZo = paramString2;
      localdzs.MZp = 0;
      localdzs.BsG = 0;
      localdzs.BsF = 0;
      localdzs.oUv = this.DIm;
      Log.d("MicroMsg.NetSceneSnsDownload", "requestKey ".concat(String.valueOf(paramString3)));
      AppMethodBeat.o(95589);
      return;
    }
  }
  
  private void aYw()
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
      Log.printErrStackTrace("MicroMsg.NetSceneSnsDownload", localIOException, "", new Object[0]);
      AppMethodBeat.o(95594);
    }
  }
  
  private int ak(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95593);
    if (!com.tencent.mm.plugin.sns.data.r.aOt(aj.getAccPath()))
    {
      AppMethodBeat.o(95593);
      return 0;
    }
    try
    {
      if (this.output == null)
      {
        com.tencent.mm.vfs.s.boN(this.DIl);
        this.output = com.tencent.mm.vfs.s.dw(this.DIl + this.filename, false);
      }
      Log.d("MicroMsg.NetSceneSnsDownload", "appendBuf " + paramArrayOfByte.length);
      this.output.write(paramArrayOfByte);
      aYw();
      int i = paramArrayOfByte.length;
      AppMethodBeat.o(95593);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneSnsDownload", paramArrayOfByte, "appendBuf failed: " + this.filename, new Object[0]);
      return -1;
    }
    finally
    {
      aYw();
      AppMethodBeat.o(95593);
    }
  }
  
  private void onError()
  {
    AppMethodBeat.i(95592);
    aj.faJ().aOR(this.DIp);
    AppMethodBeat.o(95592);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(95590);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95590);
    return i;
  }
  
  public final int getType()
  {
    return 208;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95591);
    Log.d("MicroMsg.NetSceneSnsDownload", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramArrayOfByte = (d.c)params.getRespObj();
    params = (dzt)((d)params).iLL.iLR;
    if (paramArrayOfByte.getRetCode() != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      aj.faJ().aOR(this.DIp);
      AppMethodBeat.o(95591);
      return;
    }
    paramArrayOfByte = aj.faD().aQE(this.mediaId);
    if (params.BsF <= 0)
    {
      Log.e("MicroMsg.NetSceneSnsDownload", "error 1");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    if (params.KMS == null)
    {
      Log.e("MicroMsg.NetSceneSnsDownload", "error 2");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    if ((params.BsG < 0) || (params.BsG + params.KMS.getBuffer().zy.length > params.BsF))
    {
      Log.e("MicroMsg.NetSceneSnsDownload", "error 3");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    if (params.BsG != paramArrayOfByte.offset)
    {
      Log.e("MicroMsg.NetSceneSnsDownload", "error 4");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    paramInt1 = ak(params.KMS.getBuffer().toByteArray());
    if (paramInt1 < 0)
    {
      Log.e("MicroMsg.NetSceneSnsDownload", "error 5");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    paramArrayOfByte.offset += paramInt1;
    paramArrayOfByte.EmM = params.BsF;
    Log.d("MicroMsg.NetSceneSnsDownload", "byteLen " + paramInt1 + "  totalLen " + params.BsF);
    aj.faD().a(this.mediaId, paramArrayOfByte);
    if ((paramArrayOfByte.offset == paramArrayOfByte.EmM) && (paramArrayOfByte.EmM != 0))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label665;
      }
      Log.d("MicroMsg.NetSceneSnsDownload", "downLoad ok");
      if (this.DIn != 1) {
        break label552;
      }
      params = com.tencent.mm.plugin.sns.data.r.e(this.DIq);
      label442:
      paramArrayOfByte = ar.ki(aj.getAccSnsPath(), this.mediaId);
      com.tencent.mm.vfs.s.deleteFile(paramArrayOfByte + params);
      com.tencent.mm.vfs.s.bo(paramArrayOfByte, this.filename, params);
      if (!this.DIo) {
        break label564;
      }
      com.tencent.mm.plugin.sns.storage.r.b(paramArrayOfByte, params, com.tencent.mm.plugin.sns.data.r.f(this.DIq), aj.fbb());
    }
    for (;;)
    {
      aj.faJ().aOR(this.DIp);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95591);
      return;
      paramInt1 = 0;
      break;
      label552:
      params = com.tencent.mm.plugin.sns.data.r.l(this.DIq);
      break label442;
      label564:
      String str = com.tencent.mm.plugin.sns.data.r.e(this.DIq);
      if (!com.tencent.mm.vfs.s.YS(paramArrayOfByte + str)) {
        com.tencent.mm.plugin.sns.storage.r.a(paramArrayOfByte, params, str, aj.fbc());
      }
      str = com.tencent.mm.plugin.sns.data.r.f(this.DIq);
      if (!com.tencent.mm.vfs.s.YS(paramArrayOfByte + str)) {
        com.tencent.mm.plugin.sns.storage.r.b(paramArrayOfByte, params, str, aj.fbb());
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
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return q.b.iMq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.q
 * JD-Core Version:    0.7.0.1
 */