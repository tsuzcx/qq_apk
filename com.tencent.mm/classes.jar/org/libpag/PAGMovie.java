package org.libpag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.extra.tools.b;

public class PAGMovie
  extends PAGImage
{
  static
  {
    AppMethodBeat.i(216933);
    b.loadLibrary("libpag");
    nativeInit();
    PAGFont.loadSystemFonts();
    AppMethodBeat.o(216933);
  }
  
  private PAGMovie(long paramLong)
  {
    super(paramLong);
  }
  
  public static PAGMovie FromComposition(PAGComposition paramPAGComposition)
  {
    AppMethodBeat.i(216930);
    long l = MakeFromComposition(paramPAGComposition);
    if (l == 0L)
    {
      AppMethodBeat.o(216930);
      return null;
    }
    paramPAGComposition = new PAGMovie(l);
    AppMethodBeat.o(216930);
    return paramPAGComposition;
  }
  
  public static PAGMovie FromVideoPath(String paramString)
  {
    AppMethodBeat.i(216931);
    long l = MakeFromVideoPath(paramString);
    if (l == 0L)
    {
      AppMethodBeat.o(216931);
      return null;
    }
    paramString = new PAGMovie(l);
    AppMethodBeat.o(216931);
    return paramString;
  }
  
  public static PAGMovie FromVideoPath(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(216932);
    paramLong1 = MakeFromVideoPath(paramString, paramLong1, paramLong2);
    if (paramLong1 == 0L)
    {
      AppMethodBeat.o(216932);
      return null;
    }
    paramString = new PAGMovie(paramLong1);
    AppMethodBeat.o(216932);
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