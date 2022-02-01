package io.flutter.embedding.engine.deferredcomponents;

import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.systemchannels.DeferredComponentChannel;

public abstract interface DeferredComponentManager
{
  public abstract void destroy();
  
  public abstract String getDeferredComponentInstallState(int paramInt, String paramString);
  
  public abstract void installDeferredComponent(int paramInt, String paramString);
  
  public abstract void loadAssets(int paramInt, String paramString);
  
  public abstract void loadDartLibrary(int paramInt, String paramString);
  
  public abstract void setDeferredComponentChannel(DeferredComponentChannel paramDeferredComponentChannel);
  
  public abstract void setJNI(FlutterJNI paramFlutterJNI);
  
  public abstract boolean uninstallDeferredComponent(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager
 * JD-Core Version:    0.7.0.1
 */