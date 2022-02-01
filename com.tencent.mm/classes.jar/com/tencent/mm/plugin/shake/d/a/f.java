package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.ae;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.protocal.protobuf.dda;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class f
  extends e
{
  private com.tencent.mm.al.f callback;
  private final b rr;
  
  public f(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    super(paramLong);
    AppMethodBeat.i(28283);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dda();
    ((b.a)localObject).hNN = new ddb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/shakemusic";
    ((b.a)localObject).funcId = 367;
    ((b.a)localObject).hNO = 177;
    ((b.a)localObject).respCmdId = 1000000177;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dda)this.rr.hNK.hNQ;
    ((dda)localObject).xcN = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ((dda)localObject).HrK = paramInt2;
    if (paramBoolean)
    {
      paramInt2 = 1;
      ((dda)localObject).ihf = paramInt2;
      ((dda)localObject).HrL = paramInt1;
      if (!ae.cP(aj.getContext())) {
        break label372;
      }
    }
    label372:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      ((dda)localObject).FYc = paramInt1;
      ((dda)localObject).Fws = paramInt3;
      float f3 = 0.0F;
      float f4 = 0.0F;
      float f2 = f4;
      float f1 = f3;
      try
      {
        ba.aBQ();
        f2 = f4;
        f1 = f3;
        f3 = bt.getFloat((String)c.ajl().get(al.a.Irn, null), 0.0F);
        f2 = f4;
        f1 = f3;
        ba.aBQ();
        f2 = f4;
        f1 = f3;
        f4 = bt.getFloat((String)c.ajl().get(al.a.Iro, null), 0.0F);
        f2 = f4;
        f1 = f3;
        ba.aBQ();
        f2 = f4;
        f1 = f3;
        paramInt1 = bt.aRe((String)c.ajl().get(al.a.ItT, null));
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
      ((dda)localObject).FOB = f1;
      ((dda)localObject).HrM = f2;
      if (!com.tencent.mm.az.e.aJQ()) {
        break label383;
      }
      paramInt2 = 0;
      ((dda)localObject).GBY = paramInt2;
      if (!com.tencent.mm.az.e.aJP()) {
        break label389;
      }
      paramInt2 = 1;
      ((dda)localObject).GBZ = paramInt2;
      o.a(2014, ((dda)localObject).HrM, ((dda)localObject).FOB, paramInt1);
      AppMethodBeat.o(28283);
      return;
      paramInt2 = 0;
      break;
    }
  }
  
  public final cvp dPr()
  {
    return (ddb)this.rr.hNL.hNQ;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(28284);
    dda localdda = (dda)this.rr.hNK.hNQ;
    ad.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", new Object[] { Integer.valueOf(localdda.HrK), Integer.valueOf(localdda.xcN.getILen()), Integer.valueOf(localdda.ihf), Float.valueOf(localdda.HrL), Integer.valueOf(localdda.FYc), Integer.valueOf(localdda.Fws) });
    this.callback = paramf;
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
    paramq = (dda)this.rr.hNK.hNQ;
    paramArrayOfByte = (ddb)this.rr.hNL.hNQ;
    ad.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramq.HrK), Integer.valueOf(paramArrayOfByte.ihf) });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.ihf == 1)) {
      this.dxG = true;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.f
 * JD-Core Version:    0.7.0.1
 */