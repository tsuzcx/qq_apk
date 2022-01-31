package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bc.a;
import com.tencent.mm.model.bc.b;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cqq;
import com.tencent.mm.protocal.protobuf.cre;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public final class h
  extends com.tencent.mm.ai.m
  implements k
{
  int DW;
  private int Fb;
  f callback;
  private String filename;
  private final q ftU;
  String gEl;
  public boolean tre;
  private boolean trf;
  private Handler trg;
  private int trh;
  
  public h(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(26097);
    this.Fb = 0;
    this.tre = false;
    this.trf = false;
    this.trg = null;
    this.trh = 0;
    this.DW = 0;
    this.gEl = "";
    ab.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "resid %d vertifyTicket %s", new Object[] { Integer.valueOf(paramInt), bo.bf(paramString2, "") });
    this.ftU = new c();
    bc.a locala = (bc.a)this.ftU.getReqObj();
    this.filename = paramString1;
    this.Fb = 0;
    locala.fmo.xGP = paramInt;
    locala.fmo.xgY = paramString2;
    this.trh = 0;
    locala.fmo.xGN = 0;
    ab.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "voiceRegist %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0) });
    this.tre = true;
    cLe();
    AppMethodBeat.o(26097);
  }
  
  private int cLe()
  {
    AppMethodBeat.i(26099);
    bc.a locala = (bc.a)this.ftU.getReqObj();
    cre localcre = new cre();
    new g();
    locala.fmo.xZe = localcre;
    Object localObject = new n(m.bE(this.filename, false));
    int i = (int)com.tencent.mm.vfs.e.avI(m.bE(this.filename, false));
    if (i - this.Fb >= 6000) {}
    int j;
    for (localObject = ((n)localObject).cJ(this.Fb, 6000);; localObject = ((n)localObject).cJ(j, i - j))
    {
      ab.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[] { Integer.valueOf(this.Fb), Integer.valueOf(((g)localObject).ret), Integer.valueOf(((g)localObject).ckj), Integer.valueOf(i), Boolean.valueOf(this.tre) });
      if (((g)localObject).ckj != 0) {
        break;
      }
      AppMethodBeat.o(26099);
      return -2;
      j = this.Fb;
    }
    if (((g)localObject).ret < 0)
    {
      ab.w("MicroMsg.NetSceneRsaVertifyVoicePrint", "readerror %d", new Object[] { Integer.valueOf(((g)localObject).ret) });
      AppMethodBeat.o(26099);
      return -1;
    }
    if (this.Fb >= 469000)
    {
      ab.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "moffset > maxfile %d", new Object[] { Integer.valueOf(this.Fb) });
      AppMethodBeat.o(26099);
      return -1;
    }
    localcre.xZN = new SKBuiltinBuffer_t().setBuffer(((g)localObject).buf);
    localcre.pIy = this.Fb;
    localcre.xZL = ((g)localObject).ckj;
    localcre.xZM = 0;
    locala.fmo.xGN = this.trh;
    if (this.tre)
    {
      j = (int)com.tencent.mm.vfs.e.avI(m.bE(this.filename, false));
      if (((g)localObject).fXX >= j)
      {
        localcre.xZM = 1;
        this.trf = true;
        ab.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "the last one pack for uploading totallen %d", new Object[] { Integer.valueOf(i) });
      }
    }
    this.Fb = ((g)localObject).fXX;
    locala.fmo.xZe = localcre;
    AppMethodBeat.o(26099);
    return 0;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(26098);
    this.callback = paramf;
    int i = dispatch(parame, this.ftU, this);
    AppMethodBeat.o(26098);
    return i;
  }
  
  public final int getType()
  {
    return 617;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26100);
    ab.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (bc.b)paramq.getRespObj();
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = paramq.getReqObj().getRsaInfo().ver;
      ab.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      aw.RO().ac(new h.1(this, paramInt1));
      AppMethodBeat.o(26100);
      return;
    }
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26100);
      return;
    }
    this.trh = paramArrayOfByte.fmp.xGN;
    this.DW = paramArrayOfByte.fmp.wKy;
    this.gEl = paramArrayOfByte.fmp.xZf;
    int i = paramArrayOfByte.fmp.xGN;
    int j = this.DW;
    boolean bool = bo.isNullOrNil(this.gEl);
    if (bo.isNullOrNil(this.gEl)) {}
    for (paramInt1 = 0;; paramInt1 = this.gEl.length())
    {
      ab.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "voice VoiceTicket %d mResult %d mAuthPwd is null: %b, mAuthPwd.len: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
      if (!this.trf) {
        break;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26100);
      return;
    }
    ab.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "tryDoScene ret %d", new Object[] { Integer.valueOf(cLe()) });
    doScene(dispatcher(), this.callback);
    ab.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "loop doscene");
    AppMethodBeat.o(26100);
  }
  
  public final int securityLimitCount()
  {
    return 240;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.h
 * JD-Core Version:    0.7.0.1
 */