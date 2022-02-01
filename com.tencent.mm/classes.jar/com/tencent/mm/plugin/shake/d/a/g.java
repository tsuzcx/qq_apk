package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.ag;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.ehd;
import com.tencent.mm.protocal.protobuf.ehe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class g
  extends e
{
  private i callback;
  private final d rr;
  
  public g(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    super(paramLong);
    AppMethodBeat.i(28286);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ehd();
    ((d.a)localObject).lBV = new ehe();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/shaketv";
    ((d.a)localObject).funcId = 408;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ehd)d.b.b(this.rr.lBR);
    ((ehd)localObject).Hnc = new eae().dc(paramArrayOfByte);
    ((ehd)localObject).Ujq = paramInt2;
    if (paramBoolean) {
      paramInt2 = 1;
    }
    for (;;)
    {
      ((ehd)localObject).lVs = paramInt2;
      ((ehd)localObject).Ujr = paramInt1;
      if (ag.dj(MMApplicationContext.getContext()))
      {
        paramInt1 = j;
        label158:
        ((ehd)localObject).SmH = paramInt1;
        ((ehd)localObject).RJP = paramInt3;
      }
      try
      {
        bh.beI();
        f2 = Util.getFloat((String)c.aHp().get(ar.a.VhL, null), 0.0F);
      }
      catch (Exception paramArrayOfByte)
      {
        try
        {
          bh.beI();
          f1 = Util.getFloat((String)c.aHp().get(ar.a.VhM, null), 0.0F);
        }
        catch (Exception paramArrayOfByte)
        {
          try
          {
            float f2;
            float f1;
            bh.beI();
            paramInt1 = Util.safeParseInt((String)c.aHp().get(ar.a.Vks, null));
            for (;;)
            {
              ((ehd)localObject).ScP = f2;
              ((ehd)localObject).Ujs = f1;
              n.a(2009, ((ehd)localObject).Ujs, ((ehd)localObject).ScP, paramInt1);
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
  
  public static int arZ()
  {
    return 408;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(28287);
    ehd localehd = (ehd)d.b.b(this.rr.lBR);
    Log.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", new Object[] { Integer.valueOf(localehd.Ujq), Integer.valueOf(localehd.Hnc.Ufv), Integer.valueOf(localehd.lVs), Float.valueOf(localehd.Ujr), Integer.valueOf(localehd.SmH), Integer.valueOf(localehd.RJP) });
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(28287);
    return i;
  }
  
  public final dyy fHQ()
  {
    AppMethodBeat.i(231493);
    ehe localehe = (ehe)d.c.b(this.rr.lBS);
    AppMethodBeat.o(231493);
    return localehe;
  }
  
  public final int getType()
  {
    return 408;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28288);
    params = (ehd)d.b.b(this.rr.lBR);
    paramArrayOfByte = (ehe)d.c.b(this.rr.lBS);
    Log.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(params.Ujq), Integer.valueOf(paramArrayOfByte.lVs) });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.lVs == 1)) {
      this.fJQ = true;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.g
 * JD-Core Version:    0.7.0.1
 */