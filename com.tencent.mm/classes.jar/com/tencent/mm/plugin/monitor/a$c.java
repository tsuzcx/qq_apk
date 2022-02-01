package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$c
{
  boolean hLV = false;
  long mSs;
  final String smf;
  long uVb;
  long uVc;
  long uVf;
  
  a$c(String paramString)
  {
    this.smf = paramString;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(51496);
    String str = String.format("TempAccDirResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvaildCount[%d]", new Object[] { Integer.valueOf(hashCode()), this.smf, Boolean.valueOf(this.hLV), Long.valueOf(this.uVb), Long.valueOf(this.uVc), Long.valueOf(this.mSs), Long.valueOf(this.uVf) });
    AppMethodBeat.o(51496);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.a.c
 * JD-Core Version:    0.7.0.1
 */