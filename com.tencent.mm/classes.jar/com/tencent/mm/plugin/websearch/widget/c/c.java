package com.tencent.mm.plugin.websearch.widget.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.b.a.el;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Arrays;

public final class c
{
  public static boolean ah(long paramLong, int paramInt)
  {
    return (1 << paramInt & paramLong) > 0L;
  }
  
  public static void d(String paramString1, String paramString2, String... paramVarArgs)
  {
    AppMethodBeat.i(116657);
    ad.e("WidgetPermissionUtil", "permissionFailed appid %s, api %s, args %s", new Object[] { paramString1, paramString2, Arrays.toString(paramVarArgs) });
    g.yhR.dD(930, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i <= 0)
    {
      localStringBuilder.append(q.encode(paramVarArgs[0])).append("&");
      i += 1;
    }
    paramVarArgs = new el();
    paramVarArgs.eic = paramVarArgs.t("api", paramString2, true);
    paramVarArgs.dSD = paramVarArgs.t("appid", paramString1, true);
    paramString1 = paramVarArgs.jY(System.currentTimeMillis());
    paramString1.eid = paramString1.t("arg", localStringBuilder.toString(), true);
    paramString1.aLk();
    AppMethodBeat.o(116657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c.c
 * JD-Core Version:    0.7.0.1
 */