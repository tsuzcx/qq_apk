package LBSAddrProtocol;

import java.io.Serializable;

public final class POITYPE
  implements Serializable
{
  public static final POITYPE POI_CULTURE;
  public static final POITYPE POI_ENTM;
  public static final POITYPE POI_FOOD;
  public static final POITYPE POI_HEALTH;
  public static final POITYPE POI_HOTEL;
  public static final POITYPE POI_INFRA;
  public static final POITYPE POI_ORG;
  public static final POITYPE POI_PLACE;
  public static final POITYPE POI_SERVICE;
  public static final POITYPE POI_SHOPPING;
  public static final POITYPE POI_TOUR;
  public static final POITYPE POI_WORK;
  public static final int _POI_CULTURE = 170000;
  public static final int _POI_ENTM = 160000;
  public static final int _POI_FOOD = 100000;
  public static final int _POI_HEALTH = 200000;
  public static final int _POI_HOTEL = 210000;
  public static final int _POI_INFRA = 270000;
  public static final int _POI_ORG = 120000;
  public static final int _POI_PLACE = 260000;
  public static final int _POI_SERVICE = 140000;
  public static final int _POI_SHOPPING = 130000;
  public static final int _POI_TOUR = 220000;
  public static final int _POI_WORK = 280000;
  private static POITYPE[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!POITYPE.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new POITYPE[12];
      POI_FOOD = new POITYPE(0, 100000, "POI_FOOD");
      POI_ORG = new POITYPE(1, 120000, "POI_ORG");
      POI_SHOPPING = new POITYPE(2, 130000, "POI_SHOPPING");
      POI_SERVICE = new POITYPE(3, 140000, "POI_SERVICE");
      POI_ENTM = new POITYPE(4, 160000, "POI_ENTM");
      POI_CULTURE = new POITYPE(5, 170000, "POI_CULTURE");
      POI_HEALTH = new POITYPE(6, 200000, "POI_HEALTH");
      POI_HOTEL = new POITYPE(7, 210000, "POI_HOTEL");
      POI_TOUR = new POITYPE(8, 220000, "POI_TOUR");
      POI_PLACE = new POITYPE(9, 260000, "POI_PLACE");
      POI_INFRA = new POITYPE(10, 270000, "POI_INFRA");
      POI_WORK = new POITYPE(11, 280000, "POI_WORK");
      return;
    }
  }
  
  private POITYPE(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static POITYPE convert(int paramInt)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static POITYPE convert(String paramString)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i].toString().equals(paramString)) {
        return a[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom2.jar
 * Qualified Name:     LBSAddrProtocol.POITYPE
 * JD-Core Version:    0.7.0.1
 */