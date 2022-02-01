package io.flutter.plugin.platform;

import android.view.View;
import io.flutter.view.AccessibilityBridge;

public abstract interface PlatformViewsAccessibilityDelegate
{
  public abstract void attachAccessibilityBridge(AccessibilityBridge paramAccessibilityBridge);
  
  public abstract void detachAccessibiltyBridge();
  
  public abstract View getPlatformViewById(Integer paramInteger);
  
  public abstract boolean usesVirtualDisplay(Integer paramInteger);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
 * JD-Core Version:    0.7.0.1
 */