package com.tencent.mm.plugin.monitor;

public final class a$b
{
  boolean esC = false;
  long fileLenInvalidCount;
  long hFz;
  final String mrK;
  long mrL;
  long mrM;
  final int tag;
  
  a$b(String paramString, int paramInt)
  {
    this.mrK = paramString;
    this.tag = paramInt;
  }
  
  public final String toString()
  {
    return String.format("SubDirResult hash(%d) root[%d][%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.tag), this.mrK, Boolean.valueOf(this.esC), Long.valueOf(this.mrL), Long.valueOf(this.mrM), Long.valueOf(this.hFz), Long.valueOf(this.fileLenInvalidCount) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.a.b
 * JD-Core Version:    0.7.0.1
 */