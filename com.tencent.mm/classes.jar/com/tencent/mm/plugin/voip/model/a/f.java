package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.protocal.protobuf.dzn;
import com.tencent.mm.protocal.protobuf.dzo;

public final class f
  extends n<dzn, dzo>
{
  String TAG;
  
  public f(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(115234);
    this.TAG = "MicroMsg.NetSceneVoipHeartBeat";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dzn();
    ((b.a)localObject).hQG = new dzo();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipheartbeat";
    ((b.a)localObject).funcId = 178;
    ((b.a)localObject).hQH = 81;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dzn)this.rr.hQD.hQJ;
    ((dzn)localObject).Gxq = paramInt1;
    ((dzn)localObject).Gxr = paramLong;
    ((dzn)localObject).Idp = System.currentTimeMillis();
    ((dzn)localObject).Iew = paramInt2;
    AppMethodBeat.o(115234);
  }
  
  public final com.tencent.mm.ak.f eBL()
  {
    AppMethodBeat.i(115235);
    f.1 local1 = new f.1(this);
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