package com.tencent.mm.plugin.webview.emojistore;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.or;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.protocal.protobuf.csw;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;

public final class a
  implements com.tencent.mm.ak.g
{
  a Cgd;
  private c Cge;
  
  public a()
  {
    AppMethodBeat.i(77863);
    this.Cgd = new a((byte)0);
    this.Cge = new c() {};
    com.tencent.mm.sdk.b.a.GpY.c(this.Cge);
    AppMethodBeat.o(77863);
  }
  
  public static String x(Map<String, Object> paramMap, String paramString)
  {
    AppMethodBeat.i(77866);
    if (paramMap.containsKey(paramString))
    {
      if (paramMap.get(paramString) != null)
      {
        paramMap = paramMap.get(paramString).toString();
        AppMethodBeat.o(77866);
        return paramMap;
      }
      AppMethodBeat.o(77866);
      return "";
    }
    AppMethodBeat.o(77866);
    return "";
  }
  
  public static int z(Map<String, Object> paramMap, String paramString)
  {
    AppMethodBeat.i(77867);
    paramMap = x(paramMap, paramString);
    if (bs.isNullOrNil(paramMap))
    {
      AppMethodBeat.o(77867);
      return 0;
    }
    int i = bs.getInt(paramMap, 0);
    AppMethodBeat.o(77867);
    return i;
  }
  
  public final boolean ba(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77864);
    ac.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "getSearchEmotionData: %s", new Object[] { paramMap.toString() });
    String str1 = x(paramMap, "keyword");
    String str2 = x(paramMap, "nextPageBuffer");
    int i = z(paramMap, "type");
    int j = z(paramMap, "webview_instance_id");
    paramMap = x(paramMap, "searchID");
    if (bs.isNullOrNil(paramMap)) {}
    for (long l = 0L;; l = Long.valueOf(paramMap).longValue())
    {
      this.Cgd.a(i, str1, str2, j, l);
      AppMethodBeat.o(77864);
      return false;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(77865);
    if ((paramn instanceof b))
    {
      com.tencent.mm.kernel.g.agi().b(234, this);
      this.Cgd.isRunning = false;
      paramString = (b)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label128;
      }
      this.Cgd.deB = false;
      com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(paramString.Cgj).a("{}", paramString.Cgk, "", 0L);
    }
    for (;;)
    {
      paramn = paramString.ezh().FEY;
      String str = z.b(paramString.ezh().EOe);
      long l = paramString.ezh().EOh;
      com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(paramString.Cgj).a(paramn, paramString.Cgk, str, l);
      AppMethodBeat.o(77865);
      return;
      label128:
      this.Cgd.deB = true;
    }
  }
  
  final class a
  {
    private b Cgg;
    private String Cgh;
    private long Cgi;
    boolean deB;
    boolean isRunning;
    
    private a() {}
    
    private static String fb(String paramString, int paramInt)
    {
      AppMethodBeat.i(77861);
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramString);
      localStringBuffer.append(paramInt);
      paramString = com.tencent.mm.b.g.getMessageDigest(localStringBuffer.toString().getBytes());
      AppMethodBeat.o(77861);
      return paramString;
    }
    
    public final void a(int paramInt1, String paramString1, String paramString2, int paramInt2, long paramLong)
    {
      AppMethodBeat.i(77862);
      if (bs.isNullOrNil(paramString1))
      {
        if (paramString2 == null) {}
        for (paramString2 = "";; paramString2 = paramString2.toString())
        {
          ac.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "error query:%s type:%d pagebuf:%s ", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2 });
          AppMethodBeat.o(77862);
          return;
        }
      }
      String str = fb(paramString1, paramInt1);
      if ((!bs.isNullOrNil(this.Cgh)) && (this.Cgh.equals(str)) && (System.currentTimeMillis() - this.Cgi <= 8000L) && (bs.isNullOrNil(paramString2)))
      {
        if (this.deB)
        {
          ac.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "hit the search cache %s", new Object[] { paramString1 });
          com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(paramInt2).a(this.Cgg.ezh().FEY, true, z.b(this.Cgg.ezh().EOe), this.Cgg.ezh().EOh);
          AppMethodBeat.o(77862);
          return;
        }
        if (this.isRunning)
        {
          if (this.Cgg != null) {
            this.Cgg.Cgj = paramInt2;
          }
          ac.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "wait the netscene running");
          AppMethodBeat.o(77862);
          return;
        }
        ac.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "netscene error try again");
      }
      ac.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "start New NetScene query:%s newMD5:%s webviewID:%d", new Object[] { paramString1, str, Integer.valueOf(paramInt2) });
      if (this.Cgg != null) {
        com.tencent.mm.kernel.g.agi().a(this.Cgg);
      }
      this.Cgh = str;
      this.Cgi = System.currentTimeMillis();
      this.isRunning = true;
      this.deB = false;
      com.tencent.mm.kernel.g.agi().a(234, a.this);
      this.Cgg = new b(paramInt1, paramString1, paramString2.getBytes(), paramInt2, paramLong);
      com.tencent.mm.kernel.g.agi().a(this.Cgg, 0);
      AppMethodBeat.o(77862);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.a
 * JD-Core Version:    0.7.0.1
 */