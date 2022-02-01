package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.aa;
import com.tencent.mm.plugin.sns.storage.z;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.fdz;
import com.tencent.mm.protocal.protobuf.fea;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.io.OutputStream;

public final class q
  extends p
  implements m
{
  private String Qsm;
  private int Qsn;
  int Qso;
  private boolean Qsp;
  private String Qsq;
  private dmz Qsr;
  public h callback;
  private String filename;
  String mediaId;
  private OutputStream osU;
  private com.tencent.mm.am.c rr;
  
  public q(dmz paramdmz, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(95589);
    this.mediaId = "";
    this.osU = null;
    this.Qsn = -1;
    this.Qso = -1;
    this.Qsp = true;
    this.Qsq = null;
    this.mediaId = paramString1;
    this.Qsr = paramdmz;
    this.Qsp = paramBoolean;
    this.Qsn = paramInt1;
    this.Qso = paramInt2;
    this.Qsq = paramString3;
    this.Qsm = as.mg(al.getAccSnsPath(), paramString1);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fdz();
    ((c.a)localObject).otF = new fea();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsdownload";
    ((c.a)localObject).funcId = 208;
    ((c.a)localObject).otG = 96;
    ((c.a)localObject).respCmdId = 1000000096;
    this.rr = ((c.a)localObject).bEF();
    fdz localfdz = (fdz)c.b.b(this.rr.otB);
    z localz = al.hgq().bal(paramString1);
    localObject = localz;
    if (localz == null) {
      localObject = new z();
    }
    ((z)localObject).strId = paramString1;
    ((z)localObject).offset = 0;
    al.hgq().a(paramString1, (z)localObject);
    if (paramBoolean) {}
    for (this.filename = t.m(paramdmz);; this.filename = t.l(paramdmz))
    {
      y.bDX(this.Qsm);
      y.deleteFile(as.mg(al.getAccSnsPath(), paramString1) + this.filename);
      localfdz.abDD = paramString2;
      localfdz.abDE = 0;
      localfdz.NkO = 0;
      localfdz.NkN = 0;
      localfdz.vhJ = this.Qsn;
      Log.d("MicroMsg.NetSceneSnsDownload", "requestKey ".concat(String.valueOf(paramString3)));
      AppMethodBeat.o(95589);
      return;
    }
  }
  
  private void atR()
  {
    AppMethodBeat.i(95592);
    al.hgw().aXZ(this.Qsq);
    AppMethodBeat.o(95592);
  }
  
  private int au(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95593);
    if (!t.aXA(al.getAccPath()))
    {
      AppMethodBeat.o(95593);
      return 0;
    }
    try
    {
      if (this.osU == null)
      {
        y.bDX(this.Qsm);
        this.osU = y.ev(this.Qsm + this.filename, false);
      }
      Log.d("MicroMsg.NetSceneSnsDownload", "appendBuf " + paramArrayOfByte.length);
      this.osU.write(paramArrayOfByte);
      bFz();
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
      bFz();
      AppMethodBeat.o(95593);
    }
  }
  
  private void bFz()
  {
    AppMethodBeat.i(95594);
    try
    {
      if (this.osU != null)
      {
        this.osU.flush();
        this.osU.close();
        this.osU = null;
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
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(95590);
    this.callback = paramh;
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
    paramArrayOfByte = (c.c)params.getRespObj();
    params = (fea)c.c.b(((com.tencent.mm.am.c)params).otC);
    if (paramArrayOfByte.getRetCode() != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      al.hgw().aXZ(this.Qsq);
      AppMethodBeat.o(95591);
      return;
    }
    paramArrayOfByte = al.hgq().bal(this.mediaId);
    if (params.NkN <= 0)
    {
      Log.e("MicroMsg.NetSceneSnsDownload", "error 1");
      atR();
      AppMethodBeat.o(95591);
      return;
    }
    if (params.YLa == null)
    {
      Log.e("MicroMsg.NetSceneSnsDownload", "error 2");
      atR();
      AppMethodBeat.o(95591);
      return;
    }
    if ((params.NkO < 0) || (params.NkO + params.YLa.aaxD.Op.length > params.NkN))
    {
      Log.e("MicroMsg.NetSceneSnsDownload", "error 3");
      atR();
      AppMethodBeat.o(95591);
      return;
    }
    if (params.NkO != paramArrayOfByte.offset)
    {
      Log.e("MicroMsg.NetSceneSnsDownload", "error 4");
      atR();
      AppMethodBeat.o(95591);
      return;
    }
    paramInt1 = au(params.YLa.aaxD.toByteArray());
    if (paramInt1 < 0)
    {
      Log.e("MicroMsg.NetSceneSnsDownload", "error 5");
      atR();
      AppMethodBeat.o(95591);
      return;
    }
    paramArrayOfByte.offset += paramInt1;
    paramArrayOfByte.QZs = params.NkN;
    Log.d("MicroMsg.NetSceneSnsDownload", "byteLen " + paramInt1 + "  totalLen " + params.NkN);
    al.hgq().a(this.mediaId, paramArrayOfByte);
    if ((paramArrayOfByte.offset == paramArrayOfByte.QZs) && (paramArrayOfByte.QZs != 0))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label662;
      }
      Log.d("MicroMsg.NetSceneSnsDownload", "downLoad ok");
      if (this.Qso != 1) {
        break label549;
      }
      params = t.d(this.Qsr);
      label439:
      paramArrayOfByte = as.mg(al.getAccSnsPath(), this.mediaId);
      y.deleteFile(paramArrayOfByte + params);
      y.bF(paramArrayOfByte, this.filename, params);
      if (!this.Qsp) {
        break label561;
      }
      aa.b(paramArrayOfByte, params, t.e(this.Qsr), al.hgP());
    }
    for (;;)
    {
      al.hgw().aXZ(this.Qsq);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95591);
      return;
      paramInt1 = 0;
      break;
      label549:
      params = t.k(this.Qsr);
      break label439;
      label561:
      String str = t.d(this.Qsr);
      if (!y.ZC(paramArrayOfByte + str)) {
        aa.a(paramArrayOfByte, params, str, al.hgQ());
      }
      str = t.e(this.Qsr);
      if (!y.ZC(paramArrayOfByte + str)) {
        aa.b(paramArrayOfByte, params, str, al.hgP());
      }
    }
    label662:
    doScene(dispatcher(), this.callback);
    AppMethodBeat.o(95591);
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.q
 * JD-Core Version:    0.7.0.1
 */