package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public abstract interface a
{
  public abstract void a(int paramInt, a parama);
  
  public static final class a
  {
    final String Hlu;
    long Lfl;
    long Lfm;
    ArrayList<a.b> Lfn;
    ArrayList<a.c> Lfo;
    int aOm;
    long fileLenInvalidCount;
    long hqS;
    boolean oLU;
    long uWn;
    
    a(String paramString)
    {
      AppMethodBeat.i(51493);
      this.Lfn = new ArrayList(20);
      this.Lfo = new ArrayList(20);
      this.oLU = false;
      this.Hlu = paramString;
      AppMethodBeat.o(51493);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(51494);
      String str = String.format("FileResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d], subDirResult[%d], tempAccDirResult[%d], totalTime[%d], depth[%d]", new Object[] { Integer.valueOf(hashCode()), this.Hlu, Boolean.valueOf(this.oLU), Long.valueOf(this.Lfl), Long.valueOf(this.Lfm), Long.valueOf(this.uWn), Long.valueOf(this.fileLenInvalidCount), Integer.valueOf(this.Lfn.size()), Integer.valueOf(this.Lfo.size()), Long.valueOf(this.hqS), Integer.valueOf(this.aOm) });
      AppMethodBeat.o(51494);
      return str;
    }
  }
  
  public static final class b
  {
    String Hlu;
    long Lfl;
    long Lfm;
    long fileLenInvalidCount;
    boolean oLU = false;
    final int tag;
    long uWn;
    
    b(String paramString, int paramInt)
    {
      this.Hlu = paramString;
      this.tag = paramInt;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(51495);
      String str = String.format("SubDirResult hash(%d) root[%d][%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.tag), this.Hlu, Boolean.valueOf(this.oLU), Long.valueOf(this.Lfl), Long.valueOf(this.Lfm), Long.valueOf(this.uWn), Long.valueOf(this.fileLenInvalidCount) });
      AppMethodBeat.o(51495);
      return str;
    }
  }
  
  public static final class c
  {
    final String Hlu;
    long Lfl;
    long Lfm;
    long Lfp;
    boolean oLU = false;
    long uWn;
    
    c(String paramString)
    {
      this.Hlu = paramString;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(51496);
      String str = String.format("TempAccDirResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvaildCount[%d]", new Object[] { Integer.valueOf(hashCode()), this.Hlu, Boolean.valueOf(this.oLU), Long.valueOf(this.Lfl), Long.valueOf(this.Lfm), Long.valueOf(this.uWn), Long.valueOf(this.Lfp) });
      AppMethodBeat.o(51496);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.a
 * JD-Core Version:    0.7.0.1
 */