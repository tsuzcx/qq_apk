package com.tencent.mm.plugin.webview.luggage.ipc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class LuggageMainProcessService$4
  implements ServiceConnection
{
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    LuggageMainProcessService.a(a.a.F(paramIBinder));
    LuggageMainProcessService.ahw();
    LuggageMainProcessService.ahv();
    try
    {
      LuggageMainProcessService.cbw().a(new Binder(), ae.getProcessName());
      y.i("MicroMsg.LuggageMainProcessService", "onServiceConnected(%s)", new Object[] { ae.getProcessName() });
      return;
    }
    catch (Exception paramComponentName)
    {
      for (;;)
      {
        y.e("MicroMsg.LuggageMainProcessService", "onServiceConnected, registerDeathRecipient, %s", new Object[] { paramComponentName });
      }
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    LuggageMainProcessService.a(null);
    LuggageMainProcessService.ahu();
    LuggageMainProcessService.aht();
    y.i("MicroMsg.LuggageMainProcessService", "onServiceDisconnected(%s)", new Object[] { ae.getProcessName() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.LuggageMainProcessService.4
 * JD-Core Version:    0.7.0.1
 */