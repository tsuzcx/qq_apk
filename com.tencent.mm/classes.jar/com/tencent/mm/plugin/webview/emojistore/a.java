package com.tencent.mm.plugin.webview.emojistore;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public final class a
  implements com.tencent.mm.al.f
{
  a DJg;
  private c DJh;
  
  public a()
  {
    AppMethodBeat.i(77863);
    this.DJg = new a((byte)0);
    this.DJh = new c() {};
    com.tencent.mm.sdk.b.a.IbL.c(this.DJh);
    AppMethodBeat.o(77863);
  }
  
  public static int B(Map<String, Object> paramMap, String paramString)
  {
    AppMethodBeat.i(77867);
    paramMap = z(paramMap, paramString);
    if (bt.isNullOrNil(paramMap))
    {
      AppMethodBeat.o(77867);
      return 0;
    }
    int i = bt.getInt(paramMap, 0);
    AppMethodBeat.o(77867);
    return i;
  }
  
  public static String z(Map<String, Object> paramMap, String paramString)
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
  
  public final boolean bc(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77864);
    ad.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "getSearchEmotionData: %s", new Object[] { paramMap.toString() });
    String str1 = z(paramMap, "keyword");
    String str2 = z(paramMap, "nextPageBuffer");
    int i = B(paramMap, "type");
    int j = B(paramMap, "webview_instance_id");
    paramMap = z(paramMap, "searchID");
    if (bt.isNullOrNil(paramMap)) {}
    for (long l = 0L;; l = Long.valueOf(paramMap).longValue())
    {
      this.DJg.a(i, str1, str2, j, l);
      AppMethodBeat.o(77864);
      return false;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(77865);
    if ((paramn instanceof b))
    {
      com.tencent.mm.kernel.g.aiU().b(234, this);
      this.DJg.isRunning = false;
      paramString = (b)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label128;
      }
      this.DJg.dpX = false;
      com.tencent.mm.plugin.webview.ui.tools.jsapi.g.XN(paramString.DJm).a("{}", paramString.DJn, "", 0L);
    }
    for (;;)
    {
      paramn = paramString.eNW().Hpx;
      String str = z.b(paramString.eNW().Gxi);
      long l = paramString.eNW().Gxl;
      com.tencent.mm.plugin.webview.ui.tools.jsapi.g.XN(paramString.DJm).a(paramn, paramString.DJn, str, l);
      AppMethodBeat.o(77865);
      return;
      label128:
      this.DJg.dpX = true;
    }
  }
  
  final class a
  {
    private b DJj;
    private String DJk;
    private long DJl;
    boolean dpX;
    boolean isRunning;
    
    private a() {}
    
    private static String fy(String paramString, int paramInt)
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
      String str = fy(paramString1, paramInt1);
      if ((!bt.isNullOrNil(this.DJk)) && (this.DJk.equals(str)) && (System.currentTimeMillis() - this.DJl <= 8000L) && (bt.isNullOrNil(paramString2)))
      {
        if (this.dpX)
        {
          ad.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "hit the search cache %s", new Object[] { paramString1 });
          com.tencent.mm.plugin.webview.ui.tools.jsapi.g.XN(paramInt2).a(this.DJj.eNW().Hpx, true, z.b(this.DJj.eNW().Gxi), this.DJj.eNW().Gxl);
          AppMethodBeat.o(77862);
          return;
        }
        if (this.isRunning)
        {
          if (this.DJj != null) {
            this.DJj.DJm = paramInt2;
          }
          ad.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "wait the netscene running");
          AppMethodBeat.o(77862);
          return;
        }
        ad.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "netscene error try again");
      }
      ad.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "start New NetScene query:%s newMD5:%s webviewID:%d", new Object[] { paramString1, str, Integer.valueOf(paramInt2) });
      if (this.DJj != null) {
        com.tencent.mm.kernel.g.aiU().a(this.DJj);
      }
      this.DJk = str;
      this.DJl = System.currentTimeMillis();
      this.isRunning = true;
      this.dpX = false;
      com.tencent.mm.kernel.g.aiU().a(234, a.this);
      this.DJj = new b(paramInt1, paramString1, paramString2.getBytes(), paramInt2, paramLong);
      com.tencent.mm.kernel.g.aiU().a(this.DJj, 0);
      AppMethodBeat.o(77862);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.a
 * JD-Core Version:    0.7.0.1
 */