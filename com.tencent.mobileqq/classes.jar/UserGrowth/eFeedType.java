package UserGrowth;

import java.io.Serializable;

public final class eFeedType
  implements Serializable
{
  private static eFeedType[] __values;
  public static final int _eFeedTypePerson = 1;
  public static final int _eFeedTypeVideo = 2;
  public static final eFeedType eFeedTypePerson;
  public static final eFeedType eFeedTypeVideo;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!eFeedType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      __values = new eFeedType[2];
      eFeedTypePerson = new eFeedType(0, 1, "eFeedTypePerson");
      eFeedTypeVideo = new eFeedType(1, 2, "eFeedTypeVideo");
      return;
    }
  }
  
  private eFeedType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static eFeedType convert(int paramInt)
  {
    int i = 0;
    while (i < __values.length)
    {
      if (__values[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static eFeedType convert(String paramString)
  {
    int i = 0;
    while (i < __values.length)
    {
      if (__values[i].toString().equals(paramString)) {
        return __values[i];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.eFeedType
 * JD-Core Version:    0.7.0.1
 */