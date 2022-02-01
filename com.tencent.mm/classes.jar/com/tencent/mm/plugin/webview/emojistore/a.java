package com.tencent.mm.plugin.webview.emojistore;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.b.g;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.qr;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.ebu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class a
  implements com.tencent.mm.an.i
{
  private a PJJ;
  private IListener PJK;
  
  public a()
  {
    AppMethodBeat.i(77863);
    this.PJJ = new a((byte)0);
    this.PJK = new IListener() {};
    EventCenter.instance.addListener(this.PJK);
    AppMethodBeat.o(77863);
  }
  
  private static String aa(Map<String, Object> paramMap, String paramString)
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
  
  private static int ac(Map<String, Object> paramMap, String paramString)
  {
    AppMethodBeat.i(77867);
    paramMap = aa(paramMap, paramString);
    if (Util.isNullOrNil(paramMap))
    {
      AppMethodBeat.o(77867);
      return 0;
    }
    int i = Util.getInt(paramMap, 0);
    AppMethodBeat.o(77867);
    return i;
  }
  
  public static boolean bf(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(265316);
    paramMap = aa(paramMap, "urlString");
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramMap);
    c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(265316);
    return false;
  }
  
  public static boolean bg(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(265319);
    String str2 = com.tencent.mm.at.a.bkK();
    if (Util.isNullOrNil(str2))
    {
      Log.e("MicroMsg.emoji.EmojiStoreWebViewLogic", "load emojiStore Template Path error");
      AppMethodBeat.o(265319);
      return false;
    }
    int i = ac(paramMap, "type");
    String str3 = aa(paramMap, "pageName");
    String str1 = aa(paramMap, "keyword");
    int j = ac(paramMap, "scene");
    paramMap = new Intent();
    paramMap.putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
    paramMap.putExtra("hardcode_general_ctrl", GeneralControlWrapper.RAX);
    paramMap.putExtra("neverGetA8Key", true);
    paramMap.putExtra("rawUrl", "file://" + str2 + "/" + str3 + "?type=" + i + "&keyword=" + str1 + "&scene=" + j + "&lang=" + LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()) + "&clientType=1&version=" + com.tencent.mm.at.a.bkM());
    paramMap.putExtra("keyword", str1);
    paramMap.putExtra("type", i);
    paramMap.putExtra("sence", j);
    c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.emojistore.EmojiStoreSearchWebViewUI", paramMap);
    com.tencent.mm.plugin.report.service.h.IzE.a(13055, new Object[] { Integer.valueOf(1), "", "", Integer.valueOf(i), Integer.valueOf(com.tencent.mm.at.a.bkM()), Long.valueOf(0L) });
    paramMap = new qr();
    paramMap.fPn.type = i;
    paramMap.fPn.query = str1;
    paramMap.fPn.fPo = "";
    EventCenter.instance.publish(paramMap);
    AppMethodBeat.o(265319);
    return true;
  }
  
  public final boolean be(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77864);
    Log.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "getSearchEmotionData: %s", new Object[] { paramMap.toString() });
    String str1 = aa(paramMap, "keyword");
    String str2 = aa(paramMap, "nextPageBuffer");
    int i = ac(paramMap, "type");
    int j = ac(paramMap, "webview_instance_id");
    paramMap = aa(paramMap, "searchID");
    if (Util.isNullOrNil(paramMap)) {}
    for (long l = 0L;; l = Long.valueOf(paramMap).longValue())
    {
      this.PJJ.b(i, str1, str2, j, l);
      AppMethodBeat.o(77864);
      return false;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(77865);
    if ((paramq instanceof b))
    {
      com.tencent.mm.kernel.h.aGY().b(234, this);
      this.PJJ.isRunning = false;
      paramString = (b)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label131;
      }
      this.PJJ.isSuccess = false;
      com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(paramString.PJP).a("{}", paramString.PJQ, "", 0L);
    }
    for (;;)
    {
      paramq = paramString.gTj().UgK;
      String str = z.b(paramString.gTj().TdH);
      long l = paramString.gTj().TdK;
      com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(paramString.PJP).a(paramq, paramString.PJQ, str, l);
      AppMethodBeat.o(77865);
      return;
      label131:
      this.PJJ.isSuccess = true;
    }
  }
  
  final class a
  {
    private b PJM;
    private String PJN;
    private long PJO;
    boolean isRunning;
    boolean isSuccess;
    
    private a() {}
    
    private static String gP(String paramString, int paramInt)
    {
      AppMethodBeat.i(77861);
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramString);
      localStringBuffer.append(paramInt);
      paramString = g.getMessageDigest(localStringBuffer.toString().getBytes());
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
      String str = gP(paramString1, paramInt1);
      if ((!Util.isNullOrNil(this.PJN)) && (this.PJN.equals(str)) && (System.currentTimeMillis() - this.PJO <= 8000L) && (Util.isNullOrNil(paramString2)))
      {
        if (this.isSuccess)
        {
          Log.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "hit the search cache %s", new Object[] { paramString1 });
          com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(paramInt2).a(this.PJM.gTj().UgK, true, z.b(this.PJM.gTj().TdH), this.PJM.gTj().TdK);
          AppMethodBeat.o(77862);
          return;
        }
        if (this.isRunning)
        {
          if (this.PJM != null) {
            this.PJM.PJP = paramInt2;
          }
          Log.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "wait the netscene running");
          AppMethodBeat.o(77862);
          return;
        }
        Log.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "netscene error try again");
      }
      Log.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "start New NetScene query:%s newMD5:%s webviewID:%d", new Object[] { paramString1, str, Integer.valueOf(paramInt2) });
      if (this.PJM != null) {
        com.tencent.mm.kernel.h.aGY().a(this.PJM);
      }
      this.PJN = str;
      this.PJO = System.currentTimeMillis();
      this.isRunning = true;
      this.isSuccess = false;
      com.tencent.mm.kernel.h.aGY().a(234, a.this);
      this.PJM = new b(paramInt1, paramString1, paramString2.getBytes(), paramInt2, paramLong);
      com.tencent.mm.kernel.h.aGY().a(this.PJM, 0);
      AppMethodBeat.o(77862);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.a
 * JD-Core Version:    0.7.0.1
 */