package com.tencent.mm.plugin.webview.emojistore;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.oi;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.protocal.protobuf.cnp;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public final class a
  implements com.tencent.mm.al.g
{
  a ANL;
  private c ANM;
  
  public a()
  {
    AppMethodBeat.i(77863);
    this.ANL = new a((byte)0);
    this.ANM = new c() {};
    com.tencent.mm.sdk.b.a.ESL.c(this.ANM);
    AppMethodBeat.o(77863);
  }
  
  public static String w(Map<String, Object> paramMap, String paramString)
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
  
  public static int y(Map<String, Object> paramMap, String paramString)
  {
    AppMethodBeat.i(77867);
    paramMap = w(paramMap, paramString);
    if (bt.isNullOrNil(paramMap))
    {
      AppMethodBeat.o(77867);
      return 0;
    }
    int i = bt.getInt(paramMap, 0);
    AppMethodBeat.o(77867);
    return i;
  }
  
  public final boolean aW(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77864);
    ad.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "getSearchEmotionData: %s", new Object[] { paramMap.toString() });
    String str1 = w(paramMap, "keyword");
    String str2 = w(paramMap, "nextPageBuffer");
    int i = y(paramMap, "type");
    int j = y(paramMap, "webview_instance_id");
    paramMap = w(paramMap, "searchID");
    if (bt.isNullOrNil(paramMap)) {}
    for (long l = 0L;; l = Long.valueOf(paramMap).longValue())
    {
      this.ANL.a(i, str1, str2, j, l);
      AppMethodBeat.o(77864);
      return false;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(77865);
    if ((paramn instanceof b))
    {
      com.tencent.mm.kernel.g.aeS().b(234, this);
      this.ANL.isRunning = false;
      paramString = (b)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label128;
      }
      this.ANL.dhg = false;
      com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(paramString.ANR).a("{}", paramString.ANS, "", 0L);
    }
    for (;;)
    {
      paramn = paramString.ejM().Eia;
      String str = z.b(paramString.ejM().Dta);
      long l = paramString.ejM().Dtd;
      com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(paramString.ANR).a(paramn, paramString.ANS, str, l);
      AppMethodBeat.o(77865);
      return;
      label128:
      this.ANL.dhg = true;
    }
  }
  
  final class a
  {
    private b ANO;
    private String ANP;
    private long ANQ;
    boolean dhg;
    boolean isRunning;
    
    private a() {}
    
    private static String eT(String paramString, int paramInt)
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
      if (bt.isNullOrNil(paramString1))
      {
        if (paramString2 == null) {}
        for (paramString2 = "";; paramString2 = paramString2.toString())
        {
          ad.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "error query:%s type:%d pagebuf:%s ", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2 });
          AppMethodBeat.o(77862);
          return;
        }
      }
      String str = eT(paramString1, paramInt1);
      if ((!bt.isNullOrNil(this.ANP)) && (this.ANP.equals(str)) && (System.currentTimeMillis() - this.ANQ <= 8000L) && (bt.isNullOrNil(paramString2)))
      {
        if (this.dhg)
        {
          ad.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "hit the search cache %s", new Object[] { paramString1 });
          com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(paramInt2).a(this.ANO.ejM().Eia, true, z.b(this.ANO.ejM().Dta), this.ANO.ejM().Dtd);
          AppMethodBeat.o(77862);
          return;
        }
        if (this.isRunning)
        {
          if (this.ANO != null) {
            this.ANO.ANR = paramInt2;
          }
          ad.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "wait the netscene running");
          AppMethodBeat.o(77862);
          return;
        }
        ad.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "netscene error try again");
      }
      ad.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "start New NetScene query:%s newMD5:%s webviewID:%d", new Object[] { paramString1, str, Integer.valueOf(paramInt2) });
      if (this.ANO != null) {
        com.tencent.mm.kernel.g.aeS().a(this.ANO);
      }
      this.ANP = str;
      this.ANQ = System.currentTimeMillis();
      this.isRunning = true;
      this.dhg = false;
      com.tencent.mm.kernel.g.aeS().a(234, a.this);
      this.ANO = new b(paramInt1, paramString1, paramString2.getBytes(), paramInt2, paramLong);
      com.tencent.mm.kernel.g.aeS().a(this.ANO, 0);
      AppMethodBeat.o(77862);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.a
 * JD-Core Version:    0.7.0.1
 */