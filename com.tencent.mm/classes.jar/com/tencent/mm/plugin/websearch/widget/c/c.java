package com.tencent.mm.plugin.websearch.widget.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.mu;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;

public final class c
{
  public static boolean aJ(long paramLong, int paramInt)
  {
    return (1 << paramInt & paramLong) > 0L;
  }
  
  public static void e(String paramString1, String paramString2, String... paramVarArgs)
  {
    AppMethodBeat.i(116657);
    Log.e("WidgetPermissionUtil", "permissionFailed appid %s, api %s, args %s", new Object[] { paramString1, paramString2, Arrays.toString(paramVarArgs) });
    h.OAn.kJ(930, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i <= 0)
    {
      localStringBuilder.append(r.cg(paramVarArgs[0])).append("&");
      i += 1;
    }
    paramVarArgs = new mu();
    paramVarArgs.jcy = paramVarArgs.F("api", paramString2, true);
    paramVarArgs.ipx = paramVarArgs.F("appid", paramString1, true);
    paramString1 = paramVarArgs.fn(System.currentTimeMillis());
    paramString1.jcz = paramString1.F("arg", localStringBuilder.toString(), true);
    paramString1.bMH();
    AppMethodBeat.o(116657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c.c
 * JD-Core Version:    0.7.0.1
 */