package com.tencent.mm.vfs;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;

public abstract interface l
{
  public abstract FileSystem.b bBL(String paramString);
  
  public abstract Pair<FileSystem.b, String> bBM(String paramString);
  
  public abstract Map<String, FileSystem> ifl();
  
  public abstract Map<String, String> ift();
  
  public abstract List<a> ifu();
  
  public static class a
  {
    public final String YDQ;
    public final String basePath;
    
    a(String paramString1, String paramString2)
    {
      this.basePath = paramString1;
      this.YDQ = paramString2;
    }
    
    public String toString()
    {
      AppMethodBeat.i(236757);
      String str = this.basePath + " -> " + this.YDQ;
      AppMethodBeat.o(236757);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.l
 * JD-Core Version:    0.7.0.1
 */