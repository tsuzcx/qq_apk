package io.flutter.embedding.engine.plugins.broadcastreceiver;

public abstract interface BroadcastReceiverAware
{
  public abstract void onAttachedToBroadcastReceiver(BroadcastReceiverPluginBinding paramBroadcastReceiverPluginBinding);
  
  public abstract void onDetachedFromBroadcastReceiver();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverAware
 * JD-Core Version:    0.7.0.1
 */