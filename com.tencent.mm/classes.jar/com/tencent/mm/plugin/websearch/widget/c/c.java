package com.tencent.mm.plugin.websearch.widget.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.g.b.a.cc;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Arrays;

public final class c
{
  public static boolean Z(long paramLong, int paramInt)
  {
    return (1 << paramInt & paramLong) > 0L;
  }
  
  public static void c(String paramString1, String paramString2, String... paramVarArgs)
  {
    AppMethodBeat.i(116657);
    ad.e("WidgetPermissionUtil", "permissionFailed appid %s, api %s, args %s", new Object[] { paramString1, paramString2, Arrays.toString(paramVarArgs) });
    h.vKh.dB(930, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i <= 0)
    {
      localStringBuilder.append(p.encode(paramVarArgs[0])).append("&");
      i += 1;
    }
    paramVarArgs = new cc();
    paramVarArgs.dQH = paramVarArgs.t("api", paramString2, true);
    paramVarArgs.dHL = paramVarArgs.t("appid", paramString1, true);
    paramString1 = paramVarArgs.eZ(System.currentTimeMillis());
    paramString1.dQI = paramString1.t("arg", localStringBuilder.toString(), true);
    paramString1.aBj();
    AppMethodBeat.o(116657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c.c
 * JD-Core Version:    0.7.0.1
 */