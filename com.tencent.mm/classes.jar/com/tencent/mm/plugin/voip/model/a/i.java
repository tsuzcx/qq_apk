package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dyo;
import com.tencent.mm.protocal.protobuf.dyp;
import com.tencent.mm.protocal.protobuf.dyu;

public final class i
  extends n<dyo, dyp>
{
  String TAG;
  
  public i(int paramInt, long paramLong, String paramString)
  {
    AppMethodBeat.i(115244);
    this.TAG = "MicroMsg.NetSceneVoipShutDown";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dyo();
    ((b.a)localObject).hNN = new dyp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipshutdown";
    ((b.a)localObject).funcId = 173;
    ((b.a)localObject).hNO = 66;
    ((b.a)localObject).respCmdId = 1000000066;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dyo)this.rr.hNK.hNQ;
    ((dyo)localObject).GeI = paramInt;
    ((dyo)localObject).GeJ = paramLong;
    dyu localdyu = new dyu();
    cwt localcwt = new cwt();
    localcwt.aPy(paramString);
    localdyu.HAz = localcwt;
    ((dyo)localObject).HKc = localdyu;
    ((dyo)localObject).HJh = System.currentTimeMillis();
    AppMethodBeat.o(115244);
  }
  
  public final com.tencent.mm.al.f eyd()
  {
    AppMethodBeat.i(115245);
    com.tencent.mm.al.f local1 = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(115243);
        com.tencent.mm.plugin.voip.b.f.Logd(i.this.TAG, "onSceneEnd type:" + paramAnonymousn.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.i
 * JD-Core Version:    0.7.0.1
 */