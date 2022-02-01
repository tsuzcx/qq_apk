package com.tencent.youtu.ytcommon.auth;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StatisticsUtils
{
  private static String encryptUid(String paramString)
  {
    AppMethodBeat.i(73349);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(73349);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      int k = paramString.charAt(i);
      localStringBuilder.append(k + k % j);
      i += 1;
    }
    localStringBuilder.reverse();
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(73349);
    return paramString;
  }
  
  private static char getChar(byte paramByte, int paramInt)
  {
    AppMethodBeat.i(73348);
    char c = (char)(paramByte - getOffset(paramInt & 0x1));
    AppMethodBeat.o(73348);
    return c;
  }
  
  public static String getDeviceUid(Context paramContext)
  {
    AppMethodBeat.i(73344);
    if (paramContext.getPackageName().startsWith("com.tencent"))
    {
      AppMethodBeat.o(73344);
      return "com.tencent";
    }
    String str = getIMEI(paramContext.getApplicationContext());
    Object localObject = getMacAddr(paramContext.getApplicationContext());
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      i = 1;
      paramContext = (Context)localObject;
      if (i != 0) {
        paramContext = ((String)localObject).replaceAll(":", "");
      }
      localObject = new StringBuilder().append(str);
      if (i == 0) {
        break label108;
      }
    }
    for (;;)
    {
      paramContext = toMD5(encryptUid(paramContext));
      AppMethodBeat.o(73344);
      return paramContext;
      i = 0;
      break;
      label108:
      paramContext = "";
    }
  }
  
  public static String getIMEI(Context paramContext)
  {
    AppMethodBeat.i(73346);
    String str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    if (TextUtils.isEmpty(str))
    {
      paramContext = (TelephonyManager)paramContext.getApplicationContext().getSystemService("phone");
      if (paramContext == null) {}
    }
    for (paramContext = paramContext.getDeviceId();; paramContext = str)
    {
      AppMethodBeat.o(73346);
      return paramContext;
    }
  }
  
  public static String getMacAddr(Context paramContext)
  {
    AppMethodBeat.i(73345);
    if (paramContext == null)
    {
      AppMethodBeat.o(73345);
      return null;
    }
    paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
    if (paramContext != null)
    {
      paramContext = paramContext.getConnectionInfo();
      if (paramContext == null) {}
    }
    for (paramContext = paramContext.getMacAddress();; paramContext = null)
    {
      AppMethodBeat.o(73345);
      return paramContext;
    }
  }
  
  private static byte getOffset(int paramInt)
  {
    if (paramInt == 0) {}
    for (paramInt = 65;; paramInt = 97) {
      return (byte)paramInt;
    }
  }
  
  public static String toMD5(String paramString)
  {
    AppMethodBeat.i(73347);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(73347);
      return "";
    }
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).reset();
      ((MessageDigest)localObject).update(paramString.getBytes());
      for (paramString = new BigInteger(1, ((MessageDigest)localObject).digest()).toString(16);; paramString = "0".concat(String.valueOf(paramString)))
      {
        localObject = paramString;
        if (paramString.length() >= 32) {
          break;
        }
      }
      return localObject;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      localObject = "";
      AppMethodBeat.o(73347);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.auth.StatisticsUtils
 * JD-Core Version:    0.7.0.1
 */