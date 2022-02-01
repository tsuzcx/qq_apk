package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.eag;
import com.tencent.mm.protocal.protobuf.eal;

public final class i
  extends n<eaf, eag>
{
  String TAG;
  
  public i(int paramInt, long paramLong, String paramString)
  {
    AppMethodBeat.i(115244);
    this.TAG = "MicroMsg.NetSceneVoipShutDown";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new eaf();
    ((b.a)localObject).hQG = new eag();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipshutdown";
    ((b.a)localObject).funcId = 173;
    ((b.a)localObject).hQH = 66;
    ((b.a)localObject).respCmdId = 1000000066;
    this.rr = ((b.a)localObject).aDS();
    localObject = (eaf)this.rr.hQD.hQJ;
    ((eaf)localObject).Gxq = paramInt;
    ((eaf)localObject).Gxr = paramLong;
    eal localeal = new eal();
    cxn localcxn = new cxn();
    localcxn.aQV(paramString);
    localeal.HUm = localcxn;
    ((eaf)localObject).Iek = localeal;
    ((eaf)localObject).Idp = System.currentTimeMillis();
    AppMethodBeat.o(115244);
  }
  
  public final com.tencent.mm.ak.f eBL()
  {
    AppMethodBeat.i(115245);
    com.tencent.mm.ak.f local1 = new com.tencent.mm.ak.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.i
 * JD-Core Version:    0.7.0.1
 */