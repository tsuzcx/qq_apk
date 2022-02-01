package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.protocal.protobuf.etu;
import com.tencent.mm.protocal.protobuf.etv;

public final class f
  extends n<etu, etv>
{
  String TAG;
  
  public f(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(115234);
    this.TAG = "MicroMsg.NetSceneVoipHeartBeat";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new etu();
    ((d.a)localObject).iLO = new etv();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voipheartbeat";
    ((d.a)localObject).funcId = 178;
    ((d.a)localObject).iLP = 81;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (etu)this.rr.iLK.iLR;
    ((etu)localObject).LsZ = paramInt1;
    ((etu)localObject).Lta = paramLong;
    ((etu)localObject).NpN = System.currentTimeMillis();
    ((etu)localObject).NqU = paramInt2;
    AppMethodBeat.o(115234);
  }
  
  public final i fIF()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.f
 * JD-Core Version:    0.7.0.1
 */