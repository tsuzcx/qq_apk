package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cip;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.protocal.protobuf.dkz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;

public final class f
  extends com.tencent.mm.al.n
  implements k
{
  int KI;
  private int LZ;
  private com.tencent.mm.al.g callback;
  private String filename;
  private final b rr;
  public boolean zdo;
  private boolean zdp;
  private Handler zdq;
  int zdr;
  private int zds;
  int zdt;
  
  public f(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(29767);
    this.LZ = 0;
    this.zdo = false;
    this.zdp = false;
    this.zdq = null;
    this.zdr = 0;
    this.zds = 0;
    this.zdt = 0;
    this.KI = 0;
    ad.d("MicroMsg.NetSceneRegisterVoicePrint", "step %d resid %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.zdt = paramInt1;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cip();
    ((b.a)localObject).gUV = new ciq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/registervoiceprint";
    ((b.a)localObject).funcId = 612;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (cip)this.rr.gUS.gUX;
    this.filename = paramString;
    this.LZ = 0;
    ((cip)localObject).EdY = paramInt2;
    ((cip)localObject).mBG = paramInt1;
    this.zdr = paramInt3;
    ((cip)localObject).EdW = paramInt3;
    ad.i("MicroMsg.NetSceneRegisterVoicePrint", "voiceRegist %d %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.zdo = true;
    dRm();
    AppMethodBeat.o(29767);
  }
  
  private int dRm()
  {
    AppMethodBeat.i(29769);
    cip localcip = (cip)this.rr.gUS.gUX;
    dkz localdkz = new dkz();
    new com.tencent.mm.modelvoice.g();
    localcip.EdX = localdkz;
    Object localObject = new com.tencent.mm.modelvoice.n(m.bP(this.filename, false));
    int i = (int)i.aMN(m.bP(this.filename, false));
    if (i - this.LZ >= 6000) {}
    int j;
    for (localObject = ((com.tencent.mm.modelvoice.n)localObject).dp(this.LZ, 6000);; localObject = ((com.tencent.mm.modelvoice.n)localObject).dp(j, i - j))
    {
      ad.d("MicroMsg.NetSceneRegisterVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[] { Integer.valueOf(this.LZ), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).cZc), Integer.valueOf(i), Boolean.valueOf(this.zdo) });
      if (((com.tencent.mm.modelvoice.g)localObject).cZc != 0) {
        break;
      }
      AppMethodBeat.o(29769);
      return -2;
      j = this.LZ;
    }
    if (((com.tencent.mm.modelvoice.g)localObject).ret < 0)
    {
      ad.w("MicroMsg.NetSceneRegisterVoicePrint", "readerror %d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret) });
      AppMethodBeat.o(29769);
      return -1;
    }
    if (this.LZ >= 469000)
    {
      ad.i("MicroMsg.NetSceneRegisterVoicePrint", "moffset > maxfile %d", new Object[] { Integer.valueOf(this.LZ) });
      AppMethodBeat.o(29769);
      return -1;
    }
    localdkz.EAK = new SKBuiltinBuffer_t().setBuffer(((com.tencent.mm.modelvoice.g)localObject).buf);
    localdkz.uKR = this.LZ;
    localdkz.EAI = ((com.tencent.mm.modelvoice.g)localObject).cZc;
    localdkz.EAJ = 0;
    localcip.EdW = this.zdr;
    if (this.zdo)
    {
      j = (int)i.aMN(m.bP(this.filename, false));
      if (((com.tencent.mm.modelvoice.g)localObject).hAL >= j)
      {
        localdkz.EAJ = 1;
        this.zdp = true;
        ad.i("MicroMsg.NetSceneRegisterVoicePrint", "the last one pack for uploading totallen %d", new Object[] { Integer.valueOf(i) });
      }
    }
    this.LZ = ((com.tencent.mm.modelvoice.g)localObject).hAL;
    localcip.EdX = localdkz;
    AppMethodBeat.o(29769);
    return 0;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(29768);
    this.callback = paramg;
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
    paramq = (ciq)((b)paramq).gUT.gUX;
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29770);
      return;
    }
    ad.i("MicroMsg.NetSceneRegisterVoicePrint", "voice ticket %d ret %d nextstep %d %d ", new Object[] { Integer.valueOf(paramq.EdW), Integer.valueOf(paramq.EdZ), Integer.valueOf(paramq.Eea), Integer.valueOf(paramq.EdZ) });
    this.zdr = paramq.EdW;
    this.zds = paramq.Eea;
    this.KI = paramq.EdZ;
    if (this.zdp)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29770);
      return;
    }
    ad.i("MicroMsg.NetSceneRegisterVoicePrint", "tryDoScene ret %d", new Object[] { Integer.valueOf(dRm()) });
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
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.f
 * JD-Core Version:    0.7.0.1
 */