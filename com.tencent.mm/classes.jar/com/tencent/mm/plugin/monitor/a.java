package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public abstract interface a
{
  public abstract void a(int paramInt, a parama);
  
  public static final class a
  {
    int bCc;
    long dcg;
    long fileLenInvalidCount;
    boolean ieP;
    long nsQ;
    final String tiJ;
    long vYj;
    long vYk;
    ArrayList<a.b> vYl;
    ArrayList<a.c> vYm;
    
    a(String paramString)
    {
      AppMethodBeat.i(51493);
      this.vYl = new ArrayList(20);
      this.vYm = new ArrayList(20);
      this.ieP = false;
      this.tiJ = paramString;
      AppMethodBeat.o(51493);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(51494);
      String str = String.format("FileResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d], subDirResult[%d], tempAccDirResult[%d], totalTime[%d], depth[%d]", new Object[] { Integer.valueOf(hashCode()), this.tiJ, Boolean.valueOf(this.ieP), Long.valueOf(this.vYj), Long.valueOf(this.vYk), Long.valueOf(this.nsQ), Long.valueOf(this.fileLenInvalidCount), Integer.valueOf(this.vYl.size()), Integer.valueOf(this.vYm.size()), Long.valueOf(this.dcg), Integer.valueOf(this.bCc) });
      AppMethodBeat.o(51494);
      return str;
    }
  }
  
  public static final class b
  {
    long fileLenInvalidCount;
    boolean ieP = false;
    long nsQ;
    final int tag;
    String tiJ;
    long vYj;
    long vYk;
    
    b(String paramString, int paramInt)
    {
      this.tiJ = paramString;
      this.tag = paramInt;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(51495);
      String str = String.format("SubDirResult hash(%d) root[%d][%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.tag), this.tiJ, Boolean.valueOf(this.ieP), Long.valueOf(this.vYj), Long.valueOf(this.vYk), Long.valueOf(this.nsQ), Long.valueOf(this.fileLenInvalidCount) });
      AppMethodBeat.o(51495);
      return str;
    }
  }
  
  public static final class c
  {
    boolean ieP = false;
    long nsQ;
    final String tiJ;
    long vYj;
    long vYk;
    long vYn;
    
    c(String paramString)
    {
      this.tiJ = paramString;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(51496);
      String str = String.format("TempAccDirResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvaildCount[%d]", new Object[] { Integer.valueOf(hashCode()), this.tiJ, Boolean.valueOf(this.ieP), Long.valueOf(this.vYj), Long.valueOf(this.vYk), Long.valueOf(this.nsQ), Long.valueOf(this.vYn) });
      AppMethodBeat.o(51496);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.a
 * JD-Core Version:    0.7.0.1
 */