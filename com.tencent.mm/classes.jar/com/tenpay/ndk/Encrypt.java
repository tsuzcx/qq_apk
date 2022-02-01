package com.tenpay.ndk;

import android.text.TextUtils;
import android.util.Base64;
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
  
  private native boolean encryptPasswdWithRSA(byte paramByte, byte[] paramArrayOfByte, int paramInt);
  
  private native boolean encryptVerifyCode(byte[] paramArrayOfByte);
  
  private native byte[] encryptWithRSA(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt);
  
  private native byte[] getRandom();
  
  private static byte[] hexToBytes(String paramString)
  {
    AppMethodBeat.i(208507);
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() % 2 != 0))
    {
      AppMethodBeat.o(208507);
      return null;
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (i < paramString.length())
    {
      arrayOfByte[(i / 2)] = ((byte)((Character.digit(paramString.charAt(i), 16) << 4) + Character.digit(paramString.charAt(i + 1), 16)));
      i += 2;
    }
    AppMethodBeat.o(208507);
    return arrayOfByte;
  }
  
  public String desedeDecode(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73320);
    if ((paramString1 != null) && (paramString2 != null) && (paramString1.length() > 0)) {
      try
      {
        this.raw_buf = paramString1.getBytes("UTF-8");
        this.key_buf = paramString2.getBytes("UTF-8");
        decrypt(this.key_buf, this.raw_buf);
        if (this.dec_buf == null)
        {
          AppMethodBeat.o(73320);
          return null;
        }
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(73320);
        return null;
      }
    }
    for (;;)
    {
      try
      {
        paramString1 = new String(this.dec_buf, "UTF-8");
        AppMethodBeat.o(73320);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(73320);
        return null;
      }
      paramString1 = null;
    }
  }
  
  public String desedeEncode(String paramString)
  {
    AppMethodBeat.i(73317);
    if ((paramString != null) && (paramString.length() > 0)) {
      try
      {
        this.raw_buf = paramString.getBytes("UTF-8");
        encrypt(null, this.raw_buf);
        if (this.enc_buf == null)
        {
          AppMethodBeat.o(73317);
          return null;
        }
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(73317);
        return null;
      }
    }
    for (;;)
    {
      try
      {
        paramString = new String(this.enc_buf, "UTF-8");
        AppMethodBeat.o(73317);
        return paramString;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(73317);
        return null;
      }
      paramString = null;
    }
  }
  
  public String desedeEncode(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73319);
    if ((paramString1 != null) && (paramString2 != null) && (paramString1.length() > 0)) {
      try
      {
        this.raw_buf = paramString1.getBytes("UTF-8");
        this.key_buf = paramString2.getBytes("UTF-8");
        encrypt(this.key_buf, this.raw_buf);
        if (this.enc_buf == null)
        {
          AppMethodBeat.o(73319);
          return null;
        }
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(73319);
        return null;
      }
    }
    for (;;)
    {
      try
      {
        paramString1 = new String(this.enc_buf, "UTF-8");
        AppMethodBeat.o(73319);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(73319);
        return null;
      }
      paramString1 = null;
    }
  }
  
  public String desedeVerifyCode(String paramString)
  {
    AppMethodBeat.i(73318);
    if ((paramString != null) && (paramString.length() > 0)) {
      try
      {
        this.raw_buf = paramString.getBytes("UTF-8");
        encryptVerifyCode(this.raw_buf);
        if (this.enc_buf == null)
        {
          AppMethodBeat.o(73318);
          return null;
        }
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(73318);
        return null;
      }
    }
    for (;;)
    {
      try
      {
        paramString = new String(this.enc_buf, "UTF-8");
        AppMethodBeat.o(73318);
        return paramString;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(73318);
        return null;
      }
      paramString = null;
    }
  }
  
  public String encryptPasswd(String paramString)
  {
    AppMethodBeat.i(73323);
    if ((paramString != null) && (paramString.length() > 0)) {
      try
      {
        this.raw_passwd = paramString.getBytes("UTF-8");
        encryptPasswdWithRSA((byte)2, this.raw_passwd, 0);
        if (this.enc_passwd == null)
        {
          AppMethodBeat.o(73323);
          return null;
        }
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(73323);
        return null;
      }
    }
    for (;;)
    {
      try
      {
        paramString = new String(this.enc_passwd, "UTF-8");
        AppMethodBeat.o(73323);
        return paramString;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(73323);
        return null;
      }
      paramString = null;
    }
  }
  
  public String encryptPasswdWithRSA2048(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(73322);
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
            if (!encryptPasswdWithRSA((byte)2, this.raw_passwd, 1))
            {
              AppMethodBeat.o(73322);
              return null;
            }
          }
          catch (Exception paramString)
          {
            AppMethodBeat.o(73322);
            return null;
          }
        }
        if (this.enc_passwd == null)
        {
          AppMethodBeat.o(73322);
          return null;
        }
      }
    }
    try
    {
      localObject1 = "V01_" + new String(this.enc_passwd, "UTF-8");
      AppMethodBeat.o(73322);
      return localObject1;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(73322);
    }
    return null;
  }
  
  public String encryptWithRSA1024(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(208530);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(208530);
      return null;
    }
    paramString2 = hexToBytes(paramString2);
    paramString3 = hexToBytes(paramString3);
    paramString1 = encryptWithRSA(paramString1.getBytes(), paramString2, paramString3, 0);
    if (paramString1 == null)
    {
      AppMethodBeat.o(208530);
      return null;
    }
    paramString1 = Base64.encodeToString(paramString1, 0);
    AppMethodBeat.o(208530);
    return paramString1;
  }
  
  public String encryptWithRSA2048(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(208528);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(208528);
      return null;
    }
    paramString2 = hexToBytes(paramString2);
    paramString3 = hexToBytes(paramString3);
    paramString1 = encryptWithRSA(paramString1.getBytes(), paramString2, paramString3, 1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(208528);
      return null;
    }
    paramString1 = Base64.encodeToString(paramString1, 0);
    AppMethodBeat.o(208528);
    return paramString1;
  }
  
  public String getPasswdTimeStamp()
  {
    AppMethodBeat.i(73321);
    int i = this.time_stamp;
    AppMethodBeat.o(73321);
    return String.valueOf(i);
  }
  
  public String getRandomKey()
  {
    AppMethodBeat.i(73324);
    Object localObject1 = getRandom();
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        localObject1 = new String((byte[])localObject1, "UTF-8");
        AppMethodBeat.o(73324);
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
  
  public native byte[] sm4DecryptCBC(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3);
  
  public native byte[] sm4EncryptCBC(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tenpay.ndk.Encrypt
 * JD-Core Version:    0.7.0.1
 */