package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public final class a
{
  @Deprecated
  public static final Charset ISO_8859_1 = StandardCharsets.ISO_8859_1;
  @Deprecated
  public static final Charset UTF_8 = StandardCharsets.UTF_8;
  @Deprecated
  public static final Charset ajuA;
  @Deprecated
  public static final Charset ajuB;
  @Deprecated
  public static final Charset ajuC = StandardCharsets.US_ASCII;
  @Deprecated
  public static final Charset ajuz = StandardCharsets.UTF_16;
  
  static
  {
    ajuA = StandardCharsets.UTF_16BE;
    ajuB = StandardCharsets.UTF_16LE;
  }
  
  public static Charset b(Charset paramCharset)
  {
    AppMethodBeat.i(178791);
    if (paramCharset == null)
    {
      paramCharset = Charset.defaultCharset();
      AppMethodBeat.o(178791);
      return paramCharset;
    }
    AppMethodBeat.o(178791);
    return paramCharset;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.apache.commons.b.a
 * JD-Core Version:    0.7.0.1
 */