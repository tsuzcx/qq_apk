package MessageSvcPack;

import java.io.Serializable;

public final class MsgFilter
  implements Serializable
{
  public static final MsgFilter LIMIT_10_AND_IN_3_DAYS;
  public static final MsgFilter NO_FILTER;
  public static final int _LIMIT_10_AND_IN_3_DAYS = 1;
  public static final int _NO_FILTER = 0;
  private static MsgFilter[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!MsgFilter.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new MsgFilter[2];
      NO_FILTER = new MsgFilter(0, 0, "NO_FILTER");
      LIMIT_10_AND_IN_3_DAYS = new MsgFilter(1, 1, "LIMIT_10_AND_IN_3_DAYS");
      return;
    }
  }
  
  private MsgFilter(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static MsgFilter convert(int paramInt)
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
  
  public static MsgFilter convert(String paramString)
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
 * Qualified Name:     MessageSvcPack.MsgFilter
 * JD-Core Version:    0.7.0.1
 */