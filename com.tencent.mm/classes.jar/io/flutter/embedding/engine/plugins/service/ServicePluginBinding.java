package io.flutter.embedding.engine.plugins.service;

import android.app.Service;

public abstract interface ServicePluginBinding
{
  public abstract void addOnModeChangeListener(ServiceAware.OnModeChangeListener paramOnModeChangeListener);
  
  public abstract Object getLifecycle();
  
  public abstract Service getService();
  
  public abstract void removeOnModeChangeListener(ServiceAware.OnModeChangeListener paramOnModeChangeListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.service.ServicePluginBinding
 * JD-Core Version:    0.7.0.1
 */