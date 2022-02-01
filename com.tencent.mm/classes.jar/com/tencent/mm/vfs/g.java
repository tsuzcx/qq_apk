package com.tencent.mm.vfs;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;

public abstract interface g
{
  public abstract FileSystem.b aZO(String paramString);
  
  public abstract Pair<FileSystem.b, String> aZP(String paramString);
  
  public abstract Map<String, FileSystem> fSZ();
  
  public abstract Map<String, String> fTa();
  
  public abstract List<a> fTb();
  
  public static class a
  {
    public final String LHq;
    public final String basePath;
    
    a(String paramString1, String paramString2)
    {
      this.basePath = paramString1;
      this.LHq = paramString2;
    }
    
    public String toString()
    {
      AppMethodBeat.i(193436);
      String str = this.basePath + " -> " + this.LHq;
      AppMethodBeat.o(193436);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.g
 * JD-Core Version:    0.7.0.1
 */