package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.cxo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah.a;

public final class f
  extends e
{
  private g callback;
  private final b rr;
  
  public f(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    super(paramLong);
    AppMethodBeat.i(28283);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cxn();
    ((b.a)localObject).hvu = new cxo();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/shakemusic";
    ((b.a)localObject).funcId = 367;
    ((b.a)localObject).reqCmdId = 177;
    ((b.a)localObject).respCmdId = 1000000177;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cxn)this.rr.hvr.hvw;
    ((cxn)localObject).vTK = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ((cxn)localObject).FHc = paramInt2;
    if (paramBoolean)
    {
      paramInt2 = 1;
      ((cxn)localObject).hNR = paramInt2;
      ((cxn)localObject).FHd = paramInt1;
      if (!com.tencent.mm.network.ae.cS(ai.getContext())) {
        break label372;
      }
    }
    label372:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      ((cxn)localObject).EqS = paramInt1;
      ((cxn)localObject).DRa = paramInt3;
      float f3 = 0.0F;
      float f4 = 0.0F;
      float f2 = f4;
      float f1 = f3;
      try
      {
        az.ayM();
        f2 = f4;
        f1 = f3;
        f3 = bs.getFloat((String)c.agA().get(ah.a.GEV, null), 0.0F);
        f2 = f4;
        f1 = f3;
        az.ayM();
        f2 = f4;
        f1 = f3;
        f4 = bs.getFloat((String)c.agA().get(ah.a.GEW, null), 0.0F);
        f2 = f4;
        f1 = f3;
        az.ayM();
        f2 = f4;
        f1 = f3;
        paramInt1 = bs.aLy((String)c.agA().get(ah.a.GHB, null));
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
      ((cxn)localObject).Ehu = f1;
      ((cxn)localObject).FHe = f2;
      if (!com.tencent.mm.ay.e.aGF()) {
        break label383;
      }
      paramInt2 = 0;
      ((cxn)localObject).ESF = paramInt2;
      if (!com.tencent.mm.ay.e.aGE()) {
        break label389;
      }
      paramInt2 = 1;
      ((cxn)localObject).ESG = paramInt2;
      o.a(2014, ((cxn)localObject).FHe, ((cxn)localObject).Ehu, paramInt1);
      AppMethodBeat.o(28283);
      return;
      paramInt2 = 0;
      break;
    }
  }
  
  public final cqk dDO()
  {
    return (cxo)this.rr.hvs.hvw;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(28284);
    cxn localcxn = (cxn)this.rr.hvr.hvw;
    ac.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", new Object[] { Integer.valueOf(localcxn.FHc), Integer.valueOf(localcxn.vTK.getILen()), Integer.valueOf(localcxn.hNR), Float.valueOf(localcxn.FHd), Integer.valueOf(localcxn.EqS), Integer.valueOf(localcxn.DRa) });
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(28284);
    return i;
  }
  
  public final int getType()
  {
    return 367;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28285);
    paramq = (cxn)this.rr.hvr.hvw;
    paramArrayOfByte = (cxo)this.rr.hvs.hvw;
    ac.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramq.FHc), Integer.valueOf(paramArrayOfByte.hNR) });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.hNR == 1)) {
      this.dlS = true;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.f
 * JD-Core Version:    0.7.0.1
 */