package NeighborComm;

import java.io.Serializable;

public final class LocalInfoType
  implements Serializable
{
  public static final LocalInfoType LocalInfoType_Decode = new LocalInfoType(0, 0, "LocalInfoType_Decode");
  public static final LocalInfoType LocalInfoType_Encode = new LocalInfoType(1, 1, "LocalInfoType_Encode");
  public static final LocalInfoType LocalInfoType_SOSO = new LocalInfoType(2, 2, "LocalInfoType_SOSO");
  public static final int _LocalInfoType_Decode = 0;
  public static final int _LocalInfoType_Encode = 1;
  public static final int _LocalInfoType_SOSO = 2;
  private static LocalInfoType[] a = new LocalInfoType[3];
  private String __T = new String();
  private int __value;
  
  private LocalInfoType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static LocalInfoType convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      LocalInfoType[] arrayOfLocalInfoType = a;
      if (i >= arrayOfLocalInfoType.length) {
        break;
      }
      if (arrayOfLocalInfoType[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static LocalInfoType convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      LocalInfoType[] arrayOfLocalInfoType = a;
      if (i >= arrayOfLocalInfoType.length) {
        break;
      }
      if (arrayOfLocalInfoType[i].toString().equals(paramString)) {
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
 * Qualified Name:     NeighborComm.LocalInfoType
 * JD-Core Version:    0.7.0.1
 */