package UserGrowth;

import java.io.Serializable;

public final class eBlockStyle
  implements Serializable
{
  private static eBlockStyle[] __values = new eBlockStyle[2];
  public static final int _eBlockMiddle = 2;
  public static final int _eBlockTop = 1;
  public static final eBlockStyle eBlockMiddle = new eBlockStyle(1, 2, "eBlockMiddle");
  public static final eBlockStyle eBlockTop = new eBlockStyle(0, 1, "eBlockTop");
  private String __T = new String();
  private int __value;
  
  private eBlockStyle(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static eBlockStyle convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      eBlockStyle[] arrayOfeBlockStyle = __values;
      if (i >= arrayOfeBlockStyle.length) {
        break;
      }
      if (arrayOfeBlockStyle[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static eBlockStyle convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      eBlockStyle[] arrayOfeBlockStyle = __values;
      if (i >= arrayOfeBlockStyle.length) {
        break;
      }
      if (arrayOfeBlockStyle[i].toString().equals(paramString)) {
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
 * Qualified Name:     UserGrowth.eBlockStyle
 * JD-Core Version:    0.7.0.1
 */