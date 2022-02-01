package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.voip.c.e;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.fef;
import com.tencent.mm.protocal.protobuf.feg;

public final class f
  extends n<fef, feg>
{
  private String TAG;
  
  public f(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(115234);
    this.TAG = "MicroMsg.NetSceneVoipHeartBeat";
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new fef();
    ((d.a)localObject).lBV = new feg();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voipheartbeat";
    ((d.a)localObject).funcId = 178;
    ((d.a)localObject).lBW = 81;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (fef)d.b.b(this.rr.lBR);
    ((fef)localObject).Svu = paramInt1;
    ((fef)localObject).Svv = paramLong;
    ((fef)localObject).UCJ = System.currentTimeMillis();
    ((fef)localObject).UDQ = paramInt2;
    AppMethodBeat.o(115234);
  }
  
  public final i gAU()
  {
    AppMethodBeat.i(115235);
    i local1 = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(115233);
        if ((paramAnonymousInt1 != 0) && (paramAnonymousInt2 == 231))
        {
          e.Loge(f.a(f.this), "Voip heartbeat Failed, type:" + paramAnonymousq.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
          f.this.NMN.NMi.NSI.NNq = 111;
          f.this.NMN.NMi.NSI.NNr = paramAnonymousInt2;
          f.this.NMN.NMi.NSI.NNI = 2;
          f.this.NMN.J(1, -9004, "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.f
 * JD-Core Version:    0.7.0.1
 */