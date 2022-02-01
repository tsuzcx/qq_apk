package com.tencent.ytcommon.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ytcommon.auth.Auth;

public final class a
{
  public static int dv(Context paramContext, String paramString)
  {
    AppMethodBeat.i(210528);
    int i = Auth.ao(paramContext, paramString, "");
    if (i == 0) {
      new StringBuilder("error code: ").append(i).append("  version: ").append(Auth.getVersion()).append("  ").append(Auth.getFailedReason(i));
    }
    for (;;)
    {
      AppMethodBeat.o(210528);
      return i;
      new StringBuilder("error code: ").append(i).append("  version: ").append(Auth.getVersion()).append("  ").append(Auth.getFailedReason(i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ytcommon.a.a
 * JD-Core Version:    0.7.0.1
 */