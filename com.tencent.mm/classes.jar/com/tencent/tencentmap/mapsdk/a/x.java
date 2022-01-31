package com.tencent.tencentmap.mapsdk.a;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

public class x
{
  static final byte[] a = { -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  
  public static String a(File paramFile)
  {
    paramFile = new FileInputStream(paramFile);
    byte[] arrayOfByte = new byte[1024];
    char[] arrayOfChar = new char[16];
    char[] tmp24_22 = arrayOfChar;
    tmp24_22[0] = 48;
    char[] tmp29_24 = tmp24_22;
    tmp29_24[1] = 49;
    char[] tmp34_29 = tmp29_24;
    tmp34_29[2] = 50;
    char[] tmp39_34 = tmp34_29;
    tmp39_34[3] = 51;
    char[] tmp44_39 = tmp39_34;
    tmp44_39[4] = 52;
    char[] tmp49_44 = tmp44_39;
    tmp49_44[5] = 53;
    char[] tmp54_49 = tmp49_44;
    tmp54_49[6] = 54;
    char[] tmp60_54 = tmp54_49;
    tmp60_54[7] = 55;
    char[] tmp66_60 = tmp60_54;
    tmp66_60[8] = 56;
    char[] tmp72_66 = tmp66_60;
    tmp72_66[9] = 57;
    char[] tmp78_72 = tmp72_66;
    tmp78_72[10] = 97;
    char[] tmp84_78 = tmp78_72;
    tmp84_78[11] = 98;
    char[] tmp90_84 = tmp84_78;
    tmp90_84[12] = 99;
    char[] tmp96_90 = tmp90_84;
    tmp96_90[13] = 100;
    char[] tmp102_96 = tmp96_90;
    tmp102_96[14] = 101;
    char[] tmp108_102 = tmp102_96;
    tmp108_102[15] = 102;
    tmp108_102;
    Object localObject2;
    int i;
    int j;
    try
    {
      localObject2 = MessageDigest.getInstance("MD5");
      for (;;)
      {
        i = paramFile.read(arrayOfByte, 0, 1024);
        if (i == -1) {
          break;
        }
        ((MessageDigest)localObject2).update(arrayOfByte, 0, i);
      }
      String str;
      while (i >= 16) {}
    }
    catch (Exception localException)
    {
      rh.b(Log.getStackTraceString(localException));
      return null;
      arrayOfByte = ((MessageDigest)localObject2).digest();
      localObject2 = new char[32];
      i = 0;
      j = 0;
      break label213;
      str = new String((char[])localObject2);
      return str;
    }
    finally
    {
      k.a(paramFile);
    }
    for (;;)
    {
      label213:
      int m = arrayOfByte[i];
      int k = j + 1;
      localObject2[j] = localObject1[(m >>> 4 & 0xF)];
      localObject2[k] = localObject1[(m & 0xF)];
      i += 1;
      j = k + 1;
    }
  }
  
  public static String a(byte[] paramArrayOfByte)
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
    tmp62_56[10] = 97;
    char[] tmp68_62 = tmp62_56;
    tmp68_62[11] = 98;
    char[] tmp74_68 = tmp68_62;
    tmp74_68[12] = 99;
    char[] tmp80_74 = tmp74_68;
    tmp80_74[13] = 100;
    char[] tmp86_80 = tmp80_74;
    tmp86_80[14] = 101;
    char[] tmp92_86 = tmp86_80;
    tmp92_86[15] = 102;
    tmp92_86;
    for (;;)
    {
      Object localObject;
      int i;
      int j;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramArrayOfByte);
        paramArrayOfByte = ((MessageDigest)localObject).digest();
        localObject = new char[32];
        i = 0;
        j = 0;
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
      paramArrayOfByte = new String((char[])localObject);
      return paramArrayOfByte;
      while (i < 16)
      {
        int m = paramArrayOfByte[i];
        int k = j + 1;
        localObject[j] = arrayOfChar[(m >>> 4 & 0xF)];
        localObject[k] = arrayOfChar[(m & 0xF)];
        i += 1;
        j = k + 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.x
 * JD-Core Version:    0.7.0.1
 */