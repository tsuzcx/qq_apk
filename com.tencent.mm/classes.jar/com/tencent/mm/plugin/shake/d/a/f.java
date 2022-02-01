package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.ag;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.egz;
import com.tencent.mm.protocal.protobuf.eha;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class f
  extends e
{
  private i callback;
  private final d rr;
  
  public f(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    super(paramLong);
    AppMethodBeat.i(28283);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new egz();
    ((d.a)localObject).lBV = new eha();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/shakemusic";
    ((d.a)localObject).funcId = 367;
    ((d.a)localObject).lBW = 177;
    ((d.a)localObject).respCmdId = 1000000177;
    this.rr = ((d.a)localObject).bgN();
    localObject = (egz)d.b.b(this.rr.lBR);
    ((egz)localObject).Hnc = new eae().dc(paramArrayOfByte);
    ((egz)localObject).Ujq = paramInt2;
    if (paramBoolean)
    {
      paramInt2 = 1;
      ((egz)localObject).lVs = paramInt2;
      ((egz)localObject).Ujr = paramInt1;
      if (!ag.dj(MMApplicationContext.getContext())) {
        break label372;
      }
    }
    label372:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      ((egz)localObject).SmH = paramInt1;
      ((egz)localObject).RJP = paramInt3;
      float f3 = 0.0F;
      float f4 = 0.0F;
      float f2 = f4;
      float f1 = f3;
      try
      {
        bh.beI();
        f2 = f4;
        f1 = f3;
        f3 = Util.getFloat((String)c.aHp().get(ar.a.VhL, null), 0.0F);
        f2 = f4;
        f1 = f3;
        bh.beI();
        f2 = f4;
        f1 = f3;
        f4 = Util.getFloat((String)c.aHp().get(ar.a.VhM, null), 0.0F);
        f2 = f4;
        f1 = f3;
        bh.beI();
        f2 = f4;
        f1 = f3;
        paramInt1 = Util.safeParseInt((String)c.aHp().get(ar.a.Vks, null));
        f1 = f3;
        f2 = f4;
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          paramInt1 = 0;
          continue;
          paramInt2 = 1;
          continue;
          paramInt2 = 0;
        }
      }
      ((egz)localObject).ScP = f1;
      ((egz)localObject).Ujs = f2;
      if (!com.tencent.mm.bb.e.bnH()) {
        break label383;
      }
      paramInt2 = 0;
      ((egz)localObject).Tjl = paramInt2;
      if (!com.tencent.mm.bb.e.bnG()) {
        break label389;
      }
      paramInt2 = 1;
      ((egz)localObject).Tjm = paramInt2;
      n.a(2014, ((egz)localObject).Ujs, ((egz)localObject).ScP, paramInt1);
      AppMethodBeat.o(28283);
      return;
      paramInt2 = 0;
      break;
    }
  }
  
  public static int arZ()
  {
    return 367;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(28284);
    egz localegz = (egz)d.b.b(this.rr.lBR);
    Log.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", new Object[] { Integer.valueOf(localegz.Ujq), Integer.valueOf(localegz.Hnc.Ufv), Integer.valueOf(localegz.lVs), Float.valueOf(localegz.Ujr), Integer.valueOf(localegz.SmH), Integer.valueOf(localegz.RJP) });
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(28284);
    return i;
  }
  
  public final dyy fHQ()
  {
    AppMethodBeat.i(286882);
    eha localeha = (eha)d.c.b(this.rr.lBS);
    AppMethodBeat.o(286882);
    return localeha;
  }
  
  public final int getType()
  {
    return 367;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28285);
    params = (egz)d.b.b(this.rr.lBR);
    paramArrayOfByte = (eha)d.c.b(this.rr.lBS);
    Log.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(params.Ujq), Integer.valueOf(paramArrayOfByte.lVs) });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.lVs == 1)) {
      this.fJQ = true;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.f
 * JD-Core Version:    0.7.0.1
 */