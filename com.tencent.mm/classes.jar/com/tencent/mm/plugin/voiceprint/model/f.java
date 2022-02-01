package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n.b;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.csy;
import com.tencent.mm.protocal.protobuf.csz;
import com.tencent.mm.protocal.protobuf.dwk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;

public final class f
  extends com.tencent.mm.al.n
  implements k
{
  public boolean BVp;
  private boolean BVq;
  private Handler BVr;
  int BVs;
  private int BVt;
  int BVu;
  int Nv;
  private com.tencent.mm.al.f callback;
  private String filename;
  private int fq;
  private final b rr;
  
  public f(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(29767);
    this.fq = 0;
    this.BVp = false;
    this.BVq = false;
    this.BVr = null;
    this.BVs = 0;
    this.BVt = 0;
    this.BVu = 0;
    this.Nv = 0;
    ad.d("MicroMsg.NetSceneRegisterVoicePrint", "step %d resid %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.BVu = paramInt1;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new csy();
    ((b.a)localObject).hNN = new csz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/registervoiceprint";
    ((b.a)localObject).funcId = 612;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (csy)this.rr.hNK.hNQ;
    this.filename = paramString;
    this.fq = 0;
    ((csy)localObject).Hlk = paramInt2;
    ((csy)localObject).nEe = paramInt1;
    this.BVs = paramInt3;
    ((csy)localObject).Hli = paramInt3;
    ad.i("MicroMsg.NetSceneRegisterVoicePrint", "voiceRegist %d %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.BVp = true;
    eui();
    AppMethodBeat.o(29767);
  }
  
  private int eui()
  {
    AppMethodBeat.i(29769);
    csy localcsy = (csy)this.rr.hNK.hNQ;
    dwk localdwk = new dwk();
    new g();
    localcsy.Hlj = localdwk;
    Object localObject = new com.tencent.mm.modelvoice.n(m.cd(this.filename, false));
    int i = (int)i.aYo(m.cd(this.filename, false));
    if (i - this.fq >= 6000) {}
    int j;
    for (localObject = ((com.tencent.mm.modelvoice.n)localObject).dr(this.fq, 6000);; localObject = ((com.tencent.mm.modelvoice.n)localObject).dr(j, i - j))
    {
      ad.d("MicroMsg.NetSceneRegisterVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[] { Integer.valueOf(this.fq), Integer.valueOf(((g)localObject).ret), Integer.valueOf(((g)localObject).dhO), Integer.valueOf(i), Boolean.valueOf(this.BVp) });
      if (((g)localObject).dhO != 0) {
        break;
      }
      AppMethodBeat.o(29769);
      return -2;
      j = this.fq;
    }
    if (((g)localObject).ret < 0)
    {
      ad.w("MicroMsg.NetSceneRegisterVoicePrint", "readerror %d", new Object[] { Integer.valueOf(((g)localObject).ret) });
      AppMethodBeat.o(29769);
      return -1;
    }
    if (this.fq >= 469000)
    {
      ad.i("MicroMsg.NetSceneRegisterVoicePrint", "moffset > maxfile %d", new Object[] { Integer.valueOf(this.fq) });
      AppMethodBeat.o(29769);
      return -1;
    }
    localdwk.HIT = new SKBuiltinBuffer_t().setBuffer(((g)localObject).buf);
    localdwk.xcL = this.fq;
    localdwk.HIR = ((g)localObject).dhO;
    localdwk.HIS = 0;
    localcsy.Hli = this.BVs;
    if (this.BVp)
    {
      j = (int)i.aYo(m.cd(this.filename, false));
      if (((g)localObject).iuI >= j)
      {
        localdwk.HIS = 1;
        this.BVq = true;
        ad.i("MicroMsg.NetSceneRegisterVoicePrint", "the last one pack for uploading totallen %d", new Object[] { Integer.valueOf(i) });
      }
    }
    this.fq = ((g)localObject).iuI;
    localcsy.Hlj = localdwk;
    AppMethodBeat.o(29769);
    return 0;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(29768);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(29768);
    return i;
  }
  
  public final int getType()
  {
    return 612;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29770);
    ad.d("MicroMsg.NetSceneRegisterVoicePrint", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (csz)((b)paramq).hNL.hNQ;
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29770);
      return;
    }
    ad.i("MicroMsg.NetSceneRegisterVoicePrint", "voice ticket %d ret %d nextstep %d %d ", new Object[] { Integer.valueOf(paramq.Hli), Integer.valueOf(paramq.Hll), Integer.valueOf(paramq.Hlm), Integer.valueOf(paramq.Hll) });
    this.BVs = paramq.Hli;
    this.BVt = paramq.Hlm;
    this.Nv = paramq.Hll;
    if (this.BVq)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29770);
      return;
    }
    ad.i("MicroMsg.NetSceneRegisterVoicePrint", "tryDoScene ret %d", new Object[] { Integer.valueOf(eui()) });
    doScene(dispatcher(), this.callback);
    ad.i("MicroMsg.NetSceneRegisterVoicePrint", "loop doscene");
    AppMethodBeat.o(29770);
  }
  
  public final int securityLimitCount()
  {
    return 240;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hOp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.f
 * JD-Core Version:    0.7.0.1
 */