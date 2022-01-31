package com.google.android.gms.internal;

import java.io.IOException;

public final class dv
  extends IOException
{
  private dv(String paramString)
  {
    super(paramString);
  }
  
  static dv kb()
  {
    return new dv("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
  }
  
  static dv kc()
  {
    return new dv("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static dv kd()
  {
    return new dv("CodedInputStream encountered a malformed varint.");
  }
  
  static dv ke()
  {
    return new dv("Protocol message contained an invalid tag (zero).");
  }
  
  static dv kf()
  {
    return new dv("Protocol message end-group tag did not match expected tag.");
  }
  
  static dv kg()
  {
    return new dv("Protocol message tag had invalid wire type.");
  }
  
  static dv kh()
  {
    return new dv("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.dv
 * JD-Core Version:    0.7.0.1
 */