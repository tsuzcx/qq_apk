package com.tencent.mm.plugin.monitor;

import java.util.ArrayList;

public final class a$a
{
  int aOn;
  boolean esC = false;
  long fileLenInvalidCount;
  long hFz;
  final String mrK;
  long mrL;
  long mrM;
  long mrN;
  ArrayList<a.b> mrO = new ArrayList(20);
  ArrayList<a.c> mrP = new ArrayList(20);
  
  a$a(String paramString)
  {
    this.mrK = paramString;
  }
  
  public final String toString()
  {
    return String.format("FileResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d], subDirResult[%d], tempAccDirResult[%d], totalTime[%d], depth[%d]", new Object[] { Integer.valueOf(hashCode()), this.mrK, Boolean.valueOf(this.esC), Long.valueOf(this.mrL), Long.valueOf(this.mrM), Long.valueOf(this.hFz), Long.valueOf(this.fileLenInvalidCount), Integer.valueOf(this.mrO.size()), Integer.valueOf(this.mrP.size()), Long.valueOf(this.mrN), Integer.valueOf(this.aOn) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.a.a
 * JD-Core Version:    0.7.0.1
 */