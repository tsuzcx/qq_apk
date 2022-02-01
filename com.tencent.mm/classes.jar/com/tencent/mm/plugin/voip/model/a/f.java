package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmm;

public final class f
  extends n<dml, dmm>
{
  String TAG;
  
  public f(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(115234);
    this.TAG = "MicroMsg.NetSceneVoipHeartBeat";
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new dml();
    ((b.a)localObject).gUV = new dmm();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipheartbeat";
    ((b.a)localObject).funcId = 178;
    ((b.a)localObject).reqCmdId = 81;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (dml)this.rr.gUS.gUX;
    ((dml)localObject).DdZ = paramInt1;
    ((dml)localObject).Dea = paramLong;
    ((dml)localObject).EAY = System.currentTimeMillis();
    ((dml)localObject).ECf = paramInt2;
    AppMethodBeat.o(115234);
  }
  
  public final g dVg()
  {
    AppMethodBeat.i(115235);
    g local1 = new g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(115233);
        if ((paramAnonymousInt1 != 0) && (paramAnonymousInt2 == 231))
        {
          c.Loge(f.this.TAG, "Voip heartbeat Failed, type:" + paramAnonymousn.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
          f.this.zjH.ziZ.zpq.zkh = 111;
          f.this.zjH.ziZ.zpq.zki = paramAnonymousInt2;
          f.this.zjH.ziZ.zpq.zkz = 2;
          f.this.zjH.I(1, -9004, "");
          AppMethodBeat.o(115233);
          return;
        }
        AppMethodBeat.o(115233);
      }
    };
    AppMethodBeat.o(115235);
    return local1;
  }
  
  public final int getType()
  {
    return 178;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.f
 * JD-Core Version:    0.7.0.1
 */