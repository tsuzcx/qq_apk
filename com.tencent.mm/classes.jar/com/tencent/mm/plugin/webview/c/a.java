package com.tencent.mm.plugin.webview.c;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.protocal.c.bnq;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class a
  implements f
{
  a.a qYB = new a.a(this, (byte)0);
  private c qYC = new a.1(this);
  
  public a()
  {
    com.tencent.mm.sdk.b.a.udP.c(this.qYC);
  }
  
  public static String s(Map<String, Object> paramMap, String paramString)
  {
    if (paramMap.containsKey(paramString))
    {
      if (paramMap.get(paramString) != null) {
        return paramMap.get(paramString).toString();
      }
      return "";
    }
    return "";
  }
  
  public static int u(Map<String, Object> paramMap, String paramString)
  {
    paramMap = s(paramMap, paramString);
    if (bk.bl(paramMap)) {
      return 0;
    }
    return Integer.valueOf(paramMap).intValue();
  }
  
  public final boolean W(Map<String, Object> paramMap)
  {
    y.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "getSearchEmotionData: %s", new Object[] { paramMap.toString() });
    String str1 = s(paramMap, "keyword");
    String str2 = s(paramMap, "nextPageBuffer");
    int i = u(paramMap, "type");
    int j = u(paramMap, "webview_instance_id");
    paramMap = s(paramMap, "searchID");
    if (bk.bl(paramMap)) {}
    for (long l = 0L;; l = Long.valueOf(paramMap).longValue())
    {
      this.qYB.a(i, str1, str2, j, l);
      return false;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof b))
    {
      au.Dk().b(234, this);
      this.qYB.isRunning = false;
      paramString = (b)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label118;
      }
      this.qYB.bKQ = false;
      h.Db(paramString.qYH).a("{}", paramString.qYI, "", 0L);
    }
    for (;;)
    {
      paramm = paramString.cax().tGA;
      String str = aa.b(paramString.cax().tcI);
      long l = paramString.cax().tcL;
      h.Db(paramString.qYH).a(paramm, paramString.qYI, str, l);
      return;
      label118:
      this.qYB.bKQ = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.a
 * JD-Core Version:    0.7.0.1
 */