package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bf.a;
import com.tencent.mm.model.bf.b;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dpr;
import com.tencent.mm.protocal.protobuf.dqq;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

public final class h
  extends com.tencent.mm.ak.n
  implements k
{
  public boolean AvU;
  private boolean AvV;
  private Handler AvW;
  private int AvX;
  int LD;
  private int MW;
  com.tencent.mm.ak.g callback;
  private String filename;
  private final q hwy;
  String iRo;
  
  public h(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(29778);
    this.MW = 0;
    this.AvU = false;
    this.AvV = false;
    this.AvW = null;
    this.AvX = 0;
    this.LD = 0;
    this.iRo = "";
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "resid %d vertifyTicket %s", new Object[] { Integer.valueOf(paramInt), bs.bG(paramString2, "") });
    this.hwy = new c();
    bf.a locala = (bf.a)this.hwy.getReqObj();
    this.filename = paramString1;
    this.MW = 0;
    locala.hoc.FAX = paramInt;
    locala.hoc.EVw = paramString2;
    this.AvX = 0;
    locala.hoc.FAV = 0;
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "voiceRegist %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0) });
    this.AvU = true;
    egw();
    AppMethodBeat.o(29778);
  }
  
  private int egw()
  {
    AppMethodBeat.i(29780);
    bf.a locala = (bf.a)this.hwy.getReqObj();
    dqq localdqq = new dqq();
    new com.tencent.mm.modelvoice.g();
    locala.hoc.FWU = localdqq;
    Object localObject = new com.tencent.mm.modelvoice.n(m.bW(this.filename, false));
    int i = (int)i.aSp(m.bW(this.filename, false));
    if (i - this.MW >= 6000) {}
    int j;
    for (localObject = ((com.tencent.mm.modelvoice.n)localObject).dp(this.MW, 6000);; localObject = ((com.tencent.mm.modelvoice.n)localObject).dp(j, i - j))
    {
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[] { Integer.valueOf(this.MW), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).cWy), Integer.valueOf(i), Boolean.valueOf(this.AvU) });
      if (((com.tencent.mm.modelvoice.g)localObject).cWy != 0) {
        break;
      }
      AppMethodBeat.o(29780);
      return -2;
      j = this.MW;
    }
    if (((com.tencent.mm.modelvoice.g)localObject).ret < 0)
    {
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneRsaVertifyVoicePrint", "readerror %d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret) });
      AppMethodBeat.o(29780);
      return -1;
    }
    if (this.MW >= 469000)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "moffset > maxfile %d", new Object[] { Integer.valueOf(this.MW) });
      AppMethodBeat.o(29780);
      return -1;
    }
    localdqq.FXX = new SKBuiltinBuffer_t().setBuffer(((com.tencent.mm.modelvoice.g)localObject).buf);
    localdqq.vTI = this.MW;
    localdqq.FXV = ((com.tencent.mm.modelvoice.g)localObject).cWy;
    localdqq.FXW = 0;
    locala.hoc.FAV = this.AvX;
    if (this.AvU)
    {
      j = (int)i.aSp(m.bW(this.filename, false));
      if (((com.tencent.mm.modelvoice.g)localObject).ibm >= j)
      {
        localdqq.FXW = 1;
        this.AvV = true;
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "the last one pack for uploading totallen %d", new Object[] { Integer.valueOf(i) });
      }
    }
    this.MW = ((com.tencent.mm.modelvoice.g)localObject).ibm;
    locala.hoc.FWU = localdqq;
    AppMethodBeat.o(29780);
    return 0;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(29779);
    this.callback = paramg;
    int i = dispatch(parame, this.hwy, this);
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
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (bf.b)paramq.getRespObj();
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = paramq.getReqObj().getRsaInfo().ver;
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      az.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(29777);
          new l().doScene(h.this.dispatcher(), new com.tencent.mm.ak.g()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.ak.n paramAnonymous2n)
            {
              AppMethodBeat.i(29776);
              com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2n.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
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
    this.AvX = paramArrayOfByte.hod.FAV;
    this.LD = paramArrayOfByte.hod.Epu;
    this.iRo = paramArrayOfByte.hod.FWV;
    int i = paramArrayOfByte.hod.FAV;
    int j = this.LD;
    boolean bool = bs.isNullOrNil(this.iRo);
    if (bs.isNullOrNil(this.iRo)) {}
    for (paramInt1 = 0;; paramInt1 = this.iRo.length())
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "voice VoiceTicket %d mResult %d mAuthPwd is null: %b, mAuthPwd.len: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
      if (!this.AvV) {
        break;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29781);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "tryDoScene ret %d", new Object[] { Integer.valueOf(egw()) });
    doScene(dispatcher(), this.callback);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "loop doscene");
    AppMethodBeat.o(29781);
  }
  
  public final int securityLimitCount()
  {
    return 240;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.h
 * JD-Core Version:    0.7.0.1
 */