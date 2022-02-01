package io.flutter.plugin.platform;

import android.view.View;

public abstract interface PlatformView
{
  public abstract void dispose();
  
  public abstract View getView();
  
  public abstract void onFlutterViewAttached(View paramView);
  
  public abstract void onFlutterViewDetached();
  
  public abstract void onInputConnectionLocked();
  
  public abstract void onInputConnectionUnlocked();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.plugin.platform.PlatformView
 * JD-Core Version:    0.7.0.1
 */