package io.flutter.embedding.engine.plugins.service;

public abstract interface ServiceAware
{
  public abstract void onAttachedToService(ServicePluginBinding paramServicePluginBinding);
  
  public abstract void onDetachedFromService();
  
  public static abstract interface OnModeChangeListener
  {
    public abstract void onMoveToBackground();
    
    public abstract void onMoveToForeground();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.service.ServiceAware
 * JD-Core Version:    0.7.0.1
 */