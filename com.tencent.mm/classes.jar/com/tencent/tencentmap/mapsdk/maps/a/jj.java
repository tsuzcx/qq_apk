package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class jj
{
  public static int a(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0] & 0xFF | 0xFF00 & paramArrayOfByte[1] << 8 | 0xFF0000 & paramArrayOfByte[2] << 16 | 0xFF000000 & paramArrayOfByte[3] << 24;
  }
  
  public static String a(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(148704);
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, paramString).trim();
      AppMethodBeat.o(148704);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(148704);
    }
    return null;
  }
  
  public static byte[] a(int paramInt)
  {
    return new byte[] { (byte)paramInt, (byte)(paramInt >> 8), (byte)(paramInt >> 16), (byte)(paramInt >> 24) };
  }
  
  public static byte[] a(String paramString)
  {
    AppMethodBeat.i(148702);
    if (paramString != null) {
      try
      {
        paramString = paramString.getBytes("UTF-16LE");
        AppMethodBeat.o(148702);
        return paramString;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(148702);
    return new byte[0];
  }
  
  public static boolean b(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    if (paramArrayOfByte[0] > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static float c(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148701);
    float f = Float.intBitsToFloat(a(paramArrayOfByte));
    AppMethodBeat.o(148701);
    return f;
  }
  
  public static String d(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148703);
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-16LE").trim();
      AppMethodBeat.o(148703);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(148703);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.jj
 * JD-Core Version:    0.7.0.1
 */