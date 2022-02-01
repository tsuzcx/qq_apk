package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;

public final class t
  implements ServiceConnection
{
  private final int LD;
  
  public t(l paraml, int paramInt)
  {
    this.LD = paramInt;
  }
  
  public final void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    if (paramIBinder == null)
    {
      this.Lz.aa(8, this.LD);
      return;
    }
    synchronized (l.a(this.Lz))
    {
      l.a(this.Lz, au.g(paramIBinder));
      this.Lz.aa(0, this.LD);
      return;
    }
  }
  
  public final void onServiceDisconnected(ComponentName arg1)
  {
    synchronized (l.a(this.Lz))
    {
      l.a(this.Lz, null);
      this.Lz.dG.sendMessage(this.Lz.dG.obtainMessage(4, this.LD, 1));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.t
 * JD-Core Version:    0.7.0.1
 */