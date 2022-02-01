package com.tencent.mm.plugin.sns.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$a
{
  public static String bf(Context paramContext, String paramString)
  {
    AppMethodBeat.i(219204);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(219204);
      return "";
    }
    try
    {
      paramContext = paramContext.getPackageManager();
      paramContext = paramContext.getApplicationLabel(paramContext.getApplicationInfo(paramString, 128));
      if (paramContext != null)
      {
        paramContext = paramContext.toString();
        AppMethodBeat.o(219204);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(219204);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.a.a
 * JD-Core Version:    0.7.0.1
 */