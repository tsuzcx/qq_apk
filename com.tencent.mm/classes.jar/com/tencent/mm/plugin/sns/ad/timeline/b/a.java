package com.tencent.mm.plugin.sns.ad.timeline.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class a
{
  public static boolean a(ADXml paramADXml)
  {
    boolean bool = false;
    AppMethodBeat.i(202199);
    if (paramADXml != null)
    {
      if (paramADXml.videoPlayInStreamingMode > 0) {
        bool = true;
      }
      Log.d("SnsAd.OnlinePlayerSwitchHelper", "enableOnlineVideoFeatureInAdXml return ".concat(String.valueOf(bool)));
      AppMethodBeat.o(202199);
      return bool;
    }
    Log.d("SnsAd.OnlinePlayerSwitchHelper", "enableOnlineVideoFeatureInAdXml : the adxml is null, so return false");
    AppMethodBeat.o(202199);
    return false;
  }
  
  public static boolean a(TimeLineObject paramTimeLineObject, ADXml paramADXml)
  {
    AppMethodBeat.i(202197);
    if ((c(paramTimeLineObject)) && (a(paramADXml)))
    {
      if (eXT())
      {
        if ((paramADXml != null) && (!paramADXml.isCardAd()) && (!paramADXml.isFullCardAd()) && (!paramADXml.isSphereCardAd())) {}
        for (int i = 1; i != 0; i = 0)
        {
          Log.i("SnsAd.OnlinePlayerSwitchHelper", "the normal video preload is disable, because the online normal video preload is enable!");
          AppMethodBeat.o(202197);
          return true;
        }
      }
      if ((eXU()) && (paramADXml.isCardAd()))
      {
        Log.i("SnsAd.OnlinePlayerSwitchHelper", "the base card ad video preload is disable, because the online base card prload is enable!");
        AppMethodBeat.o(202197);
        return true;
      }
      Log.i("SnsAd.OnlinePlayerSwitchHelper", "the ad video preload is not disable!");
    }
    AppMethodBeat.o(202197);
    return false;
  }
  
  public static boolean c(TimeLineObject paramTimeLineObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramTimeLineObject != null)
    {
      bool1 = bool2;
      if (paramTimeLineObject.ContentObj != null)
      {
        bool1 = bool2;
        if (paramTimeLineObject.ContentObj.LoU == 15) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean eXT()
  {
    AppMethodBeat.i(202195);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPi, 0);
      Log.i("SnsAd.OnlinePlayerSwitchHelper", "useOnlineVideoInNormalTimeline value is ".concat(String.valueOf(i)));
      if (i > 0)
      {
        AppMethodBeat.o(202195);
        return true;
      }
      AppMethodBeat.o(202195);
      return false;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202195);
    }
    return false;
  }
  
  public static boolean eXU()
  {
    AppMethodBeat.i(202196);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPh, 0);
      Log.i("SnsAd.OnlinePlayerSwitchHelper", "useOnlineVideoInBaseCardTimeline value is  ".concat(String.valueOf(i)));
      if (i > 0)
      {
        AppMethodBeat.o(202196);
        return true;
      }
      AppMethodBeat.o(202196);
      return false;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202196);
    }
    return false;
  }
  
  public static boolean n(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(202198);
    if (paramSnsInfo == null)
    {
      Log.w("SnsAd.OnlinePlayerSwitchHelper", "enableOnlineVideoPreload: the snsInfo is null!!");
      AppMethodBeat.o(202198);
      return false;
    }
    if (!paramSnsInfo.isAd())
    {
      Log.w("SnsAd.OnlinePlayerSwitchHelper", "enableOnlineVideoPreload: the snsInfo is not ad!!");
      AppMethodBeat.o(202198);
      return false;
    }
    TimeLineObject localTimeLineObject = paramSnsInfo.getTimeLine();
    paramSnsInfo = paramSnsInfo.getAdXml();
    boolean bool = a(localTimeLineObject, paramSnsInfo);
    if (bool) {}
    try
    {
      if ((localTimeLineObject.ContentObj != null) && (localTimeLineObject.ContentObj.LoV.size() > 0))
      {
        cnb localcnb = (cnb)localTimeLineObject.ContentObj.LoV.get(0);
        Log.i("SnsAd.OnlinePlayerSwitchHelper", "AdH265Helper, enableAdOnlineVideoPreload, snsId=" + localTimeLineObject.Id);
        com.tencent.mm.plugin.sns.ad.e.b.a(paramSnsInfo, localcnb, localTimeLineObject.Id);
      }
      AppMethodBeat.o(202198);
      return bool;
    }
    catch (Throwable paramSnsInfo)
    {
      for (;;)
      {
        Log.e("SnsAd.OnlinePlayerSwitchHelper", "AdH265Helper, enableAdOnlineVideoPreload exp=" + paramSnsInfo.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.a
 * JD-Core Version:    0.7.0.1
 */