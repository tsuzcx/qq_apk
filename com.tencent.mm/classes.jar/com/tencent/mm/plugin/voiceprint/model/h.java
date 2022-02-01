package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bf.a;
import com.tencent.mm.model.bf.b;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dkc;
import com.tencent.mm.protocal.protobuf.dkz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public final class h
  extends com.tencent.mm.al.n
  implements k
{
  int KI;
  private int LZ;
  com.tencent.mm.al.g callback;
  private String filename;
  private final q gVZ;
  String iri;
  public boolean zdo;
  private boolean zdp;
  private Handler zdq;
  private int zdr;
  
  public h(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(29778);
    this.LZ = 0;
    this.zdo = false;
    this.zdp = false;
    this.zdq = null;
    this.zdr = 0;
    this.KI = 0;
    this.iri = "";
    ad.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "resid %d vertifyTicket %s", new Object[] { Integer.valueOf(paramInt), bt.by(paramString2, "") });
    this.gVZ = new c();
    bf.a locala = (bf.a)this.gVZ.getReqObj();
    this.filename = paramString1;
    this.LZ = 0;
    locala.gNC.EdY = paramInt;
    locala.gNC.DAa = paramString2;
    this.zdr = 0;
    locala.gNC.EdW = 0;
    ad.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "voiceRegist %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0) });
    this.zdo = true;
    dRm();
    AppMethodBeat.o(29778);
  }
  
  private int dRm()
  {
    AppMethodBeat.i(29780);
    bf.a locala = (bf.a)this.gVZ.getReqObj();
    dkz localdkz = new dkz();
    new com.tencent.mm.modelvoice.g();
    locala.gNC.EzQ = localdkz;
    Object localObject = new com.tencent.mm.modelvoice.n(m.bP(this.filename, false));
    int i = (int)i.aMN(m.bP(this.filename, false));
    if (i - this.LZ >= 6000) {}
    int j;
    for (localObject = ((com.tencent.mm.modelvoice.n)localObject).dp(this.LZ, 6000);; localObject = ((com.tencent.mm.modelvoice.n)localObject).dp(j, i - j))
    {
      ad.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[] { Integer.valueOf(this.LZ), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).cZc), Integer.valueOf(i), Boolean.valueOf(this.zdo) });
      if (((com.tencent.mm.modelvoice.g)localObject).cZc != 0) {
        break;
      }
      AppMethodBeat.o(29780);
      return -2;
      j = this.LZ;
    }
    if (((com.tencent.mm.modelvoice.g)localObject).ret < 0)
    {
      ad.w("MicroMsg.NetSceneRsaVertifyVoicePrint", "readerror %d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret) });
      AppMethodBeat.o(29780);
      return -1;
    }
    if (this.LZ >= 469000)
    {
      ad.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "moffset > maxfile %d", new Object[] { Integer.valueOf(this.LZ) });
      AppMethodBeat.o(29780);
      return -1;
    }
    localdkz.EAK = new SKBuiltinBuffer_t().setBuffer(((com.tencent.mm.modelvoice.g)localObject).buf);
    localdkz.uKR = this.LZ;
    localdkz.EAI = ((com.tencent.mm.modelvoice.g)localObject).cZc;
    localdkz.EAJ = 0;
    locala.gNC.EdW = this.zdr;
    if (this.zdo)
    {
      j = (int)i.aMN(m.bP(this.filename, false));
      if (((com.tencent.mm.modelvoice.g)localObject).hAL >= j)
      {
        localdkz.EAJ = 1;
        this.zdp = true;
        ad.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "the last one pack for uploading totallen %d", new Object[] { Integer.valueOf(i) });
      }
    }
    this.LZ = ((com.tencent.mm.modelvoice.g)localObject).hAL;
    locala.gNC.EzQ = localdkz;
    AppMethodBeat.o(29780);
    return 0;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(29779);
    this.callback = paramg;
    int i = dispatch(parame, this.gVZ, this);
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
    paramArrayOfByte = (bf.b)paramq.getRespObj();
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = paramq.getReqObj().getRsaInfo().ver;
      ad.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      az.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(29777);
          new l().doScene(h.this.dispatcher(), new com.tencent.mm.al.g()
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
    this.zdr = paramArrayOfByte.gND.EdW;
    this.KI = paramArrayOfByte.gND.CWL;
    this.iri = paramArrayOfByte.gND.EzR;
    int i = paramArrayOfByte.gND.EdW;
    int j = this.KI;
    boolean bool = bt.isNullOrNil(this.iri);
    if (bt.isNullOrNil(this.iri)) {}
    for (paramInt1 = 0;; paramInt1 = this.iri.length())
    {
      ad.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "voice VoiceTicket %d mResult %d mAuthPwd is null: %b, mAuthPwd.len: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
      if (!this.zdp) {
        break;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29781);
      return;
    }
    ad.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "tryDoScene ret %d", new Object[] { Integer.valueOf(dRm()) });
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
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.h
 * JD-Core Version:    0.7.0.1
 */