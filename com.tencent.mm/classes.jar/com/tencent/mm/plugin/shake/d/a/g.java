package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.ag;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dxc;
import com.tencent.mm.protocal.protobuf.dxd;
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
    ((d.a)localObject).iLN = new dxc();
    ((d.a)localObject).iLO = new dxd();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/shaketv";
    ((d.a)localObject).funcId = 408;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dxc)this.rr.iLK.iLR;
    ((dxc)localObject).BsI = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ((dxc)localObject).MWV = paramInt2;
    if (paramBoolean) {
      paramInt2 = 1;
    }
    for (;;)
    {
      ((dxc)localObject).jeU = paramInt2;
      ((dxc)localObject).MWW = paramInt1;
      if (ag.dm(MMApplicationContext.getContext()))
      {
        paramInt1 = j;
        label158:
        ((dxc)localObject).Llx = paramInt1;
        ((dxc)localObject).KIy = paramInt3;
      }
      try
      {
        bg.aVF();
        f2 = Util.getFloat((String)c.azQ().get(ar.a.NTL, null), 0.0F);
      }
      catch (Exception paramArrayOfByte)
      {
        try
        {
          bg.aVF();
          f1 = Util.getFloat((String)c.azQ().get(ar.a.NTM, null), 0.0F);
        }
        catch (Exception paramArrayOfByte)
        {
          try
          {
            float f2;
            float f1;
            bg.aVF();
            paramInt1 = Util.safeParseInt((String)c.azQ().get(ar.a.NWs, null));
            for (;;)
            {
              ((dxc)localObject).LbD = f2;
              ((dxc)localObject).MWX = f1;
              o.a(2009, ((dxc)localObject).MWX, ((dxc)localObject).LbD, paramInt1);
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
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(28287);
    dxc localdxc = (dxc)this.rr.iLK.iLR;
    Log.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", new Object[] { Integer.valueOf(localdxc.MWV), Integer.valueOf(localdxc.BsI.getILen()), Integer.valueOf(localdxc.jeU), Float.valueOf(localdxc.MWW), Integer.valueOf(localdxc.Llx), Integer.valueOf(localdxc.KIy) });
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(28287);
    return i;
  }
  
  public final dpc eUP()
  {
    return (dxd)this.rr.iLL.iLR;
  }
  
  public final int getType()
  {
    return 408;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28288);
    params = (dxc)this.rr.iLK.iLR;
    paramArrayOfByte = (dxd)this.rr.iLL.iLR;
    Log.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(params.MWV), Integer.valueOf(paramArrayOfByte.jeU) });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.jeU == 1)) {
      this.dQA = true;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.g
 * JD-Core Version:    0.7.0.1
 */