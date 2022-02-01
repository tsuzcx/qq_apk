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
import com.tencent.mm.protocal.protobuf.djz;
import com.tencent.mm.protocal.protobuf.dka;
import com.tencent.mm.protocal.protobuf.dkz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;

public final class j
  extends com.tencent.mm.al.n
  implements k
{
  int KI;
  private int LZ;
  private com.tencent.mm.al.g callback;
  private String filename;
  private String iri;
  private final b rr;
  public boolean zdo;
  private boolean zdp;
  private Handler zdq;
  private int zdr;
  
  public j(String paramString, int paramInt)
  {
    AppMethodBeat.i(29785);
    this.LZ = 0;
    this.zdo = false;
    this.zdp = false;
    this.zdq = null;
    this.zdr = 0;
    this.KI = 0;
    this.iri = "";
    ad.d("MicroMsg.NetSceneVerifyVoicePrint", "resid %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new djz();
    ((b.a)localObject).gUV = new dka();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyvoiceprint";
    ((b.a)localObject).funcId = 613;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (djz)this.rr.gUS.gUX;
    this.filename = paramString;
    this.LZ = 0;
    ((djz)localObject).EdY = paramInt;
    this.zdr = 0;
    ((djz)localObject).EdW = 0;
    ad.i("MicroMsg.NetSceneVerifyVoicePrint", "voiceRegist %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0) });
    this.zdo = true;
    dRm();
    AppMethodBeat.o(29785);
  }
  
  private int dRm()
  {
    AppMethodBeat.i(29787);
    djz localdjz = (djz)this.rr.gUS.gUX;
    dkz localdkz = new dkz();
    new com.tencent.mm.modelvoice.g();
    localdjz.EzQ = localdkz;
    Object localObject = new com.tencent.mm.modelvoice.n(m.bP(this.filename, false));
    int i = (int)i.aMN(m.bP(this.filename, false));
    if (i - this.LZ >= 6000) {}
    int j;
    for (localObject = ((com.tencent.mm.modelvoice.n)localObject).dp(this.LZ, 6000);; localObject = ((com.tencent.mm.modelvoice.n)localObject).dp(j, i - j))
    {
      ad.d("MicroMsg.NetSceneVerifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[] { Integer.valueOf(this.LZ), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).cZc), Integer.valueOf(i), Boolean.valueOf(this.zdo) });
      if (((com.tencent.mm.modelvoice.g)localObject).cZc != 0) {
        break;
      }
      AppMethodBeat.o(29787);
      return -2;
      j = this.LZ;
    }
    if (((com.tencent.mm.modelvoice.g)localObject).ret < 0)
    {
      ad.w("MicroMsg.NetSceneVerifyVoicePrint", "readerror %d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret) });
      AppMethodBeat.o(29787);
      return -1;
    }
    if (this.LZ >= 469000)
    {
      ad.i("MicroMsg.NetSceneVerifyVoicePrint", "moffset > maxfile %d", new Object[] { Integer.valueOf(this.LZ) });
      AppMethodBeat.o(29787);
      return -1;
    }
    localdkz.EAK = new SKBuiltinBuffer_t().setBuffer(((com.tencent.mm.modelvoice.g)localObject).buf);
    localdkz.uKR = this.LZ;
    localdkz.EAI = ((com.tencent.mm.modelvoice.g)localObject).cZc;
    localdkz.EAJ = 0;
    localdjz.EdW = this.zdr;
    if (this.zdo)
    {
      j = (int)i.aMN(m.bP(this.filename, false));
      if (((com.tencent.mm.modelvoice.g)localObject).hAL >= j)
      {
        localdkz.EAJ = 1;
        this.zdp = true;
        ad.i("MicroMsg.NetSceneVerifyVoicePrint", "the last one pack for uploading totallen %d", new Object[] { Integer.valueOf(i) });
      }
    }
    this.LZ = ((com.tencent.mm.modelvoice.g)localObject).hAL;
    localdjz.EzQ = localdkz;
    AppMethodBeat.o(29787);
    return 0;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(29786);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(29786);
    return i;
  }
  
  public final int getType()
  {
    return 613;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29788);
    ad.d("MicroMsg.NetSceneVerifyVoicePrint", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (dka)((b)paramq).gUT.gUX;
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29788);
      return;
    }
    this.zdr = paramq.EdW;
    this.KI = paramq.CWL;
    ad.i("MicroMsg.NetSceneVerifyVoicePrint", "voice VoiceTicket %d mResult %d", new Object[] { Integer.valueOf(paramq.EdW), Integer.valueOf(this.KI) });
    if (this.zdp)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29788);
      return;
    }
    ad.i("MicroMsg.NetSceneVerifyVoicePrint", "tryDoScene ret %d", new Object[] { Integer.valueOf(dRm()) });
    doScene(dispatcher(), this.callback);
    ad.i("MicroMsg.NetSceneVerifyVoicePrint", "loop doscene");
    AppMethodBeat.o(29788);
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
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.j
 * JD-Core Version:    0.7.0.1
 */