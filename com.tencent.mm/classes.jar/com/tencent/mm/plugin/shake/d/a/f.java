package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.ae;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.protocal.protobuf.cse;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

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
    ((b.a)localObject).gUU = new cse();
    ((b.a)localObject).gUV = new csf();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/shakemusic";
    ((b.a)localObject).funcId = 367;
    ((b.a)localObject).reqCmdId = 177;
    ((b.a)localObject).respCmdId = 1000000177;
    this.rr = ((b.a)localObject).atI();
    localObject = (cse)this.rr.gUS.gUX;
    ((cse)localObject).uKT = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ((cse)localObject).Eke = paramInt2;
    if (paramBoolean)
    {
      paramInt2 = 1;
      ((cse)localObject).hno = paramInt2;
      ((cse)localObject).Ekf = paramInt1;
      if (!ae.cJ(aj.getContext())) {
        break label372;
      }
    }
    label372:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      ((cse)localObject).CYi = paramInt1;
      ((cse)localObject).CyE = paramInt3;
      float f3 = 0.0F;
      float f4 = 0.0F;
      float f2 = f4;
      float f1 = f3;
      try
      {
        az.arV();
        f2 = f4;
        f1 = f3;
        f3 = bt.getFloat((String)c.afk().get(ae.a.Fhg, null), 0.0F);
        f2 = f4;
        f1 = f3;
        az.arV();
        f2 = f4;
        f1 = f3;
        f4 = bt.getFloat((String)c.afk().get(ae.a.Fhh, null), 0.0F);
        f2 = f4;
        f1 = f3;
        az.arV();
        f2 = f4;
        f1 = f3;
        paramInt1 = bt.aGh((String)c.afk().get(ae.a.FjM, null));
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
      ((cse)localObject).COJ = f1;
      ((cse)localObject).Ekg = f2;
      if (!com.tencent.mm.az.e.azP()) {
        break label383;
      }
      paramInt2 = 0;
      ((cse)localObject).Dxk = paramInt2;
      if (!com.tencent.mm.az.e.azO()) {
        break label389;
      }
      paramInt2 = 1;
      ((cse)localObject).Dxl = paramInt2;
      o.a(2014, ((cse)localObject).Ekg, ((cse)localObject).COJ, paramInt1);
      AppMethodBeat.o(28283);
      return;
      paramInt2 = 0;
      break;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(28284);
    cse localcse = (cse)this.rr.gUS.gUX;
    ad.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", new Object[] { Integer.valueOf(localcse.Eke), Integer.valueOf(localcse.uKT.getILen()), Integer.valueOf(localcse.hno), Float.valueOf(localcse.Ekf), Integer.valueOf(localcse.CYi), Integer.valueOf(localcse.CyE) });
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(28284);
    return i;
  }
  
  public final cld dpE()
  {
    return (csf)this.rr.gUT.gUX;
  }
  
  public final int getType()
  {
    return 367;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28285);
    paramq = (cse)this.rr.gUS.gUX;
    paramArrayOfByte = (csf)this.rr.gUT.gUX;
    ad.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramq.Eke), Integer.valueOf(paramArrayOfByte.hno) });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.hno == 1)) {
      this.doj = true;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.f
 * JD-Core Version:    0.7.0.1
 */