package com.tencent.mm.plugin.webview.luggage.ipc;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class LuggageMainProcessService$2$1
  implements IBinder.DeathRecipient
{
  LuggageMainProcessService$2$1(LuggageMainProcessService.2 param2, IBinder paramIBinder, String paramString) {}
  
  public final void binderDied()
  {
    this.gdQ.unlinkToDeath((IBinder.DeathRecipient)LuggageMainProcessService.b(this.rdn.rdm).get(this.dGw), 0);
    LuggageMainProcessService.b(this.rdn.rdm).remove(this.dGw);
    LuggageMainProcessService.ahu();
    y.e("MicroMsg.LuggageMainProcessService", "Client Process Died: %s", new Object[] { this.dGw });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.LuggageMainProcessService.2.1
 * JD-Core Version:    0.7.0.1
 */