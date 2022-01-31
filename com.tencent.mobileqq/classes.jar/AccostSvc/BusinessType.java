package AccostSvc;

import java.io.Serializable;

public final class BusinessType
  implements Serializable
{
  public static final BusinessType BusinessType_Friend;
  public static final BusinessType BusinessType_LBS_YSS;
  public static final BusinessType BusinessType_MGroup;
  public static final BusinessType BusinessType_MQQ;
  public static final int _BusinessType_Friend = 1;
  public static final int _BusinessType_LBS_YSS = 101;
  public static final int _BusinessType_MGroup = 2;
  public static final int _BusinessType_MQQ = 0;
  private static BusinessType[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!BusinessType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new BusinessType[4];
      BusinessType_MQQ = new BusinessType(0, 0, "BusinessType_MQQ");
      BusinessType_Friend = new BusinessType(1, 1, "BusinessType_Friend");
      BusinessType_MGroup = new BusinessType(2, 2, "BusinessType_MGroup");
      BusinessType_LBS_YSS = new BusinessType(3, 101, "BusinessType_LBS_YSS");
      return;
    }
  }
  
  private BusinessType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static BusinessType convert(int paramInt)
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
  
  public static BusinessType convert(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom1.jar
 * Qualified Name:     AccostSvc.BusinessType
 * JD-Core Version:    0.7.0.1
 */