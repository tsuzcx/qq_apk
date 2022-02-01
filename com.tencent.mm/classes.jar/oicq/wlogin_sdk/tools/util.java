package oicq.wlogin_sdk.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.Key;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import oicq.wlogin_sdk.request.i;

public class util
{
  public static int ajIA = 6;
  public static int ajIB = 7;
  public static int ajIC = 8;
  public static int ajID = 9;
  public static int ajIE = 10;
  public static int ajIF = 11;
  public static int ajIG = 12;
  public static int ajIH = 13;
  public static int ajII = 14;
  public static int ajIJ = 1;
  public static b ajIK = null;
  public static boolean ajIL = false;
  public static int ajIM = 5;
  public static int ajIs = 65535;
  public static int ajIt = 128;
  public static int ajIu = 0;
  public static int ajIv = 1;
  public static int ajIw = 2;
  public static int ajIx = 3;
  public static int ajIy = 4;
  public static int ajIz = 5;
  
  public static void LOGD(String paramString)
  {
    AppMethodBeat.i(88183);
    try
    {
      if (ajIJ >= 2)
      {
        if (ajIK != null)
        {
          ajIK.Q(2, paramString);
          AppMethodBeat.o(88183);
          return;
        }
        if (ajIL)
        {
          new StringBuilder("wlogin_sdk").append(kGu());
          AppMethodBeat.o(88183);
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(88183);
    }
  }
  
  public static Key RSAPrivKeyFromJNI(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88190);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(88190);
      return null;
    }
    byte[] arrayOfByte1 = new byte[26];
    arrayOfByte1[0] = 48;
    arrayOfByte1[1] = -126;
    arrayOfByte1[2] = 2;
    arrayOfByte1[3] = 117;
    arrayOfByte1[4] = 2;
    arrayOfByte1[5] = 1;
    arrayOfByte1[7] = 48;
    arrayOfByte1[8] = 13;
    arrayOfByte1[9] = 6;
    arrayOfByte1[10] = 9;
    arrayOfByte1[11] = 42;
    arrayOfByte1[12] = -122;
    arrayOfByte1[13] = 72;
    arrayOfByte1[14] = -122;
    arrayOfByte1[15] = -9;
    arrayOfByte1[16] = 13;
    arrayOfByte1[17] = 1;
    arrayOfByte1[18] = 1;
    arrayOfByte1[19] = 1;
    arrayOfByte1[20] = 5;
    arrayOfByte1[22] = 4;
    arrayOfByte1[23] = -126;
    arrayOfByte1[24] = 2;
    arrayOfByte1[25] = 95;
    int i = paramArrayOfByte.length - 607;
    arrayOfByte1[3] = ((byte)(arrayOfByte1[3] + i));
    arrayOfByte1[25] = ((byte)(i + arrayOfByte1[25]));
    byte[] arrayOfByte2 = new byte[paramArrayOfByte.length + 26];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, 26);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, 26, paramArrayOfByte.length);
    try
    {
      paramArrayOfByte = new PKCS8EncodedKeySpec(arrayOfByte2);
      paramArrayOfByte = KeyFactory.getInstance("RSA").generatePrivate(paramArrayOfByte);
      AppMethodBeat.o(88190);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      p(paramArrayOfByte);
      AppMethodBeat.o(88190);
    }
    return null;
  }
  
  public static Key RSAPubKeyFromJNI(byte[] paramArrayOfByte)
  {
    int j = 1;
    AppMethodBeat.i(88189);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(88189);
      return null;
    }
    byte[] arrayOfByte2 = new byte[22];
    arrayOfByte2[0] = 48;
    arrayOfByte2[1] = -127;
    arrayOfByte2[2] = -97;
    arrayOfByte2[3] = 48;
    arrayOfByte2[4] = 13;
    arrayOfByte2[5] = 6;
    arrayOfByte2[6] = 9;
    arrayOfByte2[7] = 42;
    arrayOfByte2[8] = -122;
    arrayOfByte2[9] = 72;
    arrayOfByte2[10] = -122;
    arrayOfByte2[11] = -9;
    arrayOfByte2[12] = 13;
    arrayOfByte2[13] = 1;
    arrayOfByte2[14] = 1;
    arrayOfByte2[15] = 1;
    arrayOfByte2[16] = 5;
    arrayOfByte2[18] = 3;
    arrayOfByte2[19] = -127;
    arrayOfByte2[20] = -115;
    byte[] arrayOfByte1 = new byte[paramArrayOfByte.length + 22];
    int i = j;
    if (paramArrayOfByte.length >= 22)
    {
      i = 0;
      if (i >= 22) {
        i = j;
      }
    }
    else
    {
      label180:
      if (i == 0) {
        break label232;
      }
    }
    for (;;)
    {
      paramArrayOfByte = new X509EncodedKeySpec(paramArrayOfByte);
      try
      {
        paramArrayOfByte = KeyFactory.getInstance("RSA").generatePublic(paramArrayOfByte);
        AppMethodBeat.o(88189);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        p(paramArrayOfByte);
        AppMethodBeat.o(88189);
      }
      if (arrayOfByte2[i] != paramArrayOfByte[i])
      {
        i = 0;
        break label180;
      }
      i += 1;
      break;
      label232:
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, 22);
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 22, paramArrayOfByte.length);
      paramArrayOfByte = arrayOfByte1;
    }
    return null;
  }
  
  public static void a(Context paramContext, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88174);
    byte[] arrayOfByte = pv(paramContext);
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("ksid", dY(paramArrayOfByte));
      paramContext.commit();
    }
    AppMethodBeat.o(88174);
  }
  
  public static void af(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[(paramInt1 + 0)] = ((byte)(paramInt2 >> 0));
  }
  
  public static void ag(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(paramInt2 >> 0));
    paramArrayOfByte[(paramInt1 + 0)] = ((byte)(paramInt2 >> 8));
  }
  
  public static void ah(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[(paramInt1 + 3)] = ((byte)(paramInt2 >> 0));
    paramArrayOfByte[(paramInt1 + 2)] = ((byte)(paramInt2 >> 8));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(paramInt2 >> 16));
    paramArrayOfByte[(paramInt1 + 0)] = ((byte)(paramInt2 >> 24));
  }
  
  public static int ap(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt] & 0xFF;
  }
  
  public static int aq(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[paramInt] << 8 & 0xFF00) + (paramArrayOfByte[(paramInt + 1)] << 0 & 0xFF);
  }
  
  public static int ar(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[paramInt] << 24 & 0xFF000000) + (paramArrayOfByte[(paramInt + 1)] << 16 & 0xFF0000) + (paramArrayOfByte[(paramInt + 2)] << 8 & 0xFF00) + (paramArrayOfByte[(paramInt + 3)] << 0 & 0xFF);
  }
  
  public static void b(Context paramContext, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88176);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("imei", dY(paramArrayOfByte));
      paramContext.commit();
    }
    AppMethodBeat.o(88176);
  }
  
  private static byte[] bKe(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(88164);
    if (paramString == null)
    {
      AppMethodBeat.o(88164);
      return new byte[0];
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    for (;;)
    {
      if (i >= paramString.length() / 2)
      {
        AppMethodBeat.o(88164);
        return arrayOfByte;
      }
      arrayOfByte[i] = ((byte)((r((byte)paramString.charAt(i * 2)) << 4) + r((byte)paramString.charAt(i * 2 + 1))));
      i += 1;
    }
  }
  
  public static void bKf(String paramString)
  {
    AppMethodBeat.i(88182);
    try
    {
      if (ajIJ > 0)
      {
        if (ajIK != null)
        {
          ajIK.Q(1, paramString);
          AppMethodBeat.o(88182);
          return;
        }
        if (ajIL)
        {
          new StringBuilder("wlogin_sdk").append(kGu());
          AppMethodBeat.o(88182);
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(88182);
    }
  }
  
  public static void bL(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(88171);
    paramContext = paramContext.getSharedPreferences("WLOGIN_SERVER_INFO", 0).edit();
    paramContext.putInt("network_type", paramInt);
    paramContext.commit();
    AppMethodBeat.o(88171);
  }
  
  public static void c(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[(paramInt + 7)] = ((byte)(int)(paramLong >> 0));
    paramArrayOfByte[(paramInt + 6)] = ((byte)(int)(paramLong >> 8));
    paramArrayOfByte[(paramInt + 5)] = ((byte)(int)(paramLong >> 16));
    paramArrayOfByte[(paramInt + 4)] = ((byte)(int)(paramLong >> 24));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)(paramLong >> 32));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 40));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 48));
    paramArrayOfByte[(paramInt + 0)] = ((byte)(int)(paramLong >> 56));
  }
  
  public static void d(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)(paramLong >> 0));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 8));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 16));
    paramArrayOfByte[(paramInt + 0)] = ((byte)(int)(paramLong >> 24));
  }
  
  public static byte[] dX(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88161);
    byte[] arrayOfByte1 = SecureRandom.getSeed(16);
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramArrayOfByte.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, arrayOfByte1.length, paramArrayOfByte.length);
    paramArrayOfByte = c.dW(arrayOfByte2);
    AppMethodBeat.o(88161);
    return paramArrayOfByte;
  }
  
  public static String dY(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88163);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(88163);
      return "";
    }
    String str = "";
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte.length)
      {
        AppMethodBeat.o(88163);
        return str;
      }
      str = new StringBuilder(String.valueOf(str)).append(Integer.toHexString(paramArrayOfByte[i] >> 4 & 0xF)).toString() + Integer.toHexString(paramArrayOfByte[i] & 0xF);
      i += 1;
    }
  }
  
  public static long dZ(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return 0L;
    }
    return paramArrayOfByte.length;
  }
  
  public static byte[] dy(Context paramContext, String paramString)
  {
    AppMethodBeat.i(88179);
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0).versionName.getBytes();
      AppMethodBeat.o(88179);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(88179);
    }
    return new byte[0];
  }
  
  public static byte[] dz(Context paramContext, String paramString)
  {
    AppMethodBeat.i(88180);
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      if ((paramContext.signatures != null) && (paramContext.signatures.length > 0))
      {
        paramString = paramContext.signatures[0];
        if (paramString != null) {}
      }
      else
      {
        return null;
      }
      paramContext = c.dW(paramContext.signatures[0].toByteArray());
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(88180);
    }
    return new byte[0];
  }
  
  public static boolean isFileExist(String paramString)
  {
    AppMethodBeat.i(88187);
    try
    {
      boolean bool = new File(paramString).exists();
      AppMethodBeat.o(88187);
      return bool;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(88187);
    }
    return false;
  }
  
  public static byte[] kGp()
  {
    AppMethodBeat.i(88157);
    byte[] arrayOfByte = new String("android").getBytes();
    AppMethodBeat.o(88157);
    return arrayOfByte;
  }
  
  public static byte[] kGq()
  {
    AppMethodBeat.i(88158);
    byte[] arrayOfByte = Build.VERSION.RELEASE.getBytes();
    AppMethodBeat.o(88158);
    return arrayOfByte;
  }
  
  public static int kGr()
  {
    AppMethodBeat.i(88159);
    int i = (int)(Math.random() * 2147483647.0D);
    AppMethodBeat.o(88159);
    return i;
  }
  
  public static byte[] kGs()
  {
    AppMethodBeat.i(88160);
    byte[] arrayOfByte = SecureRandom.getSeed(16);
    AppMethodBeat.o(88160);
    return arrayOfByte;
  }
  
  public static long kGt()
  {
    AppMethodBeat.i(88162);
    long l = i.kGi();
    AppMethodBeat.o(88162);
    return l;
  }
  
  private static String kGu()
  {
    AppMethodBeat.i(88181);
    try
    {
      Object localObject = new java.lang.Throwable().getStackTrace()[2];
      localObject = "[" + ((StackTraceElement)localObject).getFileName() + ":" + ((StackTraceElement)localObject).getLineNumber() + "]";
      AppMethodBeat.o(88181);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(88181);
    }
    return "";
  }
  
  public static String kGv()
  {
    AppMethodBeat.i(88188);
    String str = new String("2014/02/28 14:20");
    AppMethodBeat.o(88188);
    return str;
  }
  
  public static void p(Exception paramException)
  {
    AppMethodBeat.i(88186);
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter, true);
    paramException.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    localStringWriter.flush();
    rz("exception:", localStringWriter.toString());
    AppMethodBeat.o(88186);
  }
  
  public static byte[] pn(Context paramContext)
  {
    AppMethodBeat.i(88165);
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    if (paramContext != null)
    {
      paramContext = (WifiInfo)a.a(paramContext, "oicq/wlogin_sdk/tools/util", "get_mac_addr", "(Landroid/content/Context;)[B", "android/net/wifi/WifiManager", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;");
      if (paramContext != null)
      {
        paramContext = paramContext.getMacAddress();
        if (paramContext != null)
        {
          paramContext = paramContext.getBytes();
          AppMethodBeat.o(88165);
          return paramContext;
        }
      }
    }
    AppMethodBeat.o(88165);
    return new byte[0];
  }
  
  public static byte[] po(Context paramContext)
  {
    AppMethodBeat.i(88166);
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext != null)
    {
      paramContext = (String)a.a(paramContext, "oicq/wlogin_sdk/tools/util", "get_imei_id", "(Landroid/content/Context;)[B", "android/telephony/TelephonyManager", "getDeviceId", "()Ljava/lang/String;");
      if (paramContext != null)
      {
        paramContext = paramContext.getBytes();
        AppMethodBeat.o(88166);
        return paramContext;
      }
    }
    AppMethodBeat.o(88166);
    return new byte[0];
  }
  
  public static byte[] pp(Context paramContext)
  {
    Object localObject3 = null;
    AppMethodBeat.i(88167);
    Object localObject1 = (TelephonyManager)paramContext.getSystemService("phone");
    if (localObject1 != null) {}
    for (localObject1 = (String)a.a(localObject1, "oicq/wlogin_sdk/tools/util", "get_IMEI", "(Landroid/content/Context;)[B", "android/telephony/TelephonyManager", "getDeviceId", "()Ljava/lang/String;");; localObject1 = null)
    {
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      Object localObject2 = localObject3;
      if (paramContext != null)
      {
        paramContext = (WifiInfo)a.a(paramContext, "oicq/wlogin_sdk/tools/util", "get_IMEI", "(Landroid/content/Context;)[B", "android/net/wifi/WifiManager", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;");
        localObject2 = localObject3;
        if (paramContext != null) {
          localObject2 = paramContext.getMacAddress();
        }
      }
      paramContext = "";
      if (localObject1 != null) {
        paramContext = "" + (String)localObject1;
      }
      localObject1 = paramContext;
      if (localObject2 != null) {
        localObject1 = paramContext + (String)localObject2;
      }
      if (((String)localObject1).length() <= 0)
      {
        AppMethodBeat.o(88167);
        return new byte[0];
      }
      paramContext = c.dW(((String)localObject1).getBytes());
      AppMethodBeat.o(88167);
      return paramContext;
    }
  }
  
  public static byte[] pq(Context paramContext)
  {
    AppMethodBeat.i(88168);
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext.getSimState() == 5)
      {
        paramContext = paramContext.getSimOperatorName().getBytes();
        return paramContext;
      }
      return new byte[0];
    }
    finally
    {
      AppMethodBeat.o(88168);
    }
    return new byte[0];
  }
  
  public static int pr(Context paramContext)
  {
    AppMethodBeat.i(88169);
    try
    {
      i = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo().getType();
      if (i == 0)
      {
        AppMethodBeat.o(88169);
        return 1;
      }
    }
    catch (Exception paramContext)
    {
      int i;
      for (;;)
      {
        i = 0;
      }
      if (i == 1)
      {
        AppMethodBeat.o(88169);
        return 2;
      }
      AppMethodBeat.o(88169);
    }
    return 0;
  }
  
  public static int ps(Context paramContext)
  {
    AppMethodBeat.i(88170);
    int i = paramContext.getSharedPreferences("WLOGIN_SERVER_INFO", 0).getInt("network_type", 0);
    AppMethodBeat.o(88170);
    return i;
  }
  
  public static void pt(Context paramContext)
  {
    AppMethodBeat.i(88172);
    paramContext = paramContext.getSharedPreferences("WLOGIN_NET_RETRY_TYPE", 0).edit();
    paramContext.putInt("type", 0);
    paramContext.commit();
    AppMethodBeat.o(88172);
  }
  
  public static String pu(Context paramContext)
  {
    AppMethodBeat.i(88173);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext.getType() == 0)
      {
        paramContext = paramContext.getExtraInfo();
        if (paramContext != null)
        {
          AppMethodBeat.o(88173);
          return paramContext;
        }
      }
      else
      {
        AppMethodBeat.o(88173);
        return "wifi";
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(88173);
    }
    return "wifi";
  }
  
  public static byte[] pv(Context paramContext)
  {
    AppMethodBeat.i(88175);
    byte[] arrayOfByte = new String("").getBytes();
    try
    {
      paramContext = bKe(paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("ksid", new String("")));
      if ((paramContext == null) || (paramContext.length <= 0))
      {
        LOGD("get_ksid:null");
        AppMethodBeat.o(88175);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        StringWriter localStringWriter = new StringWriter();
        PrintWriter localPrintWriter = new PrintWriter(localStringWriter, true);
        paramContext.printStackTrace(localPrintWriter);
        localPrintWriter.flush();
        localStringWriter.flush();
        rz("exception", localStringWriter.toString());
        paramContext = arrayOfByte;
        continue;
        LOGD("get_ksid:" + dY(paramContext));
      }
    }
  }
  
  public static byte[] pw(Context paramContext)
  {
    AppMethodBeat.i(88177);
    try
    {
      paramContext = bKe(paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("imei", new String("")));
      if ((paramContext == null) || (paramContext.length <= 0))
      {
        paramContext = new byte[0];
        AppMethodBeat.o(88177);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        StringWriter localStringWriter = new StringWriter();
        PrintWriter localPrintWriter = new PrintWriter(localStringWriter, true);
        paramContext.printStackTrace(localPrintWriter);
        localPrintWriter.flush();
        localStringWriter.flush();
        rz("exception", localStringWriter.toString());
        paramContext = new byte[0];
        continue;
        LOGD("get_imei:" + dY(paramContext));
      }
    }
  }
  
  public static byte[] px(Context paramContext)
  {
    AppMethodBeat.i(88178);
    paramContext = paramContext.getPackageName().getBytes();
    AppMethodBeat.o(88178);
    return paramContext;
  }
  
  private static byte r(byte paramByte)
  {
    if ((paramByte >= 48) && (paramByte <= 57)) {
      return (byte)(paramByte - 48);
    }
    if ((paramByte >= 97) && (paramByte <= 102)) {
      return (byte)(paramByte - 97 + 10);
    }
    if ((paramByte >= 65) && (paramByte <= 70)) {
      return (byte)(paramByte - 65 + 10);
    }
    return 0;
  }
  
  public static void ry(String paramString1, String paramString2)
  {
    AppMethodBeat.i(88184);
    try
    {
      if (ajIJ >= 2)
      {
        if (ajIK != null)
        {
          ajIK.OnLog(2, paramString1, paramString2);
          AppMethodBeat.o(88184);
          return;
        }
        if (ajIL)
        {
          new StringBuilder("wlogin_sdk").append(kGu());
          new StringBuilder(String.valueOf(paramString1)).append(":").append(paramString2);
          AppMethodBeat.o(88184);
          return;
        }
      }
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(88184);
    }
  }
  
  public static void rz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(88185);
    try
    {
      if (ajIJ >= 0)
      {
        if (ajIK != null)
        {
          ajIK.OnLog(0, paramString1, paramString2);
          AppMethodBeat.o(88185);
          return;
        }
        if (ajIL)
        {
          new StringBuilder("wlogin_sdk").append(kGu());
          new StringBuilder(String.valueOf(paramString1)).append(":").append(paramString2);
          AppMethodBeat.o(88185);
          return;
        }
      }
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(88185);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.util
 * JD-Core Version:    0.7.0.1
 */