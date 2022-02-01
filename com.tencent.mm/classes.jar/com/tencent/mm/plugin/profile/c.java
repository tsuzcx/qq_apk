package com.tencent.mm.plugin.profile;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cr;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;

public final class c
{
  public static String br(Context paramContext, String paramString)
  {
    AppMethodBeat.i(231798);
    if (WeChatBrands.AppInfo.current().isMainland())
    {
      paramContext = paramContext.getString(2131755837);
      AppMethodBeat.o(231798);
      return paramContext;
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (boolean bool = false; bool; bool = paramString.equals(z.aTY()))
    {
      paramContext = paramContext.getString(2131755837);
      AppMethodBeat.o(231798);
      return paramContext;
    }
    paramContext = paramContext.getString(2131755838);
    AppMethodBeat.o(231798);
    return paramContext;
  }
  
  public static String ju(String paramString1, String paramString2)
  {
    AppMethodBeat.i(231799);
    if (WeChatBrands.AppInfo.current().isMainland())
    {
      AppMethodBeat.o(231799);
      return paramString2;
    }
    if (ab.Iv(paramString1))
    {
      paramString1 = cr.KN("OfficialAliasName");
      AppMethodBeat.o(231799);
      return paramString1;
    }
    AppMethodBeat.o(231799);
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.c
 * JD-Core Version:    0.7.0.1
 */