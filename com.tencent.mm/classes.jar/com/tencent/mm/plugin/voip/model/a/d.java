package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.voip.c.e;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.feb;
import com.tencent.mm.protocal.protobuf.fec;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends n<feb, fec>
{
  public d(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte, int paramInt7)
  {
    AppMethodBeat.i(115226);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new feb();
    ((d.a)localObject).lBV = new fec();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voipDoubleLinkSwitch";
    ((d.a)localObject).funcId = 249;
    ((d.a)localObject).lBW = 249;
    ((d.a)localObject).respCmdId = 1000000249;
    this.rr = ((d.a)localObject).bgN();
    localObject = (feb)d.b.b(this.rr.lBR);
    ((feb)localObject).Svu = paramInt1;
    ((feb)localObject).Svv = paramLong;
    ((feb)localObject).TWl = paramInt2;
    ((feb)localObject).UDI = paramInt3;
    ((feb)localObject).UDJ = paramInt4;
    ((feb)localObject).UDK = paramInt5;
    ((feb)localObject).UDL = paramInt6;
    ((feb)localObject).UDM = 1;
    ((feb)localObject).RNM = new eae().ag(paramArrayOfByte, paramInt7);
    AppMethodBeat.o(115226);
  }
  
  public final i gAU()
  {
    AppMethodBeat.i(115228);
    i local1 = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(115225);
        e.Logi("MicroMsg.Voip.DoubleLinkSwitch", "double link switch response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + d.this.NMN.mStatus);
        if (paramAnonymousInt2 != 0)
        {
          e.Loge("MicroMsg.Voip.DoubleLinkSwitch", " double link switch  response with error code:".concat(String.valueOf(paramAnonymousInt2)));
          AppMethodBeat.o(115225);
          return;
        }
        paramAnonymousString = (fec)d.this.gAY();
        d.this.NMN.NLV = paramAnonymousString.TKv;
        if (d.this.NMN.NLV == 0)
        {
          AppMethodBeat.o(115225);
          return;
        }
        if (d.this.NMN.NMi.doubleLinkSwitch(paramAnonymousString.UDN) == 0)
        {
          if (1 != paramAnonymousString.UDN) {
            break label311;
          }
          paramAnonymousq = d.this.NMN.NMi;
          paramAnonymousq.NRT += 1;
        }
        for (;;)
        {
          e.Logi("MicroMsg.Voip.DoubleLinkSwitch", "zhengxue[DOUBLELINK]room " + paramAnonymousString.Svu + " member " + paramAnonymousString.TWl + " key " + paramAnonymousString.Svv + "report flag " + paramAnonymousString.TKv + "switch to link type " + paramAnonymousString.UDN + "doubleLinkSwitchReportStatus " + d.this.NMN.NLV + "mDoubleLinkSwitchSucToDirectCnt" + d.this.NMN.NMi.NRT + "mDoubleLinkSwitchSucToRelayCnt" + d.this.NMN.NMi.NRU);
          AppMethodBeat.o(115225);
          return;
          label311:
          if (2 == paramAnonymousString.UDN)
          {
            paramAnonymousq = d.this.NMN.NMi;
            paramAnonymousq.NRU += 1;
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
  
  public final void kQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115227);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      fec localfec = (fec)gAY();
      if (localfec != null) {
        Log.i("MicroMsg.Voip.DoubleLinkSwitch", "roomId:%d, roomKey:%s, member:%d", new Object[] { Integer.valueOf(localfec.Svu), Long.valueOf(localfec.Svv), Integer.valueOf(localfec.TWl) });
      }
      AppMethodBeat.o(115227);
      return;
    }
    Log.i("MicroMsg.Voip.DoubleLinkSwitch", "double link switch error");
    AppMethodBeat.o(115227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.d
 * JD-Core Version:    0.7.0.1
 */