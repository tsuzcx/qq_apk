package com.tencent.mm.remoteservice;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class d$1
  implements ServiceConnection
{
  d$1(d paramd) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AppMethodBeat.i(80230);
    this.yiw.yiv = c.a.K(paramIBinder);
    paramComponentName = (Runnable[])this.yiw.yiu.toArray(new Runnable[this.yiw.yiu.size()]);
    int j = paramComponentName.length;
    int i = 0;
    while (i < j)
    {
      paramIBinder = paramComponentName[i];
      if (paramIBinder != null) {
        paramIBinder.run();
      }
      i += 1;
    }
    this.yiw.yiu.clear();
    AppMethodBeat.o(80230);
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.yiw.yiv = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.remoteservice.d.1
 * JD-Core Version:    0.7.0.1
 */