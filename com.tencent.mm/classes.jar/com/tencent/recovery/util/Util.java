package com.tencent.recovery.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Process;
import android.provider.Settings.Secure;
import com.tencent.recovery.Recovery;
import com.tencent.recovery.log.RecoveryLog;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class Util
{
  private static String processName = "";
  
  private static String az(Context paramContext, int paramInt)
  {
    if (Process.myUid() >= 99000) {
      return "ISOLATE_PROCESS";
    }
    if (!isNullOrNil(processName)) {
      return processName;
    }
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = Recovery.getContext();
    }
    if ((localObject == null) || (paramInt <= 0)) {
      return processName;
    }
    try
    {
      paramContext = ((ActivityManager)((Context)localObject).getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if ((((ActivityManager.RunningAppProcessInfo)localObject).pid == paramInt) && (((ActivityManager.RunningAppProcessInfo)localObject).processName != null) && (!((ActivityManager.RunningAppProcessInfo)localObject).processName.equals(""))) {
          processName = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
        }
      }
      return processName;
    }
    catch (Exception paramContext)
    {
      RecoveryLog.printErrStackTrace("Recovery.Util", paramContext, "", new Object[0]);
    }
  }
  
  public static final int iT(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("recovery-info", 0);
    int j = localSharedPreferences.getInt("KeySafeModeUUID", -1);
    int i = j;
    StringBuffer localStringBuffer;
    if (j == -1)
    {
      localStringBuffer = new StringBuffer();
      localStringBuffer.append(Settings.Secure.getString(paramContext.getContentResolver(), "android_id"));
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext != null) {
        break label202;
      }
      paramContext = null;
      if (paramContext == null) {
        break label215;
      }
    }
    label202:
    label210:
    label215:
    for (Object localObject = paramContext.getMacAddress();; localObject = null)
    {
      paramContext = (Context)localObject;
      if (localObject == null)
      {
        paramContext = BluetoothAdapter.getDefaultAdapter();
        if (paramContext == null) {
          break label210;
        }
      }
      for (paramContext = paramContext.getAddress();; paramContext = null)
      {
        localObject = paramContext;
        if (paramContext == null) {
          localObject = UUID.randomUUID().toString();
        }
        localStringBuffer.append((String)localObject);
        localStringBuffer.append(Build.MANUFACTURER + Build.MODEL);
        i = ("A" + w(localStringBuffer.toString().getBytes()).substring(0, 15)).hashCode();
        localSharedPreferences.edit().putInt("KeySafeModeUUID", i).commit();
        return i;
        paramContext = paramContext.getConnectionInfo();
        break;
      }
    }
  }
  
  public static String iU(Context paramContext)
  {
    return az(paramContext, Process.myPid());
  }
  
  public static final boolean isNullOrNil(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static String oW(long paramLong)
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(paramLong));
  }
  
  private static final String w(byte[] paramArrayOfByte)
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
      int k;
      int i;
      int j;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramArrayOfByte);
        paramArrayOfByte = ((MessageDigest)localObject).digest();
        k = paramArrayOfByte.length;
        localObject = new char[k * 2];
        i = 0;
        j = 0;
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
      paramArrayOfByte = new String((char[])localObject);
      return paramArrayOfByte;
      while (i < k)
      {
        int n = paramArrayOfByte[i];
        int m = j + 1;
        localObject[j] = arrayOfChar[(n >>> 4 & 0xF)];
        localObject[m] = arrayOfChar[(n & 0xF)];
        i += 1;
        j = m + 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.util.Util
 * JD-Core Version:    0.7.0.1
 */