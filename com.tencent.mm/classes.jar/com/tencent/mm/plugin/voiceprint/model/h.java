package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bg.a;
import com.tencent.mm.model.bg.b;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dvi;
import com.tencent.mm.protocal.protobuf.dwk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public final class h
  extends com.tencent.mm.al.n
  implements k
{
  public boolean BVp;
  private boolean BVq;
  private Handler BVr;
  private int BVs;
  int Nv;
  f callback;
  private String filename;
  private int fq;
  private final q hON;
  String jkw;
  
  public h(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(29778);
    this.fq = 0;
    this.BVp = false;
    this.BVq = false;
    this.BVr = null;
    this.BVs = 0;
    this.Nv = 0;
    this.jkw = "";
    ad.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "resid %d vertifyTicket %s", new Object[] { Integer.valueOf(paramInt), bt.bI(paramString2, "") });
    this.hON = new c();
    bg.a locala = (bg.a)this.hON.getReqObj();
    this.filename = paramString1;
    this.fq = 0;
    locala.hGu.Hlk = paramInt;
    locala.hGu.GEU = paramString2;
    this.BVs = 0;
    locala.hGu.Hli = 0;
    ad.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "voiceRegist %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0) });
    this.BVp = true;
    eui();
    AppMethodBeat.o(29778);
  }
  
  private int eui()
  {
    AppMethodBeat.i(29780);
    bg.a locala = (bg.a)this.hON.getReqObj();
    dwk localdwk = new dwk();
    new g();
    locala.hGu.HHK = localdwk;
    Object localObject = new com.tencent.mm.modelvoice.n(m.cd(this.filename, false));
    int i = (int)i.aYo(m.cd(this.filename, false));
    if (i - this.fq >= 6000) {}
    int j;
    for (localObject = ((com.tencent.mm.modelvoice.n)localObject).dr(this.fq, 6000);; localObject = ((com.tencent.mm.modelvoice.n)localObject).dr(j, i - j))
    {
      ad.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[] { Integer.valueOf(this.fq), Integer.valueOf(((g)localObject).ret), Integer.valueOf(((g)localObject).dhO), Integer.valueOf(i), Boolean.valueOf(this.BVp) });
      if (((g)localObject).dhO != 0) {
        break;
      }
      AppMethodBeat.o(29780);
      return -2;
      j = this.fq;
    }
    if (((g)localObject).ret < 0)
    {
      ad.w("MicroMsg.NetSceneRsaVertifyVoicePrint", "readerror %d", new Object[] { Integer.valueOf(((g)localObject).ret) });
      AppMethodBeat.o(29780);
      return -1;
    }
    if (this.fq >= 469000)
    {
      ad.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "moffset > maxfile %d", new Object[] { Integer.valueOf(this.fq) });
      AppMethodBeat.o(29780);
      return -1;
    }
    localdwk.HIT = new SKBuiltinBuffer_t().setBuffer(((g)localObject).buf);
    localdwk.xcL = this.fq;
    localdwk.HIR = ((g)localObject).dhO;
    localdwk.HIS = 0;
    locala.hGu.Hli = this.BVs;
    if (this.BVp)
    {
      j = (int)i.aYo(m.cd(this.filename, false));
      if (((g)localObject).iuI >= j)
      {
        localdwk.HIS = 1;
        this.BVq = true;
        ad.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "the last one pack for uploading totallen %d", new Object[] { Integer.valueOf(i) });
      }
    }
    this.fq = ((g)localObject).iuI;
    locala.hGu.HHK = localdwk;
    AppMethodBeat.o(29780);
    return 0;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(29779);
    this.callback = paramf;
    int i = dispatch(parame, this.hON, this);
    AppMethodBeat.o(29779);
    return i;
  }
  
  public final int getType()
  {
    return 617;
  }
  
  public final void onGYNetEnd(final int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29781);
    ad.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (bg.b)paramq.getRespObj();
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = paramq.getReqObj().getRsaInfo().ver;
      ad.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      ba.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(29777);
          new l().doScene(h.this.dispatcher(), new f()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.al.n paramAnonymous2n)
            {
              AppMethodBeat.i(29776);
              ad.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2n.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                h.this.callback.onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", h.this);
                AppMethodBeat.o(29776);
                return;
              }
              h.this.doScene(h.this.dispatcher(), h.this.callback);
              AppMethodBeat.o(29776);
            }
          });
          AppMethodBeat.o(29777);
        }
      });
      AppMethodBeat.o(29781);
      return;
    }
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29781);
      return;
    }
    this.BVs = paramArrayOfByte.hGv.Hli;
    this.Nv = paramArrayOfByte.hGv.FWG;
    this.jkw = paramArrayOfByte.hGv.HHL;
    int i = paramArrayOfByte.hGv.Hli;
    int j = this.Nv;
    boolean bool = bt.isNullOrNil(this.jkw);
    if (bt.isNullOrNil(this.jkw)) {}
    for (paramInt1 = 0;; paramInt1 = this.jkw.length())
    {
      ad.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "voice VoiceTicket %d mResult %d mAuthPwd is null: %b, mAuthPwd.len: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
      if (!this.BVq) {
        break;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29781);
      return;
    }
    ad.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "tryDoScene ret %d", new Object[] { Integer.valueOf(eui()) });
    doScene(dispatcher(), this.callback);
    ad.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "loop doscene");
    AppMethodBeat.o(29781);
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
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.h
 * JD-Core Version:    0.7.0.1
 */