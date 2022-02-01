package a.a.a.b.a;

import java.io.IOException;

public final class b
  extends IOException
{
  private b(String paramString)
  {
    super(paramString);
  }
  
  static b pA()
  {
    return new b("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
  }
  
  static b pw()
  {
    return new b("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
  }
  
  static b px()
  {
    return new b("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static b py()
  {
    return new b("CodedInputStream encountered a malformed varint.");
  }
  
  static b pz()
  {
    return new b("Protocol message contained an invalid tag (zero).");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     a.a.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */