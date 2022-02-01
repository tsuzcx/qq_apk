package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.dae;
import com.tencent.mm.protocal.protobuf.daf;
import com.tencent.mm.sdk.platformtools.ac;
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
  private com.tencent.mm.ak.b rr;
  private String xRt;
  private int xRu;
  int xRv;
  private boolean xRw;
  private String xRx;
  private btz xRy;
  
  public o(btz parambtz, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(95589);
    this.mediaId = "";
    this.output = null;
    this.xRu = -1;
    this.xRv = -1;
    this.xRw = true;
    this.xRx = null;
    this.mediaId = paramString1;
    this.xRy = parambtz;
    this.xRw = paramBoolean;
    this.xRu = paramInt1;
    this.xRv = paramInt2;
    this.xRx = paramString3;
    this.xRt = an.jc(af.getAccSnsPath(), paramString1);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dae();
    ((b.a)localObject).hvu = new daf();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsdownload";
    ((b.a)localObject).funcId = 208;
    ((b.a)localObject).reqCmdId = 96;
    ((b.a)localObject).respCmdId = 1000000096;
    this.rr = ((b.a)localObject).aAz();
    dae localdae = (dae)this.rr.hvr.hvw;
    t localt = af.dHG().avl(paramString1);
    localObject = localt;
    if (localt == null) {
      localObject = new t();
    }
    ((t)localObject).ywd = paramString1;
    ((t)localObject).offset = 0;
    af.dHG().a(paramString1, (t)localObject);
    if (paramBoolean) {}
    for (this.filename = com.tencent.mm.plugin.sns.data.q.m(parambtz);; this.filename = com.tencent.mm.plugin.sns.data.q.l(parambtz))
    {
      i.aSh(this.xRt);
      i.deleteFile(an.jc(af.getAccSnsPath(), paramString1) + this.filename);
      localdae.FJv = paramString2;
      localdae.FJw = 0;
      localdae.vTI = 0;
      localdae.vTH = 0;
      localdae.ndI = this.xRu;
      ac.d("MicroMsg.NetSceneSnsDownload", "requestKey ".concat(String.valueOf(paramString3)));
      AppMethodBeat.o(95589);
      return;
    }
  }
  
  private int X(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95593);
    if (!com.tencent.mm.plugin.sns.data.q.ata(af.getAccPath()))
    {
      AppMethodBeat.o(95593);
      return 0;
    }
    try
    {
      if (this.output == null)
      {
        i.aSh(this.xRt);
        this.output = i.cS(this.xRt + this.filename, false);
      }
      ac.d("MicroMsg.NetSceneSnsDownload", "appendBuf " + paramArrayOfByte.length);
      this.output.write(paramArrayOfByte);
      aBr();
      int i = paramArrayOfByte.length;
      AppMethodBeat.o(95593);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      ac.printErrStackTrace("MicroMsg.NetSceneSnsDownload", paramArrayOfByte, "appendBuf failed: " + this.filename, new Object[0]);
      return -1;
    }
    finally
    {
      aBr();
      AppMethodBeat.o(95593);
    }
  }
  
  private void aBr()
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
      ac.printErrStackTrace("MicroMsg.NetSceneSnsDownload", localIOException, "", new Object[0]);
      AppMethodBeat.o(95594);
    }
  }
  
  private void onError()
  {
    AppMethodBeat.i(95592);
    af.dHM().atz(this.xRx);
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
    ac.d("MicroMsg.NetSceneSnsDownload", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramArrayOfByte = (b.c)paramq.getRespObj();
    paramq = (daf)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    if (paramArrayOfByte.getRetCode() != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      af.dHM().atz(this.xRx);
      AppMethodBeat.o(95591);
      return;
    }
    paramArrayOfByte = af.dHG().avl(this.mediaId);
    if (paramq.vTH <= 0)
    {
      ac.e("MicroMsg.NetSceneSnsDownload", "error 1");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    if (paramq.DVs == null)
    {
      ac.e("MicroMsg.NetSceneSnsDownload", "error 2");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    if ((paramq.vTI < 0) || (paramq.vTI + paramq.DVs.getBuffer().xy.length > paramq.vTH))
    {
      ac.e("MicroMsg.NetSceneSnsDownload", "error 3");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    if (paramq.vTI != paramArrayOfByte.offset)
    {
      ac.e("MicroMsg.NetSceneSnsDownload", "error 4");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    paramInt1 = X(paramq.DVs.getBuffer().toByteArray());
    if (paramInt1 < 0)
    {
      ac.e("MicroMsg.NetSceneSnsDownload", "error 5");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    paramArrayOfByte.offset += paramInt1;
    paramArrayOfByte.yvZ = paramq.vTH;
    ac.d("MicroMsg.NetSceneSnsDownload", "byteLen " + paramInt1 + "  totalLen " + paramq.vTH);
    af.dHG().a(this.mediaId, paramArrayOfByte);
    if ((paramArrayOfByte.offset == paramArrayOfByte.yvZ) && (paramArrayOfByte.yvZ != 0))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label665;
      }
      ac.d("MicroMsg.NetSceneSnsDownload", "downLoad ok");
      if (this.xRv != 1) {
        break label552;
      }
      paramq = com.tencent.mm.plugin.sns.data.q.d(this.xRy);
      label442:
      paramArrayOfByte = an.jc(af.getAccSnsPath(), this.mediaId);
      i.deleteFile(paramArrayOfByte + paramq);
      i.aT(paramArrayOfByte, this.filename, paramq);
      if (!this.xRw) {
        break label564;
      }
      u.b(paramArrayOfByte, paramq, com.tencent.mm.plugin.sns.data.q.e(this.xRy), af.dIc());
    }
    for (;;)
    {
      af.dHM().atz(this.xRx);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95591);
      return;
      paramInt1 = 0;
      break;
      label552:
      paramq = com.tencent.mm.plugin.sns.data.q.k(this.xRy);
      break label442;
      label564:
      String str = com.tencent.mm.plugin.sns.data.q.d(this.xRy);
      if (!i.eA(paramArrayOfByte + str)) {
        u.a(paramArrayOfByte, paramq, str, af.dId());
      }
      str = com.tencent.mm.plugin.sns.data.q.e(this.xRy);
      if (!i.eA(paramArrayOfByte + str)) {
        u.b(paramArrayOfByte, paramq, str, af.dIc());
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
    return n.b.hwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.o
 * JD-Core Version:    0.7.0.1
 */