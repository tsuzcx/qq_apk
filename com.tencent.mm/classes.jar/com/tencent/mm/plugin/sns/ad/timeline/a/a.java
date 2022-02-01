package com.tencent.mm.plugin.sns.ad.timeline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
{
  public static boolean a(com.tencent.mm.plugin.sns.storage.b paramb)
  {
    boolean bool = false;
    AppMethodBeat.i(219121);
    if (paramb != null)
    {
      if (paramb.zNY > 0) {
        bool = true;
      }
      ae.d("SnsAd.OnlinePlayerSwitchHelper", "enableOnlineVideoFeatureInAdXml return ".concat(String.valueOf(bool)));
      AppMethodBeat.o(219121);
      return bool;
    }
    ae.d("SnsAd.OnlinePlayerSwitchHelper", "enableOnlineVideoFeatureInAdXml : the adxml is null, so return false");
    AppMethodBeat.o(219121);
    return false;
  }
  
  public static boolean a(TimeLineObject paramTimeLineObject, com.tencent.mm.plugin.sns.storage.b paramb)
  {
    AppMethodBeat.i(219119);
    if ((c(paramTimeLineObject)) && (a(paramb)))
    {
      if (dVr())
      {
        if ((paramb != null) && (!paramb.dZA()) && (!paramb.dZB()) && (!paramb.dZC())) {}
        for (int i = 1; i != 0; i = 0)
        {
          ae.i("SnsAd.OnlinePlayerSwitchHelper", "the normal video preload is disable, because the online normal video preload is enable!");
          AppMethodBeat.o(219119);
          return true;
        }
      }
      if ((dVs()) && (paramb.dZA()))
      {
        ae.i("SnsAd.OnlinePlayerSwitchHelper", "the base card ad video preload is disable, because the online base card prload is enable!");
        AppMethodBeat.o(219119);
        return true;
      }
      ae.i("SnsAd.OnlinePlayerSwitchHelper", "the ad video preload is not disable!");
    }
    AppMethodBeat.o(219119);
    return false;
  }
  
  public static boolean c(TimeLineObject paramTimeLineObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramTimeLineObject != null)
    {
      bool1 = bool2;
      if (paramTimeLineObject.HUG != null)
      {
        bool1 = bool2;
        if (paramTimeLineObject.HUG.Gtw == 15) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean dVr()
  {
    AppMethodBeat.i(219117);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxr, 0);
      ae.i("SnsAd.OnlinePlayerSwitchHelper", "useOnlineVideoInNormalTimeline value is ".concat(String.valueOf(i)));
      if (i > 0)
      {
        AppMethodBeat.o(219117);
        return true;
      }
      AppMethodBeat.o(219117);
      return false;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(219117);
    }
    return false;
  }
  
  public static boolean dVs()
  {
    AppMethodBeat.i(219118);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxq, 0);
      ae.i("SnsAd.OnlinePlayerSwitchHelper", "useOnlineVideoInBaseCardTimeline value is  ".concat(String.valueOf(i)));
      if (i > 0)
      {
        AppMethodBeat.o(219118);
        return true;
      }
      AppMethodBeat.o(219118);
      return false;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(219118);
    }
    return false;
  }
  
  public static boolean j(p paramp)
  {
    AppMethodBeat.i(219120);
    if (paramp == null)
    {
      ae.w("SnsAd.OnlinePlayerSwitchHelper", "enableOnlineVideoPreload: the snsInfo is null!!");
      AppMethodBeat.o(219120);
      return false;
    }
    if (!paramp.Rt(32))
    {
      ae.w("SnsAd.OnlinePlayerSwitchHelper", "enableOnlineVideoPreload: the snsInfo is not ad!!");
      AppMethodBeat.o(219120);
      return false;
    }
    boolean bool = a(paramp.ebP(), paramp.dVj());
    AppMethodBeat.o(219120);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.a
 * JD-Core Version:    0.7.0.1
 */