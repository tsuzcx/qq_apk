package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.eum;
import com.tencent.mm.protocal.protobuf.eun;
import com.tencent.mm.protocal.protobuf.eus;

public final class i
  extends n<eum, eun>
{
  String TAG;
  
  public i(int paramInt, long paramLong, String paramString)
  {
    AppMethodBeat.i(115244);
    this.TAG = "MicroMsg.NetSceneVoipShutDown";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new eum();
    ((d.a)localObject).iLO = new eun();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voipshutdown";
    ((d.a)localObject).funcId = 173;
    ((d.a)localObject).iLP = 66;
    ((d.a)localObject).respCmdId = 1000000066;
    this.rr = ((d.a)localObject).aXF();
    localObject = (eum)this.rr.iLK.iLR;
    ((eum)localObject).LsZ = paramInt;
    ((eum)localObject).Lta = paramLong;
    eus localeus = new eus();
    dqi localdqi = new dqi();
    localdqi.bhy(paramString);
    localeus.NgE = localdqi;
    ((eum)localObject).NqI = localeus;
    ((eum)localObject).NpN = System.currentTimeMillis();
    AppMethodBeat.o(115244);
  }
  
  public final com.tencent.mm.ak.i fIF()
  {
    AppMethodBeat.i(115245);
    com.tencent.mm.ak.i local1 = new com.tencent.mm.ak.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(115243);
        e.Logd(i.this.TAG, "onSceneEnd type:" + paramAnonymousq.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
        AppMethodBeat.o(115243);
      }
    };
    AppMethodBeat.o(115245);
    return local1;
  }
  
  public final int getType()
  {
    return 173;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.i
 * JD-Core Version:    0.7.0.1
 */