package UserGrowth;

import java.io.Serializable;

public final class eLandingPage
  implements Serializable
{
  private static eLandingPage[] __values = new eLandingPage[2];
  public static final int _eLandingPageFallList = 0;
  public static final int _eLandingPageVideoPage = 1;
  public static final eLandingPage eLandingPageFallList = new eLandingPage(0, 0, "eLandingPageFallList");
  public static final eLandingPage eLandingPageVideoPage = new eLandingPage(1, 1, "eLandingPageVideoPage");
  private String __T = new String();
  private int __value;
  
  private eLandingPage(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static eLandingPage convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      eLandingPage[] arrayOfeLandingPage = __values;
      if (i >= arrayOfeLandingPage.length) {
        break;
      }
      if (arrayOfeLandingPage[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static eLandingPage convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      eLandingPage[] arrayOfeLandingPage = __values;
      if (i >= arrayOfeLandingPage.length) {
        break;
      }
      if (arrayOfeLandingPage[i].toString().equals(paramString)) {
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
 * Qualified Name:     UserGrowth.eLandingPage
 * JD-Core Version:    0.7.0.1
 */