package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dwc;
import com.tencent.mm.protocal.protobuf.dwd;
import com.tencent.mm.protocal.protobuf.dyb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;

public final class j
  extends com.tencent.mm.ak.n
  implements k
{
  public boolean CmQ;
  private boolean CmR;
  private Handler CmS;
  private int CmT;
  int Nv;
  private f callback;
  private String filename;
  private int fq;
  private String jnq;
  private final b rr;
  
  public j(String paramString, int paramInt)
  {
    AppMethodBeat.i(29785);
    this.fq = 0;
    this.CmQ = false;
    this.CmR = false;
    this.CmS = null;
    this.CmT = 0;
    this.Nv = 0;
    this.jnq = "";
    ae.d("MicroMsg.NetSceneVerifyVoicePrint", "resid %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dwc();
    ((b.a)localObject).hQG = new dwd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyvoiceprint";
    ((b.a)localObject).funcId = 613;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dwc)this.rr.hQD.hQJ;
    this.filename = paramString;
    this.fq = 0;
    ((dwc)localObject).HEK = paramInt;
    this.CmT = 0;
    ((dwc)localObject).HEI = 0;
    ae.i("MicroMsg.NetSceneVerifyVoicePrint", "voiceRegist %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0) });
    this.CmQ = true;
    exO();
    AppMethodBeat.o(29785);
  }
  
  private int exO()
  {
    AppMethodBeat.i(29787);
    dwc localdwc = (dwc)this.rr.hQD.hQJ;
    dyb localdyb = new dyb();
    new g();
    localdwc.Ibx = localdyb;
    Object localObject = new com.tencent.mm.modelvoice.n(m.ch(this.filename, false));
    int i = (int)o.aZR(m.ch(this.filename, false));
    if (i - this.fq >= 6000) {}
    int j;
    for (localObject = ((com.tencent.mm.modelvoice.n)localObject).dr(this.fq, 6000);; localObject = ((com.tencent.mm.modelvoice.n)localObject).dr(j, i - j))
    {
      ae.d("MicroMsg.NetSceneVerifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[] { Integer.valueOf(this.fq), Integer.valueOf(((g)localObject).ret), Integer.valueOf(((g)localObject).diR), Integer.valueOf(i), Boolean.valueOf(this.CmQ) });
      if (((g)localObject).diR != 0) {
        break;
      }
      AppMethodBeat.o(29787);
      return -2;
      j = this.fq;
    }
    if (((g)localObject).ret < 0)
    {
      ae.w("MicroMsg.NetSceneVerifyVoicePrint", "readerror %d", new Object[] { Integer.valueOf(((g)localObject).ret) });
      AppMethodBeat.o(29787);
      return -1;
    }
    if (this.fq >= 469000)
    {
      ae.i("MicroMsg.NetSceneVerifyVoicePrint", "moffset > maxfile %d", new Object[] { Integer.valueOf(this.fq) });
      AppMethodBeat.o(29787);
      return -1;
    }
    localdyb.Idb = new SKBuiltinBuffer_t().setBuffer(((g)localObject).buf);
    localdyb.xsC = this.fq;
    localdyb.IcZ = ((g)localObject).diR;
    localdyb.Ida = 0;
    localdwc.HEI = this.CmT;
    if (this.CmQ)
    {
      j = (int)o.aZR(m.ch(this.filename, false));
      if (((g)localObject).ixC >= j)
      {
        localdyb.Ida = 1;
        this.CmR = true;
        ae.i("MicroMsg.NetSceneVerifyVoicePrint", "the last one pack for uploading totallen %d", new Object[] { Integer.valueOf(i) });
      }
    }
    this.fq = ((g)localObject).ixC;
    localdwc.Ibx = localdyb;
    AppMethodBeat.o(29787);
    return 0;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(29786);
    this.callback = paramf;
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
    ae.d("MicroMsg.NetSceneVerifyVoicePrint", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (dwd)((b)paramq).hQE.hQJ;
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29788);
      return;
    }
    this.CmT = paramq.HEI;
    this.Nv = paramq.Gpf;
    ae.i("MicroMsg.NetSceneVerifyVoicePrint", "voice VoiceTicket %d mResult %d", new Object[] { Integer.valueOf(paramq.HEI), Integer.valueOf(this.Nv) });
    if (this.CmR)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29788);
      return;
    }
    ae.i("MicroMsg.NetSceneVerifyVoicePrint", "tryDoScene ret %d", new Object[] { Integer.valueOf(exO()) });
    doScene(dispatcher(), this.callback);
    ae.i("MicroMsg.NetSceneVerifyVoicePrint", "loop doscene");
    AppMethodBeat.o(29788);
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
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.j
 * JD-Core Version:    0.7.0.1
 */