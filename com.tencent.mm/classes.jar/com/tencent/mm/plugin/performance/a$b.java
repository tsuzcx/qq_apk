package com.tencent.mm.plugin.performance;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$b
{
  long bQI;
  String name;
  int pid;
  long psh;
  long psi;
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof b))
    {
      bool1 = bool2;
      if (((b)paramObject).pid == this.pid) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    return this.pid;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(111022);
    int i = this.name.indexOf(":");
    if (i > 0) {}
    for (String str = this.name.substring(i + 1);; str = "main")
    {
      str = String.format(" %s(%s) diff:%s allThreadSumDiff:%s", new Object[] { str, Integer.valueOf(this.pid), Long.valueOf(this.psh), Long.valueOf(this.psi) });
      AppMethodBeat.o(111022);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.a.b
 * JD-Core Version:    0.7.0.1
 */