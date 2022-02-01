package com.tencent.mm.plugin.sns.ad.timeline.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.ad.c;
import com.tencent.mm.plugin.sns.ad.d.d;
import com.tencent.mm.plugin.sns.ad.timeline.c.b.a;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class b
{
  public static boolean a(ADXml paramADXml)
  {
    boolean bool = false;
    AppMethodBeat.i(228063);
    if (paramADXml != null)
    {
      if (paramADXml.videoPlayInStreamingMode > 0) {
        bool = true;
      }
      Log.d("SnsAd.OnlinePlayerSwitchHelper", "enableOnlineVideoFeatureInAdXml return ".concat(String.valueOf(bool)));
      AppMethodBeat.o(228063);
      return bool;
    }
    Log.d("SnsAd.OnlinePlayerSwitchHelper", "enableOnlineVideoFeatureInAdXml : the adxml is null, so return false");
    AppMethodBeat.o(228063);
    return false;
  }
  
  public static boolean a(TimeLineObject paramTimeLineObject, ADXml paramADXml)
  {
    AppMethodBeat.i(228052);
    boolean bool = c(paramTimeLineObject);
    if ((paramADXml != null) && (paramADXml.isFullCardAd()))
    {
      if (paramADXml.isLongPressGestureAd())
      {
        Log.i("SnsAd.OnlinePlayerSwitchHelper", "fullcard useOnlineVideoView preload false, longpressgesture offline");
        AppMethodBeat.o(228052);
        return false;
      }
      if (c.Jxs == 1)
      {
        Log.i("SnsAd.OnlinePlayerSwitchHelper", "fullcard useOnlineVideoView preload false, force offline");
        AppMethodBeat.o(228052);
        return false;
      }
      if (c.Jxs == 2)
      {
        Log.i("SnsAd.OnlinePlayerSwitchHelper", "fullcard useOnlineVideoView preload true,  force online");
        AppMethodBeat.o(228052);
        return true;
      }
    }
    if ((bool) && (a(paramADXml)))
    {
      if (fLw())
      {
        if ((paramADXml != null) && (!paramADXml.isCardAd()) && (!paramADXml.isFullCardAd()) && (!paramADXml.isSphereCardAd())) {}
        for (int i = 1; i != 0; i = 0)
        {
          Log.i("SnsAd.OnlinePlayerSwitchHelper", "the normal video preload is disable, because the online normal video preload is enable!");
          AppMethodBeat.o(228052);
          return true;
        }
      }
      if ((fLx()) && (paramADXml.isCardAd()))
      {
        Log.i("SnsAd.OnlinePlayerSwitchHelper", "the base card ad video preload is disable, because the online base card prload is enable!");
        AppMethodBeat.o(228052);
        return true;
      }
      if ((a.fLC()) && (paramADXml.isFullCardAd()) && (!paramADXml.isLongPressGestureAd()))
      {
        Log.i("SnsAd.OnlinePlayerSwitchHelper", "fullcard useOnlineVideoView preload true");
        AppMethodBeat.o(228052);
        return true;
      }
      Log.i("SnsAd.OnlinePlayerSwitchHelper", "the ad video preload is not disable!");
    }
    AppMethodBeat.o(228052);
    return false;
  }
  
  public static boolean b(ADXml paramADXml)
  {
    AppMethodBeat.i(228071);
    try
    {
      if (a(paramADXml))
      {
        boolean bool = fLw();
        if (bool)
        {
          AppMethodBeat.o(228071);
          return true;
        }
      }
    }
    catch (Throwable paramADXml)
    {
      AppMethodBeat.o(228071);
    }
    return false;
  }
  
  public static boolean b(TimeLineObject paramTimeLineObject, ADXml paramADXml)
  {
    AppMethodBeat.i(228067);
    try
    {
      if ((c(paramTimeLineObject)) && (a(paramADXml)))
      {
        boolean bool = fLx();
        if (bool)
        {
          AppMethodBeat.o(228067);
          return true;
        }
      }
    }
    catch (Throwable paramTimeLineObject)
    {
      AppMethodBeat.o(228067);
    }
    return false;
  }
  
  private static boolean c(TimeLineObject paramTimeLineObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramTimeLineObject != null)
    {
      bool1 = bool2;
      if (paramTimeLineObject.ContentObj != null)
      {
        bool1 = bool2;
        if (paramTimeLineObject.ContentObj.Sqq == 15) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static boolean fLw()
  {
    AppMethodBeat.i(228042);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvq, 0);
      Log.i("SnsAd.OnlinePlayerSwitchHelper", "useOnlineVideoInNormalTimeline value is ".concat(String.valueOf(i)));
      if (i > 0)
      {
        AppMethodBeat.o(228042);
        return true;
      }
      AppMethodBeat.o(228042);
      return false;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(228042);
    }
    return false;
  }
  
  private static boolean fLx()
  {
    AppMethodBeat.i(228045);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvp, 0);
      Log.i("SnsAd.OnlinePlayerSwitchHelper", "useOnlineVideoInBaseCardTimeline value is  ".concat(String.valueOf(i)));
      if (i > 0)
      {
        AppMethodBeat.o(228045);
        return true;
      }
      AppMethodBeat.o(228045);
      return false;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(228045);
    }
    return false;
  }
  
  public static boolean n(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(228059);
    if (paramSnsInfo == null)
    {
      Log.w("SnsAd.OnlinePlayerSwitchHelper", "enableOnlineVideoPreload: the snsInfo is null!!");
      AppMethodBeat.o(228059);
      return false;
    }
    if (!paramSnsInfo.isAd())
    {
      Log.w("SnsAd.OnlinePlayerSwitchHelper", "enableOnlineVideoPreload: the snsInfo is not ad!!");
      AppMethodBeat.o(228059);
      return false;
    }
    TimeLineObject localTimeLineObject = paramSnsInfo.getTimeLine();
    paramSnsInfo = paramSnsInfo.getAdXml();
    boolean bool = a(localTimeLineObject, paramSnsInfo);
    if (bool) {}
    try
    {
      if ((localTimeLineObject.ContentObj != null) && (localTimeLineObject.ContentObj.Sqr.size() > 0))
      {
        cvt localcvt = (cvt)localTimeLineObject.ContentObj.Sqr.get(0);
        Log.i("SnsAd.OnlinePlayerSwitchHelper", "AdH265Helper, enableAdOnlineVideoPreload, snsId=" + localTimeLineObject.Id);
        d.a(paramSnsInfo, localcvt, localTimeLineObject.Id);
      }
      AppMethodBeat.o(228059);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.b
 * JD-Core Version:    0.7.0.1
 */