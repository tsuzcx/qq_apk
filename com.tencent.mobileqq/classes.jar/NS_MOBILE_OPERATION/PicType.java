package NS_MOBILE_OPERATION;

import java.io.Serializable;

public final class PicType
  implements Serializable
{
  public static final PicType ENUM_PIC_GIF = new PicType(1, 2, "ENUM_PIC_GIF");
  public static final PicType ENUM_PIC_JPG;
  public static final PicType ENUM_PIC_PNG = new PicType(2, 3, "ENUM_PIC_PNG");
  public static final int _ENUM_PIC_GIF = 2;
  public static final int _ENUM_PIC_JPG = 1;
  public static final int _ENUM_PIC_PNG = 3;
  private static PicType[] __values = new PicType[3];
  private String __T = new String();
  private int __value;
  
  static
  {
    ENUM_PIC_JPG = new PicType(0, 1, "ENUM_PIC_JPG");
  }
  
  private PicType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static PicType convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      PicType[] arrayOfPicType = __values;
      if (i >= arrayOfPicType.length) {
        break;
      }
      if (arrayOfPicType[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static PicType convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      PicType[] arrayOfPicType = __values;
      if (i >= arrayOfPicType.length) {
        break;
      }
      if (arrayOfPicType[i].toString().equals(paramString)) {
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
 * Qualified Name:     NS_MOBILE_OPERATION.PicType
 * JD-Core Version:    0.7.0.1
 */