package com.tencent.mm.plugin.music.model.notification;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import junit.framework.Assert;

final class b$2
  implements ServiceConnection
{
  b$2(b paramb) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AppMethodBeat.i(104988);
    ab.i("MicroMsg.Music.MMMusicNotificationHelper", "onServiceConnected");
    if (!(paramIBinder instanceof MMMusicPlayerService.a))
    {
      ab.e("MicroMsg.Music.MMMusicNotificationHelper", "service %s isn't MMMusicPlayerService, err, return", new Object[] { paramIBinder.getClass().getName() });
      Assert.assertTrue(false);
      AppMethodBeat.o(104988);
      return;
    }
    this.oZY.oZX = false;
    this.oZY.oZR = ((MMMusicPlayerService.a)paramIBinder).pab;
    AppMethodBeat.o(104988);
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(104989);
    ab.i("MicroMsg.Music.MMMusicNotificationHelper", "onServiceDisconnected");
    this.oZY.oZX = false;
    this.oZY.oZR = null;
    AppMethodBeat.o(104989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.notification.b.2
 * JD-Core Version:    0.7.0.1
 */