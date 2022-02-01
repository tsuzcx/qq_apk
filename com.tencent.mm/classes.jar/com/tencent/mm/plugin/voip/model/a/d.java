package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dmh;
import com.tencent.mm.protocal.protobuf.dmi;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends n<dmh, dmi>
{
  public d(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte, int paramInt7)
  {
    AppMethodBeat.i(115226);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new dmh();
    ((b.a)localObject).gUV = new dmi();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipDoubleLinkSwitch";
    ((b.a)localObject).funcId = 249;
    ((b.a)localObject).reqCmdId = 249;
    ((b.a)localObject).respCmdId = 1000000249;
    this.rr = ((b.a)localObject).atI();
    localObject = (dmh)this.rr.gUS.gUX;
    ((dmh)localObject).DdZ = paramInt1;
    ((dmh)localObject).Dea = paramLong;
    ((dmh)localObject).DZg = paramInt2;
    ((dmh)localObject).EBX = paramInt3;
    ((dmh)localObject).EBY = paramInt4;
    ((dmh)localObject).EBZ = paramInt5;
    ((dmh)localObject).ECa = paramInt6;
    ((dmh)localObject).ECb = 1;
    ((dmh)localObject).CCV = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte, 0, paramInt7);
    AppMethodBeat.o(115226);
  }
  
  public final g dVg()
  {
    AppMethodBeat.i(115228);
    g local1 = new g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(115225);
        c.Logi("MicroMsg.Voip.DoubleLinkSwitch", "double link switch response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + d.this.zjH.mStatus);
        if (paramAnonymousInt2 != 0)
        {
          c.Loge("MicroMsg.Voip.DoubleLinkSwitch", " double link switch  response with error code:".concat(String.valueOf(paramAnonymousInt2)));
          AppMethodBeat.o(115225);
          return;
        }
        paramAnonymousString = (dmi)d.this.dVk();
        d.this.zjH.ziM = paramAnonymousString.DQN;
        if (d.this.zjH.ziM == 0)
        {
          AppMethodBeat.o(115225);
          return;
        }
        if (d.this.zjH.ziZ.doubleLinkSwitch(paramAnonymousString.ECc) == 0)
        {
          if (1 != paramAnonymousString.ECc) {
            break label311;
          }
          paramAnonymousn = d.this.zjH.ziZ;
          paramAnonymousn.zoC += 1;
        }
        for (;;)
        {
          c.Logi("MicroMsg.Voip.DoubleLinkSwitch", "zhengxue[DOUBLELINK]room " + paramAnonymousString.DdZ + " member " + paramAnonymousString.DZg + " key " + paramAnonymousString.Dea + "report flag " + paramAnonymousString.DQN + "switch to link type " + paramAnonymousString.ECc + "doubleLinkSwitchReportStatus " + d.this.zjH.ziM + "mDoubleLinkSwitchSucToDirectCnt" + d.this.zjH.ziZ.zoC + "mDoubleLinkSwitchSucToRelayCnt" + d.this.zjH.ziZ.zoD);
          AppMethodBeat.o(115225);
          return;
          label311:
          if (2 == paramAnonymousString.ECc)
          {
            paramAnonymousn = d.this.zjH.ziZ;
            paramAnonymousn.zoD += 1;
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
  
  public final void hR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115227);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      dmi localdmi = (dmi)dVk();
      if (localdmi != null) {
        ad.i("MicroMsg.Voip.DoubleLinkSwitch", "roomId:%d, roomKey:%s, member:%d", new Object[] { Integer.valueOf(localdmi.DdZ), Long.valueOf(localdmi.Dea), Integer.valueOf(localdmi.DZg) });
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