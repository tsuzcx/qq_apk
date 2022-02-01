package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cmj;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.protocal.protobuf.dba;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.math.BigInteger;

public final class l
  implements cc.a
{
  private static String as(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95188);
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)) || (bs.isNullOrNil(paramString3)))
    {
      AppMethodBeat.o(95188);
      return "";
    }
    int j = paramString1.indexOf(paramString2);
    if (j >= 0) {}
    for (int i = paramString1.indexOf(paramString3); (j >= 0) && (i > j); i = -1)
    {
      paramString1 = paramString1.substring(j, i + paramString3.length());
      AppMethodBeat.o(95188);
      return paramString1;
    }
    AppMethodBeat.o(95188);
    return "";
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(95187);
    if ((parama == null) || (parama.fXi == null) || (parama.fXi.DPV == null))
    {
      ac.i("MicroMsg.SimpleExperimentLsn", "recv null msg");
      AppMethodBeat.o(95187);
      return;
    }
    Object localObject1 = z.a(parama.fXi.DPV);
    ac.d("MicroMsg.SimpleExperimentLsn", "recv addMsg ".concat(String.valueOf(localObject1)));
    parama = as((String)localObject1, "<TimelineObject", "</TimelineObject>");
    if (bs.isNullOrNil(parama))
    {
      ac.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  timelineObj tag");
      AppMethodBeat.o(95187);
      return;
    }
    String str = as((String)localObject1, "<RecXml", "</RecXml>");
    if (bs.isNullOrNil(str))
    {
      ac.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  RecXml tag");
      AppMethodBeat.o(95187);
      return;
    }
    Object localObject2 = as((String)localObject1, "<ADInfo", "</ADInfo>");
    if (bs.isNullOrNil((String)localObject2))
    {
      ac.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  ADInfo tag");
      AppMethodBeat.o(95187);
      return;
    }
    com.tencent.mm.plugin.sns.waid.g.awf((String)localObject2);
    localObject1 = com.tencent.mm.modelsns.g.Ds(parama);
    cmj localcmj = new cmj();
    localcmj.FzG = z.FI((String)localObject2);
    localObject2 = new dba();
    localcmj.FzF = ((dba)localObject2);
    ((dba)localObject2).FKh = z.FI(str);
    SnsObject localSnsObject = new SnsObject();
    localSnsObject.Id = new BigInteger(((TimeLineObject)localObject1).Id).longValue();
    localSnsObject.CreateTime = ((TimeLineObject)localObject1).CreateTime;
    localSnsObject.Username = ((TimeLineObject)localObject1).ncR;
    localSnsObject.ObjectDesc = z.al(parama.getBytes());
    ((dba)localObject2).FIN = localSnsObject;
    com.tencent.mm.plugin.sns.model.a.b(localcmj);
    com.tencent.mm.plugin.sns.ad.timeline.a.a.a((TimeLineObject)localObject1, new b(str), 2);
    AppMethodBeat.o(95187);
  }
  
  public final void a(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.l
 * JD-Core Version:    0.7.0.1
 */