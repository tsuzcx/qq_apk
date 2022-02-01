package org.apache.commons.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public final class a
{
  @Deprecated
  public static final Charset ISO_8859_1 = StandardCharsets.ISO_8859_1;
  @Deprecated
  public static final Charset US_ASCII = StandardCharsets.US_ASCII;
  @Deprecated
  public static final Charset UTF_16 = StandardCharsets.UTF_16;
  @Deprecated
  public static final Charset UTF_16BE = StandardCharsets.UTF_16BE;
  @Deprecated
  public static final Charset UTF_16LE = StandardCharsets.UTF_16LE;
  @Deprecated
  public static final Charset UTF_8 = StandardCharsets.UTF_8;
  
  public static Charset a(Charset paramCharset)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     org.apache.commons.a.a
 * JD-Core Version:    0.7.0.1
 */