package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.ag;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dwy;
import com.tencent.mm.protocal.protobuf.dwz;
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
    ((d.a)localObject).iLN = new dwy();
    ((d.a)localObject).iLO = new dwz();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/shakemusic";
    ((d.a)localObject).funcId = 367;
    ((d.a)localObject).iLP = 177;
    ((d.a)localObject).respCmdId = 1000000177;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dwy)this.rr.iLK.iLR;
    ((dwy)localObject).BsI = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ((dwy)localObject).MWV = paramInt2;
    if (paramBoolean)
    {
      paramInt2 = 1;
      ((dwy)localObject).jeU = paramInt2;
      ((dwy)localObject).MWW = paramInt1;
      if (!ag.dm(MMApplicationContext.getContext())) {
        break label372;
      }
    }
    label372:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      ((dwy)localObject).Llx = paramInt1;
      ((dwy)localObject).KIy = paramInt3;
      float f3 = 0.0F;
      float f4 = 0.0F;
      float f2 = f4;
      float f1 = f3;
      try
      {
        bg.aVF();
        f2 = f4;
        f1 = f3;
        f3 = Util.getFloat((String)c.azQ().get(ar.a.NTL, null), 0.0F);
        f2 = f4;
        f1 = f3;
        bg.aVF();
        f2 = f4;
        f1 = f3;
        f4 = Util.getFloat((String)c.azQ().get(ar.a.NTM, null), 0.0F);
        f2 = f4;
        f1 = f3;
        bg.aVF();
        f2 = f4;
        f1 = f3;
        paramInt1 = Util.safeParseInt((String)c.azQ().get(ar.a.NWs, null));
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
      ((dwy)localObject).LbD = f1;
      ((dwy)localObject).MWX = f2;
      if (!com.tencent.mm.ay.e.bem()) {
        break label383;
      }
      paramInt2 = 0;
      ((dwy)localObject).LZS = paramInt2;
      if (!com.tencent.mm.ay.e.bel()) {
        break label389;
      }
      paramInt2 = 1;
      ((dwy)localObject).LZT = paramInt2;
      o.a(2014, ((dwy)localObject).MWX, ((dwy)localObject).LbD, paramInt1);
      AppMethodBeat.o(28283);
      return;
      paramInt2 = 0;
      break;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(28284);
    dwy localdwy = (dwy)this.rr.iLK.iLR;
    Log.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", new Object[] { Integer.valueOf(localdwy.MWV), Integer.valueOf(localdwy.BsI.getILen()), Integer.valueOf(localdwy.jeU), Float.valueOf(localdwy.MWW), Integer.valueOf(localdwy.Llx), Integer.valueOf(localdwy.KIy) });
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(28284);
    return i;
  }
  
  public final dpc eUP()
  {
    return (dwz)this.rr.iLL.iLR;
  }
  
  public final int getType()
  {
    return 367;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28285);
    params = (dwy)this.rr.iLK.iLR;
    paramArrayOfByte = (dwz)this.rr.iLL.iLR;
    Log.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(params.MWV), Integer.valueOf(paramArrayOfByte.jeU) });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.jeU == 1)) {
      this.dQA = true;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.f
 * JD-Core Version:    0.7.0.1
 */