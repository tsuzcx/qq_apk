package org.extra.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class c
{
  public static void loadLibrary(Context paramContext, String paramString)
  {
    AppMethodBeat.i(187290);
    new d().dA(paramContext, paramString);
    AppMethodBeat.o(187290);
  }
  
  public static abstract interface a
  {
    public abstract void a(Context paramContext, String[] paramArrayOfString, String paramString, File paramFile, d paramd);
  }
  
  public static abstract interface b
  {
    public abstract void bLp(String paramString);
    
    public abstract String bLq(String paramString);
    
    public abstract String bLr(String paramString);
    
    public abstract String[] kJy();
    
    public abstract void loadLibrary(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     org.extra.a.c
 * JD-Core Version:    0.7.0.1
 */