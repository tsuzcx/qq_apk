package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum WebSettings$ZoomDensity
{
  int value;
  
  static
  {
    AppMethodBeat.i(64723);
    FAR = new ZoomDensity("FAR", 0, 150);
    MEDIUM = new ZoomDensity("MEDIUM", 1, 100);
    CLOSE = new ZoomDensity("CLOSE", 2, 75);
    $VALUES = new ZoomDensity[] { FAR, MEDIUM, CLOSE };
    AppMethodBeat.o(64723);
  }
  
  private WebSettings$ZoomDensity(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebSettings.ZoomDensity
 * JD-Core Version:    0.7.0.1
 */