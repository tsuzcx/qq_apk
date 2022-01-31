package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import java.lang.reflect.Field;

public class CookieSyncManager
{
  private static android.webkit.CookieSyncManager a;
  private static CookieSyncManager b;
  private static boolean c = false;
  
  private CookieSyncManager(Context paramContext)
  {
    AppMethodBeat.i(63889);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_createInstance", new Class[] { Context.class }, new Object[] { paramContext });
      c = true;
    }
    AppMethodBeat.o(63889);
  }
  
  public static CookieSyncManager createInstance(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(63887);
      a = android.webkit.CookieSyncManager.createInstance(paramContext);
      if ((b == null) || (!c)) {
        b = new CookieSyncManager(paramContext.getApplicationContext());
      }
      paramContext = b;
      AppMethodBeat.o(63887);
      return paramContext;
    }
    finally {}
  }
  
  public static CookieSyncManager getInstance()
  {
    try
    {
      AppMethodBeat.i(63888);
      if (b == null)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
        AppMethodBeat.o(63888);
        throw localIllegalStateException;
      }
    }
    finally {}
    CookieSyncManager localCookieSyncManager = b;
    AppMethodBeat.o(63888);
    return localCookieSyncManager;
  }
  
  public void startSync()
  {
    AppMethodBeat.i(63892);
    Object localObject = bz.a();
    if ((localObject != null) && (((bz)localObject).b()))
    {
      ((bz)localObject).c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_startSync", new Class[0], new Object[0]);
      AppMethodBeat.o(63892);
      return;
    }
    a.startSync();
    try
    {
      localObject = Class.forName("android.webkit.WebSyncManager").getDeclaredField("mSyncThread");
      ((Field)localObject).setAccessible(true);
      ((Thread)((Field)localObject).get(a)).setUncaughtExceptionHandler(new p());
      AppMethodBeat.o(63892);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(63892);
    }
  }
  
  public void stopSync()
  {
    AppMethodBeat.i(63891);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_stopSync", new Class[0], new Object[0]);
      AppMethodBeat.o(63891);
      return;
    }
    a.stopSync();
    AppMethodBeat.o(63891);
  }
  
  public void sync()
  {
    AppMethodBeat.i(63890);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_Sync", new Class[0], new Object[0]);
      AppMethodBeat.o(63890);
      return;
    }
    a.sync();
    AppMethodBeat.o(63890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.CookieSyncManager
 * JD-Core Version:    0.7.0.1
 */