package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.o;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.w;
import com.tencent.mm.protocal.protobuf.bso;
import com.tencent.mm.protocal.protobuf.cir;
import com.tencent.mm.protocal.protobuf.cis;
import com.tencent.mm.protocal.protobuf.dli;
import com.tencent.mm.protocal.protobuf.dmu;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.protocal.protobuf.dnc;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class h
  extends n<dmz, dna>
{
  public h(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, LinkedList<bso> paramLinkedList)
  {
    AppMethodBeat.i(115240);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new dmz();
    ((b.a)localObject).gUV = new dna();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipRedirect";
    ((b.a)localObject).funcId = 678;
    ((b.a)localObject).reqCmdId = 240;
    ((b.a)localObject).respCmdId = 1000000240;
    this.rr = ((b.a)localObject).atI();
    localObject = (dmz)this.rr.gUS.gUX;
    ((dmz)localObject).DdZ = paramInt1;
    ((dmz)localObject).Dea = paramLong;
    ((dmz)localObject).DZg = paramInt2;
    ((dmz)localObject).EDy = paramInt3;
    ((dmz)localObject).EDz = paramInt4;
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt1 < paramInt4)
    {
      dnc localdnc = new dnc();
      paramInt3 = paramInt2 + 1;
      localdnc.EDM = paramArrayOfInt[paramInt2];
      paramInt2 = paramInt3 + 1;
      localdnc.EDN = paramArrayOfInt[paramInt3];
      paramInt3 = paramInt2 + 1;
      localdnc.EDO = paramArrayOfInt[paramInt2];
      int i = paramInt3 + 1;
      localdnc.EDP = paramArrayOfInt[paramInt3];
      paramInt2 = i + 1;
      localdnc.EDQ = paramArrayOfInt[i];
      ((dmz)localObject).EDA.add(localdnc);
      paramInt1 += 1;
    }
    paramInt1 = 0;
    if (this.zjH.ziZ.zpq.zkI != 0L) {
      paramInt1 = (int)((System.currentTimeMillis() - this.zjH.ziZ.zpq.zkI) / 1000L);
    }
    ((dmz)localObject).EDB = paramInt1;
    ((dmz)localObject).EBa = paramLinkedList.size();
    ((dmz)localObject).EBb = paramLinkedList;
    AppMethodBeat.o(115240);
  }
  
  public final g dVg()
  {
    AppMethodBeat.i(115242);
    g local1 = new g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(115239);
        c.Logi("MicroMsg.Voip.Redirect", "Redirect response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + h.this.zjH.mStatus);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          c.Loge("MicroMsg.Voip.Redirect", " redirect response with error code:" + paramAnonymousInt2 + "error type" + paramAnonymousInt1);
          AppMethodBeat.o(115239);
          return;
        }
        paramAnonymousString = (dna)h.this.dVk();
        c.Logi("MicroMsg.Voip.Redirect", "room " + paramAnonymousString.DdZ + " member " + paramAnonymousString.DZg + " key " + paramAnonymousString.Dea + " relay addr cnt " + paramAnonymousString.EDE + " RedirectThreshold " + paramAnonymousString.EDJ + " RedirectDecision " + paramAnonymousString.EDK);
        paramAnonymousn = new dli();
        Object localObject = new dli();
        dli localdli = new dli();
        paramAnonymousn.EBj = paramAnonymousString.EDE;
        paramAnonymousn.EBk = paramAnonymousString.EDF;
        ((dli)localObject).EBj = paramAnonymousString.EDG;
        ((dli)localObject).EBk = paramAnonymousString.EDH;
        localdli.EBj = paramAnonymousString.EDI;
        localdli.EBk = paramAnonymousString.EBM;
        h.this.zjH.zjc.a(paramAnonymousString.EDL);
        if (((paramAnonymousString.EDL == null) || (paramAnonymousString.EDL.zjj == 0)) && (paramAnonymousString.EDE > 0))
        {
          c.Logi("MicroMsg.Voip.Redirect", "use old method to add redirect conn");
          paramAnonymousn = new cis();
          localObject = new cir();
          ((cir)localObject).Dch = 0;
          ((cir)localObject).Dci = "";
          ((cir)localObject).Dcj = "";
          ((cir)localObject).Dck = h.this.zjH.ziZ.netType;
          ((cir)localObject).Dcl = 4;
          ((cir)localObject).Dcm = 2;
          ((cir)localObject).Eec = new dli();
          ((cir)localObject).Eed = new dli();
          ((cir)localObject).Eec.EBj = paramAnonymousString.EDE;
          ((cir)localObject).Eec.EBk = paramAnonymousString.EDF;
          ((cir)localObject).Eed.EBj = paramAnonymousString.EDI;
          ((cir)localObject).Eed.EBk = paramAnonymousString.EBM;
          paramAnonymousn.Eef.add(localObject);
          paramAnonymousn.Eee = 1;
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
        paramAnonymousInt1 = h.this.zjH.ziZ.AddNewRelayConns(paramAnonymousString, paramAnonymousString.length, 1);
        if (paramAnonymousInt1 != 0) {
          c.Loge("MicroMsg.Voip.Redirect", "redirect relay conns fail ret:".concat(String.valueOf(paramAnonymousInt1)));
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
  
  public final void hR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115241);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      dna localdna = (dna)this.rr.gUT.gUX;
      if (localdna != null) {
        ad.i("MicroMsg.Voip.Redirect", "roomId:%d, roomKey:%s, member:%d", new Object[] { Integer.valueOf(localdna.DdZ), Long.valueOf(localdna.Dea), Integer.valueOf(localdna.DZg) });
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