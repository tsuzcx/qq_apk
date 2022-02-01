package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.etq;
import com.tencent.mm.protocal.protobuf.etr;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends n<etq, etr>
{
  public d(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte, int paramInt7)
  {
    AppMethodBeat.i(115226);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new etq();
    ((d.a)localObject).iLO = new etr();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voipDoubleLinkSwitch";
    ((d.a)localObject).funcId = 249;
    ((d.a)localObject).iLP = 249;
    ((d.a)localObject).respCmdId = 1000000249;
    this.rr = ((d.a)localObject).aXF();
    localObject = (etq)this.rr.iLK.iLR;
    ((etq)localObject).LsZ = paramInt1;
    ((etq)localObject).Lta = paramLong;
    ((etq)localObject).MKr = paramInt2;
    ((etq)localObject).NqM = paramInt3;
    ((etq)localObject).NqN = paramInt4;
    ((etq)localObject).NqO = paramInt5;
    ((etq)localObject).NqP = paramInt6;
    ((etq)localObject).NqQ = 1;
    ((etq)localObject).KMS = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte, 0, paramInt7);
    AppMethodBeat.o(115226);
  }
  
  public final i fIF()
  {
    AppMethodBeat.i(115228);
    i local1 = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(115225);
        e.Logi("MicroMsg.Voip.DoubleLinkSwitch", "double link switch response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + d.this.GWA.mStatus);
        if (paramAnonymousInt2 != 0)
        {
          e.Loge("MicroMsg.Voip.DoubleLinkSwitch", " double link switch  response with error code:".concat(String.valueOf(paramAnonymousInt2)));
          AppMethodBeat.o(115225);
          return;
        }
        paramAnonymousString = (etr)d.this.fIJ();
        d.this.GWA.GVI = paramAnonymousString.MyU;
        if (d.this.GWA.GVI == 0)
        {
          AppMethodBeat.o(115225);
          return;
        }
        if (d.this.GWA.GVV.doubleLinkSwitch(paramAnonymousString.NqR) == 0)
        {
          if (1 != paramAnonymousString.NqR) {
            break label311;
          }
          paramAnonymousq = d.this.GWA.GVV;
          paramAnonymousq.HbH += 1;
        }
        for (;;)
        {
          e.Logi("MicroMsg.Voip.DoubleLinkSwitch", "zhengxue[DOUBLELINK]room " + paramAnonymousString.LsZ + " member " + paramAnonymousString.MKr + " key " + paramAnonymousString.Lta + "report flag " + paramAnonymousString.MyU + "switch to link type " + paramAnonymousString.NqR + "doubleLinkSwitchReportStatus " + d.this.GWA.GVI + "mDoubleLinkSwitchSucToDirectCnt" + d.this.GWA.GVV.HbH + "mDoubleLinkSwitchSucToRelayCnt" + d.this.GWA.GVV.HbI);
          AppMethodBeat.o(115225);
          return;
          label311:
          if (2 == paramAnonymousString.NqR)
          {
            paramAnonymousq = d.this.GWA.GVV;
            paramAnonymousq.HbI += 1;
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
  
  public final void jC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115227);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      etr localetr = (etr)fIJ();
      if (localetr != null) {
        Log.i("MicroMsg.Voip.DoubleLinkSwitch", "roomId:%d, roomKey:%s, member:%d", new Object[] { Integer.valueOf(localetr.LsZ), Long.valueOf(localetr.Lta), Integer.valueOf(localetr.MKr) });
      }
      AppMethodBeat.o(115227);
      return;
    }
    Log.i("MicroMsg.Voip.DoubleLinkSwitch", "double link switch error");
    AppMethodBeat.o(115227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.d
 * JD-Core Version:    0.7.0.1
 */