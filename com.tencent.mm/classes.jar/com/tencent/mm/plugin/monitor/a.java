package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public abstract interface a
{
  public abstract void a(int paramInt, a parama);
  
  public static final class a
  {
    int brJ;
    long cQQ;
    long fileLenInvalidCount;
    boolean hLV;
    long mSs;
    final String smf;
    long uVb;
    long uVc;
    ArrayList<a.b> uVd;
    ArrayList<a.c> uVe;
    
    a(String paramString)
    {
      AppMethodBeat.i(51493);
      this.uVd = new ArrayList(20);
      this.uVe = new ArrayList(20);
      this.hLV = false;
      this.smf = paramString;
      AppMethodBeat.o(51493);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(51494);
      String str = String.format("FileResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d], subDirResult[%d], tempAccDirResult[%d], totalTime[%d], depth[%d]", new Object[] { Integer.valueOf(hashCode()), this.smf, Boolean.valueOf(this.hLV), Long.valueOf(this.uVb), Long.valueOf(this.uVc), Long.valueOf(this.mSs), Long.valueOf(this.fileLenInvalidCount), Integer.valueOf(this.uVd.size()), Integer.valueOf(this.uVe.size()), Long.valueOf(this.cQQ), Integer.valueOf(this.brJ) });
      AppMethodBeat.o(51494);
      return str;
    }
  }
  
  public static final class b
  {
    long fileLenInvalidCount;
    boolean hLV = false;
    long mSs;
    final String smf;
    final int tag;
    long uVb;
    long uVc;
    
    b(String paramString, int paramInt)
    {
      this.smf = paramString;
      this.tag = paramInt;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(51495);
      String str = String.format("SubDirResult hash(%d) root[%d][%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.tag), this.smf, Boolean.valueOf(this.hLV), Long.valueOf(this.uVb), Long.valueOf(this.uVc), Long.valueOf(this.mSs), Long.valueOf(this.fileLenInvalidCount) });
      AppMethodBeat.o(51495);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.a
 * JD-Core Version:    0.7.0.1
 */