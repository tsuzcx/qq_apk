package com.tencent.mm.plugin.sns.device.appstore;

import android.content.Context;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d
{
  private static d xOi = null;
  private ApkInstalledWatcher xOe;
  private boolean xOf;
  private final Map<String, e> xOg;
  private final b xOh;
  
  private d()
  {
    AppMethodBeat.i(200081);
    this.xOf = false;
    this.xOg = new HashMap();
    this.xOe = new a((byte)0);
    this.xOh = new b((byte)0);
    AppMethodBeat.o(200081);
  }
  
  public static void a(e parame)
  {
    try
    {
      AppMethodBeat.i(200079);
      try
      {
        dGI().b(parame);
        AppMethodBeat.o(200079);
      }
      catch (Throwable parame)
      {
        for (;;)
        {
          ac.e("ApkInstalledWatcherManager", "watchStatic: watch info failed!");
          AppMethodBeat.o(200079);
        }
      }
      return;
    }
    finally {}
  }
  
  private e atj(String paramString)
  {
    AppMethodBeat.i(200085);
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.xOg)
      {
        paramString = (e)this.xOg.remove(paramString);
        AppMethodBeat.o(200085);
        return paramString;
      }
    }
    AppMethodBeat.o(200085);
    return null;
  }
  
  private void b(e parame)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(200082);
        ac.i("ApkInstalledWatcherManager", "watch is called");
        if (parame == null)
        {
          if (i != 0) {
            break label72;
          }
          AppMethodBeat.o(200082);
          return;
        }
        if ((TextUtils.isEmpty(parame.xOk)) || (TextUtils.isEmpty(parame.xOl)))
        {
          ac.i("ApkInstalledWatcherManager", "checkWatchInfo is called, the input param is invalid");
          continue;
        }
        i = 1;
      }
      finally {}
      continue;
      label72:
      dGJ();
      synchronized (this.xOg)
      {
        this.xOg.put(parame.xOk, parame);
        dGL();
        parame = this.xOh;
        if (!parame.mStarted)
        {
          parame.mStarted = true;
          ap.n(parame, 300000L);
          ac.i("ApkInstalledWatcherManager", "startTimer is called, the timer is to start.");
          AppMethodBeat.o(200082);
        }
      }
      ac.i("ApkInstalledWatcherManager", "startTimer is called, the timer is started!");
      AppMethodBeat.o(200082);
    }
  }
  
  private static d dGI()
  {
    try
    {
      AppMethodBeat.i(200080);
      if (xOi == null) {
        xOi = new d();
      }
      d locald = xOi;
      AppMethodBeat.o(200080);
      return locald;
    }
    finally {}
  }
  
  private void dGJ()
  {
    try
    {
      AppMethodBeat.i(200083);
      try
      {
        if (this.xOe == null) {
          this.xOe = new a((byte)0);
        }
        if (!this.xOf)
        {
          ac.i("ApkInstalledWatcherManager", "registerWatcher: the watcher is to be registered");
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
          localIntentFilter.addDataScheme("package");
          ai.getContext().registerReceiver(this.xOe, localIntentFilter);
          this.xOf = true;
        }
        AppMethodBeat.o(200083);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ac.e("ApkInstalledWatcherManager", "register ApkInstalledWatcher failed");
          AppMethodBeat.o(200083);
        }
      }
      return;
    }
    finally {}
  }
  
  private void dGK()
  {
    try
    {
      AppMethodBeat.i(200084);
      try
      {
        if ((this.xOe != null) && (this.xOf))
        {
          ai.getContext().unregisterReceiver(this.xOe);
          this.xOf = false;
        }
        AppMethodBeat.o(200084);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ac.e("ApkInstalledWatcherManager", "unregister ApkInstalledWatcher failed");
          AppMethodBeat.o(200084);
        }
      }
      return;
    }
    finally {}
  }
  
  private void dGL()
  {
    AppMethodBeat.i(200086);
    synchronized (this.xOg)
    {
      Iterator localIterator = this.xOg.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry.getValue() == null) {
          break label92;
        }
        if (((e)localEntry.getValue()).xOo + 300000L < SystemClock.elapsedRealtime()) {
          localIterator.remove();
        }
      }
      AppMethodBeat.o(200086);
      return;
      label92:
      localIterator.remove();
    }
  }
  
  private boolean dGM()
  {
    AppMethodBeat.i(200087);
    synchronized (this.xOg)
    {
      if (!this.xOg.isEmpty())
      {
        bool = true;
        AppMethodBeat.o(200087);
        return bool;
      }
      boolean bool = false;
    }
  }
  
  final class a
    extends ApkInstalledWatcher
  {
    private a() {}
    
    protected final boolean ati(String paramString)
    {
      AppMethodBeat.i(200077);
      paramString = d.a(d.this, paramString);
      if (paramString != null)
      {
        ArrayMap localArrayMap = new ArrayMap();
        if (paramString.xOn) {
          localArrayMap.put("outSns", Integer.valueOf(1));
        }
        a.a(paramString.xOl, paramString.dtx, paramString.xOm, 3, "0", localArrayMap);
        AppMethodBeat.o(200077);
        return true;
      }
      ac.i("ApkInstalledWatcherManager", "onAppInstalled is called, but the pkg is not existed!");
      AppMethodBeat.o(200077);
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
      AppMethodBeat.i(200078);
      try
      {
        d.a(d.this);
        if (d.b(d.this))
        {
          ap.n(this, 300000L);
          ac.i("ApkInstalledWatcherManager", "there are some watcher info, the timer is going on");
          AppMethodBeat.o(200078);
          return;
        }
        d.c(d.this);
        this.mStarted = false;
        ac.i("ApkInstalledWatcherManager", "the timer is end!");
        AppMethodBeat.o(200078);
        return;
      }
      catch (Throwable localThrowable)
      {
        ac.e("ApkInstalledWatcherManager", "there is something wrong in timer run function");
        AppMethodBeat.o(200078);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.device.appstore.d
 * JD-Core Version:    0.7.0.1
 */