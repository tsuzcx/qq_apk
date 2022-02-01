package UserGrowth;

import java.io.Serializable;

public final class eDarenMedal
  implements Serializable
{
  private static eDarenMedal[] __values = new eDarenMedal[7];
  public static final int _eDarenNothing = 0;
  public static final int _eDarenOrganization = 3;
  public static final int _eDarenPartyACertification = 5;
  public static final int _eDarenSenior = 2;
  public static final int _eDarenStar = 4;
  public static final int _eDarenTutor = 1;
  public static final int _eDarenWeseeAuthority = 6;
  public static final eDarenMedal eDarenNothing = new eDarenMedal(0, 0, "eDarenNothing");
  public static final eDarenMedal eDarenOrganization;
  public static final eDarenMedal eDarenPartyACertification = new eDarenMedal(5, 5, "eDarenPartyACertification");
  public static final eDarenMedal eDarenSenior;
  public static final eDarenMedal eDarenStar;
  public static final eDarenMedal eDarenTutor = new eDarenMedal(1, 1, "eDarenTutor");
  public static final eDarenMedal eDarenWeseeAuthority = new eDarenMedal(6, 6, "eDarenWeseeAuthority");
  private String __T = new String();
  private int __value;
  
  static
  {
    eDarenSenior = new eDarenMedal(2, 2, "eDarenSenior");
    eDarenOrganization = new eDarenMedal(3, 3, "eDarenOrganization");
    eDarenStar = new eDarenMedal(4, 4, "eDarenStar");
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
    for (;;)
    {
      eDarenMedal[] arrayOfeDarenMedal = __values;
      if (i >= arrayOfeDarenMedal.length) {
        break;
      }
      if (arrayOfeDarenMedal[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static eDarenMedal convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      eDarenMedal[] arrayOfeDarenMedal = __values;
      if (i >= arrayOfeDarenMedal.length) {
        break;
      }
      if (arrayOfeDarenMedal[i].toString().equals(paramString)) {
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
 * Qualified Name:     UserGrowth.eDarenMedal
 * JD-Core Version:    0.7.0.1
 */