package com.tencent.ytcommon.util;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ytcommon.auth.Auth;

public class YTCommonInterface
{
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
    paramInt = Auth.init(paramContext, paramString, paramInt);
    AppMethodBeat.o(2632);
    return paramInt;
  }
  
  public static int initAuth(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(2633);
    int i = Auth.init(paramContext, paramString1, paramString2, 0);
    AppMethodBeat.o(2633);
    return i;
  }
  
  public static void setLicensePath(String paramString)
  {
    AppMethodBeat.i(2635);
    Auth.setLicensePath(paramString);
    AppMethodBeat.o(2635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ytcommon.util.YTCommonInterface
 * JD-Core Version:    0.7.0.1
 */