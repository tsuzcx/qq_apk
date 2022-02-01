package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class InetUtil
{
  private static final Pattern IPV4_PATTERN;
  private static final Pattern IPV6_HEX_COMPRESSED_PATTERN;
  private static final Pattern IPV6_STD_PATTERN;
  
  static
  {
    AppMethodBeat.i(157562);
    IPV4_PATTERN = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    IPV6_STD_PATTERN = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    IPV6_HEX_COMPRESSED_PATTERN = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    AppMethodBeat.o(157562);
  }
  
  public static InetAddress getByDottedAddress(String paramString)
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
    boolean bool = IPV4_PATTERN.matcher(paramString).matches();
    AppMethodBeat.o(157559);
    return bool;
  }
  
  public static boolean isIPv6Address(String paramString)
  {
    AppMethodBeat.i(157560);
    if ((isIPv6StdAddress(paramString)) || (isIPv6HexCompressedAddress(paramString)))
    {
      AppMethodBeat.o(157560);
      return true;
    }
    AppMethodBeat.o(157560);
    return false;
  }
  
  public static boolean isIPv6HexCompressedAddress(String paramString)
  {
    AppMethodBeat.i(194056);
    boolean bool = IPV6_HEX_COMPRESSED_PATTERN.matcher(paramString).matches();
    AppMethodBeat.o(194056);
    return bool;
  }
  
  public static boolean isIPv6StdAddress(String paramString)
  {
    AppMethodBeat.i(194054);
    boolean bool = IPV6_STD_PATTERN.matcher(paramString).matches();
    AppMethodBeat.o(194054);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.InetUtil
 * JD-Core Version:    0.7.0.1
 */