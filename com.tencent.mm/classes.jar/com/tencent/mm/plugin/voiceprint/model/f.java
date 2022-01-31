package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.btg;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.protocal.protobuf.cre;
import com.tencent.mm.sdk.platformtools.ab;

public final class f
  extends com.tencent.mm.ai.m
  implements k
{
  int DW;
  private int Fb;
  private com.tencent.mm.ai.f callback;
  private String filename;
  private final b rr;
  public boolean tre;
  private boolean trf;
  private Handler trg;
  int trh;
  private int tri;
  int trj;
  
  public f(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(26086);
    this.Fb = 0;
    this.tre = false;
    this.trf = false;
    this.trg = null;
    this.trh = 0;
    this.tri = 0;
    this.trj = 0;
    this.DW = 0;
    ab.d("MicroMsg.NetSceneRegisterVoicePrint", "step %d resid %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.trj = paramInt1;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new btg();
    ((b.a)localObject).fsY = new bth();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/registervoiceprint";
    ((b.a)localObject).funcId = 612;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (btg)this.rr.fsV.fta;
    this.filename = paramString;
    this.Fb = 0;
    ((btg)localObject).xGP = paramInt2;
    ((btg)localObject).jKr = paramInt1;
    this.trh = paramInt3;
    ((btg)localObject).xGN = paramInt3;
    ab.i("MicroMsg.NetSceneRegisterVoicePrint", "voiceRegist %d %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.tre = true;
    cLe();
    AppMethodBeat.o(26086);
  }
  
  private int cLe()
  {
    AppMethodBeat.i(26088);
    btg localbtg = (btg)this.rr.fsV.fta;
    cre localcre = new cre();
    new g();
    localbtg.xGO = localcre;
    Object localObject = new n(m.bE(this.filename, false));
    int i = (int)com.tencent.mm.vfs.e.avI(m.bE(this.filename, false));
    if (i - this.Fb >= 6000) {}
    int j;
    for (localObject = ((n)localObject).cJ(this.Fb, 6000);; localObject = ((n)localObject).cJ(j, i - j))
    {
      ab.d("MicroMsg.NetSceneRegisterVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[] { Integer.valueOf(this.Fb), Integer.valueOf(((g)localObject).ret), Integer.valueOf(((g)localObject).ckj), Integer.valueOf(i), Boolean.valueOf(this.tre) });
      if (((g)localObject).ckj != 0) {
        break;
      }
      AppMethodBeat.o(26088);
      return -2;
      j = this.Fb;
    }
    if (((g)localObject).ret < 0)
    {
      ab.w("MicroMsg.NetSceneRegisterVoicePrint", "readerror %d", new Object[] { Integer.valueOf(((g)localObject).ret) });
      AppMethodBeat.o(26088);
      return -1;
    }
    if (this.Fb >= 469000)
    {
      ab.i("MicroMsg.NetSceneRegisterVoicePrint", "moffset > maxfile %d", new Object[] { Integer.valueOf(this.Fb) });
      AppMethodBeat.o(26088);
      return -1;
    }
    localcre.xZN = new SKBuiltinBuffer_t().setBuffer(((g)localObject).buf);
    localcre.pIy = this.Fb;
    localcre.xZL = ((g)localObject).ckj;
    localcre.xZM = 0;
    localbtg.xGN = this.trh;
    if (this.tre)
    {
      j = (int)com.tencent.mm.vfs.e.avI(m.bE(this.filename, false));
      if (((g)localObject).fXX >= j)
      {
        localcre.xZM = 1;
        this.trf = true;
        ab.i("MicroMsg.NetSceneRegisterVoicePrint", "the last one pack for uploading totallen %d", new Object[] { Integer.valueOf(i) });
      }
    }
    this.Fb = ((g)localObject).fXX;
    localbtg.xGO = localcre;
    AppMethodBeat.o(26088);
    return 0;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(26087);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(26087);
    return i;
  }
  
  public final int getType()
  {
    return 612;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26089);
    ab.d("MicroMsg.NetSceneRegisterVoicePrint", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (bth)((b)paramq).fsW.fta;
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26089);
      return;
    }
    ab.i("MicroMsg.NetSceneRegisterVoicePrint", "voice ticket %d ret %d nextstep %d %d ", new Object[] { Integer.valueOf(paramq.xGN), Integer.valueOf(paramq.xGQ), Integer.valueOf(paramq.xGR), Integer.valueOf(paramq.xGQ) });
    this.trh = paramq.xGN;
    this.tri = paramq.xGR;
    this.DW = paramq.xGQ;
    if (this.trf)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26089);
      return;
    }
    ab.i("MicroMsg.NetSceneRegisterVoicePrint", "tryDoScene ret %d", new Object[] { Integer.valueOf(cLe()) });
    doScene(dispatcher(), this.callback);
    ab.i("MicroMsg.NetSceneRegisterVoicePrint", "loop doscene");
    AppMethodBeat.o(26089);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.f
 * JD-Core Version:    0.7.0.1
 */