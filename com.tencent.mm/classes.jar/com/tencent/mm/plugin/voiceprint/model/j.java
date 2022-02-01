package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n.b;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dvf;
import com.tencent.mm.protocal.protobuf.dvg;
import com.tencent.mm.protocal.protobuf.dwk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;

public final class j
  extends com.tencent.mm.al.n
  implements k
{
  public boolean BVp;
  private boolean BVq;
  private Handler BVr;
  private int BVs;
  int Nv;
  private f callback;
  private String filename;
  private int fq;
  private String jkw;
  private final b rr;
  
  public j(String paramString, int paramInt)
  {
    AppMethodBeat.i(29785);
    this.fq = 0;
    this.BVp = false;
    this.BVq = false;
    this.BVr = null;
    this.BVs = 0;
    this.Nv = 0;
    this.jkw = "";
    ad.d("MicroMsg.NetSceneVerifyVoicePrint", "resid %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dvf();
    ((b.a)localObject).hNN = new dvg();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyvoiceprint";
    ((b.a)localObject).funcId = 613;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dvf)this.rr.hNK.hNQ;
    this.filename = paramString;
    this.fq = 0;
    ((dvf)localObject).Hlk = paramInt;
    this.BVs = 0;
    ((dvf)localObject).Hli = 0;
    ad.i("MicroMsg.NetSceneVerifyVoicePrint", "voiceRegist %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0) });
    this.BVp = true;
    eui();
    AppMethodBeat.o(29785);
  }
  
  private int eui()
  {
    AppMethodBeat.i(29787);
    dvf localdvf = (dvf)this.rr.hNK.hNQ;
    dwk localdwk = new dwk();
    new g();
    localdvf.HHK = localdwk;
    Object localObject = new com.tencent.mm.modelvoice.n(m.cd(this.filename, false));
    int i = (int)i.aYo(m.cd(this.filename, false));
    if (i - this.fq >= 6000) {}
    int j;
    for (localObject = ((com.tencent.mm.modelvoice.n)localObject).dr(this.fq, 6000);; localObject = ((com.tencent.mm.modelvoice.n)localObject).dr(j, i - j))
    {
      ad.d("MicroMsg.NetSceneVerifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[] { Integer.valueOf(this.fq), Integer.valueOf(((g)localObject).ret), Integer.valueOf(((g)localObject).dhO), Integer.valueOf(i), Boolean.valueOf(this.BVp) });
      if (((g)localObject).dhO != 0) {
        break;
      }
      AppMethodBeat.o(29787);
      return -2;
      j = this.fq;
    }
    if (((g)localObject).ret < 0)
    {
      ad.w("MicroMsg.NetSceneVerifyVoicePrint", "readerror %d", new Object[] { Integer.valueOf(((g)localObject).ret) });
      AppMethodBeat.o(29787);
      return -1;
    }
    if (this.fq >= 469000)
    {
      ad.i("MicroMsg.NetSceneVerifyVoicePrint", "moffset > maxfile %d", new Object[] { Integer.valueOf(this.fq) });
      AppMethodBeat.o(29787);
      return -1;
    }
    localdwk.HIT = new SKBuiltinBuffer_t().setBuffer(((g)localObject).buf);
    localdwk.xcL = this.fq;
    localdwk.HIR = ((g)localObject).dhO;
    localdwk.HIS = 0;
    localdvf.Hli = this.BVs;
    if (this.BVp)
    {
      j = (int)i.aYo(m.cd(this.filename, false));
      if (((g)localObject).iuI >= j)
      {
        localdwk.HIS = 1;
        this.BVq = true;
        ad.i("MicroMsg.NetSceneVerifyVoicePrint", "the last one pack for uploading totallen %d", new Object[] { Integer.valueOf(i) });
      }
    }
    this.fq = ((g)localObject).iuI;
    localdvf.HHK = localdwk;
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
    ad.d("MicroMsg.NetSceneVerifyVoicePrint", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (dvg)((b)paramq).hNL.hNQ;
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29788);
      return;
    }
    this.BVs = paramq.Hli;
    this.Nv = paramq.FWG;
    ad.i("MicroMsg.NetSceneVerifyVoicePrint", "voice VoiceTicket %d mResult %d", new Object[] { Integer.valueOf(paramq.Hli), Integer.valueOf(this.Nv) });
    if (this.BVq)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29788);
      return;
    }
    ad.i("MicroMsg.NetSceneVerifyVoicePrint", "tryDoScene ret %d", new Object[] { Integer.valueOf(eui()) });
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
    return n.b.hOp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.j
 * JD-Core Version:    0.7.0.1
 */