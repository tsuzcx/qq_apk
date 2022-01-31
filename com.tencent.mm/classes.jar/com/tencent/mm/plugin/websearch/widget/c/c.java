package com.tencent.mm.plugin.websearch.widget.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.b.a.ag;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Arrays;

public final class c
{
  public static boolean J(long paramLong, int paramInt)
  {
    return (1 << paramInt & paramLong) > 0L;
  }
  
  public static void c(String paramString1, String paramString2, String... paramVarArgs)
  {
    AppMethodBeat.i(91462);
    ab.e("WidgetPermissionUtil", "permissionFailed appid %s, api %s, args %s", new Object[] { paramString1, paramString2, Arrays.toString(paramVarArgs) });
    h.qsU.cT(930, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i <= 0)
    {
      localStringBuilder.append(q.encode(paramVarArgs[0])).append("&");
      i += 1;
    }
    new ag().fF(paramString2).fE(paramString1).bA(System.currentTimeMillis()).fG(localStringBuilder.toString()).ake();
    AppMethodBeat.o(91462);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c.c
 * JD-Core Version:    0.7.0.1
 */