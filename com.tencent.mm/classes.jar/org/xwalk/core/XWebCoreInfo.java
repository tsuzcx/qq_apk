package org.xwalk.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.h;

public class XWebCoreInfo
{
  private static final String TAG = "XWebCoreInfo";
  public String strAbi;
  public int ver;
  public String verDetail;
  
  public static XWebCoreInfo getBackupCoreInfo(String paramString)
  {
    AppMethodBeat.i(157335);
    XWebCoreInfo localXWebCoreInfo = new XWebCoreInfo();
    localXWebCoreInfo.strAbi = paramString;
    SharedPreferences localSharedPreferences = XWalkEnvironment.getSharedPreferencesForVersionInfo();
    localXWebCoreInfo.ver = localSharedPreferences.getInt(getBackupKey(paramString, "version"), -1);
    localXWebCoreInfo.verDetail = localSharedPreferences.getString(getBackupKey(paramString, "versionDetail"), "");
    AppMethodBeat.o(157335);
    return localXWebCoreInfo;
  }
  
  private static String getBackupKey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157339);
    paramString1 = "back_core_" + paramString2 + "_for_" + paramString1;
    AppMethodBeat.o(157339);
    return paramString1;
  }
  
  public static int getCurAbiInstalledNewestVersion(Context paramContext)
  {
    AppMethodBeat.i(157338);
    if (paramContext == null)
    {
      AppMethodBeat.o(157338);
      return -5;
    }
    if (XWalkEnvironment.getApplicationContext() == null) {
      XWalkEnvironment.init(paramContext);
    }
    int i = XWalkEnvironment.getSharedPreferencesForVersionInfo().getInt(getBackupKey(XWalkEnvironment.getRuntimeAbi(), "version"), -1);
    AppMethodBeat.o(157338);
    return i;
  }
  
  private static boolean isValidAbi(String paramString)
  {
    AppMethodBeat.i(157340);
    if (!TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(157340);
      return true;
    }
    AppMethodBeat.o(157340);
    return false;
  }
  
  public static boolean setVersionForAbi(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(157336);
    SharedPreferences.Editor localEditor = XWalkEnvironment.getSharedPreferencesForVersionInfo().edit();
    localEditor.putInt(getBackupKey(paramString2, "version"), paramInt);
    localEditor.putString(getBackupKey(paramString2, "versionDetail"), paramString1);
    boolean bool = localEditor.commit();
    if ((bool) && (paramInt > 0) && (!XWalkEnvironment.getRuntimeAbi().equalsIgnoreCase(paramString2)))
    {
      if (!"armeabi-v7a".equalsIgnoreCase(paramString2)) {
        break label136;
      }
      h.u(577L, 238L, 1L);
    }
    for (;;)
    {
      XWalkEnvironment.addXWalkInitializeLog("XWebCoreInfo", "set xwalk version to " + paramInt + " suc = " + bool + " abi = " + paramString2);
      AppMethodBeat.o(157336);
      return bool;
      label136:
      if ("arm64-v8a".equalsIgnoreCase(paramString2)) {
        h.u(577L, 239L, 1L);
      }
    }
  }
  
  public static boolean setVersionForAbi(XWebCoreInfo paramXWebCoreInfo)
  {
    AppMethodBeat.i(157337);
    if (paramXWebCoreInfo == null)
    {
      Log.e("XWebCoreInfo", "setVersionForAbi info is null");
      AppMethodBeat.o(157337);
      return false;
    }
    boolean bool = setVersionForAbi(paramXWebCoreInfo.ver, paramXWebCoreInfo.verDetail, paramXWebCoreInfo.strAbi);
    AppMethodBeat.o(157337);
    return bool;
  }
  
  public boolean isValid()
  {
    return this.ver > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.XWebCoreInfo
 * JD-Core Version:    0.7.0.1
 */