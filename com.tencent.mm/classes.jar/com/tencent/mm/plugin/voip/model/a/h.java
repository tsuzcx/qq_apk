package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.o;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.w;
import com.tencent.mm.protocal.protobuf.dtl;
import com.tencent.mm.protocal.protobuf.epe;
import com.tencent.mm.protocal.protobuf.epf;
import com.tencent.mm.protocal.protobuf.fzo;
import com.tencent.mm.protocal.protobuf.gba;
import com.tencent.mm.protocal.protobuf.gbf;
import com.tencent.mm.protocal.protobuf.gbg;
import com.tencent.mm.protocal.protobuf.gbi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class h
  extends n<gbf, gbg>
{
  public h(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, LinkedList<dtl> paramLinkedList)
  {
    AppMethodBeat.i(115240);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new gbf();
    ((c.a)localObject).otF = new gbg();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/voipRedirect";
    ((c.a)localObject).funcId = 678;
    ((c.a)localObject).otG = 240;
    ((c.a)localObject).respCmdId = 1000000240;
    this.rr = ((c.a)localObject).bEF();
    localObject = (gbf)c.b.b(this.rr.otB);
    ((gbf)localObject).Zvz = paramInt1;
    ((gbf)localObject).ZvA = paramLong;
    ((gbf)localObject).abna = paramInt2;
    ((gbf)localObject).abZu = paramInt3;
    ((gbf)localObject).abZv = paramInt4;
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt1 < paramInt4)
    {
      gbi localgbi = new gbi();
      paramInt3 = paramInt2 + 1;
      localgbi.abZI = paramArrayOfInt[paramInt2];
      paramInt2 = paramInt3 + 1;
      localgbi.abZJ = paramArrayOfInt[paramInt3];
      paramInt3 = paramInt2 + 1;
      localgbi.abZK = paramArrayOfInt[paramInt2];
      int i = paramInt3 + 1;
      localgbi.abZL = paramArrayOfInt[paramInt3];
      paramInt2 = i + 1;
      localgbi.abZM = paramArrayOfInt[i];
      ((gbf)localObject).abZw.add(localgbi);
      paramInt1 += 1;
    }
    paramInt1 = 0;
    if (this.UzB.UyU.UFN.UAI != 0L) {
      paramInt1 = (int)((System.currentTimeMillis() - this.UzB.UyU.UFN.UAI) / 1000L);
    }
    ((gbf)localObject).abZx = paramInt1;
    ((gbf)localObject).abWV = paramLinkedList.size();
    ((gbf)localObject).abWW = paramLinkedList;
    AppMethodBeat.o(115240);
  }
  
  public final int getType()
  {
    return 678;
  }
  
  public final com.tencent.mm.am.h hYT()
  {
    AppMethodBeat.i(115242);
    com.tencent.mm.am.h local1 = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(115239);
        g.Logi("MicroMsg.Voip.Redirect", "Redirect response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + h.this.UzB.mStatus);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          g.Loge("MicroMsg.Voip.Redirect", " redirect response with error code:" + paramAnonymousInt2 + "error type" + paramAnonymousInt1);
          AppMethodBeat.o(115239);
          return;
        }
        paramAnonymousString = h.this.UzB.UyU.UFN;
        paramAnonymousString.wS((int)(System.currentTimeMillis() - paramAnonymousString.UAS));
        paramAnonymousString = (gbg)h.this.hYX();
        g.Logi("MicroMsg.Voip.Redirect", "room " + paramAnonymousString.Zvz + " member " + paramAnonymousString.abna + " key " + paramAnonymousString.ZvA + " relay addr cnt " + paramAnonymousString.abZA + " RedirectThreshold " + paramAnonymousString.abZF + " RedirectDecision " + paramAnonymousString.abZG);
        paramAnonymousp = new fzo();
        Object localObject = new fzo();
        fzo localfzo = new fzo();
        paramAnonymousp.abXf = paramAnonymousString.abZA;
        paramAnonymousp.abXg = paramAnonymousString.abZB;
        ((fzo)localObject).abXf = paramAnonymousString.abZC;
        ((fzo)localObject).abXg = paramAnonymousString.abZD;
        localfzo.abXf = paramAnonymousString.abZE;
        localfzo.abXg = paramAnonymousString.abXI;
        h.this.UzB.UyX.a(paramAnonymousString.abZH);
        if (((paramAnonymousString.abZH == null) || (paramAnonymousString.abZH.Uze == 0)) && (paramAnonymousString.abZA > 0))
        {
          g.Logi("MicroMsg.Voip.Redirect", "use old method to add redirect conn");
          paramAnonymousp = new epf();
          localObject = new epe();
          ((epe)localObject).ZrC = 0;
          ((epe)localObject).ZrD = "";
          ((epe)localObject).ZrE = "";
          ((epe)localObject).ZrF = h.this.UzB.UyU.netType;
          ((epe)localObject).ZrG = 4;
          ((epe)localObject).ZrH = 2;
          ((epe)localObject).abto = new fzo();
          ((epe)localObject).abtp = new fzo();
          ((epe)localObject).abto.abXf = paramAnonymousString.abZA;
          ((epe)localObject).abto.abXg = paramAnonymousString.abZB;
          ((epe)localObject).abtp.abXf = paramAnonymousString.abZE;
          ((epe)localObject).abtp.abXg = paramAnonymousString.abXI;
          paramAnonymousp.abtr.add(localObject);
          paramAnonymousp.abtq = 1;
          paramAnonymousString = null;
        }
        try
        {
          paramAnonymousp = paramAnonymousp.toByteArray();
          paramAnonymousString = paramAnonymousp;
        }
        catch (Exception paramAnonymousp)
        {
          for (;;)
          {
            Log.e("MicroMsg.Voip.Redirect", "conn info to byte array fail..");
          }
        }
        paramAnonymousInt1 = h.this.UzB.UyU.AddNewRelayConns(paramAnonymousString, paramAnonymousString.length, 1);
        if (paramAnonymousInt1 != 0) {
          g.Loge("MicroMsg.Voip.Redirect", "redirect relay conns fail ret:".concat(String.valueOf(paramAnonymousInt1)));
        }
        AppMethodBeat.o(115239);
      }
    };
    AppMethodBeat.o(115242);
    return local1;
  }
  
  public final void mD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115241);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      gbg localgbg = (gbg)c.c.b(this.rr.otC);
      if (localgbg != null) {
        Log.i("MicroMsg.Voip.Redirect", "roomId:%d, roomKey:%s, member:%d", new Object[] { Integer.valueOf(localgbg.Zvz), Long.valueOf(localgbg.ZvA), Integer.valueOf(localgbg.abna) });
      }
      AppMethodBeat.o(115241);
      return;
    }
    Log.i("MicroMsg.Voip.Redirect", "Redirect error");
    AppMethodBeat.o(115241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.h
 * JD-Core Version:    0.7.0.1
 */