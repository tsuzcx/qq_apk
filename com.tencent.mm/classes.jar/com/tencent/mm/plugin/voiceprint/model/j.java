package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.fas;
import com.tencent.mm.protocal.protobuf.fat;
import com.tencent.mm.protocal.protobuf.fct;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;

public final class j
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
  private String ndo;
  private final d rr;
  private int zP;
  
  public j(String paramString, int paramInt)
  {
    AppMethodBeat.i(29785);
    this.zP = 0;
    this.NHc = false;
    this.INk = false;
    this.NHd = null;
    this.NHe = 0;
    this.Lz = 0;
    this.ndo = "";
    Log.d("MicroMsg.NetSceneVerifyVoicePrint", "resid %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new fas();
    ((d.a)localObject).lBV = new fat();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyvoiceprint";
    ((d.a)localObject).funcId = 613;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (fas)d.b.b(this.rr.lBR);
    this.filename = paramString;
    this.zP = 0;
    ((fas)localObject).UbW = paramInt;
    this.NHe = 0;
    ((fas)localObject).UbU = 0;
    Log.i("MicroMsg.NetSceneVerifyVoicePrint", "voiceRegist %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0) });
    this.NHc = true;
    gwP();
    AppMethodBeat.o(29785);
  }
  
  private int gwP()
  {
    AppMethodBeat.i(29787);
    fas localfas = (fas)d.b.b(this.rr.lBR);
    fct localfct = new fct();
    new com.tencent.mm.modelvoice.g();
    localfas.UAK = localfct;
    Object localObject = new n(m.cN(this.filename, false));
    int i = (int)u.bBQ(m.cN(this.filename, false));
    if (i - this.zP >= 6000) {}
    int j;
    for (localObject = ((n)localObject).dY(this.zP, 6000);; localObject = ((n)localObject).dY(j, i - j))
    {
      Log.d("MicroMsg.NetSceneVerifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[] { Integer.valueOf(this.zP), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).fsR), Integer.valueOf(i), Boolean.valueOf(this.NHc) });
      if (((com.tencent.mm.modelvoice.g)localObject).fsR != 0) {
        break;
      }
      AppMethodBeat.o(29787);
      return -2;
      j = this.zP;
    }
    if (((com.tencent.mm.modelvoice.g)localObject).ret < 0)
    {
      Log.w("MicroMsg.NetSceneVerifyVoicePrint", "readerror %d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret) });
      AppMethodBeat.o(29787);
      return -1;
    }
    if (this.zP >= 469000)
    {
      Log.i("MicroMsg.NetSceneVerifyVoicePrint", "moffset > maxfile %d", new Object[] { Integer.valueOf(this.zP) });
      AppMethodBeat.o(29787);
      return -1;
    }
    localfct.UCv = new eae().dc(((com.tencent.mm.modelvoice.g)localObject).buf);
    localfct.Hna = this.zP;
    localfct.UCt = ((com.tencent.mm.modelvoice.g)localObject).fsR;
    localfct.UCu = 0;
    localfas.UbU = this.NHe;
    if (this.NHc)
    {
      j = (int)u.bBQ(m.cN(this.filename, false));
      if (((com.tencent.mm.modelvoice.g)localObject).miv >= j)
      {
        localfct.UCu = 1;
        this.INk = true;
        Log.i("MicroMsg.NetSceneVerifyVoicePrint", "the last one pack for uploading totallen %d", new Object[] { Integer.valueOf(i) });
      }
    }
    this.zP = ((com.tencent.mm.modelvoice.g)localObject).miv;
    localfas.UAK = localfct;
    AppMethodBeat.o(29787);
    return 0;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(29786);
    this.callback = parami;
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
    params = (fat)d.c.b(((d)params).lBS);
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29788);
      return;
    }
    this.NHe = params.UbU;
    this.Lz = params.Tsk;
    Log.i("MicroMsg.NetSceneVerifyVoicePrint", "voice VoiceTicket %d mResult %d", new Object[] { Integer.valueOf(params.UbU), Integer.valueOf(this.Lz) });
    if (this.INk)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29788);
      return;
    }
    Log.i("MicroMsg.NetSceneVerifyVoicePrint", "tryDoScene ret %d", new Object[] { Integer.valueOf(gwP()) });
    doScene(dispatcher(), this.callback);
    Log.i("MicroMsg.NetSceneVerifyVoicePrint", "loop doscene");
    AppMethodBeat.o(29788);
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
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.j
 * JD-Core Version:    0.7.0.1
 */