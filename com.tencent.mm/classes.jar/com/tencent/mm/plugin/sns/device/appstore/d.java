package com.tencent.mm.plugin.sns.device.appstore;

import android.content.Context;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d
{
  private static d DFf = null;
  private ApkInstalledWatcher DFb;
  private boolean DFc;
  private final Map<String, e> DFd;
  private final b DFe;
  
  private d()
  {
    AppMethodBeat.i(202650);
    this.DFc = false;
    this.DFd = new HashMap();
    this.DFb = new a((byte)0);
    this.DFe = new b((byte)0);
    AppMethodBeat.o(202650);
  }
  
  public static void a(e parame)
  {
    try
    {
      AppMethodBeat.i(202648);
      try
      {
        eZD().b(parame);
        AppMethodBeat.o(202648);
      }
      catch (Throwable parame)
      {
        for (;;)
        {
          Log.e("ApkInstalledWatcherManager", "watchStatic: watch info failed!");
          AppMethodBeat.o(202648);
        }
      }
      return;
    }
    finally {}
  }
  
  private e aOC(String paramString)
  {
    AppMethodBeat.i(202654);
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.DFd)
      {
        paramString = (e)this.DFd.remove(paramString);
        AppMethodBeat.o(202654);
        return paramString;
      }
    }
    AppMethodBeat.o(202654);
    return null;
  }
  
  private void b(e parame)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(202651);
        Log.i("ApkInstalledWatcherManager", "watch is called");
        if (parame == null)
        {
          if (i != 0) {
            break label72;
          }
          AppMethodBeat.o(202651);
          return;
        }
        if ((TextUtils.isEmpty(parame.DFh)) || (TextUtils.isEmpty(parame.DFi)))
        {
          Log.i("ApkInstalledWatcherManager", "checkWatchInfo is called, the input param is invalid");
          continue;
        }
        i = 1;
      }
      finally {}
      continue;
      label72:
      eZE();
      synchronized (this.DFd)
      {
        this.DFd.put(parame.DFh, parame);
        eZG();
        parame = this.DFe;
        if (!parame.mStarted)
        {
          parame.mStarted = true;
          MMHandlerThread.postToMainThreadDelayed(parame, 300000L);
          Log.i("ApkInstalledWatcherManager", "startTimer is called, the timer is to start.");
          AppMethodBeat.o(202651);
        }
      }
      Log.i("ApkInstalledWatcherManager", "startTimer is called, the timer is started!");
      AppMethodBeat.o(202651);
    }
  }
  
  private static d eZD()
  {
    try
    {
      AppMethodBeat.i(202649);
      if (DFf == null) {
        DFf = new d();
      }
      d locald = DFf;
      AppMethodBeat.o(202649);
      return locald;
    }
    finally {}
  }
  
  private void eZE()
  {
    try
    {
      AppMethodBeat.i(202652);
      try
      {
        if (this.DFb == null) {
          this.DFb = new a((byte)0);
        }
        if (!this.DFc)
        {
          Log.i("ApkInstalledWatcherManager", "registerWatcher: the watcher is to be registered");
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
          localIntentFilter.addDataScheme("package");
          MMApplicationContext.getContext().registerReceiver(this.DFb, localIntentFilter);
          this.DFc = true;
        }
        AppMethodBeat.o(202652);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.e("ApkInstalledWatcherManager", "register ApkInstalledWatcher failed");
          AppMethodBeat.o(202652);
        }
      }
      return;
    }
    finally {}
  }
  
  private void eZF()
  {
    try
    {
      AppMethodBeat.i(202653);
      try
      {
        if ((this.DFb != null) && (this.DFc))
        {
          MMApplicationContext.getContext().unregisterReceiver(this.DFb);
          this.DFc = false;
        }
        AppMethodBeat.o(202653);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.e("ApkInstalledWatcherManager", "unregister ApkInstalledWatcher failed");
          AppMethodBeat.o(202653);
        }
      }
      return;
    }
    finally {}
  }
  
  private void eZG()
  {
    AppMethodBeat.i(202655);
    synchronized (this.DFd)
    {
      Iterator localIterator = this.DFd.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry.getValue() == null) {
          break label92;
        }
        if (((e)localEntry.getValue()).DFk + 300000L < SystemClock.elapsedRealtime()) {
          localIterator.remove();
        }
      }
      AppMethodBeat.o(202655);
      return;
      label92:
      localIterator.remove();
    }
  }
  
  private boolean eZH()
  {
    AppMethodBeat.i(202656);
    synchronized (this.DFd)
    {
      if (!this.DFd.isEmpty())
      {
        bool = true;
        AppMethodBeat.o(202656);
        return bool;
      }
      boolean bool = false;
    }
  }
  
  final class a
    extends ApkInstalledWatcher
  {
    private a() {}
    
    protected final boolean aOB(String paramString)
    {
      AppMethodBeat.i(202646);
      paramString = d.a(d.this, paramString);
      if (paramString != null)
      {
        ArrayMap localArrayMap = new ArrayMap();
        if (paramString.DFj) {
          localArrayMap.put("outSns", Integer.valueOf(1));
        }
        a.a(paramString.DFi, paramString.uxInfo, paramString.adExtInfo, 3, "0", localArrayMap);
        AppMethodBeat.o(202646);
        return true;
      }
      Log.i("ApkInstalledWatcherManager", "onAppInstalled is called, but the pkg is not existed!");
      AppMethodBeat.o(202646);
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
      AppMethodBeat.i(202647);
      try
      {
        d.a(d.this);
        if (d.b(d.this))
        {
          MMHandlerThread.postToMainThreadDelayed(this, 300000L);
          Log.i("ApkInstalledWatcherManager", "there are some watcher info, the timer is going on");
          AppMethodBeat.o(202647);
          return;
        }
        d.c(d.this);
        this.mStarted = false;
        Log.i("ApkInstalledWatcherManager", "the timer is end!");
        AppMethodBeat.o(202647);
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.e("ApkInstalledWatcherManager", "there is something wrong in timer run function");
        AppMethodBeat.o(202647);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.device.appstore.d
 * JD-Core Version:    0.7.0.1
 */