package com.tencent.mm.plugin.sns.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static final class a
  {
    public static String aZ(Context paramContext, String paramString)
    {
      AppMethodBeat.i(187243);
      if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
      {
        AppMethodBeat.o(187243);
        return "";
      }
      try
      {
        paramContext = paramContext.getPackageManager();
        paramContext = paramContext.getApplicationLabel(paramContext.getApplicationInfo(paramString, 128));
        if (paramContext != null)
        {
          paramContext = paramContext.toString();
          AppMethodBeat.o(187243);
          return paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        AppMethodBeat.o(187243);
      }
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.b.a
 * JD-Core Version:    0.7.0.1
 */