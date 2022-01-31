package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.cfx;
import com.tencent.mm.protocal.c.cfy;
import com.tencent.mm.protocal.c.cfz;
import java.util.LinkedList;

public final class l
  extends n<cfy, cfz>
{
  public l(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String[] paramArrayOfString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new cfy();
    ((b.a)localObject).ecI = new cfz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipstatreport";
    ((b.a)localObject).ecG = 320;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (cfy)this.dmK.ecE.ecN;
    cfx localcfx = new cfx();
    bml localbml = new bml();
    localbml.YI(paramString1);
    localcfx.tNi = localbml;
    paramString1 = new cfx();
    localbml = new bml();
    localbml.YI(paramString2);
    paramString1.tNi = localbml;
    paramString2 = new cfx();
    localbml = new bml();
    localbml.YI(paramString3);
    paramString2.tNi = localbml;
    paramString3 = new cfx();
    localbml = new bml();
    localbml.YI(paramString4);
    paramString3.tNi = localbml;
    paramString4 = new cfx();
    localbml = new bml();
    localbml.YI(paramString5);
    paramString4.tNi = localbml;
    ((cfy)localObject).tTF = localcfx;
    ((cfy)localObject).tVg = paramString1;
    ((cfy)localObject).tVf = paramString2;
    ((cfy)localObject).tVh = paramString3;
    ((cfy)localObject).tVi = paramString4;
    a.Logd("MicroMsg.NetSceneVoipStatReport", "natReportList length:" + paramArrayOfString.length);
    paramString1 = new LinkedList();
    while (i < paramArrayOfString.length)
    {
      paramString1.add(new bml().YI(paramArrayOfString[i]));
      i += 1;
    }
    ((cfy)localObject).tVj = paramString1.size();
    ((cfy)localObject).tVk = paramString1;
  }
  
  public final f bRy()
  {
    return new l.1(this);
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