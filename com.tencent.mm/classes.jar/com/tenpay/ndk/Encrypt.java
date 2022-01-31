package com.tenpay.ndk;

import java.io.UnsupportedEncodingException;

public class Encrypt
{
  private static final String CHARSET = "UTF-8";
  private byte[] dec_buf;
  private byte[] enc_buf;
  private byte[] enc_passwd;
  private byte[] key_buf;
  private byte[] raw_buf;
  private byte[] raw_passwd;
  private String server_time_stamp = "0";
  private int time_stamp;
  
  private native boolean decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  private native boolean encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  private native boolean encryptPasswd(byte paramByte, byte[] paramArrayOfByte);
  
  private native boolean encryptPasswdWithRSA2048(byte paramByte, byte[] paramArrayOfByte, int paramInt);
  
  private native boolean encryptVerifyCode(byte[] paramArrayOfByte);
  
  private native byte[] getRandom();
  
  public String desedeDecode(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null) && (paramString1.length() > 0)) {}
    for (;;)
    {
      try
      {
        this.raw_buf = paramString1.getBytes("UTF-8");
        this.key_buf = paramString2.getBytes("UTF-8");
        decrypt(this.key_buf, this.raw_buf);
        if (this.dec_buf == null) {
          return null;
        }
        try
        {
          paramString1 = new String(this.dec_buf, "UTF-8");
          return paramString1;
        }
        catch (Exception paramString1)
        {
          return null;
        }
        paramString1 = null;
      }
      catch (Exception paramString1)
      {
        return null;
      }
    }
  }
  
  public String desedeEncode(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (;;)
    {
      try
      {
        this.raw_buf = paramString.getBytes("UTF-8");
        encrypt(null, this.raw_buf);
        if (this.enc_buf == null) {
          return null;
        }
        try
        {
          paramString = new String(this.enc_buf, "UTF-8");
          return paramString;
        }
        catch (Exception paramString)
        {
          return null;
        }
        paramString = null;
      }
      catch (Exception paramString)
      {
        return null;
      }
    }
  }
  
  public String desedeEncode(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null) && (paramString1.length() > 0)) {}
    for (;;)
    {
      try
      {
        this.raw_buf = paramString1.getBytes("UTF-8");
        this.key_buf = paramString2.getBytes("UTF-8");
        encrypt(this.key_buf, this.raw_buf);
        if (this.enc_buf == null) {
          return null;
        }
        try
        {
          paramString1 = new String(this.enc_buf, "UTF-8");
          return paramString1;
        }
        catch (Exception paramString1)
        {
          return null;
        }
        paramString1 = null;
      }
      catch (Exception paramString1)
      {
        return null;
      }
    }
  }
  
  public String desedeVerifyCode(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (;;)
    {
      try
      {
        this.raw_buf = paramString.getBytes("UTF-8");
        encryptVerifyCode(this.raw_buf);
        if (this.enc_buf == null) {
          return null;
        }
        try
        {
          paramString = new String(this.enc_buf, "UTF-8");
          return paramString;
        }
        catch (Exception paramString)
        {
          return null;
        }
        paramString = null;
      }
      catch (Exception paramString)
      {
        return null;
      }
    }
  }
  
  public String encryptPasswd(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (;;)
    {
      try
      {
        this.raw_passwd = paramString.getBytes("UTF-8");
        encryptPasswd((byte)2, this.raw_passwd);
        if (this.enc_passwd == null) {
          return null;
        }
        try
        {
          int i = this.enc_passwd.length / 2;
          paramString = new byte[i];
          System.arraycopy(this.enc_passwd, i, paramString, 0, i);
          paramString = new String(paramString, "UTF-8");
          return paramString;
        }
        catch (Exception paramString)
        {
          return null;
        }
        paramString = null;
      }
      catch (Exception paramString)
      {
        return null;
      }
    }
  }
  
  public String encryptPasswdWithRSA2048(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      this.raw_passwd = null;
      this.enc_passwd = null;
      if (paramString.length() <= 0) {}
    }
    for (;;)
    {
      try
      {
        this.raw_passwd = paramString.getBytes("ASCII");
        if (!encryptPasswdWithRSA2048((byte)2, this.raw_passwd, 1)) {
          return null;
        }
        if (this.enc_passwd != null)
        {
          try
          {
            paramString = new String(this.enc_passwd, "ASCII");
            return paramString;
          }
          catch (Exception paramString)
          {
            return null;
          }
          paramString = null;
        }
      }
      catch (Exception paramString)
      {
        return null;
      }
    }
  }
  
  public String getPasswdTimeStamp()
  {
    return String.valueOf(this.time_stamp);
  }
  
  public String getRandomKey()
  {
    Object localObject = getRandom();
    if (localObject != null) {
      try
      {
        localObject = new String((byte[])localObject, "UTF-8");
        return localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    }
    return null;
  }
  
  public void setTimeStamp(String paramString)
  {
    this.server_time_stamp = paramString;
  }
  
  public native byte[] sm4BCDDecryptCBC(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3);
  
  public native byte[] sm4BCDEncryptCBC(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tenpay.ndk.Encrypt
 * JD-Core Version:    0.7.0.1
 */