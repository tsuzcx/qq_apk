package NeighborComm;

import java.io.Serializable;

public final class MerchantType
  implements Serializable
{
  public static final MerchantType MerchantType_Nomal = new MerchantType(0, 0, "MerchantType_Nomal");
  public static final int _MerchantType_Nomal = 0;
  private static MerchantType[] a = new MerchantType[1];
  private String __T = new String();
  private int __value;
  
  private MerchantType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static MerchantType convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      MerchantType[] arrayOfMerchantType = a;
      if (i >= arrayOfMerchantType.length) {
        break;
      }
      if (arrayOfMerchantType[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static MerchantType convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      MerchantType[] arrayOfMerchantType = a;
      if (i >= arrayOfMerchantType.length) {
        break;
      }
      if (arrayOfMerchantType[i].toString().equals(paramString)) {
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
 * Qualified Name:     NeighborComm.MerchantType
 * JD-Core Version:    0.7.0.1
 */