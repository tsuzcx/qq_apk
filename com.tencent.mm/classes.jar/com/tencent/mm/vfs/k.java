package com.tencent.mm.vfs;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;

public abstract interface k
{
  public abstract FileSystem.b boT(String paramString);
  
  public abstract Pair<FileSystem.b, String> boU(String paramString);
  
  public abstract Map<String, FileSystem> hec();
  
  public abstract Map<String, String> hej();
  
  public abstract List<a> hek();
  
  public static class a
  {
    public final String Rdc;
    public final String basePath;
    
    a(String paramString1, String paramString2)
    {
      this.basePath = paramString1;
      this.Rdc = paramString2;
    }
    
    public String toString()
    {
      AppMethodBeat.i(187731);
      String str = this.basePath + " -> " + this.Rdc;
      AppMethodBeat.o(187731);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.k
 * JD-Core Version:    0.7.0.1
 */