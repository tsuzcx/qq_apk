package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class t
{
  private static final Pattern ymX;
  private static final Pattern ymY;
  private static final Pattern ymZ;
  
  static
  {
    AppMethodBeat.i(52006);
    ymX = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    ymY = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    ymZ = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    AppMethodBeat.o(52006);
  }
  
  public static InetAddress apc(String paramString)
  {
    AppMethodBeat.i(52005);
    if (isIPv4Address(paramString))
    {
      paramString = InetAddress.getByName(paramString);
      AppMethodBeat.o(52005);
      return paramString;
    }
    if (isIPv6Address(paramString))
    {
      paramString = InetAddress.getByName(paramString);
      AppMethodBeat.o(52005);
      return paramString;
    }
    paramString = new UnknownHostException("invalid ipv4 or ipv6 dotted string");
    AppMethodBeat.o(52005);
    throw paramString;
  }
  
  public static boolean isIPv4Address(String paramString)
  {
    AppMethodBeat.i(52003);
    boolean bool = ymX.matcher(paramString).matches();
    AppMethodBeat.o(52003);
    return bool;
  }
  
  public static boolean isIPv6Address(String paramString)
  {
    AppMethodBeat.i(52004);
    if ((ymY.matcher(paramString).matches()) || (ymZ.matcher(paramString).matches()))
    {
      AppMethodBeat.o(52004);
      return true;
    }
    AppMethodBeat.o(52004);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.t
 * JD-Core Version:    0.7.0.1
 */