package com.tencent.mm.plugin.sns.ad.c;

import android.content.Context;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.i.a.af.a;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;

public final class b
{
  public static void a(String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(201867);
    try
    {
      af localaf = getFinderUtilApi();
      if (localaf == null)
      {
        Log.e("SnsAd.FinderLivingRequest", "the IFinderUtilApi is null in requestLivingState, is there something wrong in wechat??!!");
        AppMethodBeat.o(201867);
        return;
      }
      d locald = new d(paramString1, 3, parama);
      new c(paramString1, 3, parama);
      long l = Util.safeParseLong(paramString2);
      if (l != 0L)
      {
        localaf.a(l, locald);
        AppMethodBeat.o(201867);
        return;
      }
    }
    catch (Throwable paramString2)
    {
      Log.e("SnsAd.FinderLivingRequest", "requestLivingState is failed: sns id = ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(201867);
      return;
    }
    Log.e("SnsAd.FinderLivingRequest", "is the liveId not number in requestLivingState????");
    AppMethodBeat.o(201867);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, a parama)
  {
    AppMethodBeat.i(201866);
    try
    {
      af localaf = getFinderUtilApi();
      if (localaf == null)
      {
        Log.e("SnsAd.FinderLivingRequest", "the IFinderUtilApi is null in requestLivingNoticeState, is there something wrong in wechat??!!");
        AppMethodBeat.o(201866);
        return;
      }
      localaf.a(paramString2, paramString3, new d(paramString1, 1, parama), new c(paramString1, 1, parama));
      AppMethodBeat.o(201866);
      return;
    }
    catch (Throwable paramString2)
    {
      Log.e("SnsAd.FinderLivingRequest", "requestLivingNoticeState is failed: sns id = ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(201866);
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, a parama)
  {
    AppMethodBeat.i(201869);
    try
    {
      af localaf = getFinderUtilApi();
      if (localaf == null)
      {
        Log.e("SnsAd.FinderLivingRequest", "the IFinderUtilApi is null in showLivingRoom, is there something wrong in wechat??!!");
        AppMethodBeat.o(201869);
        return;
      }
      long l = Util.safeParseLong(paramString2);
      if (l != 0L)
      {
        localaf.a(paramString1, l, paramString3, paramString4, new e(paramString5, 4, parama), new c(paramString5, 4, parama));
        AppMethodBeat.o(201869);
        return;
      }
    }
    catch (Throwable paramString1)
    {
      Log.e("SnsAd.FinderLivingRequest", "showLivingRoom is failed! sns id = ".concat(String.valueOf(paramString5)));
      try
      {
        parama.b(paramString5, -1, null);
        AppMethodBeat.o(201869);
        return;
      }
      catch (Throwable paramString1)
      {
        AppMethodBeat.o(201869);
      }
      Log.e("SnsAd.FinderLivingRequest", "is the liveId not number in showLivingRoom????");
      AppMethodBeat.o(201869);
      return;
    }
  }
  
  public static void ao(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(201870);
    if (paramContext == null)
    {
      AppMethodBeat.o(201870);
      return;
    }
    if (paramInt == 0) {
      try
      {
        u.cG(paramContext, paramContext.getString(2131765957));
        AppMethodBeat.o(201870);
        return;
      }
      catch (Throwable paramContext)
      {
        AppMethodBeat.o(201870);
        return;
      }
    }
    if (paramInt == -200045)
    {
      u.cH(paramContext, paramContext.getString(2131765955));
      AppMethodBeat.o(201870);
      return;
    }
    if (paramInt == -200023)
    {
      u.cH(paramContext, paramContext.getString(2131765954));
      AppMethodBeat.o(201870);
      return;
    }
    u.cH(paramContext, paramContext.getString(2131765956));
    AppMethodBeat.o(201870);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, a parama)
  {
    AppMethodBeat.i(201868);
    try
    {
      af localaf = getFinderUtilApi();
      if (localaf == null)
      {
        Log.e("SnsAd.FinderLivingRequest", "the IFinderUtilApi is null in subscribeLivingNotice, is there something wrong in wechat??!!");
        AppMethodBeat.o(201868);
        return;
      }
      localaf.b(paramString2, paramString3, new e(paramString1, 2, parama), new c(paramString1, 2, parama));
      AppMethodBeat.o(201868);
      return;
    }
    catch (Throwable paramString2)
    {
      Log.e("SnsAd.FinderLivingRequest", "subscribeLivingNotice is failed: sns id = ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(201868);
    }
  }
  
  private static af getFinderUtilApi()
  {
    AppMethodBeat.i(201871);
    Object localObject = (aj)g.ah(aj.class);
    if (localObject != null)
    {
      localObject = ((aj)localObject).getFinderUtilApi();
      AppMethodBeat.o(201871);
      return localObject;
    }
    AppMethodBeat.o(201871);
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void b(String paramString, int paramInt, Object paramObject);
  }
  
  static abstract class b
  {
    protected final String Dsr;
    protected final int Dss;
    protected final b.a Dst;
    
    public b(String paramString, int paramInt, b.a parama)
    {
      this.Dsr = paramString;
      this.Dss = paramInt;
      this.Dst = parama;
    }
    
    protected final void o(final int paramInt, final Object paramObject)
    {
      final b.a locala = this.Dst;
      if (locala != null) {}
      try
      {
        h.RTc.aV(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(201862);
            try
            {
              Log.d("SnsAd.FinderLivingRequest", "onResult:: snsId = " + b.b.this.Dsr + ", action type = " + b.b.this.Dss + ", errorCode = " + paramInt);
              locala.b(b.b.this.Dsr, paramInt, paramObject);
              AppMethodBeat.o(201862);
              return;
            }
            catch (Throwable localThrowable)
            {
              AppMethodBeat.o(201862);
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
    implements af.a<Integer>
  {
    public c(String paramString, int paramInt, b.a parama)
    {
      super(paramInt, parama);
    }
  }
  
  static final class d
    extends b.b
    implements af.a<Boolean>
  {
    public d(String paramString, int paramInt, b.a parama)
    {
      super(paramInt, parama);
    }
  }
  
  static final class e
    extends b.b
    implements af.a<Void>
  {
    e(String paramString, int paramInt, b.a parama)
    {
      super(paramInt, parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.c.b
 * JD-Core Version:    0.7.0.1
 */