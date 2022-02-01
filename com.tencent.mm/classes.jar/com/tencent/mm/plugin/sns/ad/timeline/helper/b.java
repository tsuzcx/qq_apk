package com.tencent.mm.plugin.sns.ad.timeline.helper;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sns.ad.d;
import com.tencent.mm.plugin.sns.ad.d.e;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class b
{
  public static boolean a(TimeLineObject paramTimeLineObject, ADXml paramADXml)
  {
    AppMethodBeat.i(311133);
    boolean bool = c(paramTimeLineObject);
    if ((paramADXml != null) && (paramADXml.isFullCardAd()))
    {
      if (paramADXml.isLongPressGestureAd())
      {
        Log.i("SnsAd.OnlinePlayerSwitchHelper", "fullcard useOnlineVideoView preload false, longpressgesture offline");
        AppMethodBeat.o(311133);
        return false;
      }
      if (paramADXml.isAdBreakFrameVideo())
      {
        Log.i("SnsAd.OnlinePlayerSwitchHelper", "fullcard adBreakFrameVideo is offline");
        AppMethodBeat.o(311133);
        return false;
      }
      if (d.PKV == 1)
      {
        Log.i("SnsAd.OnlinePlayerSwitchHelper", "fullcard useOnlineVideoView preload false, force offline");
        AppMethodBeat.o(311133);
        return false;
      }
      if (d.PKV == 2)
      {
        Log.i("SnsAd.OnlinePlayerSwitchHelper", "fullcard useOnlineVideoView preload true,  force online");
        AppMethodBeat.o(311133);
        return true;
      }
    }
    if ((bool) && (b(paramADXml)))
    {
      if (hbP())
      {
        if ((paramADXml != null) && (!paramADXml.isCardAd()) && (!paramADXml.isFullCardAd()) && (!paramADXml.isSphereCardAd())) {}
        for (int i = 1; i != 0; i = 0)
        {
          Log.i("SnsAd.OnlinePlayerSwitchHelper", "the normal video preload is disable, because the online normal video preload is enable!");
          AppMethodBeat.o(311133);
          return true;
        }
      }
      if ((hbQ()) && (paramADXml.isCardAd()))
      {
        Log.i("SnsAd.OnlinePlayerSwitchHelper", "the base card ad video preload is disable, because the online base card prload is enable!");
        AppMethodBeat.o(311133);
        return true;
      }
      if ((a.hbZ()) && (paramADXml.isFullCardAd()) && (!paramADXml.isLongPressGestureAd()) && (!paramADXml.isAdBreakFrameVideo()))
      {
        Log.i("SnsAd.OnlinePlayerSwitchHelper", "fullcard useOnlineVideoView preload true");
        AppMethodBeat.o(311133);
        return true;
      }
      Log.i("SnsAd.OnlinePlayerSwitchHelper", "the ad video preload is not disable!");
    }
    AppMethodBeat.o(311133);
    return false;
  }
  
  public static boolean b(ADXml paramADXml)
  {
    boolean bool = false;
    AppMethodBeat.i(311151);
    if (paramADXml != null)
    {
      if (paramADXml.videoPlayInStreamingMode > 0) {
        bool = true;
      }
      Log.d("SnsAd.OnlinePlayerSwitchHelper", "enableOnlineVideoFeatureInAdXml return ".concat(String.valueOf(bool)));
      AppMethodBeat.o(311151);
      return bool;
    }
    Log.d("SnsAd.OnlinePlayerSwitchHelper", "enableOnlineVideoFeatureInAdXml : the adxml is null, so return false");
    AppMethodBeat.o(311151);
    return false;
  }
  
  public static boolean b(TimeLineObject paramTimeLineObject, ADXml paramADXml)
  {
    AppMethodBeat.i(311159);
    try
    {
      if ((c(paramTimeLineObject)) && (b(paramADXml)))
      {
        boolean bool = hbQ();
        if (bool) {
          return true;
        }
      }
    }
    finally
    {
      AppMethodBeat.o(311159);
    }
    return false;
  }
  
  public static boolean c(ADXml paramADXml)
  {
    AppMethodBeat.i(311166);
    try
    {
      if (b(paramADXml))
      {
        boolean bool = hbP();
        if (bool) {
          return true;
        }
      }
    }
    finally
    {
      AppMethodBeat.o(311166);
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
        if (paramTimeLineObject.ContentObj.Zpq == 15) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static boolean hbP()
  {
    AppMethodBeat.i(311113);
    try
    {
      int i = ((c)h.ax(c.class)).a(c.a.yIm, 0);
      Log.i("SnsAd.OnlinePlayerSwitchHelper", "useOnlineVideoInNormalTimeline value is ".concat(String.valueOf(i)));
      return i > 0;
    }
    finally
    {
      AppMethodBeat.o(311113);
    }
    return false;
  }
  
  private static boolean hbQ()
  {
    AppMethodBeat.i(311122);
    try
    {
      int i = ((c)h.ax(c.class)).a(c.a.yIl, 0);
      Log.i("SnsAd.OnlinePlayerSwitchHelper", "useOnlineVideoInBaseCardTimeline value is  ".concat(String.valueOf(i)));
      return i > 0;
    }
    finally
    {
      AppMethodBeat.o(311122);
    }
    return false;
  }
  
  public static boolean p(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(311143);
    if (paramSnsInfo == null)
    {
      Log.w("SnsAd.OnlinePlayerSwitchHelper", "enableOnlineVideoPreload: the snsInfo is null!!");
      AppMethodBeat.o(311143);
      return false;
    }
    if (!paramSnsInfo.isAd())
    {
      Log.w("SnsAd.OnlinePlayerSwitchHelper", "enableOnlineVideoPreload: the snsInfo is not ad!!");
      AppMethodBeat.o(311143);
      return false;
    }
    TimeLineObject localTimeLineObject = paramSnsInfo.getTimeLine();
    paramSnsInfo = paramSnsInfo.getAdXml();
    boolean bool = a(localTimeLineObject, paramSnsInfo);
    if (bool) {}
    try
    {
      if ((localTimeLineObject.ContentObj != null) && (localTimeLineObject.ContentObj.Zpr.size() > 0))
      {
        dmz localdmz = (dmz)localTimeLineObject.ContentObj.Zpr.get(0);
        Log.i("SnsAd.OnlinePlayerSwitchHelper", "AdH265Helper, enableAdOnlineVideoPreload, snsId=" + localTimeLineObject.Id);
        e.a(paramSnsInfo, localdmz, localTimeLineObject.Id);
      }
      AppMethodBeat.o(311143);
      return bool;
    }
    finally
    {
      for (;;)
      {
        Log.e("SnsAd.OnlinePlayerSwitchHelper", "AdH265Helper, enableAdOnlineVideoPreload exp=" + paramSnsInfo.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.helper.b
 * JD-Core Version:    0.7.0.1
 */