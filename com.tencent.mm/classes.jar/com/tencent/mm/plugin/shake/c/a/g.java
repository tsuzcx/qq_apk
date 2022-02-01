package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.aw.e;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.ah;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.faz;
import com.tencent.mm.protocal.protobuf.fba;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class g
  extends f
{
  private h callback;
  private final com.tencent.mm.am.c rr;
  
  public g(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    super(paramLong);
    AppMethodBeat.i(28283);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new faz();
    ((c.a)localObject).otF = new fba();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/shakemusic";
    ((c.a)localObject).funcId = 367;
    ((c.a)localObject).otG = 177;
    ((c.a)localObject).respCmdId = 1000000177;
    this.rr = ((c.a)localObject).bEF();
    localObject = (faz)c.b.b(this.rr.otB);
    ((faz)localObject).NkQ = new gol().df(paramArrayOfByte);
    ((faz)localObject).abAV = paramInt2;
    if (paramBoolean)
    {
      paramInt2 = 1;
      ((faz)localObject).oOu = paramInt2;
      ((faz)localObject).abAW = paramInt1;
      if (!ah.eb(MMApplicationContext.getContext())) {
        break label372;
      }
    }
    label372:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      ((faz)localObject).ZkT = paramInt1;
      ((faz)localObject).YHj = paramInt3;
      float f3 = 0.0F;
      float f4 = 0.0F;
      float f2 = f4;
      float f1 = f3;
      try
      {
        bh.bCz();
        f2 = f4;
        f1 = f3;
        f3 = Util.getFloat((String)com.tencent.mm.model.c.ban().get(at.a.acJf, null), 0.0F);
        f2 = f4;
        f1 = f3;
        bh.bCz();
        f2 = f4;
        f1 = f3;
        f4 = Util.getFloat((String)com.tencent.mm.model.c.ban().get(at.a.acJg, null), 0.0F);
        f2 = f4;
        f1 = f3;
        bh.bCz();
        f2 = f4;
        f1 = f3;
        paramInt1 = Util.safeParseInt((String)com.tencent.mm.model.c.ban().get(at.a.acLM, null));
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
      ((faz)localObject).ZaH = f1;
      ((faz)localObject).abAX = f2;
      if (!e.bLu()) {
        break label383;
      }
      paramInt2 = 0;
      ((faz)localObject).aawO = paramInt2;
      if (!e.bLt()) {
        break label389;
      }
      paramInt2 = 1;
      ((faz)localObject).aawP = paramInt2;
      n.a(2014, ((faz)localObject).abAX, ((faz)localObject).ZaH, paramInt1);
      AppMethodBeat.o(28283);
      return;
      paramInt2 = 0;
      break;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(28284);
    faz localfaz = (faz)c.b.b(this.rr.otB);
    Log.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", new Object[] { Integer.valueOf(localfaz.abAV), Integer.valueOf(localfaz.NkQ.abwJ), Integer.valueOf(localfaz.oOu), Float.valueOf(localfaz.abAW), Integer.valueOf(localfaz.ZkT), Integer.valueOf(localfaz.YHj) });
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(28284);
    return i;
  }
  
  public final esc gXF()
  {
    AppMethodBeat.i(273614);
    fba localfba = (fba)c.c.b(this.rr.otC);
    AppMethodBeat.o(273614);
    return localfba;
  }
  
  public final int getType()
  {
    return 367;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28285);
    params = (faz)c.b.b(this.rr.otB);
    paramArrayOfByte = (fba)c.c.b(this.rr.otC);
    Log.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(params.abAV), Integer.valueOf(paramArrayOfByte.oOu) });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.oOu == 1)) {
      this.hPw = true;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.g
 * JD-Core Version:    0.7.0.1
 */