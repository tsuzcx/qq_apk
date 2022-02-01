package d.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class k
  extends IOException
{
  public q Nrq = null;
  
  public k(String paramString)
  {
    super(paramString);
  }
  
  static k grP()
  {
    AppMethodBeat.i(59481);
    k localk = new k("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    AppMethodBeat.o(59481);
    return localk;
  }
  
  static k grQ()
  {
    AppMethodBeat.i(59482);
    k localk = new k("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    AppMethodBeat.o(59482);
    return localk;
  }
  
  static k grR()
  {
    AppMethodBeat.i(59483);
    k localk = new k("CodedInputStream encountered a malformed varint.");
    AppMethodBeat.o(59483);
    return localk;
  }
  
  static k grS()
  {
    AppMethodBeat.i(59484);
    k localk = new k("Protocol message contained an invalid tag (zero).");
    AppMethodBeat.o(59484);
    return localk;
  }
  
  static k grT()
  {
    AppMethodBeat.i(59485);
    k localk = new k("Protocol message end-group tag did not match expected tag.");
    AppMethodBeat.o(59485);
    return localk;
  }
  
  static k grU()
  {
    AppMethodBeat.i(59486);
    k localk = new k("Protocol message tag had invalid wire type.");
    AppMethodBeat.o(59486);
    return localk;
  }
  
  static k grV()
  {
    AppMethodBeat.i(59487);
    k localk = new k("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    AppMethodBeat.o(59487);
    return localk;
  }
  
  static k grW()
  {
    AppMethodBeat.i(59488);
    k localk = new k("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    AppMethodBeat.o(59488);
    return localk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.h.k
 * JD-Core Version:    0.7.0.1
 */