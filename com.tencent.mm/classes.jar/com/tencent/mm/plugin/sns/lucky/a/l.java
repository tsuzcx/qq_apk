package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.modelsns.h;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.model.a;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.crk;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.dgn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.math.BigInteger;

public final class l
  implements cd.a
{
  private static String az(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95188);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)) || (bt.isNullOrNil(paramString3)))
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
    if ((parama == null) || (parama.gqE == null) || (parama.gqE.Fvk == null))
    {
      ad.i("MicroMsg.SimpleExperimentLsn", "recv null msg");
      AppMethodBeat.o(95187);
      return;
    }
    Object localObject1 = z.a(parama.gqE.Fvk);
    ad.d("MicroMsg.SimpleExperimentLsn", "recv addMsg ".concat(String.valueOf(localObject1)));
    parama = az((String)localObject1, "<TimelineObject", "</TimelineObject>");
    if (bt.isNullOrNil(parama))
    {
      ad.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  timelineObj tag");
      AppMethodBeat.o(95187);
      return;
    }
    String str = az((String)localObject1, "<RecXml", "</RecXml>");
    if (bt.isNullOrNil(str))
    {
      ad.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  RecXml tag");
      AppMethodBeat.o(95187);
      return;
    }
    Object localObject2 = az((String)localObject1, "<ADInfo", "</ADInfo>");
    if (bt.isNullOrNil((String)localObject2))
    {
      ad.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  ADInfo tag");
      AppMethodBeat.o(95187);
      return;
    }
    localObject1 = h.Gx(parama);
    crk localcrk = new crk();
    localcrk.HjO = z.IX((String)localObject2);
    localObject2 = new dgn();
    localcrk.HjN = ((dgn)localObject2);
    ((dgn)localObject2).HuP = z.IX(str);
    SnsObject localSnsObject = new SnsObject();
    localSnsObject.Id = new BigInteger(((TimeLineObject)localObject1).Id).longValue();
    localSnsObject.CreateTime = ((TimeLineObject)localObject1).CreateTime;
    localSnsObject.Username = ((TimeLineObject)localObject1).nDo;
    localSnsObject.ObjectDesc = z.al(parama.getBytes());
    ((dgn)localObject2).Htv = localSnsObject;
    a.b(localcrk);
    boolean bool = j.axQ(str);
    parama = new com.tencent.mm.plugin.sns.storage.b(str);
    ad.i("MicroMsg.SimpleExperimentLsn", "isUsePreferedInfo=" + bool + ", adXml.usePreferedInfo" + parama.zws);
    com.tencent.mm.plugin.sns.ad.timeline.a.b.a((TimeLineObject)localObject1, parama, 2);
    AppMethodBeat.o(95187);
  }
  
  public final void a(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.l
 * JD-Core Version:    0.7.0.1
 */