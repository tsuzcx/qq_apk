package RegisterProxySvcPack;

import java.io.Serializable;

public final class eDisGroupInfoFlag
  implements Serializable
{
  public static final eDisGroupInfoFlag E_DIS_GROUP_ADD;
  public static final eDisGroupInfoFlag E_DIS_GROUP_DEFAULT;
  public static final eDisGroupInfoFlag E_DIS_GROUP_DEL;
  public static final eDisGroupInfoFlag E_DIS_GROUP_EXIST_C;
  public static final eDisGroupInfoFlag E_DIS_GROUP_EXIST_CS;
  public static final eDisGroupInfoFlag E_DIS_GROUP_INVALID;
  public static final int _E_DIS_GROUP_ADD = 1;
  public static final int _E_DIS_GROUP_DEFAULT = -1;
  public static final int _E_DIS_GROUP_DEL = 3;
  public static final int _E_DIS_GROUP_EXIST_C = 4;
  public static final int _E_DIS_GROUP_EXIST_CS = 0;
  public static final int _E_DIS_GROUP_INVALID = 2;
  private static eDisGroupInfoFlag[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!eDisGroupInfoFlag.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new eDisGroupInfoFlag[6];
      E_DIS_GROUP_DEFAULT = new eDisGroupInfoFlag(0, -1, "E_DIS_GROUP_DEFAULT");
      E_DIS_GROUP_EXIST_CS = new eDisGroupInfoFlag(1, 0, "E_DIS_GROUP_EXIST_CS");
      E_DIS_GROUP_ADD = new eDisGroupInfoFlag(2, 1, "E_DIS_GROUP_ADD");
      E_DIS_GROUP_INVALID = new eDisGroupInfoFlag(3, 2, "E_DIS_GROUP_INVALID");
      E_DIS_GROUP_DEL = new eDisGroupInfoFlag(4, 3, "E_DIS_GROUP_DEL");
      E_DIS_GROUP_EXIST_C = new eDisGroupInfoFlag(5, 4, "E_DIS_GROUP_EXIST_C");
      return;
    }
  }
  
  private eDisGroupInfoFlag(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static eDisGroupInfoFlag convert(int paramInt)
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
  
  public static eDisGroupInfoFlag convert(String paramString)
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
 * Qualified Name:     RegisterProxySvcPack.eDisGroupInfoFlag
 * JD-Core Version:    0.7.0.1
 */