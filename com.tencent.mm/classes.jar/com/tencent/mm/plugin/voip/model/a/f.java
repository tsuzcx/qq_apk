package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.protocal.protobuf.dxw;
import com.tencent.mm.protocal.protobuf.dxx;

public final class f
  extends n<dxw, dxx>
{
  String TAG;
  
  public f(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(115234);
    this.TAG = "MicroMsg.NetSceneVoipHeartBeat";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dxw();
    ((b.a)localObject).hNN = new dxx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipheartbeat";
    ((b.a)localObject).funcId = 178;
    ((b.a)localObject).hNO = 81;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dxw)this.rr.hNK.hNQ;
    ((dxw)localObject).GeI = paramInt1;
    ((dxw)localObject).GeJ = paramLong;
    ((dxw)localObject).HJh = System.currentTimeMillis();
    ((dxw)localObject).HKo = paramInt2;
    AppMethodBeat.o(115234);
  }
  
  public final com.tencent.mm.al.f eyd()
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