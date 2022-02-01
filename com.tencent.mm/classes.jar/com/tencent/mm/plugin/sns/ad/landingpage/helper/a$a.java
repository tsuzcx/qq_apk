package com.tencent.mm.plugin.sns.ad.landingpage.helper;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public final class a$a
{
  public static void t(boolean paramBoolean, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(310811);
    h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(310819);
        try
        {
          String str1;
          String str2;
          if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            if (this.PTc)
            {
              a.bg(1676L, 1L);
              str1 = "wifi";
              str2 = l.QnE;
              if (!this.PTc) {
                break label129;
              }
            }
          }
          label129:
          for (int i = 1;; i = 0)
          {
            l.a(str2, str1, i, paramInt1, paramInt2);
            AppMethodBeat.o(310819);
            return;
            a.bg(1676L, 2L);
            str1 = "wifi";
            break;
            if (this.PTc)
            {
              a.bg(1676L, 3L);
              str1 = "mobile";
              break;
            }
            a.bg(1676L, 4L);
            str1 = "mobile";
            break;
          }
          return;
        }
        finally
        {
          Log.e("AdLandingPageStaticHelper.CacheHitStaticHelper", "reportImageCacheHit exp=" + localObject.toString());
          AppMethodBeat.o(310819);
        }
      }
    });
    AppMethodBeat.o(310811);
  }
  
  public static void u(boolean paramBoolean, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(310815);
    h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(310830);
        try
        {
          String str1;
          String str2;
          if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            if (this.PTc)
            {
              a.bg(1676L, 5L);
              str1 = "wifi";
              str2 = l.QnF;
              if (!this.PTc) {
                break label131;
              }
            }
          }
          label131:
          for (int i = 1;; i = 0)
          {
            l.a(str2, str1, i, paramInt1, paramInt2);
            AppMethodBeat.o(310830);
            return;
            a.bg(1676L, 6L);
            str1 = "wifi";
            break;
            if (this.PTc)
            {
              a.bg(1676L, 7L);
              str1 = "mobile";
              break;
            }
            a.bg(1676L, 8L);
            str1 = "mobile";
            break;
          }
          return;
        }
        finally
        {
          Log.e("AdLandingPageStaticHelper.CacheHitStaticHelper", "reportSightCacheHit exp=" + localObject.toString());
          AppMethodBeat.o(310830);
        }
      }
    });
    AppMethodBeat.o(310815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.a.a
 * JD-Core Version:    0.7.0.1
 */