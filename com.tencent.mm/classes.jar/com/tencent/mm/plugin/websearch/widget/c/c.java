package com.tencent.mm.plugin.websearch.widget.c;

import com.tencent.mm.compatible.util.q;
import com.tencent.mm.h.b.a.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Arrays;

public final class c
{
  public static void c(String paramString1, String paramString2, String... paramVarArgs)
  {
    y.e("WidgetPermissionUtil", "permissionFailed appid %s, api %s, args %s", new Object[] { paramString1, paramString2, Arrays.toString(paramVarArgs) });
    h.nFQ.h(930L, 0L, 1L);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i <= 0)
    {
      localStringBuilder.append(q.encode(paramVarArgs[0])).append("&");
      i += 1;
    }
    paramVarArgs = new s();
    paramVarArgs.cjA = paramString2;
    paramVarArgs.cjv = paramString1;
    paramString1 = paramVarArgs.ap(System.currentTimeMillis());
    paramString1.cjB = localStringBuilder.toString();
    paramString1.QX();
  }
  
  public static boolean z(long paramLong, int paramInt)
  {
    return (1 << paramInt & paramLong) > 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c.c
 * JD-Core Version:    0.7.0.1
 */