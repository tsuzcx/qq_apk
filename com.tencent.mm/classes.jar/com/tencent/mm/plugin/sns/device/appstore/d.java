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
  private static d zec = null;
  private ApkInstalledWatcher zdY;
  private boolean zdZ;
  private final Map<String, e> zea;
  private final b zeb;
  
  private d()
  {
    AppMethodBeat.i(197806);
    this.zdZ = false;
    this.zea = new HashMap();
    this.zdY = new a((byte)0);
    this.zeb = new b((byte)0);
    AppMethodBeat.o(197806);
  }
  
  public static void a(e parame)
  {
    try
    {
      AppMethodBeat.i(197804);
      try
      {
        dSV().b(parame);
        AppMethodBeat.o(197804);
      }
      catch (Throwable parame)
      {
        for (;;)
        {
          ad.e("ApkInstalledWatcherManager", "watchStatic: watch info failed!");
          AppMethodBeat.o(197804);
        }
      }
      return;
    }
    finally {}
  }
  
  private e ayo(String paramString)
  {
    AppMethodBeat.i(197810);
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.zea)
      {
        paramString = (e)this.zea.remove(paramString);
        AppMethodBeat.o(197810);
        return paramString;
      }
    }
    AppMethodBeat.o(197810);
    return null;
  }
  
  private void b(e parame)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(197807);
        ad.i("ApkInstalledWatcherManager", "watch is called");
        if (parame == null)
        {
          if (i != 0) {
            break label72;
          }
          AppMethodBeat.o(197807);
          return;
        }
        if ((TextUtils.isEmpty(parame.zee)) || (TextUtils.isEmpty(parame.zef)))
        {
          ad.i("ApkInstalledWatcherManager", "checkWatchInfo is called, the input param is invalid");
          continue;
        }
        i = 1;
      }
      finally {}
      continue;
      label72:
      dSW();
      synchronized (this.zea)
      {
        this.zea.put(parame.zee, parame);
        dSY();
        parame = this.zeb;
        if (!parame.mStarted)
        {
          parame.mStarted = true;
          aq.o(parame, 300000L);
          ad.i("ApkInstalledWatcherManager", "startTimer is called, the timer is to start.");
          AppMethodBeat.o(197807);
        }
      }
      ad.i("ApkInstalledWatcherManager", "startTimer is called, the timer is started!");
      AppMethodBeat.o(197807);
    }
  }
  
  private static d dSV()
  {
    try
    {
      AppMethodBeat.i(197805);
      if (zec == null) {
        zec = new d();
      }
      d locald = zec;
      AppMethodBeat.o(197805);
      return locald;
    }
    finally {}
  }
  
  private void dSW()
  {
    try
    {
      AppMethodBeat.i(197808);
      try
      {
        if (this.zdY == null) {
          this.zdY = new a((byte)0);
        }
        if (!this.zdZ)
        {
          ad.i("ApkInstalledWatcherManager", "registerWatcher: the watcher is to be registered");
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
          localIntentFilter.addDataScheme("package");
          aj.getContext().registerReceiver(this.zdY, localIntentFilter);
          this.zdZ = true;
        }
        AppMethodBeat.o(197808);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ad.e("ApkInstalledWatcherManager", "register ApkInstalledWatcher failed");
          AppMethodBeat.o(197808);
        }
      }
      return;
    }
    finally {}
  }
  
  private void dSX()
  {
    try
    {
      AppMethodBeat.i(197809);
      try
      {
        if ((this.zdY != null) && (this.zdZ))
        {
          aj.getContext().unregisterReceiver(this.zdY);
          this.zdZ = false;
        }
        AppMethodBeat.o(197809);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ad.e("ApkInstalledWatcherManager", "unregister ApkInstalledWatcher failed");
          AppMethodBeat.o(197809);
        }
      }
      return;
    }
    finally {}
  }
  
  private void dSY()
  {
    AppMethodBeat.i(197811);
    synchronized (this.zea)
    {
      Iterator localIterator = this.zea.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry.getValue() == null) {
          break label92;
        }
        if (((e)localEntry.getValue()).zei + 300000L < SystemClock.elapsedRealtime()) {
          localIterator.remove();
        }
      }
      AppMethodBeat.o(197811);
      return;
      label92:
      localIterator.remove();
    }
  }
  
  private boolean dSZ()
  {
    AppMethodBeat.i(197812);
    synchronized (this.zea)
    {
      if (!this.zea.isEmpty())
      {
        bool = true;
        AppMethodBeat.o(197812);
        return bool;
      }
      boolean bool = false;
    }
  }
  
  final class a
    extends ApkInstalledWatcher
  {
    private a() {}
    
    protected final boolean ayn(String paramString)
    {
      AppMethodBeat.i(197802);
      paramString = d.a(d.this, paramString);
      if (paramString != null)
      {
        ArrayMap localArrayMap = new ArrayMap();
        if (paramString.zeh) {
          localArrayMap.put("outSns", Integer.valueOf(1));
        }
        a.a(paramString.zef, paramString.dFy, paramString.zeg, 3, "0", localArrayMap);
        AppMethodBeat.o(197802);
        return true;
      }
      ad.i("ApkInstalledWatcherManager", "onAppInstalled is called, but the pkg is not existed!");
      AppMethodBeat.o(197802);
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
      AppMethodBeat.i(197803);
      try
      {
        d.a(d.this);
        if (d.b(d.this))
        {
          aq.o(this, 300000L);
          ad.i("ApkInstalledWatcherManager", "there are some watcher info, the timer is going on");
          AppMethodBeat.o(197803);
          return;
        }
        d.c(d.this);
        this.mStarted = false;
        ad.i("ApkInstalledWatcherManager", "the timer is end!");
        AppMethodBeat.o(197803);
        return;
      }
      catch (Throwable localThrowable)
      {
        ad.e("ApkInstalledWatcherManager", "there is something wrong in timer run function");
        AppMethodBeat.o(197803);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.device.appstore.d
 * JD-Core Version:    0.7.0.1
 */