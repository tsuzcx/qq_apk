package com.tencent.smtt.export.external.interfaces;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum IX5WebSettings$ZoomDensity
{
  int value;
  
  static
  {
    AppMethodBeat.i(53218);
    FAR = new ZoomDensity("FAR", 0, 150);
    MEDIUM = new ZoomDensity("MEDIUM", 1, 100);
    CLOSE = new ZoomDensity("CLOSE", 2, 75);
    $VALUES = new ZoomDensity[] { FAR, MEDIUM, CLOSE };
    AppMethodBeat.o(53218);
  }
  
  private IX5WebSettings$ZoomDensity(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.IX5WebSettings.ZoomDensity
 * JD-Core Version:    0.7.0.1
 */