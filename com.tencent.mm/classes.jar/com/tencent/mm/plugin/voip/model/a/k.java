package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.dhv;
import com.tencent.mm.protocal.protobuf.dys;
import com.tencent.mm.protocal.protobuf.dyt;

public final class k
  extends n<dys, dyt>
{
  public k(dhv paramdhv)
  {
    AppMethodBeat.i(115250);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dys();
    ((b.a)localObject).hNN = new dyt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipspeedtest";
    ((b.a)localObject).funcId = 765;
    ((b.a)localObject).hNO = 765;
    ((b.a)localObject).respCmdId = 1000000765;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dys)this.rr.hNK.hNQ;
    ((dys)localObject).GeI = paramdhv.GeI;
    ((dys)localObject).Hwq = paramdhv.Hwq;
    ((dys)localObject).FYc = paramdhv.FYc;
    ((dys)localObject).Hwr = paramdhv.Hwr;
    ((dys)localObject).Hws = paramdhv.Hws;
    ((dys)localObject).Hwt = paramdhv.Hwt;
    ((dys)localObject).Hwu = paramdhv.Hwu;
    ((dys)localObject).Hwv = paramdhv.Hwv;
    ((dys)localObject).Hww = paramdhv.Hww;
    ((dys)localObject).Hwx = paramdhv.Hwx;
    ((dys)localObject).Hwy = paramdhv.Hwy;
    ((dys)localObject).Hwz = paramdhv.Hwz;
    ((dys)localObject).HwA = paramdhv.HwA;
    AppMethodBeat.o(115250);
  }
  
  public final com.tencent.mm.al.f eyd()
  {
    AppMethodBeat.i(115251);
    com.tencent.mm.al.f local1 = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(115249);
        com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.NetSceneVoipSpeedTest", "onSceneEnd type:" + paramAnonymousn.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
        try
        {
          paramAnonymousString = (dyt)k.this.eyh();
          if ((paramAnonymousString.HMf == 0) || (paramAnonymousString.HMg == 0))
          {
            com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, svrCount = " + paramAnonymousString.HMg);
            AppMethodBeat.o(115249);
            return;
          }
          if (k.this.Cbq.Can != 1)
          {
            com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, for mSpeedTestStatus = " + k.this.Cbq.Can);
            AppMethodBeat.o(115249);
            return;
          }
          k.this.Cbq.Can = 2;
          k.this.Cbq.Cap = paramAnonymousString.HMb;
          k.this.Cbq.CaI.a(paramAnonymousString);
          AppMethodBeat.o(115249);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          k.this.Cbq.Can = 0;
          AppMethodBeat.o(115249);
        }
      }
    };
    AppMethodBeat.o(115251);
    return local1;
  }
  
  public final int getType()
  {
    return 765;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.k
 * JD-Core Version:    0.7.0.1
 */