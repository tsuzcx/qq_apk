package com.tencent.tmassistantsdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
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
  public final int JCE_CMDID_Empty;
  public final int JCE_CMDID_GetAppSimpleDetail;
  public final int JCE_CMDID_GetAppUpdate;
  public final int JCE_CMDID_GetAuthorized;
  public final int JCE_CMDID_GetSettings;
  public final int JCE_CMDID_ReportLog;
  protected Context mContext;
  public HashMap<Integer, String> mJCECmdIdMap;
  public String mQUA;
  
  protected GlobalUtil()
  {
    AppMethodBeat.i(76235);
    this.mQUA = "";
    this.JCE_CMDID_Empty = 0;
    this.JCE_CMDID_ReportLog = 1;
    this.JCE_CMDID_GetSettings = 2;
    this.JCE_CMDID_GetAppUpdate = 3;
    this.JCE_CMDID_GetAuthorized = 4;
    this.JCE_CMDID_GetAppSimpleDetail = 5;
    this.mJCECmdIdMap = null;
    this.mJCECmdIdMap = new HashMap();
    this.mJCECmdIdMap.put(Integer.valueOf(1), "ReportLog");
    this.mJCECmdIdMap.put(Integer.valueOf(2), "GetSettings");
    this.mJCECmdIdMap.put(Integer.valueOf(3), "GetAppUpdate");
    this.mJCECmdIdMap.put(Integer.valueOf(4), "GetAuthorized");
    this.mJCECmdIdMap.put(Integer.valueOf(5), "GetAppSimpleDetail");
    AppMethodBeat.o(76235);
  }
  
  public static ArrayList<String> String2List(String paramString)
  {
    AppMethodBeat.i(76250);
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
    AppMethodBeat.o(76250);
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
    AppMethodBeat.i(76249);
    str = "";
    localObject = str;
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
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("GlobalUtil", paramString, "", new Object[0]);
        localObject = str;
      }
    }
    AppMethodBeat.o(76249);
    return localObject;
  }
  
  public static void deleteOldDB(String paramString)
  {
    AppMethodBeat.i(76256);
    if (getInstance().getContext() != null)
    {
      paramString = getInstance().getContext().getDatabasePath(paramString);
      if (paramString.exists() == true) {
        try
        {
          paramString.delete();
          TMLog.i("GlobalUtil", "deleteDB");
          AppMethodBeat.o(76256);
          return;
        }
        catch (Exception paramString)
        {
          TMLog.i("GlobalUtil", "deleteDB failed");
        }
      }
    }
    AppMethodBeat.o(76256);
  }
  
  public static String getAppPackageName(Context paramContext)
  {
    AppMethodBeat.i(76241);
    if (paramContext != null)
    {
      paramContext = paramContext.getPackageName();
      AppMethodBeat.o(76241);
      return paramContext;
    }
    AppMethodBeat.o(76241);
    return "";
  }
  
  public static int getAppVersionCode(Context paramContext)
  {
    AppMethodBeat.i(76242);
    if (paramContext != null)
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      try
      {
        int i = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).versionCode;
        AppMethodBeat.o(76242);
        return i;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        ab.printErrStackTrace("GlobalUtil", paramContext, "", new Object[0]);
        AppMethodBeat.o(76242);
        return 0;
      }
    }
    AppMethodBeat.o(76242);
    return 0;
  }
  
  public static GlobalUtil getInstance()
  {
    try
    {
      AppMethodBeat.i(76236);
      if (mInstance == null) {
        mInstance = new GlobalUtil();
      }
      GlobalUtil localGlobalUtil = mInstance;
      AppMethodBeat.o(76236);
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
    AppMethodBeat.i(76255);
    if ((getInstance().getContext() != null) && (getInstance().getContext().getDatabasePath(paramString).exists()))
    {
      AppMethodBeat.o(76255);
      return true;
    }
    AppMethodBeat.o(76255);
    return false;
  }
  
  public static void updateFilePathAuthorized(String paramString)
  {
    AppMethodBeat.i(76254);
    Object localObject = new File(paramString);
    String str2 = ((File)localObject).getParent();
    String str1 = new File(str2).getParent();
    paramString = new File(str1).getParent();
    try
    {
      localObject = "chmod 777 " + ((File)localObject).getAbsolutePath();
      Runtime.getRuntime().exec((String)localObject);
      str2 = "chmod 777 ".concat(String.valueOf(str2));
      Runtime.getRuntime().exec(str2);
      str1 = "chmod 777 ".concat(String.valueOf(str1));
      Runtime.getRuntime().exec(str1);
      paramString = "chmod 777".concat(String.valueOf(paramString));
      Runtime.getRuntime().exec(paramString);
      AppMethodBeat.o(76254);
      return;
    }
    catch (IOException paramString)
    {
      ab.printErrStackTrace("GlobalUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(76254);
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
    AppMethodBeat.i(76243);
    if (this.mContext == null)
    {
      AppMethodBeat.o(76243);
      return null;
    }
    String str = Settings.Secure.getString(getContext().getContentResolver(), "android_id");
    AppMethodBeat.o(76243);
    return str;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public int getJceCmdIdByClassName(String paramString)
  {
    AppMethodBeat.i(76238);
    if (paramString == null)
    {
      AppMethodBeat.o(76238);
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
          if ((localObject != null) && (((String)localObject).equals(paramString)))
          {
            int i = localInteger.intValue();
            AppMethodBeat.o(76238);
            return i;
          }
        }
      }
    }
    AppMethodBeat.o(76238);
    return 0;
  }
  
  public String getNetworkOperator()
  {
    AppMethodBeat.i(76239);
    if (this.mContext == null)
    {
      AppMethodBeat.o(76239);
      return "";
    }
    String str = ((TelephonyManager)this.mContext.getSystemService("phone")).getNetworkOperator();
    AppMethodBeat.o(76239);
    return str;
  }
  
  public int getNetworkType()
  {
    AppMethodBeat.i(76240);
    if (this.mContext == null)
    {
      AppMethodBeat.o(76240);
      return 0;
    }
    int i = ((TelephonyManager)this.mContext.getSystemService("phone")).getNetworkType();
    AppMethodBeat.o(76240);
    return i;
  }
  
  public String getPhoneGuid()
  {
    AppMethodBeat.i(76244);
    if (this.mContext == null)
    {
      AppMethodBeat.o(76244);
      return "";
    }
    Object localObject = this.mContext.getSharedPreferences("TMAssistantSDKSharedPreference", 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).getString("TMAssistantSDKPhoneGUID", "");
      AppMethodBeat.o(76244);
      return localObject;
    }
    AppMethodBeat.o(76244);
    return "";
  }
  
  public int getQQDownloaderAPILevel()
  {
    AppMethodBeat.i(76252);
    if (this.mContext == null)
    {
      AppMethodBeat.o(76252);
      return 0;
    }
    try
    {
      ApplicationInfo localApplicationInfo = this.mContext.getPackageManager().getApplicationInfo("com.tencent.android.qqdownloader", 128);
      if ((localApplicationInfo != null) && (localApplicationInfo.metaData != null))
      {
        int i = localApplicationInfo.metaData.getInt("com.tencent.android.qqdownloader.sdk.apilevel");
        AppMethodBeat.o(76252);
        return i;
      }
      AppMethodBeat.o(76252);
      return 0;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("GlobalUtil", localException, "", new Object[0]);
      AppMethodBeat.o(76252);
    }
    return 0;
  }
  
  public int getQQDownloaderVersionCode()
  {
    AppMethodBeat.i(76253);
    if (this.mContext == null)
    {
      AppMethodBeat.o(76253);
      return 0;
    }
    Object localObject = this.mContext.getPackageManager();
    if (localObject != null) {
      try
      {
        localObject = ((PackageManager)localObject).getPackageInfo("com.tencent.android.qqdownloader", 0);
        if (localObject == null)
        {
          AppMethodBeat.o(76253);
          return 0;
        }
        int i = ((PackageInfo)localObject).versionCode;
        AppMethodBeat.o(76253);
        return i;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        ab.printErrStackTrace("GlobalUtil", localNameNotFoundException, "", new Object[0]);
        AppMethodBeat.o(76253);
        return 0;
      }
    }
    AppMethodBeat.o(76253);
    return 0;
  }
  
  public void setContext(Context paramContext)
  {
    AppMethodBeat.i(76237);
    this.mContext = paramContext;
    this.mQUA = new QUASetting(paramContext).buildQUA();
    AppMethodBeat.o(76237);
  }
  
  public void setNetTypeValue(byte paramByte)
  {
    AppMethodBeat.i(76251);
    if (this.mContext == null)
    {
      AppMethodBeat.o(76251);
      return;
    }
    SharedPreferences localSharedPreferences = this.mContext.getSharedPreferences("TMAssistantSDKSharedPreference", 0);
    if ((localSharedPreferences != null) && (Byte.parseByte(localSharedPreferences.getString("TMAssistantSDKNetType", "0")) != paramByte)) {
      localSharedPreferences.edit().putString("TMAssistantSDKNetType", String.valueOf(paramByte)).commit();
    }
    AppMethodBeat.o(76251);
  }
  
  public void setPhoneGuid(String paramString)
  {
    AppMethodBeat.i(76245);
    if (this.mContext == null)
    {
      AppMethodBeat.o(76245);
      return;
    }
    if (paramString != null)
    {
      SharedPreferences localSharedPreferences = this.mContext.getSharedPreferences("TMAssistantSDKSharedPreference", 0);
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putString("TMAssistantSDKPhoneGUID", paramString).commit();
      }
    }
    AppMethodBeat.o(76245);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmassistantsdk.util.GlobalUtil
 * JD-Core Version:    0.7.0.1
 */