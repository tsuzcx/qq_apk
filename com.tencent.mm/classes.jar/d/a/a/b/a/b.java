package d.a.a.b.a;

import java.io.IOException;

public final class b
  extends IOException
{
  private b(String paramString)
  {
    super(paramString);
  }
  
  static b cUu()
  {
    return new b("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
  }
  
  static b cUv()
  {
    return new b("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static b cUw()
  {
    return new b("CodedInputStream encountered a malformed varint.");
  }
  
  public static b cUx()
  {
    return new b("Protocol message contained an invalid tag (zero).");
  }
  
  static b cUy()
  {
    return new b("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.a.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */