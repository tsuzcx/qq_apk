package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.cti;
import com.tencent.mm.protocal.protobuf.ctj;
import com.tencent.mm.protocal.protobuf.ctk;
import java.util.LinkedList;

public final class l
  extends n<ctj, ctk>
{
  public l(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String[] paramArrayOfString)
  {
    AppMethodBeat.i(4733);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new ctj();
    ((b.a)localObject).fsY = new ctk();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipstatreport";
    ((b.a)localObject).funcId = 320;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (ctj)this.rr.fsV.fta;
    cti localcti = new cti();
    bwc localbwc = new bwc();
    localbwc.aoF(paramString1);
    localcti.xTE = localbwc;
    paramString1 = new cti();
    localbwc = new bwc();
    localbwc.aoF(paramString2);
    paramString1.xTE = localbwc;
    paramString2 = new cti();
    localbwc = new bwc();
    localbwc.aoF(paramString3);
    paramString2.xTE = localbwc;
    paramString3 = new cti();
    localbwc = new bwc();
    localbwc.aoF(paramString4);
    paramString3.xTE = localbwc;
    paramString4 = new cti();
    localbwc = new bwc();
    localbwc.aoF(paramString5);
    paramString4.xTE = localbwc;
    ((ctj)localObject).yaW = localcti;
    ((ctj)localObject).ycx = paramString1;
    ((ctj)localObject).ycw = paramString2;
    ((ctj)localObject).ycy = paramString3;
    ((ctj)localObject).ycz = paramString4;
    a.Logd("MicroMsg.NetSceneVoipStatReport", "natReportList length:" + paramArrayOfString.length);
    paramString1 = new LinkedList();
    while (i < paramArrayOfString.length)
    {
      paramString1.add(new bwc().aoF(paramArrayOfString[i]));
      i += 1;
    }
    ((ctj)localObject).ycA = paramString1.size();
    ((ctj)localObject).ycB = paramString1;
    AppMethodBeat.o(4733);
  }
  
  public final f cOp()
  {
    AppMethodBeat.i(4734);
    l.1 local1 = new l.1(this);
    AppMethodBeat.o(4734);
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