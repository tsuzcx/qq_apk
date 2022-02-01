package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.ae;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.protocal.protobuf.csi;
import com.tencent.mm.protocal.protobuf.csj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class g
  extends e
{
  private com.tencent.mm.al.g callback;
  private final b rr;
  
  public g(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    super(paramLong);
    AppMethodBeat.i(28286);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new csi();
    ((b.a)localObject).gUV = new csj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/shaketv";
    ((b.a)localObject).funcId = 408;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (csi)this.rr.gUS.gUX;
    ((csi)localObject).uKT = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ((csi)localObject).Eke = paramInt2;
    if (paramBoolean) {
      paramInt2 = 1;
    }
    for (;;)
    {
      ((csi)localObject).hno = paramInt2;
      ((csi)localObject).Ekf = paramInt1;
      if (ae.cJ(aj.getContext()))
      {
        paramInt1 = j;
        label158:
        ((csi)localObject).CYi = paramInt1;
        ((csi)localObject).CyE = paramInt3;
      }
      try
      {
        az.arV();
        f2 = bt.getFloat((String)c.afk().get(ae.a.Fhg, null), 0.0F);
      }
      catch (Exception paramArrayOfByte)
      {
        try
        {
          az.arV();
          f1 = bt.getFloat((String)c.afk().get(ae.a.Fhh, null), 0.0F);
        }
        catch (Exception paramArrayOfByte)
        {
          try
          {
            float f2;
            float f1;
            az.arV();
            paramInt1 = bt.aGh((String)c.afk().get(ae.a.FjM, null));
            for (;;)
            {
              ((csi)localObject).COJ = f2;
              ((csi)localObject).Ekg = f1;
              o.a(2009, ((csi)localObject).Ekg, ((csi)localObject).COJ, paramInt1);
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
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(28287);
    csi localcsi = (csi)this.rr.gUS.gUX;
    ad.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", new Object[] { Integer.valueOf(localcsi.Eke), Integer.valueOf(localcsi.uKT.getILen()), Integer.valueOf(localcsi.hno), Float.valueOf(localcsi.Ekf), Integer.valueOf(localcsi.CYi), Integer.valueOf(localcsi.CyE) });
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(28287);
    return i;
  }
  
  public final cld dpE()
  {
    return (csj)this.rr.gUT.gUX;
  }
  
  public final int getType()
  {
    return 408;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28288);
    paramq = (csi)this.rr.gUS.gUX;
    paramArrayOfByte = (csj)this.rr.gUT.gUX;
    ad.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramq.Eke), Integer.valueOf(paramArrayOfByte.hno) });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.hno == 1)) {
      this.doj = true;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.g
 * JD-Core Version:    0.7.0.1
 */