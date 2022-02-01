package io.flutter.plugin.platform;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.view.AccessibilityBridge;

class AccessibilityEventsDelegate
{
  private AccessibilityBridge accessibilityBridge;
  
  public boolean requestSendAccessibilityEvent(View paramView1, View paramView2, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(189955);
    if (this.accessibilityBridge == null)
    {
      AppMethodBeat.o(189955);
      return false;
    }
    boolean bool = this.accessibilityBridge.externalViewRequestSendAccessibilityEvent(paramView1, paramView2, paramAccessibilityEvent);
    AppMethodBeat.o(189955);
    return bool;
  }
  
  void setAccessibilityBridge(AccessibilityBridge paramAccessibilityBridge)
  {
    this.accessibilityBridge = paramAccessibilityBridge;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.plugin.platform.AccessibilityEventsDelegate
 * JD-Core Version:    0.7.0.1
 */