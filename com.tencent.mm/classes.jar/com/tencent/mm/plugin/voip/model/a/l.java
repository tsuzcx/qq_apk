package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.voip.c.e;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ffd;
import com.tencent.mm.protocal.protobuf.ffe;
import com.tencent.mm.protocal.protobuf.fff;
import java.util.LinkedList;

public final class l
  extends n<ffe, fff>
{
  public l(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String[] paramArrayOfString4)
  {
    AppMethodBeat.i(115253);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ffe();
    ((d.a)localObject).lBV = new fff();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voipstatreport";
    ((d.a)localObject).funcId = 320;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    d.b.b(this.rr.lBR);
    localObject = (ffe)d.b.b(this.rr.lBR);
    ffd localffd = new ffd();
    eaf localeaf = new eaf();
    localeaf.btQ(paramString1);
    localffd.Uti = localeaf;
    paramString1 = new ffd();
    localeaf = new eaf();
    localeaf.btQ(paramString2);
    paramString1.Uti = localeaf;
    paramString2 = new ffd();
    localeaf = new eaf();
    localeaf.btQ(paramString3);
    paramString2.Uti = localeaf;
    paramString3 = new ffd();
    localeaf = new eaf();
    localeaf.btQ(paramString4);
    paramString3.Uti = localeaf;
    paramString4 = new ffd();
    localeaf = new eaf();
    localeaf.btQ(paramString5);
    paramString4.Uti = localeaf;
    ((ffe)localObject).UDE = localffd;
    ((ffe)localObject).UFL = paramString1;
    ((ffe)localObject).UFK = paramString2;
    ((ffe)localObject).UFM = paramString3;
    ((ffe)localObject).UFN = paramString4;
    e.Logd("MicroMsg.NetSceneVoipStatReport", "natReportList length:" + paramArrayOfString1.length);
    paramString1 = new LinkedList();
    int i = 0;
    while (i < paramArrayOfString1.length)
    {
      paramString1.add(new eaf().btQ(paramArrayOfString1[i]));
      i += 1;
    }
    ((ffe)localObject).UFO = paramString1.size();
    ((ffe)localObject).UFP = paramString1;
    paramString1 = new LinkedList();
    i = 0;
    while (i < paramArrayOfString2.length)
    {
      paramString1.add(new eaf().btQ(paramArrayOfString2[i]));
      i += 1;
    }
    ((ffe)localObject).SsF = paramString1.size();
    ((ffe)localObject).UFQ = paramString1;
    paramString1 = new LinkedList();
    i = 0;
    while (i < paramArrayOfString3.length)
    {
      paramString1.add(new eaf().btQ(paramArrayOfString3[i]));
      i += 1;
    }
    ((ffe)localObject).Ucd = paramString1.size();
    ((ffe)localObject).UFR = paramString1;
    paramString1 = new LinkedList();
    i = 0;
    while (i < paramArrayOfString4.length)
    {
      paramString1.add(new eaf().btQ(paramArrayOfString4[i]));
      i += 1;
    }
    ((ffe)localObject).UFS = paramString1.size();
    ((ffe)localObject).UFT = paramString1;
    AppMethodBeat.o(115253);
  }
  
  public final i gAU()
  {
    AppMethodBeat.i(115254);
    i local1 = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(115252);
        e.Logd("MicroMsg.NetSceneVoipStatReport", "onSceneEnd type:" + paramAnonymousq.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.l
 * JD-Core Version:    0.7.0.1
 */