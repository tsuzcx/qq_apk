package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.m;

public final class a
{
  private static int cpuFlag0;
  public static final int tbK;
  
  static
  {
    AppMethodBeat.i(25754);
    int i = m.Lo();
    cpuFlag0 = i;
    if ((i & 0x400) != 0) {}
    for (i = 16000;; i = 8000)
    {
      tbK = i;
      AppMethodBeat.o(25754);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.a
 * JD-Core Version:    0.7.0.1
 */