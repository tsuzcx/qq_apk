package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.protocal.protobuf.cxr;
import com.tencent.mm.protocal.protobuf.cxs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah.a;

public final class g
  extends e
{
  private com.tencent.mm.ak.g callback;
  private final b rr;
  
  public g(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    super(paramLong);
    AppMethodBeat.i(28286);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cxr();
    ((b.a)localObject).hvu = new cxs();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/shaketv";
    ((b.a)localObject).funcId = 408;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cxr)this.rr.hvr.hvw;
    ((cxr)localObject).vTK = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ((cxr)localObject).FHc = paramInt2;
    if (paramBoolean) {
      paramInt2 = 1;
    }
    for (;;)
    {
      ((cxr)localObject).hNR = paramInt2;
      ((cxr)localObject).FHd = paramInt1;
      if (com.tencent.mm.network.ae.cS(ai.getContext()))
      {
        paramInt1 = j;
        label158:
        ((cxr)localObject).EqS = paramInt1;
        ((cxr)localObject).DRa = paramInt3;
      }
      try
      {
        az.ayM();
        f2 = bs.getFloat((String)c.agA().get(ah.a.GEV, null), 0.0F);
      }
      catch (Exception paramArrayOfByte)
      {
        try
        {
          az.ayM();
          f1 = bs.getFloat((String)c.agA().get(ah.a.GEW, null), 0.0F);
        }
        catch (Exception paramArrayOfByte)
        {
          try
          {
            float f2;
            float f1;
            az.ayM();
            paramInt1 = bs.aLy((String)c.agA().get(ah.a.GHB, null));
            for (;;)
            {
              ((cxr)localObject).Ehu = f2;
              ((cxr)localObject).FHe = f1;
              o.a(2009, ((cxr)localObject).FHe, ((cxr)localObject).Ehu, paramInt1);
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
  
  public final cqk dDO()
  {
    return (cxs)this.rr.hvs.hvw;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(28287);
    cxr localcxr = (cxr)this.rr.hvr.hvw;
    ac.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", new Object[] { Integer.valueOf(localcxr.FHc), Integer.valueOf(localcxr.vTK.getILen()), Integer.valueOf(localcxr.hNR), Float.valueOf(localcxr.FHd), Integer.valueOf(localcxr.EqS), Integer.valueOf(localcxr.DRa) });
    this.callback = paramg;
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
    paramq = (cxr)this.rr.hvr.hvw;
    paramArrayOfByte = (cxs)this.rr.hvs.hvw;
    ac.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramq.FHc), Integer.valueOf(paramArrayOfByte.hNR) });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.hNR == 1)) {
      this.dlS = true;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.g
 * JD-Core Version:    0.7.0.1
 */