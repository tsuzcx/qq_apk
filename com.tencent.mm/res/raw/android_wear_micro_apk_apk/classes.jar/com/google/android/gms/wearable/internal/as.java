package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class as<T>
{
  private final Map<T, bz<T>> Tz = new HashMap();
  
  public final void a(by paramby, h<Status> paramh, T paramT)
  {
    synchronized (this.Tz)
    {
      bz localbz = (bz)this.Tz.remove(paramT);
      if (localbz == null)
      {
        paramh.x(new Status(4002));
        return;
      }
      localbz.clear();
      ((ap)paramby.hh()).a(new au(this.Tz, paramT, paramh), new zzck(localbz));
      return;
    }
  }
  
  public final void a(by paramby, h<Status> paramh, T paramT, bz<T> parambz)
  {
    synchronized (this.Tz)
    {
      if (this.Tz.get(paramT) != null)
      {
        paramh.x(new Status(4001));
        return;
      }
      this.Tz.put(paramT, parambz);
    }
  }
  
  public final void r(IBinder paramIBinder)
  {
    synchronized (this.Tz)
    {
      paramIBinder = aq.q(paramIBinder);
      bt localbt = new bt();
      Iterator localIterator = this.Tz.entrySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Object localObject2 = (Map.Entry)localIterator.next();
          Object localObject1 = (bz)((Map.Entry)localObject2).getValue();
          try
          {
            paramIBinder.a(localbt, new zzc((bz)localObject1));
            if (Log.isLoggable("WearableClient", 2))
            {
              String str1 = String.valueOf(((Map.Entry)localObject2).getKey());
              String str2 = String.valueOf(localObject1);
              Log.d("WearableClient", String.valueOf(str1).length() + 27 + String.valueOf(str2).length() + "onPostInitHandler: added: " + str1 + "/" + str2);
            }
          }
          catch (RemoteException localRemoteException)
          {
            localObject2 = String.valueOf(((Map.Entry)localObject2).getKey());
            localObject1 = String.valueOf(localObject1);
            Log.d("WearableClient", String.valueOf(localObject2).length() + 32 + String.valueOf(localObject1).length() + "onPostInitHandler: Didn't add: " + (String)localObject2 + "/" + (String)localObject1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.as
 * JD-Core Version:    0.7.0.1
 */