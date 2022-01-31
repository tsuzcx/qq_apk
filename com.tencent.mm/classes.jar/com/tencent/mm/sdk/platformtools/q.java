package com.tencent.mm.sdk.platformtools;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class q
{
  private static final Pattern uew = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
  private static final Pattern uex = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
  private static final Pattern uey = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
  
  public static InetAddress Ze(String paramString)
  {
    if (isIPv4Address(paramString)) {
      return InetAddress.getByName(paramString);
    }
    if (isIPv6Address(paramString)) {
      return InetAddress.getByName(paramString);
    }
    throw new UnknownHostException("invalid ipv4 or ipv6 dotted string");
  }
  
  public static boolean isIPv4Address(String paramString)
  {
    return uew.matcher(paramString).matches();
  }
  
  public static boolean isIPv6Address(String paramString)
  {
    return (uex.matcher(paramString).matches()) || (uey.matcher(paramString).matches());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.q
 * JD-Core Version:    0.7.0.1
 */