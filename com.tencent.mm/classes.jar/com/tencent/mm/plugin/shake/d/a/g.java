package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.ae;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.protocal.protobuf.dde;
import com.tencent.mm.protocal.protobuf.ddf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

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
    ((b.a)localObject).hNM = new dde();
    ((b.a)localObject).hNN = new ddf();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/shaketv";
    ((b.a)localObject).funcId = 408;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dde)this.rr.hNK.hNQ;
    ((dde)localObject).xcN = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ((dde)localObject).HrK = paramInt2;
    if (paramBoolean) {
      paramInt2 = 1;
    }
    for (;;)
    {
      ((dde)localObject).ihf = paramInt2;
      ((dde)localObject).HrL = paramInt1;
      if (ae.cP(aj.getContext()))
      {
        paramInt1 = j;
        label158:
        ((dde)localObject).FYc = paramInt1;
        ((dde)localObject).Fws = paramInt3;
      }
      try
      {
        ba.aBQ();
        f2 = bt.getFloat((String)c.ajl().get(al.a.Irn, null), 0.0F);
      }
      catch (Exception paramArrayOfByte)
      {
        try
        {
          ba.aBQ();
          f1 = bt.getFloat((String)c.ajl().get(al.a.Iro, null), 0.0F);
        }
        catch (Exception paramArrayOfByte)
        {
          try
          {
            float f2;
            float f1;
            ba.aBQ();
            paramInt1 = bt.aRe((String)c.ajl().get(al.a.ItT, null));
            for (;;)
            {
              ((dde)localObject).FOB = f2;
              ((dde)localObject).HrM = f1;
              o.a(2009, ((dde)localObject).HrM, ((dde)localObject).FOB, paramInt1);
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
  
  public final cvp dPr()
  {
    return (ddf)this.rr.hNL.hNQ;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(28287);
    dde localdde = (dde)this.rr.hNK.hNQ;
    ad.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", new Object[] { Integer.valueOf(localdde.HrK), Integer.valueOf(localdde.xcN.getILen()), Integer.valueOf(localdde.ihf), Float.valueOf(localdde.HrL), Integer.valueOf(localdde.FYc), Integer.valueOf(localdde.Fws) });
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
    paramq = (dde)this.rr.hNK.hNQ;
    paramArrayOfByte = (ddf)this.rr.hNL.hNQ;
    ad.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramq.HrK), Integer.valueOf(paramArrayOfByte.ihf) });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.ihf == 1)) {
      this.dxG = true;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.g
 * JD-Core Version:    0.7.0.1
 */