package com.tencent.mm.plugin.websearch.widget.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.f.b.a.kd;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;

public final class c
{
  public static boolean at(long paramLong, int paramInt)
  {
    return (1 << paramInt & paramLong) > 0L;
  }
  
  public static void e(String paramString1, String paramString2, String... paramVarArgs)
  {
    AppMethodBeat.i(116657);
    Log.e("WidgetPermissionUtil", "permissionFailed appid %s, api %s, args %s", new Object[] { paramString1, paramString2, Arrays.toString(paramVarArgs) });
    h.IzE.el(930, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i <= 0)
    {
      localStringBuilder.append(q.aT(paramVarArgs[0])).append("&");
      i += 1;
    }
    paramVarArgs = new kd();
    paramVarArgs.gMG = paramVarArgs.z("api", paramString2, true);
    paramVarArgs.giT = paramVarArgs.z("appid", paramString1, true);
    paramString1 = paramVarArgs.uO(System.currentTimeMillis());
    paramString1.gMH = paramString1.z("arg", localStringBuilder.toString(), true);
    paramString1.bpa();
    AppMethodBeat.o(116657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c.c
 * JD-Core Version:    0.7.0.1
 */