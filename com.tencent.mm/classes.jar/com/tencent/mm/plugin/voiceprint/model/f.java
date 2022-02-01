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
import com.tencent.mm.protocal.protobuf.dvz;
import com.tencent.mm.protocal.protobuf.dwa;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.fct;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;

public final class f
  extends q
  implements com.tencent.mm.network.m
{
  private boolean INk;
  private int JzA;
  int Lz;
  public boolean NHc;
  private Handler NHd;
  int NHe;
  int NHf;
  private i callback;
  private String filename;
  private final d rr;
  private int zP;
  
  public f(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(29767);
    this.zP = 0;
    this.NHc = false;
    this.INk = false;
    this.NHd = null;
    this.NHe = 0;
    this.JzA = 0;
    this.NHf = 0;
    this.Lz = 0;
    Log.d("MicroMsg.NetSceneRegisterVoicePrint", "step %d resid %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.NHf = paramInt1;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dvz();
    ((d.a)localObject).lBV = new dwa();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/registervoiceprint";
    ((d.a)localObject).funcId = 612;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (dvz)d.b.b(this.rr.lBR);
    this.filename = paramString;
    this.zP = 0;
    ((dvz)localObject).UbW = paramInt2;
    ((dvz)localObject).rWs = paramInt1;
    this.NHe = paramInt3;
    ((dvz)localObject).UbU = paramInt3;
    Log.i("MicroMsg.NetSceneRegisterVoicePrint", "voiceRegist %d %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.NHc = true;
    gwP();
    AppMethodBeat.o(29767);
  }
  
  private int gwP()
  {
    AppMethodBeat.i(29769);
    dvz localdvz = (dvz)d.b.b(this.rr.lBR);
    fct localfct = new fct();
    new com.tencent.mm.modelvoice.g();
    localdvz.UbV = localfct;
    Object localObject = new n(m.cN(this.filename, false));
    int i = (int)u.bBQ(m.cN(this.filename, false));
    if (i - this.zP >= 6000) {}
    int j;
    for (localObject = ((n)localObject).dY(this.zP, 6000);; localObject = ((n)localObject).dY(j, i - j))
    {
      Log.d("MicroMsg.NetSceneRegisterVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[] { Integer.valueOf(this.zP), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).fsR), Integer.valueOf(i), Boolean.valueOf(this.NHc) });
      if (((com.tencent.mm.modelvoice.g)localObject).fsR != 0) {
        break;
      }
      AppMethodBeat.o(29769);
      return -2;
      j = this.zP;
    }
    if (((com.tencent.mm.modelvoice.g)localObject).ret < 0)
    {
      Log.w("MicroMsg.NetSceneRegisterVoicePrint", "readerror %d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret) });
      AppMethodBeat.o(29769);
      return -1;
    }
    if (this.zP >= 469000)
    {
      Log.i("MicroMsg.NetSceneRegisterVoicePrint", "moffset > maxfile %d", new Object[] { Integer.valueOf(this.zP) });
      AppMethodBeat.o(29769);
      return -1;
    }
    localfct.UCv = new eae().dc(((com.tencent.mm.modelvoice.g)localObject).buf);
    localfct.Hna = this.zP;
    localfct.UCt = ((com.tencent.mm.modelvoice.g)localObject).fsR;
    localfct.UCu = 0;
    localdvz.UbU = this.NHe;
    if (this.NHc)
    {
      j = (int)u.bBQ(m.cN(this.filename, false));
      if (((com.tencent.mm.modelvoice.g)localObject).miv >= j)
      {
        localfct.UCu = 1;
        this.INk = true;
        Log.i("MicroMsg.NetSceneRegisterVoicePrint", "the last one pack for uploading totallen %d", new Object[] { Integer.valueOf(i) });
      }
    }
    this.zP = ((com.tencent.mm.modelvoice.g)localObject).miv;
    localdvz.UbV = localfct;
    AppMethodBeat.o(29769);
    return 0;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(29768);
    this.callback = parami;
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
    params = (dwa)d.c.b(((d)params).lBS);
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29770);
      return;
    }
    Log.i("MicroMsg.NetSceneRegisterVoicePrint", "voice ticket %d ret %d nextstep %d %d ", new Object[] { Integer.valueOf(params.UbU), Integer.valueOf(params.UbX), Integer.valueOf(params.UbY), Integer.valueOf(params.UbX) });
    this.NHe = params.UbU;
    this.JzA = params.UbY;
    this.Lz = params.UbX;
    if (this.INk)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29770);
      return;
    }
    Log.i("MicroMsg.NetSceneRegisterVoicePrint", "tryDoScene ret %d", new Object[] { Integer.valueOf(gwP()) });
    doScene(dispatcher(), this.callback);
    Log.i("MicroMsg.NetSceneRegisterVoicePrint", "loop doscene");
    AppMethodBeat.o(29770);
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
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.f
 * JD-Core Version:    0.7.0.1
 */