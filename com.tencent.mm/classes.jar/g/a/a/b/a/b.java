package g.a.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class b
  extends IOException
{
  private b(String paramString)
  {
    super(paramString);
  }
  
  static b hPp()
  {
    AppMethodBeat.i(2405);
    b localb = new b("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    AppMethodBeat.o(2405);
    return localb;
  }
  
  static b hPq()
  {
    AppMethodBeat.i(2406);
    b localb = new b("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    AppMethodBeat.o(2406);
    return localb;
  }
  
  static b hPr()
  {
    AppMethodBeat.i(2407);
    b localb = new b("CodedInputStream encountered a malformed varint.");
    AppMethodBeat.o(2407);
    return localb;
  }
  
  static b hPs()
  {
    AppMethodBeat.i(2408);
    b localb = new b("Protocol message contained an invalid tag (zero).");
    AppMethodBeat.o(2408);
    return localb;
  }
  
  static b hPt()
  {
    AppMethodBeat.i(2409);
    b localb = new b("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    AppMethodBeat.o(2409);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     g.a.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */