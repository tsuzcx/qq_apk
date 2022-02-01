package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class l
  extends IOException
{
  public r ajfp = null;
  
  public l(String paramString)
  {
    super(paramString);
  }
  
  static l kyn()
  {
    AppMethodBeat.i(59481);
    l locall = new l("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    AppMethodBeat.o(59481);
    return locall;
  }
  
  static l kyo()
  {
    AppMethodBeat.i(59482);
    l locall = new l("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    AppMethodBeat.o(59482);
    return locall;
  }
  
  static l kyp()
  {
    AppMethodBeat.i(59483);
    l locall = new l("CodedInputStream encountered a malformed varint.");
    AppMethodBeat.o(59483);
    return locall;
  }
  
  static l kyq()
  {
    AppMethodBeat.i(59484);
    l locall = new l("Protocol message contained an invalid tag (zero).");
    AppMethodBeat.o(59484);
    return locall;
  }
  
  static l kyr()
  {
    AppMethodBeat.i(59485);
    l locall = new l("Protocol message end-group tag did not match expected tag.");
    AppMethodBeat.o(59485);
    return locall;
  }
  
  static l kys()
  {
    AppMethodBeat.i(59486);
    l locall = new l("Protocol message tag had invalid wire type.");
    AppMethodBeat.o(59486);
    return locall;
  }
  
  static l kyt()
  {
    AppMethodBeat.i(59487);
    l locall = new l("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    AppMethodBeat.o(59487);
    return locall;
  }
  
  static l kyu()
  {
    AppMethodBeat.i(59488);
    l locall = new l("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    AppMethodBeat.o(59488);
    return locall;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.h.l
 * JD-Core Version:    0.7.0.1
 */