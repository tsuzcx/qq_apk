package com.tencent.thumbplayer.core.drm.httpclient;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum Request$Priority
{
  static
  {
    AppMethodBeat.i(193863);
    LOW = new Priority("LOW", 0);
    NORMAL = new Priority("NORMAL", 1);
    HIGH = new Priority("HIGH", 2);
    IMMEDIATE = new Priority("IMMEDIATE", 3);
    $VALUES = new Priority[] { LOW, NORMAL, HIGH, IMMEDIATE };
    AppMethodBeat.o(193863);
  }
  
  private Request$Priority() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.Request.Priority
 * JD-Core Version:    0.7.0.1
 */