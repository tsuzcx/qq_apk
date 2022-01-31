package com.tencent.mm.plugin.webview.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.protocal.protobuf.bxl;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public final class a
  implements f
{
  a.a uOh;
  private c uOi;
  
  public a()
  {
    AppMethodBeat.i(5653);
    this.uOh = new a.a(this, (byte)0);
    this.uOi = new c() {};
    com.tencent.mm.sdk.b.a.ymk.c(this.uOi);
    AppMethodBeat.o(5653);
  }
  
  public static String t(Map<String, Object> paramMap, String paramString)
  {
    AppMethodBeat.i(5656);
    if (paramMap.containsKey(paramString))
    {
      if (paramMap.get(paramString) != null)
      {
        paramMap = paramMap.get(paramString).toString();
        AppMethodBeat.o(5656);
        return paramMap;
      }
      AppMethodBeat.o(5656);
      return "";
    }
    AppMethodBeat.o(5656);
    return "";
  }
  
  public static int v(Map<String, Object> paramMap, String paramString)
  {
    AppMethodBeat.i(5657);
    paramMap = t(paramMap, paramString);
    if (bo.isNullOrNil(paramMap))
    {
      AppMethodBeat.o(5657);
      return 0;
    }
    int i = Integer.valueOf(paramMap).intValue();
    AppMethodBeat.o(5657);
    return i;
  }
  
  public final boolean ar(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(5654);
    ab.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "getSearchEmotionData: %s", new Object[] { paramMap.toString() });
    String str1 = t(paramMap, "keyword");
    String str2 = t(paramMap, "nextPageBuffer");
    int i = v(paramMap, "type");
    int j = v(paramMap, "webview_instance_id");
    paramMap = t(paramMap, "searchID");
    if (bo.isNullOrNil(paramMap)) {}
    for (long l = 0L;; l = Long.valueOf(paramMap).longValue())
    {
      this.uOh.a(i, str1, str2, j, l);
      AppMethodBeat.o(5654);
      return false;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(5655);
    if ((paramm instanceof b))
    {
      com.tencent.mm.kernel.g.Rc().b(234, this);
      this.uOh.isRunning = false;
      paramString = (b)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label130;
      }
      this.uOh.csk = false;
      h.KW(paramString.uOn).a("{}", paramString.uOo, "", 0L);
    }
    for (;;)
    {
      paramm = paramString.dax().xKp;
      String str = aa.b(paramString.dax().xaZ);
      long l = paramString.dax().xbc;
      h.KW(paramString.uOn).a(paramm, paramString.uOo, str, l);
      AppMethodBeat.o(5655);
      return;
      label130:
      this.uOh.csk = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.a
 * JD-Core Version:    0.7.0.1
 */