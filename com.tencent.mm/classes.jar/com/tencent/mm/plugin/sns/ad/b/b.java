package com.tencent.mm.plugin.sns.ad.b;

import android.content.Context;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.ag;
import com.tencent.mm.plugin.findersdk.a.ag.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;

public final class b
{
  public static void a(String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(196912);
    try
    {
      ag localag = getFinderUtilApi();
      if (localag == null)
      {
        Log.e("SnsAd.FinderLivingRequest", "the IFinderUtilApi is null in requestLivingState, is there something wrong in wechat??!!");
        AppMethodBeat.o(196912);
        return;
      }
      d locald = new d(paramString1, 3, parama);
      new c(paramString1, 3, parama);
      long l = Util.safeParseLong(paramString2);
      if (l != 0L)
      {
        localag.a(l, locald);
        AppMethodBeat.o(196912);
        return;
      }
    }
    catch (Throwable paramString2)
    {
      Log.e("SnsAd.FinderLivingRequest", "requestLivingState is failed: sns id = ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(196912);
      return;
    }
    Log.e("SnsAd.FinderLivingRequest", "is the liveId not number in requestLivingState????");
    AppMethodBeat.o(196912);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, a parama)
  {
    AppMethodBeat.i(196907);
    try
    {
      ag localag = getFinderUtilApi();
      if (localag == null)
      {
        Log.e("SnsAd.FinderLivingRequest", "the IFinderUtilApi is null in requestLivingNoticeState, is there something wrong in wechat??!!");
        AppMethodBeat.o(196907);
        return;
      }
      localag.a(paramString2, paramString3, new d(paramString1, 1, parama), new c(paramString1, 1, parama));
      AppMethodBeat.o(196907);
      return;
    }
    catch (Throwable paramString2)
    {
      Log.e("SnsAd.FinderLivingRequest", "requestLivingNoticeState is failed: sns id = ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(196907);
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, a parama)
  {
    AppMethodBeat.i(196928);
    try
    {
      ag localag = getFinderUtilApi();
      if (localag == null)
      {
        Log.e("SnsAd.FinderLivingRequest", "the IFinderUtilApi is null in showLivingRoom, is there something wrong in wechat??!!, snsId=".concat(String.valueOf(paramString5)));
        AppMethodBeat.o(196928);
        return;
      }
      long l = Util.safeParseLong(paramString2);
      if (l != 0L)
      {
        localag.a(paramString1, l, paramString3, paramString4, new e(paramString5, 4, parama), new c(paramString5, 4, parama));
        AppMethodBeat.o(196928);
        return;
      }
    }
    catch (Throwable paramString1)
    {
      Log.e("SnsAd.FinderLivingRequest", "showLivingRoom is failed! sns id = ".concat(String.valueOf(paramString5)));
      try
      {
        parama.b(paramString5, 4, -1, null);
        AppMethodBeat.o(196928);
        return;
      }
      catch (Throwable paramString1)
      {
        AppMethodBeat.o(196928);
      }
      Log.e("SnsAd.FinderLivingRequest", "is the liveId not number in showLivingRoom????, snsId=".concat(String.valueOf(paramString5)));
      AppMethodBeat.o(196928);
      return;
    }
  }
  
  public static void aG(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(196935);
    if (paramContext == null)
    {
      AppMethodBeat.o(196935);
      return;
    }
    if (paramInt == 0) {
      try
      {
        w.cR(paramContext, paramContext.getString(i.j.sns_ad_finder_living_notice_subscribed));
        AppMethodBeat.o(196935);
        return;
      }
      catch (Throwable paramContext)
      {
        AppMethodBeat.o(196935);
        return;
      }
    }
    if (paramInt == -200045)
    {
      w.cS(paramContext, paramContext.getString(i.j.sns_ad_finder_living_notice_expired));
      AppMethodBeat.o(196935);
      return;
    }
    if (paramInt == -200023)
    {
      w.cS(paramContext, paramContext.getString(i.j.sns_ad_finder_living_notice_canceled));
      AppMethodBeat.o(196935);
      return;
    }
    w.cS(paramContext, paramContext.getString(i.j.sns_ad_finder_living_notice_subscribe_failed));
    AppMethodBeat.o(196935);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, a parama)
  {
    AppMethodBeat.i(196917);
    try
    {
      ag localag = getFinderUtilApi();
      if (localag == null)
      {
        Log.e("SnsAd.FinderLivingRequest", "the IFinderUtilApi is null in subscribeLivingNotice, is there something wrong in wechat??!!");
        AppMethodBeat.o(196917);
        return;
      }
      localag.b(paramString2, paramString3, new e(paramString1, 2, parama), new c(paramString1, 2, parama));
      AppMethodBeat.o(196917);
      return;
    }
    catch (Throwable paramString2)
    {
      Log.e("SnsAd.FinderLivingRequest", "subscribeLivingNotice is failed: sns id = ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(196917);
    }
  }
  
  private static ag getFinderUtilApi()
  {
    AppMethodBeat.i(196939);
    Object localObject = (ak)com.tencent.mm.kernel.h.ag(ak.class);
    if (localObject != null)
    {
      localObject = ((ak)localObject).getFinderUtilApi();
      AppMethodBeat.o(196939);
      return localObject;
    }
    AppMethodBeat.o(196939);
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void b(String paramString, int paramInt1, int paramInt2, Object paramObject);
  }
  
  static abstract class b
  {
    protected final String JyZ;
    protected final int Jza;
    protected final b.a Jzb;
    
    public b(String paramString, int paramInt, b.a parama)
    {
      this.JyZ = paramString;
      this.Jza = paramInt;
      this.Jzb = parama;
    }
    
    protected final void s(final int paramInt, final Object paramObject)
    {
      final b.a locala = this.Jzb;
      if (locala != null) {}
      try
      {
        com.tencent.e.h.ZvG.bc(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(248206);
            try
            {
              Log.i("SnsAd.FinderLivingRequest", "onResult:: snsId = " + b.b.this.JyZ + ", action type = " + b.b.this.Jza + ", errorCode = " + paramInt);
              locala.b(b.b.this.JyZ, b.b.this.Jza, paramInt, paramObject);
              AppMethodBeat.o(248206);
              return;
            }
            catch (Throwable localThrowable)
            {
              AppMethodBeat.o(248206);
            }
          }
        });
        return;
      }
      catch (Throwable paramObject) {}
    }
  }
  
  static final class c
    extends b.b
    implements ag.a<Integer>
  {
    public c(String paramString, int paramInt, b.a parama)
    {
      super(paramInt, parama);
    }
  }
  
  static final class d
    extends b.b
    implements ag.a<Boolean>
  {
    public d(String paramString, int paramInt, b.a parama)
    {
      super(paramInt, parama);
    }
  }
  
  static final class e
    extends b.b
    implements ag.a<Void>
  {
    e(String paramString, int paramInt, b.a parama)
    {
      super(paramInt, parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.b.b
 * JD-Core Version:    0.7.0.1
 */