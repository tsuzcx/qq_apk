package com.tencent.ytcommon.util;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ytcommon.auth.Auth;

public class YTCommonInterface
{
  public static int initAuth(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(27);
    paramInt = Auth.init(paramContext, paramString, paramInt, paramBoolean);
    AppMethodBeat.o(27);
    return paramInt;
  }
  
  public static int preCheckAndInitWithLicenceStr(Context paramContext, String paramString)
  {
    AppMethodBeat.i(26);
    int i = Auth.preCheckAndInitWithLicenceStr(paramContext, paramString);
    AppMethodBeat.o(26);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ytcommon.util.YTCommonInterface
 * JD-Core Version:    0.7.0.1
 */