package QQService;

import java.io.Serializable;

public final class EFLAG
  implements Serializable
{
  public static final EFLAG E_DELUXE = new EFLAG(0, 1, "E_DELUXE");
  public static final int _E_DELUXE = 1;
  private static EFLAG[] a = new EFLAG[1];
  private String __T = new String();
  private int __value;
  
  private EFLAG(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static EFLAG convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      EFLAG[] arrayOfEFLAG = a;
      if (i >= arrayOfEFLAG.length) {
        break;
      }
      if (arrayOfEFLAG[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static EFLAG convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      EFLAG[] arrayOfEFLAG = a;
      if (i >= arrayOfEFLAG.length) {
        break;
      }
      if (arrayOfEFLAG[i].toString().equals(paramString)) {
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
 * Qualified Name:     QQService.EFLAG
 * JD-Core Version:    0.7.0.1
 */