package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.dsu;
import com.tencent.mm.protocal.protobuf.dsv;
import com.tencent.mm.protocal.protobuf.dta;

public final class i
  extends n<dsu, dsv>
{
  String TAG;
  
  public i(int paramInt, long paramLong, String paramString)
  {
    AppMethodBeat.i(115244);
    this.TAG = "MicroMsg.NetSceneVoipShutDown";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dsu();
    ((b.a)localObject).hvu = new dsv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipshutdown";
    ((b.a)localObject).funcId = 173;
    ((b.a)localObject).reqCmdId = 66;
    ((b.a)localObject).respCmdId = 1000000066;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dsu)this.rr.hvr.hvw;
    ((dsu)localObject).Exf = paramInt;
    ((dsu)localObject).Exg = paramLong;
    dta localdta = new dta();
    crm localcrm = new crm();
    localcrm.aJV(paramString);
    localdta.FPU = localcrm;
    ((dsu)localObject).FZg = localdta;
    ((dsu)localObject).FYl = System.currentTimeMillis();
    AppMethodBeat.o(115244);
  }
  
  public final g eks()
  {
    AppMethodBeat.i(115245);
    g local1 = new g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(115243);
        d.Logd(i.this.TAG, "onSceneEnd type:" + paramAnonymousn.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.i
 * JD-Core Version:    0.7.0.1
 */