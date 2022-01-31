package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import com.tencent.mm.ai.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  public static final String nat = j.egm;
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    y.d("MicroMsg.Kv10809", "brandUsername:%s, menuId:%s, menuKey:%s, status:%s, content:%s, actionType:%d, nativescene:%d, titleInfo:%s, indexInfo:%s, actionInfo:%s", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(126), paramString5, paramString6, paramString7 });
    h.nFQ.f(10809, new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(126), paramString5, paramString6, paramString7 });
  }
  
  public static String dD(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      return "";
    }
    if (paramInt2 < 0) {
      return String.valueOf(paramInt1);
    }
    return paramInt1 + "-" + paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.c.b
 * JD-Core Version:    0.7.0.1
 */