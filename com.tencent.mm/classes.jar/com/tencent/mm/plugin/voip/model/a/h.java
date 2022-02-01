package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.voip.c.e;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.o;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.w;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.protocal.protobuf.dwc;
import com.tencent.mm.protocal.protobuf.dwd;
import com.tencent.mm.protocal.protobuf.fdc;
import com.tencent.mm.protocal.protobuf.feo;
import com.tencent.mm.protocal.protobuf.fet;
import com.tencent.mm.protocal.protobuf.feu;
import com.tencent.mm.protocal.protobuf.few;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class h
  extends n<fet, feu>
{
  public h(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, LinkedList<dbt> paramLinkedList)
  {
    AppMethodBeat.i(115240);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new fet();
    ((d.a)localObject).lBV = new feu();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voipRedirect";
    ((d.a)localObject).funcId = 678;
    ((d.a)localObject).lBW = 240;
    ((d.a)localObject).respCmdId = 1000000240;
    this.rr = ((d.a)localObject).bgN();
    localObject = (fet)d.b.b(this.rr.lBR);
    ((fet)localObject).Svu = paramInt1;
    ((fet)localObject).Svv = paramLong;
    ((fet)localObject).TWl = paramInt2;
    ((fet)localObject).UFk = paramInt3;
    ((fet)localObject).UFl = paramInt4;
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt1 < paramInt4)
    {
      few localfew = new few();
      paramInt3 = paramInt2 + 1;
      localfew.UFy = paramArrayOfInt[paramInt2];
      paramInt2 = paramInt3 + 1;
      localfew.UFz = paramArrayOfInt[paramInt3];
      paramInt3 = paramInt2 + 1;
      localfew.UFA = paramArrayOfInt[paramInt2];
      int i = paramInt3 + 1;
      localfew.UFB = paramArrayOfInt[paramInt3];
      paramInt2 = i + 1;
      localfew.UFC = paramArrayOfInt[i];
      ((fet)localObject).UFm.add(localfew);
      paramInt1 += 1;
    }
    paramInt1 = 0;
    if (this.NMN.NMi.NSI.NNR != 0L) {
      paramInt1 = (int)((System.currentTimeMillis() - this.NMN.NMi.NSI.NNR) / 1000L);
    }
    ((fet)localObject).UFn = paramInt1;
    ((fet)localObject).UCL = paramLinkedList.size();
    ((fet)localObject).UCM = paramLinkedList;
    AppMethodBeat.o(115240);
  }
  
  public final i gAU()
  {
    AppMethodBeat.i(115242);
    i local1 = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(115239);
        e.Logi("MicroMsg.Voip.Redirect", "Redirect response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + h.this.NMN.mStatus);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          e.Loge("MicroMsg.Voip.Redirect", " redirect response with error code:" + paramAnonymousInt2 + "error type" + paramAnonymousInt1);
          AppMethodBeat.o(115239);
          return;
        }
        paramAnonymousString = (feu)h.this.gAY();
        e.Logi("MicroMsg.Voip.Redirect", "room " + paramAnonymousString.Svu + " member " + paramAnonymousString.TWl + " key " + paramAnonymousString.Svv + " relay addr cnt " + paramAnonymousString.UFq + " RedirectThreshold " + paramAnonymousString.UFv + " RedirectDecision " + paramAnonymousString.UFw);
        paramAnonymousq = new fdc();
        Object localObject = new fdc();
        fdc localfdc = new fdc();
        paramAnonymousq.UCU = paramAnonymousString.UFq;
        paramAnonymousq.UCV = paramAnonymousString.UFr;
        ((fdc)localObject).UCU = paramAnonymousString.UFs;
        ((fdc)localObject).UCV = paramAnonymousString.UFt;
        localfdc.UCU = paramAnonymousString.UFu;
        localfdc.UCV = paramAnonymousString.UDx;
        h.this.NMN.NMl.a(paramAnonymousString.UFx);
        if (((paramAnonymousString.UFx == null) || (paramAnonymousString.UFx.NMs == 0)) && (paramAnonymousString.UFq > 0))
        {
          e.Logi("MicroMsg.Voip.Redirect", "use old method to add redirect conn");
          paramAnonymousq = new dwd();
          localObject = new dwc();
          ((dwc)localObject).Ssu = 0;
          ((dwc)localObject).Ssv = "";
          ((dwc)localObject).Ssw = "";
          ((dwc)localObject).Ssx = h.this.NMN.NMi.netType;
          ((dwc)localObject).Ssy = 4;
          ((dwc)localObject).Ssz = 2;
          ((dwc)localObject).Ucb = new fdc();
          ((dwc)localObject).Ucc = new fdc();
          ((dwc)localObject).Ucb.UCU = paramAnonymousString.UFq;
          ((dwc)localObject).Ucb.UCV = paramAnonymousString.UFr;
          ((dwc)localObject).Ucc.UCU = paramAnonymousString.UFu;
          ((dwc)localObject).Ucc.UCV = paramAnonymousString.UDx;
          paramAnonymousq.Uce.add(localObject);
          paramAnonymousq.Ucd = 1;
          paramAnonymousString = null;
        }
        try
        {
          paramAnonymousq = paramAnonymousq.toByteArray();
          paramAnonymousString = paramAnonymousq;
        }
        catch (Exception paramAnonymousq)
        {
          for (;;)
          {
            Log.e("MicroMsg.Voip.Redirect", "conn info to byte array fail..");
          }
        }
        paramAnonymousInt1 = h.this.NMN.NMi.AddNewRelayConns(paramAnonymousString, paramAnonymousString.length, 1);
        if (paramAnonymousInt1 != 0) {
          e.Loge("MicroMsg.Voip.Redirect", "redirect relay conns fail ret:".concat(String.valueOf(paramAnonymousInt1)));
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
  
  public final void kQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115241);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      feu localfeu = (feu)d.c.b(this.rr.lBS);
      if (localfeu != null) {
        Log.i("MicroMsg.Voip.Redirect", "roomId:%d, roomKey:%s, member:%d", new Object[] { Integer.valueOf(localfeu.Svu), Long.valueOf(localfeu.Svv), Integer.valueOf(localfeu.TWl) });
      }
      AppMethodBeat.o(115241);
      return;
    }
    Log.i("MicroMsg.Voip.Redirect", "Redirect error");
    AppMethodBeat.o(115241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.h
 * JD-Core Version:    0.7.0.1
 */