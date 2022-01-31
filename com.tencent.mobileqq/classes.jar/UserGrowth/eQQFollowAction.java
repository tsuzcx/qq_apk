package UserGrowth;

import java.io.Serializable;

public final class eQQFollowAction
  implements Serializable
{
  private static eQQFollowAction[] __values;
  public static final int _eQQFollowActionCancel = 2;
  public static final int _eQQFollowActionConfirm = 1;
  public static final eQQFollowAction eQQFollowActionCancel;
  public static final eQQFollowAction eQQFollowActionConfirm;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!eQQFollowAction.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      __values = new eQQFollowAction[2];
      eQQFollowActionConfirm = new eQQFollowAction(0, 1, "eQQFollowActionConfirm");
      eQQFollowActionCancel = new eQQFollowAction(1, 2, "eQQFollowActionCancel");
      return;
    }
  }
  
  private eQQFollowAction(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static eQQFollowAction convert(int paramInt)
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
  
  public static eQQFollowAction convert(String paramString)
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
 * Qualified Name:     UserGrowth.eQQFollowAction
 * JD-Core Version:    0.7.0.1
 */