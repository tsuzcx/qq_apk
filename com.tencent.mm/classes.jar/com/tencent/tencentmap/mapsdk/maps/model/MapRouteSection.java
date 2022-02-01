package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MapRouteSection
{
  public static final int kMaxRoadNameLength = 32;
  public int color;
  public int endNum;
  public String roadName;
  public int startNum;
  
  public static int byteLength()
  {
    return 140;
  }
  
  private byte[] intToBytes(int paramInt)
  {
    return new byte[] { (byte)paramInt, (byte)(paramInt >> 8), (byte)(paramInt >> 16), (byte)(paramInt >> 24) };
  }
  
  private byte[] stringToBytes(String paramString)
  {
    AppMethodBeat.i(181079);
    if (paramString != null) {
      try
      {
        paramString = paramString.getBytes("UTF-16LE");
        AppMethodBeat.o(181079);
        return paramString;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(181079);
    return new byte[0];
  }
  
  public byte[] toBytes()
  {
    AppMethodBeat.i(181078);
    byte[] arrayOfByte1 = new byte[byteLength()];
    System.arraycopy(intToBytes(this.startNum), 0, arrayOfByte1, 0, 4);
    System.arraycopy(intToBytes(this.endNum), 0, arrayOfByte1, 4, 4);
    System.arraycopy(intToBytes(this.color), 0, arrayOfByte1, 8, 4);
    byte[] arrayOfByte2 = stringToBytes(this.roadName);
    if (arrayOfByte2.length < 32) {
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 12, arrayOfByte2.length);
    }
    for (;;)
    {
      AppMethodBeat.o(181078);
      return arrayOfByte1;
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 12, 32);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.MapRouteSection
 * JD-Core Version:    0.7.0.1
 */