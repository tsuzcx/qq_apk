package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dyu;
import com.tencent.mm.protocal.protobuf.dyv;
import com.tencent.mm.protocal.protobuf.dyw;
import java.util.LinkedList;

public final class l
  extends n<dyv, dyw>
{
  public l(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String[] paramArrayOfString4)
  {
    AppMethodBeat.i(115253);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dyv();
    ((b.a)localObject).hNN = new dyw();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipstatreport";
    ((b.a)localObject).funcId = 320;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dyv)this.rr.hNK.hNQ;
    dyu localdyu = new dyu();
    cwt localcwt = new cwt();
    localcwt.aPy(paramString1);
    localdyu.HAz = localcwt;
    paramString1 = new dyu();
    localcwt = new cwt();
    localcwt.aPy(paramString2);
    paramString1.HAz = localcwt;
    paramString2 = new dyu();
    localcwt = new cwt();
    localcwt.aPy(paramString3);
    paramString2.HAz = localcwt;
    paramString3 = new dyu();
    localcwt = new cwt();
    localcwt.aPy(paramString4);
    paramString3.HAz = localcwt;
    paramString4 = new dyu();
    localcwt = new cwt();
    localcwt.aPy(paramString5);
    paramString4.HAz = localcwt;
    ((dyv)localObject).HKc = localdyu;
    ((dyv)localObject).HMj = paramString1;
    ((dyv)localObject).HMi = paramString2;
    ((dyv)localObject).HMk = paramString3;
    ((dyv)localObject).HMl = paramString4;
    com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.NetSceneVoipStatReport", "natReportList length:" + paramArrayOfString1.length);
    paramString1 = new LinkedList();
    int i = 0;
    while (i < paramArrayOfString1.length)
    {
      paramString1.add(new cwt().aPy(paramArrayOfString1[i]));
      i += 1;
    }
    ((dyv)localObject).HMm = paramString1.size();
    ((dyv)localObject).HMn = paramString1;
    paramString1 = new LinkedList();
    i = 0;
    while (i < paramArrayOfString2.length)
    {
      paramString1.add(new cwt().aPy(paramArrayOfString2[i]));
      i += 1;
    }
    ((dyv)localObject).GcV = paramString1.size();
    ((dyv)localObject).HMo = paramString1;
    paramString1 = new LinkedList();
    i = 0;
    while (i < paramArrayOfString3.length)
    {
      paramString1.add(new cwt().aPy(paramArrayOfString3[i]));
      i += 1;
    }
    ((dyv)localObject).Hlr = paramString1.size();
    ((dyv)localObject).HMp = paramString1;
    paramString1 = new LinkedList();
    i = 0;
    while (i < paramArrayOfString4.length)
    {
      paramString1.add(new cwt().aPy(paramArrayOfString4[i]));
      i += 1;
    }
    ((dyv)localObject).HMq = paramString1.size();
    ((dyv)localObject).HMr = paramString1;
    AppMethodBeat.o(115253);
  }
  
  public final com.tencent.mm.al.f eyd()
  {
    AppMethodBeat.i(115254);
    com.tencent.mm.al.f local1 = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.l
 * JD-Core Version:    0.7.0.1
 */