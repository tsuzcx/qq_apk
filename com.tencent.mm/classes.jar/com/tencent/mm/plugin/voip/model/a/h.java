package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.o;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.w;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.cny;
import com.tencent.mm.protocal.protobuf.cnz;
import com.tencent.mm.protocal.protobuf.dqz;
import com.tencent.mm.protocal.protobuf.dsl;
import com.tencent.mm.protocal.protobuf.dsq;
import com.tencent.mm.protocal.protobuf.dsr;
import com.tencent.mm.protocal.protobuf.dst;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class h
  extends n<dsq, dsr>
{
  public h(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, LinkedList<bxf> paramLinkedList)
  {
    AppMethodBeat.i(115240);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dsq();
    ((b.a)localObject).hvu = new dsr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipRedirect";
    ((b.a)localObject).funcId = 678;
    ((b.a)localObject).reqCmdId = 240;
    ((b.a)localObject).respCmdId = 1000000240;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dsq)this.rr.hvr.hvw;
    ((dsq)localObject).Exf = paramInt1;
    ((dsq)localObject).Exg = paramLong;
    ((dsq)localObject).Fwc = paramInt2;
    ((dsq)localObject).GaL = paramInt3;
    ((dsq)localObject).GaM = paramInt4;
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt1 < paramInt4)
    {
      dst localdst = new dst();
      paramInt3 = paramInt2 + 1;
      localdst.GaZ = paramArrayOfInt[paramInt2];
      paramInt2 = paramInt3 + 1;
      localdst.Gba = paramArrayOfInt[paramInt3];
      paramInt3 = paramInt2 + 1;
      localdst.Gbb = paramArrayOfInt[paramInt2];
      int i = paramInt3 + 1;
      localdst.Gbc = paramArrayOfInt[paramInt3];
      paramInt2 = i + 1;
      localdst.Gbd = paramArrayOfInt[i];
      ((dsq)localObject).GaN.add(localdst);
      paramInt1 += 1;
    }
    paramInt1 = 0;
    if (this.ACr.ABJ.AIf.ADs != 0L) {
      paramInt1 = (int)((System.currentTimeMillis() - this.ACr.ABJ.AIf.ADs) / 1000L);
    }
    ((dsq)localObject).GaO = paramInt1;
    ((dsq)localObject).FYn = paramLinkedList.size();
    ((dsq)localObject).FYo = paramLinkedList;
    AppMethodBeat.o(115240);
  }
  
  public final g eks()
  {
    AppMethodBeat.i(115242);
    g local1 = new g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(115239);
        d.Logi("MicroMsg.Voip.Redirect", "Redirect response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + h.this.ACr.mStatus);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          d.Loge("MicroMsg.Voip.Redirect", " redirect response with error code:" + paramAnonymousInt2 + "error type" + paramAnonymousInt1);
          AppMethodBeat.o(115239);
          return;
        }
        paramAnonymousString = (dsr)h.this.ekw();
        d.Logi("MicroMsg.Voip.Redirect", "room " + paramAnonymousString.Exf + " member " + paramAnonymousString.Fwc + " key " + paramAnonymousString.Exg + " relay addr cnt " + paramAnonymousString.GaR + " RedirectThreshold " + paramAnonymousString.GaW + " RedirectDecision " + paramAnonymousString.GaX);
        paramAnonymousn = new dqz();
        Object localObject = new dqz();
        dqz localdqz = new dqz();
        paramAnonymousn.FYw = paramAnonymousString.GaR;
        paramAnonymousn.FYx = paramAnonymousString.GaS;
        ((dqz)localObject).FYw = paramAnonymousString.GaT;
        ((dqz)localObject).FYx = paramAnonymousString.GaU;
        localdqz.FYw = paramAnonymousString.GaV;
        localdqz.FYx = paramAnonymousString.FYZ;
        h.this.ACr.ABM.a(paramAnonymousString.GaY);
        if (((paramAnonymousString.GaY == null) || (paramAnonymousString.GaY.ABT == 0)) && (paramAnonymousString.GaR > 0))
        {
          d.Logi("MicroMsg.Voip.Redirect", "use old method to add redirect conn");
          paramAnonymousn = new cnz();
          localObject = new cny();
          ((cny)localObject).Evo = 0;
          ((cny)localObject).Evp = "";
          ((cny)localObject).Evq = "";
          ((cny)localObject).Evr = h.this.ACr.ABJ.netType;
          ((cny)localObject).Evs = 4;
          ((cny)localObject).Evt = 2;
          ((cny)localObject).FBc = new dqz();
          ((cny)localObject).FBd = new dqz();
          ((cny)localObject).FBc.FYw = paramAnonymousString.GaR;
          ((cny)localObject).FBc.FYx = paramAnonymousString.GaS;
          ((cny)localObject).FBd.FYw = paramAnonymousString.GaV;
          ((cny)localObject).FBd.FYx = paramAnonymousString.FYZ;
          paramAnonymousn.FBf.add(localObject);
          paramAnonymousn.FBe = 1;
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
            ac.e("MicroMsg.Voip.Redirect", "conn info to byte array fail..");
          }
        }
        paramAnonymousInt1 = h.this.ACr.ABJ.AddNewRelayConns(paramAnonymousString, paramAnonymousString.length, 1);
        if (paramAnonymousInt1 != 0) {
          d.Loge("MicroMsg.Voip.Redirect", "redirect relay conns fail ret:".concat(String.valueOf(paramAnonymousInt1)));
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
  
  public final void ig(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115241);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      dsr localdsr = (dsr)this.rr.hvs.hvw;
      if (localdsr != null) {
        ac.i("MicroMsg.Voip.Redirect", "roomId:%d, roomKey:%s, member:%d", new Object[] { Integer.valueOf(localdsr.Exf), Long.valueOf(localdsr.Exg), Integer.valueOf(localdsr.Fwc) });
      }
      AppMethodBeat.o(115241);
      return;
    }
    ac.i("MicroMsg.Voip.Redirect", "Redirect error");
    AppMethodBeat.o(115241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.h
 * JD-Core Version:    0.7.0.1
 */