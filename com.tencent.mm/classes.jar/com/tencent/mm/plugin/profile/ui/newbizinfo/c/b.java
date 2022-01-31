package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
{
  public static final String pFE = j.fwo;
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(23955);
    ab.d("MicroMsg.Kv10809", "brandUsername:%s, menuId:%s, menuKey:%s, status:%s, content:%s, actionType:%d, nativescene:%d, titleInfo:%s, indexInfo:%s, actionInfo:%s", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(126), paramString5, paramString6, paramString7 });
    h.qsU.e(10809, new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(126), paramString5, paramString6, paramString7 });
    AppMethodBeat.o(23955);
  }
  
  public static String fj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(23956);
    if (paramInt1 < 0)
    {
      AppMethodBeat.o(23956);
      return "";
    }
    if (paramInt2 < 0)
    {
      AppMethodBeat.o(23956);
      return String.valueOf(paramInt1);
    }
    String str = paramInt1 + "-" + paramInt2;
    AppMethodBeat.o(23956);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.c.b
 * JD-Core Version:    0.7.0.1
 */