package com.tencent.ytcommon.util;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ytcommon.auth.Auth;

public class YTCommonInterface
{
  private static final String TAG = "youtu-common";
  
  public static long getEndTime()
  {
    AppMethodBeat.i(2634);
    long l = Auth.getEndTime();
    AppMethodBeat.o(2634);
    return l;
  }
  
  public static String getFailedReason(int paramInt)
  {
    AppMethodBeat.i(2638);
    String str = Auth.getFailedReason(paramInt);
    AppMethodBeat.o(2638);
    return str;
  }
  
  public static String getLicensePath()
  {
    AppMethodBeat.i(2636);
    String str = Auth.getLicensePath();
    AppMethodBeat.o(2636);
    return str;
  }
  
  public static int getVersion()
  {
    AppMethodBeat.i(2637);
    int i = Auth.getVersion();
    AppMethodBeat.o(2637);
    return i;
  }
  
  public static int initAuth(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(2632);
    paramInt = Auth.init(paramContext, paramString, "", paramInt);
    if (paramInt == 0) {
      new StringBuilder("error code: ").append(paramInt).append("  version: ").append(getVersion()).append("  ").append(getFailedReason(paramInt));
    }
    for (;;)
    {
      AppMethodBeat.o(2632);
      return paramInt;
      new StringBuilder("error code: ").append(paramInt).append("  version: ").append(getVersion()).append("  ").append(getFailedReason(paramInt));
    }
  }
  
  public static int initAuth(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(186331);
    paramInt = Auth.init(paramContext, paramString1, paramString2, paramInt);
    if (paramInt == 0) {
      new StringBuilder("error code: ").append(paramInt).append("  version: ").append(getVersion()).append("  ").append(getFailedReason(paramInt));
    }
    for (;;)
    {
      AppMethodBeat.o(186331);
      return paramInt;
      new StringBuilder("error code: ").append(paramInt).append("  version: ").append(getVersion()).append("  ").append(getFailedReason(paramInt));
    }
  }
  
  public static int initAuth(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(186332);
    int i = Auth.init(paramContext, paramString1, paramString2, 0, paramString3);
    if (i == 0) {
      new StringBuilder("error code: ").append(i).append("  version: ").append(getVersion()).append("  ").append(getFailedReason(i));
    }
    for (;;)
    {
      AppMethodBeat.o(186332);
      return i;
      new StringBuilder("error code: ").append(i).append("  version: ").append(getVersion()).append("  ").append(getFailedReason(i));
    }
  }
  
  public static int initAuthForQQ(Context paramContext)
  {
    AppMethodBeat.i(186333);
    int i = Auth.initAuthForQQ(paramContext);
    if (i == 0) {
      new StringBuilder("error code: ").append(i).append("  version: ").append(getVersion()).append("  ").append(getFailedReason(i));
    }
    for (;;)
    {
      AppMethodBeat.o(186333);
      return i;
      new StringBuilder("error code: ").append(i).append("  version: ").append(getVersion()).append("  ").append(getFailedReason(i));
    }
  }
  
  public static void setLicensePath(String paramString)
  {
    AppMethodBeat.i(2635);
    Auth.setLicensePath(paramString);
    AppMethodBeat.o(2635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ytcommon.util.YTCommonInterface
 * JD-Core Version:    0.7.0.1
 */