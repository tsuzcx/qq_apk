package UserGrowth;

import java.io.Serializable;

public final class eLandingPage
  implements Serializable
{
  private static eLandingPage[] __values;
  public static final int _eLandingPageFallList = 0;
  public static final int _eLandingPageVideoPage = 1;
  public static final eLandingPage eLandingPageFallList;
  public static final eLandingPage eLandingPageVideoPage;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!eLandingPage.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      __values = new eLandingPage[2];
      eLandingPageFallList = new eLandingPage(0, 0, "eLandingPageFallList");
      eLandingPageVideoPage = new eLandingPage(1, 1, "eLandingPageVideoPage");
      return;
    }
  }
  
  private eLandingPage(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static eLandingPage convert(int paramInt)
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
  
  public static eLandingPage convert(String paramString)
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
 * Qualified Name:     UserGrowth.eLandingPage
 * JD-Core Version:    0.7.0.1
 */