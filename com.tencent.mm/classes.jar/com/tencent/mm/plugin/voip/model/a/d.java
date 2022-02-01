package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dry;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.sdk.platformtools.ac;

public final class d
  extends n<dry, drz>
{
  public d(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte, int paramInt7)
  {
    AppMethodBeat.i(115226);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dry();
    ((b.a)localObject).hvu = new drz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipDoubleLinkSwitch";
    ((b.a)localObject).funcId = 249;
    ((b.a)localObject).reqCmdId = 249;
    ((b.a)localObject).respCmdId = 1000000249;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dry)this.rr.hvr.hvw;
    ((dry)localObject).Exf = paramInt1;
    ((dry)localObject).Exg = paramLong;
    ((dry)localObject).Fwc = paramInt2;
    ((dry)localObject).FZk = paramInt3;
    ((dry)localObject).FZl = paramInt4;
    ((dry)localObject).FZm = paramInt5;
    ((dry)localObject).FZn = paramInt6;
    ((dry)localObject).FZo = 1;
    ((dry)localObject).DVs = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte, 0, paramInt7);
    AppMethodBeat.o(115226);
  }
  
  public final g eks()
  {
    AppMethodBeat.i(115228);
    g local1 = new g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(115225);
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.DoubleLinkSwitch", "double link switch response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + d.this.ACr.mStatus);
        if (paramAnonymousInt2 != 0)
        {
          com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.DoubleLinkSwitch", " double link switch  response with error code:".concat(String.valueOf(paramAnonymousInt2)));
          AppMethodBeat.o(115225);
          return;
        }
        paramAnonymousString = (drz)d.this.ekw();
        d.this.ACr.ABw = paramAnonymousString.Fnf;
        if (d.this.ACr.ABw == 0)
        {
          AppMethodBeat.o(115225);
          return;
        }
        if (d.this.ACr.ABJ.doubleLinkSwitch(paramAnonymousString.FZp) == 0)
        {
          if (1 != paramAnonymousString.FZp) {
            break label311;
          }
          paramAnonymousn = d.this.ACr.ABJ;
          paramAnonymousn.AHr += 1;
        }
        for (;;)
        {
          com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.DoubleLinkSwitch", "zhengxue[DOUBLELINK]room " + paramAnonymousString.Exf + " member " + paramAnonymousString.Fwc + " key " + paramAnonymousString.Exg + "report flag " + paramAnonymousString.Fnf + "switch to link type " + paramAnonymousString.FZp + "doubleLinkSwitchReportStatus " + d.this.ACr.ABw + "mDoubleLinkSwitchSucToDirectCnt" + d.this.ACr.ABJ.AHr + "mDoubleLinkSwitchSucToRelayCnt" + d.this.ACr.ABJ.AHs);
          AppMethodBeat.o(115225);
          return;
          label311:
          if (2 == paramAnonymousString.FZp)
          {
            paramAnonymousn = d.this.ACr.ABJ;
            paramAnonymousn.AHs += 1;
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
  
  public final void ig(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115227);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      drz localdrz = (drz)ekw();
      if (localdrz != null) {
        ac.i("MicroMsg.Voip.DoubleLinkSwitch", "roomId:%d, roomKey:%s, member:%d", new Object[] { Integer.valueOf(localdrz.Exf), Long.valueOf(localdrz.Exg), Integer.valueOf(localdrz.Fwc) });
      }
      AppMethodBeat.o(115227);
      return;
    }
    ac.i("MicroMsg.Voip.DoubleLinkSwitch", "double link switch error");
    AppMethodBeat.o(115227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.d
 * JD-Core Version:    0.7.0.1
 */