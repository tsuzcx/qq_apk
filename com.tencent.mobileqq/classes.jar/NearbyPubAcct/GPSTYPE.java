package NearbyPubAcct;

import java.io.Serializable;

public final class GPSTYPE
  implements Serializable
{
  public static final GPSTYPE GPS_GCJ02 = new GPSTYPE(1, 1, "GPS_GCJ02");
  public static final GPSTYPE GPS_WGS84;
  public static final GPSTYPE GPS_WGS_REAL = new GPSTYPE(2, 2, "GPS_WGS_REAL");
  public static final int _GPS_GCJ02 = 1;
  public static final int _GPS_WGS84 = 0;
  public static final int _GPS_WGS_REAL = 2;
  private static GPSTYPE[] a = new GPSTYPE[3];
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
    a[paramInt1] = this;
  }
  
  public static GPSTYPE convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      GPSTYPE[] arrayOfGPSTYPE = a;
      if (i >= arrayOfGPSTYPE.length) {
        break;
      }
      if (arrayOfGPSTYPE[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static GPSTYPE convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      GPSTYPE[] arrayOfGPSTYPE = a;
      if (i >= arrayOfGPSTYPE.length) {
        break;
      }
      if (arrayOfGPSTYPE[i].toString().equals(paramString)) {
        return a[i];
      }
      i += 1;
    }
    return null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NearbyPubAcct.GPSTYPE
 * JD-Core Version:    0.7.0.1
 */