package org.extra.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class c
{
  public static void loadLibrary(Context paramContext, String paramString)
  {
    AppMethodBeat.i(216811);
    new d().cN(paramContext, paramString);
    AppMethodBeat.o(216811);
  }
  
  public static abstract interface a
  {
    public abstract void a(Context paramContext, String[] paramArrayOfString, String paramString, File paramFile);
  }
  
  public static abstract interface b
  {
    public abstract String bfA(String paramString);
    
    public abstract void bfz(String paramString);
    
    public abstract String[] gCN();
    
    public abstract void loadLibrary(String paramString);
    
    public abstract String mapLibraryName(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.extra.a.c
 * JD-Core Version:    0.7.0.1
 */