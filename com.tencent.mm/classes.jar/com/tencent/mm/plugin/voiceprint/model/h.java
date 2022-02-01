package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.model.bn.b;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.fav;
import com.tencent.mm.protocal.protobuf.fct;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public final class h
  extends q
  implements com.tencent.mm.network.m
{
  private boolean INk;
  int Lz;
  public boolean NHc;
  private Handler NHd;
  private int NHe;
  private i callback;
  private String filename;
  private final s lCW;
  String ndo;
  private int zP;
  
  public h(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(29778);
    this.zP = 0;
    this.NHc = false;
    this.INk = false;
    this.NHd = null;
    this.NHe = 0;
    this.Lz = 0;
    this.ndo = "";
    Log.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "resid %d vertifyTicket %s", new Object[] { Integer.valueOf(paramInt), Util.nullAs(paramString2, "") });
    this.lCW = new c();
    bn.a locala = (bn.a)this.lCW.getReqObj();
    this.filename = paramString1;
    this.zP = 0;
    locala.ltX.UbW = paramInt;
    locala.ltX.TmN = paramString2;
    this.NHe = 0;
    locala.ltX.UbU = 0;
    Log.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "voiceRegist %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0) });
    this.NHc = true;
    gwP();
    AppMethodBeat.o(29778);
  }
  
  private int gwP()
  {
    AppMethodBeat.i(29780);
    bn.a locala = (bn.a)this.lCW.getReqObj();
    fct localfct = new fct();
    new com.tencent.mm.modelvoice.g();
    locala.ltX.UAK = localfct;
    Object localObject = new n(m.cN(this.filename, false));
    int i = (int)u.bBQ(m.cN(this.filename, false));
    if (i - this.zP >= 6000) {}
    int j;
    for (localObject = ((n)localObject).dY(this.zP, 6000);; localObject = ((n)localObject).dY(j, i - j))
    {
      Log.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[] { Integer.valueOf(this.zP), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).fsR), Integer.valueOf(i), Boolean.valueOf(this.NHc) });
      if (((com.tencent.mm.modelvoice.g)localObject).fsR != 0) {
        break;
      }
      AppMethodBeat.o(29780);
      return -2;
      j = this.zP;
    }
    if (((com.tencent.mm.modelvoice.g)localObject).ret < 0)
    {
      Log.w("MicroMsg.NetSceneRsaVertifyVoicePrint", "readerror %d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret) });
      AppMethodBeat.o(29780);
      return -1;
    }
    if (this.zP >= 469000)
    {
      Log.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "moffset > maxfile %d", new Object[] { Integer.valueOf(this.zP) });
      AppMethodBeat.o(29780);
      return -1;
    }
    localfct.UCv = new eae().dc(((com.tencent.mm.modelvoice.g)localObject).buf);
    localfct.Hna = this.zP;
    localfct.UCt = ((com.tencent.mm.modelvoice.g)localObject).fsR;
    localfct.UCu = 0;
    locala.ltX.UbU = this.NHe;
    if (this.NHc)
    {
      j = (int)u.bBQ(m.cN(this.filename, false));
      if (((com.tencent.mm.modelvoice.g)localObject).miv >= j)
      {
        localfct.UCu = 1;
        this.INk = true;
        Log.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "the last one pack for uploading totallen %d", new Object[] { Integer.valueOf(i) });
      }
    }
    this.zP = ((com.tencent.mm.modelvoice.g)localObject).miv;
    locala.ltX.UAK = localfct;
    AppMethodBeat.o(29780);
    return 0;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(29779);
    this.callback = parami;
    int i = dispatch(paramg, this.lCW, this);
    AppMethodBeat.o(29779);
    return i;
  }
  
  public final int getType()
  {
    return 617;
  }
  
  public final void onGYNetEnd(final int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29781);
    Log.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (bn.b)params.getRespObj();
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = params.getReqObj().getRsaInfo().ver;
      Log.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      bh.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(29777);
          new com.tencent.mm.modelsimple.m().doScene(h.a(h.this), new i()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
            {
              AppMethodBeat.i(29776);
              Log.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2q.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                h.b(h.this).onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", h.this);
                AppMethodBeat.o(29776);
                return;
              }
              h.this.doScene(h.c(h.this), h.b(h.this));
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
    this.NHe = paramArrayOfByte.ltY.UbU;
    this.Lz = paramArrayOfByte.ltY.Tsk;
    this.ndo = paramArrayOfByte.ltY.UAL;
    int i = paramArrayOfByte.ltY.UbU;
    int j = this.Lz;
    boolean bool = Util.isNullOrNil(this.ndo);
    if (Util.isNullOrNil(this.ndo)) {}
    for (paramInt1 = 0;; paramInt1 = this.ndo.length())
    {
      Log.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "voice VoiceTicket %d mResult %d mAuthPwd is null: %b, mAuthPwd.len: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
      if (!this.INk) {
        break;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29781);
      return;
    }
    Log.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "tryDoScene ret %d", new Object[] { Integer.valueOf(gwP()) });
    doScene(dispatcher(), this.callback);
    Log.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "loop doscene");
    AppMethodBeat.o(29781);
  }
  
  public final int securityLimitCount()
  {
    return 240;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.h
 * JD-Core Version:    0.7.0.1
 */