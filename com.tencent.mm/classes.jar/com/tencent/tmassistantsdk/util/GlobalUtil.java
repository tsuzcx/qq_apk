package com.tencent.tmassistantsdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class GlobalUtil
{
  static final int NET_TYPE_WIFI = 4;
  protected static final String SharedPreferencesName = "TMAssistantSDKSharedPreference";
  private static final String TAG = "GlobalUtil";
  protected static GlobalUtil mInstance = null;
  protected static int mMemUUID = 0;
  public final int JCE_CMDID_Empty = 0;
  public final int JCE_CMDID_GetAppSimpleDetail = 5;
  public final int JCE_CMDID_GetAppUpdate = 3;
  public final int JCE_CMDID_GetAuthorized = 4;
  public final int JCE_CMDID_GetSettings = 2;
  public final int JCE_CMDID_ReportLog = 1;
  protected Context mContext;
  public HashMap<Integer, String> mJCECmdIdMap = null;
  public String mQUA = "";
  
  protected GlobalUtil()
  {
    this.mJCECmdIdMap.put(Integer.valueOf(1), "ReportLog");
    this.mJCECmdIdMap.put(Integer.valueOf(2), "GetSettings");
    this.mJCECmdIdMap.put(Integer.valueOf(3), "GetAppUpdate");
    this.mJCECmdIdMap.put(Integer.valueOf(4), "GetAuthorized");
    this.mJCECmdIdMap.put(Integer.valueOf(5), "GetAppSimpleDetail");
  }
  
  public static ArrayList<String> String2List(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(",");
      int i = 0;
      while (i < paramString.length)
      {
        CharSequence localCharSequence = paramString[i];
        if (!TextUtils.isEmpty(localCharSequence)) {
          localArrayList.add(localCharSequence);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static int assistantErrorCode2SDKErrorCode(int paramInt)
  {
    switch (paramInt)
    {
    case -1000: 
    case -26: 
    case -24: 
    default: 
      return 604;
    case 0: 
      return 0;
    case -1: 
      return 709;
    case -11: 
      return 708;
    case -12: 
      return 730;
    case -13: 
      return 703;
    case -15: 
      return 1;
    case -16: 
      return 731;
    case -21: 
      return 700;
    case -22: 
      return 732;
    case -23: 
      return 601;
    case -25: 
      return 602;
    case -27: 
      return 606;
    }
    return 701;
  }
  
  public static int assistantState2SDKState(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 7: 
    case 8: 
    default: 
      return 0;
    case 1: 
      return 2;
    case 6: 
      return 1;
    case 2: 
      return 3;
    case 4: 
      return 4;
    case 3: 
      return 5;
    }
    return 6;
  }
  
  public static String calcMD5AsString(String paramString)
  {
    Object localObject = "";
    if (!TextUtils.isEmpty(paramString)) {
      paramString = paramString.getBytes();
    }
    try
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).reset();
      ((MessageDigest)localObject).update(paramString, 0, paramString.length);
      paramString = ((MessageDigest)localObject).digest();
      localObject = new StringBuffer();
      int i = 0;
      while (i < paramString.length)
      {
        ((StringBuffer)localObject).append(Integer.toHexString(paramString[i] & 0xFF));
        i += 1;
      }
      localObject = ((StringBuffer)localObject).toString();
      return localObject;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      y.printErrStackTrace("GlobalUtil", paramString, "", new Object[0]);
    }
    return "";
  }
  
  public static void deleteOldDB(String paramString)
  {
    if (getInstance().getContext() != null)
    {
      paramString = getInstance().getContext().getDatabasePath(paramString);
      if (paramString.exists() != true) {}
    }
    try
    {
      paramString.delete();
      TMLog.i("GlobalUtil", "deleteDB");
      return;
    }
    catch (Exception paramString)
    {
      TMLog.i("GlobalUtil", "deleteDB failed");
    }
  }
  
  public static String getAppPackageName(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getPackageName();
    }
    return "";
  }
  
  public static int getAppVersionCode(Context paramContext)
  {
    int i = 0;
    PackageManager localPackageManager;
    if (paramContext != null) {
      localPackageManager = paramContext.getPackageManager();
    }
    try
    {
      i = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      y.printErrStackTrace("GlobalUtil", paramContext, "", new Object[0]);
    }
    return 0;
  }
  
  public static GlobalUtil getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new GlobalUtil();
      }
      GlobalUtil localGlobalUtil = mInstance;
      return localGlobalUtil;
    }
    finally {}
  }
  
  public static int getMemUUID()
  {
    try
    {
      int i = mMemUUID;
      mMemUUID = i + 1;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean isDBExist(String paramString)
  {
    return (getInstance().getContext() != null) && (getInstance().getContext().getDatabasePath(paramString).exists());
  }
  
  public static void updateFilePathAuthorized(String paramString)
  {
    Object localObject = new File(paramString);
    String str2 = ((File)localObject).getParent();
    String str1 = new File(str2).getParent();
    paramString = new File(str1).getParent();
    try
    {
      localObject = "chmod 777 " + ((File)localObject).getAbsolutePath();
      Runtime.getRuntime().exec((String)localObject);
      str2 = "chmod 777 " + str2;
      Runtime.getRuntime().exec(str2);
      str1 = "chmod 777 " + str1;
      Runtime.getRuntime().exec(str1);
      paramString = "chmod 777" + paramString;
      Runtime.getRuntime().exec(paramString);
      return;
    }
    catch (IOException paramString)
    {
      y.printErrStackTrace("GlobalUtil", paramString, "", new Object[0]);
    }
  }
  
  public boolean canReportValue()
  {
    return false;
  }
  
  public void destroy()
  {
    this.mContext = null;
    mInstance = null;
  }
  
  public String getAndroidIdInPhone()
  {
    if (this.mContext == null) {
      return null;
    }
    return Settings.Secure.getString(getContext().getContentResolver(), "android_id");
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public String getImei()
  {
    if (this.mContext == null) {
      return null;
    }
    Object localObject = (TelephonyManager)getContext().getSystemService("phone");
    try
    {
      localObject = ((TelephonyManager)localObject).getDeviceId();
      return localObject;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("GlobalUtil", localException, "getImei:", new Object[0]);
    }
    return "";
  }
  
  public String getImsi()
  {
    if (this.mContext == null) {
      return null;
    }
    Object localObject = (TelephonyManager)getContext().getSystemService("phone");
    try
    {
      localObject = ((TelephonyManager)localObject).getSubscriberId();
      return localObject;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("GlobalUtil", localException, "getImsi:", new Object[0]);
    }
    return "";
  }
  
  public int getJceCmdIdByClassName(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    if (this.mJCECmdIdMap != null)
    {
      Iterator localIterator = this.mJCECmdIdMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        if (localObject != null)
        {
          Integer localInteger = (Integer)((Map.Entry)localObject).getKey();
          localObject = (String)((Map.Entry)localObject).getValue();
          if ((localObject != null) && (((String)localObject).equals(paramString))) {
            return localInteger.intValue();
          }
        }
      }
    }
    return 0;
  }
  
  public String getMacAddress()
  {
    if (this.mContext == null) {
      return null;
    }
    try
    {
      Object localObject = ((WifiManager)getContext().getSystemService("wifi")).getConnectionInfo();
      if (localObject != null)
      {
        localObject = ((WifiInfo)localObject).getMacAddress();
        return localObject;
      }
      return "";
    }
    catch (Exception localException) {}
    return "";
  }
  
  public String getNetworkOperator()
  {
    if (this.mContext == null) {
      return "";
    }
    return ((TelephonyManager)this.mContext.getSystemService("phone")).getNetworkOperator();
  }
  
  public int getNetworkType()
  {
    if (this.mContext == null) {
      return 0;
    }
    return ((TelephonyManager)this.mContext.getSystemService("phone")).getNetworkType();
  }
  
  public String getPhoneGuid()
  {
    if (this.mContext == null) {
      return "";
    }
    SharedPreferences localSharedPreferences = this.mContext.getSharedPreferences("TMAssistantSDKSharedPreference", 0);
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString("TMAssistantSDKPhoneGUID", "");
    }
    return "";
  }
  
  public int getQQDownloaderAPILevel()
  {
    if (this.mContext == null) {}
    for (;;)
    {
      return 0;
      try
      {
        ApplicationInfo localApplicationInfo = this.mContext.getPackageManager().getApplicationInfo("com.tencent.android.qqdownloader", 128);
        if ((localApplicationInfo != null) && (localApplicationInfo.metaData != null))
        {
          int i = localApplicationInfo.metaData.getInt("com.tencent.android.qqdownloader.sdk.apilevel");
          return i;
        }
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("GlobalUtil", localException, "", new Object[0]);
      }
    }
    return 0;
  }
  
  public int getQQDownloaderVersionCode()
  {
    if (this.mContext == null) {}
    for (;;)
    {
      return 0;
      Object localObject = this.mContext.getPackageManager();
      if (localObject != null) {
        try
        {
          localObject = ((PackageManager)localObject).getPackageInfo("com.tencent.android.qqdownloader", 0);
          if (localObject != null)
          {
            int i = ((PackageInfo)localObject).versionCode;
            return i;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          y.printErrStackTrace("GlobalUtil", localNameNotFoundException, "", new Object[0]);
        }
      }
    }
    return 0;
  }
  
  public void setContext(Context paramContext)
  {
    this.mContext = paramContext;
    this.mQUA = new QUASetting(paramContext).buildQUA();
  }
  
  public void setNetTypeValue(byte paramByte)
  {
    if (this.mContext == null) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      localSharedPreferences = this.mContext.getSharedPreferences("TMAssistantSDKSharedPreference", 0);
    } while ((localSharedPreferences == null) || (Byte.parseByte(localSharedPreferences.getString("TMAssistantSDKNetType", "0")) == paramByte));
    localSharedPreferences.edit().putString("TMAssistantSDKNetType", String.valueOf(paramByte)).commit();
  }
  
  public void setPhoneGuid(String paramString)
  {
    if (this.mContext == null) {}
    SharedPreferences localSharedPreferences;
    do
    {
      do
      {
        return;
      } while (paramString == null);
      localSharedPreferences = this.mContext.getSharedPreferences("TMAssistantSDKSharedPreference", 0);
    } while (localSharedPreferences == null);
    localSharedPreferences.edit().putString("TMAssistantSDKPhoneGUID", paramString).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmassistantsdk.util.GlobalUtil
 * JD-Core Version:    0.7.0.1
 */