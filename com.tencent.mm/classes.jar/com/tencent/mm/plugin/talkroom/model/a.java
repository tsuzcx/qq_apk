package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.m;

public final class a
{
  public static final int FPn;
  private static int cpuFlag0;
  
  static
  {
    AppMethodBeat.i(29436);
    int i = m.aon();
    cpuFlag0 = i;
    if ((i & 0x400) != 0) {}
    for (i = 16000;; i = 8000)
    {
      FPn = i;
      AppMethodBeat.o(29436);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.a
 * JD-Core Version:    0.7.0.1
 */