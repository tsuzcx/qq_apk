package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.eal;
import com.tencent.mm.protocal.protobuf.eam;
import com.tencent.mm.protocal.protobuf.ean;
import java.util.LinkedList;

public final class l
  extends n<eam, ean>
{
  public l(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String[] paramArrayOfString4)
  {
    AppMethodBeat.i(115253);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new eam();
    ((b.a)localObject).hQG = new ean();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipstatreport";
    ((b.a)localObject).funcId = 320;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (eam)this.rr.hQD.hQJ;
    eal localeal = new eal();
    cxn localcxn = new cxn();
    localcxn.aQV(paramString1);
    localeal.HUm = localcxn;
    paramString1 = new eal();
    localcxn = new cxn();
    localcxn.aQV(paramString2);
    paramString1.HUm = localcxn;
    paramString2 = new eal();
    localcxn = new cxn();
    localcxn.aQV(paramString3);
    paramString2.HUm = localcxn;
    paramString3 = new eal();
    localcxn = new cxn();
    localcxn.aQV(paramString4);
    paramString3.HUm = localcxn;
    paramString4 = new eal();
    localcxn = new cxn();
    localcxn.aQV(paramString5);
    paramString4.HUm = localcxn;
    ((eam)localObject).Iek = localeal;
    ((eam)localObject).Igq = paramString1;
    ((eam)localObject).Igp = paramString2;
    ((eam)localObject).Igr = paramString3;
    ((eam)localObject).Igs = paramString4;
    com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.NetSceneVoipStatReport", "natReportList length:" + paramArrayOfString1.length);
    paramString1 = new LinkedList();
    int i = 0;
    while (i < paramArrayOfString1.length)
    {
      paramString1.add(new cxn().aQV(paramArrayOfString1[i]));
      i += 1;
    }
    ((eam)localObject).Igt = paramString1.size();
    ((eam)localObject).Igu = paramString1;
    paramString1 = new LinkedList();
    i = 0;
    while (i < paramArrayOfString2.length)
    {
      paramString1.add(new cxn().aQV(paramArrayOfString2[i]));
      i += 1;
    }
    ((eam)localObject).GvC = paramString1.size();
    ((eam)localObject).Igv = paramString1;
    paramString1 = new LinkedList();
    i = 0;
    while (i < paramArrayOfString3.length)
    {
      paramString1.add(new cxn().aQV(paramArrayOfString3[i]));
      i += 1;
    }
    ((eam)localObject).HER = paramString1.size();
    ((eam)localObject).Igw = paramString1;
    paramString1 = new LinkedList();
    i = 0;
    while (i < paramArrayOfString4.length)
    {
      paramString1.add(new cxn().aQV(paramArrayOfString4[i]));
      i += 1;
    }
    ((eam)localObject).Igx = paramString1.size();
    ((eam)localObject).Igy = paramString1;
    AppMethodBeat.o(115253);
  }
  
  public final com.tencent.mm.ak.f eBL()
  {
    AppMethodBeat.i(115254);
    com.tencent.mm.ak.f local1 = new com.tencent.mm.ak.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(115252);
        com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.NetSceneVoipStatReport", "onSceneEnd type:" + paramAnonymousn.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.l
 * JD-Core Version:    0.7.0.1
 */