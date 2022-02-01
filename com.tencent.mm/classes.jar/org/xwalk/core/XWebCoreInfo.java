package org.xwalk.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.b;
import com.tencent.xweb.util.l;

public class XWebCoreInfo
{
  public static final int INVALID_VERSION = -1;
  private static final String STR_TAG_VERSION = "version";
  private static final String STR_TAG_VERSION_DETAIL = "versionDetail";
  private static final String TAG = "XWebCoreInfo";
  public String strAbi;
  public int ver;
  public String verDetail;
  
  public XWebCoreInfo() {}
  
  public XWebCoreInfo(int paramInt, String paramString1, String paramString2)
  {
    this.ver = paramInt;
    this.verDetail = paramString1;
    this.strAbi = paramString2;
  }
  
  private static String getBackupKey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157339);
    paramString1 = "back_core_" + paramString2 + "_for_" + paramString1;
    AppMethodBeat.o(157339);
    return paramString1;
  }
  
  public static int getInstalledNewestVersionForCurAbi(Context paramContext)
  {
    AppMethodBeat.i(187569);
    if (paramContext == null)
    {
      Log.w("XWebCoreInfo", "getInstalledNewestVersionForCurAbi, context is null, return -1");
      AppMethodBeat.o(187569);
      return -1;
    }
    if (XWalkEnvironment.getApplicationContext() == null) {
      XWalkEnvironment.init(paramContext);
    }
    int i = XWalkSharedPreferenceUtil.getSharedPreferencesForVersionInfo().getInt(getBackupKey(b.khw(), "version"), -1);
    AppMethodBeat.o(187569);
    return i;
  }
  
  public static XWebCoreInfo getVersionInfoForAbi(String paramString)
  {
    AppMethodBeat.i(187557);
    XWebCoreInfo localXWebCoreInfo = new XWebCoreInfo();
    SharedPreferences localSharedPreferences = XWalkSharedPreferenceUtil.getSharedPreferencesForVersionInfo();
    localXWebCoreInfo.strAbi = paramString;
    localXWebCoreInfo.ver = localSharedPreferences.getInt(getBackupKey(paramString, "version"), -1);
    localXWebCoreInfo.verDetail = localSharedPreferences.getString(getBackupKey(paramString, "versionDetail"), "");
    AppMethodBeat.o(187557);
    return localXWebCoreInfo;
  }
  
  public static boolean setVersionInfo(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(187560);
    SharedPreferences.Editor localEditor = XWalkSharedPreferenceUtil.getSharedPreferencesForVersionInfo().edit();
    localEditor.putInt(getBackupKey(paramString2, "version"), paramInt);
    localEditor.putString(getBackupKey(paramString2, "versionDetail"), paramString1);
    boolean bool = localEditor.commit();
    if ((bool) && (paramInt > 0) && (!b.khw().equalsIgnoreCase(paramString2)))
    {
      if (!"armeabi-v7a".equalsIgnoreCase(paramString2)) {
        break label136;
      }
      l.y(577L, 238L, 1L);
    }
    for (;;)
    {
      XWalkEnvironment.addXWalkInitializeLog("XWebCoreInfo", "setVersionInfo, version:" + paramInt + ", abi:" + paramString2 + ", detail:" + paramString1);
      AppMethodBeat.o(187560);
      return bool;
      label136:
      if ("arm64-v8a".equalsIgnoreCase(paramString2)) {
        l.y(577L, 239L, 1L);
      }
    }
  }
  
  public static boolean setVersionInfo(XWebCoreInfo paramXWebCoreInfo)
  {
    AppMethodBeat.i(187564);
    if (paramXWebCoreInfo == null)
    {
      Log.w("XWebCoreInfo", "setVersionInfo, info is null");
      AppMethodBeat.o(187564);
      return false;
    }
    boolean bool = setVersionInfo(paramXWebCoreInfo.ver, paramXWebCoreInfo.verDetail, paramXWebCoreInfo.strAbi);
    AppMethodBeat.o(187564);
    return bool;
  }
  
  public String toString()
  {
    AppMethodBeat.i(187577);
    String str = "XWebCoreInfo{ver=" + this.ver + ", verDetail='" + this.verDetail + '\'' + ", strAbi='" + this.strAbi + '\'' + '}';
    AppMethodBeat.o(187577);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWebCoreInfo
 * JD-Core Version:    0.7.0.1
 */