package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cqn;
import com.tencent.mm.protocal.protobuf.cqo;
import com.tencent.mm.protocal.protobuf.cre;
import com.tencent.mm.sdk.platformtools.ab;

public final class j
  extends com.tencent.mm.ai.m
  implements k
{
  int DW;
  private int Fb;
  private f callback;
  private String filename;
  private String gEl;
  private final b rr;
  public boolean tre;
  private boolean trf;
  private Handler trg;
  private int trh;
  
  public j(String paramString, int paramInt)
  {
    AppMethodBeat.i(26104);
    this.Fb = 0;
    this.tre = false;
    this.trf = false;
    this.trg = null;
    this.trh = 0;
    this.DW = 0;
    this.gEl = "";
    ab.d("MicroMsg.NetSceneVerifyVoicePrint", "resid %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cqn();
    ((b.a)localObject).fsY = new cqo();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyvoiceprint";
    ((b.a)localObject).funcId = 613;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (cqn)this.rr.fsV.fta;
    this.filename = paramString;
    this.Fb = 0;
    ((cqn)localObject).xGP = paramInt;
    this.trh = 0;
    ((cqn)localObject).xGN = 0;
    ab.i("MicroMsg.NetSceneVerifyVoicePrint", "voiceRegist %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0) });
    this.tre = true;
    cLe();
    AppMethodBeat.o(26104);
  }
  
  private int cLe()
  {
    AppMethodBeat.i(26106);
    cqn localcqn = (cqn)this.rr.fsV.fta;
    cre localcre = new cre();
    new g();
    localcqn.xZe = localcre;
    Object localObject = new n(m.bE(this.filename, false));
    int i = (int)com.tencent.mm.vfs.e.avI(m.bE(this.filename, false));
    if (i - this.Fb >= 6000) {}
    int j;
    for (localObject = ((n)localObject).cJ(this.Fb, 6000);; localObject = ((n)localObject).cJ(j, i - j))
    {
      ab.d("MicroMsg.NetSceneVerifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[] { Integer.valueOf(this.Fb), Integer.valueOf(((g)localObject).ret), Integer.valueOf(((g)localObject).ckj), Integer.valueOf(i), Boolean.valueOf(this.tre) });
      if (((g)localObject).ckj != 0) {
        break;
      }
      AppMethodBeat.o(26106);
      return -2;
      j = this.Fb;
    }
    if (((g)localObject).ret < 0)
    {
      ab.w("MicroMsg.NetSceneVerifyVoicePrint", "readerror %d", new Object[] { Integer.valueOf(((g)localObject).ret) });
      AppMethodBeat.o(26106);
      return -1;
    }
    if (this.Fb >= 469000)
    {
      ab.i("MicroMsg.NetSceneVerifyVoicePrint", "moffset > maxfile %d", new Object[] { Integer.valueOf(this.Fb) });
      AppMethodBeat.o(26106);
      return -1;
    }
    localcre.xZN = new SKBuiltinBuffer_t().setBuffer(((g)localObject).buf);
    localcre.pIy = this.Fb;
    localcre.xZL = ((g)localObject).ckj;
    localcre.xZM = 0;
    localcqn.xGN = this.trh;
    if (this.tre)
    {
      j = (int)com.tencent.mm.vfs.e.avI(m.bE(this.filename, false));
      if (((g)localObject).fXX >= j)
      {
        localcre.xZM = 1;
        this.trf = true;
        ab.i("MicroMsg.NetSceneVerifyVoicePrint", "the last one pack for uploading totallen %d", new Object[] { Integer.valueOf(i) });
      }
    }
    this.Fb = ((g)localObject).fXX;
    localcqn.xZe = localcre;
    AppMethodBeat.o(26106);
    return 0;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(26105);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(26105);
    return i;
  }
  
  public final int getType()
  {
    return 613;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26107);
    ab.d("MicroMsg.NetSceneVerifyVoicePrint", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (cqo)((b)paramq).fsW.fta;
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26107);
      return;
    }
    this.trh = paramq.xGN;
    this.DW = paramq.wKy;
    ab.i("MicroMsg.NetSceneVerifyVoicePrint", "voice VoiceTicket %d mResult %d", new Object[] { Integer.valueOf(paramq.xGN), Integer.valueOf(this.DW) });
    if (this.trf)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26107);
      return;
    }
    ab.i("MicroMsg.NetSceneVerifyVoicePrint", "tryDoScene ret %d", new Object[] { Integer.valueOf(cLe()) });
    doScene(dispatcher(), this.callback);
    ab.i("MicroMsg.NetSceneVerifyVoicePrint", "loop doscene");
    AppMethodBeat.o(26107);
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
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.j
 * JD-Core Version:    0.7.0.1
 */