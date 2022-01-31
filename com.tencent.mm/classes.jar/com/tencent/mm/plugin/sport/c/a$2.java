package com.tencent.mm.plugin.sport.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mm.plugin.sport.a.a.a;
import com.tencent.mm.sdk.platformtools.y;

final class a$2
  implements ServiceConnection
{
  a$2(a parama) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    y.i("MicroMsg.Sport.DeviceStepManager", "onServiceConnected %s", new Object[] { paramComponentName.toShortString() });
    this.pti.ptg = a.a.B(paramIBinder);
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    y.i("MicroMsg.Sport.DeviceStepManager", "onServiceDisconnected %s", new Object[] { paramComponentName.toShortString() });
    this.pti.ptg = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.c.a.2
 * JD-Core Version:    0.7.0.1
 */