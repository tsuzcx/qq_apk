package com.tencent.mm.plugin.websearch.widget.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.g.b.a.dq;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Arrays;

public final class c
{
  public static boolean ac(long paramLong, int paramInt)
  {
    return (1 << paramInt & paramLong) > 0L;
  }
  
  public static void c(String paramString1, String paramString2, String... paramVarArgs)
  {
    AppMethodBeat.i(116657);
    ac.e("WidgetPermissionUtil", "permissionFailed appid %s, api %s, args %s", new Object[] { paramString1, paramString2, Arrays.toString(paramVarArgs) });
    h.wUl.dB(930, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i <= 0)
    {
      localStringBuilder.append(p.encode(paramVarArgs[0])).append("&");
      i += 1;
    }
    paramVarArgs = new dq();
    paramVarArgs.dSw = paramVarArgs.t("api", paramString2, true);
    paramVarArgs.dFy = paramVarArgs.t("appid", paramString1, true);
    paramString1 = paramVarArgs.im(System.currentTimeMillis());
    paramString1.dSx = paramString1.t("arg", localStringBuilder.toString(), true);
    paramString1.aHZ();
    AppMethodBeat.o(116657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c.c
 * JD-Core Version:    0.7.0.1
 */