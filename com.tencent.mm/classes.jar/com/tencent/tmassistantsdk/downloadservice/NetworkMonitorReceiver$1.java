package com.tencent.tmassistantsdk.downloadservice;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;

class NetworkMonitorReceiver$1
  extends ah
{
  NetworkMonitorReceiver$1(NetworkMonitorReceiver paramNetworkMonitorReceiver) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.this$0.notifyNetworkChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver.1
 * JD-Core Version:    0.7.0.1
 */