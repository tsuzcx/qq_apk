package com.tenpay.android.wechat;

public abstract interface ISecureEncrypt
{
  public abstract String desedeEncode(String paramString1, String paramString2);
  
  public abstract String desedeVerifyCode(String paramString1, String paramString2);
  
  public abstract String encryptPasswd(boolean paramBoolean, String paramString1, String paramString2);
  
  public abstract String encryptPasswdWithRSA2048(boolean paramBoolean, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tenpay.android.wechat.ISecureEncrypt
 * JD-Core Version:    0.7.0.1
 */