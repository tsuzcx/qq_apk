package protocol.KQQConfig;

import java.io.Serializable;

public final class GPSTYPE
  implements Serializable
{
  public static final GPSTYPE GPS_MARS = new GPSTYPE(1, 1, "GPS_MARS");
  public static final GPSTYPE GPS_WGS84;
  public static final GPSTYPE GPS_WGS_REAL = new GPSTYPE(2, 2, "GPS_WGS_REAL");
  public static final int _GPS_MARS = 1;
  public static final int _GPS_WGS84 = 0;
  public static final int _GPS_WGS_REAL = 2;
  private static GPSTYPE[] __values = new GPSTYPE[3];
  private String __T = new String();
  private int __value;
  
  static
  {
    GPS_WGS84 = new GPSTYPE(0, 0, "GPS_WGS84");
  }
  
  private GPSTYPE(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static GPSTYPE convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      GPSTYPE[] arrayOfGPSTYPE = __values;
      if (i >= arrayOfGPSTYPE.length) {
        return null;
      }
      if (arrayOfGPSTYPE[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
  }
  
  public static GPSTYPE convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      GPSTYPE[] arrayOfGPSTYPE = __values;
      if (i >= arrayOfGPSTYPE.length) {
        return null;
      }
      if (arrayOfGPSTYPE[i].toString().equals(paramString)) {
        return __values[i];
      }
      i += 1;
    }
  }
  
  public String toString()
  {
    return this.__T;
  }
  
  public int value()
  {
    return this.__value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     protocol.KQQConfig.GPSTYPE
 * JD-Core Version:    0.7.0.1
 */