package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.ad.timeline.b.f;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.model.a;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.dtv;
import com.tencent.mm.protocal.protobuf.ekq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.math.BigInteger;
import java.util.LinkedList;

public final class l
  implements ck.a
{
  private static String aE(String paramString1, String paramString2, String paramString3)
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
    if ((parama == null) || (parama.jQG == null) || (parama.jQG.RIF == null))
    {
      Log.i("MicroMsg.SimpleExperimentLsn", "recv null msg");
      AppMethodBeat.o(95187);
      return;
    }
    parama = z.a(parama.jQG.RIF);
    Log.d("MicroMsg.SimpleExperimentLsn", "recv addMsg ".concat(String.valueOf(parama)));
    Object localObject1 = aE(parama, "<TimelineObject", "</TimelineObject>");
    if (Util.isNullOrNil((String)localObject1))
    {
      Log.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  timelineObj tag");
      AppMethodBeat.o(95187);
      return;
    }
    String str = aE(parama, "<RecXml", "</RecXml>");
    if (Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  RecXml tag");
      AppMethodBeat.o(95187);
      return;
    }
    Object localObject2 = aE(parama, "<ADInfo", "</ADInfo>");
    if (Util.isNullOrNil((String)localObject2))
    {
      Log.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  ADInfo tag");
      AppMethodBeat.o(95187);
      return;
    }
    parama = o.Xk((String)localObject1);
    dtv localdtv = new dtv();
    localdtv.TZZ = z.ZW((String)localObject2);
    localObject2 = new ekq();
    localdtv.TZY = ((ekq)localObject2);
    ((ekq)localObject2).Umx = z.ZW(str);
    SnsObject localSnsObject = new SnsObject();
    localSnsObject.Id = new BigInteger(parama.Id).longValue();
    localSnsObject.CreateTime = parama.CreateTime;
    localSnsObject.Username = parama.UserName;
    localSnsObject.ObjectDesc = z.aN(((String)localObject1).getBytes());
    ((ekq)localObject2).Ulb = localSnsObject;
    a.b(localdtv);
    boolean bool = m.aYV(str);
    localObject1 = new ADXml(str);
    Log.i("MicroMsg.SimpleExperimentLsn", "isUsePreferedInfo=" + bool + ", adXml.usePreferedInfo" + ((ADXml)localObject1).usePreferedInfo);
    try
    {
      if ((parama.ContentObj.Sqr != null) && (parama.ContentObj.Sqr.size() > 0)) {
        ((cvt)parama.ContentObj.Sqr.get(0)).isAd = true;
      }
      f.a(parama, (ADXml)localObject1, 2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.l
 * JD-Core Version:    0.7.0.1
 */