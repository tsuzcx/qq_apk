package NS_MOBILE_OPERATION;

import java.io.Serializable;

public final class PicType
  implements Serializable
{
  public static final PicType ENUM_PIC_GIF;
  public static final PicType ENUM_PIC_JPG;
  public static final PicType ENUM_PIC_PNG;
  public static final int _ENUM_PIC_GIF = 2;
  public static final int _ENUM_PIC_JPG = 1;
  public static final int _ENUM_PIC_PNG = 3;
  private static PicType[] __values;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!PicType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      __values = new PicType[3];
      ENUM_PIC_JPG = new PicType(0, 1, "ENUM_PIC_JPG");
      ENUM_PIC_GIF = new PicType(1, 2, "ENUM_PIC_GIF");
      ENUM_PIC_PNG = new PicType(2, 3, "ENUM_PIC_PNG");
      return;
    }
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
  
  public static PicType convert(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     NS_MOBILE_OPERATION.PicType
 * JD-Core Version:    0.7.0.1
 */