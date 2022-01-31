package e.a.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class b
  extends IOException
{
  private b(String paramString)
  {
    super(paramString);
  }
  
  static b eqT()
  {
    AppMethodBeat.i(51871);
    b localb = new b("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    AppMethodBeat.o(51871);
    return localb;
  }
  
  static b eqU()
  {
    AppMethodBeat.i(51872);
    b localb = new b("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    AppMethodBeat.o(51872);
    return localb;
  }
  
  static b eqV()
  {
    AppMethodBeat.i(51873);
    b localb = new b("CodedInputStream encountered a malformed varint.");
    AppMethodBeat.o(51873);
    return localb;
  }
  
  public static b eqW()
  {
    AppMethodBeat.i(51874);
    b localb = new b("Protocol message contained an invalid tag (zero).");
    AppMethodBeat.o(51874);
    return localb;
  }
  
  static b eqX()
  {
    AppMethodBeat.i(51875);
    b localb = new b("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    AppMethodBeat.o(51875);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     e.a.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */