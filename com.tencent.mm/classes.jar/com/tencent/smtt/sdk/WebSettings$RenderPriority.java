package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum WebSettings$RenderPriority
{
  static
  {
    AppMethodBeat.i(54366);
    NORMAL = new RenderPriority("NORMAL", 0);
    HIGH = new RenderPriority("HIGH", 1);
    LOW = new RenderPriority("LOW", 2);
    $VALUES = new RenderPriority[] { NORMAL, HIGH, LOW };
    AppMethodBeat.o(54366);
  }
  
  private WebSettings$RenderPriority() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebSettings.RenderPriority
 * JD-Core Version:    0.7.0.1
 */