package UserGrowth;

import java.io.Serializable;

public final class eDarenMedal
  implements Serializable
{
  private static eDarenMedal[] __values;
  public static final int _eDarenNothing = 0;
  public static final int _eDarenOrganization = 3;
  public static final int _eDarenPartyACertification = 5;
  public static final int _eDarenSenior = 2;
  public static final int _eDarenStar = 4;
  public static final int _eDarenTutor = 1;
  public static final int _eDarenWeseeAuthority = 6;
  public static final eDarenMedal eDarenNothing;
  public static final eDarenMedal eDarenOrganization;
  public static final eDarenMedal eDarenPartyACertification;
  public static final eDarenMedal eDarenSenior;
  public static final eDarenMedal eDarenStar;
  public static final eDarenMedal eDarenTutor;
  public static final eDarenMedal eDarenWeseeAuthority;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!eDarenMedal.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      __values = new eDarenMedal[7];
      eDarenNothing = new eDarenMedal(0, 0, "eDarenNothing");
      eDarenTutor = new eDarenMedal(1, 1, "eDarenTutor");
      eDarenSenior = new eDarenMedal(2, 2, "eDarenSenior");
      eDarenOrganization = new eDarenMedal(3, 3, "eDarenOrganization");
      eDarenStar = new eDarenMedal(4, 4, "eDarenStar");
      eDarenPartyACertification = new eDarenMedal(5, 5, "eDarenPartyACertification");
      eDarenWeseeAuthority = new eDarenMedal(6, 6, "eDarenWeseeAuthority");
      return;
    }
  }
  
  private eDarenMedal(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static eDarenMedal convert(int paramInt)
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
  
  public static eDarenMedal convert(String paramString)
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
 * Qualified Name:     UserGrowth.eDarenMedal
 * JD-Core Version:    0.7.0.1
 */