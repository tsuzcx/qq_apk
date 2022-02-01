package org.libpag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.extra.tools.b;

public class PAGMovie
  extends PAGImage
{
  static
  {
    AppMethodBeat.i(195144);
    b.loadLibrary("pag");
    nativeInit();
    AppMethodBeat.o(195144);
  }
  
  private PAGMovie(long paramLong)
  {
    super(paramLong);
  }
  
  public static PAGMovie FromComposition(PAGComposition paramPAGComposition)
  {
    AppMethodBeat.i(195132);
    long l = MakeFromComposition(paramPAGComposition);
    if (l == 0L)
    {
      AppMethodBeat.o(195132);
      return null;
    }
    paramPAGComposition = new PAGMovie(l);
    AppMethodBeat.o(195132);
    return paramPAGComposition;
  }
  
  public static PAGMovie FromVideoPath(String paramString)
  {
    AppMethodBeat.i(195137);
    long l = MakeFromVideoPath(paramString);
    if (l == 0L)
    {
      AppMethodBeat.o(195137);
      return null;
    }
    paramString = new PAGMovie(l);
    AppMethodBeat.o(195137);
    return paramString;
  }
  
  public static PAGMovie FromVideoPath(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(195139);
    paramLong1 = MakeFromVideoPath(paramString, paramLong1, paramLong2);
    if (paramLong1 == 0L)
    {
      AppMethodBeat.o(195139);
      return null;
    }
    paramString = new PAGMovie(paramLong1);
    AppMethodBeat.o(195139);
    return paramString;
  }
  
  private static native long MakeFromComposition(PAGComposition paramPAGComposition);
  
  private static native long MakeFromVideoPath(String paramString);
  
  private static native long MakeFromVideoPath(String paramString, long paramLong1, long paramLong2);
  
  private static native void nativeInit();
  
  public native long duration();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.libpag.PAGMovie
 * JD-Core Version:    0.7.0.1
 */