package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.stats.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class ai
  implements ServiceConnection
{
  private IBinder KI;
  private ComponentName Mi;
  private final Set<ServiceConnection> Mn;
  private boolean Mo;
  private final ag Mp;
  private int cs;
  
  public ai(ah paramah, ag paramag)
  {
    this.Mp = paramag;
    this.Mn = new HashSet();
    this.cs = 2;
  }
  
  public final void a(ServiceConnection paramServiceConnection)
  {
    ah.d(this.Mq);
    ah.c(this.Mq);
    this.Mp.hH();
    this.Mn.add(paramServiceConnection);
  }
  
  public final void b(ServiceConnection paramServiceConnection)
  {
    ah.d(this.Mq);
    ah.c(this.Mq);
    this.Mn.remove(paramServiceConnection);
  }
  
  public final boolean c(ServiceConnection paramServiceConnection)
  {
    return this.Mn.contains(paramServiceConnection);
  }
  
  public final IBinder getBinder()
  {
    return this.KI;
  }
  
  public final ComponentName getComponentName()
  {
    return this.Mi;
  }
  
  public final int getState()
  {
    return this.cs;
  }
  
  public final void hI()
  {
    this.cs = 3;
    ah.d(this.Mq);
    this.Mo = a.a(ah.c(this.Mq), this.Mp.hH(), this);
    if (this.Mo)
    {
      Message localMessage = ah.b(this.Mq).obtainMessage(1, this.Mp);
      ah.b(this.Mq).sendMessageDelayed(localMessage, ah.e(this.Mq));
      return;
    }
    this.cs = 2;
    try
    {
      ah.d(this.Mq);
      a.a(ah.c(this.Mq), this);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
  }
  
  public final void hJ()
  {
    ah.b(this.Mq).removeMessages(1, this.Mp);
    ah.d(this.Mq);
    a.a(ah.c(this.Mq), this);
    this.Mo = false;
    this.cs = 2;
  }
  
  public final boolean hK()
  {
    return this.Mn.isEmpty();
  }
  
  public final boolean isBound()
  {
    return this.Mo;
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    synchronized (ah.a(this.Mq))
    {
      ah.b(this.Mq).removeMessages(1, this.Mp);
      this.KI = paramIBinder;
      this.Mi = paramComponentName;
      Iterator localIterator = this.Mn.iterator();
      if (localIterator.hasNext()) {
        ((ServiceConnection)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
      }
    }
    this.cs = 1;
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    synchronized (ah.a(this.Mq))
    {
      ah.b(this.Mq).removeMessages(1, this.Mp);
      this.KI = null;
      this.Mi = paramComponentName;
      Iterator localIterator = this.Mn.iterator();
      if (localIterator.hasNext()) {
        ((ServiceConnection)localIterator.next()).onServiceDisconnected(paramComponentName);
      }
    }
    this.cs = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.ai
 * JD-Core Version:    0.7.0.1
 */