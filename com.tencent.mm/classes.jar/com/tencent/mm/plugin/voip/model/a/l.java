package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.gbp;
import com.tencent.mm.protocal.protobuf.gbq;
import com.tencent.mm.protocal.protobuf.gbr;
import java.util.LinkedList;

public final class l
  extends n<gbq, gbr>
{
  public l(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String[] paramArrayOfString4)
  {
    AppMethodBeat.i(115253);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new gbq();
    ((c.a)localObject).otF = new gbr();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/voipstatreport";
    ((c.a)localObject).funcId = 320;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    c.b.b(this.rr.otB);
    localObject = (gbq)c.b.b(this.rr.otB);
    gbp localgbp = new gbp();
    etl localetl = new etl();
    localetl.btH(paramString1);
    localgbp.abMp = localetl;
    paramString1 = new gbp();
    localetl = new etl();
    localetl.btH(paramString2);
    paramString1.abMp = localetl;
    paramString2 = new gbp();
    localetl = new etl();
    localetl.btH(paramString3);
    paramString2.abMp = localetl;
    paramString3 = new gbp();
    localetl = new etl();
    localetl.btH(paramString4);
    paramString3.abMp = localetl;
    paramString4 = new gbp();
    localetl = new etl();
    localetl.btH(paramString5);
    paramString4.abMp = localetl;
    ((gbq)localObject).abXP = localgbp;
    ((gbq)localObject).abZV = paramString1;
    ((gbq)localObject).abZU = paramString2;
    ((gbq)localObject).abZW = paramString3;
    ((gbq)localObject).abZX = paramString4;
    g.Logd("MicroMsg.NetSceneVoipStatReport", "natReportList length:" + paramArrayOfString1.length);
    paramString1 = new LinkedList();
    int i = 0;
    while (i < paramArrayOfString1.length)
    {
      paramString1.add(new etl().btH(paramArrayOfString1[i]));
      i += 1;
    }
    ((gbq)localObject).abZY = paramString1.size();
    ((gbq)localObject).abZZ = paramString1;
    paramString1 = new LinkedList();
    i = 0;
    while (i < paramArrayOfString2.length)
    {
      paramString1.add(new etl().btH(paramArrayOfString2[i]));
      i += 1;
    }
    ((gbq)localObject).ZrN = paramString1.size();
    ((gbq)localObject).acaa = paramString1;
    paramString1 = new LinkedList();
    i = 0;
    while (i < paramArrayOfString3.length)
    {
      paramString1.add(new etl().btH(paramArrayOfString3[i]));
      i += 1;
    }
    ((gbq)localObject).abtq = paramString1.size();
    ((gbq)localObject).acab = paramString1;
    paramString1 = new LinkedList();
    i = 0;
    while (i < paramArrayOfString4.length)
    {
      paramString1.add(new etl().btH(paramArrayOfString4[i]));
      i += 1;
    }
    ((gbq)localObject).acac = paramString1.size();
    ((gbq)localObject).acad = paramString1;
    AppMethodBeat.o(115253);
  }
  
  public final int getType()
  {
    return 320;
  }
  
  public final h hYT()
  {
    AppMethodBeat.i(115254);
    h local1 = new h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(115252);
        g.Logd("MicroMsg.NetSceneVoipStatReport", "onSceneEnd type:" + paramAnonymousp.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
        AppMethodBeat.o(115252);
      }
    };
    AppMethodBeat.o(115254);
    return local1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.l
 * JD-Core Version:    0.7.0.1
 */