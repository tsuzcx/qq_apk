package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;

public final class t
  implements ServiceConnection
{
  private final int JO;
  
  public t(l paraml, int paramInt)
  {
    this.JO = paramInt;
  }
  
  public final void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    if (paramIBinder == null)
    {
      this.JK.Y(8, this.JO);
      return;
    }
    synchronized (l.a(this.JK))
    {
      l.a(this.JK, au.g(paramIBinder));
      this.JK.Y(0, this.JO);
      return;
    }
  }
  
  public final void onServiceDisconnected(ComponentName arg1)
  {
    synchronized (l.a(this.JK))
    {
      l.a(this.JK, null);
      this.JK.mHandler.sendMessage(this.JK.mHandler.obtainMessage(4, this.JO, 1));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.t
 * JD-Core Version:    0.7.0.1
 */