package com.tenpay.android.wechat;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import com.tenpay.ndk.Encrypt;
import java.lang.reflect.Field;
import java.security.MessageDigest;

public class TenpayUtil
{
  public static final int getResourceDeclareStyleableIndex(Context paramContext, String paramString)
  {
    AppMethodBeat.i(73260);
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
          i = localObject.getInt(null);
          AppMethodBeat.o(73260);
          return i;
        }
        i += 1;
      }
      return 0;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(73260);
    }
  }
  
  public static final int[] getResourceDeclareStyleableIntArray(Context paramContext, String paramString)
  {
    AppMethodBeat.i(73259);
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
          AppMethodBeat.o(73259);
          return paramContext;
        }
        i += 1;
      }
      AppMethodBeat.o(73259);
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(73259);
      return null;
    }
    return null;
  }
  
  public static boolean invalidateID(String paramString)
  {
    AppMethodBeat.i(73261);
    if (paramString == null)
    {
      AppMethodBeat.o(73261);
      return false;
    }
    if (paramString.length() != 18)
    {
      AppMethodBeat.o(73261);
      return false;
    }
    int i = 0;
    int j = 0;
    try
    {
      while (i < paramString.length() - 1)
      {
        int k = bt.aGh(paramString.substring(i, i + 1));
        int m = new int[] { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 }[i];
        j += k * m;
        i += 1;
      }
      i = j % 11;
    }
    catch (NumberFormatException paramString)
    {
      AppMethodBeat.o(73261);
      return false;
    }
    j = paramString.charAt(17);
    if (i == 2)
    {
      if ((j != 88) && (j != 120))
      {
        AppMethodBeat.o(73261);
        return false;
      }
    }
    else if (j != new char[] { 49, 48, 88, 57, 56, 55, 54, 53, 52, 51, 50 }[i])
    {
      AppMethodBeat.o(73261);
      return false;
    }
    AppMethodBeat.o(73261);
    return true;
  }
  
  public static String md5HexDigest(String paramString)
  {
    AppMethodBeat.i(73258);
    char[] arrayOfChar = new char[16];
    char[] tmp13_11 = arrayOfChar;
    tmp13_11[0] = 48;
    char[] tmp18_13 = tmp13_11;
    tmp18_13[1] = 49;
    char[] tmp23_18 = tmp18_13;
    tmp23_18[2] = 50;
    char[] tmp28_23 = tmp23_18;
    tmp28_23[3] = 51;
    char[] tmp33_28 = tmp28_23;
    tmp33_28[4] = 52;
    char[] tmp38_33 = tmp33_28;
    tmp38_33[5] = 53;
    char[] tmp43_38 = tmp38_33;
    tmp43_38[6] = 54;
    char[] tmp49_43 = tmp43_38;
    tmp49_43[7] = 55;
    char[] tmp55_49 = tmp49_43;
    tmp55_49[8] = 56;
    char[] tmp61_55 = tmp55_49;
    tmp61_55[9] = 57;
    char[] tmp67_61 = tmp61_55;
    tmp67_61[10] = 65;
    char[] tmp73_67 = tmp67_61;
    tmp73_67[11] = 66;
    char[] tmp79_73 = tmp73_67;
    tmp79_73[12] = 67;
    char[] tmp85_79 = tmp79_73;
    tmp85_79[13] = 68;
    char[] tmp91_85 = tmp85_79;
    tmp91_85[14] = 69;
    char[] tmp97_91 = tmp91_85;
    tmp97_91[15] = 70;
    tmp97_91;
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
        paramString = null;
        continue;
      }
      paramString = new String((char[])localObject);
      AppMethodBeat.o(73258);
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
    AppMethodBeat.i(73257);
    if (paramString == null)
    {
      AppMethodBeat.o(73257);
      return null;
    }
    paramString = md5HexDigest(paramString);
    paramString = new Encrypt().desedeEncode(paramString);
    AppMethodBeat.o(73257);
    return paramString;
  }
  
  public static byte[] sm4DecryptCBC(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    AppMethodBeat.i(73256);
    if (paramArrayOfByte1 == null)
    {
      AppMethodBeat.o(73256);
      return null;
    }
    paramArrayOfByte1 = new Encrypt().sm4BCDDecryptCBC(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
    AppMethodBeat.o(73256);
    return paramArrayOfByte1;
  }
  
  public static byte[] sm4EncryptCBC(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    AppMethodBeat.i(73255);
    if (paramArrayOfByte1 == null)
    {
      AppMethodBeat.o(73255);
      return null;
    }
    paramArrayOfByte1 = new Encrypt().sm4BCDEncryptCBC(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
    AppMethodBeat.o(73255);
    return paramArrayOfByte1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tenpay.android.wechat.TenpayUtil
 * JD-Core Version:    0.7.0.1
 */