package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dmi;
import com.tencent.mm.protocal.protobuf.dmj;
import com.tencent.mm.protocal.protobuf.esi;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
  extends q
  implements com.tencent.mm.network.m
{
  private boolean CIm;
  private int DsN;
  public boolean GQR;
  private Handler GQS;
  int GQT;
  int GQU;
  int NH;
  private i callback;
  private String filename;
  private int fs;
  private final d rr;
  
  public f(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(29767);
    this.fs = 0;
    this.GQR = false;
    this.CIm = false;
    this.GQS = null;
    this.GQT = 0;
    this.DsN = 0;
    this.GQU = 0;
    this.NH = 0;
    Log.d("MicroMsg.NetSceneRegisterVoicePrint", "step %d resid %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.GQU = paramInt1;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dmi();
    ((d.a)localObject).iLO = new dmj();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/registervoiceprint";
    ((d.a)localObject).funcId = 612;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dmi)this.rr.iLK.iLR;
    this.filename = paramString;
    this.fs = 0;
    ((dmi)localObject).MPS = paramInt2;
    ((dmi)localObject).oUu = paramInt1;
    this.GQT = paramInt3;
    ((dmi)localObject).MPQ = paramInt3;
    Log.i("MicroMsg.NetSceneRegisterVoicePrint", "voiceRegist %d %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.GQR = true;
    fEC();
    AppMethodBeat.o(29767);
  }
  
  private int fEC()
  {
    AppMethodBeat.i(29769);
    dmi localdmi = (dmi)this.rr.iLK.iLR;
    esi localesi = new esi();
    new com.tencent.mm.modelvoice.g();
    localdmi.MPR = localesi;
    Object localObject = new n(m.cz(this.filename, false));
    int i = (int)com.tencent.mm.vfs.s.boW(m.cz(this.filename, false));
    if (i - this.fs >= 6000) {}
    int j;
    for (localObject = ((n)localObject).dB(this.fs, 6000);; localObject = ((n)localObject).dB(j, i - j))
    {
      Log.d("MicroMsg.NetSceneRegisterVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[] { Integer.valueOf(this.fs), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).dAc), Integer.valueOf(i), Boolean.valueOf(this.GQR) });
      if (((com.tencent.mm.modelvoice.g)localObject).dAc != 0) {
        break;
      }
      AppMethodBeat.o(29769);
      return -2;
      j = this.fs;
    }
    if (((com.tencent.mm.modelvoice.g)localObject).ret < 0)
    {
      Log.w("MicroMsg.NetSceneRegisterVoicePrint", "readerror %d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret) });
      AppMethodBeat.o(29769);
      return -1;
    }
    if (this.fs >= 469000)
    {
      Log.i("MicroMsg.NetSceneRegisterVoicePrint", "moffset > maxfile %d", new Object[] { Integer.valueOf(this.fs) });
      AppMethodBeat.o(29769);
      return -1;
    }
    localesi.Npz = new SKBuiltinBuffer_t().setBuffer(((com.tencent.mm.modelvoice.g)localObject).buf);
    localesi.BsG = this.fs;
    localesi.Npx = ((com.tencent.mm.modelvoice.g)localObject).dAc;
    localesi.Npy = 0;
    localdmi.MPQ = this.GQT;
    if (this.GQR)
    {
      j = (int)com.tencent.mm.vfs.s.boW(m.cz(this.filename, false));
      if (((com.tencent.mm.modelvoice.g)localObject).jsR >= j)
      {
        localesi.Npy = 1;
        this.CIm = true;
        Log.i("MicroMsg.NetSceneRegisterVoicePrint", "the last one pack for uploading totallen %d", new Object[] { Integer.valueOf(i) });
      }
    }
    this.fs = ((com.tencent.mm.modelvoice.g)localObject).jsR;
    localdmi.MPR = localesi;
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29770);
    Log.d("MicroMsg.NetSceneRegisterVoicePrint", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    params = (dmj)((d)params).iLL.iLR;
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29770);
      return;
    }
    Log.i("MicroMsg.NetSceneRegisterVoicePrint", "voice ticket %d ret %d nextstep %d %d ", new Object[] { Integer.valueOf(params.MPQ), Integer.valueOf(params.MPT), Integer.valueOf(params.MPU), Integer.valueOf(params.MPT) });
    this.GQT = params.MPQ;
    this.DsN = params.MPU;
    this.NH = params.MPT;
    if (this.CIm)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29770);
      return;
    }
    Log.i("MicroMsg.NetSceneRegisterVoicePrint", "tryDoScene ret %d", new Object[] { Integer.valueOf(fEC()) });
    doScene(dispatcher(), this.callback);
    Log.i("MicroMsg.NetSceneRegisterVoicePrint", "loop doscene");
    AppMethodBeat.o(29770);
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
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.f
 * JD-Core Version:    0.7.0.1
 */