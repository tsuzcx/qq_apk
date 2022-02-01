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
  private static boolean cBE;
  
  public static void a(a parama)
  {
    AppMethodBeat.i(194530);
    d.a(parama);
    AppMethodBeat.o(194530);
  }
  
  public static void cC(Context paramContext, String paramString)
  {
    AppMethodBeat.i(194529);
    if (!cBE)
    {
      d.i("TPThumbPlayer[TPPlayerMgr.java]", "Enter initSdk");
      cBE = true;
      IR = paramContext.getApplicationContext();
      com.tencent.thumbplayer.e.a.bbo(paramString);
      com.tencent.thumbplayer.e.a.gbv();
      paramString = TPNetworkChangeMonitor.gcg();
      Context localContext = IR;
      paramContext = "context can not be null!";
      if (localContext == null)
      {
        if (!TextUtils.isEmpty("context can not be null!")) {}
        for (;;)
        {
          paramContext = new IllegalArgumentException(paramContext);
          AppMethodBeat.o(194529);
          throw paramContext;
          paramContext = "this argument should not be null!";
        }
      }
      paramString.cM(localContext);
      paramString.lp(localContext);
      d.i("TPThumbPlayer[TPPlayerMgr.java]", "Enter initSdk for monitor");
      d.i("TPThumbPlayer[TPPlayerMgr.java]", "Enter initSdk for report");
      TPNativeLog.setLogCallback(new ITPNativeLogCallback()
      {
        public final void onPrintLog(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(194528);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(194528);
            return;
            d.v(paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(194528);
            return;
            d.d(paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(194528);
            return;
            d.i(paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(194528);
            return;
            d.w(paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(194528);
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
      AppMethodBeat.o(194529);
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
  
  public static void gaU()
  {
    AppMethodBeat.i(194531);
    com.tencent.thumbplayer.e.a.gbl();
    AppMethodBeat.o(194531);
  }
  
  public static void gaV()
  {
    AppMethodBeat.i(194532);
    com.tencent.thumbplayer.e.a.gaV();
    AppMethodBeat.o(194532);
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