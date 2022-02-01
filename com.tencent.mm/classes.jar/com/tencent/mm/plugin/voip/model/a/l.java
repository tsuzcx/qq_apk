package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.dta;
import com.tencent.mm.protocal.protobuf.dtb;
import com.tencent.mm.protocal.protobuf.dtc;
import java.util.LinkedList;

public final class l
  extends n<dtb, dtc>
{
  public l(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String[] paramArrayOfString4)
  {
    AppMethodBeat.i(115253);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dtb();
    ((b.a)localObject).hvu = new dtc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipstatreport";
    ((b.a)localObject).funcId = 320;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dtb)this.rr.hvr.hvw;
    dta localdta = new dta();
    crm localcrm = new crm();
    localcrm.aJV(paramString1);
    localdta.FPU = localcrm;
    paramString1 = new dta();
    localcrm = new crm();
    localcrm.aJV(paramString2);
    paramString1.FPU = localcrm;
    paramString2 = new dta();
    localcrm = new crm();
    localcrm.aJV(paramString3);
    paramString2.FPU = localcrm;
    paramString3 = new dta();
    localcrm = new crm();
    localcrm.aJV(paramString4);
    paramString3.FPU = localcrm;
    paramString4 = new dta();
    localcrm = new crm();
    localcrm.aJV(paramString5);
    paramString4.FPU = localcrm;
    ((dtb)localObject).FZg = localdta;
    ((dtb)localObject).Gbm = paramString1;
    ((dtb)localObject).Gbl = paramString2;
    ((dtb)localObject).Gbn = paramString3;
    ((dtb)localObject).Gbo = paramString4;
    d.Logd("MicroMsg.NetSceneVoipStatReport", "natReportList length:" + paramArrayOfString1.length);
    paramString1 = new LinkedList();
    int i = 0;
    while (i < paramArrayOfString1.length)
    {
      paramString1.add(new crm().aJV(paramArrayOfString1[i]));
      i += 1;
    }
    ((dtb)localObject).Gbp = paramString1.size();
    ((dtb)localObject).Gbq = paramString1;
    paramString1 = new LinkedList();
    i = 0;
    while (i < paramArrayOfString2.length)
    {
      paramString1.add(new crm().aJV(paramArrayOfString2[i]));
      i += 1;
    }
    ((dtb)localObject).Evz = paramString1.size();
    ((dtb)localObject).Gbr = paramString1;
    paramString1 = new LinkedList();
    i = 0;
    while (i < paramArrayOfString3.length)
    {
      paramString1.add(new crm().aJV(paramArrayOfString3[i]));
      i += 1;
    }
    ((dtb)localObject).FBe = paramString1.size();
    ((dtb)localObject).Gbs = paramString1;
    paramString1 = new LinkedList();
    i = 0;
    while (i < paramArrayOfString4.length)
    {
      paramString1.add(new crm().aJV(paramArrayOfString4[i]));
      i += 1;
    }
    ((dtb)localObject).Gbt = paramString1.size();
    ((dtb)localObject).Gbu = paramString1;
    AppMethodBeat.o(115253);
  }
  
  public final g eks()
  {
    AppMethodBeat.i(115254);
    g local1 = new g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(115252);
        d.Logd("MicroMsg.NetSceneVoipStatReport", "onSceneEnd type:" + paramAnonymousn.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
        AppMethodBeat.o(115252);
      }
    };
    AppMethodBeat.o(115254);
    return local1;
  }
  
  public final int getType()
  {
    return 320;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.l
 * JD-Core Version:    0.7.0.1
 */