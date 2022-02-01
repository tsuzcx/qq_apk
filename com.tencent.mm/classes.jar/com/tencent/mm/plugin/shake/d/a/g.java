package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.protocal.protobuf.ddz;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class g
  extends e
{
  private f callback;
  private final b rr;
  
  public g(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    super(paramLong);
    AppMethodBeat.i(28286);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ddy();
    ((b.a)localObject).hQG = new ddz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/shaketv";
    ((b.a)localObject).funcId = 408;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (ddy)this.rr.hQD.hQJ;
    ((ddy)localObject).xsE = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ((ddy)localObject).HLm = paramInt2;
    if (paramBoolean) {
      paramInt2 = 1;
    }
    for (;;)
    {
      ((ddy)localObject).ijY = paramInt2;
      ((ddy)localObject).HLn = paramInt1;
      if (com.tencent.mm.network.ae.cR(ak.getContext()))
      {
        paramInt1 = j;
        label158:
        ((ddy)localObject).GqB = paramInt1;
        ((ddy)localObject).FOQ = paramInt3;
      }
      try
      {
        bc.aCg();
        f2 = bu.getFloat((String)c.ajA().get(am.a.ILJ, null), 0.0F);
      }
      catch (Exception paramArrayOfByte)
      {
        try
        {
          bc.aCg();
          f1 = bu.getFloat((String)c.ajA().get(am.a.ILK, null), 0.0F);
        }
        catch (Exception paramArrayOfByte)
        {
          try
          {
            float f2;
            float f1;
            bc.aCg();
            paramInt1 = bu.aSB((String)c.ajA().get(am.a.IOq, null));
            for (;;)
            {
              ((ddy)localObject).Gha = f2;
              ((ddy)localObject).HLo = f1;
              o.a(2009, ((ddy)localObject).HLo, ((ddy)localObject).Gha, paramInt1);
              AppMethodBeat.o(28286);
              return;
              paramInt2 = 0;
              break;
              paramInt1 = 2;
              break label158;
              paramArrayOfByte = paramArrayOfByte;
              f1 = 0.0F;
              f2 = 0.0F;
              paramInt1 = i;
              continue;
              paramArrayOfByte = paramArrayOfByte;
              f1 = 0.0F;
              paramInt1 = i;
            }
          }
          catch (Exception paramArrayOfByte)
          {
            for (;;)
            {
              paramInt1 = i;
            }
          }
        }
      }
    }
  }
  
  public final cwj dSO()
  {
    return (ddz)this.rr.hQE.hQJ;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(28287);
    ddy localddy = (ddy)this.rr.hQD.hQJ;
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", new Object[] { Integer.valueOf(localddy.HLm), Integer.valueOf(localddy.xsE.getILen()), Integer.valueOf(localddy.ijY), Float.valueOf(localddy.HLn), Integer.valueOf(localddy.GqB), Integer.valueOf(localddy.FOQ) });
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(28287);
    return i;
  }
  
  public final int getType()
  {
    return 408;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28288);
    paramq = (ddy)this.rr.hQD.hQJ;
    paramArrayOfByte = (ddz)this.rr.hQE.hQJ;
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramq.HLm), Integer.valueOf(paramArrayOfByte.ijY) });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.ijY == 1)) {
      this.dyL = true;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.g
 * JD-Core Version:    0.7.0.1
 */