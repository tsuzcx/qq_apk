package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.dnj;
import com.tencent.mm.protocal.protobuf.dnk;
import com.tencent.mm.protocal.protobuf.dnl;
import java.util.LinkedList;

public final class l
  extends n<dnk, dnl>
{
  public l(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String[] paramArrayOfString4)
  {
    AppMethodBeat.i(115253);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new dnk();
    ((b.a)localObject).gUV = new dnl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipstatreport";
    ((b.a)localObject).funcId = 320;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (dnk)this.rr.gUS.gUX;
    dnj localdnj = new dnj();
    cmf localcmf = new cmf();
    localcmf.aEE(paramString1);
    localdnj.EsS = localcmf;
    paramString1 = new dnj();
    localcmf = new cmf();
    localcmf.aEE(paramString2);
    paramString1.EsS = localcmf;
    paramString2 = new dnj();
    localcmf = new cmf();
    localcmf.aEE(paramString3);
    paramString2.EsS = localcmf;
    paramString3 = new dnj();
    localcmf = new cmf();
    localcmf.aEE(paramString4);
    paramString3.EsS = localcmf;
    paramString4 = new dnj();
    localcmf = new cmf();
    localcmf.aEE(paramString5);
    paramString4.EsS = localcmf;
    ((dnk)localObject).EBT = localdnj;
    ((dnk)localObject).EDZ = paramString1;
    ((dnk)localObject).EDY = paramString2;
    ((dnk)localObject).EEa = paramString3;
    ((dnk)localObject).EEb = paramString4;
    c.Logd("MicroMsg.NetSceneVoipStatReport", "natReportList length:" + paramArrayOfString1.length);
    paramString1 = new LinkedList();
    int i = 0;
    while (i < paramArrayOfString1.length)
    {
      paramString1.add(new cmf().aEE(paramArrayOfString1[i]));
      i += 1;
    }
    ((dnk)localObject).EEc = paramString1.size();
    ((dnk)localObject).EEd = paramString1;
    paramString1 = new LinkedList();
    i = 0;
    while (i < paramArrayOfString2.length)
    {
      paramString1.add(new cmf().aEE(paramArrayOfString2[i]));
      i += 1;
    }
    ((dnk)localObject).Dcs = paramString1.size();
    ((dnk)localObject).EEe = paramString1;
    paramString1 = new LinkedList();
    i = 0;
    while (i < paramArrayOfString3.length)
    {
      paramString1.add(new cmf().aEE(paramArrayOfString3[i]));
      i += 1;
    }
    ((dnk)localObject).Eee = paramString1.size();
    ((dnk)localObject).EEf = paramString1;
    paramString1 = new LinkedList();
    i = 0;
    while (i < paramArrayOfString4.length)
    {
      paramString1.add(new cmf().aEE(paramArrayOfString4[i]));
      i += 1;
    }
    ((dnk)localObject).EEg = paramString1.size();
    ((dnk)localObject).EEh = paramString1;
    AppMethodBeat.o(115253);
  }
  
  public final g dVg()
  {
    AppMethodBeat.i(115254);
    g local1 = new g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(115252);
        c.Logd("MicroMsg.NetSceneVoipStatReport", "onSceneEnd type:" + paramAnonymousn.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.l
 * JD-Core Version:    0.7.0.1
 */