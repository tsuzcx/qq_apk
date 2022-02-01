package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$c
{
  boolean ihH = false;
  long nyl;
  final String ttB;
  long wkn;
  long wko;
  long wkr;
  
  a$c(String paramString)
  {
    this.ttB = paramString;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(51496);
    String str = String.format("TempAccDirResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvaildCount[%d]", new Object[] { Integer.valueOf(hashCode()), this.ttB, Boolean.valueOf(this.ihH), Long.valueOf(this.wkn), Long.valueOf(this.wko), Long.valueOf(this.nyl), Long.valueOf(this.wkr) });
    AppMethodBeat.o(51496);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.a.c
 * JD-Core Version:    0.7.0.1
 */