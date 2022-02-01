package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.sns.ad.timeline.helper.h;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.model.a;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.emq;
import com.tencent.mm.protocal.protobuf.fey;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.math.BigInteger;
import java.util.LinkedList;

public final class l
  implements cl.a
{
  private static String aU(String paramString1, String paramString2, String paramString3)
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
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(95187);
    if ((parama == null) || (parama.mpN == null) || (parama.mpN.YFG == null))
    {
      Log.i("MicroMsg.SimpleExperimentLsn", "recv null msg");
      AppMethodBeat.o(95187);
      return;
    }
    parama = w.a(parama.mpN.YFG);
    Log.d("MicroMsg.SimpleExperimentLsn", "recv addMsg ".concat(String.valueOf(parama)));
    Object localObject1 = aU(parama, "<TimelineObject", "</TimelineObject>");
    if (Util.isNullOrNil((String)localObject1))
    {
      Log.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  timelineObj tag");
      AppMethodBeat.o(95187);
      return;
    }
    Object localObject2 = aU(parama, "<RecXml", "</RecXml>");
    if (Util.isNullOrNil((String)localObject2))
    {
      Log.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  RecXml tag");
      AppMethodBeat.o(95187);
      return;
    }
    String str = aU(parama, "<ADInfo", "</ADInfo>");
    if (Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  ADInfo tag");
      AppMethodBeat.o(95187);
      return;
    }
    parama = o.Pm((String)localObject1);
    emq localemq = new emq();
    localemq.abqW = w.Sk(str);
    fey localfey = new fey();
    localemq.abqV = localfey;
    localfey.abEE = w.Sk((String)localObject2);
    SnsObject localSnsObject = new SnsObject();
    localSnsObject.Id = new BigInteger(parama.Id).longValue();
    localSnsObject.CreateTime = parama.CreateTime;
    localSnsObject.Username = parama.UserName;
    localSnsObject.ObjectDesc = w.aN(((String)localObject1).getBytes());
    localfey.abCS = localSnsObject;
    a.b(localemq);
    boolean bool = m.aXg((String)localObject2);
    localObject1 = new ADXml((String)localObject2);
    localObject2 = new ADInfo(str);
    Log.i("MicroMsg.SimpleExperimentLsn", "isUsePreferedInfo=" + bool + ", adXml.usePreferedInfo" + ((ADXml)localObject1).usePreferedInfo);
    try
    {
      if ((parama.ContentObj.Zpr != null) && (parama.ContentObj.Zpr.size() > 0)) {
        ((dmz)parama.ContentObj.Zpr.get(0)).isAd = true;
      }
      h.a(parama, (ADXml)localObject1, (ADInfo)localObject2, 2);
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
  
  public final void a(g.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.l
 * JD-Core Version:    0.7.0.1
 */