package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.ac;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.cbq;
import com.tencent.mm.protocal.protobuf.cbr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class g
  extends e
{
  private f callback;
  private final b rr;
  
  public g(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    super(paramLong);
    AppMethodBeat.i(24616);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cbq();
    ((b.a)localObject).fsY = new cbr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/shaketv";
    ((b.a)localObject).funcId = 408;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (cbq)this.rr.fsV.fta;
    ((cbq)localObject).pIA = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ((cbq)localObject).xMg = paramInt2;
    if (paramBoolean) {
      paramInt2 = 1;
    }
    for (;;)
    {
      ((cbq)localObject).fKi = paramInt2;
      ((cbq)localObject).xMh = paramInt1;
      if (ac.cm(ah.getContext()))
      {
        paramInt1 = j;
        label158:
        ((cbq)localObject).wLO = paramInt1;
        ((cbq)localObject).wpR = paramInt3;
      }
      try
      {
        aw.aaz();
        f2 = bo.getFloat((String)c.Ru().get(ac.a.yyL, null), 0.0F);
      }
      catch (Exception paramArrayOfByte)
      {
        try
        {
          aw.aaz();
          f1 = bo.getFloat((String)c.Ru().get(ac.a.yyM, null), 0.0F);
        }
        catch (Exception paramArrayOfByte)
        {
          try
          {
            float f2;
            float f1;
            aw.aaz();
            paramInt1 = bo.apV((String)c.Ru().get(ac.a.yBq, null));
            for (;;)
            {
              ((cbq)localObject).wDi = f2;
              ((cbq)localObject).xMi = f1;
              o.a(2009, ((cbq)localObject).xMi, ((cbq)localObject).wDi, paramInt1);
              AppMethodBeat.o(24616);
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
  
  public final bvk clR()
  {
    return (cbr)this.rr.fsW.fta;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(24617);
    cbq localcbq = (cbq)this.rr.fsV.fta;
    ab.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", new Object[] { Integer.valueOf(localcbq.xMg), Integer.valueOf(localcbq.pIA.getILen()), Integer.valueOf(localcbq.fKi), Float.valueOf(localcbq.xMh), Integer.valueOf(localcbq.wLO), Integer.valueOf(localcbq.wpR) });
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(24617);
    return i;
  }
  
  public final int getType()
  {
    return 408;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(24618);
    paramq = (cbq)this.rr.fsV.fta;
    paramArrayOfByte = (cbr)this.rr.fsW.fta;
    ab.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramq.xMg), Integer.valueOf(paramArrayOfByte.fKi) });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.fKi == 1)) {
      this.qOT = true;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(24618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.g
 * JD-Core Version:    0.7.0.1
 */