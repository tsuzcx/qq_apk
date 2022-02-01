package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cts;
import com.tencent.mm.protocal.protobuf.ctt;
import com.tencent.mm.protocal.protobuf.dyb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;

public final class f
  extends com.tencent.mm.ak.n
  implements k
{
  public boolean CmQ;
  private boolean CmR;
  private Handler CmS;
  int CmT;
  private int CmU;
  int CmV;
  int Nv;
  private com.tencent.mm.ak.f callback;
  private String filename;
  private int fq;
  private final b rr;
  
  public f(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(29767);
    this.fq = 0;
    this.CmQ = false;
    this.CmR = false;
    this.CmS = null;
    this.CmT = 0;
    this.CmU = 0;
    this.CmV = 0;
    this.Nv = 0;
    ae.d("MicroMsg.NetSceneRegisterVoicePrint", "step %d resid %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.CmV = paramInt1;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cts();
    ((b.a)localObject).hQG = new ctt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/registervoiceprint";
    ((b.a)localObject).funcId = 612;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cts)this.rr.hQD.hQJ;
    this.filename = paramString;
    this.fq = 0;
    ((cts)localObject).HEK = paramInt2;
    ((cts)localObject).nJz = paramInt1;
    this.CmT = paramInt3;
    ((cts)localObject).HEI = paramInt3;
    ae.i("MicroMsg.NetSceneRegisterVoicePrint", "voiceRegist %d %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.CmQ = true;
    exO();
    AppMethodBeat.o(29767);
  }
  
  private int exO()
  {
    AppMethodBeat.i(29769);
    cts localcts = (cts)this.rr.hQD.hQJ;
    dyb localdyb = new dyb();
    new g();
    localcts.HEJ = localdyb;
    Object localObject = new com.tencent.mm.modelvoice.n(m.ch(this.filename, false));
    int i = (int)o.aZR(m.ch(this.filename, false));
    if (i - this.fq >= 6000) {}
    int j;
    for (localObject = ((com.tencent.mm.modelvoice.n)localObject).dr(this.fq, 6000);; localObject = ((com.tencent.mm.modelvoice.n)localObject).dr(j, i - j))
    {
      ae.d("MicroMsg.NetSceneRegisterVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[] { Integer.valueOf(this.fq), Integer.valueOf(((g)localObject).ret), Integer.valueOf(((g)localObject).diR), Integer.valueOf(i), Boolean.valueOf(this.CmQ) });
      if (((g)localObject).diR != 0) {
        break;
      }
      AppMethodBeat.o(29769);
      return -2;
      j = this.fq;
    }
    if (((g)localObject).ret < 0)
    {
      ae.w("MicroMsg.NetSceneRegisterVoicePrint", "readerror %d", new Object[] { Integer.valueOf(((g)localObject).ret) });
      AppMethodBeat.o(29769);
      return -1;
    }
    if (this.fq >= 469000)
    {
      ae.i("MicroMsg.NetSceneRegisterVoicePrint", "moffset > maxfile %d", new Object[] { Integer.valueOf(this.fq) });
      AppMethodBeat.o(29769);
      return -1;
    }
    localdyb.Idb = new SKBuiltinBuffer_t().setBuffer(((g)localObject).buf);
    localdyb.xsC = this.fq;
    localdyb.IcZ = ((g)localObject).diR;
    localdyb.Ida = 0;
    localcts.HEI = this.CmT;
    if (this.CmQ)
    {
      j = (int)o.aZR(m.ch(this.filename, false));
      if (((g)localObject).ixC >= j)
      {
        localdyb.Ida = 1;
        this.CmR = true;
        ae.i("MicroMsg.NetSceneRegisterVoicePrint", "the last one pack for uploading totallen %d", new Object[] { Integer.valueOf(i) });
      }
    }
    this.fq = ((g)localObject).ixC;
    localcts.HEJ = localdyb;
    AppMethodBeat.o(29769);
    return 0;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
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
    ae.d("MicroMsg.NetSceneRegisterVoicePrint", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (ctt)((b)paramq).hQE.hQJ;
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29770);
      return;
    }
    ae.i("MicroMsg.NetSceneRegisterVoicePrint", "voice ticket %d ret %d nextstep %d %d ", new Object[] { Integer.valueOf(paramq.HEI), Integer.valueOf(paramq.HEL), Integer.valueOf(paramq.HEM), Integer.valueOf(paramq.HEL) });
    this.CmT = paramq.HEI;
    this.CmU = paramq.HEM;
    this.Nv = paramq.HEL;
    if (this.CmR)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29770);
      return;
    }
    ae.i("MicroMsg.NetSceneRegisterVoicePrint", "tryDoScene ret %d", new Object[] { Integer.valueOf(exO()) });
    doScene(dispatcher(), this.callback);
    ae.i("MicroMsg.NetSceneRegisterVoicePrint", "loop doscene");
    AppMethodBeat.o(29770);
  }
  
  public final int securityLimitCount()
  {
    return 240;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.f
 * JD-Core Version:    0.7.0.1
 */