package com.tenpay.android.wechat;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.bk;
import com.tenpay.ndk.Encrypt;
import java.lang.reflect.Field;
import java.security.MessageDigest;

public class TenpayUtil
{
  public static final int getResourceDeclareStyleableIndex(Context paramContext, String paramString)
  {
    int k = 0;
    try
    {
      paramContext = Class.forName(paramContext.getPackageName() + ".R$styleable").getFields();
      int m = paramContext.length;
      int i = 0;
      for (;;)
      {
        int j = k;
        if (i < m)
        {
          Object localObject = paramContext[i];
          if (localObject.getName().equals(paramString)) {
            j = localObject.getInt(null);
          }
        }
        else
        {
          return j;
        }
        i += 1;
      }
      return 0;
    }
    catch (Throwable paramContext) {}
  }
  
  public static final int[] getResourceDeclareStyleableIntArray(Context paramContext, String paramString)
  {
    try
    {
      paramContext = Class.forName(paramContext.getPackageName() + ".R$styleable").getFields();
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramContext[i];
        if (localObject.getName().equals(paramString))
        {
          paramContext = (int[])localObject.get(null);
          return paramContext;
        }
        i += 1;
      }
      return null;
    }
    catch (Throwable paramContext)
    {
      return null;
    }
  }
  
  public static boolean invalidateID(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      if (paramString.length() == 18)
      {
        int i = 0;
        int j = 0;
        try
        {
          while (i < paramString.length() - 1)
          {
            int k = bk.ZR(paramString.substring(i, i + 1));
            int m = new int[] { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 }[i];
            j += k * m;
            i += 1;
          }
          i = j % 11;
          j = paramString.charAt(17);
          if (i == 2)
          {
            if ((j != 88) && (j != 120)) {}
          }
          else
          {
            while (j == new char[] { 49, 48, 88, 57, 56, 55, 54, 53, 52, 51, 50 }[i]) {
              return true;
            }
            return false;
          }
        }
        catch (NumberFormatException paramString) {}
      }
    }
    return false;
  }
  
  public static String md5HexDigest(String paramString)
  {
    char[] arrayOfChar = new char[16];
    char[] tmp8_6 = arrayOfChar;
    tmp8_6[0] = 48;
    char[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 49;
    char[] tmp18_13 = tmp13_8;
    tmp18_13[2] = 50;
    char[] tmp23_18 = tmp18_13;
    tmp23_18[3] = 51;
    char[] tmp28_23 = tmp23_18;
    tmp28_23[4] = 52;
    char[] tmp33_28 = tmp28_23;
    tmp33_28[5] = 53;
    char[] tmp38_33 = tmp33_28;
    tmp38_33[6] = 54;
    char[] tmp44_38 = tmp38_33;
    tmp44_38[7] = 55;
    char[] tmp50_44 = tmp44_38;
    tmp50_44[8] = 56;
    char[] tmp56_50 = tmp50_44;
    tmp56_50[9] = 57;
    char[] tmp62_56 = tmp56_50;
    tmp62_56[10] = 65;
    char[] tmp68_62 = tmp62_56;
    tmp68_62[11] = 66;
    char[] tmp74_68 = tmp68_62;
    tmp74_68[12] = 67;
    char[] tmp80_74 = tmp74_68;
    tmp80_74[13] = 68;
    char[] tmp86_80 = tmp80_74;
    tmp86_80[14] = 69;
    char[] tmp92_86 = tmp86_80;
    tmp92_86[15] = 70;
    tmp92_86;
    for (;;)
    {
      Object localObject;
      int i;
      int j;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramString.getBytes());
        paramString = ((MessageDigest)localObject).digest();
        localObject = new char[32];
        i = 0;
        j = 0;
      }
      catch (Exception paramString)
      {
        return null;
      }
      paramString = new String((char[])localObject);
      return paramString;
      while (i < 16)
      {
        int m = paramString[i];
        int k = j + 1;
        localObject[j] = arrayOfChar[(m >>> 4 & 0xF)];
        localObject[k] = arrayOfChar[(m & 0xF)];
        i += 1;
        j = k + 1;
      }
    }
  }
  
  public static String signWith3Des(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = md5HexDigest(paramString);
    return new Encrypt().desedeEncode(paramString);
  }
  
  public static byte[] sm4DecryptCBC(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if (paramArrayOfByte1 == null) {
      return null;
    }
    return new Encrypt().sm4BCDDecryptCBC(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
  }
  
  public static byte[] sm4EncryptCBC(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if (paramArrayOfByte1 == null) {
      return null;
    }
    return new Encrypt().sm4BCDEncryptCBC(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tenpay.android.wechat.TenpayUtil
 * JD-Core Version:    0.7.0.1
 */