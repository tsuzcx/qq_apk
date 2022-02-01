package com.tencent.mm.plugin.sns.device.appstore;

import android.content.Context;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
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
  private static d JSa = null;
  private ApkInstalledWatcher JRW;
  private boolean JRX;
  private final Map<String, e> JRY;
  private final b JRZ;
  
  private d()
  {
    AppMethodBeat.i(220601);
    this.JRX = false;
    this.JRY = new HashMap();
    this.JRW = new a((byte)0);
    this.JRZ = new b((byte)0);
    AppMethodBeat.o(220601);
  }
  
  public static void a(e parame)
  {
    try
    {
      AppMethodBeat.i(220598);
      try
      {
        fNv().b(parame);
        AppMethodBeat.o(220598);
      }
      catch (Throwable parame)
      {
        for (;;)
        {
          Log.e("ApkInstalledWatcherManager", "watchStatic: watch info failed!");
          AppMethodBeat.o(220598);
        }
      }
      return;
    }
    finally {}
  }
  
  private e aZy(String paramString)
  {
    AppMethodBeat.i(220613);
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.JRY)
      {
        paramString = (e)this.JRY.remove(paramString);
        AppMethodBeat.o(220613);
        return paramString;
      }
    }
    AppMethodBeat.o(220613);
    return null;
  }
  
  private void b(e parame)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(220604);
        Log.i("ApkInstalledWatcherManager", "watch is called");
        if (parame == null)
        {
          if (i != 0) {
            break label72;
          }
          AppMethodBeat.o(220604);
          return;
        }
        if ((TextUtils.isEmpty(parame.JSc)) || (TextUtils.isEmpty(parame.JSd)))
        {
          Log.i("ApkInstalledWatcherManager", "checkWatchInfo is called, the input param is invalid");
          continue;
        }
        i = 1;
      }
      finally {}
      continue;
      label72:
      fNw();
      synchronized (this.JRY)
      {
        this.JRY.put(parame.JSc, parame);
        fNy();
        parame = this.JRZ;
        if (!parame.mStarted)
        {
          parame.mStarted = true;
          MMHandlerThread.postToMainThreadDelayed(parame, 300000L);
          Log.i("ApkInstalledWatcherManager", "startTimer is called, the timer is to start.");
          AppMethodBeat.o(220604);
        }
      }
    }
  }
  
  private static d fNv()
  {
    try
    {
      AppMethodBeat.i(220599);
      if (JSa == null) {
        JSa = new d();
      }
      d locald = JSa;
      AppMethodBeat.o(220599);
      return locald;
    }
    finally {}
  }
  
  private void fNw()
  {
    try
    {
      AppMethodBeat.i(220609);
      try
      {
        if (this.JRW == null) {
          this.JRW = new a((byte)0);
        }
        if (!this.JRX)
        {
          Log.i("ApkInstalledWatcherManager", "registerWatcher: the watcher is to be registered");
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
          localIntentFilter.addDataScheme("package");
          MMApplicationContext.getContext().registerReceiver(this.JRW, localIntentFilter);
          this.JRX = true;
        }
        AppMethodBeat.o(220609);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.e("ApkInstalledWatcherManager", "register ApkInstalledWatcher failed");
          AppMethodBeat.o(220609);
        }
      }
      return;
    }
    finally {}
  }
  
  private void fNx()
  {
    try
    {
      AppMethodBeat.i(220611);
      try
      {
        if ((this.JRW != null) && (this.JRX))
        {
          MMApplicationContext.getContext().unregisterReceiver(this.JRW);
          this.JRX = false;
        }
        AppMethodBeat.o(220611);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.e("ApkInstalledWatcherManager", "unregister ApkInstalledWatcher failed");
          AppMethodBeat.o(220611);
        }
      }
      return;
    }
    finally {}
  }
  
  private void fNy()
  {
    AppMethodBeat.i(220619);
    synchronized (this.JRY)
    {
      Iterator localIterator = this.JRY.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry.getValue() == null) {
          break label92;
        }
        if (((e)localEntry.getValue()).JSf + 300000L < SystemClock.elapsedRealtime()) {
          localIterator.remove();
        }
      }
      AppMethodBeat.o(220619);
      return;
      label92:
      localIterator.remove();
    }
  }
  
  private boolean fNz()
  {
    AppMethodBeat.i(220622);
    synchronized (this.JRY)
    {
      if (!this.JRY.isEmpty())
      {
        bool = true;
        AppMethodBeat.o(220622);
        return bool;
      }
      boolean bool = false;
    }
  }
  
  final class a
    extends ApkInstalledWatcher
  {
    private a() {}
    
    protected final boolean aZx(String paramString)
    {
      AppMethodBeat.i(195533);
      paramString = d.a(d.this, paramString);
      if (paramString != null)
      {
        Object localObject = new ArrayMap();
        if (paramString.JSe) {
          ((Map)localObject).put("outSns", Integer.valueOf(1));
        }
        a.a(paramString.JSd, paramString.uxInfo, paramString.adExtInfo, 3, "0", (Map)localObject);
        if ((paramString.Jzk != null) && (paramString.Jzk.getAdXml() != null))
        {
          localObject = new com.tencent.mm.plugin.sns.data.b(paramString.Jzk.getUxinfo(), paramString.Jzk.getAdXml().adExtInfo, paramString.Jzk.getAid(), paramString.Jzk.getTraceid(), paramString.Jzk.getPid());
          ((com.tencent.mm.plugin.sns.data.b)localObject).JPI = ((int)(System.currentTimeMillis() - paramString.JSg));
          com.tencent.mm.plugin.sns.ad.d.b.c((com.tencent.mm.plugin.sns.data.b)localObject, 1);
        }
        AppMethodBeat.o(195533);
        return true;
      }
      Log.i("ApkInstalledWatcherManager", "onAppInstalled is called, but the pkg is not existed!");
      AppMethodBeat.o(195533);
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
      AppMethodBeat.i(266317);
      try
      {
        d.a(d.this);
        if (d.b(d.this))
        {
          MMHandlerThread.postToMainThreadDelayed(this, 300000L);
          Log.i("ApkInstalledWatcherManager", "there are some watcher info, the timer is going on");
          AppMethodBeat.o(266317);
          return;
        }
        d.c(d.this);
        this.mStarted = false;
        Log.i("ApkInstalledWatcherManager", "the timer is end!");
        AppMethodBeat.o(266317);
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.e("ApkInstalledWatcherManager", "there is something wrong in timer run function");
        AppMethodBeat.o(266317);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.device.appstore.d
 * JD-Core Version:    0.7.0.1
 */