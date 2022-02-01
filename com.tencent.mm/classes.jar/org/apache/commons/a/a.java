package org.apache.commons.a;

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
  public static final Charset abvr;
  @Deprecated
  public static final Charset abvs;
  @Deprecated
  public static final Charset abvt;
  @Deprecated
  public static final Charset abvu = StandardCharsets.US_ASCII;
  
  static
  {
    abvr = StandardCharsets.UTF_16;
    abvs = StandardCharsets.UTF_16BE;
    abvt = StandardCharsets.UTF_16LE;
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
 * Qualified Name:     org.apache.commons.a.a
 * JD-Core Version:    0.7.0.1
 */