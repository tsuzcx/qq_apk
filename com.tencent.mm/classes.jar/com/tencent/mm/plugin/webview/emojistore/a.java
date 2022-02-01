package com.tencent.mm.plugin.webview.emojistore;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.sf;
import com.tencent.mm.b.g;
import com.tencent.mm.br.c;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.k;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.evl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class a
  implements com.tencent.mm.am.h
{
  private a WAb;
  private IListener WAc;
  
  public a()
  {
    AppMethodBeat.i(77863);
    this.WAb = new a((byte)0);
    this.WAc = new EmojiStoreWebViewLogic.1(this, f.hfK);
    this.WAc.alive();
    AppMethodBeat.o(77863);
  }
  
  private static String au(Map<String, Object> paramMap, String paramString)
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
  
  private static int aw(Map<String, Object> paramMap, String paramString)
  {
    AppMethodBeat.i(77867);
    paramMap = au(paramMap, paramString);
    if (Util.isNullOrNil(paramMap))
    {
      AppMethodBeat.o(77867);
      return 0;
    }
    int i = Util.getInt(paramMap, 0);
    AppMethodBeat.o(77867);
    return i;
  }
  
  public static boolean bx(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(294739);
    paramMap = au(paramMap, "urlString");
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramMap);
    c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(294739);
    return false;
  }
  
  public static boolean by(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(294751);
    String str2 = com.tencent.mm.modelemoji.a.bIE();
    if (Util.isNullOrNil(str2))
    {
      Log.e("MicroMsg.emoji.EmojiStoreWebViewLogic", "load emojiStore Template Path error");
      AppMethodBeat.o(294751);
      return false;
    }
    int i = aw(paramMap, "type");
    String str3 = au(paramMap, "pageName");
    String str1 = au(paramMap, "keyword");
    int j = aw(paramMap, "scene");
    paramMap = new Intent();
    paramMap.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
    paramMap.putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
    paramMap.putExtra("neverGetA8Key", true);
    paramMap.putExtra("rawUrl", "file://" + str2 + "/" + str3 + "?type=" + i + "&keyword=" + str1 + "&scene=" + j + "&lang=" + LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()) + "&clientType=1&version=" + com.tencent.mm.modelemoji.a.bIG());
    paramMap.putExtra("keyword", str1);
    paramMap.putExtra("type", i);
    paramMap.putExtra("sence", j);
    c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.emojistore.EmojiStoreSearchWebViewUI", paramMap);
    com.tencent.mm.plugin.report.service.h.OAn.b(13055, new Object[] { Integer.valueOf(1), "", "", Integer.valueOf(i), Integer.valueOf(com.tencent.mm.modelemoji.a.bIG()), Long.valueOf(0L) });
    paramMap = new sf();
    paramMap.hVi.type = i;
    paramMap.hVi.query = str1;
    paramMap.hVi.hVj = "";
    paramMap.publish();
    AppMethodBeat.o(294751);
    return true;
  }
  
  public final boolean bw(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77864);
    Log.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "getSearchEmotionData: %s", new Object[] { paramMap.toString() });
    String str1 = au(paramMap, "keyword");
    String str2 = au(paramMap, "nextPageBuffer");
    int i = aw(paramMap, "type");
    int j = aw(paramMap, "webview_instance_id");
    paramMap = au(paramMap, "searchID");
    if (Util.isNullOrNil(paramMap)) {}
    for (long l = 0L;; l = Long.valueOf(paramMap).longValue())
    {
      this.WAb.b(i, str1, str2, j, l);
      AppMethodBeat.o(77864);
      return false;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(77865);
    if ((paramp instanceof b))
    {
      com.tencent.mm.kernel.h.aZW().b(234, this);
      this.WAb.Uz = false;
      paramString = (b)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label131;
      }
      this.WAb.isSuccess = false;
      k.auP(paramString.WAh).a("{}", paramString.WAi, "", 0L);
    }
    for (;;)
    {
      paramp = paramString.isX().abyl;
      String str = w.b(paramString.isX().aaqV);
      long l = paramString.isX().aaqY;
      k.auP(paramString.WAh).a(paramp, paramString.WAi, str, l);
      AppMethodBeat.o(77865);
      return;
      label131:
      this.WAb.isSuccess = true;
    }
  }
  
  final class a
  {
    boolean Uz;
    private b WAe;
    private String WAf;
    private long WAg;
    boolean isSuccess;
    
    private a() {}
    
    private static String hP(String paramString, int paramInt)
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
      String str = hP(paramString1, paramInt1);
      if ((!Util.isNullOrNil(this.WAf)) && (this.WAf.equals(str)) && (System.currentTimeMillis() - this.WAg <= 8000L) && (Util.isNullOrNil(paramString2)))
      {
        if (this.isSuccess)
        {
          Log.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "hit the search cache %s", new Object[] { paramString1 });
          k.auP(paramInt2).a(this.WAe.isX().abyl, true, w.b(this.WAe.isX().aaqV), this.WAe.isX().aaqY);
          AppMethodBeat.o(77862);
          return;
        }
        if (this.Uz)
        {
          if (this.WAe != null) {
            this.WAe.WAh = paramInt2;
          }
          Log.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "wait the netscene running");
          AppMethodBeat.o(77862);
          return;
        }
        Log.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "netscene error try again");
      }
      Log.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "start New NetScene query:%s newMD5:%s webviewID:%d", new Object[] { paramString1, str, Integer.valueOf(paramInt2) });
      if (this.WAe != null) {
        com.tencent.mm.kernel.h.aZW().a(this.WAe);
      }
      this.WAf = str;
      this.WAg = System.currentTimeMillis();
      this.Uz = true;
      this.isSuccess = false;
      com.tencent.mm.kernel.h.aZW().a(234, a.this);
      this.WAe = new b(paramInt1, paramString1, paramString2.getBytes(), paramInt2, paramLong);
      com.tencent.mm.kernel.h.aZW().a(this.WAe, 0);
      AppMethodBeat.o(77862);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.a
 * JD-Core Version:    0.7.0.1
 */