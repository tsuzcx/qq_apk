package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eoz;
import com.tencent.mm.protocal.protobuf.epa;
import com.tencent.mm.protocal.protobuf.fzf;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;

public final class f
  extends p
  implements com.tencent.mm.network.m
{
  private boolean OUp;
  private int POh;
  private int Sc;
  public boolean Utc;
  private Handler Utd;
  int Ute;
  int Utf;
  int brM;
  private h callback;
  private String filename;
  private final c rr;
  
  public f(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(29767);
    this.Sc = 0;
    this.Utc = false;
    this.OUp = false;
    this.Utd = null;
    this.Ute = 0;
    this.POh = 0;
    this.Utf = 0;
    this.brM = 0;
    Log.d("MicroMsg.NetSceneRegisterVoicePrint", "step %d resid %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.Utf = paramInt1;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new eoz();
    ((c.a)localObject).otF = new epa();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/registervoiceprint";
    ((c.a)localObject).funcId = 612;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (eoz)c.b.b(this.rr.otB);
    this.filename = paramString;
    this.Sc = 0;
    ((eoz)localObject).abth = paramInt2;
    ((eoz)localObject).vhI = paramInt1;
    this.Ute = paramInt3;
    ((eoz)localObject).abtf = paramInt3;
    Log.i("MicroMsg.NetSceneRegisterVoicePrint", "voiceRegist %d %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.Utc = true;
    hUM();
    AppMethodBeat.o(29767);
  }
  
  private int hUM()
  {
    AppMethodBeat.i(29769);
    eoz localeoz = (eoz)c.b.b(this.rr.otB);
    fzf localfzf = new fzf();
    new com.tencent.mm.modelvoice.g();
    localeoz.abtg = localfzf;
    Object localObject = new n(m.dt(this.filename, false));
    int i = (int)y.bEl(m.dt(this.filename, false));
    if (i - this.Sc >= 6000) {}
    int j;
    for (localObject = ((n)localObject).eQ(this.Sc, 6000);; localObject = ((n)localObject).eQ(j, i - j))
    {
      Log.d("MicroMsg.NetSceneRegisterVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[] { Integer.valueOf(this.Sc), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).hxg), Integer.valueOf(i), Boolean.valueOf(this.Utc) });
      if (((com.tencent.mm.modelvoice.g)localObject).hxg != 0) {
        break;
      }
      AppMethodBeat.o(29769);
      return -2;
      j = this.Sc;
    }
    if (((com.tencent.mm.modelvoice.g)localObject).ret < 0)
    {
      Log.w("MicroMsg.NetSceneRegisterVoicePrint", "readerror %d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret) });
      AppMethodBeat.o(29769);
      return -1;
    }
    if (this.Sc >= 469000)
    {
      Log.i("MicroMsg.NetSceneRegisterVoicePrint", "moffset > maxfile %d", new Object[] { Integer.valueOf(this.Sc) });
      AppMethodBeat.o(29769);
      return -1;
    }
    localfzf.abWF = new gol().df(((com.tencent.mm.modelvoice.g)localObject).buf);
    localfzf.NkO = this.Sc;
    localfzf.abWD = ((com.tencent.mm.modelvoice.g)localObject).hxg;
    localfzf.abWE = 0;
    localeoz.abtf = this.Ute;
    if (this.Utc)
    {
      j = (int)y.bEl(m.dt(this.filename, false));
      if (((com.tencent.mm.modelvoice.g)localObject).pbK >= j)
      {
        localfzf.abWE = 1;
        this.OUp = true;
        Log.i("MicroMsg.NetSceneRegisterVoicePrint", "the last one pack for uploading totallen %d", new Object[] { Integer.valueOf(i) });
      }
    }
    this.Sc = ((com.tencent.mm.modelvoice.g)localObject).pbK;
    localeoz.abtg = localfzf;
    AppMethodBeat.o(29769);
    return 0;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(29768);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(29768);
    return i;
  }
  
  public final int getType()
  {
    return 612;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29770);
    Log.d("MicroMsg.NetSceneRegisterVoicePrint", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    params = (epa)c.c.b(((c)params).otC);
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29770);
      return;
    }
    Log.i("MicroMsg.NetSceneRegisterVoicePrint", "voice ticket %d ret %d nextstep %d %d ", new Object[] { Integer.valueOf(params.abtf), Integer.valueOf(params.abti), Integer.valueOf(params.abtj), Integer.valueOf(params.abti) });
    this.Ute = params.abtf;
    this.POh = params.abtj;
    this.brM = params.abti;
    if (this.OUp)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29770);
      return;
    }
    Log.i("MicroMsg.NetSceneRegisterVoicePrint", "tryDoScene ret %d", new Object[] { Integer.valueOf(hUM()) });
    doScene(dispatcher(), this.callback);
    Log.i("MicroMsg.NetSceneRegisterVoicePrint", "loop doscene");
    AppMethodBeat.o(29770);
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
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.f
 * JD-Core Version:    0.7.0.1
 */