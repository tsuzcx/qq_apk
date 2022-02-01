package com.tencent.thumbplayer.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.ITPNativeLogCallback;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;
import com.tencent.thumbplayer.utils.TPNetworkChangeMonitor;
import com.tencent.thumbplayer.utils.f;

public final class h
{
  public static Context GX;
  private static boolean cqf;
  
  public static void a(a parama)
  {
    AppMethodBeat.i(187831);
    f.a(parama);
    AppMethodBeat.o(187831);
  }
  
  public static void cw(Context paramContext, String paramString)
  {
    AppMethodBeat.i(187830);
    if (!cqf)
    {
      f.i("TPThumbPlayer[TPPlayerMgr.java]", "Enter initSdk");
      cqf = true;
      GX = paramContext.getApplicationContext();
      com.tencent.thumbplayer.e.a.aTL(paramString);
      com.tencent.thumbplayer.e.a.fFH();
      paramString = TPNetworkChangeMonitor.fGv();
      Context localContext = GX;
      paramContext = "context can not be null!";
      if (localContext == null)
      {
        if (!TextUtils.isEmpty("context can not be null!")) {}
        for (;;)
        {
          paramContext = new IllegalArgumentException(paramContext);
          AppMethodBeat.o(187830);
          throw paramContext;
          paramContext = "this argument should not be null!";
        }
      }
      paramString.cN(localContext);
      paramString.kW(localContext);
      f.i("TPThumbPlayer[TPPlayerMgr.java]", "Enter initSdk for monitor");
      f.i("TPThumbPlayer[TPPlayerMgr.java]", "Enter initSdk for report");
      TPNativeLog.setLogCallback(new ITPNativeLogCallback()
      {
        public final void onPrintLog(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(187829);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(187829);
            return;
            f.v(paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(187829);
            return;
            f.d(paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(187829);
            return;
            f.i(paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(187829);
            return;
            f.w(paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(187829);
            return;
            f.e(paramAnonymousString1, paramAnonymousString2);
          }
        }
      });
    }
    try
    {
      TPNativeLibraryLoader.loadLibIfNeeded(GX);
      f.i("TPThumbPlayer[TPPlayerMgr.java]", "Enter initSdk for loadlib");
      com.tencent.thumbplayer.a.a.b.a.init(GX);
      f.i("TPThumbPlayer[TPPlayerMgr.java]", "Enter initSdk for drm cap");
      TPThumbplayerCapabilityHelper.init(GX, true);
      f.i("TPThumbPlayer[TPPlayerMgr.java]", "Enter initSdk DONE");
      AppMethodBeat.o(187830);
      return;
    }
    catch (UnsupportedOperationException paramContext)
    {
      for (;;)
      {
        f.e("TPThumbPlayer[TPPlayerMgr.java]", paramContext);
      }
    }
  }
  
  public static void fFe()
  {
    AppMethodBeat.i(187832);
    com.tencent.thumbplayer.e.a.fFx();
    AppMethodBeat.o(187832);
  }
  
  public static void fFf()
  {
    AppMethodBeat.i(187833);
    com.tencent.thumbplayer.e.a.fFf();
    AppMethodBeat.o(187833);
  }
  
  public static abstract interface a
  {
    public abstract int d(String paramString1, String paramString2);
    
    public abstract int e(String paramString1, String paramString2);
    
    public abstract int i(String paramString1, String paramString2);
    
    public abstract int v(String paramString1, String paramString2);
    
    public abstract int w(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.b.h
 * JD-Core Version:    0.7.0.1
 */