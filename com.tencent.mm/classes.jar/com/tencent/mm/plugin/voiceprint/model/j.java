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
import com.tencent.mm.protocal.protobuf.fwy;
import com.tencent.mm.protocal.protobuf.fwz;
import com.tencent.mm.protocal.protobuf.fzf;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;

public final class j
  extends p
  implements com.tencent.mm.network.m
{
  private boolean OUp;
  private int Sc;
  public boolean Utc;
  private Handler Utd;
  private int Ute;
  int brM;
  private h callback;
  private String filename;
  private String pZt;
  private final c rr;
  
  public j(String paramString, int paramInt)
  {
    AppMethodBeat.i(29785);
    this.Sc = 0;
    this.Utc = false;
    this.OUp = false;
    this.Utd = null;
    this.Ute = 0;
    this.brM = 0;
    this.pZt = "";
    Log.d("MicroMsg.NetSceneVerifyVoicePrint", "resid %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fwy();
    ((c.a)localObject).otF = new fwz();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyvoiceprint";
    ((c.a)localObject).funcId = 613;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fwy)c.b.b(this.rr.otB);
    this.filename = paramString;
    this.Sc = 0;
    ((fwy)localObject).abth = paramInt;
    this.Ute = 0;
    ((fwy)localObject).abtf = 0;
    Log.i("MicroMsg.NetSceneVerifyVoicePrint", "voiceRegist %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0) });
    this.Utc = true;
    hUM();
    AppMethodBeat.o(29785);
  }
  
  private int hUM()
  {
    AppMethodBeat.i(29787);
    fwy localfwy = (fwy)c.b.b(this.rr.otB);
    fzf localfzf = new fzf();
    new com.tencent.mm.modelvoice.g();
    localfwy.abUN = localfzf;
    Object localObject = new n(m.dt(this.filename, false));
    int i = (int)y.bEl(m.dt(this.filename, false));
    if (i - this.Sc >= 6000) {}
    int j;
    for (localObject = ((n)localObject).eQ(this.Sc, 6000);; localObject = ((n)localObject).eQ(j, i - j))
    {
      Log.d("MicroMsg.NetSceneVerifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[] { Integer.valueOf(this.Sc), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).hxg), Integer.valueOf(i), Boolean.valueOf(this.Utc) });
      if (((com.tencent.mm.modelvoice.g)localObject).hxg != 0) {
        break;
      }
      AppMethodBeat.o(29787);
      return -2;
      j = this.Sc;
    }
    if (((com.tencent.mm.modelvoice.g)localObject).ret < 0)
    {
      Log.w("MicroMsg.NetSceneVerifyVoicePrint", "readerror %d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret) });
      AppMethodBeat.o(29787);
      return -1;
    }
    if (this.Sc >= 469000)
    {
      Log.i("MicroMsg.NetSceneVerifyVoicePrint", "moffset > maxfile %d", new Object[] { Integer.valueOf(this.Sc) });
      AppMethodBeat.o(29787);
      return -1;
    }
    localfzf.abWF = new gol().df(((com.tencent.mm.modelvoice.g)localObject).buf);
    localfzf.NkO = this.Sc;
    localfzf.abWD = ((com.tencent.mm.modelvoice.g)localObject).hxg;
    localfzf.abWE = 0;
    localfwy.abtf = this.Ute;
    if (this.Utc)
    {
      j = (int)y.bEl(m.dt(this.filename, false));
      if (((com.tencent.mm.modelvoice.g)localObject).pbK >= j)
      {
        localfzf.abWE = 1;
        this.OUp = true;
        Log.i("MicroMsg.NetSceneVerifyVoicePrint", "the last one pack for uploading totallen %d", new Object[] { Integer.valueOf(i) });
      }
    }
    this.Sc = ((com.tencent.mm.modelvoice.g)localObject).pbK;
    localfwy.abUN = localfzf;
    AppMethodBeat.o(29787);
    return 0;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(29786);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(29786);
    return i;
  }
  
  public final int getType()
  {
    return 613;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29788);
    Log.d("MicroMsg.NetSceneVerifyVoicePrint", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    params = (fwz)c.c.b(((c)params).otC);
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29788);
      return;
    }
    this.Ute = params.abtf;
    this.brM = params.aaGv;
    Log.i("MicroMsg.NetSceneVerifyVoicePrint", "voice VoiceTicket %d mResult %d", new Object[] { Integer.valueOf(params.abtf), Integer.valueOf(this.brM) });
    if (this.OUp)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29788);
      return;
    }
    Log.i("MicroMsg.NetSceneVerifyVoicePrint", "tryDoScene ret %d", new Object[] { Integer.valueOf(hUM()) });
    doScene(dispatcher(), this.callback);
    Log.i("MicroMsg.NetSceneVerifyVoicePrint", "loop doscene");
    AppMethodBeat.o(29788);
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
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.j
 * JD-Core Version:    0.7.0.1
 */