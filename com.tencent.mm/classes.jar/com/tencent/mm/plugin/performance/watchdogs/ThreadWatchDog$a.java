package com.tencent.mm.plugin.performance.watchdogs;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ThreadWatchDog$a
{
  int count;
  String name;
  
  public ThreadWatchDog$a(String paramString, int paramInt)
  {
    this.name = paramString;
    this.count = paramInt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(201187);
    String str = this.name + "=" + this.count;
    AppMethodBeat.o(201187);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.ThreadWatchDog.a
 * JD-Core Version:    0.7.0.1
 */