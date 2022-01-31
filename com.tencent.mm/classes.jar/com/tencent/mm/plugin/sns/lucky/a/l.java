package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.sns.model.a;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bsc;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.math.BigInteger;

public final class l
  implements bz.a
{
  private static String af(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(35891);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)) || (bo.isNullOrNil(paramString3)))
    {
      AppMethodBeat.o(35891);
      return "";
    }
    int j = paramString1.indexOf(paramString2);
    if (j >= 0) {}
    for (int i = paramString1.indexOf(paramString3); (j >= 0) && (i > j); i = -1)
    {
      paramString1 = paramString1.substring(j, i + paramString3.length());
      AppMethodBeat.o(35891);
      return paramString1;
    }
    AppMethodBeat.o(35891);
    return "";
  }
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(35890);
    if ((parama == null) || (parama.eyJ == null) || (parama.eyJ.woR == null))
    {
      ab.i("MicroMsg.SimpleExperimentLsn", "recv null msg");
      AppMethodBeat.o(35890);
      return;
    }
    Object localObject2 = aa.a(parama.eyJ.woR);
    ab.d("MicroMsg.SimpleExperimentLsn", "recv addMsg ".concat(String.valueOf(localObject2)));
    parama = af((String)localObject2, "<TimelineObject", "</TimelineObject>");
    if (bo.isNullOrNil(parama))
    {
      ab.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  timelineObj tag");
      AppMethodBeat.o(35890);
      return;
    }
    Object localObject1 = af((String)localObject2, "<RecXml", "</RecXml>");
    if (bo.isNullOrNil((String)localObject1))
    {
      ab.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  RecXml tag");
      AppMethodBeat.o(35890);
      return;
    }
    Object localObject3 = af((String)localObject2, "<ADInfo", "</ADInfo>");
    if (bo.isNullOrNil((String)localObject3))
    {
      ab.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  ADInfo tag");
      AppMethodBeat.o(35890);
      return;
    }
    localObject2 = e.uA(parama);
    bsc localbsc = new bsc();
    localbsc.xFB = aa.wA((String)localObject3);
    localObject3 = new cer();
    localbsc.xFA = ((cer)localObject3);
    ((cer)localObject3).xPc = aa.wA((String)localObject1);
    localObject1 = new SnsObject();
    ((SnsObject)localObject1).Id = new BigInteger(((TimeLineObject)localObject2).Id).longValue();
    ((SnsObject)localObject1).CreateTime = ((TimeLineObject)localObject2).CreateTime;
    ((SnsObject)localObject1).Username = ((TimeLineObject)localObject2).jJA;
    ((SnsObject)localObject1).ObjectDesc = aa.ac(parama.getBytes());
    ((cer)localObject3).xNM = ((SnsObject)localObject1);
    a.b(localbsc);
    AppMethodBeat.o(35890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.l
 * JD-Core Version:    0.7.0.1
 */