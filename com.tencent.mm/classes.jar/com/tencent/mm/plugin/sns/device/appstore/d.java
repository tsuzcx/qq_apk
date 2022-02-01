package com.tencent.mm.plugin.sns.device.appstore;

import android.content.Context;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d
{
  private static d zuS = null;
  private ApkInstalledWatcher zuO;
  private boolean zuP;
  private final Map<String, e> zuQ;
  private final b zuR;
  
  private d()
  {
    AppMethodBeat.i(219289);
    this.zuP = false;
    this.zuQ = new HashMap();
    this.zuO = new a((byte)0);
    this.zuR = new b((byte)0);
    AppMethodBeat.o(219289);
  }
  
  public static void a(e parame)
  {
    try
    {
      AppMethodBeat.i(219287);
      try
      {
        dWv().b(parame);
        AppMethodBeat.o(219287);
      }
      catch (Throwable parame)
      {
        for (;;)
        {
          ae.e("ApkInstalledWatcherManager", "watchStatic: watch info failed!");
          AppMethodBeat.o(219287);
        }
      }
      return;
    }
    finally {}
  }
  
  private e azF(String paramString)
  {
    AppMethodBeat.i(219293);
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.zuQ)
      {
        paramString = (e)this.zuQ.remove(paramString);
        AppMethodBeat.o(219293);
        return paramString;
      }
    }
    AppMethodBeat.o(219293);
    return null;
  }
  
  private void b(e parame)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(219290);
        ae.i("ApkInstalledWatcherManager", "watch is called");
        if (parame == null)
        {
          if (i != 0) {
            break label72;
          }
          AppMethodBeat.o(219290);
          return;
        }
        if ((TextUtils.isEmpty(parame.zuU)) || (TextUtils.isEmpty(parame.zuV)))
        {
          ae.i("ApkInstalledWatcherManager", "checkWatchInfo is called, the input param is invalid");
          continue;
        }
        i = 1;
      }
      finally {}
      continue;
      label72:
      dWw();
      synchronized (this.zuQ)
      {
        this.zuQ.put(parame.zuU, parame);
        dWy();
        parame = this.zuR;
        if (!parame.mStarted)
        {
          parame.mStarted = true;
          ar.o(parame, 300000L);
          ae.i("ApkInstalledWatcherManager", "startTimer is called, the timer is to start.");
          AppMethodBeat.o(219290);
        }
      }
      ae.i("ApkInstalledWatcherManager", "startTimer is called, the timer is started!");
      AppMethodBeat.o(219290);
    }
  }
  
  private static d dWv()
  {
    try
    {
      AppMethodBeat.i(219288);
      if (zuS == null) {
        zuS = new d();
      }
      d locald = zuS;
      AppMethodBeat.o(219288);
      return locald;
    }
    finally {}
  }
  
  private void dWw()
  {
    try
    {
      AppMethodBeat.i(219291);
      try
      {
        if (this.zuO == null) {
          this.zuO = new a((byte)0);
        }
        if (!this.zuP)
        {
          ae.i("ApkInstalledWatcherManager", "registerWatcher: the watcher is to be registered");
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
          localIntentFilter.addDataScheme("package");
          ak.getContext().registerReceiver(this.zuO, localIntentFilter);
          this.zuP = true;
        }
        AppMethodBeat.o(219291);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ae.e("ApkInstalledWatcherManager", "register ApkInstalledWatcher failed");
          AppMethodBeat.o(219291);
        }
      }
      return;
    }
    finally {}
  }
  
  private void dWx()
  {
    try
    {
      AppMethodBeat.i(219292);
      try
      {
        if ((this.zuO != null) && (this.zuP))
        {
          ak.getContext().unregisterReceiver(this.zuO);
          this.zuP = false;
        }
        AppMethodBeat.o(219292);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ae.e("ApkInstalledWatcherManager", "unregister ApkInstalledWatcher failed");
          AppMethodBeat.o(219292);
        }
      }
      return;
    }
    finally {}
  }
  
  private void dWy()
  {
    AppMethodBeat.i(219294);
    synchronized (this.zuQ)
    {
      Iterator localIterator = this.zuQ.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry.getValue() == null) {
          break label92;
        }
        if (((e)localEntry.getValue()).zuX + 300000L < SystemClock.elapsedRealtime()) {
          localIterator.remove();
        }
      }
      AppMethodBeat.o(219294);
      return;
      label92:
      localIterator.remove();
    }
  }
  
  private boolean dWz()
  {
    AppMethodBeat.i(219295);
    synchronized (this.zuQ)
    {
      if (!this.zuQ.isEmpty())
      {
        bool = true;
        AppMethodBeat.o(219295);
        return bool;
      }
      boolean bool = false;
    }
  }
  
  final class a
    extends ApkInstalledWatcher
  {
    private a() {}
    
    protected final boolean azE(String paramString)
    {
      AppMethodBeat.i(219285);
      paramString = d.a(d.this, paramString);
      if (paramString != null)
      {
        ArrayMap localArrayMap = new ArrayMap();
        if (paramString.zuW) {
          localArrayMap.put("outSns", Integer.valueOf(1));
        }
        a.a(paramString.zuV, paramString.dGD, paramString.zsJ, 3, "0", localArrayMap);
        AppMethodBeat.o(219285);
        return true;
      }
      ae.i("ApkInstalledWatcherManager", "onAppInstalled is called, but the pkg is not existed!");
      AppMethodBeat.o(219285);
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
      AppMethodBeat.i(219286);
      try
      {
        d.a(d.this);
        if (d.b(d.this))
        {
          ar.o(this, 300000L);
          ae.i("ApkInstalledWatcherManager", "there are some watcher info, the timer is going on");
          AppMethodBeat.o(219286);
          return;
        }
        d.c(d.this);
        this.mStarted = false;
        ae.i("ApkInstalledWatcherManager", "the timer is end!");
        AppMethodBeat.o(219286);
        return;
      }
      catch (Throwable localThrowable)
      {
        ae.e("ApkInstalledWatcherManager", "there is something wrong in timer run function");
        AppMethodBeat.o(219286);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.device.appstore.d
 * JD-Core Version:    0.7.0.1
 */