package com.tencent.mm.plugin.profile;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cs;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;

public final class c
{
  public static boolean aUI(String paramString)
  {
    AppMethodBeat.i(273676);
    if (((n)h.ae(n.class)).eSe().aOH(paramString).field_msgId != 0L)
    {
      AppMethodBeat.o(273676);
      return true;
    }
    AppMethodBeat.o(273676);
    return false;
  }
  
  public static String bE(Context paramContext, String paramString)
  {
    AppMethodBeat.i(273674);
    if (WeChatBrands.AppInfo.current().isMainland())
    {
      paramContext = paramContext.getString(R.l.app_field_username);
      AppMethodBeat.o(273674);
      return paramContext;
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (boolean bool = false; bool; bool = paramString.equals(z.bcZ()))
    {
      paramContext = paramContext.getString(R.l.app_field_username);
      AppMethodBeat.o(273674);
      return paramContext;
    }
    paramContext = paramContext.getString(R.l.app_field_username_others);
    AppMethodBeat.o(273674);
    return paramContext;
  }
  
  public static String jG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(273675);
    if (WeChatBrands.AppInfo.current().isMainland())
    {
      AppMethodBeat.o(273675);
      return paramString2;
    }
    if (ab.PN(paramString1))
    {
      paramString1 = cs.Sg("OfficialAliasName");
      AppMethodBeat.o(273675);
      return paramString1;
    }
    AppMethodBeat.o(273675);
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.c
 * JD-Core Version:    0.7.0.1
 */