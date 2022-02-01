package com.tencent.mm.plugin.webview.emojistore;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.pt;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.protocal.protobuf.dry;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class a
  implements i
{
  a INq;
  private IListener INr;
  
  public a()
  {
    AppMethodBeat.i(77863);
    this.INq = new a((byte)0);
    this.INr = new IListener() {};
    EventCenter.instance.addListener(this.INr);
    AppMethodBeat.o(77863);
  }
  
  public static String N(Map<String, Object> paramMap, String paramString)
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
  
  public static int P(Map<String, Object> paramMap, String paramString)
  {
    AppMethodBeat.i(77867);
    paramMap = N(paramMap, paramString);
    if (Util.isNullOrNil(paramMap))
    {
      AppMethodBeat.o(77867);
      return 0;
    }
    int i = Util.getInt(paramMap, 0);
    AppMethodBeat.o(77867);
    return i;
  }
  
  public final boolean bk(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77864);
    Log.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "getSearchEmotionData: %s", new Object[] { paramMap.toString() });
    String str1 = N(paramMap, "keyword");
    String str2 = N(paramMap, "nextPageBuffer");
    int i = P(paramMap, "type");
    int j = P(paramMap, "webview_instance_id");
    paramMap = N(paramMap, "searchID");
    if (Util.isNullOrNil(paramMap)) {}
    for (long l = 0L;; l = Long.valueOf(paramMap).longValue())
    {
      this.INq.b(i, str1, str2, j, l);
      AppMethodBeat.o(77864);
      return false;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(77865);
    if ((paramq instanceof b))
    {
      com.tencent.mm.kernel.g.azz().b(234, this);
      this.INq.isRunning = false;
      paramString = (b)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label128;
      }
      this.INq.isSuccess = false;
      com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(paramString.INw).a("{}", paramString.INx, "", 0L);
    }
    for (;;)
    {
      paramq = paramString.gap().MUB;
      String str = z.b(paramString.gap().LUY);
      long l = paramString.gap().LVb;
      com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(paramString.INw).a(paramq, paramString.INx, str, l);
      AppMethodBeat.o(77865);
      return;
      label128:
      this.INq.isSuccess = true;
    }
  }
  
  final class a
  {
    private b INt;
    private String INu;
    private long INv;
    boolean isRunning;
    boolean isSuccess;
    
    private a() {}
    
    private static String gg(String paramString, int paramInt)
    {
      AppMethodBeat.i(77861);
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramString);
      localStringBuffer.append(paramInt);
      paramString = com.tencent.mm.b.g.getMessageDigest(localStringBuffer.toString().getBytes());
      AppMethodBeat.o(77861);
      return paramString;
    }
    
    public final void b(int paramInt1, String paramString1, String paramString2, int paramInt2, long paramLong)
    {
      AppMethodBeat.i(77862);
      if (Util.isNullOrNil(paramString1))
      {
        if (paramString2 == null) {}
        for (paramString2 = "";; paramString2 = paramString2.toString())
        {
          Log.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "error query:%s type:%d pagebuf:%s ", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2 });
          AppMethodBeat.o(77862);
          return;
        }
      }
      String str = gg(paramString1, paramInt1);
      if ((!Util.isNullOrNil(this.INu)) && (this.INu.equals(str)) && (System.currentTimeMillis() - this.INv <= 8000L) && (Util.isNullOrNil(paramString2)))
      {
        if (this.isSuccess)
        {
          Log.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "hit the search cache %s", new Object[] { paramString1 });
          com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(paramInt2).a(this.INt.gap().MUB, true, z.b(this.INt.gap().LUY), this.INt.gap().LVb);
          AppMethodBeat.o(77862);
          return;
        }
        if (this.isRunning)
        {
          if (this.INt != null) {
            this.INt.INw = paramInt2;
          }
          Log.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "wait the netscene running");
          AppMethodBeat.o(77862);
          return;
        }
        Log.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "netscene error try again");
      }
      Log.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "start New NetScene query:%s newMD5:%s webviewID:%d", new Object[] { paramString1, str, Integer.valueOf(paramInt2) });
      if (this.INt != null) {
        com.tencent.mm.kernel.g.azz().a(this.INt);
      }
      this.INu = str;
      this.INv = System.currentTimeMillis();
      this.isRunning = true;
      this.isSuccess = false;
      com.tencent.mm.kernel.g.azz().a(234, a.this);
      this.INt = new b(paramInt1, paramString1, paramString2.getBytes(), paramInt2, paramLong);
      com.tencent.mm.kernel.g.azz().a(this.INt, 0);
      AppMethodBeat.o(77862);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.a
 * JD-Core Version:    0.7.0.1
 */