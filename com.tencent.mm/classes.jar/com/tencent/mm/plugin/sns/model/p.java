package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.cdw;
import com.tencent.mm.protocal.protobuf.cdx;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.io.OutputStream;

public final class p
  extends m
  implements k
{
  String cBO;
  public f callback;
  private String filename;
  private OutputStream output;
  private String reC;
  private int reD;
  int reE;
  private boolean reF;
  private String reG;
  private bcs reH;
  private com.tencent.mm.ai.b rr;
  
  public p(bcs parambcs, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(36264);
    this.cBO = "";
    this.output = null;
    this.reD = -1;
    this.reE = -1;
    this.reF = true;
    this.reG = null;
    this.cBO = paramString1;
    this.reH = parambcs;
    this.reF = paramBoolean;
    this.reD = paramInt1;
    this.reE = paramInt2;
    this.reG = paramString3;
    this.reC = ao.gl(ag.getAccSnsPath(), paramString1);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cdw();
    ((b.a)localObject).fsY = new cdx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsdownload";
    ((b.a)localObject).funcId = 208;
    ((b.a)localObject).reqCmdId = 96;
    ((b.a)localObject).respCmdId = 1000000096;
    this.rr = ((b.a)localObject).ado();
    cdw localcdw = (cdw)this.rr.fsV.fta;
    r localr = ag.coU().abK(paramString1);
    localObject = localr;
    if (localr == null) {
      localObject = new r();
    }
    ((r)localObject).rDF = paramString1;
    ((r)localObject).offset = 0;
    ag.coU().a(paramString1, (r)localObject);
    if (paramBoolean) {}
    for (this.filename = i.n(parambcs);; this.filename = i.m(parambcs))
    {
      com.tencent.mm.vfs.e.um(this.reC);
      com.tencent.mm.vfs.e.deleteFile(ao.gl(ag.getAccSnsPath(), paramString1) + this.filename);
      localcdw.xOt = paramString2;
      localcdw.xOu = 0;
      localcdw.pIy = 0;
      localcdw.pIx = 0;
      localcdw.jKs = this.reD;
      ab.d("MicroMsg.NetSceneSnsDownload", "requestKey ".concat(String.valueOf(paramString3)));
      AppMethodBeat.o(36264);
      return;
    }
  }
  
  private int Q(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(36268);
    if (!i.ZK(ag.getAccPath()))
    {
      AppMethodBeat.o(36268);
      return 0;
    }
    try
    {
      if (this.output == null)
      {
        com.tencent.mm.vfs.e.um(this.reC);
        this.output = com.tencent.mm.vfs.e.M(this.reC + this.filename, false);
      }
      ab.d("MicroMsg.NetSceneSnsDownload", "appendBuf " + paramArrayOfByte.length);
      this.output.write(paramArrayOfByte);
      ada();
      int i = paramArrayOfByte.length;
      AppMethodBeat.o(36268);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      ab.printErrStackTrace("MicroMsg.NetSceneSnsDownload", paramArrayOfByte, "appendBuf failed: " + this.filename, new Object[0]);
      return -1;
    }
    finally
    {
      ada();
      AppMethodBeat.o(36268);
    }
  }
  
  private void ada()
  {
    AppMethodBeat.i(36269);
    try
    {
      if (this.output != null)
      {
        this.output.flush();
        this.output.close();
        this.output = null;
      }
      AppMethodBeat.o(36269);
      return;
    }
    catch (IOException localIOException)
    {
      ab.printErrStackTrace("MicroMsg.NetSceneSnsDownload", localIOException, "", new Object[0]);
      AppMethodBeat.o(36269);
    }
  }
  
  private void onError()
  {
    AppMethodBeat.i(36267);
    ag.cpa().aaf(this.reG);
    AppMethodBeat.o(36267);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(36265);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(36265);
    return i;
  }
  
  public final int getType()
  {
    return 208;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(36266);
    ab.d("MicroMsg.NetSceneSnsDownload", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramArrayOfByte = (b.c)paramq.getRespObj();
    paramq = (cdx)((com.tencent.mm.ai.b)paramq).fsW.fta;
    if (paramArrayOfByte.getRetCode() != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      ag.cpa().aaf(this.reG);
      AppMethodBeat.o(36266);
      return;
    }
    paramArrayOfByte = ag.coU().abK(this.cBO);
    if (paramq.pIx <= 0)
    {
      ab.e("MicroMsg.NetSceneSnsDownload", "error 1");
      onError();
      AppMethodBeat.o(36266);
      return;
    }
    if (paramq.wtq == null)
    {
      ab.e("MicroMsg.NetSceneSnsDownload", "error 2");
      onError();
      AppMethodBeat.o(36266);
      return;
    }
    if ((paramq.pIy < 0) || (paramq.pIy + paramq.wtq.getBuffer().pW.length > paramq.pIx))
    {
      ab.e("MicroMsg.NetSceneSnsDownload", "error 3");
      onError();
      AppMethodBeat.o(36266);
      return;
    }
    if (paramq.pIy != paramArrayOfByte.offset)
    {
      ab.e("MicroMsg.NetSceneSnsDownload", "error 4");
      onError();
      AppMethodBeat.o(36266);
      return;
    }
    paramInt1 = Q(paramq.wtq.getBuffer().toByteArray());
    if (paramInt1 < 0)
    {
      ab.e("MicroMsg.NetSceneSnsDownload", "error 5");
      onError();
      AppMethodBeat.o(36266);
      return;
    }
    paramArrayOfByte.offset += paramInt1;
    paramArrayOfByte.rDB = paramq.pIx;
    ab.d("MicroMsg.NetSceneSnsDownload", "byteLen " + paramInt1 + "  totalLen " + paramq.pIx);
    ag.coU().a(this.cBO, paramArrayOfByte);
    if ((paramArrayOfByte.offset == paramArrayOfByte.rDB) && (paramArrayOfByte.rDB != 0))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label665;
      }
      ab.d("MicroMsg.NetSceneSnsDownload", "downLoad ok");
      if (this.reE != 1) {
        break label552;
      }
      paramq = i.e(this.reH);
      label442:
      paramArrayOfByte = ao.gl(ag.getAccSnsPath(), this.cBO);
      com.tencent.mm.vfs.e.deleteFile(paramArrayOfByte + paramq);
      com.tencent.mm.vfs.e.h(paramArrayOfByte, this.filename, paramq);
      if (!this.reF) {
        break label564;
      }
      s.b(paramArrayOfByte, paramq, i.f(this.reH), ag.cpn());
    }
    for (;;)
    {
      ag.cpa().aaf(this.reG);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(36266);
      return;
      paramInt1 = 0;
      break;
      label552:
      paramq = i.l(this.reH);
      break label442;
      label564:
      String str = i.e(this.reH);
      if (!com.tencent.mm.vfs.e.cN(paramArrayOfByte + str)) {
        s.a(paramArrayOfByte, paramq, str, ag.cpo());
      }
      str = i.f(this.reH);
      if (!com.tencent.mm.vfs.e.cN(paramArrayOfByte + str)) {
        s.b(paramArrayOfByte, paramq, str, ag.cpn());
      }
    }
    label665:
    doScene(dispatcher(), this.callback);
    AppMethodBeat.o(36266);
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.p
 * JD-Core Version:    0.7.0.1
 */