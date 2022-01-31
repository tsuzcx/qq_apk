package FileUpload;

import java.io.Serializable;

public final class UPLOAD_LOGIN_TYPE
  implements Serializable
{
  public static final UPLOAD_LOGIN_TYPE LOGIN_TYPE_A2;
  public static final UPLOAD_LOGIN_TYPE LOGIN_TYPE_ENC_A2;
  public static final UPLOAD_LOGIN_TYPE LOGIN_TYPE_HA3;
  public static final UPLOAD_LOGIN_TYPE LOGIN_TYPE_MKEY;
  public static final UPLOAD_LOGIN_TYPE LOGIN_TYPE_OPENID;
  public static final UPLOAD_LOGIN_TYPE LOGIN_TYPE_PSKEY;
  public static final UPLOAD_LOGIN_TYPE LOGIN_TYPE_SID;
  public static final UPLOAD_LOGIN_TYPE LOGIN_TYPE_SKEY;
  public static final UPLOAD_LOGIN_TYPE LOGIN_TYPE_ST;
  public static final int _LOGIN_TYPE_A2 = 6;
  public static final int _LOGIN_TYPE_ENC_A2 = 1;
  public static final int _LOGIN_TYPE_HA3 = 0;
  public static final int _LOGIN_TYPE_MKEY = 4;
  public static final int _LOGIN_TYPE_OPENID = 5;
  public static final int _LOGIN_TYPE_PSKEY = 8;
  public static final int _LOGIN_TYPE_SID = 7;
  public static final int _LOGIN_TYPE_SKEY = 3;
  public static final int _LOGIN_TYPE_ST = 2;
  private static UPLOAD_LOGIN_TYPE[] __values;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!UPLOAD_LOGIN_TYPE.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      __values = new UPLOAD_LOGIN_TYPE[9];
      LOGIN_TYPE_HA3 = new UPLOAD_LOGIN_TYPE(0, 0, "LOGIN_TYPE_HA3");
      LOGIN_TYPE_ENC_A2 = new UPLOAD_LOGIN_TYPE(1, 1, "LOGIN_TYPE_ENC_A2");
      LOGIN_TYPE_ST = new UPLOAD_LOGIN_TYPE(2, 2, "LOGIN_TYPE_ST");
      LOGIN_TYPE_SKEY = new UPLOAD_LOGIN_TYPE(3, 3, "LOGIN_TYPE_SKEY");
      LOGIN_TYPE_MKEY = new UPLOAD_LOGIN_TYPE(4, 4, "LOGIN_TYPE_MKEY");
      LOGIN_TYPE_OPENID = new UPLOAD_LOGIN_TYPE(5, 5, "LOGIN_TYPE_OPENID");
      LOGIN_TYPE_A2 = new UPLOAD_LOGIN_TYPE(6, 6, "LOGIN_TYPE_A2");
      LOGIN_TYPE_SID = new UPLOAD_LOGIN_TYPE(7, 7, "LOGIN_TYPE_SID");
      LOGIN_TYPE_PSKEY = new UPLOAD_LOGIN_TYPE(8, 8, "LOGIN_TYPE_PSKEY");
      return;
    }
  }
  
  private UPLOAD_LOGIN_TYPE(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static UPLOAD_LOGIN_TYPE convert(int paramInt)
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
  
  public static UPLOAD_LOGIN_TYPE convert(String paramString)
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
 * Qualified Name:     FileUpload.UPLOAD_LOGIN_TYPE
 * JD-Core Version:    0.7.0.1
 */