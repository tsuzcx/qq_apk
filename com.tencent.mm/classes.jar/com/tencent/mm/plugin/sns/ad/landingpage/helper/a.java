package com.tencent.mm.plugin.sns.ad.landingpage.helper;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public final class a
{
  public static final class a
  {
    public static void yl(boolean paramBoolean)
    {
      AppMethodBeat.i(194986);
      try
      {
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
        {
          if (paramBoolean)
          {
            a.aw(1676L, 1L);
            AppMethodBeat.o(194986);
            return;
          }
          a.aw(1676L, 2L);
          AppMethodBeat.o(194986);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Log.e("AdLandingPageStaticHelper.CacheHitStaticHelper", "reportImageCacheHit exp=" + localThrowable.toString());
        AppMethodBeat.o(194986);
        return;
      }
      if (paramBoolean)
      {
        a.aw(1676L, 3L);
        AppMethodBeat.o(194986);
        return;
      }
      a.aw(1676L, 4L);
      AppMethodBeat.o(194986);
    }
    
    public static void ym(boolean paramBoolean)
    {
      AppMethodBeat.i(194991);
      try
      {
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
        {
          if (paramBoolean)
          {
            a.aw(1676L, 5L);
            AppMethodBeat.o(194991);
            return;
          }
          a.aw(1676L, 6L);
          AppMethodBeat.o(194991);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Log.e("AdLandingPageStaticHelper.CacheHitStaticHelper", "reportSightCacheHit exp=" + localThrowable.toString());
        AppMethodBeat.o(194991);
        return;
      }
      if (paramBoolean)
      {
        a.aw(1676L, 7L);
        AppMethodBeat.o(194991);
        return;
      }
      a.aw(1676L, 8L);
      AppMethodBeat.o(194991);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.a
 * JD-Core Version:    0.7.0.1
 */