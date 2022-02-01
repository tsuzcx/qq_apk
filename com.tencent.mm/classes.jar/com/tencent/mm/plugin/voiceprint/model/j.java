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
import com.tencent.mm.protocal.protobuf.eqg;
import com.tencent.mm.protocal.protobuf.eqh;
import com.tencent.mm.protocal.protobuf.esi;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  extends q
  implements com.tencent.mm.network.m
{
  private boolean CIm;
  public boolean GQR;
  private Handler GQS;
  private int GQT;
  int NH;
  private i callback;
  private String filename;
  private int fs;
  private String kly;
  private final d rr;
  
  public j(String paramString, int paramInt)
  {
    AppMethodBeat.i(29785);
    this.fs = 0;
    this.GQR = false;
    this.CIm = false;
    this.GQS = null;
    this.GQT = 0;
    this.NH = 0;
    this.kly = "";
    Log.d("MicroMsg.NetSceneVerifyVoicePrint", "resid %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new eqg();
    ((d.a)localObject).iLO = new eqh();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyvoiceprint";
    ((d.a)localObject).funcId = 613;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (eqg)this.rr.iLK.iLR;
    this.filename = paramString;
    this.fs = 0;
    ((eqg)localObject).MPS = paramInt;
    this.GQT = 0;
    ((eqg)localObject).MPQ = 0;
    Log.i("MicroMsg.NetSceneVerifyVoicePrint", "voiceRegist %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0) });
    this.GQR = true;
    fEC();
    AppMethodBeat.o(29785);
  }
  
  private int fEC()
  {
    AppMethodBeat.i(29787);
    eqg localeqg = (eqg)this.rr.iLK.iLR;
    esi localesi = new esi();
    new com.tencent.mm.modelvoice.g();
    localeqg.NnN = localesi;
    Object localObject = new n(m.cz(this.filename, false));
    int i = (int)com.tencent.mm.vfs.s.boW(m.cz(this.filename, false));
    if (i - this.fs >= 6000) {}
    int j;
    for (localObject = ((n)localObject).dB(this.fs, 6000);; localObject = ((n)localObject).dB(j, i - j))
    {
      Log.d("MicroMsg.NetSceneVerifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[] { Integer.valueOf(this.fs), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).dAc), Integer.valueOf(i), Boolean.valueOf(this.GQR) });
      if (((com.tencent.mm.modelvoice.g)localObject).dAc != 0) {
        break;
      }
      AppMethodBeat.o(29787);
      return -2;
      j = this.fs;
    }
    if (((com.tencent.mm.modelvoice.g)localObject).ret < 0)
    {
      Log.w("MicroMsg.NetSceneVerifyVoicePrint", "readerror %d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret) });
      AppMethodBeat.o(29787);
      return -1;
    }
    if (this.fs >= 469000)
    {
      Log.i("MicroMsg.NetSceneVerifyVoicePrint", "moffset > maxfile %d", new Object[] { Integer.valueOf(this.fs) });
      AppMethodBeat.o(29787);
      return -1;
    }
    localesi.Npz = new SKBuiltinBuffer_t().setBuffer(((com.tencent.mm.modelvoice.g)localObject).buf);
    localesi.BsG = this.fs;
    localesi.Npx = ((com.tencent.mm.modelvoice.g)localObject).dAc;
    localesi.Npy = 0;
    localeqg.MPQ = this.GQT;
    if (this.GQR)
    {
      j = (int)com.tencent.mm.vfs.s.boW(m.cz(this.filename, false));
      if (((com.tencent.mm.modelvoice.g)localObject).jsR >= j)
      {
        localesi.Npy = 1;
        this.CIm = true;
        Log.i("MicroMsg.NetSceneVerifyVoicePrint", "the last one pack for uploading totallen %d", new Object[] { Integer.valueOf(i) });
      }
    }
    this.fs = ((com.tencent.mm.modelvoice.g)localObject).jsR;
    localeqg.NnN = localesi;
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29788);
    Log.d("MicroMsg.NetSceneVerifyVoicePrint", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    params = (eqh)((d)params).iLL.iLR;
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29788);
      return;
    }
    this.GQT = params.MPQ;
    this.NH = params.LjQ;
    Log.i("MicroMsg.NetSceneVerifyVoicePrint", "voice VoiceTicket %d mResult %d", new Object[] { Integer.valueOf(params.MPQ), Integer.valueOf(this.NH) });
    if (this.CIm)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29788);
      return;
    }
    Log.i("MicroMsg.NetSceneVerifyVoicePrint", "tryDoScene ret %d", new Object[] { Integer.valueOf(fEC()) });
    doScene(dispatcher(), this.callback);
    Log.i("MicroMsg.NetSceneVerifyVoicePrint", "loop doscene");
    AppMethodBeat.o(29788);
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
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.j
 * JD-Core Version:    0.7.0.1
 */