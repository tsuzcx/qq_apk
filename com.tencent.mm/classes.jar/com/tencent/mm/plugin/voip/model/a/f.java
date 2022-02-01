package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.dsc;
import com.tencent.mm.protocal.protobuf.dsd;

public final class f
  extends n<dsc, dsd>
{
  String TAG;
  
  public f(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(115234);
    this.TAG = "MicroMsg.NetSceneVoipHeartBeat";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dsc();
    ((b.a)localObject).hvu = new dsd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipheartbeat";
    ((b.a)localObject).funcId = 178;
    ((b.a)localObject).reqCmdId = 81;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dsc)this.rr.hvr.hvw;
    ((dsc)localObject).Exf = paramInt1;
    ((dsc)localObject).Exg = paramLong;
    ((dsc)localObject).FYl = System.currentTimeMillis();
    ((dsc)localObject).FZs = paramInt2;
    AppMethodBeat.o(115234);
  }
  
  public final g eks()
  {
    AppMethodBeat.i(115235);
    g local1 = new g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(115233);
        if ((paramAnonymousInt1 != 0) && (paramAnonymousInt2 == 231))
        {
          d.Loge(f.this.TAG, "Voip heartbeat Failed, type:" + paramAnonymousn.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
          f.this.ACr.ABJ.AIf.ACR = 111;
          f.this.ACr.ABJ.AIf.ACS = paramAnonymousInt2;
          f.this.ACr.ABJ.AIf.ADj = 2;
          f.this.ACr.H(1, -9004, "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.f
 * JD-Core Version:    0.7.0.1
 */