package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.o;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.w;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.protocal.protobuf.ctw;
import com.tencent.mm.protocal.protobuf.dyk;
import com.tencent.mm.protocal.protobuf.dzw;
import com.tencent.mm.protocal.protobuf.eab;
import com.tencent.mm.protocal.protobuf.eac;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class h
  extends n<eab, eac>
{
  public h(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, LinkedList<ccp> paramLinkedList)
  {
    AppMethodBeat.i(115240);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new eab();
    ((b.a)localObject).hQG = new eac();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipRedirect";
    ((b.a)localObject).funcId = 678;
    ((b.a)localObject).hQH = 240;
    ((b.a)localObject).respCmdId = 1000000240;
    this.rr = ((b.a)localObject).aDS();
    localObject = (eab)this.rr.hQD.hQJ;
    ((eab)localObject).Gxq = paramInt1;
    ((eab)localObject).Gxr = paramLong;
    ((eab)localObject).HzI = paramInt2;
    ((eab)localObject).IfP = paramInt3;
    ((eab)localObject).IfQ = paramInt4;
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt1 < paramInt4)
    {
      eae localeae = new eae();
      paramInt3 = paramInt2 + 1;
      localeae.Igd = paramArrayOfInt[paramInt2];
      paramInt2 = paramInt3 + 1;
      localeae.Ige = paramArrayOfInt[paramInt3];
      paramInt3 = paramInt2 + 1;
      localeae.Igf = paramArrayOfInt[paramInt2];
      int i = paramInt3 + 1;
      localeae.Igg = paramArrayOfInt[paramInt3];
      paramInt2 = i + 1;
      localeae.Igh = paramArrayOfInt[i];
      ((eab)localObject).IfR.add(localeae);
      paramInt1 += 1;
    }
    paramInt1 = 0;
    if (this.CsR.Csj.CyH.CtU != 0L) {
      paramInt1 = (int)((System.currentTimeMillis() - this.CsR.Csj.CyH.CtU) / 1000L);
    }
    ((eab)localObject).IfS = paramInt1;
    ((eab)localObject).Idr = paramLinkedList.size();
    ((eab)localObject).Ids = paramLinkedList;
    AppMethodBeat.o(115240);
  }
  
  public final com.tencent.mm.ak.f eBL()
  {
    AppMethodBeat.i(115242);
    com.tencent.mm.ak.f local1 = new com.tencent.mm.ak.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(115239);
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.Redirect", "Redirect response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + h.this.CsR.mStatus);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.Redirect", " redirect response with error code:" + paramAnonymousInt2 + "error type" + paramAnonymousInt1);
          AppMethodBeat.o(115239);
          return;
        }
        paramAnonymousString = (eac)h.this.eBP();
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.Redirect", "room " + paramAnonymousString.Gxq + " member " + paramAnonymousString.HzI + " key " + paramAnonymousString.Gxr + " relay addr cnt " + paramAnonymousString.IfV + " RedirectThreshold " + paramAnonymousString.Iga + " RedirectDecision " + paramAnonymousString.Igb);
        paramAnonymousn = new dyk();
        Object localObject = new dyk();
        dyk localdyk = new dyk();
        paramAnonymousn.IdA = paramAnonymousString.IfV;
        paramAnonymousn.IdB = paramAnonymousString.IfW;
        ((dyk)localObject).IdA = paramAnonymousString.IfX;
        ((dyk)localObject).IdB = paramAnonymousString.IfY;
        localdyk.IdA = paramAnonymousString.IfZ;
        localdyk.IdB = paramAnonymousString.Ied;
        h.this.CsR.Csm.a(paramAnonymousString.Igc);
        if (((paramAnonymousString.Igc == null) || (paramAnonymousString.Igc.Cst == 0)) && (paramAnonymousString.IfV > 0))
        {
          com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.Redirect", "use old method to add redirect conn");
          paramAnonymousn = new ctw();
          localObject = new ctv();
          ((ctv)localObject).Gvr = 0;
          ((ctv)localObject).Gvs = "";
          ((ctv)localObject).Gvt = "";
          ((ctv)localObject).Gvu = h.this.CsR.Csj.netType;
          ((ctv)localObject).Gvv = 4;
          ((ctv)localObject).Gvw = 2;
          ((ctv)localObject).HEP = new dyk();
          ((ctv)localObject).HEQ = new dyk();
          ((ctv)localObject).HEP.IdA = paramAnonymousString.IfV;
          ((ctv)localObject).HEP.IdB = paramAnonymousString.IfW;
          ((ctv)localObject).HEQ.IdA = paramAnonymousString.IfZ;
          ((ctv)localObject).HEQ.IdB = paramAnonymousString.Ied;
          paramAnonymousn.HES.add(localObject);
          paramAnonymousn.HER = 1;
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
            ae.e("MicroMsg.Voip.Redirect", "conn info to byte array fail..");
          }
        }
        paramAnonymousInt1 = h.this.CsR.Csj.AddNewRelayConns(paramAnonymousString, paramAnonymousString.length, 1);
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
  
  public final void ix(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115241);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      eac localeac = (eac)this.rr.hQE.hQJ;
      if (localeac != null) {
        ae.i("MicroMsg.Voip.Redirect", "roomId:%d, roomKey:%s, member:%d", new Object[] { Integer.valueOf(localeac.Gxq), Long.valueOf(localeac.Gxr), Integer.valueOf(localeac.HzI) });
      }
      AppMethodBeat.o(115241);
      return;
    }
    ae.i("MicroMsg.Voip.Redirect", "Redirect error");
    AppMethodBeat.o(115241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.h
 * JD-Core Version:    0.7.0.1
 */