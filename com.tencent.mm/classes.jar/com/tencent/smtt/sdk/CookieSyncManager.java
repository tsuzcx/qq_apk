package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager;
import java.lang.reflect.Field;

public class CookieSyncManager
  extends z
{
  private static android.webkit.CookieSyncManager a;
  private static CookieSyncManager b;
  private static boolean c = false;
  
  private CookieSyncManager(Context paramContext)
  {
    AppMethodBeat.i(55015);
    if (isX5Core())
    {
      getCookieManagerImpl().syncManagerCreateInstance(paramContext);
      c = true;
    }
    AppMethodBeat.o(55015);
  }
  
  public static CookieSyncManager createInstance(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(55013);
      a = android.webkit.CookieSyncManager.createInstance(paramContext);
      if ((b == null) || (!c)) {
        b = new CookieSyncManager(paramContext.getApplicationContext());
      }
      paramContext = b;
      AppMethodBeat.o(55013);
      return paramContext;
    }
    finally {}
  }
  
  public static CookieSyncManager getInstance()
  {
    try
    {
      AppMethodBeat.i(55014);
      if (b == null)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
        AppMethodBeat.o(55014);
        throw localIllegalStateException;
      }
    }
    finally {}
    CookieSyncManager localCookieSyncManager = b;
    AppMethodBeat.o(55014);
    return localCookieSyncManager;
  }
  
  public void startSync()
  {
    AppMethodBeat.i(55018);
    if (isX5Core())
    {
      getCookieManagerImpl().syncManagerStartSync();
      AppMethodBeat.o(55018);
      return;
    }
    a.startSync();
    try
    {
      Field localField = Class.forName("android.webkit.WebSyncManager").getDeclaredField("mSyncThread");
      localField.setAccessible(true);
      ((Thread)localField.get(a)).setUncaughtExceptionHandler(new h());
      AppMethodBeat.o(55018);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(55018);
    }
  }
  
  public void stopSync()
  {
    AppMethodBeat.i(55017);
    if (isX5Core())
    {
      getCookieManagerImpl().syncManagerStopSync();
      AppMethodBeat.o(55017);
      return;
    }
    a.stopSync();
    AppMethodBeat.o(55017);
  }
  
  public void sync()
  {
    AppMethodBeat.i(55016);
    if (isX5Core())
    {
      getCookieManagerImpl().syncManagerSync();
      AppMethodBeat.o(55016);
      return;
    }
    a.sync();
    AppMethodBeat.o(55016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.CookieSyncManager
 * JD-Core Version:    0.7.0.1
 */