package com.tenpay.android.wechat;

import com.tenpay.ndk.Encrypt;

public final class TenpaySecureEncrypt
  implements ISecureEncrypt
{
  public final String desedeEncode(String paramString1, String paramString2)
  {
    return new Encrypt().desedeEncode(paramString1);
  }
  
  public final String desedeVerifyCode(String paramString1, String paramString2)
  {
    return new Encrypt().desedeVerifyCode(paramString1);
  }
  
  public final String encryptPasswd(boolean paramBoolean, String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramBoolean) {
      str = TenpayUtil.md5HexDigest(paramString1);
    }
    paramString1 = new Encrypt();
    if (paramString2 != null) {
      paramString1.setTimeStamp(paramString2);
    }
    return paramString1.encryptPasswd(str);
  }
  
  public final String encryptPasswdWithRSA2048(boolean paramBoolean, String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramBoolean) {
      str = TenpayUtil.md5HexDigest(paramString1);
    }
    paramString1 = new Encrypt();
    if (paramString2 != null) {
      paramString1.setTimeStamp(paramString2);
    }
    return paramString1.encryptPasswdWithRSA2048(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tenpay.android.wechat.TenpaySecureEncrypt
 * JD-Core Version:    0.7.0.1
 */