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
  public static int COe = 65535;
  public static int COf = 128;
  public static int COg = 0;
  public static int COh = 1;
  public static int COi = 2;
  public static int COj = 3;
  public static int COk = 4;
  public static int COl = 5;
  public static int COm = 6;
  public static int COn = 7;
  public static int COo = 8;
  public static int COp = 9;
  public static int COq = 10;
  public static int COr = 11;
  public static int COs = 12;
  public static int COt = 13;
  public static int COu = 14;
  public static int COv = 1;
  public static b COw = null;
  public static boolean COx = false;
  public static int COy = 5;
  
  public static void LOGD(String paramString)
  {
    AppMethodBeat.i(96544);
    try
    {
      if (COv >= 2)
      {
        if (COw != null)
        {
          COw.w(2, paramString);
          AppMethodBeat.o(96544);
          return;
        }
        if (COx)
        {
          new StringBuilder("wlogin_sdk").append(ero());
          AppMethodBeat.o(96544);
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(96544);
    }
  }
  
  public static void N(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[(paramInt1 + 0)] = ((byte)(paramInt2 >> 0));
  }
  
  public static void O(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(paramInt2 >> 0));
    paramArrayOfByte[(paramInt1 + 0)] = ((byte)(paramInt2 >> 8));
  }
  
  public static void P(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[(paramInt1 + 3)] = ((byte)(paramInt2 >> 0));
    paramArrayOfByte[(paramInt1 + 2)] = ((byte)(paramInt2 >> 8));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(paramInt2 >> 16));
    paramArrayOfByte[(paramInt1 + 0)] = ((byte)(paramInt2 >> 24));
  }
  
  public static Key RSAPrivKeyFromJNI(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(96551);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(96551);
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
      AppMethodBeat.o(96551);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      j(paramArrayOfByte);
      AppMethodBeat.o(96551);
    }
    return null;
  }
  
  public static Key RSAPubKeyFromJNI(byte[] paramArrayOfByte)
  {
    int j = 1;
    AppMethodBeat.i(96550);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(96550);
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
        AppMethodBeat.o(96550);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        j(paramArrayOfByte);
        AppMethodBeat.o(96550);
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
    AppMethodBeat.i(96535);
    byte[] arrayOfByte = ki(paramContext);
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("ksid", cS(paramArrayOfByte));
      paramContext.commit();
    }
    AppMethodBeat.o(96535);
  }
  
  public static void aI(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(96532);
    paramContext = paramContext.getSharedPreferences("WLOGIN_SERVER_INFO", 0).edit();
    paramContext.putInt("network_type", paramInt);
    paramContext.commit();
    AppMethodBeat.o(96532);
  }
  
  public static int ad(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt] & 0xFF;
  }
  
  public static int ae(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[paramInt] << 8 & 0xFF00) + (paramArrayOfByte[(paramInt + 1)] << 0 & 0xFF);
  }
  
  public static int af(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[paramInt] << 24 & 0xFF000000) + (paramArrayOfByte[(paramInt + 1)] << 16 & 0xFF0000) + (paramArrayOfByte[(paramInt + 2)] << 8 & 0xFF00) + (paramArrayOfByte[(paramInt + 3)] << 0 & 0xFF);
  }
  
  private static byte[] azB(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(96525);
    if (paramString == null)
    {
      AppMethodBeat.o(96525);
      return new byte[0];
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    for (;;)
    {
      if (i >= paramString.length() / 2)
      {
        AppMethodBeat.o(96525);
        return arrayOfByte;
      }
      arrayOfByte[i] = ((byte)((e((byte)paramString.charAt(i * 2)) << 4) + e((byte)paramString.charAt(i * 2 + 1))));
      i += 1;
    }
  }
  
  public static void azC(String paramString)
  {
    AppMethodBeat.i(96543);
    try
    {
      if (COv > 0)
      {
        if (COw != null)
        {
          COw.w(1, paramString);
          AppMethodBeat.o(96543);
          return;
        }
        if (COx)
        {
          new StringBuilder("wlogin_sdk").append(ero());
          AppMethodBeat.o(96543);
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(96543);
    }
  }
  
  public static void b(Context paramContext, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(96537);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("imei", cS(paramArrayOfByte));
      paramContext.commit();
    }
    AppMethodBeat.o(96537);
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
  
  public static byte[] cR(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(96522);
    byte[] arrayOfByte1 = SecureRandom.getSeed(16);
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramArrayOfByte.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, arrayOfByte1.length, paramArrayOfByte.length);
    paramArrayOfByte = c.cQ(arrayOfByte2);
    AppMethodBeat.o(96522);
    return paramArrayOfByte;
  }
  
  public static String cS(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(96524);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(96524);
      return "";
    }
    String str = "";
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte.length)
      {
        AppMethodBeat.o(96524);
        return str;
      }
      str = new StringBuilder(String.valueOf(str)).append(Integer.toHexString(paramArrayOfByte[i] >> 4 & 0xF)).toString() + Integer.toHexString(paramArrayOfByte[i] & 0xF);
      i += 1;
    }
  }
  
  public static long cT(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return 0L;
    }
    return paramArrayOfByte.length;
  }
  
  public static byte[] ck(Context paramContext, String paramString)
  {
    AppMethodBeat.i(96540);
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0).versionName.getBytes();
      AppMethodBeat.o(96540);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(96540);
    }
    return new byte[0];
  }
  
  public static byte[] cl(Context paramContext, String paramString)
  {
    AppMethodBeat.i(96541);
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
        AppMethodBeat.o(96541);
        return null;
      }
      paramContext = c.cQ(paramContext.signatures[0].toByteArray());
      AppMethodBeat.o(96541);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(96541);
    }
    return new byte[0];
  }
  
  public static void d(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)(paramLong >> 0));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 8));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 16));
    paramArrayOfByte[(paramInt + 0)] = ((byte)(int)(paramLong >> 24));
  }
  
  private static byte e(byte paramByte)
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
  
  public static byte[] erj()
  {
    AppMethodBeat.i(96518);
    byte[] arrayOfByte = new String("android").getBytes();
    AppMethodBeat.o(96518);
    return arrayOfByte;
  }
  
  public static byte[] erk()
  {
    AppMethodBeat.i(96519);
    byte[] arrayOfByte = Build.VERSION.RELEASE.getBytes();
    AppMethodBeat.o(96519);
    return arrayOfByte;
  }
  
  public static int erl()
  {
    AppMethodBeat.i(96520);
    int i = (int)(Math.random() * 2147483647.0D);
    AppMethodBeat.o(96520);
    return i;
  }
  
  public static byte[] erm()
  {
    AppMethodBeat.i(96521);
    byte[] arrayOfByte = SecureRandom.getSeed(16);
    AppMethodBeat.o(96521);
    return arrayOfByte;
  }
  
  public static long ern()
  {
    AppMethodBeat.i(96523);
    long l = i.erc();
    AppMethodBeat.o(96523);
    return l;
  }
  
  private static String ero()
  {
    AppMethodBeat.i(96542);
    try
    {
      Object localObject = new Throwable().getStackTrace()[2];
      localObject = "[" + ((StackTraceElement)localObject).getFileName() + ":" + ((StackTraceElement)localObject).getLineNumber() + "]";
      AppMethodBeat.o(96542);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(96542);
    }
    return "";
  }
  
  public static String erp()
  {
    AppMethodBeat.i(96549);
    String str = new String("2014/02/28 14:20");
    AppMethodBeat.o(96549);
    return str;
  }
  
  public static boolean isFileExist(String paramString)
  {
    AppMethodBeat.i(96548);
    try
    {
      boolean bool = new File(paramString).exists();
      AppMethodBeat.o(96548);
      return bool;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(96548);
    }
    return false;
  }
  
  public static void j(Exception paramException)
  {
    AppMethodBeat.i(96547);
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter, true);
    paramException.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    localStringWriter.flush();
    jD("exception:", localStringWriter.toString());
    AppMethodBeat.o(96547);
  }
  
  public static void jC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96545);
    try
    {
      if (COv >= 2)
      {
        if (COw != null)
        {
          COw.OnLog(2, paramString1, paramString2);
          AppMethodBeat.o(96545);
          return;
        }
        if (COx)
        {
          new StringBuilder("wlogin_sdk").append(ero());
          new StringBuilder(String.valueOf(paramString1)).append(":").append(paramString2);
          AppMethodBeat.o(96545);
          return;
        }
      }
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(96545);
    }
  }
  
  public static void jD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96546);
    try
    {
      if (COv >= 0)
      {
        if (COw != null)
        {
          COw.OnLog(0, paramString1, paramString2);
          AppMethodBeat.o(96546);
          return;
        }
        if (COx)
        {
          new StringBuilder("wlogin_sdk").append(ero());
          new StringBuilder(String.valueOf(paramString1)).append(":").append(paramString2);
          AppMethodBeat.o(96546);
          return;
        }
      }
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(96546);
    }
  }
  
  public static byte[] ka(Context paramContext)
  {
    AppMethodBeat.i(96526);
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    if (paramContext != null)
    {
      paramContext = paramContext.getConnectionInfo();
      if (paramContext != null)
      {
        paramContext = paramContext.getMacAddress();
        if (paramContext != null)
        {
          paramContext = paramContext.getBytes();
          AppMethodBeat.o(96526);
          return paramContext;
        }
      }
    }
    AppMethodBeat.o(96526);
    return new byte[0];
  }
  
  public static byte[] kb(Context paramContext)
  {
    AppMethodBeat.i(96527);
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext != null)
    {
      paramContext = paramContext.getDeviceId();
      if (paramContext != null)
      {
        paramContext = paramContext.getBytes();
        AppMethodBeat.o(96527);
        return paramContext;
      }
    }
    AppMethodBeat.o(96527);
    return new byte[0];
  }
  
  public static byte[] kc(Context paramContext)
  {
    Object localObject3 = null;
    AppMethodBeat.i(96528);
    Object localObject1 = (TelephonyManager)paramContext.getSystemService("phone");
    if (localObject1 != null) {}
    for (localObject1 = ((TelephonyManager)localObject1).getDeviceId();; localObject1 = null)
    {
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      Object localObject2 = localObject3;
      if (paramContext != null)
      {
        paramContext = paramContext.getConnectionInfo();
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
        AppMethodBeat.o(96528);
        return new byte[0];
      }
      paramContext = c.cQ(((String)localObject1).getBytes());
      AppMethodBeat.o(96528);
      return paramContext;
    }
  }
  
  public static byte[] kd(Context paramContext)
  {
    AppMethodBeat.i(96529);
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext.getSimState() == 5)
      {
        paramContext = paramContext.getSimOperatorName().getBytes();
        AppMethodBeat.o(96529);
        return paramContext;
      }
      AppMethodBeat.o(96529);
      return new byte[0];
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(96529);
    }
    return new byte[0];
  }
  
  public static int ke(Context paramContext)
  {
    AppMethodBeat.i(96530);
    try
    {
      i = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo().getType();
      if (i == 0)
      {
        AppMethodBeat.o(96530);
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
        AppMethodBeat.o(96530);
        return 2;
      }
      AppMethodBeat.o(96530);
    }
    return 0;
  }
  
  public static int kf(Context paramContext)
  {
    AppMethodBeat.i(96531);
    int i = paramContext.getSharedPreferences("WLOGIN_SERVER_INFO", 0).getInt("network_type", 0);
    AppMethodBeat.o(96531);
    return i;
  }
  
  public static void kg(Context paramContext)
  {
    AppMethodBeat.i(96533);
    paramContext = paramContext.getSharedPreferences("WLOGIN_NET_RETRY_TYPE", 0).edit();
    paramContext.putInt("type", 0);
    paramContext.commit();
    AppMethodBeat.o(96533);
  }
  
  public static String kh(Context paramContext)
  {
    AppMethodBeat.i(96534);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext.getType() == 0)
      {
        paramContext = paramContext.getExtraInfo();
        if (paramContext != null)
        {
          AppMethodBeat.o(96534);
          return paramContext;
        }
      }
      else
      {
        AppMethodBeat.o(96534);
        return "wifi";
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(96534);
    }
    return "wifi";
  }
  
  public static byte[] ki(Context paramContext)
  {
    AppMethodBeat.i(96536);
    byte[] arrayOfByte = new String("").getBytes();
    try
    {
      paramContext = azB(paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("ksid", new String("")));
      if ((paramContext == null) || (paramContext.length <= 0))
      {
        LOGD("get_ksid:null");
        AppMethodBeat.o(96536);
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
        jD("exception", localStringWriter.toString());
        paramContext = arrayOfByte;
        continue;
        LOGD("get_ksid:" + cS(paramContext));
      }
    }
  }
  
  public static byte[] kj(Context paramContext)
  {
    AppMethodBeat.i(96538);
    byte[] arrayOfByte = new byte[0];
    try
    {
      paramContext = azB(paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("imei", new String("")));
      if (paramContext.length <= 0)
      {
        paramContext = new byte[0];
        AppMethodBeat.o(96538);
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
        jD("exception", localStringWriter.toString());
        paramContext = arrayOfByte;
        continue;
        LOGD("get_imei:" + cS(paramContext));
      }
    }
  }
  
  public static byte[] kk(Context paramContext)
  {
    AppMethodBeat.i(96539);
    paramContext = paramContext.getPackageName().getBytes();
    AppMethodBeat.o(96539);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.util
 * JD-Core Version:    0.7.0.1
 */