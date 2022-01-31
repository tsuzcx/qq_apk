package com.tenpay.ndk;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(49569);
    if ((paramString1 != null) && (paramString2 != null) && (paramString1.length() > 0)) {
      try
      {
        this.raw_buf = paramString1.getBytes("UTF-8");
        this.key_buf = paramString2.getBytes("UTF-8");
        decrypt(this.key_buf, this.raw_buf);
        if (this.dec_buf == null)
        {
          AppMethodBeat.o(49569);
          return null;
        }
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(49569);
        return null;
      }
    }
    for (;;)
    {
      try
      {
        paramString1 = new String(this.dec_buf, "UTF-8");
        AppMethodBeat.o(49569);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(49569);
        return null;
      }
      paramString1 = null;
    }
  }
  
  public String desedeEncode(String paramString)
  {
    AppMethodBeat.i(49566);
    if ((paramString != null) && (paramString.length() > 0)) {
      try
      {
        this.raw_buf = paramString.getBytes("UTF-8");
        encrypt(null, this.raw_buf);
        if (this.enc_buf == null)
        {
          AppMethodBeat.o(49566);
          return null;
        }
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(49566);
        return null;
      }
    }
    for (;;)
    {
      try
      {
        paramString = new String(this.enc_buf, "UTF-8");
        AppMethodBeat.o(49566);
        return paramString;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(49566);
        return null;
      }
      paramString = null;
    }
  }
  
  public String desedeEncode(String paramString1, String paramString2)
  {
    AppMethodBeat.i(49568);
    if ((paramString1 != null) && (paramString2 != null) && (paramString1.length() > 0)) {
      try
      {
        this.raw_buf = paramString1.getBytes("UTF-8");
        this.key_buf = paramString2.getBytes("UTF-8");
        encrypt(this.key_buf, this.raw_buf);
        if (this.enc_buf == null)
        {
          AppMethodBeat.o(49568);
          return null;
        }
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(49568);
        return null;
      }
    }
    for (;;)
    {
      try
      {
        paramString1 = new String(this.enc_buf, "UTF-8");
        AppMethodBeat.o(49568);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(49568);
        return null;
      }
      paramString1 = null;
    }
  }
  
  public String desedeVerifyCode(String paramString)
  {
    AppMethodBeat.i(49567);
    if ((paramString != null) && (paramString.length() > 0)) {
      try
      {
        this.raw_buf = paramString.getBytes("UTF-8");
        encryptVerifyCode(this.raw_buf);
        if (this.enc_buf == null)
        {
          AppMethodBeat.o(49567);
          return null;
        }
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(49567);
        return null;
      }
    }
    for (;;)
    {
      try
      {
        paramString = new String(this.enc_buf, "UTF-8");
        AppMethodBeat.o(49567);
        return paramString;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(49567);
        return null;
      }
      paramString = null;
    }
  }
  
  public String encryptPasswd(String paramString)
  {
    AppMethodBeat.i(49572);
    if ((paramString != null) && (paramString.length() > 0)) {
      try
      {
        this.raw_passwd = paramString.getBytes("UTF-8");
        encryptPasswd((byte)2, this.raw_passwd);
        if (this.enc_passwd == null)
        {
          AppMethodBeat.o(49572);
          return null;
        }
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(49572);
        return null;
      }
    }
    for (;;)
    {
      try
      {
        int i = this.enc_passwd.length / 2;
        paramString = new byte[i];
        System.arraycopy(this.enc_passwd, i, paramString, 0, i);
        paramString = new String(paramString, "UTF-8");
        AppMethodBeat.o(49572);
        return paramString;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(49572);
        return null;
      }
      paramString = null;
    }
  }
  
  public String encryptPasswdWithRSA2048(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(49571);
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (paramString.length() > 0)
      {
        this.raw_passwd = null;
        this.enc_passwd = null;
        if (paramString.length() > 0) {
          try
          {
            this.raw_passwd = paramString.getBytes("UTF-8");
            if (!encryptPasswdWithRSA2048((byte)2, this.raw_passwd, 1))
            {
              AppMethodBeat.o(49571);
              return null;
            }
          }
          catch (Exception paramString)
          {
            AppMethodBeat.o(49571);
            return null;
          }
        }
        if (this.enc_passwd == null)
        {
          AppMethodBeat.o(49571);
          return null;
        }
      }
    }
    try
    {
      localObject1 = "V01_" + new String(this.enc_passwd, "UTF-8");
      AppMethodBeat.o(49571);
      return localObject1;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(49571);
    }
    return null;
  }
  
  public String getPasswdTimeStamp()
  {
    AppMethodBeat.i(49570);
    int i = this.time_stamp;
    AppMethodBeat.o(49570);
    return String.valueOf(i);
  }
  
  public String getRandomKey()
  {
    AppMethodBeat.i(49573);
    Object localObject1 = getRandom();
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        localObject1 = new String((byte[])localObject1, "UTF-8");
        AppMethodBeat.o(49573);
        return localObject1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
      Object localObject2 = null;
    }
  }
  
  public void setTimeStamp(String paramString)
  {
    this.server_time_stamp = paramString;
  }
  
  public native byte[] sm4BCDDecryptCBC(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3);
  
  public native byte[] sm4BCDEncryptCBC(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tenpay.ndk.Encrypt
 * JD-Core Version:    0.7.0.1
 */