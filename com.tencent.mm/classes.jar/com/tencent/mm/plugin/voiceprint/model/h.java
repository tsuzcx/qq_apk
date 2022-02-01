package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bo.a;
import com.tencent.mm.model.bo.b;
import com.tencent.mm.modelsimple.o;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.fxb;
import com.tencent.mm.protocal.protobuf.fzf;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public final class h
  extends p
  implements com.tencent.mm.network.m
{
  private boolean OUp;
  private int Sc;
  public boolean Utc;
  private Handler Utd;
  private int Ute;
  int brM;
  private com.tencent.mm.am.h callback;
  private String filename;
  private final s ouH;
  String pZt;
  
  public h(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(29778);
    this.Sc = 0;
    this.Utc = false;
    this.OUp = false;
    this.Utd = null;
    this.Ute = 0;
    this.brM = 0;
    this.pZt = "";
    Log.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "resid %d vertifyTicket %s", new Object[] { Integer.valueOf(paramInt), Util.nullAs(paramString2, "") });
    this.ouH = new c();
    bo.a locala = (bo.a)this.ouH.getReqObj();
    this.filename = paramString1;
    this.Sc = 0;
    locala.olw.abth = paramInt;
    locala.olw.YOu = paramString2;
    this.Ute = 0;
    locala.olw.abtf = 0;
    Log.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "voiceRegist %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0) });
    this.Utc = true;
    hUM();
    AppMethodBeat.o(29778);
  }
  
  private int hUM()
  {
    AppMethodBeat.i(29780);
    bo.a locala = (bo.a)this.ouH.getReqObj();
    fzf localfzf = new fzf();
    new com.tencent.mm.modelvoice.g();
    locala.olw.abUN = localfzf;
    Object localObject = new n(m.dt(this.filename, false));
    int i = (int)y.bEl(m.dt(this.filename, false));
    if (i - this.Sc >= 6000) {}
    int j;
    for (localObject = ((n)localObject).eQ(this.Sc, 6000);; localObject = ((n)localObject).eQ(j, i - j))
    {
      Log.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[] { Integer.valueOf(this.Sc), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).hxg), Integer.valueOf(i), Boolean.valueOf(this.Utc) });
      if (((com.tencent.mm.modelvoice.g)localObject).hxg != 0) {
        break;
      }
      AppMethodBeat.o(29780);
      return -2;
      j = this.Sc;
    }
    if (((com.tencent.mm.modelvoice.g)localObject).ret < 0)
    {
      Log.w("MicroMsg.NetSceneRsaVertifyVoicePrint", "readerror %d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret) });
      AppMethodBeat.o(29780);
      return -1;
    }
    if (this.Sc >= 469000)
    {
      Log.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "moffset > maxfile %d", new Object[] { Integer.valueOf(this.Sc) });
      AppMethodBeat.o(29780);
      return -1;
    }
    localfzf.abWF = new gol().df(((com.tencent.mm.modelvoice.g)localObject).buf);
    localfzf.NkO = this.Sc;
    localfzf.abWD = ((com.tencent.mm.modelvoice.g)localObject).hxg;
    localfzf.abWE = 0;
    locala.olw.abtf = this.Ute;
    if (this.Utc)
    {
      j = (int)y.bEl(m.dt(this.filename, false));
      if (((com.tencent.mm.modelvoice.g)localObject).pbK >= j)
      {
        localfzf.abWE = 1;
        this.OUp = true;
        Log.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "the last one pack for uploading totallen %d", new Object[] { Integer.valueOf(i) });
      }
    }
    this.Sc = ((com.tencent.mm.modelvoice.g)localObject).pbK;
    locala.olw.abUN = localfzf;
    AppMethodBeat.o(29780);
    return 0;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(29779);
    this.callback = paramh;
    int i = dispatch(paramg, this.ouH, this);
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
    paramArrayOfByte = (bo.b)params.getRespObj();
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = params.getReqObj().getRsaInfo().ver;
      Log.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      bh.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(29777);
          new o().doScene(h.a(h.this), new com.tencent.mm.am.h()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, p paramAnonymous2p)
            {
              AppMethodBeat.i(29776);
              Log.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2p.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
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
    this.Ute = paramArrayOfByte.olx.abtf;
    this.brM = paramArrayOfByte.olx.aaGv;
    this.pZt = paramArrayOfByte.olx.abUO;
    int i = paramArrayOfByte.olx.abtf;
    int j = this.brM;
    boolean bool = Util.isNullOrNil(this.pZt);
    if (Util.isNullOrNil(this.pZt)) {}
    for (paramInt1 = 0;; paramInt1 = this.pZt.length())
    {
      Log.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "voice VoiceTicket %d mResult %d mAuthPwd is null: %b, mAuthPwd.len: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
      if (!this.OUp) {
        break;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29781);
      return;
    }
    Log.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "tryDoScene ret %d", new Object[] { Integer.valueOf(hUM()) });
    doScene(dispatcher(), this.callback);
    Log.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "loop doscene");
    AppMethodBeat.o(29781);
  }
  
  public final int securityLimitCount()
  {
    return 240;
  }
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.h
 * JD-Core Version:    0.7.0.1
 */