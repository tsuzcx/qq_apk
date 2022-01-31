package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.protocal.protobuf.csr;

public final class f
  extends n<csq, csr>
{
  String TAG;
  
  public f(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(4714);
    this.TAG = "MicroMsg.NetSceneVoipHeartBeat";
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new csq();
    ((b.a)localObject).fsY = new csr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipheartbeat";
    ((b.a)localObject).funcId = 178;
    ((b.a)localObject).reqCmdId = 81;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (csq)this.rr.fsV.fta;
    ((csq)localObject).wQP = paramInt1;
    ((csq)localObject).wQQ = paramLong;
    ((csq)localObject).yab = System.currentTimeMillis();
    ((csq)localObject).ybh = paramInt2;
    AppMethodBeat.o(4714);
  }
  
  public final com.tencent.mm.ai.f cOp()
  {
    AppMethodBeat.i(4715);
    f.1 local1 = new f.1(this);
    AppMethodBeat.o(4715);
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