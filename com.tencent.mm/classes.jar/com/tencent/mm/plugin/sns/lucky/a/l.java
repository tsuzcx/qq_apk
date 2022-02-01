package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.ad.timeline.b.e;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.model.a;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.protocal.protobuf.eaq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.math.BigInteger;
import java.util.LinkedList;

public final class l
  implements cj.a
{
  private static String aK(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95188);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString3)))
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
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(95187);
    if ((parama == null) || (parama.heO == null) || (parama.heO.KHn == null))
    {
      Log.i("MicroMsg.SimpleExperimentLsn", "recv null msg");
      AppMethodBeat.o(95187);
      return;
    }
    parama = z.a(parama.heO.KHn);
    Log.d("MicroMsg.SimpleExperimentLsn", "recv addMsg ".concat(String.valueOf(parama)));
    Object localObject1 = aK(parama, "<TimelineObject", "</TimelineObject>");
    if (Util.isNullOrNil((String)localObject1))
    {
      Log.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  timelineObj tag");
      AppMethodBeat.o(95187);
      return;
    }
    String str = aK(parama, "<RecXml", "</RecXml>");
    if (Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  RecXml tag");
      AppMethodBeat.o(95187);
      return;
    }
    Object localObject2 = aK(parama, "<ADInfo", "</ADInfo>");
    if (Util.isNullOrNil((String)localObject2))
    {
      Log.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  ADInfo tag");
      AppMethodBeat.o(95187);
      return;
    }
    parama = n.PM((String)localObject1);
    dkg localdkg = new dkg();
    localdkg.MOg = z.Su((String)localObject2);
    localObject2 = new eaq();
    localdkg.MOf = ((eaq)localObject2);
    ((eaq)localObject2).Nad = z.Su(str);
    SnsObject localSnsObject = new SnsObject();
    localSnsObject.Id = new BigInteger(parama.Id).longValue();
    localSnsObject.CreateTime = parama.CreateTime;
    localSnsObject.Username = parama.UserName;
    localSnsObject.ObjectDesc = z.aC(((String)localObject1).getBytes());
    ((eaq)localObject2).MYH = localSnsObject;
    a.b(localdkg);
    boolean bool = k.aOd(str);
    localObject1 = new ADXml(str);
    Log.i("MicroMsg.SimpleExperimentLsn", "isUsePreferedInfo=" + bool + ", adXml.usePreferedInfo" + ((ADXml)localObject1).usePreferedInfo);
    try
    {
      if ((parama.ContentObj.LoV != null) && (parama.ContentObj.LoV.size() > 0)) {
        ((cnb)parama.ContentObj.LoV.get(0)).isAd = true;
      }
      e.a(parama, (ADXml)localObject1, 2);
      AppMethodBeat.o(95187);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.i("MicroMsg.SimpleExperimentLsn", "onRecieveMsg, exp=" + localException.toString());
      }
    }
  }
  
  public final void a(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.l
 * JD-Core Version:    0.7.0.1
 */