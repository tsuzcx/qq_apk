package com.tencent.mm.plugin.webview.luggage.ipc;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class LuggageMainProcessService$2
  extends a.a
{
  LuggageMainProcessService$2(LuggageMainProcessService paramLuggageMainProcessService) {}
  
  public final void a(IBinder paramIBinder, String paramString)
  {
    LuggageMainProcessService.2.1 local1 = new LuggageMainProcessService.2.1(this, paramIBinder, paramString);
    try
    {
      paramIBinder.linkToDeath(local1, 0);
      LuggageMainProcessService.b(this.rdm).put(paramString, local1);
      LuggageMainProcessService.ahv();
      return;
    }
    catch (Exception paramIBinder)
    {
      y.e("MicroMsg.LuggageMainProcessService", "registerDeathRecipient: %s", new Object[] { paramIBinder });
    }
  }
  
  public final void s(Bundle paramBundle)
  {
    Message localMessage = Message.obtain();
    localMessage.setData(paramBundle);
    LuggageMainProcessService.a(this.rdm).send(localMessage);
  }
  
  public final void t(Bundle paramBundle)
  {
    LuggageMainProcessService.e(paramBundle, false).Zu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.LuggageMainProcessService.2
 * JD-Core Version:    0.7.0.1
 */