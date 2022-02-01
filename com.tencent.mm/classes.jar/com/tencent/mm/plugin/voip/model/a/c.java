package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.gah;
import com.tencent.mm.protocal.protobuf.gai;
import com.tencent.mm.protocal.protobuf.gbp;

public final class c
  extends n<gah, gai>
{
  public c(int paramInt1, long paramLong, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(115222);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new gah();
    ((c.a)localObject).otF = new gai();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/voipcancelinvite";
    ((c.a)localObject).funcId = 171;
    ((c.a)localObject).otG = 64;
    ((c.a)localObject).respCmdId = 1000000064;
    this.rr = ((c.a)localObject).bEF();
    localObject = (gah)c.b.b(this.rr.otB);
    ((gah)localObject).Zvz = paramInt1;
    ((gah)localObject).ZvA = paramLong;
    ((gah)localObject).IMg = paramString1;
    ((gah)localObject).abmP = paramInt2;
    paramString1 = new gbp();
    etl localetl = new etl();
    localetl.btH(paramString2);
    paramString1.abMp = localetl;
    ((gah)localObject).abXP = paramString1;
    ((gah)localObject).abWT = System.currentTimeMillis();
    ((gah)localObject).abXR = paramInt3;
    AppMethodBeat.o(115222);
  }
  
  public final int getType()
  {
    return 171;
  }
  
  public final h hYT()
  {
    AppMethodBeat.i(115224);
    h local1 = new h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(115221);
        g.Logd("MicroMsg.NetSceneVoipCancelInvite", "onSceneEnd type:" + paramAnonymousp.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
        AppMethodBeat.o(115221);
      }
    };
    AppMethodBeat.o(115224);
    return local1;
  }
  
  public final int hYU()
  {
    AppMethodBeat.i(115223);
    gah localgah = (gah)hYY();
    if ((localgah.Zvz == 0) && (localgah.abmP == 0))
    {
      AppMethodBeat.o(115223);
      return -1;
    }
    AppMethodBeat.o(115223);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.c
 * JD-Core Version:    0.7.0.1
 */