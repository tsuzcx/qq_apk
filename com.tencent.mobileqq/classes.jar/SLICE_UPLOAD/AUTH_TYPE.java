package SLICE_UPLOAD;

import java.io.Serializable;

public final class AUTH_TYPE
  implements Serializable
{
  public static final AUTH_TYPE LOGIN_TYPE_A2;
  public static final AUTH_TYPE LOGIN_TYPE_BIZ;
  public static final AUTH_TYPE LOGIN_TYPE_ENC_A2;
  public static final AUTH_TYPE LOGIN_TYPE_OPENID;
  public static final AUTH_TYPE LOGIN_TYPE_OPENID_OTHER;
  public static final AUTH_TYPE LOGIN_TYPE_PSKEY;
  public static final AUTH_TYPE LOGIN_TYPE_SKEY;
  public static final AUTH_TYPE LOGIN_TYPE_THEMEALBUM_XCX_TICKET;
  public static final int _LOGIN_TYPE_A2 = 2;
  public static final int _LOGIN_TYPE_BIZ = 7;
  public static final int _LOGIN_TYPE_ENC_A2 = 1;
  public static final int _LOGIN_TYPE_OPENID = 5;
  public static final int _LOGIN_TYPE_OPENID_OTHER = 8;
  public static final int _LOGIN_TYPE_PSKEY = 4;
  public static final int _LOGIN_TYPE_SKEY = 3;
  public static final int _LOGIN_TYPE_THEMEALBUM_XCX_TICKET = 6;
  private static AUTH_TYPE[] __values;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!AUTH_TYPE.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      __values = new AUTH_TYPE[8];
      LOGIN_TYPE_ENC_A2 = new AUTH_TYPE(0, 1, "LOGIN_TYPE_ENC_A2");
      LOGIN_TYPE_A2 = new AUTH_TYPE(1, 2, "LOGIN_TYPE_A2");
      LOGIN_TYPE_SKEY = new AUTH_TYPE(2, 3, "LOGIN_TYPE_SKEY");
      LOGIN_TYPE_PSKEY = new AUTH_TYPE(3, 4, "LOGIN_TYPE_PSKEY");
      LOGIN_TYPE_OPENID = new AUTH_TYPE(4, 5, "LOGIN_TYPE_OPENID");
      LOGIN_TYPE_THEMEALBUM_XCX_TICKET = new AUTH_TYPE(5, 6, "LOGIN_TYPE_THEMEALBUM_XCX_TICKET");
      LOGIN_TYPE_BIZ = new AUTH_TYPE(6, 7, "LOGIN_TYPE_BIZ");
      LOGIN_TYPE_OPENID_OTHER = new AUTH_TYPE(7, 8, "LOGIN_TYPE_OPENID_OTHER");
      return;
    }
  }
  
  private AUTH_TYPE(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static AUTH_TYPE convert(int paramInt)
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
  
  public static AUTH_TYPE convert(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     SLICE_UPLOAD.AUTH_TYPE
 * JD-Core Version:    0.7.0.1
 */