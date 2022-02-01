package com.tencent.mm.plugin.websearch.api;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aaj;
import com.tencent.mm.protocal.protobuf.ega;
import com.tencent.mm.protocal.protobuf.egb;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class v
  extends a
  implements k
{
  private s DTs;
  private f callback;
  private b rr;
  
  public v(s params)
  {
    AppMethodBeat.i(117630);
    this.DTs = params;
    this.uaV = params.dmf;
    this.fq = params.offset;
    this.mScene = params.scene;
    this.DSQ = params.dDY;
    this.DTs = params;
    this.DSR = params.yzF;
    Object localObject1 = new b.a();
    ((b.a)localObject1).funcId = getType();
    ((b.a)localObject1).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((b.a)localObject1).hQF = new ega();
    ((b.a)localObject1).hQG = new egb();
    this.rr = ((b.a)localObject1).aDS();
    localObject1 = (ega)this.rr.hQD.hQJ;
    ((ega)localObject1).GeT = params.offset;
    ((ega)localObject1).GWA = ad.WL(1);
    ((ega)localObject1).HFR = params.DSW;
    ((ega)localObject1).GLP = params.dmf;
    ((ega)localObject1).HkU = ad.bOD();
    ((ega)localObject1).Scene = params.scene;
    ((ega)localObject1).GeS = params.pSq;
    ((ega)localObject1).HFV = params.dEf;
    ((ega)localObject1).IjH = params.DTc;
    ((ega)localObject1).HUi = params.cSM;
    ((ega)localObject1).IjJ = params.DTo;
    Object localObject2 = new aaj();
    ((aaj)localObject2).key = "client_system_version";
    ((aaj)localObject2).GrE = Build.VERSION.SDK_INT;
    params.DTg.add(localObject2);
    ((ega)localObject1).Iiw = params.DTg;
    ((ega)localObject1).IjI = params.sessionId;
    this.dEc = params.dyb;
    int i;
    String str;
    int j;
    if (params.DTq)
    {
      i = params.scene;
      localObject1 = params.sessionId;
      localObject2 = params.dEb;
      str = params.pSq;
      j = params.offset;
      if (params.DSW != 1) {
        break label372;
      }
    }
    for (;;)
    {
      ac.a(i, (String)localObject1, (String)localObject2, str, j, bool, params.dyb, params.dmf, params.businessType, params.DTm);
      AppMethodBeat.o(117630);
      return;
      label372:
      bool = false;
    }
  }
  
  private egb ePF()
  {
    return (egb)this.rr.hQE.hQJ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(117631);
    am.iV(this.mScene, 2);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(117631);
    return i;
  }
  
  public final String ePw()
  {
    AppMethodBeat.i(117633);
    if (ePF() != null)
    {
      String str = ePF().GWB;
      AppMethodBeat.o(117633);
      return str;
    }
    AppMethodBeat.o(117633);
    return "";
  }
  
  public final int ePx()
  {
    AppMethodBeat.i(117634);
    if (ePF() != null)
    {
      int i = ePF().IjN;
      AppMethodBeat.o(117634);
      return i;
    }
    AppMethodBeat.o(117634);
    return 0;
  }
  
  public final int getType()
  {
    return 1943;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117632);
    ae.i("MicroMsg.FTS.NetSceneWebRecommend", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    boolean bool1;
    boolean bool2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      bool1 = true;
      if (this.DTs.DTq)
      {
        paramInt1 = this.DTs.scene;
        paramq = this.DTs.sessionId;
        paramArrayOfByte = this.DTs.dEb;
        String str = this.DTs.pSq;
        int i = this.DTs.offset;
        if (this.DTs.DSW != 1) {
          break label208;
        }
        bool2 = true;
        label124:
        ac.a(paramInt1, paramq, paramArrayOfByte, str, i, bool2, this.DTs.dyb, bool1, this.DTs.dmf, this.DTs.businessType, this.DTs.DTm);
      }
      if (paramInt3 != -1) {
        break label214;
      }
      am.iV(this.mScene, 4);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(117632);
      return;
      bool1 = false;
      break;
      label208:
      bool2 = false;
      break label124;
      label214:
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        am.iV(this.mScene, 8);
      } else {
        am.iV(this.mScene, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.v
 * JD-Core Version:    0.7.0.1
 */