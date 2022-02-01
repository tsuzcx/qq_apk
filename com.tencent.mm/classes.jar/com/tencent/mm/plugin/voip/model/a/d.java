package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.gan;
import com.tencent.mm.protocal.protobuf.gao;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends n<gan, gao>
{
  public d(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte, int paramInt7)
  {
    AppMethodBeat.i(115226);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new gan();
    ((c.a)localObject).otF = new gao();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/voipDoubleLinkSwitch";
    ((c.a)localObject).funcId = 249;
    ((c.a)localObject).otG = 249;
    ((c.a)localObject).respCmdId = 1000000249;
    this.rr = ((c.a)localObject).bEF();
    localObject = (gan)c.b.b(this.rr.otB);
    ((gan)localObject).Zvz = paramInt1;
    ((gan)localObject).ZvA = paramLong;
    ((gan)localObject).abna = paramInt2;
    ((gan)localObject).abXT = paramInt3;
    ((gan)localObject).abXU = paramInt4;
    ((gan)localObject).abXV = paramInt5;
    ((gan)localObject).abXW = paramInt6;
    ((gan)localObject).abXX = 1;
    ((gan)localObject).YLa = new gol().ah(paramArrayOfByte, paramInt7);
    AppMethodBeat.o(115226);
  }
  
  public final int getType()
  {
    return 249;
  }
  
  public final h hYT()
  {
    AppMethodBeat.i(115228);
    h local1 = new h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(115225);
        g.Logi("MicroMsg.Voip.DoubleLinkSwitch", "double link switch response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + d.this.UzB.mStatus);
        if (paramAnonymousInt2 != 0)
        {
          g.Loge("MicroMsg.Voip.DoubleLinkSwitch", " double link switch  response with error code:".concat(String.valueOf(paramAnonymousInt2)));
          AppMethodBeat.o(115225);
          return;
        }
        paramAnonymousString = (gao)d.this.hYX();
        d.this.UzB.UyH = paramAnonymousString.abao;
        if (d.this.UzB.UyH == 0)
        {
          AppMethodBeat.o(115225);
          return;
        }
        if (d.this.UzB.UyU.doubleLinkSwitch(paramAnonymousString.abXY) == 0)
        {
          if (1 != paramAnonymousString.abXY) {
            break label311;
          }
          paramAnonymousp = d.this.UzB.UyU;
          paramAnonymousp.UEY += 1;
        }
        for (;;)
        {
          g.Logi("MicroMsg.Voip.DoubleLinkSwitch", "zhengxue[DOUBLELINK]room " + paramAnonymousString.Zvz + " member " + paramAnonymousString.abna + " key " + paramAnonymousString.ZvA + "report flag " + paramAnonymousString.abao + "switch to link type " + paramAnonymousString.abXY + "doubleLinkSwitchReportStatus " + d.this.UzB.UyH + "mDoubleLinkSwitchSucToDirectCnt" + d.this.UzB.UyU.UEY + "mDoubleLinkSwitchSucToRelayCnt" + d.this.UzB.UyU.UEZ);
          AppMethodBeat.o(115225);
          return;
          label311:
          if (2 == paramAnonymousString.abXY)
          {
            paramAnonymousp = d.this.UzB.UyU;
            paramAnonymousp.UEZ += 1;
          }
        }
      }
    };
    AppMethodBeat.o(115228);
    return local1;
  }
  
  public final void mD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115227);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      gao localgao = (gao)hYX();
      if (localgao != null) {
        Log.i("MicroMsg.Voip.DoubleLinkSwitch", "roomId:%d, roomKey:%s, member:%d", new Object[] { Integer.valueOf(localgao.Zvz), Long.valueOf(localgao.ZvA), Integer.valueOf(localgao.abna) });
      }
      AppMethodBeat.o(115227);
      return;
    }
    Log.i("MicroMsg.Voip.DoubleLinkSwitch", "double link switch error");
    AppMethodBeat.o(115227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.d
 * JD-Core Version:    0.7.0.1
 */