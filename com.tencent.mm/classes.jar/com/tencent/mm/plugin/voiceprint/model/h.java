package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dwf;
import com.tencent.mm.protocal.protobuf.dyb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

public final class h
  extends com.tencent.mm.ak.n
  implements k
{
  public boolean CmQ;
  private boolean CmR;
  private Handler CmS;
  private int CmT;
  int Nv;
  f callback;
  private String filename;
  private int fq;
  private final q hRG;
  String jnq;
  
  public h(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(29778);
    this.fq = 0;
    this.CmQ = false;
    this.CmR = false;
    this.CmS = null;
    this.CmT = 0;
    this.Nv = 0;
    this.jnq = "";
    ae.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "resid %d vertifyTicket %s", new Object[] { Integer.valueOf(paramInt), bu.bI(paramString2, "") });
    this.hRG = new c();
    bi.a locala = (bi.a)this.hRG.getReqObj();
    this.filename = paramString1;
    this.fq = 0;
    locala.hJm.HEK = paramInt;
    locala.hJm.GYw = paramString2;
    this.CmT = 0;
    locala.hJm.HEI = 0;
    ae.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "voiceRegist %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0) });
    this.CmQ = true;
    exO();
    AppMethodBeat.o(29778);
  }
  
  private int exO()
  {
    AppMethodBeat.i(29780);
    bi.a locala = (bi.a)this.hRG.getReqObj();
    dyb localdyb = new dyb();
    new g();
    locala.hJm.Ibx = localdyb;
    Object localObject = new com.tencent.mm.modelvoice.n(m.ch(this.filename, false));
    int i = (int)o.aZR(m.ch(this.filename, false));
    if (i - this.fq >= 6000) {}
    int j;
    for (localObject = ((com.tencent.mm.modelvoice.n)localObject).dr(this.fq, 6000);; localObject = ((com.tencent.mm.modelvoice.n)localObject).dr(j, i - j))
    {
      ae.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[] { Integer.valueOf(this.fq), Integer.valueOf(((g)localObject).ret), Integer.valueOf(((g)localObject).diR), Integer.valueOf(i), Boolean.valueOf(this.CmQ) });
      if (((g)localObject).diR != 0) {
        break;
      }
      AppMethodBeat.o(29780);
      return -2;
      j = this.fq;
    }
    if (((g)localObject).ret < 0)
    {
      ae.w("MicroMsg.NetSceneRsaVertifyVoicePrint", "readerror %d", new Object[] { Integer.valueOf(((g)localObject).ret) });
      AppMethodBeat.o(29780);
      return -1;
    }
    if (this.fq >= 469000)
    {
      ae.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "moffset > maxfile %d", new Object[] { Integer.valueOf(this.fq) });
      AppMethodBeat.o(29780);
      return -1;
    }
    localdyb.Idb = new SKBuiltinBuffer_t().setBuffer(((g)localObject).buf);
    localdyb.xsC = this.fq;
    localdyb.IcZ = ((g)localObject).diR;
    localdyb.Ida = 0;
    locala.hJm.HEI = this.CmT;
    if (this.CmQ)
    {
      j = (int)o.aZR(m.ch(this.filename, false));
      if (((g)localObject).ixC >= j)
      {
        localdyb.Ida = 1;
        this.CmR = true;
        ae.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "the last one pack for uploading totallen %d", new Object[] { Integer.valueOf(i) });
      }
    }
    this.fq = ((g)localObject).ixC;
    locala.hJm.Ibx = localdyb;
    AppMethodBeat.o(29780);
    return 0;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(29779);
    this.callback = paramf;
    int i = dispatch(parame, this.hRG, this);
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
    ae.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (bi.b)paramq.getRespObj();
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = paramq.getReqObj().getRsaInfo().ver;
      ae.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      bc.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(29777);
          new com.tencent.mm.modelsimple.m().doScene(h.this.dispatcher(), new f()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.ak.n paramAnonymous2n)
            {
              AppMethodBeat.i(29776);
              ae.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2n.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
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
    this.CmT = paramArrayOfByte.hJn.HEI;
    this.Nv = paramArrayOfByte.hJn.Gpf;
    this.jnq = paramArrayOfByte.hJn.Iby;
    int i = paramArrayOfByte.hJn.HEI;
    int j = this.Nv;
    boolean bool = bu.isNullOrNil(this.jnq);
    if (bu.isNullOrNil(this.jnq)) {}
    for (paramInt1 = 0;; paramInt1 = this.jnq.length())
    {
      ae.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "voice VoiceTicket %d mResult %d mAuthPwd is null: %b, mAuthPwd.len: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
      if (!this.CmR) {
        break;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29781);
      return;
    }
    ae.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "tryDoScene ret %d", new Object[] { Integer.valueOf(exO()) });
    doScene(dispatcher(), this.callback);
    ae.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "loop doscene");
    AppMethodBeat.o(29781);
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
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.h
 * JD-Core Version:    0.7.0.1
 */