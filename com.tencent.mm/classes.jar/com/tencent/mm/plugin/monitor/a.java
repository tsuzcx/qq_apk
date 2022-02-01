package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public abstract interface a
{
  public abstract void a(int paramInt, a parama);
  
  public static final class a
  {
    int btK;
    long cTt;
    long fileLenInvalidCount;
    boolean hls;
    long mqq;
    ArrayList<a.b> tMA;
    ArrayList<a.c> tMB;
    final String tMx;
    long tMy;
    long tMz;
    
    a(String paramString)
    {
      AppMethodBeat.i(51493);
      this.tMA = new ArrayList(20);
      this.tMB = new ArrayList(20);
      this.hls = false;
      this.tMx = paramString;
      AppMethodBeat.o(51493);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(51494);
      String str = String.format("FileResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d], subDirResult[%d], tempAccDirResult[%d], totalTime[%d], depth[%d]", new Object[] { Integer.valueOf(hashCode()), this.tMx, Boolean.valueOf(this.hls), Long.valueOf(this.tMy), Long.valueOf(this.tMz), Long.valueOf(this.mqq), Long.valueOf(this.fileLenInvalidCount), Integer.valueOf(this.tMA.size()), Integer.valueOf(this.tMB.size()), Long.valueOf(this.cTt), Integer.valueOf(this.btK) });
      AppMethodBeat.o(51494);
      return str;
    }
  }
  
  public static final class b
  {
    long fileLenInvalidCount;
    boolean hls = false;
    long mqq;
    final String tMx;
    long tMy;
    long tMz;
    final int tag;
    
    b(String paramString, int paramInt)
    {
      this.tMx = paramString;
      this.tag = paramInt;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(51495);
      String str = String.format("SubDirResult hash(%d) root[%d][%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.tag), this.tMx, Boolean.valueOf(this.hls), Long.valueOf(this.tMy), Long.valueOf(this.tMz), Long.valueOf(this.mqq), Long.valueOf(this.fileLenInvalidCount) });
      AppMethodBeat.o(51495);
      return str;
    }
  }
  
  public static final class c
  {
    boolean hls = false;
    long mqq;
    long tMC;
    final String tMx;
    long tMy;
    long tMz;
    
    c(String paramString)
    {
      this.tMx = paramString;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(51496);
      String str = String.format("TempAccDirResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvaildCount[%d]", new Object[] { Integer.valueOf(hashCode()), this.tMx, Boolean.valueOf(this.hls), Long.valueOf(this.tMy), Long.valueOf(this.tMz), Long.valueOf(this.mqq), Long.valueOf(this.tMC) });
      AppMethodBeat.o(51496);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.a
 * JD-Core Version:    0.7.0.1
 */