package org.extra.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class c
{
  public static void loadLibrary(Context paramContext, String paramString)
  {
    AppMethodBeat.i(236776);
    new d().dh(paramContext, paramString);
    AppMethodBeat.o(236776);
  }
  
  public static abstract interface a
  {
    public abstract void a(Context paramContext, String[] paramArrayOfString, String paramString, File paramFile, d paramd);
  }
  
  public static abstract interface b
  {
    public abstract void bvp(String paramString);
    
    public abstract String bvq(String paramString);
    
    public abstract String[] hPR();
    
    public abstract void loadLibrary(String paramString);
    
    public abstract String mapLibraryName(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.extra.a.c
 * JD-Core Version:    0.7.0.1
 */