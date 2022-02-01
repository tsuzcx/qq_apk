package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.ah;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.fbd;
import com.tencent.mm.protocal.protobuf.fbe;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class i
  extends f
{
  private h callback;
  private final com.tencent.mm.am.c rr;
  
  public i(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    super(paramLong);
    AppMethodBeat.i(28286);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fbd();
    ((c.a)localObject).otF = new fbe();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/shaketv";
    ((c.a)localObject).funcId = 408;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fbd)c.b.b(this.rr.otB);
    ((fbd)localObject).NkQ = new gol().df(paramArrayOfByte);
    ((fbd)localObject).abAV = paramInt2;
    if (paramBoolean) {
      paramInt2 = 1;
    }
    for (;;)
    {
      ((fbd)localObject).oOu = paramInt2;
      ((fbd)localObject).abAW = paramInt1;
      if (ah.eb(MMApplicationContext.getContext()))
      {
        paramInt1 = j;
        label158:
        ((fbd)localObject).ZkT = paramInt1;
        ((fbd)localObject).YHj = paramInt3;
      }
      try
      {
        bh.bCz();
        f2 = Util.getFloat((String)com.tencent.mm.model.c.ban().get(at.a.acJf, null), 0.0F);
      }
      catch (Exception paramArrayOfByte)
      {
        try
        {
          bh.bCz();
          f1 = Util.getFloat((String)com.tencent.mm.model.c.ban().get(at.a.acJg, null), 0.0F);
        }
        catch (Exception paramArrayOfByte)
        {
          try
          {
            float f2;
            float f1;
            bh.bCz();
            paramInt1 = Util.safeParseInt((String)com.tencent.mm.model.c.ban().get(at.a.acLM, null));
            for (;;)
            {
              ((fbd)localObject).ZaH = f2;
              ((fbd)localObject).abAX = f1;
              n.a(2009, ((fbd)localObject).abAX, ((fbd)localObject).ZaH, paramInt1);
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
  
  public static int aLV()
  {
    return 408;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(28287);
    fbd localfbd = (fbd)c.b.b(this.rr.otB);
    Log.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", new Object[] { Integer.valueOf(localfbd.abAV), Integer.valueOf(localfbd.NkQ.abwJ), Integer.valueOf(localfbd.oOu), Float.valueOf(localfbd.abAW), Integer.valueOf(localfbd.ZkT), Integer.valueOf(localfbd.YHj) });
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(28287);
    return i;
  }
  
  public final esc gXF()
  {
    AppMethodBeat.i(273613);
    fbe localfbe = (fbe)c.c.b(this.rr.otC);
    AppMethodBeat.o(273613);
    return localfbe;
  }
  
  public final int getType()
  {
    return 408;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28288);
    params = (fbd)c.b.b(this.rr.otB);
    paramArrayOfByte = (fbe)c.c.b(this.rr.otC);
    Log.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(params.abAV), Integer.valueOf(paramArrayOfByte.oOu) });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.oOu == 1)) {
      this.hPw = true;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.i
 * JD-Core Version:    0.7.0.1
 */