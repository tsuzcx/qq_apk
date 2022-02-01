package com.tencent.mm.plugin.webview.emojistore;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.pb;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cza;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;

public final class a
  implements com.tencent.mm.ak.f
{
  a Ebe;
  private c Ebf;
  
  public a()
  {
    AppMethodBeat.i(77863);
    this.Ebe = new a((byte)0);
    this.Ebf = new c() {};
    com.tencent.mm.sdk.b.a.IvT.c(this.Ebf);
    AppMethodBeat.o(77863);
  }
  
  public static String A(Map<String, Object> paramMap, String paramString)
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
  
  public static int C(Map<String, Object> paramMap, String paramString)
  {
    AppMethodBeat.i(77867);
    paramMap = A(paramMap, paramString);
    if (bu.isNullOrNil(paramMap))
    {
      AppMethodBeat.o(77867);
      return 0;
    }
    int i = bu.getInt(paramMap, 0);
    AppMethodBeat.o(77867);
    return i;
  }
  
  public final boolean bi(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77864);
    ae.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "getSearchEmotionData: %s", new Object[] { paramMap.toString() });
    String str1 = A(paramMap, "keyword");
    String str2 = A(paramMap, "nextPageBuffer");
    int i = C(paramMap, "type");
    int j = C(paramMap, "webview_instance_id");
    paramMap = A(paramMap, "searchID");
    if (bu.isNullOrNil(paramMap)) {}
    for (long l = 0L;; l = Long.valueOf(paramMap).longValue())
    {
      this.Ebe.a(i, str1, str2, j, l);
      AppMethodBeat.o(77864);
      return false;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(77865);
    if ((paramn instanceof b))
    {
      com.tencent.mm.kernel.g.ajj().b(234, this);
      this.Ebe.isRunning = false;
      paramString = (b)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label128;
      }
      this.Ebe.drc = false;
      com.tencent.mm.plugin.webview.ui.tools.jsapi.g.Yt(paramString.Ebk).a("{}", paramString.Ebl, "", 0L);
    }
    for (;;)
    {
      paramn = paramString.eRH().HIZ;
      String str = z.b(paramString.eRH().GQI);
      long l = paramString.eRH().GQL;
      com.tencent.mm.plugin.webview.ui.tools.jsapi.g.Yt(paramString.Ebk).a(paramn, paramString.Ebl, str, l);
      AppMethodBeat.o(77865);
      return;
      label128:
      this.Ebe.drc = true;
    }
  }
  
  final class a
  {
    private b Ebh;
    private String Ebi;
    private long Ebj;
    boolean drc;
    boolean isRunning;
    
    private a() {}
    
    private static String fJ(String paramString, int paramInt)
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
      if (bu.isNullOrNil(paramString1))
      {
        if (paramString2 == null) {}
        for (paramString2 = "";; paramString2 = paramString2.toString())
        {
          ae.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "error query:%s type:%d pagebuf:%s ", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2 });
          AppMethodBeat.o(77862);
          return;
        }
      }
      String str = fJ(paramString1, paramInt1);
      if ((!bu.isNullOrNil(this.Ebi)) && (this.Ebi.equals(str)) && (System.currentTimeMillis() - this.Ebj <= 8000L) && (bu.isNullOrNil(paramString2)))
      {
        if (this.drc)
        {
          ae.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "hit the search cache %s", new Object[] { paramString1 });
          com.tencent.mm.plugin.webview.ui.tools.jsapi.g.Yt(paramInt2).a(this.Ebh.eRH().HIZ, true, z.b(this.Ebh.eRH().GQI), this.Ebh.eRH().GQL);
          AppMethodBeat.o(77862);
          return;
        }
        if (this.isRunning)
        {
          if (this.Ebh != null) {
            this.Ebh.Ebk = paramInt2;
          }
          ae.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "wait the netscene running");
          AppMethodBeat.o(77862);
          return;
        }
        ae.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "netscene error try again");
      }
      ae.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "start New NetScene query:%s newMD5:%s webviewID:%d", new Object[] { paramString1, str, Integer.valueOf(paramInt2) });
      if (this.Ebh != null) {
        com.tencent.mm.kernel.g.ajj().a(this.Ebh);
      }
      this.Ebi = str;
      this.Ebj = System.currentTimeMillis();
      this.isRunning = true;
      this.drc = false;
      com.tencent.mm.kernel.g.ajj().a(234, a.this);
      this.Ebh = new b(paramInt1, paramString1, paramString2.getBytes(), paramInt2, paramLong);
      com.tencent.mm.kernel.g.ajj().a(this.Ebh, 0);
      AppMethodBeat.o(77862);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.a
 * JD-Core Version:    0.7.0.1
 */