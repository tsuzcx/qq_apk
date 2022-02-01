package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.o;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.w;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.protocal.protobuf.ctb;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.protocal.protobuf.dwt;
import com.tencent.mm.protocal.protobuf.dyf;
import com.tencent.mm.protocal.protobuf.dyk;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyn;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class h
  extends n<dyk, dyl>
{
  public h(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, LinkedList<cbv> paramLinkedList)
  {
    AppMethodBeat.i(115240);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dyk();
    ((b.a)localObject).hNN = new dyl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipRedirect";
    ((b.a)localObject).funcId = 678;
    ((b.a)localObject).hNO = 240;
    ((b.a)localObject).respCmdId = 1000000240;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dyk)this.rr.hNK.hNQ;
    ((dyk)localObject).GeI = paramInt1;
    ((dyk)localObject).GeJ = paramLong;
    ((dyk)localObject).Hgi = paramInt2;
    ((dyk)localObject).HLH = paramInt3;
    ((dyk)localObject).HLI = paramInt4;
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt1 < paramInt4)
    {
      dyn localdyn = new dyn();
      paramInt3 = paramInt2 + 1;
      localdyn.HLW = paramArrayOfInt[paramInt2];
      paramInt2 = paramInt3 + 1;
      localdyn.HLX = paramArrayOfInt[paramInt3];
      paramInt3 = paramInt2 + 1;
      localdyn.HLY = paramArrayOfInt[paramInt2];
      int i = paramInt3 + 1;
      localdyn.HLZ = paramArrayOfInt[paramInt3];
      paramInt2 = i + 1;
      localdyn.HMa = paramArrayOfInt[i];
      ((dyk)localObject).HLJ.add(localdyn);
      paramInt1 += 1;
    }
    paramInt1 = 0;
    if (this.Cbq.CaI.Chg.Cct != 0L) {
      paramInt1 = (int)((System.currentTimeMillis() - this.Cbq.CaI.Chg.Cct) / 1000L);
    }
    ((dyk)localObject).HLK = paramInt1;
    ((dyk)localObject).HJj = paramLinkedList.size();
    ((dyk)localObject).HJk = paramLinkedList;
    AppMethodBeat.o(115240);
  }
  
  public final com.tencent.mm.al.f eyd()
  {
    AppMethodBeat.i(115242);
    com.tencent.mm.al.f local1 = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(115239);
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.Redirect", "Redirect response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + h.this.Cbq.mStatus);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.Redirect", " redirect response with error code:" + paramAnonymousInt2 + "error type" + paramAnonymousInt1);
          AppMethodBeat.o(115239);
          return;
        }
        paramAnonymousString = (dyl)h.this.eyh();
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.Redirect", "room " + paramAnonymousString.GeI + " member " + paramAnonymousString.Hgi + " key " + paramAnonymousString.GeJ + " relay addr cnt " + paramAnonymousString.HLN + " RedirectThreshold " + paramAnonymousString.HLT + " RedirectDecision " + paramAnonymousString.HLU);
        paramAnonymousn = new dwt();
        Object localObject = new dwt();
        dwt localdwt = new dwt();
        paramAnonymousn.HJs = paramAnonymousString.HLN;
        paramAnonymousn.HJt = paramAnonymousString.HLO;
        ((dwt)localObject).HJs = paramAnonymousString.HLP;
        ((dwt)localObject).HJt = paramAnonymousString.HLQ;
        localdwt.HJs = paramAnonymousString.HLR;
        localdwt.HJt = paramAnonymousString.HJV;
        h.this.Cbq.CaL.a(paramAnonymousString.HLV);
        if (((paramAnonymousString.HLV == null) || (paramAnonymousString.HLV.CaS == 0)) && (paramAnonymousString.HLN > 0))
        {
          com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.Redirect", "use old method to add redirect conn");
          paramAnonymousn = new ctc();
          localObject = new ctb();
          ((ctb)localObject).GcK = 0;
          ((ctb)localObject).GcL = "";
          ((ctb)localObject).GcM = "";
          ((ctb)localObject).GcN = h.this.Cbq.CaI.netType;
          ((ctb)localObject).GcO = 4;
          ((ctb)localObject).GcP = 2;
          ((ctb)localObject).Hlp = new dwt();
          ((ctb)localObject).Hlq = new dwt();
          ((ctb)localObject).Hlp.HJs = paramAnonymousString.HLN;
          ((ctb)localObject).Hlp.HJt = paramAnonymousString.HLO;
          ((ctb)localObject).Hlq.HJs = paramAnonymousString.HLR;
          ((ctb)localObject).Hlq.HJt = paramAnonymousString.HJV;
          paramAnonymousn.Hls.add(localObject);
          paramAnonymousn.Hlr = 1;
          paramAnonymousString = null;
        }
        try
        {
          paramAnonymousn = paramAnonymousn.toByteArray();
          paramAnonymousString = paramAnonymousn;
        }
        catch (Exception paramAnonymousn)
        {
          for (;;)
          {
            ad.e("MicroMsg.Voip.Redirect", "conn info to byte array fail..");
          }
        }
        paramAnonymousInt1 = h.this.Cbq.CaI.AddNewRelayConns(paramAnonymousString, paramAnonymousString.length, 1);
        if (paramAnonymousInt1 != 0) {
          com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.Redirect", "redirect relay conns fail ret:".concat(String.valueOf(paramAnonymousInt1)));
        }
        AppMethodBeat.o(115239);
      }
    };
    AppMethodBeat.o(115242);
    return local1;
  }
  
  public final int getType()
  {
    return 678;
  }
  
  public final void it(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115241);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      dyl localdyl = (dyl)this.rr.hNL.hNQ;
      if (localdyl != null) {
        ad.i("MicroMsg.Voip.Redirect", "roomId:%d, roomKey:%s, member:%d", new Object[] { Integer.valueOf(localdyl.GeI), Long.valueOf(localdyl.GeJ), Integer.valueOf(localdyl.Hgi) });
      }
      AppMethodBeat.o(115241);
      return;
    }
    ad.i("MicroMsg.Voip.Redirect", "Redirect error");
    AppMethodBeat.o(115241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.h
 * JD-Core Version:    0.7.0.1
 */