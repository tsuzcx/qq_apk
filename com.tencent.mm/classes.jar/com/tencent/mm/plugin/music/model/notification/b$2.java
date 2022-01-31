package com.tencent.mm.plugin.music.model.notification;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mm.sdk.platformtools.y;
import junit.framework.Assert;

final class b$2
  implements ServiceConnection
{
  b$2(b paramb) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    y.i("MicroMsg.Music.MMMusicNotificationHelper", "onServiceConnected");
    if (!(paramIBinder instanceof MMMusicPlayerService.a))
    {
      y.e("MicroMsg.Music.MMMusicNotificationHelper", "service %s isn't MMMusicPlayerService, err, return", new Object[] { paramIBinder.getClass().getName() });
      Assert.assertTrue(false);
      return;
    }
    this.mzS.mzR = false;
    this.mzS.mzL = ((MMMusicPlayerService.a)paramIBinder).mzV;
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    y.i("MicroMsg.Music.MMMusicNotificationHelper", "onServiceDisconnected");
    this.mzS.mzR = false;
    this.mzS.mzL = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.notification.b.2
 * JD-Core Version:    0.7.0.1
 */