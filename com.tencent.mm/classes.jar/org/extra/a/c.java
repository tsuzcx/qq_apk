package org.extra.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class c
{
  public static void loadLibrary(Context paramContext, String paramString)
  {
    AppMethodBeat.i(194637);
    new d().dr(paramContext, paramString);
    AppMethodBeat.o(194637);
  }
  
  public static abstract interface a
  {
    public abstract void a(Context paramContext, String[] paramArrayOfString, String paramString, File paramFile, d paramd);
  }
  
  public static abstract interface b
  {
    public abstract void bIu(String paramString);
    
    public abstract String bIv(String paramString);
    
    public abstract String bIw(String paramString);
    
    public abstract String[] iVa();
    
    public abstract void loadLibrary(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.extra.a.c
 * JD-Core Version:    0.7.0.1
 */