package com.tencent.mm.plugin.sns.ad.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.ca.a;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.threadpool.i;
import java.util.Map;

public final class b
{
  public static void a(String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(309719);
    try
    {
      ca localca = getFinderUtilApi();
      if (localca == null)
      {
        Log.e("SnsAd.FinderLivingRequest", "the IFinderUtilApi is null in requestLivingState, is there something wrong in wechat??!!");
        AppMethodBeat.o(309719);
        return;
      }
      d locald = new d(paramString1, 3, parama);
      new c(paramString1, 3, parama);
      long l = Util.safeParseLong(paramString2);
      if (l != 0L)
      {
        localca.a(l, locald);
        AppMethodBeat.o(309719);
        return;
      }
    }
    finally
    {
      Log.e("SnsAd.FinderLivingRequest", "requestLivingState is failed: sns id = ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(309719);
      return;
    }
    Log.e("SnsAd.FinderLivingRequest", "is the liveId not number in requestLivingState????, liveId=".concat(String.valueOf(paramString2)));
    AppMethodBeat.o(309719);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, a parama)
  {
    AppMethodBeat.i(309705);
    try
    {
      ca localca = getFinderUtilApi();
      if (localca == null)
      {
        Log.e("SnsAd.FinderLivingRequest", "the IFinderUtilApi is null in requestLivingNoticeState, is there something wrong in wechat??!!");
        AppMethodBeat.o(309705);
        return;
      }
      localca.a(paramString2, paramString3, new d(paramString1, 1, parama), new c(paramString1, 1, parama));
      AppMethodBeat.o(309705);
      return;
    }
    finally
    {
      Log.e("SnsAd.FinderLivingRequest", "requestLivingNoticeState is failed: sns id = ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(309705);
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, Object> paramMap, String paramString5, a parama)
  {
    AppMethodBeat.i(309747);
    try
    {
      Log.i("SnsAd.FinderLivingRequest", "showLivingRoom, liveId=" + paramString2 + ", username=" + paramString1 + ", snsId=" + paramString5);
      ca localca = getFinderUtilApi();
      if (localca == null)
      {
        Log.e("SnsAd.FinderLivingRequest", "the IFinderUtilApi is null in showLivingRoom, is there something wrong in wechat??!!, snsId=".concat(String.valueOf(paramString5)));
        AppMethodBeat.o(309747);
        return;
      }
      l = Util.safeParseLong(paramString2);
      if (l != 0L)
      {
        localca.b(paramString1, l, paramString3, paramString4, paramMap, new e(paramString5, 4, parama), new c(paramString5, 4, parama));
        AppMethodBeat.o(309747);
        return;
      }
    }
    finally
    {
      long l;
      Log.e("SnsAd.FinderLivingRequest", "showLivingRoom is failed! sns id = ".concat(String.valueOf(paramString5)));
      try
      {
        parama.b(paramString5, 4, -1, null);
        return;
      }
      finally
      {
        AppMethodBeat.o(309747);
      }
      Log.e("SnsAd.FinderLivingRequest", "is the liveId not number in showLivingRoom????, snsId=" + paramString5 + ", livingId=" + l);
      AppMethodBeat.o(309747);
      return;
    }
  }
  
  public static void aT(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(309766);
    try
    {
      Log.i("SnsAd.FinderLivingRequest", "promptResult, errCode=".concat(String.valueOf(paramInt)));
      if (paramContext == null)
      {
        AppMethodBeat.o(309766);
        return;
      }
      if (paramInt == 0) {
        aa.db(paramContext, paramContext.getString(b.j.sns_ad_finder_living_notice_subscribed));
      }
    }
    finally
    {
      AppMethodBeat.o(309766);
      return;
    }
    if (paramInt == -200045)
    {
      aa.dc(paramContext, paramContext.getString(b.j.sns_ad_finder_living_notice_expired));
      AppMethodBeat.o(309766);
      return;
    }
    if (paramInt == -200023)
    {
      aa.dc(paramContext, paramContext.getString(b.j.sns_ad_finder_living_notice_canceled));
      AppMethodBeat.o(309766);
      return;
    }
    aa.dc(paramContext, paramContext.getString(b.j.sns_ad_finder_living_notice_subscribe_failed));
    AppMethodBeat.o(309766);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, a parama)
  {
    AppMethodBeat.i(309728);
    try
    {
      ca localca = getFinderUtilApi();
      if (localca == null)
      {
        Log.e("SnsAd.FinderLivingRequest", "the IFinderUtilApi is null in subscribeLivingNotice, is there something wrong in wechat??!!");
        AppMethodBeat.o(309728);
        return;
      }
      localca.b(paramString2, paramString3, new e(paramString1, 2, parama), new c(paramString1, 2, parama));
      AppMethodBeat.o(309728);
      return;
    }
    finally
    {
      Log.e("SnsAd.FinderLivingRequest", "subscribeLivingNotice is failed: sns id = ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(309728);
    }
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, Object> paramMap, String paramString5, a parama)
  {
    AppMethodBeat.i(309788);
    try
    {
      Log.i("SnsAd.FinderLivingRequest", "doPreloadFinderLivingRoom, liveId=" + paramString2 + ", username=" + paramString1 + ", snsId=" + paramString5);
      ca localca = getFinderUtilApi();
      if (localca == null)
      {
        Log.e("SnsAd.FinderLivingRequest", "the IFinderUtilApi is null in doPreloadFinderLivingRoom, is there something wrong in wechat??!!, snsId=".concat(String.valueOf(paramString5)));
        AppMethodBeat.o(309788);
        return;
      }
      l = Util.safeParseLong(paramString2);
      if (l != 0L)
      {
        localca.a(paramString1, l, paramString3, paramString4, paramMap, new e(paramString5, 4, parama), new c(paramString5, 4, parama));
        AppMethodBeat.o(309788);
        return;
      }
    }
    finally
    {
      long l;
      Log.e("SnsAd.FinderLivingRequest", "showLivingRoom is failed! sns id = ".concat(String.valueOf(paramString5)));
      try
      {
        parama.b(paramString5, 4, -1, null);
        return;
      }
      finally
      {
        AppMethodBeat.o(309788);
      }
      Log.e("SnsAd.FinderLivingRequest", "is the liveId not number in doPreloadFinderLivingRoom????, snsId=" + paramString5 + ", livingId=" + l);
      AppMethodBeat.o(309788);
      return;
    }
  }
  
  private static ca getFinderUtilApi()
  {
    AppMethodBeat.i(309775);
    Object localObject = (cn)com.tencent.mm.kernel.h.az(cn.class);
    if (localObject != null)
    {
      localObject = ((cn)localObject).getFinderUtilApi();
      AppMethodBeat.o(309775);
      return localObject;
    }
    AppMethodBeat.o(309775);
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void b(String paramString, int paramInt1, int paramInt2, Object paramObject);
  }
  
  static abstract class b
  {
    protected final String PNx;
    protected final int PNy;
    protected final b.a PNz;
    
    public b(String paramString, int paramInt, b.a parama)
    {
      this.PNx = paramString;
      this.PNy = paramInt;
      this.PNz = parama;
    }
    
    protected final void M(final int paramInt, final Object paramObject)
    {
      final b.a locala = this.PNz;
      if (locala != null) {}
      try
      {
        com.tencent.threadpool.h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(309699);
            try
            {
              Log.i("SnsAd.FinderLivingRequest", "onResult:: snsId = " + b.b.this.PNx + ", action type = " + b.b.this.PNy + ", errorCode = " + paramInt);
              locala.b(b.b.this.PNx, b.b.this.PNy, paramInt, paramObject);
              return;
            }
            finally
            {
              AppMethodBeat.o(309699);
            }
          }
        });
        return;
      }
      finally {}
    }
  }
  
  static final class c
    extends b.b
    implements ca.a<Integer>
  {
    public c(String paramString, int paramInt, b.a parama)
    {
      super(paramInt, parama);
    }
  }
  
  static final class d
    extends b.b
    implements ca.a<Boolean>
  {
    public d(String paramString, int paramInt, b.a parama)
    {
      super(paramInt, parama);
    }
  }
  
  static final class e
    extends b.b
    implements ca.a<Void>
  {
    e(String paramString, int paramInt, b.a parama)
    {
      super(paramInt, parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.b.b
 * JD-Core Version:    0.7.0.1
 */