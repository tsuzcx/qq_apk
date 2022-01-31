package com.tencent.mm.plugin.wepkg.ipc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class WepkgMainProcessService$4
  implements ServiceConnection
{
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    WepkgMainProcessService.a(a.a.J(paramIBinder));
    WepkgMainProcessService.aoH();
    y.i("MicroMsg.Wepkg.WepkgMainProcessService", "onServiceConnected(%s)", new Object[] { ae.getProcessName() });
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    WepkgMainProcessService.a(null);
    WepkgMainProcessService.aoI();
    y.i("MicroMsg.Wepkg.WepkgMainProcessService", "onServiceDisconnected(%s)", new Object[] { ae.getProcessName() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService.4
 * JD-Core Version:    0.7.0.1
 */