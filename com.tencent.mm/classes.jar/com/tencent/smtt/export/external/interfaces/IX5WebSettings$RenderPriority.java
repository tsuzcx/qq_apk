package com.tencent.smtt.export.external.interfaces;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum IX5WebSettings$RenderPriority
{
  static
  {
    AppMethodBeat.i(63809);
    NORMAL = new RenderPriority("NORMAL", 0);
    HIGH = new RenderPriority("HIGH", 1);
    LOW = new RenderPriority("LOW", 2);
    $VALUES = new RenderPriority[] { NORMAL, HIGH, LOW };
    AppMethodBeat.o(63809);
  }
  
  private IX5WebSettings$RenderPriority() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.IX5WebSettings.RenderPriority
 * JD-Core Version:    0.7.0.1
 */