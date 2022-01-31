package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$c
{
  boolean fIp = false;
  long jyU;
  long oRA;
  long oRD;
  final String oRy;
  long oRz;
  
  a$c(String paramString)
  {
    this.oRy = paramString;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(84514);
    String str = String.format("TempAccDirResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvaildCount[%d]", new Object[] { Integer.valueOf(hashCode()), this.oRy, Boolean.valueOf(this.fIp), Long.valueOf(this.oRz), Long.valueOf(this.oRA), Long.valueOf(this.jyU), Long.valueOf(this.oRD) });
    AppMethodBeat.o(84514);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.a.c
 * JD-Core Version:    0.7.0.1
 */