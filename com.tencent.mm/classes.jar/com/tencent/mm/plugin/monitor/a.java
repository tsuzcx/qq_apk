package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public abstract interface a
{
  public abstract void a(int paramInt, a parama);
  
  public static final class a
  {
    int bCc;
    long ddi;
    long fileLenInvalidCount;
    boolean ihH;
    long nyl;
    final String ttB;
    long wkn;
    long wko;
    ArrayList<a.b> wkp;
    ArrayList<a.c> wkq;
    
    a(String paramString)
    {
      AppMethodBeat.i(51493);
      this.wkp = new ArrayList(20);
      this.wkq = new ArrayList(20);
      this.ihH = false;
      this.ttB = paramString;
      AppMethodBeat.o(51493);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(51494);
      String str = String.format("FileResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d], subDirResult[%d], tempAccDirResult[%d], totalTime[%d], depth[%d]", new Object[] { Integer.valueOf(hashCode()), this.ttB, Boolean.valueOf(this.ihH), Long.valueOf(this.wkn), Long.valueOf(this.wko), Long.valueOf(this.nyl), Long.valueOf(this.fileLenInvalidCount), Integer.valueOf(this.wkp.size()), Integer.valueOf(this.wkq.size()), Long.valueOf(this.ddi), Integer.valueOf(this.bCc) });
      AppMethodBeat.o(51494);
      return str;
    }
  }
  
  public static final class b
  {
    long fileLenInvalidCount;
    boolean ihH = false;
    long nyl;
    final int tag;
    String ttB;
    long wkn;
    long wko;
    
    b(String paramString, int paramInt)
    {
      this.ttB = paramString;
      this.tag = paramInt;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(51495);
      String str = String.format("SubDirResult hash(%d) root[%d][%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.tag), this.ttB, Boolean.valueOf(this.ihH), Long.valueOf(this.wkn), Long.valueOf(this.wko), Long.valueOf(this.nyl), Long.valueOf(this.fileLenInvalidCount) });
      AppMethodBeat.o(51495);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.a
 * JD-Core Version:    0.7.0.1
 */