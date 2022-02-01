package com.google.android.gms.wearable;

import android.content.ComponentName;
import android.os.Binder;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.l;
import com.google.android.gms.wearable.internal.an;
import com.google.android.gms.wearable.internal.ca;
import com.google.android.gms.wearable.internal.zzbz;
import com.google.android.gms.wearable.internal.zzcc;
import com.google.android.gms.wearable.internal.zzh;
import com.google.android.gms.wearable.internal.zzk;
import com.google.android.gms.wearable.internal.zzo;
import com.google.android.gms.wearable.internal.zzs;
import java.util.List;

final class ae
  extends an
{
  private volatile int UF = -1;
  
  private ae(WearableListenerService paramWearableListenerService) {}
  
  private boolean a(Runnable paramRunnable, String arg2, Object paramObject)
  {
    if (Log.isLoggable("WearableLS", 3)) {
      Log.d("WearableLS", String.format("%s: %s %s", new Object[] { ???, WearableListenerService.a(this.UE).toString(), paramObject }));
    }
    int i = Binder.getCallingUid();
    if (i == this.UF) {
      i = 1;
    }
    while (i == 0)
    {
      return false;
      if ((ca.w(this.UE).y("com.google.android.wearable.app.cn")) && (l.b(this.UE, i, "com.google.android.wearable.app.cn")))
      {
        this.UF = i;
        i = 1;
      }
      else if (l.h(this.UE, i))
      {
        this.UF = i;
        i = 1;
      }
      else
      {
        Log.e("WearableLS", 57 + "Caller is not GooglePlayServices; caller UID: " + i);
        i = 0;
      }
    }
    synchronized (WearableListenerService.c(this.UE))
    {
      if (WearableListenerService.d(this.UE)) {
        return false;
      }
    }
    WearableListenerService.e(this.UE).post(paramRunnable);
    return true;
  }
  
  public final void a(final DataHolder paramDataHolder)
  {
    Runnable local1 = new Runnable()
    {
      public final void run()
      {
        k localk = new k(paramDataHolder);
        try
        {
          ae.this.UE.a(localk);
          return;
        }
        finally
        {
          localk.release();
        }
      }
    };
    try
    {
      String str = String.valueOf(paramDataHolder);
      int i = paramDataHolder.getCount();
      boolean bool = a(local1, "onDataItemChanged", String.valueOf(str).length() + 18 + str + ", rows=" + i);
      if (!bool) {}
      return;
    }
    finally
    {
      paramDataHolder.close();
    }
  }
  
  public final void a(final zzbz paramzzbz)
  {
    a(new Runnable()
    {
      public final void run()
      {
        ae.this.UE.a(paramzzbz);
      }
    }, "onMessageReceived", paramzzbz);
  }
  
  public final void a(final zzcc paramzzcc)
  {
    a(new Runnable()
    {
      public final void run()
      {
        ae.this.UE.kJ();
      }
    }, "onPeerConnected", paramzzcc);
  }
  
  public final void a(final zzh paramzzh)
  {
    a(new Runnable()
    {
      public final void run() {}
    }, "onEntityUpdate", paramzzh);
  }
  
  public final void a(final zzk paramzzk)
  {
    a(new Runnable()
    {
      public final void run() {}
    }, "onNotificationReceived", paramzzk);
  }
  
  public final void a(final zzo paramzzo)
  {
    a(new Runnable()
    {
      public final void run() {}
    }, "onConnectedCapabilityChanged", paramzzo);
  }
  
  public final void a(final zzs paramzzs)
  {
    a(new Runnable()
    {
      public final void run()
      {
        paramzzs.a(ae.this.UE);
      }
    }, "onChannelEvent", paramzzs);
  }
  
  public final void b(final zzcc paramzzcc)
  {
    a(new Runnable()
    {
      public final void run()
      {
        ae.this.UE.kK();
      }
    }, "onPeerDisconnected", paramzzcc);
  }
  
  public final void j(final List<zzcc> paramList)
  {
    a(new Runnable()
    {
      public final void run() {}
    }, "onConnectedNodes", paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.ae
 * JD-Core Version:    0.7.0.1
 */