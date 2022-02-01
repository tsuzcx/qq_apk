package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum PlaySound$SPEAKERON
{
  static
  {
    AppMethodBeat.i(157785);
    NOTSET = new SPEAKERON("NOTSET", 0);
    ON = new SPEAKERON("ON", 1);
    OFF = new SPEAKERON("OFF", 2);
    $VALUES = new SPEAKERON[] { NOTSET, ON, OFF };
    AppMethodBeat.o(157785);
  }
  
  private PlaySound$SPEAKERON() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.PlaySound.SPEAKERON
 * JD-Core Version:    0.7.0.1
 */