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
  private IBinder IT;
  private final ag KA;
  private ComponentName Kt;
  private final Set<ServiceConnection> Ky;
  private boolean Kz;
  private int aJ;
  
  public ai(ah paramah, ag paramag)
  {
    this.KA = paramag;
    this.Ky = new HashSet();
    this.aJ = 2;
  }
  
  public final void a(ServiceConnection paramServiceConnection)
  {
    ah.d(this.KB);
    ah.c(this.KB);
    this.KA.hx();
    a.hS();
    this.Ky.add(paramServiceConnection);
  }
  
  public final void b(ServiceConnection paramServiceConnection)
  {
    ah.d(this.KB);
    ah.c(this.KB);
    a.hT();
    this.Ky.remove(paramServiceConnection);
  }
  
  public final boolean c(ServiceConnection paramServiceConnection)
  {
    return this.Ky.contains(paramServiceConnection);
  }
  
  public final IBinder getBinder()
  {
    return this.IT;
  }
  
  public final ComponentName getComponentName()
  {
    return this.Kt;
  }
  
  public final int getState()
  {
    return this.aJ;
  }
  
  public final boolean hA()
  {
    return this.Ky.isEmpty();
  }
  
  public final void hy()
  {
    this.aJ = 3;
    ah.d(this.KB);
    this.Kz = a.a(ah.c(this.KB), this.KA.hx(), this);
    if (this.Kz)
    {
      Message localMessage = ah.b(this.KB).obtainMessage(1, this.KA);
      ah.b(this.KB).sendMessageDelayed(localMessage, ah.e(this.KB));
      return;
    }
    this.aJ = 2;
    try
    {
      ah.d(this.KB);
      a.a(ah.c(this.KB), this);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
  }
  
  public final void hz()
  {
    ah.b(this.KB).removeMessages(1, this.KA);
    ah.d(this.KB);
    a.a(ah.c(this.KB), this);
    this.Kz = false;
    this.aJ = 2;
  }
  
  public final boolean isBound()
  {
    return this.Kz;
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    synchronized (ah.a(this.KB))
    {
      ah.b(this.KB).removeMessages(1, this.KA);
      this.IT = paramIBinder;
      this.Kt = paramComponentName;
      Iterator localIterator = this.Ky.iterator();
      if (localIterator.hasNext()) {
        ((ServiceConnection)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
      }
    }
    this.aJ = 1;
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    synchronized (ah.a(this.KB))
    {
      ah.b(this.KB).removeMessages(1, this.KA);
      this.IT = null;
      this.Kt = paramComponentName;
      Iterator localIterator = this.Ky.iterator();
      if (localIterator.hasNext()) {
        ((ServiceConnection)localIterator.next()).onServiceDisconnected(paramComponentName);
      }
    }
    this.aJ = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.ai
 * JD-Core Version:    0.7.0.1
 */