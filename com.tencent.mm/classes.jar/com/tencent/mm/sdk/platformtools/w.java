package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class w
{
  private static final Pattern IwZ;
  private static final Pattern Ixa;
  private static final Pattern Ixb;
  
  static
  {
    AppMethodBeat.i(157562);
    IwZ = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    Ixa = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    Ixb = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    AppMethodBeat.o(157562);
  }
  
  public static InetAddress aRK(String paramString)
  {
    AppMethodBeat.i(157561);
    if (isIPv4Address(paramString))
    {
      paramString = InetAddress.getByName(paramString);
      AppMethodBeat.o(157561);
      return paramString;
    }
    if (isIPv6Address(paramString))
    {
      paramString = InetAddress.getByName(paramString);
      AppMethodBeat.o(157561);
      return paramString;
    }
    paramString = new UnknownHostException("invalid ipv4 or ipv6 dotted string");
    AppMethodBeat.o(157561);
    throw paramString;
  }
  
  public static boolean isIPv4Address(String paramString)
  {
    AppMethodBeat.i(157559);
    boolean bool = IwZ.matcher(paramString).matches();
    AppMethodBeat.o(157559);
    return bool;
  }
  
  public static boolean isIPv6Address(String paramString)
  {
    AppMethodBeat.i(157560);
    if ((Ixa.matcher(paramString).matches()) || (Ixb.matcher(paramString).matches()))
    {
      AppMethodBeat.o(157560);
      return true;
    }
    AppMethodBeat.o(157560);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.w
 * JD-Core Version:    0.7.0.1
 */