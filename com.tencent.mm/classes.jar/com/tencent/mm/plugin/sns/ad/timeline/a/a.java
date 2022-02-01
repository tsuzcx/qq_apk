package com.tencent.mm.plugin.sns.ad.timeline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  public static boolean a(com.tencent.mm.plugin.sns.storage.b paramb)
  {
    boolean bool = false;
    AppMethodBeat.i(197655);
    if (paramb != null)
    {
      if (paramb.zwC > 0) {
        bool = true;
      }
      ad.d("SnsAd.OnlinePlayerSwitchHelper", "enableOnlineVideoFeatureInAdXml return ".concat(String.valueOf(bool)));
      AppMethodBeat.o(197655);
      return bool;
    }
    ad.d("SnsAd.OnlinePlayerSwitchHelper", "enableOnlineVideoFeatureInAdXml : the adxml is null, so return false");
    AppMethodBeat.o(197655);
    return false;
  }
  
  public static boolean a(TimeLineObject paramTimeLineObject, com.tencent.mm.plugin.sns.storage.b paramb)
  {
    AppMethodBeat.i(197653);
    if ((c(paramTimeLineObject)) && (a(paramb)))
    {
      if (dRT())
      {
        if ((paramb != null) && (!paramb.dVZ()) && (!paramb.dWa()) && (!paramb.dWb())) {}
        for (int i = 1; i != 0; i = 0)
        {
          ad.i("SnsAd.OnlinePlayerSwitchHelper", "the normal video preload is disable, because the online normal video preload is enable!");
          AppMethodBeat.o(197653);
          return true;
        }
      }
      if ((dRU()) && (paramb.dVZ()))
      {
        ad.i("SnsAd.OnlinePlayerSwitchHelper", "the base card ad video preload is disable, because the online base card prload is enable!");
        AppMethodBeat.o(197653);
        return true;
      }
      ad.i("SnsAd.OnlinePlayerSwitchHelper", "the ad video preload is not disable!");
    }
    AppMethodBeat.o(197653);
    return false;
  }
  
  public static boolean c(TimeLineObject paramTimeLineObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramTimeLineObject != null)
    {
      bool1 = bool2;
      if (paramTimeLineObject.HAT != null)
      {
        bool1 = bool2;
        if (paramTimeLineObject.HAT.GaP == 15) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean dRT()
  {
    AppMethodBeat.i(197651);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqE, 0);
      ad.i("SnsAd.OnlinePlayerSwitchHelper", "useOnlineVideoInNormalTimeline value is ".concat(String.valueOf(i)));
      if (i > 0)
      {
        AppMethodBeat.o(197651);
        return true;
      }
      AppMethodBeat.o(197651);
      return false;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(197651);
    }
    return false;
  }
  
  public static boolean dRU()
  {
    AppMethodBeat.i(197652);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqD, 0);
      ad.i("SnsAd.OnlinePlayerSwitchHelper", "useOnlineVideoInBaseCardTimeline value is  ".concat(String.valueOf(i)));
      if (i > 0)
      {
        AppMethodBeat.o(197652);
        return true;
      }
      AppMethodBeat.o(197652);
      return false;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(197652);
    }
    return false;
  }
  
  public static boolean i(p paramp)
  {
    AppMethodBeat.i(197654);
    if (paramp == null)
    {
      ad.w("SnsAd.OnlinePlayerSwitchHelper", "enableOnlineVideoPreload: the snsInfo is null!!");
      AppMethodBeat.o(197654);
      return false;
    }
    if (!paramp.QM(32))
    {
      ad.w("SnsAd.OnlinePlayerSwitchHelper", "enableOnlineVideoPreload: the snsInfo is not ad!!");
      AppMethodBeat.o(197654);
      return false;
    }
    boolean bool = a(paramp.dYl(), paramp.dRL());
    AppMethodBeat.o(197654);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.a
 * JD-Core Version:    0.7.0.1
 */