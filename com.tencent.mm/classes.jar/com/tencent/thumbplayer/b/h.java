package com.tencent.thumbplayer.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.ITPNativeLogCallback;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;
import com.tencent.thumbplayer.utils.TPNetworkChangeMonitor;
import com.tencent.thumbplayer.utils.d;

public final class h
{
  public static Context IR;
  private static boolean cAX;
  
  public static void a(a parama)
  {
    AppMethodBeat.i(191852);
    d.a(parama);
    AppMethodBeat.o(191852);
  }
  
  public static void cB(Context paramContext, String paramString)
  {
    AppMethodBeat.i(191851);
    if (!cAX)
    {
      d.i("TPThumbPlayer[TPPlayerMgr.java]", "Enter initSdk");
      cAX = true;
      IR = paramContext.getApplicationContext();
      com.tencent.thumbplayer.e.a.aZL(paramString);
      com.tencent.thumbplayer.e.a.fWW();
      paramString = TPNetworkChangeMonitor.fXH();
      Context localContext = IR;
      paramContext = "context can not be null!";
      if (localContext == null)
      {
        if (!TextUtils.isEmpty("context can not be null!")) {}
        for (;;)
        {
          paramContext = new IllegalArgumentException(paramContext);
          AppMethodBeat.o(191851);
          throw paramContext;
          paramContext = "this argument should not be null!";
        }
      }
      paramString.cK(localContext);
      paramString.lj(localContext);
      d.i("TPThumbPlayer[TPPlayerMgr.java]", "Enter initSdk for monitor");
      d.i("TPThumbPlayer[TPPlayerMgr.java]", "Enter initSdk for report");
      TPNativeLog.setLogCallback(new ITPNativeLogCallback()
      {
        public final void onPrintLog(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(191850);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(191850);
            return;
            d.v(paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(191850);
            return;
            d.d(paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(191850);
            return;
            d.i(paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(191850);
            return;
            d.w(paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(191850);
            return;
            d.e(paramAnonymousString1, paramAnonymousString2);
          }
        }
      });
    }
    try
    {
      TPNativeLibraryLoader.loadLibIfNeeded(IR);
      d.i("TPThumbPlayer[TPPlayerMgr.java]", "Enter initSdk for loadlib");
      com.tencent.thumbplayer.a.a.b.a.init(IR);
      d.i("TPThumbPlayer[TPPlayerMgr.java]", "Enter initSdk for drm cap");
      TPThumbplayerCapabilityHelper.init(IR, true);
      d.i("TPThumbPlayer[TPPlayerMgr.java]", "Enter initSdk DONE");
      AppMethodBeat.o(191851);
      return;
    }
    catch (UnsupportedOperationException paramContext)
    {
      for (;;)
      {
        d.e("TPThumbPlayer[TPPlayerMgr.java]", paramContext);
      }
    }
  }
  
  public static void fWv()
  {
    AppMethodBeat.i(191853);
    com.tencent.thumbplayer.e.a.fWM();
    AppMethodBeat.o(191853);
  }
  
  public static void fWw()
  {
    AppMethodBeat.i(191854);
    com.tencent.thumbplayer.e.a.fWw();
    AppMethodBeat.o(191854);
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