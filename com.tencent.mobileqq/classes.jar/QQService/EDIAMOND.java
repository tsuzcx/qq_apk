package QQService;

import java.io.Serializable;

public final class EDIAMOND
  implements Serializable
{
  public static final EDIAMOND E_DIAMOND_10YEAR_YELLOW = new EDIAMOND(5, 111, "E_DIAMOND_10YEAR_YELLOW");
  public static final EDIAMOND E_DIAMOND_COUPLE_YELLOW;
  public static final EDIAMOND E_DIAMOND_GREEN;
  public static final EDIAMOND E_DIAMOND_RED;
  public static final EDIAMOND E_DIAMOND_SUPER_STAR;
  public static final EDIAMOND E_DIAMOND_YELLOW;
  public static final int _E_DIAMOND_10YEAR_YELLOW = 111;
  public static final int _E_DIAMOND_COUPLE_YELLOW = 104;
  public static final int _E_DIAMOND_GREEN = 103;
  public static final int _E_DIAMOND_RED = 101;
  public static final int _E_DIAMOND_SUPER_STAR = 105;
  public static final int _E_DIAMOND_YELLOW = 102;
  private static EDIAMOND[] a = new EDIAMOND[6];
  private String __T = new String();
  private int __value;
  
  static
  {
    E_DIAMOND_RED = new EDIAMOND(0, 101, "E_DIAMOND_RED");
    E_DIAMOND_YELLOW = new EDIAMOND(1, 102, "E_DIAMOND_YELLOW");
    E_DIAMOND_GREEN = new EDIAMOND(2, 103, "E_DIAMOND_GREEN");
    E_DIAMOND_COUPLE_YELLOW = new EDIAMOND(3, 104, "E_DIAMOND_COUPLE_YELLOW");
    E_DIAMOND_SUPER_STAR = new EDIAMOND(4, 105, "E_DIAMOND_SUPER_STAR");
  }
  
  private EDIAMOND(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static EDIAMOND convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      EDIAMOND[] arrayOfEDIAMOND = a;
      if (i >= arrayOfEDIAMOND.length) {
        break;
      }
      if (arrayOfEDIAMOND[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static EDIAMOND convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      EDIAMOND[] arrayOfEDIAMOND = a;
      if (i >= arrayOfEDIAMOND.length) {
        break;
      }
      if (arrayOfEDIAMOND[i].toString().equals(paramString)) {
        return a[i];
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
 * Qualified Name:     QQService.EDIAMOND
 * JD-Core Version:    0.7.0.1
 */