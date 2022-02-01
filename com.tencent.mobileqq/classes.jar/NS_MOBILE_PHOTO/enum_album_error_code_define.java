package NS_MOBILE_PHOTO;

import java.io.Serializable;

public final class enum_album_error_code_define
  implements Serializable
{
  private static enum_album_error_code_define[] __values = new enum_album_error_code_define[1];
  public static final int _enum_album_not_exist = -11529;
  public static final enum_album_error_code_define enum_album_not_exist = new enum_album_error_code_define(0, -11529, "enum_album_not_exist");
  private String __T = new String();
  private int __value;
  
  private enum_album_error_code_define(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static enum_album_error_code_define convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      enum_album_error_code_define[] arrayOfenum_album_error_code_define = __values;
      if (i >= arrayOfenum_album_error_code_define.length) {
        break;
      }
      if (arrayOfenum_album_error_code_define[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static enum_album_error_code_define convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      enum_album_error_code_define[] arrayOfenum_album_error_code_define = __values;
      if (i >= arrayOfenum_album_error_code_define.length) {
        break;
      }
      if (arrayOfenum_album_error_code_define[i].toString().equals(paramString)) {
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
 * Qualified Name:     NS_MOBILE_PHOTO.enum_album_error_code_define
 * JD-Core Version:    0.7.0.1
 */