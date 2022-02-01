package NS_MOBILE_OPERATION;

import java.io.Serializable;

public final class e_albumtype
  implements Serializable
{
  public static final e_albumtype ENUM_ALBUM_TYPE_MOBILE;
  public static final e_albumtype ENUM_ALBUM_TYPE_SECRET_TIETU = new e_albumtype(2, 7, "ENUM_ALBUM_TYPE_SECRET_TIETU");
  public static final e_albumtype ENUM_ALBUM_TYPE_TIETU;
  public static final int _ENUM_ALBUM_TYPE_MOBILE = 1;
  public static final int _ENUM_ALBUM_TYPE_SECRET_TIETU = 7;
  public static final int _ENUM_ALBUM_TYPE_TIETU = 2;
  private static e_albumtype[] __values = new e_albumtype[3];
  private String __T = new String();
  private int __value;
  
  static
  {
    ENUM_ALBUM_TYPE_MOBILE = new e_albumtype(0, 1, "ENUM_ALBUM_TYPE_MOBILE");
    ENUM_ALBUM_TYPE_TIETU = new e_albumtype(1, 2, "ENUM_ALBUM_TYPE_TIETU");
  }
  
  private e_albumtype(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static e_albumtype convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      e_albumtype[] arrayOfe_albumtype = __values;
      if (i >= arrayOfe_albumtype.length) {
        break;
      }
      if (arrayOfe_albumtype[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static e_albumtype convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      e_albumtype[] arrayOfe_albumtype = __values;
      if (i >= arrayOfe_albumtype.length) {
        break;
      }
      if (arrayOfe_albumtype[i].toString().equals(paramString)) {
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
 * Qualified Name:     NS_MOBILE_OPERATION.e_albumtype
 * JD-Core Version:    0.7.0.1
 */