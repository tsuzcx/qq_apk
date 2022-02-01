package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dxm;
import com.tencent.mm.protocal.protobuf.dxn;
import com.tencent.mm.protocal.protobuf.dyu;

public final class c
  extends n<dxm, dxn>
{
  public c(int paramInt1, long paramLong, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(115222);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dxm();
    ((b.a)localObject).hNN = new dxn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipcancelinvite";
    ((b.a)localObject).funcId = 171;
    ((b.a)localObject).hNO = 64;
    ((b.a)localObject).respCmdId = 1000000064;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dxm)this.rr.hNK.hNQ;
    ((dxm)localObject).GeI = paramInt1;
    ((dxm)localObject).GeJ = paramLong;
    ((dxm)localObject).uki = paramString1;
    ((dxm)localObject).HfX = paramInt2;
    paramString1 = new dyu();
    cwt localcwt = new cwt();
    localcwt.aPy(paramString2);
    paramString1.HAz = localcwt;
    ((dxm)localObject).HKc = paramString1;
    ((dxm)localObject).HJh = System.currentTimeMillis();
    ((dxm)localObject).HKe = paramInt3;
    AppMethodBeat.o(115222);
  }
  
  public final com.tencent.mm.al.f eyd()
  {
    AppMethodBeat.i(115224);
    com.tencent.mm.al.f local1 = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(115221);
        com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.NetSceneVoipCancelInvite", "onSceneEnd type:" + paramAnonymousn.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
        AppMethodBeat.o(115221);
      }
    };
    AppMethodBeat.o(115224);
    return local1;
  }
  
  public final int eye()
  {
    AppMethodBeat.i(115223);
    dxm localdxm = (dxm)eyi();
    if ((localdxm.GeI == 0) && (localdxm.HfX == 0))
    {
      AppMethodBeat.o(115223);
      return -1;
    }
    AppMethodBeat.o(115223);
    return 0;
  }
  
  public final int getType()
  {
    return 171;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.c
 * JD-Core Version:    0.7.0.1
 */