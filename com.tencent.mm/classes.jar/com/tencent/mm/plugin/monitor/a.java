package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public abstract interface a
{
  public abstract void a(int paramInt, a parama);
  
  public static final class a
  {
    int bCe;
    long dtZ;
    long fileLenInvalidCount;
    boolean jcC;
    long oJj;
    final String wKP;
    long zEP;
    long zEQ;
    ArrayList<a.b> zER;
    ArrayList<a.c> zES;
    
    a(String paramString)
    {
      AppMethodBeat.i(51493);
      this.zER = new ArrayList(20);
      this.zES = new ArrayList(20);
      this.jcC = false;
      this.wKP = paramString;
      AppMethodBeat.o(51493);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(51494);
      String str = String.format("FileResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d], subDirResult[%d], tempAccDirResult[%d], totalTime[%d], depth[%d]", new Object[] { Integer.valueOf(hashCode()), this.wKP, Boolean.valueOf(this.jcC), Long.valueOf(this.zEP), Long.valueOf(this.zEQ), Long.valueOf(this.oJj), Long.valueOf(this.fileLenInvalidCount), Integer.valueOf(this.zER.size()), Integer.valueOf(this.zES.size()), Long.valueOf(this.dtZ), Integer.valueOf(this.bCe) });
      AppMethodBeat.o(51494);
      return str;
    }
  }
  
  public static final class b
  {
    long fileLenInvalidCount;
    boolean jcC = false;
    long oJj;
    final int tag;
    String wKP;
    long zEP;
    long zEQ;
    
    b(String paramString, int paramInt)
    {
      this.wKP = paramString;
      this.tag = paramInt;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(51495);
      String str = String.format("SubDirResult hash(%d) root[%d][%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.tag), this.wKP, Boolean.valueOf(this.jcC), Long.valueOf(this.zEP), Long.valueOf(this.zEQ), Long.valueOf(this.oJj), Long.valueOf(this.fileLenInvalidCount) });
      AppMethodBeat.o(51495);
      return str;
    }
  }
  
  public static final class c
  {
    boolean jcC = false;
    long oJj;
    final String wKP;
    long zEP;
    long zEQ;
    long zET;
    
    c(String paramString)
    {
      this.wKP = paramString;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(51496);
      String str = String.format("TempAccDirResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvaildCount[%d]", new Object[] { Integer.valueOf(hashCode()), this.wKP, Boolean.valueOf(this.jcC), Long.valueOf(this.zEP), Long.valueOf(this.zEQ), Long.valueOf(this.oJj), Long.valueOf(this.zET) });
      AppMethodBeat.o(51496);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.a
 * JD-Core Version:    0.7.0.1
 */