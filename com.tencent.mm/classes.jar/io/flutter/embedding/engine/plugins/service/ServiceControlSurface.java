package io.flutter.embedding.engine.plugins.service;

import android.app.Service;
import androidx.lifecycle.j;

public abstract interface ServiceControlSurface
{
  public abstract void attachToService(Service paramService, j paramj, boolean paramBoolean);
  
  public abstract void detachFromService();
  
  public abstract void onMoveToBackground();
  
  public abstract void onMoveToForeground();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.service.ServiceControlSurface
 * JD-Core Version:    0.7.0.1
 */