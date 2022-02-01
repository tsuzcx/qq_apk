package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.model.a;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.cvo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.math.BigInteger;

public final class l
  implements cc.a
{
  private static String aq(String paramString1, String paramString2, String paramString3)
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
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(95187);
    if ((parama == null) || (parama.fTo == null) || (parama.fTo.Cxz == null))
    {
      ad.i("MicroMsg.SimpleExperimentLsn", "recv null msg");
      AppMethodBeat.o(95187);
      return;
    }
    Object localObject2 = z.a(parama.fTo.Cxz);
    ad.d("MicroMsg.SimpleExperimentLsn", "recv addMsg ".concat(String.valueOf(localObject2)));
    parama = aq((String)localObject2, "<TimelineObject", "</TimelineObject>");
    if (bt.isNullOrNil(parama))
    {
      ad.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  timelineObj tag");
      AppMethodBeat.o(95187);
      return;
    }
    Object localObject1 = aq((String)localObject2, "<RecXml", "</RecXml>");
    if (bt.isNullOrNil((String)localObject1))
    {
      ad.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  RecXml tag");
      AppMethodBeat.o(95187);
      return;
    }
    Object localObject3 = aq((String)localObject2, "<ADInfo", "</ADInfo>");
    if (bt.isNullOrNil((String)localObject3))
    {
      ad.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  ADInfo tag");
      AppMethodBeat.o(95187);
      return;
    }
    com.tencent.mm.plugin.sns.waid.g.aqW((String)localObject3);
    localObject2 = com.tencent.mm.modelsns.g.zn(parama);
    chg localchg = new chg();
    localchg.EcL = z.BE((String)localObject3);
    localObject3 = new cvo();
    localchg.EcK = ((cvo)localObject3);
    ((cvo)localObject3).Eni = z.BE((String)localObject1);
    localObject1 = new SnsObject();
    ((SnsObject)localObject1).Id = new BigInteger(((TimeLineObject)localObject2).Id).longValue();
    ((SnsObject)localObject1).CreateTime = ((TimeLineObject)localObject2).CreateTime;
    ((SnsObject)localObject1).Username = ((TimeLineObject)localObject2).mAQ;
    ((SnsObject)localObject1).ObjectDesc = z.am(parama.getBytes());
    ((cvo)localObject3).ElO = ((SnsObject)localObject1);
    a.b(localchg);
    j.d((TimeLineObject)localObject2);
    AppMethodBeat.o(95187);
  }
  
  public final void a(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.l
 * JD-Core Version:    0.7.0.1
 */