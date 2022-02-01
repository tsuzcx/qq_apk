package com.tencent.mm.plugin.sns.device.appstore;

import android.content.Context;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d
{
  private static d wBN = null;
  private ApkInstalledWatcher wBJ;
  private boolean wBK;
  private final Map<String, e> wBL;
  private final b wBM;
  
  private d()
  {
    AppMethodBeat.i(187300);
    this.wBK = false;
    this.wBL = new HashMap();
    this.wBJ = new a((byte)0);
    this.wBM = new b((byte)0);
    AppMethodBeat.o(187300);
  }
  
  public static void a(e parame)
  {
    try
    {
      AppMethodBeat.i(187298);
      try
      {
        dsj().b(parame);
        AppMethodBeat.o(187298);
      }
      catch (Throwable parame)
      {
        for (;;)
        {
          ad.e("ApkInstalledWatcherManager", "watchStatic: watch info failed!");
          AppMethodBeat.o(187298);
        }
      }
      return;
    }
    finally {}
  }
  
  private e anX(String paramString)
  {
    AppMethodBeat.i(187304);
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.wBL)
      {
        paramString = (e)this.wBL.remove(paramString);
        AppMethodBeat.o(187304);
        return paramString;
      }
    }
    AppMethodBeat.o(187304);
    return null;
  }
  
  private void b(e parame)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(187301);
        ad.i("ApkInstalledWatcherManager", "watch is called");
        if (parame == null)
        {
          if (i != 0) {
            break label72;
          }
          AppMethodBeat.o(187301);
          return;
        }
        if ((TextUtils.isEmpty(parame.wBP)) || (TextUtils.isEmpty(parame.wBQ)))
        {
          ad.i("ApkInstalledWatcherManager", "checkWatchInfo is called, the input param is invalid");
          continue;
        }
        i = 1;
      }
      finally {}
      continue;
      label72:
      dsk();
      synchronized (this.wBL)
      {
        this.wBL.put(parame.wBP, parame);
        dsm();
        parame = this.wBM;
        if (!parame.mStarted)
        {
          parame.mStarted = true;
          aq.n(parame, 300000L);
          ad.i("ApkInstalledWatcherManager", "startTimer is called, the timer is to start.");
          AppMethodBeat.o(187301);
        }
      }
      ad.i("ApkInstalledWatcherManager", "startTimer is called, the timer is started!");
      AppMethodBeat.o(187301);
    }
  }
  
  private static d dsj()
  {
    try
    {
      AppMethodBeat.i(187299);
      if (wBN == null) {
        wBN = new d();
      }
      d locald = wBN;
      AppMethodBeat.o(187299);
      return locald;
    }
    finally {}
  }
  
  private void dsk()
  {
    try
    {
      AppMethodBeat.i(187302);
      try
      {
        if (this.wBJ == null) {
          this.wBJ = new a((byte)0);
        }
        if (!this.wBK)
        {
          ad.i("ApkInstalledWatcherManager", "registerWatcher: the watcher is to be registered");
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
          localIntentFilter.addDataScheme("package");
          aj.getContext().registerReceiver(this.wBJ, localIntentFilter);
          this.wBK = true;
        }
        AppMethodBeat.o(187302);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ad.e("ApkInstalledWatcherManager", "register ApkInstalledWatcher failed");
          AppMethodBeat.o(187302);
        }
      }
      return;
    }
    finally {}
  }
  
  private void dsl()
  {
    try
    {
      AppMethodBeat.i(187303);
      try
      {
        if ((this.wBJ != null) && (this.wBK))
        {
          aj.getContext().unregisterReceiver(this.wBJ);
          this.wBK = false;
        }
        AppMethodBeat.o(187303);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ad.e("ApkInstalledWatcherManager", "unregister ApkInstalledWatcher failed");
          AppMethodBeat.o(187303);
        }
      }
      return;
    }
    finally {}
  }
  
  private void dsm()
  {
    AppMethodBeat.i(187305);
    synchronized (this.wBL)
    {
      Iterator localIterator = this.wBL.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry.getValue() == null) {
          break label92;
        }
        if (((e)localEntry.getValue()).wBT + 300000L < SystemClock.elapsedRealtime()) {
          localIterator.remove();
        }
      }
      AppMethodBeat.o(187305);
      return;
      label92:
      localIterator.remove();
    }
  }
  
  private boolean dsn()
  {
    AppMethodBeat.i(187306);
    synchronized (this.wBL)
    {
      if (!this.wBL.isEmpty())
      {
        bool = true;
        AppMethodBeat.o(187306);
        return bool;
      }
      boolean bool = false;
    }
  }
  
  final class a
    extends ApkInstalledWatcher
  {
    private a() {}
    
    protected final boolean anW(String paramString)
    {
      AppMethodBeat.i(187296);
      paramString = d.a(d.this, paramString);
      if (paramString != null)
      {
        ArrayMap localArrayMap = new ArrayMap();
        if (paramString.wBS) {
          localArrayMap.put("outSns", Integer.valueOf(1));
        }
        a.a(paramString.wBQ, paramString.dvK, paramString.wBR, 3, "0", localArrayMap);
        AppMethodBeat.o(187296);
        return true;
      }
      ad.i("ApkInstalledWatcherManager", "onAppInstalled is called, but the pkg is not existed!");
      AppMethodBeat.o(187296);
      return false;
    }
  }
  
  final class b
    implements Runnable
  {
    volatile boolean mStarted = false;
    
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(187297);
      try
      {
        d.a(d.this);
        if (d.b(d.this))
        {
          aq.n(this, 300000L);
          ad.i("ApkInstalledWatcherManager", "there are some watcher info, the timer is going on");
          AppMethodBeat.o(187297);
          return;
        }
        d.c(d.this);
        this.mStarted = false;
        ad.i("ApkInstalledWatcherManager", "the timer is end!");
        AppMethodBeat.o(187297);
        return;
      }
      catch (Throwable localThrowable)
      {
        ad.e("ApkInstalledWatcherManager", "there is something wrong in timer run function");
        AppMethodBeat.o(187297);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.device.appstore.d
 * JD-Core Version:    0.7.0.1
 */