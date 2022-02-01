package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.eus;
import com.tencent.mm.protocal.protobuf.eut;
import com.tencent.mm.protocal.protobuf.euu;
import java.util.LinkedList;

public final class l
  extends n<eut, euu>
{
  public l(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String[] paramArrayOfString4)
  {
    AppMethodBeat.i(115253);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new eut();
    ((d.a)localObject).iLO = new euu();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voipstatreport";
    ((d.a)localObject).funcId = 320;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (eut)this.rr.iLK.iLR;
    eus localeus = new eus();
    dqi localdqi = new dqi();
    localdqi.bhy(paramString1);
    localeus.NgE = localdqi;
    paramString1 = new eus();
    localdqi = new dqi();
    localdqi.bhy(paramString2);
    paramString1.NgE = localdqi;
    paramString2 = new eus();
    localdqi = new dqi();
    localdqi.bhy(paramString3);
    paramString2.NgE = localdqi;
    paramString3 = new eus();
    localdqi = new dqi();
    localdqi.bhy(paramString4);
    paramString3.NgE = localdqi;
    paramString4 = new eus();
    localdqi = new dqi();
    localdqi.bhy(paramString5);
    paramString4.NgE = localdqi;
    ((eut)localObject).NqI = localeus;
    ((eut)localObject).NsO = paramString1;
    ((eut)localObject).NsN = paramString2;
    ((eut)localObject).NsP = paramString3;
    ((eut)localObject).NsQ = paramString4;
    e.Logd("MicroMsg.NetSceneVoipStatReport", "natReportList length:" + paramArrayOfString1.length);
    paramString1 = new LinkedList();
    int i = 0;
    while (i < paramArrayOfString1.length)
    {
      paramString1.add(new dqi().bhy(paramArrayOfString1[i]));
      i += 1;
    }
    ((eut)localObject).NsR = paramString1.size();
    ((eut)localObject).NsS = paramString1;
    paramString1 = new LinkedList();
    i = 0;
    while (i < paramArrayOfString2.length)
    {
      paramString1.add(new dqi().bhy(paramArrayOfString2[i]));
      i += 1;
    }
    ((eut)localObject).Lri = paramString1.size();
    ((eut)localObject).NsT = paramString1;
    paramString1 = new LinkedList();
    i = 0;
    while (i < paramArrayOfString3.length)
    {
      paramString1.add(new dqi().bhy(paramArrayOfString3[i]));
      i += 1;
    }
    ((eut)localObject).MPZ = paramString1.size();
    ((eut)localObject).NsU = paramString1;
    paramString1 = new LinkedList();
    i = 0;
    while (i < paramArrayOfString4.length)
    {
      paramString1.add(new dqi().bhy(paramArrayOfString4[i]));
      i += 1;
    }
    ((eut)localObject).NsV = paramString1.size();
    ((eut)localObject).NsW = paramString1;
    AppMethodBeat.o(115253);
  }
  
  public final i fIF()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.l
 * JD-Core Version:    0.7.0.1
 */