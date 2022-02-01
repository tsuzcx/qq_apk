package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.o;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.w;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmm;
import com.tencent.mm.protocal.protobuf.esr;
import com.tencent.mm.protocal.protobuf.eud;
import com.tencent.mm.protocal.protobuf.eui;
import com.tencent.mm.protocal.protobuf.euj;
import com.tencent.mm.protocal.protobuf.eul;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class h
  extends n<eui, euj>
{
  public h(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, LinkedList<csu> paramLinkedList)
  {
    AppMethodBeat.i(115240);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new eui();
    ((d.a)localObject).iLO = new euj();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voipRedirect";
    ((d.a)localObject).funcId = 678;
    ((d.a)localObject).iLP = 240;
    ((d.a)localObject).respCmdId = 1000000240;
    this.rr = ((d.a)localObject).aXF();
    localObject = (eui)this.rr.iLK.iLR;
    ((eui)localObject).LsZ = paramInt1;
    ((eui)localObject).Lta = paramLong;
    ((eui)localObject).MKr = paramInt2;
    ((eui)localObject).Nsn = paramInt3;
    ((eui)localObject).Nso = paramInt4;
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt1 < paramInt4)
    {
      eul localeul = new eul();
      paramInt3 = paramInt2 + 1;
      localeul.NsB = paramArrayOfInt[paramInt2];
      paramInt2 = paramInt3 + 1;
      localeul.NsC = paramArrayOfInt[paramInt3];
      paramInt3 = paramInt2 + 1;
      localeul.NsD = paramArrayOfInt[paramInt2];
      int i = paramInt3 + 1;
      localeul.NsE = paramArrayOfInt[paramInt3];
      paramInt2 = i + 1;
      localeul.NsF = paramArrayOfInt[i];
      ((eui)localObject).Nsp.add(localeul);
      paramInt1 += 1;
    }
    paramInt1 = 0;
    if (this.GWA.GVV.Hcw.GXD != 0L) {
      paramInt1 = (int)((System.currentTimeMillis() - this.GWA.GVV.Hcw.GXD) / 1000L);
    }
    ((eui)localObject).Nsq = paramInt1;
    ((eui)localObject).NpP = paramLinkedList.size();
    ((eui)localObject).NpQ = paramLinkedList;
    AppMethodBeat.o(115240);
  }
  
  public final i fIF()
  {
    AppMethodBeat.i(115242);
    i local1 = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(115239);
        e.Logi("MicroMsg.Voip.Redirect", "Redirect response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + h.this.GWA.mStatus);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          e.Loge("MicroMsg.Voip.Redirect", " redirect response with error code:" + paramAnonymousInt2 + "error type" + paramAnonymousInt1);
          AppMethodBeat.o(115239);
          return;
        }
        paramAnonymousString = (euj)h.this.fIJ();
        e.Logi("MicroMsg.Voip.Redirect", "room " + paramAnonymousString.LsZ + " member " + paramAnonymousString.MKr + " key " + paramAnonymousString.Lta + " relay addr cnt " + paramAnonymousString.Nst + " RedirectThreshold " + paramAnonymousString.Nsy + " RedirectDecision " + paramAnonymousString.Nsz);
        paramAnonymousq = new esr();
        Object localObject = new esr();
        esr localesr = new esr();
        paramAnonymousq.NpY = paramAnonymousString.Nst;
        paramAnonymousq.NpZ = paramAnonymousString.Nsu;
        ((esr)localObject).NpY = paramAnonymousString.Nsv;
        ((esr)localObject).NpZ = paramAnonymousString.Nsw;
        localesr.NpY = paramAnonymousString.Nsx;
        localesr.NpZ = paramAnonymousString.NqB;
        h.this.GWA.GVY.a(paramAnonymousString.NsA);
        if (((paramAnonymousString.NsA == null) || (paramAnonymousString.NsA.GWf == 0)) && (paramAnonymousString.Nst > 0))
        {
          e.Logi("MicroMsg.Voip.Redirect", "use old method to add redirect conn");
          paramAnonymousq = new dmm();
          localObject = new dml();
          ((dml)localObject).LqX = 0;
          ((dml)localObject).LqY = "";
          ((dml)localObject).LqZ = "";
          ((dml)localObject).Lra = h.this.GWA.GVV.netType;
          ((dml)localObject).Lrb = 4;
          ((dml)localObject).Lrc = 2;
          ((dml)localObject).MPX = new esr();
          ((dml)localObject).MPY = new esr();
          ((dml)localObject).MPX.NpY = paramAnonymousString.Nst;
          ((dml)localObject).MPX.NpZ = paramAnonymousString.Nsu;
          ((dml)localObject).MPY.NpY = paramAnonymousString.Nsx;
          ((dml)localObject).MPY.NpZ = paramAnonymousString.NqB;
          paramAnonymousq.MQa.add(localObject);
          paramAnonymousq.MPZ = 1;
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
        paramAnonymousInt1 = h.this.GWA.GVV.AddNewRelayConns(paramAnonymousString, paramAnonymousString.length, 1);
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
  
  public final void jC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115241);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      euj localeuj = (euj)this.rr.iLL.iLR;
      if (localeuj != null) {
        Log.i("MicroMsg.Voip.Redirect", "roomId:%d, roomKey:%s, member:%d", new Object[] { Integer.valueOf(localeuj.LsZ), Long.valueOf(localeuj.Lta), Integer.valueOf(localeuj.MKr) });
      }
      AppMethodBeat.o(115241);
      return;
    }
    Log.i("MicroMsg.Voip.Redirect", "Redirect error");
    AppMethodBeat.o(115241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.h
 * JD-Core Version:    0.7.0.1
 */