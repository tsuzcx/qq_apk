package com.tencent.mm.plugin.webview.luggage.ipc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class LuggageMainProcessService$1
  extends Handler
{
  LuggageMainProcessService$1(LuggageMainProcessService paramLuggageMainProcessService, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    LuggageMainProcessService.e(paramMessage.getData(), true).Zu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.LuggageMainProcessService.1
 * JD-Core Version:    0.7.0.1
 */