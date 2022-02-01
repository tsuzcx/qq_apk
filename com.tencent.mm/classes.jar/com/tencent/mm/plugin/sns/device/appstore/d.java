package com.tencent.mm.plugin.sns.device.appstore;

import android.content.Context;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.d.c;
import com.tencent.mm.plugin.sns.data.b;
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
  private static d QoM = null;
  private ApkInstalledWatcher QoI;
  private boolean QoJ;
  private final Map<String, e> QoK;
  private final b QoL;
  
  private d()
  {
    AppMethodBeat.i(306368);
    this.QoJ = false;
    this.QoK = new HashMap();
    this.QoI = new a((byte)0);
    this.QoL = new b((byte)0);
    AppMethodBeat.o(306368);
  }
  
  public static void a(e parame)
  {
    try
    {
      AppMethodBeat.i(306349);
      try
      {
        heX().b(parame);
        AppMethodBeat.o(306349);
      }
      finally
      {
        for (;;)
        {
          parame = finally;
          Log.e("ApkInstalledWatcherManager", "watchStatic: watch info failed!");
          AppMethodBeat.o(306349);
        }
      }
      return;
    }
    finally {}
  }
  
  private e aXJ(String paramString)
  {
    AppMethodBeat.i(306405);
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.QoK)
      {
        paramString = (e)this.QoK.remove(paramString);
        AppMethodBeat.o(306405);
        return paramString;
      }
    }
    AppMethodBeat.o(306405);
    return null;
  }
  
  private void b(e parame)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(306380);
        Log.i("ApkInstalledWatcherManager", "watch is called");
        if (parame == null)
        {
          if (i != 0) {
            break label72;
          }
          AppMethodBeat.o(306380);
          return;
        }
        if ((TextUtils.isEmpty(parame.QoO)) || (TextUtils.isEmpty(parame.QoP)))
        {
          Log.i("ApkInstalledWatcherManager", "checkWatchInfo is called, the input param is invalid");
          continue;
        }
        i = 1;
      }
      finally {}
      continue;
      label72:
      heY();
      synchronized (this.QoK)
      {
        this.QoK.put(parame.QoO, parame);
        hfa();
        parame = this.QoL;
        if (!parame.mStarted)
        {
          parame.mStarted = true;
          MMHandlerThread.postToMainThreadDelayed(parame, 300000L);
          Log.i("ApkInstalledWatcherManager", "startTimer is called, the timer is to start.");
          AppMethodBeat.o(306380);
        }
      }
    }
  }
  
  private static d heX()
  {
    try
    {
      AppMethodBeat.i(306359);
      if (QoM == null) {
        QoM = new d();
      }
      d locald = QoM;
      AppMethodBeat.o(306359);
      return locald;
    }
    finally {}
  }
  
  private void heY()
  {
    try
    {
      AppMethodBeat.i(306390);
      try
      {
        if (this.QoI == null) {
          this.QoI = new a((byte)0);
        }
        if (!this.QoJ)
        {
          Log.i("ApkInstalledWatcherManager", "registerWatcher: the watcher is to be registered");
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
          localIntentFilter.addDataScheme("package");
          MMApplicationContext.getContext().registerReceiver(this.QoI, localIntentFilter);
          this.QoJ = true;
        }
        AppMethodBeat.o(306390);
      }
      finally
      {
        for (;;)
        {
          Log.e("ApkInstalledWatcherManager", "register ApkInstalledWatcher failed");
          AppMethodBeat.o(306390);
        }
      }
      return;
    }
    finally {}
  }
  
  private void heZ()
  {
    try
    {
      AppMethodBeat.i(306397);
      try
      {
        if ((this.QoI != null) && (this.QoJ))
        {
          MMApplicationContext.getContext().unregisterReceiver(this.QoI);
          this.QoJ = false;
        }
        AppMethodBeat.o(306397);
      }
      finally
      {
        for (;;)
        {
          localObject1 = finally;
          Log.e("ApkInstalledWatcherManager", "unregister ApkInstalledWatcher failed");
          AppMethodBeat.o(306397);
        }
      }
      return;
    }
    finally {}
  }
  
  private void hfa()
  {
    AppMethodBeat.i(306415);
    synchronized (this.QoK)
    {
      Iterator localIterator = this.QoK.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry.getValue() == null) {
          break label92;
        }
        if (((e)localEntry.getValue()).QoR + 300000L < SystemClock.elapsedRealtime()) {
          localIterator.remove();
        }
      }
      AppMethodBeat.o(306415);
      return;
      label92:
      localIterator.remove();
    }
  }
  
  private boolean hfb()
  {
    AppMethodBeat.i(306418);
    synchronized (this.QoK)
    {
      if (!this.QoK.isEmpty())
      {
        bool = true;
        AppMethodBeat.o(306418);
        return bool;
      }
      boolean bool = false;
    }
  }
  
  final class a
    extends ApkInstalledWatcher
  {
    private a() {}
    
    protected final boolean aXI(String paramString)
    {
      AppMethodBeat.i(306344);
      paramString = d.a(d.this, paramString);
      if (paramString != null)
      {
        Object localObject = new ArrayMap();
        if (paramString.QoQ) {
          ((Map)localObject).put("outSns", Integer.valueOf(1));
        }
        a.a(paramString.QoP, paramString.uxInfo, paramString.adExtInfo, 3, "0", (Map)localObject);
        if ((paramString.PNI != null) && (paramString.PNI.getAdXml() != null))
        {
          localObject = new b(paramString.PNI.getUxinfo(), paramString.PNI.getAdXml().adExtInfo, paramString.PNI.getAid(), paramString.PNI.getTraceid(), paramString.PNI.getPid());
          ((b)localObject).Qmp = ((int)(System.currentTimeMillis() - paramString.QoS));
          c.c((b)localObject, 1);
        }
        AppMethodBeat.o(306344);
        return true;
      }
      Log.i("ApkInstalledWatcherManager", "onAppInstalled is called, but the pkg is not existed!");
      AppMethodBeat.o(306344);
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
      AppMethodBeat.i(306340);
      try
      {
        d.a(d.this);
        if (d.b(d.this))
        {
          MMHandlerThread.postToMainThreadDelayed(this, 300000L);
          return;
        }
        d.c(d.this);
        this.mStarted = false;
        return;
      }
      finally
      {
        Log.e("ApkInstalledWatcherManager", "there is something wrong in timer run function");
        AppMethodBeat.o(306340);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.device.appstore.d
 * JD-Core Version:    0.7.0.1
 */