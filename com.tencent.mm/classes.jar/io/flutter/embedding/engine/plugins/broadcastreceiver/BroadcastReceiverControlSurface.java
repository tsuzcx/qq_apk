package io.flutter.embedding.engine.plugins.broadcastreceiver;

import android.content.BroadcastReceiver;
import androidx.lifecycle.j;

public abstract interface BroadcastReceiverControlSurface
{
  public abstract void attachToBroadcastReceiver(BroadcastReceiver paramBroadcastReceiver, j paramj);
  
  public abstract void detachFromBroadcastReceiver();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface
 * JD-Core Version:    0.7.0.1
 */