package org.libpag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.extra.tools.b;

public class PAGMovie
  extends PAGImage
{
  static
  {
    AppMethodBeat.i(236904);
    b.loadLibrary("pag");
    nativeInit();
    AppMethodBeat.o(236904);
  }
  
  private PAGMovie(long paramLong)
  {
    super(paramLong);
  }
  
  public static PAGMovie FromComposition(PAGComposition paramPAGComposition)
  {
    AppMethodBeat.i(236901);
    long l = MakeFromComposition(paramPAGComposition);
    if (l == 0L)
    {
      AppMethodBeat.o(236901);
      return null;
    }
    paramPAGComposition = new PAGMovie(l);
    AppMethodBeat.o(236901);
    return paramPAGComposition;
  }
  
  public static PAGMovie FromVideoPath(String paramString)
  {
    AppMethodBeat.i(236902);
    long l = MakeFromVideoPath(paramString);
    if (l == 0L)
    {
      AppMethodBeat.o(236902);
      return null;
    }
    paramString = new PAGMovie(l);
    AppMethodBeat.o(236902);
    return paramString;
  }
  
  public static PAGMovie FromVideoPath(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(236903);
    paramLong1 = MakeFromVideoPath(paramString, paramLong1, paramLong2);
    if (paramLong1 == 0L)
    {
      AppMethodBeat.o(236903);
      return null;
    }
    paramString = new PAGMovie(paramLong1);
    AppMethodBeat.o(236903);
    return paramString;
  }
  
  private static native long MakeFromComposition(PAGComposition paramPAGComposition);
  
  private static native long MakeFromVideoPath(String paramString);
  
  private static native long MakeFromVideoPath(String paramString, long paramLong1, long paramLong2);
  
  private static native void nativeInit();
  
  public native long duration();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.libpag.PAGMovie
 * JD-Core Version:    0.7.0.1
 */