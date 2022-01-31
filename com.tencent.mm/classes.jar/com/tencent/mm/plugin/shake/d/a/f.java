package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.aw.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.ac;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cbn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class f
  extends e
{
  private com.tencent.mm.ai.f callback;
  private final b rr;
  
  public f(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    super(paramLong);
    AppMethodBeat.i(24613);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cbm();
    ((b.a)localObject).fsY = new cbn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/shakemusic";
    ((b.a)localObject).funcId = 367;
    ((b.a)localObject).reqCmdId = 177;
    ((b.a)localObject).respCmdId = 1000000177;
    this.rr = ((b.a)localObject).ado();
    localObject = (cbm)this.rr.fsV.fta;
    ((cbm)localObject).pIA = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ((cbm)localObject).xMg = paramInt2;
    if (paramBoolean)
    {
      paramInt2 = 1;
      ((cbm)localObject).fKi = paramInt2;
      ((cbm)localObject).xMh = paramInt1;
      if (!ac.cm(ah.getContext())) {
        break label372;
      }
    }
    label372:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      ((cbm)localObject).wLO = paramInt1;
      ((cbm)localObject).wpR = paramInt3;
      float f3 = 0.0F;
      float f4 = 0.0F;
      float f2 = f4;
      float f1 = f3;
      try
      {
        aw.aaz();
        f2 = f4;
        f1 = f3;
        f3 = bo.getFloat((String)c.Ru().get(ac.a.yyL, null), 0.0F);
        f2 = f4;
        f1 = f3;
        aw.aaz();
        f2 = f4;
        f1 = f3;
        f4 = bo.getFloat((String)c.Ru().get(ac.a.yyM, null), 0.0F);
        f2 = f4;
        f1 = f3;
        aw.aaz();
        f2 = f4;
        f1 = f3;
        paramInt1 = bo.apV((String)c.Ru().get(ac.a.yBq, null));
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
      ((cbm)localObject).wDi = f1;
      ((cbm)localObject).xMi = f2;
      if (!d.aiG()) {
        break label383;
      }
      paramInt2 = 0;
      ((cbm)localObject).xeu = paramInt2;
      if (!d.aiF()) {
        break label389;
      }
      paramInt2 = 1;
      ((cbm)localObject).xev = paramInt2;
      o.a(2014, ((cbm)localObject).xMi, ((cbm)localObject).wDi, paramInt1);
      AppMethodBeat.o(24613);
      return;
      paramInt2 = 0;
      break;
    }
  }
  
  public final bvk clR()
  {
    return (cbn)this.rr.fsW.fta;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(24614);
    cbm localcbm = (cbm)this.rr.fsV.fta;
    ab.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", new Object[] { Integer.valueOf(localcbm.xMg), Integer.valueOf(localcbm.pIA.getILen()), Integer.valueOf(localcbm.fKi), Float.valueOf(localcbm.xMh), Integer.valueOf(localcbm.wLO), Integer.valueOf(localcbm.wpR) });
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(24614);
    return i;
  }
  
  public final int getType()
  {
    return 367;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(24615);
    paramq = (cbm)this.rr.fsV.fta;
    paramArrayOfByte = (cbn)this.rr.fsW.fta;
    ab.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramq.xMg), Integer.valueOf(paramArrayOfByte.fKi) });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.fKi == 1)) {
      this.qOT = true;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(24615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.f
 * JD-Core Version:    0.7.0.1
 */