package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.gbj;
import com.tencent.mm.protocal.protobuf.gbk;
import com.tencent.mm.protocal.protobuf.gbp;

public final class i
  extends n<gbj, gbk>
{
  private String TAG;
  
  public i(int paramInt, long paramLong, String paramString)
  {
    AppMethodBeat.i(115244);
    this.TAG = "MicroMsg.NetSceneVoipShutDown";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new gbj();
    ((c.a)localObject).otF = new gbk();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/voipshutdown";
    ((c.a)localObject).funcId = 173;
    ((c.a)localObject).otG = 66;
    ((c.a)localObject).respCmdId = 1000000066;
    this.rr = ((c.a)localObject).bEF();
    localObject = (gbj)c.b.b(this.rr.otB);
    ((gbj)localObject).Zvz = paramInt;
    ((gbj)localObject).ZvA = paramLong;
    gbp localgbp = new gbp();
    etl localetl = new etl();
    localetl.btH(paramString);
    localgbp.abMp = localetl;
    ((gbj)localObject).abXP = localgbp;
    ((gbj)localObject).abWT = System.currentTimeMillis();
    AppMethodBeat.o(115244);
  }
  
  public final int getType()
  {
    return 173;
  }
  
  public final h hYT()
  {
    AppMethodBeat.i(115245);
    h local1 = new h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(115243);
        g.Logd(i.a(i.this), "onSceneEnd type:" + paramAnonymousp.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
        AppMethodBeat.o(115243);
      }
    };
    AppMethodBeat.o(115245);
    return local1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.i
 * JD-Core Version:    0.7.0.1
 */