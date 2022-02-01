package io.flutter.view;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum AccessibilityBridge$AccessibilityFeature
{
  final int value;
  
  static
  {
    AppMethodBeat.i(9824);
    ACCESSIBLE_NAVIGATION = new AccessibilityFeature("ACCESSIBLE_NAVIGATION", 0, 1);
    INVERT_COLORS = new AccessibilityFeature("INVERT_COLORS", 1, 2);
    DISABLE_ANIMATIONS = new AccessibilityFeature("DISABLE_ANIMATIONS", 2, 4);
    $VALUES = new AccessibilityFeature[] { ACCESSIBLE_NAVIGATION, INVERT_COLORS, DISABLE_ANIMATIONS };
    AppMethodBeat.o(9824);
  }
  
  private AccessibilityBridge$AccessibilityFeature(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     io.flutter.view.AccessibilityBridge.AccessibilityFeature
 * JD-Core Version:    0.7.0.1
 */