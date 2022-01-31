package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$b
{
  boolean fIp = false;
  long fileLenInvalidCount;
  long jyU;
  long oRA;
  final String oRy;
  long oRz;
  final int tag;
  
  a$b(String paramString, int paramInt)
  {
    this.oRy = paramString;
    this.tag = paramInt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(84513);
    String str = String.format("SubDirResult hash(%d) root[%d][%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.tag), this.oRy, Boolean.valueOf(this.fIp), Long.valueOf(this.oRz), Long.valueOf(this.oRA), Long.valueOf(this.jyU), Long.valueOf(this.fileLenInvalidCount) });
    AppMethodBeat.o(84513);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.a.b
 * JD-Core Version:    0.7.0.1
 */