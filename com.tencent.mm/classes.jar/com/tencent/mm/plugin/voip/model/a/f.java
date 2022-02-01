package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.protocal.protobuf.gar;
import com.tencent.mm.protocal.protobuf.gas;

public final class f
  extends n<gar, gas>
{
  private String TAG;
  
  public f(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(115234);
    this.TAG = "MicroMsg.NetSceneVoipHeartBeat";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new gar();
    ((c.a)localObject).otF = new gas();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/voipheartbeat";
    ((c.a)localObject).funcId = 178;
    ((c.a)localObject).otG = 81;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (gar)c.b.b(this.rr.otB);
    ((gar)localObject).Zvz = paramInt1;
    ((gar)localObject).ZvA = paramLong;
    ((gar)localObject).abWT = System.currentTimeMillis();
    ((gar)localObject).abYb = paramInt2;
    AppMethodBeat.o(115234);
  }
  
  public final int getType()
  {
    return 178;
  }
  
  public final h hYT()
  {
    AppMethodBeat.i(115235);
    f.1 local1 = new f.1(this);
    AppMethodBeat.o(115235);
    return local1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.f
 * JD-Core Version:    0.7.0.1
 */