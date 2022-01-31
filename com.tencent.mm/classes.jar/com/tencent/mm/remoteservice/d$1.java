package com.tencent.mm.remoteservice;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.List;

final class d$1
  implements ServiceConnection
{
  d$1(d paramd) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.uaG.uaF = c.a.M(paramIBinder);
    paramComponentName = (Runnable[])this.uaG.uaE.toArray(new Runnable[this.uaG.uaE.size()]);
    int j = paramComponentName.length;
    int i = 0;
    while (i < j)
    {
      paramComponentName[i].run();
      i += 1;
    }
    this.uaG.uaE.clear();
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.uaG.uaF = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.remoteservice.d.1
 * JD-Core Version:    0.7.0.1
 */