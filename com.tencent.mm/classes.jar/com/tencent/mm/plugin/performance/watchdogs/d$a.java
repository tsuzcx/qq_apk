package com.tencent.mm.plugin.performance.watchdogs;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$a
{
  long AXJ;
  int pid;
  String processName;
  
  public d$a(String paramString, int paramInt)
  {
    this.processName = paramString;
    this.pid = paramInt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(201177);
    String str = this.processName + "|pid:" + this.pid + "|pss:" + this.AXJ;
    AppMethodBeat.o(201177);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.d.a
 * JD-Core Version:    0.7.0.1
 */