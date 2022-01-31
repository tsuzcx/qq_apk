package com.tencent.mm.plugin.monitor;

public final class a$c
{
  boolean esC = false;
  long hFz;
  final String mrK;
  long mrL;
  long mrM;
  long mrQ;
  
  a$c(String paramString)
  {
    this.mrK = paramString;
  }
  
  public final String toString()
  {
    return String.format("TempAccDirResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvaildCount[%d]", new Object[] { Integer.valueOf(hashCode()), this.mrK, Boolean.valueOf(this.esC), Long.valueOf(this.mrL), Long.valueOf(this.mrM), Long.valueOf(this.hFz), Long.valueOf(this.mrQ) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.a.c
 * JD-Core Version:    0.7.0.1
 */