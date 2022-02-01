package PasserbySvc;

import java.io.Serializable;

public final class CMDTYPE
  implements Serializable
{
  public static final CMDTYPE CMD_CHECK_IN;
  public static final CMDTYPE CMD_GET_PASSERBIES;
  public static final CMDTYPE CMD_INIT;
  public static final CMDTYPE CMD_SET_USER_STATE;
  public static final int _CMD_CHECK_IN = 1;
  public static final int _CMD_GET_PASSERBIES = 2;
  public static final int _CMD_INIT = 0;
  public static final int _CMD_SET_USER_STATE = 3;
  private static CMDTYPE[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!CMDTYPE.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new CMDTYPE[4];
      CMD_INIT = new CMDTYPE(0, 0, "CMD_INIT");
      CMD_CHECK_IN = new CMDTYPE(1, 1, "CMD_CHECK_IN");
      CMD_GET_PASSERBIES = new CMDTYPE(2, 2, "CMD_GET_PASSERBIES");
      CMD_SET_USER_STATE = new CMDTYPE(3, 3, "CMD_SET_USER_STATE");
      return;
    }
  }
  
  private CMDTYPE(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static CMDTYPE convert(int paramInt)
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
  
  public static CMDTYPE convert(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     PasserbySvc.CMDTYPE
 * JD-Core Version:    0.7.0.1
 */