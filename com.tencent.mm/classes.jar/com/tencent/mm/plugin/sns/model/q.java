package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q.b;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.ejs;
import com.tencent.mm.protocal.protobuf.ejt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.io.OutputStream;

public final class q
  extends com.tencent.mm.an.q
  implements m
{
  private String JVl;
  private int JVm;
  int JVn;
  private boolean JVo;
  private String JVp;
  private cvt JVq;
  public i callback;
  private String filename;
  String mediaId;
  private OutputStream output;
  private d rr;
  
  public q(cvt paramcvt, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(95589);
    this.mediaId = "";
    this.output = null;
    this.JVm = -1;
    this.JVn = -1;
    this.JVo = true;
    this.JVp = null;
    this.mediaId = paramString1;
    this.JVq = paramcvt;
    this.JVo = paramBoolean;
    this.JVm = paramInt1;
    this.JVn = paramInt2;
    this.JVp = paramString3;
    this.JVl = aq.kD(aj.getAccSnsPath(), paramString1);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ejs();
    ((d.a)localObject).lBV = new ejt();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsdownload";
    ((d.a)localObject).funcId = 208;
    ((d.a)localObject).lBW = 96;
    ((d.a)localObject).respCmdId = 1000000096;
    this.rr = ((d.a)localObject).bgN();
    ejs localejs = (ejs)d.b.b(this.rr.lBR);
    com.tencent.mm.plugin.sns.storage.q localq = aj.fOx().bbE(paramString1);
    localObject = localq;
    if (localq == null) {
      localObject = new com.tencent.mm.plugin.sns.storage.q();
    }
    ((com.tencent.mm.plugin.sns.storage.q)localObject).KzZ = paramString1;
    ((com.tencent.mm.plugin.sns.storage.q)localObject).offset = 0;
    aj.fOx().a(paramString1, (com.tencent.mm.plugin.sns.storage.q)localObject);
    if (paramBoolean) {}
    for (this.filename = t.m(paramcvt);; this.filename = t.l(paramcvt))
    {
      u.bBD(this.JVl);
      u.deleteFile(aq.kD(aj.getAccSnsPath(), paramString1) + this.filename);
      localejs.UlI = paramString2;
      localejs.UlJ = 0;
      localejs.Hna = 0;
      localejs.HmZ = 0;
      localejs.rWu = this.JVm;
      Log.d("MicroMsg.NetSceneSnsDownload", "requestKey ".concat(String.valueOf(paramString3)));
      AppMethodBeat.o(95589);
      return;
    }
  }
  
  private int au(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95593);
    if (!t.aZp(aj.getAccPath()))
    {
      AppMethodBeat.o(95593);
      return 0;
    }
    try
    {
      if (this.output == null)
      {
        u.bBD(this.JVl);
        this.output = u.Te(this.JVl + this.filename);
      }
      Log.d("MicroMsg.NetSceneSnsDownload", "appendBuf " + paramArrayOfByte.length);
      this.output.write(paramArrayOfByte);
      bhK();
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
      bhK();
      AppMethodBeat.o(95593);
    }
  }
  
  private void bhK()
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
  
  private void onError()
  {
    AppMethodBeat.i(95592);
    aj.fOD().aZM(this.JVp);
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95591);
    Log.d("MicroMsg.NetSceneSnsDownload", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramArrayOfByte = (d.c)params.getRespObj();
    params = (ejt)d.c.b(((d)params).lBS);
    if (paramArrayOfByte.getRetCode() != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      aj.fOD().aZM(this.JVp);
      AppMethodBeat.o(95591);
      return;
    }
    paramArrayOfByte = aj.fOx().bbE(this.mediaId);
    if (params.HmZ <= 0)
    {
      Log.e("MicroMsg.NetSceneSnsDownload", "error 1");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    if (params.RNM == null)
    {
      Log.e("MicroMsg.NetSceneSnsDownload", "error 2");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    if ((params.Hna < 0) || (params.Hna + params.RNM.Tkb.UH.length > params.HmZ))
    {
      Log.e("MicroMsg.NetSceneSnsDownload", "error 3");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    if (params.Hna != paramArrayOfByte.offset)
    {
      Log.e("MicroMsg.NetSceneSnsDownload", "error 4");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    paramInt1 = au(params.RNM.Tkb.toByteArray());
    if (paramInt1 < 0)
    {
      Log.e("MicroMsg.NetSceneSnsDownload", "error 5");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    paramArrayOfByte.offset += paramInt1;
    paramArrayOfByte.KzV = params.HmZ;
    Log.d("MicroMsg.NetSceneSnsDownload", "byteLen " + paramInt1 + "  totalLen " + params.HmZ);
    aj.fOx().a(this.mediaId, paramArrayOfByte);
    if ((paramArrayOfByte.offset == paramArrayOfByte.KzV) && (paramArrayOfByte.KzV != 0))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label665;
      }
      Log.d("MicroMsg.NetSceneSnsDownload", "downLoad ok");
      if (this.JVn != 1) {
        break label552;
      }
      params = t.d(this.JVq);
      label442:
      paramArrayOfByte = aq.kD(aj.getAccSnsPath(), this.mediaId);
      u.deleteFile(paramArrayOfByte + params);
      u.bj(paramArrayOfByte, this.filename, params);
      if (!this.JVo) {
        break label564;
      }
      r.b(paramArrayOfByte, params, t.e(this.JVq), aj.fOV());
    }
    for (;;)
    {
      aj.fOD().aZM(this.JVp);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95591);
      return;
      paramInt1 = 0;
      break;
      label552:
      params = t.k(this.JVq);
      break label442;
      label564:
      String str = t.d(this.JVq);
      if (!u.agG(paramArrayOfByte + str)) {
        r.a(paramArrayOfByte, params, str, aj.fOW());
      }
      str = t.e(this.JVq);
      if (!u.agG(paramArrayOfByte + str)) {
        r.b(paramArrayOfByte, params, str, aj.fOV());
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
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.q
 * JD-Core Version:    0.7.0.1
 */