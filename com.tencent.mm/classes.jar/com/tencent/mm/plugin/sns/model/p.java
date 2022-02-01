package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.dgl;
import com.tencent.mm.protocal.protobuf.dgm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.io.OutputStream;

public final class p
  extends n
  implements k
{
  public f callback;
  private String filename;
  String mediaId;
  private OutputStream output;
  private com.tencent.mm.ak.b rr;
  private String zyc;
  private int zyd;
  int zye;
  private boolean zyf;
  private String zyg;
  private bzh zyh;
  
  public p(bzh parambzh, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(95589);
    this.mediaId = "";
    this.output = null;
    this.zyd = -1;
    this.zye = -1;
    this.zyf = true;
    this.zyg = null;
    this.mediaId = paramString1;
    this.zyh = parambzh;
    this.zyf = paramBoolean;
    this.zyd = paramInt1;
    this.zye = paramInt2;
    this.zyg = paramString3;
    this.zyc = ap.jv(ah.getAccSnsPath(), paramString1);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dgl();
    ((b.a)localObject).hQG = new dgm();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsdownload";
    ((b.a)localObject).funcId = 208;
    ((b.a)localObject).hQH = 96;
    ((b.a)localObject).respCmdId = 1000000096;
    this.rr = ((b.a)localObject).aDS();
    dgl localdgl = (dgl)this.rr.hQD.hQJ;
    t localt = ah.dXt().aBJ(paramString1);
    localObject = localt;
    if (localt == null) {
      localObject = new t();
    }
    ((t)localObject).Aex = paramString1;
    ((t)localObject).offset = 0;
    ah.dXt().a(paramString1, (t)localObject);
    if (paramBoolean) {}
    for (this.filename = r.m(parambzh);; this.filename = r.l(parambzh))
    {
      o.aZI(this.zyc);
      o.deleteFile(ap.jv(ah.getAccSnsPath(), paramString1) + this.filename);
      localdgl.HNG = paramString2;
      localdgl.HNH = 0;
      localdgl.xsC = 0;
      localdgl.xsB = 0;
      localdgl.nJA = this.zyd;
      ae.d("MicroMsg.NetSceneSnsDownload", "requestKey ".concat(String.valueOf(paramString3)));
      AppMethodBeat.o(95589);
      return;
    }
  }
  
  private int W(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95593);
    if (!r.azw(ah.getAccPath()))
    {
      AppMethodBeat.o(95593);
      return 0;
    }
    try
    {
      if (this.output == null)
      {
        o.aZI(this.zyc);
        this.output = o.db(this.zyc + this.filename, false);
      }
      ae.d("MicroMsg.NetSceneSnsDownload", "appendBuf " + paramArrayOfByte.length);
      this.output.write(paramArrayOfByte);
      aEJ();
      int i = paramArrayOfByte.length;
      AppMethodBeat.o(95593);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      ae.printErrStackTrace("MicroMsg.NetSceneSnsDownload", paramArrayOfByte, "appendBuf failed: " + this.filename, new Object[0]);
      return -1;
    }
    finally
    {
      aEJ();
      AppMethodBeat.o(95593);
    }
  }
  
  private void aEJ()
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
      ae.printErrStackTrace("MicroMsg.NetSceneSnsDownload", localIOException, "", new Object[0]);
      AppMethodBeat.o(95594);
    }
  }
  
  private void onError()
  {
    AppMethodBeat.i(95592);
    ah.dXz().azV(this.zyg);
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95591);
    ae.d("MicroMsg.NetSceneSnsDownload", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramArrayOfByte = (b.c)paramq.getRespObj();
    paramq = (dgm)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    if (paramArrayOfByte.getRetCode() != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      ah.dXz().azV(this.zyg);
      AppMethodBeat.o(95591);
      return;
    }
    paramArrayOfByte = ah.dXt().aBJ(this.mediaId);
    if (paramq.xsB <= 0)
    {
      ae.e("MicroMsg.NetSceneSnsDownload", "error 1");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    if (paramq.FTj == null)
    {
      ae.e("MicroMsg.NetSceneSnsDownload", "error 2");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    if ((paramq.xsC < 0) || (paramq.xsC + paramq.FTj.getBuffer().zr.length > paramq.xsB))
    {
      ae.e("MicroMsg.NetSceneSnsDownload", "error 3");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    if (paramq.xsC != paramArrayOfByte.offset)
    {
      ae.e("MicroMsg.NetSceneSnsDownload", "error 4");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    paramInt1 = W(paramq.FTj.getBuffer().toByteArray());
    if (paramInt1 < 0)
    {
      ae.e("MicroMsg.NetSceneSnsDownload", "error 5");
      onError();
      AppMethodBeat.o(95591);
      return;
    }
    paramArrayOfByte.offset += paramInt1;
    paramArrayOfByte.Aet = paramq.xsB;
    ae.d("MicroMsg.NetSceneSnsDownload", "byteLen " + paramInt1 + "  totalLen " + paramq.xsB);
    ah.dXt().a(this.mediaId, paramArrayOfByte);
    if ((paramArrayOfByte.offset == paramArrayOfByte.Aet) && (paramArrayOfByte.Aet != 0))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label665;
      }
      ae.d("MicroMsg.NetSceneSnsDownload", "downLoad ok");
      if (this.zye != 1) {
        break label552;
      }
      paramq = r.d(this.zyh);
      label442:
      paramArrayOfByte = ap.jv(ah.getAccSnsPath(), this.mediaId);
      o.deleteFile(paramArrayOfByte + paramq);
      o.bc(paramArrayOfByte, this.filename, paramq);
      if (!this.zyf) {
        break label564;
      }
      u.b(paramArrayOfByte, paramq, r.e(this.zyh), ah.dXP());
    }
    for (;;)
    {
      ah.dXz().azV(this.zyg);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95591);
      return;
      paramInt1 = 0;
      break;
      label552:
      paramq = r.k(this.zyh);
      break label442;
      label564:
      String str = r.d(this.zyh);
      if (!o.fB(paramArrayOfByte + str)) {
        u.a(paramArrayOfByte, paramq, str, ah.dXQ());
      }
      str = r.e(this.zyh);
      if (!o.fB(paramArrayOfByte + str)) {
        u.b(paramArrayOfByte, paramq, str, ah.dXP());
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
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.p
 * JD-Core Version:    0.7.0.1
 */