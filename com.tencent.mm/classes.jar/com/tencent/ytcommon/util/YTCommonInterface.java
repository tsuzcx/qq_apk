package com.tencent.ytcommon.util;

import android.content.Context;
import com.tencent.ytcommon.auth.Auth;

public class YTCommonInterface
{
  public static int initAuth(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    return Auth.init(paramContext, paramString, paramInt, paramBoolean);
  }
  
  public static int preCheckAndInitWithLicenceStr(Context paramContext, String paramString)
  {
    return Auth.preCheckAndInitWithLicenceStr(paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ytcommon.util.YTCommonInterface
 * JD-Core Version:    0.7.0.1
 */