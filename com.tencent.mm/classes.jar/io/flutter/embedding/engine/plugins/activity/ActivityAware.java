package io.flutter.embedding.engine.plugins.activity;

public abstract interface ActivityAware
{
  public abstract void onAttachedToActivity(ActivityPluginBinding paramActivityPluginBinding);
  
  public abstract void onDetachedFromActivity();
  
  public abstract void onDetachedFromActivityForConfigChanges();
  
  public abstract void onReattachedToActivityForConfigChanges(ActivityPluginBinding paramActivityPluginBinding);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.activity.ActivityAware
 * JD-Core Version:    0.7.0.1
 */