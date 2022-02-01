package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.protocal.protobuf.ddu;
import com.tencent.mm.protocal.protobuf.ddv;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class f
  extends e
{
  private com.tencent.mm.ak.f callback;
  private final b rr;
  
  public f(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    super(paramLong);
    AppMethodBeat.i(28283);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ddu();
    ((b.a)localObject).hQG = new ddv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/shakemusic";
    ((b.a)localObject).funcId = 367;
    ((b.a)localObject).hQH = 177;
    ((b.a)localObject).respCmdId = 1000000177;
    this.rr = ((b.a)localObject).aDS();
    localObject = (ddu)this.rr.hQD.hQJ;
    ((ddu)localObject).xsE = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ((ddu)localObject).HLm = paramInt2;
    if (paramBoolean)
    {
      paramInt2 = 1;
      ((ddu)localObject).ijY = paramInt2;
      ((ddu)localObject).HLn = paramInt1;
      if (!com.tencent.mm.network.ae.cR(ak.getContext())) {
        break label372;
      }
    }
    label372:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      ((ddu)localObject).GqB = paramInt1;
      ((ddu)localObject).FOQ = paramInt3;
      float f3 = 0.0F;
      float f4 = 0.0F;
      float f2 = f4;
      float f1 = f3;
      try
      {
        bc.aCg();
        f2 = f4;
        f1 = f3;
        f3 = bu.getFloat((String)c.ajA().get(am.a.ILJ, null), 0.0F);
        f2 = f4;
        f1 = f3;
        bc.aCg();
        f2 = f4;
        f1 = f3;
        f4 = bu.getFloat((String)c.ajA().get(am.a.ILK, null), 0.0F);
        f2 = f4;
        f1 = f3;
        bc.aCg();
        f2 = f4;
        f1 = f3;
        paramInt1 = bu.aSB((String)c.ajA().get(am.a.IOq, null));
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
      ((ddu)localObject).Gha = f1;
      ((ddu)localObject).HLo = f2;
      if (!com.tencent.mm.ay.e.aKj()) {
        break label383;
      }
      paramInt2 = 0;
      ((ddu)localObject).GVy = paramInt2;
      if (!com.tencent.mm.ay.e.aKi()) {
        break label389;
      }
      paramInt2 = 1;
      ((ddu)localObject).GVz = paramInt2;
      o.a(2014, ((ddu)localObject).HLo, ((ddu)localObject).Gha, paramInt1);
      AppMethodBeat.o(28283);
      return;
      paramInt2 = 0;
      break;
    }
  }
  
  public final cwj dSO()
  {
    return (ddv)this.rr.hQE.hQJ;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(28284);
    ddu localddu = (ddu)this.rr.hQD.hQJ;
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", new Object[] { Integer.valueOf(localddu.HLm), Integer.valueOf(localddu.xsE.getILen()), Integer.valueOf(localddu.ijY), Float.valueOf(localddu.HLn), Integer.valueOf(localddu.GqB), Integer.valueOf(localddu.FOQ) });
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
    paramq = (ddu)this.rr.hQD.hQJ;
    paramArrayOfByte = (ddv)this.rr.hQE.hQJ;
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramq.HLm), Integer.valueOf(paramArrayOfByte.ijY) });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.ijY == 1)) {
      this.dyL = true;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.f
 * JD-Core Version:    0.7.0.1
 */