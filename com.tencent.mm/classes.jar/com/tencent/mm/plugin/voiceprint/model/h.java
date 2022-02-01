package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bm.a;
import com.tencent.mm.model.bm.b;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eqj;
import com.tencent.mm.protocal.protobuf.esi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public final class h
  extends q
  implements com.tencent.mm.network.m
{
  private boolean CIm;
  public boolean GQR;
  private Handler GQS;
  private int GQT;
  int NH;
  i callback;
  private String filename;
  private int fs;
  private final com.tencent.mm.network.s iMO;
  String kly;
  
  public h(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(29778);
    this.fs = 0;
    this.GQR = false;
    this.CIm = false;
    this.GQS = null;
    this.GQT = 0;
    this.NH = 0;
    this.kly = "";
    Log.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "resid %d vertifyTicket %s", new Object[] { Integer.valueOf(paramInt), Util.nullAs(paramString2, "") });
    this.iMO = new c();
    bm.a locala = (bm.a)this.iMO.getReqObj();
    this.filename = paramString1;
    this.fs = 0;
    locala.iDW.MPS = paramInt;
    locala.iDW.Mdm = paramString2;
    this.GQT = 0;
    locala.iDW.MPQ = 0;
    Log.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "voiceRegist %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0) });
    this.GQR = true;
    fEC();
    AppMethodBeat.o(29778);
  }
  
  private int fEC()
  {
    AppMethodBeat.i(29780);
    bm.a locala = (bm.a)this.iMO.getReqObj();
    esi localesi = new esi();
    new com.tencent.mm.modelvoice.g();
    locala.iDW.NnN = localesi;
    Object localObject = new n(m.cz(this.filename, false));
    int i = (int)com.tencent.mm.vfs.s.boW(m.cz(this.filename, false));
    if (i - this.fs >= 6000) {}
    int j;
    for (localObject = ((n)localObject).dB(this.fs, 6000);; localObject = ((n)localObject).dB(j, i - j))
    {
      Log.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[] { Integer.valueOf(this.fs), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).dAc), Integer.valueOf(i), Boolean.valueOf(this.GQR) });
      if (((com.tencent.mm.modelvoice.g)localObject).dAc != 0) {
        break;
      }
      AppMethodBeat.o(29780);
      return -2;
      j = this.fs;
    }
    if (((com.tencent.mm.modelvoice.g)localObject).ret < 0)
    {
      Log.w("MicroMsg.NetSceneRsaVertifyVoicePrint", "readerror %d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret) });
      AppMethodBeat.o(29780);
      return -1;
    }
    if (this.fs >= 469000)
    {
      Log.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "moffset > maxfile %d", new Object[] { Integer.valueOf(this.fs) });
      AppMethodBeat.o(29780);
      return -1;
    }
    localesi.Npz = new SKBuiltinBuffer_t().setBuffer(((com.tencent.mm.modelvoice.g)localObject).buf);
    localesi.BsG = this.fs;
    localesi.Npx = ((com.tencent.mm.modelvoice.g)localObject).dAc;
    localesi.Npy = 0;
    locala.iDW.MPQ = this.GQT;
    if (this.GQR)
    {
      j = (int)com.tencent.mm.vfs.s.boW(m.cz(this.filename, false));
      if (((com.tencent.mm.modelvoice.g)localObject).jsR >= j)
      {
        localesi.Npy = 1;
        this.CIm = true;
        Log.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "the last one pack for uploading totallen %d", new Object[] { Integer.valueOf(i) });
      }
    }
    this.fs = ((com.tencent.mm.modelvoice.g)localObject).jsR;
    locala.iDW.NnN = localesi;
    AppMethodBeat.o(29780);
    return 0;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(29779);
    this.callback = parami;
    int i = dispatch(paramg, this.iMO, this);
    AppMethodBeat.o(29779);
    return i;
  }
  
  public final int getType()
  {
    return 617;
  }
  
  public final void onGYNetEnd(final int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29781);
    Log.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (bm.b)params.getRespObj();
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = params.getReqObj().getRsaInfo().ver;
      Log.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      bg.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(29777);
          new com.tencent.mm.modelsimple.m().doScene(h.this.dispatcher(), new i()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
            {
              AppMethodBeat.i(29776);
              Log.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2q.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
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
    this.GQT = paramArrayOfByte.iDX.MPQ;
    this.NH = paramArrayOfByte.iDX.LjQ;
    this.kly = paramArrayOfByte.iDX.NnO;
    int i = paramArrayOfByte.iDX.MPQ;
    int j = this.NH;
    boolean bool = Util.isNullOrNil(this.kly);
    if (Util.isNullOrNil(this.kly)) {}
    for (paramInt1 = 0;; paramInt1 = this.kly.length())
    {
      Log.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "voice VoiceTicket %d mResult %d mAuthPwd is null: %b, mAuthPwd.len: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
      if (!this.CIm) {
        break;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29781);
      return;
    }
    Log.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "tryDoScene ret %d", new Object[] { Integer.valueOf(fEC()) });
    doScene(dispatcher(), this.callback);
    Log.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "loop doscene");
    AppMethodBeat.o(29781);
  }
  
  public final int securityLimitCount()
  {
    return 240;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return q.b.iMq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.h
 * JD-Core Version:    0.7.0.1
 */