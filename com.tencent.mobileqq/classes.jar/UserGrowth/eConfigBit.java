package UserGrowth;

import java.io.Serializable;

public final class eConfigBit
  implements Serializable
{
  private static eConfigBit[] __values = new eConfigBit[4];
  public static final int _eGetAuth = 4;
  public static final int _eGetCallInBg = 8;
  public static final int _eSetAuth = 2;
  public static final int _eShowConfirmWindow = 1;
  public static final eConfigBit eGetAuth = new eConfigBit(2, 4, "eGetAuth");
  public static final eConfigBit eGetCallInBg = new eConfigBit(3, 8, "eGetCallInBg");
  public static final eConfigBit eSetAuth;
  public static final eConfigBit eShowConfirmWindow = new eConfigBit(0, 1, "eShowConfirmWindow");
  private String __T = new String();
  private int __value;
  
  static
  {
    eSetAuth = new eConfigBit(1, 2, "eSetAuth");
  }
  
  private eConfigBit(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static eConfigBit convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      eConfigBit[] arrayOfeConfigBit = __values;
      if (i >= arrayOfeConfigBit.length) {
        break;
      }
      if (arrayOfeConfigBit[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static eConfigBit convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      eConfigBit[] arrayOfeConfigBit = __values;
      if (i >= arrayOfeConfigBit.length) {
        break;
      }
      if (arrayOfeConfigBit[i].toString().equals(paramString)) {
        return __values[i];
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
 * Qualified Name:     UserGrowth.eConfigBit
 * JD-Core Version:    0.7.0.1
 */