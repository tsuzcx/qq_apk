package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dxs;
import com.tencent.mm.protocal.protobuf.dxt;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends n<dxs, dxt>
{
  public d(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte, int paramInt7)
  {
    AppMethodBeat.i(115226);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dxs();
    ((b.a)localObject).hNN = new dxt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipDoubleLinkSwitch";
    ((b.a)localObject).funcId = 249;
    ((b.a)localObject).hNO = 249;
    ((b.a)localObject).respCmdId = 1000000249;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dxs)this.rr.hNK.hNQ;
    ((dxs)localObject).GeI = paramInt1;
    ((dxs)localObject).GeJ = paramLong;
    ((dxs)localObject).Hgi = paramInt2;
    ((dxs)localObject).HKg = paramInt3;
    ((dxs)localObject).HKh = paramInt4;
    ((dxs)localObject).HKi = paramInt5;
    ((dxs)localObject).HKj = paramInt6;
    ((dxs)localObject).HKk = 1;
    ((dxs)localObject).FAN = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte, 0, paramInt7);
    AppMethodBeat.o(115226);
  }
  
  public final com.tencent.mm.al.f eyd()
  {
    AppMethodBeat.i(115228);
    com.tencent.mm.al.f local1 = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(115225);
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.DoubleLinkSwitch", "double link switch response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + d.this.Cbq.mStatus);
        if (paramAnonymousInt2 != 0)
        {
          com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.DoubleLinkSwitch", " double link switch  response with error code:".concat(String.valueOf(paramAnonymousInt2)));
          AppMethodBeat.o(115225);
          return;
        }
        paramAnonymousString = (dxt)d.this.eyh();
        d.this.Cbq.Cav = paramAnonymousString.GWO;
        if (d.this.Cbq.Cav == 0)
        {
          AppMethodBeat.o(115225);
          return;
        }
        if (d.this.Cbq.CaI.doubleLinkSwitch(paramAnonymousString.HKl) == 0)
        {
          if (1 != paramAnonymousString.HKl) {
            break label311;
          }
          paramAnonymousn = d.this.Cbq.CaI;
          paramAnonymousn.Cgs += 1;
        }
        for (;;)
        {
          com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.DoubleLinkSwitch", "zhengxue[DOUBLELINK]room " + paramAnonymousString.GeI + " member " + paramAnonymousString.Hgi + " key " + paramAnonymousString.GeJ + "report flag " + paramAnonymousString.GWO + "switch to link type " + paramAnonymousString.HKl + "doubleLinkSwitchReportStatus " + d.this.Cbq.Cav + "mDoubleLinkSwitchSucToDirectCnt" + d.this.Cbq.CaI.Cgs + "mDoubleLinkSwitchSucToRelayCnt" + d.this.Cbq.CaI.Cgt);
          AppMethodBeat.o(115225);
          return;
          label311:
          if (2 == paramAnonymousString.HKl)
          {
            paramAnonymousn = d.this.Cbq.CaI;
            paramAnonymousn.Cgt += 1;
          }
        }
      }
    };
    AppMethodBeat.o(115228);
    return local1;
  }
  
  public final int getType()
  {
    return 249;
  }
  
  public final void it(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115227);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      dxt localdxt = (dxt)eyh();
      if (localdxt != null) {
        ad.i("MicroMsg.Voip.DoubleLinkSwitch", "roomId:%d, roomKey:%s, member:%d", new Object[] { Integer.valueOf(localdxt.GeI), Long.valueOf(localdxt.GeJ), Integer.valueOf(localdxt.Hgi) });
      }
      AppMethodBeat.o(115227);
      return;
    }
    ad.i("MicroMsg.Voip.DoubleLinkSwitch", "double link switch error");
    AppMethodBeat.o(115227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.d
 * JD-Core Version:    0.7.0.1
 */