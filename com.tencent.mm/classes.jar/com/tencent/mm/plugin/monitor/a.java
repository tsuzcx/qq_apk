package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public abstract interface a
{
  public abstract void a(int paramInt, a parama);
  
  public static final class a
  {
    final String BCM;
    long FjO;
    long FjP;
    ArrayList<a.b> FjQ;
    ArrayList<a.c> FjR;
    int blG;
    long fileLenInvalidCount;
    long fmH;
    boolean lTb;
    long rKZ;
    
    a(String paramString)
    {
      AppMethodBeat.i(51493);
      this.FjQ = new ArrayList(20);
      this.FjR = new ArrayList(20);
      this.lTb = false;
      this.BCM = paramString;
      AppMethodBeat.o(51493);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(51494);
      String str = String.format("FileResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d], subDirResult[%d], tempAccDirResult[%d], totalTime[%d], depth[%d]", new Object[] { Integer.valueOf(hashCode()), this.BCM, Boolean.valueOf(this.lTb), Long.valueOf(this.FjO), Long.valueOf(this.FjP), Long.valueOf(this.rKZ), Long.valueOf(this.fileLenInvalidCount), Integer.valueOf(this.FjQ.size()), Integer.valueOf(this.FjR.size()), Long.valueOf(this.fmH), Integer.valueOf(this.blG) });
      AppMethodBeat.o(51494);
      return str;
    }
  }
  
  public static final class b
  {
    String BCM;
    long FjO;
    long FjP;
    long fileLenInvalidCount;
    boolean lTb = false;
    long rKZ;
    final int tag;
    
    b(String paramString, int paramInt)
    {
      this.BCM = paramString;
      this.tag = paramInt;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(51495);
      String str = String.format("SubDirResult hash(%d) root[%d][%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.tag), this.BCM, Boolean.valueOf(this.lTb), Long.valueOf(this.FjO), Long.valueOf(this.FjP), Long.valueOf(this.rKZ), Long.valueOf(this.fileLenInvalidCount) });
      AppMethodBeat.o(51495);
      return str;
    }
  }
  
  public static final class c
  {
    final String BCM;
    long FjO;
    long FjP;
    long FjS;
    boolean lTb = false;
    long rKZ;
    
    c(String paramString)
    {
      this.BCM = paramString;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(51496);
      String str = String.format("TempAccDirResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvaildCount[%d]", new Object[] { Integer.valueOf(hashCode()), this.BCM, Boolean.valueOf(this.lTb), Long.valueOf(this.FjO), Long.valueOf(this.FjP), Long.valueOf(this.rKZ), Long.valueOf(this.FjS) });
      AppMethodBeat.o(51496);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.a
 * JD-Core Version:    0.7.0.1
 */