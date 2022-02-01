package UserGrowth;

import java.io.Serializable;

public final class eBlockStyle
  implements Serializable
{
  private static eBlockStyle[] __values;
  public static final int _eBlockMiddle = 2;
  public static final int _eBlockTop = 1;
  public static final eBlockStyle eBlockMiddle;
  public static final eBlockStyle eBlockTop;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!eBlockStyle.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      __values = new eBlockStyle[2];
      eBlockTop = new eBlockStyle(0, 1, "eBlockTop");
      eBlockMiddle = new eBlockStyle(1, 2, "eBlockMiddle");
      return;
    }
  }
  
  private eBlockStyle(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static eBlockStyle convert(int paramInt)
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
  
  public static eBlockStyle convert(String paramString)
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
 * Qualified Name:     UserGrowth.eBlockStyle
 * JD-Core Version:    0.7.0.1
 */