package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class a$a
{
  int aVH;
  long cew;
  boolean fIp;
  long fileLenInvalidCount;
  long jyU;
  long oRA;
  ArrayList<a.b> oRB;
  ArrayList<a.c> oRC;
  final String oRy;
  long oRz;
  
  a$a(String paramString)
  {
    AppMethodBeat.i(84511);
    this.oRB = new ArrayList(20);
    this.oRC = new ArrayList(20);
    this.fIp = false;
    this.oRy = paramString;
    AppMethodBeat.o(84511);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(84512);
    String str = String.format("FileResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d], subDirResult[%d], tempAccDirResult[%d], totalTime[%d], depth[%d]", new Object[] { Integer.valueOf(hashCode()), this.oRy, Boolean.valueOf(this.fIp), Long.valueOf(this.oRz), Long.valueOf(this.oRA), Long.valueOf(this.jyU), Long.valueOf(this.fileLenInvalidCount), Integer.valueOf(this.oRB.size()), Integer.valueOf(this.oRC.size()), Long.valueOf(this.cew), Integer.valueOf(this.aVH) });
    AppMethodBeat.o(84512);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.a.a
 * JD-Core Version:    0.7.0.1
 */