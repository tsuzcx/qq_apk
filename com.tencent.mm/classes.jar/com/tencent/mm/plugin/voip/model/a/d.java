package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.dzk;
import com.tencent.mm.sdk.platformtools.ae;

public final class d
  extends n<dzj, dzk>
{
  public d(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte, int paramInt7)
  {
    AppMethodBeat.i(115226);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dzj();
    ((b.a)localObject).hQG = new dzk();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipDoubleLinkSwitch";
    ((b.a)localObject).funcId = 249;
    ((b.a)localObject).hQH = 249;
    ((b.a)localObject).respCmdId = 1000000249;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dzj)this.rr.hQD.hQJ;
    ((dzj)localObject).Gxq = paramInt1;
    ((dzj)localObject).Gxr = paramLong;
    ((dzj)localObject).HzI = paramInt2;
    ((dzj)localObject).Ieo = paramInt3;
    ((dzj)localObject).Iep = paramInt4;
    ((dzj)localObject).Ieq = paramInt5;
    ((dzj)localObject).Ier = paramInt6;
    ((dzj)localObject).Ies = 1;
    ((dzj)localObject).FTj = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte, 0, paramInt7);
    AppMethodBeat.o(115226);
  }
  
  public final com.tencent.mm.ak.f eBL()
  {
    AppMethodBeat.i(115228);
    com.tencent.mm.ak.f local1 = new com.tencent.mm.ak.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(115225);
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.DoubleLinkSwitch", "double link switch response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + d.this.CsR.mStatus);
        if (paramAnonymousInt2 != 0)
        {
          com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.DoubleLinkSwitch", " double link switch  response with error code:".concat(String.valueOf(paramAnonymousInt2)));
          AppMethodBeat.o(115225);
          return;
        }
        paramAnonymousString = (dzk)d.this.eBP();
        d.this.CsR.CrW = paramAnonymousString.Hqo;
        if (d.this.CsR.CrW == 0)
        {
          AppMethodBeat.o(115225);
          return;
        }
        if (d.this.CsR.Csj.doubleLinkSwitch(paramAnonymousString.Iet) == 0)
        {
          if (1 != paramAnonymousString.Iet) {
            break label311;
          }
          paramAnonymousn = d.this.CsR.Csj;
          paramAnonymousn.CxT += 1;
        }
        for (;;)
        {
          com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.DoubleLinkSwitch", "zhengxue[DOUBLELINK]room " + paramAnonymousString.Gxq + " member " + paramAnonymousString.HzI + " key " + paramAnonymousString.Gxr + "report flag " + paramAnonymousString.Hqo + "switch to link type " + paramAnonymousString.Iet + "doubleLinkSwitchReportStatus " + d.this.CsR.CrW + "mDoubleLinkSwitchSucToDirectCnt" + d.this.CsR.Csj.CxT + "mDoubleLinkSwitchSucToRelayCnt" + d.this.CsR.Csj.CxU);
          AppMethodBeat.o(115225);
          return;
          label311:
          if (2 == paramAnonymousString.Iet)
          {
            paramAnonymousn = d.this.CsR.Csj;
            paramAnonymousn.CxU += 1;
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
  
  public final void ix(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115227);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      dzk localdzk = (dzk)eBP();
      if (localdzk != null) {
        ae.i("MicroMsg.Voip.DoubleLinkSwitch", "roomId:%d, roomKey:%s, member:%d", new Object[] { Integer.valueOf(localdzk.Gxq), Long.valueOf(localdzk.Gxr), Integer.valueOf(localdzk.HzI) });
      }
      AppMethodBeat.o(115227);
      return;
    }
    ae.i("MicroMsg.Voip.DoubleLinkSwitch", "double link switch error");
    AppMethodBeat.o(115227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.d
 * JD-Core Version:    0.7.0.1
 */