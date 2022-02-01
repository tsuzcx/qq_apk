package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.modelsns.h;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.model.a;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cse;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.dhh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.math.BigInteger;

public final class l
  implements cf.a
{
  private static String az(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95188);
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)) || (bu.isNullOrNil(paramString3)))
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
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(95187);
    if ((parama == null) || (parama.gte == null) || (parama.gte.FNI == null))
    {
      ae.i("MicroMsg.SimpleExperimentLsn", "recv null msg");
      AppMethodBeat.o(95187);
      return;
    }
    Object localObject1 = z.a(parama.gte.FNI);
    ae.d("MicroMsg.SimpleExperimentLsn", "recv addMsg ".concat(String.valueOf(localObject1)));
    parama = az((String)localObject1, "<TimelineObject", "</TimelineObject>");
    if (bu.isNullOrNil(parama))
    {
      ae.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  timelineObj tag");
      AppMethodBeat.o(95187);
      return;
    }
    String str = az((String)localObject1, "<RecXml", "</RecXml>");
    if (bu.isNullOrNil(str))
    {
      ae.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  RecXml tag");
      AppMethodBeat.o(95187);
      return;
    }
    Object localObject2 = az((String)localObject1, "<ADInfo", "</ADInfo>");
    if (bu.isNullOrNil((String)localObject2))
    {
      ae.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  ADInfo tag");
      AppMethodBeat.o(95187);
      return;
    }
    localObject1 = h.GZ(parama);
    cse localcse = new cse();
    localcse.HDo = z.Jw((String)localObject2);
    localObject2 = new dhh();
    localcse.HDn = ((dhh)localObject2);
    ((dhh)localObject2).HOs = z.Jw(str);
    SnsObject localSnsObject = new SnsObject();
    localSnsObject.Id = new BigInteger(((TimeLineObject)localObject1).Id).longValue();
    localSnsObject.CreateTime = ((TimeLineObject)localObject1).CreateTime;
    localSnsObject.Username = ((TimeLineObject)localObject1).nIJ;
    localSnsObject.ObjectDesc = z.al(parama.getBytes());
    ((dhh)localObject2).HMY = localSnsObject;
    a.b(localcse);
    boolean bool = k.azh(str);
    parama = new b(str);
    ae.i("MicroMsg.SimpleExperimentLsn", "isUsePreferedInfo=" + bool + ", adXml.usePreferedInfo" + parama.zNN);
    d.a((TimeLineObject)localObject1, parama, 2);
    AppMethodBeat.o(95187);
  }
  
  public final void a(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.l
 * JD-Core Version:    0.7.0.1
 */