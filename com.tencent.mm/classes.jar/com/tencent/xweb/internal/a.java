package com.tencent.xweb.internal;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

final class a
{
  private static String aiix;
  private static String aiiy;
  private static String aiiz;
  
  public static String kgU()
  {
    AppMethodBeat.i(212565);
    if (TextUtils.isEmpty(aiix)) {
      aiix = Build.BRAND;
    }
    String str = aiix;
    AppMethodBeat.o(212565);
    return str;
  }
  
  public static String kgV()
  {
    AppMethodBeat.i(212569);
    Object localObject;
    if (TextUtils.isEmpty(aiiy))
    {
      localObject = XWalkEnvironment.getXWebInitArgs("packageName");
      if (!(localObject instanceof String)) {
        break label157;
      }
      if (!"com.tencent.mm".equals((String)localObject)) {
        break label125;
      }
      localObject = XWalkEnvironment.getXWebInitArgs("deviceModel");
      if (!(localObject instanceof String)) {
        break label93;
      }
      aiiy = (String)localObject;
      Log.i("CachedSystemBuildInfo", "device model from init args:" + aiiy);
    }
    for (;;)
    {
      localObject = aiiy;
      AppMethodBeat.o(212569);
      return localObject;
      label93:
      aiiy = Build.MODEL;
      Log.w("CachedSystemBuildInfo", "device model, not available in init args, use Build.MODEL:" + aiiy);
      continue;
      label125:
      aiiy = Build.MODEL;
      Log.w("CachedSystemBuildInfo", "device model, not in wechat app, use Build.MODEL:" + aiiy);
      continue;
      label157:
      aiiy = Build.MODEL;
      Log.w("CachedSystemBuildInfo", "device model, package name not available in init args, use Build.MODEL:" + aiiy);
    }
  }
  
  public static String kgW()
  {
    AppMethodBeat.i(212572);
    if (TextUtils.isEmpty(aiiz)) {
      aiiz = Build.MANUFACTURER;
    }
    String str = aiiz;
    AppMethodBeat.o(212572);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.internal.a
 * JD-Core Version:    0.7.0.1
 */